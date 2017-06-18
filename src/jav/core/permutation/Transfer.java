package jav.core.permutation;

import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/18.
 */
public class Transfer {
    Node target;
    Node orginRoot;
    int pathNum = 1;

    Node transferRainbowTreePathToNodeTree(List<RainbowNode> rainbowTreePath) throws Exception {
        RainbowNode rainbowRoot = rainbowTreePath.get(0);
        if (rainbowRoot.getNodes().size() == 0) {
            return null;
        }
        if (rainbowRoot.getNodes().size() > 1) {
            throw new Exception("无根节点");
        }
        orginRoot = rainbowRoot.getNodes().get(0);
        target = orginRoot.copy();
        recuirse(orginRoot, target, rainbowTreePath);
        return target;
    }

    private void recuirse(Node originParentNode, Node newParentNode, List<RainbowNode> rainbowTreePath) throws CloneNotSupportedException {
        if(pathNum==rainbowTreePath.size()){
            return;
        }
        RainbowNode rainbowNode = rainbowTreePath.get(pathNum);
        for (Node orginNode : rainbowNode.getNodes()) {
            if (orginNode.getParent() == originParentNode) {
                Node newNode = orginNode.copy();
                newParentNode.addChild(newNode);
                pathNum++;
                recuirse(orginNode,newNode,rainbowTreePath);
                pathNum--;
            }
        }
    }

}
