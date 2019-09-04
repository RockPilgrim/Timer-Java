package my.rockpilgrim.timerforall.Tree;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.Timer.TimerFunctional;

public class TreeHandler<T extends TimerFunctional> {

    public final Node<T> root;
    private int lastIndex;
    private ArrayList<Node<T>> nodeList;

    public TreeHandler() {
        root = new Node<T>(null, null);
        nodeList = new ArrayList<>();
    }

    public Node getParentOf(int index) {
        return nodeList.get(index).getParent();
    }

    public void addToRoot(T object) {
        Node child = new Node(object, root);
        root.addChild(child);
        nodeList.add(child);
        child.setIndex(nodeList.indexOf(child));
    }

    public void addTimer(int fatherIndex, T son) {
        Node child = new Node<T>(son);
        nodeList.get(fatherIndex).addChild(child);
        nodeList.add(child);
        child.setIndex(nodeList.indexOf(child));
    }

    public void addChild(Node<T> father, Node<T> son) {
        father.addChild(son);
        nodeList.add(son);
        son.setIndex(nodeList.indexOf(son));
    }

    public int getFindIndexOf(T object) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).object.equals(object)) {
//                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public Node getNode(int index) {
        return nodeList.get(index);
    }

    public T getTimer(int index) {
        return nodeList.get(index).object;
    }

    public int size() {
        return nodeList.size();
    }
}
