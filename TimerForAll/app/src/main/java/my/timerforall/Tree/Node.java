package my.timerforall.Tree;

import java.util.ArrayList;

import my.timerforall.Timer.TimerFunctional;

public class Node<T extends TimerFunctional> {

    private Node<T> parent;
    public T object;
    private int index;
    private ArrayList<Node<T>> children;

    public Node(T object, Node parent) {
        this.object = object;
        this.parent=parent;
        children = new ArrayList<>();
    }

    public Node(T object) {
        this.object = object;
        children = new ArrayList<>();
    }
    public void addChild(Node child) {
        child.setParent(this);
        children.add(child);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node<T> getChild(int index) {
        return children.get(index);
    }
    public T getChildObj(int index) {
        return children.get(index).object;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        object.setIndex(index);
    }

    public ArrayList<Node<T>> getChildrenNode() {
        return children;
    }
    public ArrayList<T> getChildren() {
        ArrayList<T> kids = new ArrayList<>();
        for (Node<T> o:children) {
            kids.add(o.object);
        }
        return kids;
    }
/*    public T getChildrenObj() {
        for ()
        return children;
    }*/


    public Node getParent() {
        return parent;
    }

    public int sizeCildren() {
        return children.size();
    }
}