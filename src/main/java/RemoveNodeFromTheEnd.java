

public class RemoveNodeFromTheEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList nodeToRemove = head;
        LinkedList movingNode = head;
        int steps = 0;

        while(steps < k && movingNode.next != null) {
            movingNode = movingNode.next;
            k++;
        }

        while (movingNode.next != null) {
            movingNode = movingNode.next;
            nodeToRemove = nodeToRemove.next;
        }

        nodeToRemove.next = nodeToRemove.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
