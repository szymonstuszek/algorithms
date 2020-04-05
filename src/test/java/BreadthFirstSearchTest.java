import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BreadthFirstSearchTest {


    @Test
    public void testBreadthFirstSearch() {
        BreadthFirstSearch.Node test5 = new BreadthFirstSearch.Node("A");
        test5.addChild("B").addChild("C").addChild("D").addChild("L").addChild("M");
        test5.children.get(0).addChild("E").addChild("F").addChild("O");
        test5.children.get(1).addChild("P");
        test5.children.get(2).addChild("G").addChild("H");
        test5.children.get(0).children.get(0).addChild("Q").addChild("R");
        test5.children.get(0).children.get(1).addChild("I").addChild("J");
        test5.children.get(2).children.get(0).addChild("K");
        test5.children.get(4).addChild("S").addChild("T").addChild("U").addChild("V");
        test5.children.get(4).children.get(0).addChild("W").addChild("X");
        test5.children.get(4).children.get(0).children.get(1).addChild("Y").addChild("Z");

        List<String> list = test5.breadthFirstSearch(new ArrayList<>());
    }

}
