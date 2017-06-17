package jav.core.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator
 * 2017/6/17.
 */
//新的节点
public class RainbowNode {
    //持有的节点
    public Node[] nodes;

    //新节点的子节点
    public RainbowNode[] rainbows;

    public int k;

    public int n;

    public int t;

    public RainbowNode(Node[] nodes) {
        this.nodes = nodes;
        this.buildRainbows();
    }

    //构建子节点
    private void buildRainbows() {
        if (this.nodes == null || this.nodes.length == 0) return;
        n = 0;
        k = 1;
        List<Node[][]> allCombination = new ArrayList<Node[][]>();
        for (Node node : nodes) {
            if (node.children == null || node.children.length == 0) {
                return;
            }
            System.out.println("----" + node.children.length + "------");
            n = n + node.n;
            k = k * node.plain.length;
            allCombination.add(node.plain);
        }
        rainbows = new RainbowNode[k];
        buildRainbows(allCombination);
    }

    public void buildRainbows(List<Node[][]> inputList) {
        List<Integer> combination = new ArrayList<Integer>();
        int n = inputList.size();
        for (int i = 0; i < n; i++) {
            combination.add(0);
        }
        int i = 0;
        boolean isContinue = false;
        do {
            {
                Node[] rainbow = new Node[this.n];
                int index = 0;
                for (int j = 0; j < n; j++) {
                    Node[] nodes = inputList.get(j)[combination.get(j)];
                    for (Node node : nodes) {
                        rainbow[index] = node;
                        index++;
                    }
                }
                rainbows[t] = new RainbowNode(rainbow);
                t++;
            }

            i++;
            combination.set(n - 1, i);
            for (int j = n - 1; j >= 0; j--) {
                if (combination.get(j) >= inputList.get(j).length) {
                    combination.set(j, 0);
                    i = 0;
                    if (j - 1 >= 0) {
                        combination.set(j - 1, combination.get(j - 1) + 1);
                    }
                }
            }
            isContinue = false;
            for (Integer integer : combination) {
                if (integer != 0) {
                    isContinue = true;
                }
            }
        } while (isContinue);
    }

    public void print(Node[] path,int k) {
        if (nodes != null && nodes.length != 0) {
            for (Node node : nodes) {
                path[k++] = node;
            }
        }
        if (rainbows != null && rainbows.length != 0) {
            for (RainbowNode rainbow : rainbows) {
                rainbow.print(path,k);
            }
        }else {
            System.out.println(Arrays.toString(path));
        }
    }

    public static void main(String[] args) {
        Node[] c1Node = new Node[2];
        c1Node[0] = new Node("L1");
        c1Node[1] = new Node("L2");
//        c1Node[2] = new RealNode("L3");

        Node[] c2Node = new Node[2];
        c2Node[0] = new Node("L4");
        c2Node[1] = new Node("L5");
//        c2Node[2] = new RealNode("L6");

        Node[] cnode = new Node[2];
        cnode[0] = new Node("C1",c1Node);
//        cnode[0].print();

        cnode[1] = new Node("C2",c2Node);
//        cnode[1].print();

        Node[] pnode = new Node[1];
        pnode[0] = new Node("P1", cnode);
//        pnode[0].print();

        RainbowNode root = new RainbowNode(pnode);

        root.print(new Node[7],0);
//        test1();
    }

    private static void test1() {
        Node[] c1Node = new Node[3];
        c1Node[0] = new Node(4);
        c1Node[1] = new Node(5);
        c1Node[2] = new Node(6);

        Node[] c2Node = new Node[3];
        c2Node[0] = new Node(7);
        c2Node[1] = new Node(8);
        c2Node[2] = new Node(9);

        Node[] cnode = new Node[2];
        cnode[0] = new Node(2,c1Node);
        cnode[0].print();

        cnode[1] = new Node(3,c2Node);
        cnode[1].print();

        Node[] pnode = new Node[1];
        pnode[0] = new Node(1, cnode);
        pnode[0].print();

        RainbowNode root = new RainbowNode(pnode);

        root.print(new Node[9],0);
    }
}
