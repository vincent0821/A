package jav.core.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/18.
 */
public abstract  class Action {
    List<RainbowNode> path = new ArrayList<>();

    abstract void doAct();
    public void addNode(RainbowNode rainbowNode) {
        path.add(rainbowNode);
    }
    public void removeNode(RainbowNode rainbowNode) {
        path.remove(rainbowNode);
    }
}
