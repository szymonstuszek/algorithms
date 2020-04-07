import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class YoungestCommonAncestorTest {
    static Map<Character, YoungestCommonAncestor.AncestralTree> ancestralTrees;
    static String alphabet;

    static {
        ancestralTrees = new HashMap<Character, YoungestCommonAncestor.AncestralTree>();
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            ancestralTrees.put(a, new YoungestCommonAncestor.AncestralTree(a));
        }

        ancestralTrees
                .get('A')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {
                                ancestralTrees.get('B'),
                                ancestralTrees.get('C'),
                                ancestralTrees.get('D'),
                                ancestralTrees.get('E'),
                                ancestralTrees.get('F')
                        });
        ancestralTrees
                .get('B')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {
                                ancestralTrees.get('G'), ancestralTrees.get('H'), ancestralTrees.get('I')
                        });
        ancestralTrees.get('C').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('J')});
        ancestralTrees
                .get('D')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('K'), ancestralTrees.get('L')});
        ancestralTrees
                .get('F')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('M'), ancestralTrees.get('N')});
        ancestralTrees
                .get('H')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {
                                ancestralTrees.get('O'),
                                ancestralTrees.get('P'),
                                ancestralTrees.get('Q'),
                                ancestralTrees.get('R')
                        });
        ancestralTrees.get('K').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('S')});
        ancestralTrees
                .get('P')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('T'), ancestralTrees.get('U')});
        ancestralTrees.get('R').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('V')});
        ancestralTrees
                .get('V')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {
                                ancestralTrees.get('W'), ancestralTrees.get('X'), ancestralTrees.get('Y')
                        });
        ancestralTrees.get('X').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {ancestralTrees.get('Z')});
    }

    @Test
    public void TestCase1() {
        YoungestCommonAncestor.AncestralTree yca =
                YoungestCommonAncestor.getYoungestCommonAncestor(
                        ancestralTrees.get('A'), ancestralTrees.get('A'), ancestralTrees.get('B'));
        Assert.assertTrue(yca == ancestralTrees.get('A'));
    }

    @Test
    public void TestCase2() {
        YoungestCommonAncestor.AncestralTree yca =
                YoungestCommonAncestor.getYoungestCommonAncestor(
                        ancestralTrees.get('A'), ancestralTrees.get('B'), ancestralTrees.get('F'));
        Assert.assertTrue(yca == ancestralTrees.get('A'));
    }
}
