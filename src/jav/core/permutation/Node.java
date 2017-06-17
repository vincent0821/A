package jav.core.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/17.
 */
public class Node {
    Node parent;
    List<Node> children = new ArrayList<>();
    String name;

    public Node(String name){
        this.name = name;
    }

    public void addChild(Node child){
        children.add(child);
        child.setParent(this);
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    //子节点的全排列
    public List<List<Node>> getPlain(){
        if(children==null||children.size()==0){
            return null;
        }
        List<List<Node>> plain = new ArrayList<>();
        perm(children,0,children.size()-1,plain);
        return plain;
    }

    static void perm(List<Node> arr, int begin, int end,List<List<Node>> plain) {
        if (end == begin) {
            List<Node> aSeq = new ArrayList<>();
            for (Node n : arr) {
                aSeq.add(n);
            }
            plain.add(aSeq);
            return;
        } else {
            for (int j = begin; j <= end; j++) {
                swap(begin, j, arr);
                perm(arr, begin + 1, end,plain);
                swap(begin, j, arr);
            }
        }
    }

    static void swap(int i1, int i2, List<Node> arr) {
        Node temp = arr.get(i2);
        arr.set(i2, arr.get(i1));
        arr.set(i1, temp);
    }

    @Override
    public String toString() {
        return name;
    }
}
