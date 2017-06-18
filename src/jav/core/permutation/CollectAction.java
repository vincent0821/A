package jav.core.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongkuaikuai on 2017/6/18.
 */
public class CollectAction extends Action {
    private List<List<RainbowNode>> allNodePaths = new ArrayList<>();
    @Override
    void doAct() {
        List<RainbowNode> aFinalPath = new ArrayList<>();
        aFinalPath.addAll(this.path);
        allNodePaths.add(aFinalPath);
    }

    public List<List<RainbowNode>> getAllNodePaths() {
        return allNodePaths;
    }
}


