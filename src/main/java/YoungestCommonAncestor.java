

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int descendantOneDepth = calculateDepth(descendantOne, topAncestor);
        int descendantTwoDepth = calculateDepth(descendantTwo, topAncestor);
        int diff = 0;

        if (descendantOneDepth - descendantTwoDepth > 0) {
            diff = descendantOneDepth - descendantTwoDepth;
            return moveDescendantUp(descendantOne, descendantTwo, diff);
        } else {
            diff = descendantTwoDepth - descendantOneDepth;
            return moveDescendantUp(descendantTwo, descendantOne, diff);
        }

    }

    private static AncestralTree moveDescendantUp(AncestralTree descendantToMove, AncestralTree descendant, int depth) {
        for (int i = depth; i > 0; i--) {
            descendantToMove = descendantToMove.ancestor;
        }

        while (descendantToMove != descendant) {
            descendantToMove = descendantToMove.ancestor;
            descendant = descendant.ancestor;
        }

        return descendantToMove;
    }

    private static int calculateDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            descendant = descendant.ancestor;
            depth++;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
