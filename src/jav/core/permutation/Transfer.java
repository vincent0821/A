package jav.core.permutation;

import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/18.
 */
public class Transfer {
    Node target;
    Node orginRoot;
    int pathNum = 0;

    Node transferRainbowTreePathToNodeTree(List<RainbowNode> rainbowTreePath) throws Exception {
        RainbowNode rainbowRoot = rainbowTreePath.get(pathNum);
        if (rainbowRoot.getNodes().size() == 0) {
            return null;
        }
        if (rainbowRoot.getNodes().size() > 1) {
            throw new Exception("无根节点");
        }
        orginRoot = rainbowRoot.getNodes().get(0);
        target = (Node) orginRoot.clone();
        recuirse(orginRoot, target, rainbowTreePath);
        return orginRoot;
    }

    private void recuirse(Node originParentNode, Node newParentNode, List<RainbowNode> rainbowTreePath) throws CloneNotSupportedException {
        RainbowNode rainbowNode = rainbowTreePath.get(pathNum);
        for (Node orginNode : rainbowNode.getNodes()) {
            if (orginNode.getParent() == originParentNode) {
                Node newNode = (Node) orginNode.clone();
                newParentNode.addChild(newNode);
                pathNum++;
                recuirse(orginNode,newNode,rainbowTreePath);
                pathNum--;
            }
        }
    }

}
