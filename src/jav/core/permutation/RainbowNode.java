package jav.core.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/17.
 */
public class RainbowNode {
    //一种排序
    private List<Node> nodes;
    //rainbowNode的子节点也是rainbowNode
    private List<RainbowNode> children = new ArrayList<>();

    //传入的nodes就是一种排序,根据这些子节点，构造新的rainbowNode
    public RainbowNode(List<Node> nodes){
        this.nodes = nodes;
        List<List<List<Node>>> allChildrenSequenceOfAllNodes = new ArrayList<>();
        for(Node node : nodes){
            //该节点的所有子节点
            List<List<Node>> allChildrenSequeneOfOneNode = node.getPlain();
            if(allChildrenSequeneOfOneNode==null){
                continue;
            }
            allChildrenSequenceOfAllNodes.add(allChildrenSequeneOfOneNode);
        }
        build(allChildrenSequenceOfAllNodes,0,new ArrayList<>());
    }

    private void build(List<List<List<Node>>> allChildrenSequenceOfAllNodes,int begin,List<Node> sequenceCollector) {
        //校验准备
        if(allChildrenSequenceOfAllNodes.size()==0){
            return;
        }
        List<List<Node>> allChildrenSequenceOfOneNode = allChildrenSequenceOfAllNodes.get(begin);
        //最后一次递归了
        if(begin==allChildrenSequenceOfAllNodes.size()-1){
            for(List<Node> oneSequenceOfOneNode : allChildrenSequenceOfOneNode){
                sequenceCollector.addAll(oneSequenceOfOneNode);
                List<Node> finalList = new ArrayList<>(sequenceCollector);
                RainbowNode rainbowNode = new RainbowNode(finalList);
                this.children.add(rainbowNode);
                sequenceCollector.removeAll(oneSequenceOfOneNode);
            }
        }
        //正常递归
        else{
            for(List<Node> oneSequenceOfOneNode : allChildrenSequenceOfOneNode){
                sequenceCollector.addAll(oneSequenceOfOneNode);
                build(allChildrenSequenceOfAllNodes,begin+1,sequenceCollector);
                sequenceCollector.removeAll(oneSequenceOfOneNode);
            }
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<RainbowNode> getChildren() {
        return children;
    }

    public void print(){
        traverse(this, new Action() {
            @Override
            public void doAct() {
                System.out.println(path);
            }
        });
    }

    public List<List<RainbowNode>> allNodePaths(){
        CollectAction collectAction = new CollectAction();
        traverse(this,collectAction);
        return collectAction.getAllNodePaths();
    }

    private void traverse(RainbowNode node, Action action) {
        action.addNode(node);
        if(node.children==null||node.children.size()==0){
            action.doAct();
        }
        for(RainbowNode child : node.children){
            traverse(child,action);
        }
        action.removeNode(node);
    }

    @Override
    public String toString() {
        return this.nodes.toString();
    }

    public static void main(String[] args) throws Exception {
        Node p1 = new Node("P1");
        Node c1 = new Node("C1");
        Node c2 = new Node("C2");
        Node c3 = new Node("C3");
        Node L1 =  new Node("L1");
        Node L2 =  new Node("L2");
        Node L3 =  new Node("L3");
        Node L4 =  new Node("L4");
        Node L5 = new Node("L5");
        Node L6 = new Node("L6");
        Node L7 = new Node("L7");
        p1.addChild(c1);
        p1.addChild(c2);
        p1.addChild(c3);
        c1.addChild(L1);
        c1.addChild(L2);
        c2.addChild(L3);
        c2.addChild(L4);
        c3.addChild(L5);
        c3.addChild(L6);
        c3.addChild(L7);
        
        List<Node> root = new ArrayList<>();
        root.add(p1);
        RainbowNode rainbowNode = new RainbowNode(root);

        List<Node> allPolicys = new ArrayList<>();
        for(List<RainbowNode> aPath : rainbowNode.allNodePaths()){
            new Transfer().transferRainbowTreePathToNodeTree(aPath).print();
            System.out.println();
        }
    }

}
