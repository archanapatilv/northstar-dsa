package org.northstar.designpattern.behvioral.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EventBased {
    public static void main(String[] args)
    {
        IPerson person = new IPerson();
        Event<PropertyChangedEventArgs>.Subscription sub =
                person.propertyChanged.addHandler(x -> {
                    System.out.println("Person's "
                            + x.propertyName + " has changed");
                });
        person.setAge(17);
        person.setAge(18);
        sub.close();
        person.setAge(19);
    }
}

class Event<TArgs>
{
    private int count = 0;
    private Map<Integer, Consumer<TArgs>>
            handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler)
    {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args)
    {
        for (Consumer<TArgs> handler : handlers.values())
            handler.accept(args);
    }

    public class Subscription implements AutoCloseable
    {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id)
        {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() /*throws Exception*/
        {
            event.handlers.remove(id);
        }
    }
}


class IPerson
{
    public Event<PropertyChangedEventArgs>
            propertyChanged = new Event<>();

    private int age;

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        if (this.age == age) return;

        boolean oldCanVote = getCanVote();

        this.age = age;
        propertyChanged.fire(new PropertyChangedEventArgs(
                this, "age", age
        ));

        if (oldCanVote != getCanVote())
        {
            propertyChanged.fire(new PropertyChangedEventArgs(
                    this, "canVote", age
            ));
        }
    }

    public boolean getCanVote()
    {
        return age >= 18;
    }
}
