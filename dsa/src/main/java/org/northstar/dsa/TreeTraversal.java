package org.northstar.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class TreeTraversal {

    public static void main(String[] args) {

        Node node3 = new VisitedNode(3, new ArrayList<>());
        Node node4 = new VisitedNode(4, new ArrayList<>());
        Node node2 = new VisitedNode(2, Arrays.asList(node3, node4));
        Node node1 = new VisitedNode(1, Arrays.asList(node2, node3));
        Node node = new VisitedNode(0, Arrays.asList(node1, node2));
        //bfs(node);
        //System.out.println();
        dfs(node);
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node qNode = queue.poll();
            if(!((VisitedNode) qNode).isVisited()) {
                System.out.print(qNode.value + " ");
                ((VisitedNode) qNode).setVisited(true);
                queue.addAll(qNode.children);
            }
        }
    }

    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            Node sNode = stack.peek();
                List<Node> collect = sNode.children.stream().filter(n -> !((VisitedNode) n).visited).collect(Collectors.toList());
            if(collect.isEmpty()) {
                sNode = stack.pop();
                if(!((VisitedNode)sNode).isVisited()) {
                    System.out.print(sNode.value + " ");
                    ((VisitedNode) sNode).setVisited(true);
                }
            } else {
                stack.addAll(collect);
            }
        }
    }
}

class Node {
    int value;
    List<Node> children;

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }
}

class VisitedNode extends Node{
    boolean visited= false;

    public VisitedNode(int value, List<Node> children) {
        super(value, children);
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean isVisited() {
        return visited;
    }
}