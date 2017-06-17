package jav.core.tree;

/**
 * Created by Administrator
 * 2017/6/16.
 */
public class Node {
    //id
    public int id;
    public String name;
    //子节点
    public Node[] children;
    //全排列的个数
    public int k;
    //子节点的个数
    public int n;
    //子节点排列得到的二维数组
    public Node[][] plain;

    public Node(int id) {
        this.id = id;
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(String name,Node[] children) {
        this.name = name;
        this.children = children;
        if (children != null && children.length != 0) {
            this.n = children.length;
            plain = new Node[A(n)][n];
            all(0,n);
        }
    }

    public Node(int id, Node[] children) {
        this.id = id;
        this.children = children;
        if (children != null && children.length != 0) {
            this.n = children.length;
            plain = new Node[A(n)][n];
            all(0,n);
        }
    }

    private static int A(int n) {
        int r = n;
        for (int i = 1; i < n; i++) {
            r = r * (n - i);
        }
        return r;
    }
    //全排列子节点
    private void all(int from, int to) {
        if (to <= 1) {
            return;
        }
        if (from == to) {
            for (int i = 0; i < to; i++) {
                plain[k][i] = children[i];
            }
            k = k + 1;
        } else {
            for (int j = from; j < to; j++) {
                swap(j, from);
                all(from + 1, to);
                swap(j, from);
            }
        }
    }

    private void swap(int j, int k) {
        Node temp = children[j];
        children[j] = children[k];
        children[k] = temp;
    }

    public void print() {
        System.out.println("=======================");
        if (children == null || children.length == 0) {
            System.out.println(this.id);
        } else {
            for (int i=0;i<k;i++){
                for(int j=0;j<n;j++){
                    System.out.printf("%2s",plain[i][j].id);
                }
                System.out.println();
            }
        }
    }

    @Override
    public String toString() {
        return name+"";
    }

}
