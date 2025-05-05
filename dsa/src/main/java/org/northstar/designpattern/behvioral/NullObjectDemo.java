package org.northstar.designpattern.behvioral;

import java.lang.reflect.Proxy;

public class NullObjectDemo {
    public static void main(String[] args) {
        Log log = new ConsoleLog();
        BankAccount ba = new BankAccount(100, log);
        ba.deposit(200);

        //Lets say I don't want to log
        // 1. Option to have null check before calling log.info
        // 2. Create dummy log class which doesn't do anything
        // 3. Create a proxy invoker, here we go with noOp
        Log noOpLog = noOp(Log.class);
        BankAccount bankAccount = new BankAccount(200, noOpLog);
        bankAccount.deposit(200);
    }

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                ((proxy, method, args) ->
                {
                    if(method.getReturnType().equals(Void.TYPE))
                        return null;
                    else
                        return method.getReturnType().getConstructor().newInstance();
                })
        );
    }
}

class BankAccount {
    int balance;
    private Log log;

    public BankAccount(int amount, Log log) {
        this.balance = amount;
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;
        log.info("Deposited amount : " + amount + " and balance : " + balance);
    }
}

interface Log {
    public void info(String msg);
    public void warn(String msg);
}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }
    @Override
    public void warn(String msg) {
        System.out.println("WARNING :" + msg);
    }
}