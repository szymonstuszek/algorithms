

public class ShiftLinkedList {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        LinkedList tail = head;
        int linkedListLength = 1;
        while (tail.next != null) {
            tail = tail.next;
            linkedListLength++;
        }

        int offset = Math.abs(k) % linkedListLength;
        if (offset == 0) {
            return head;
        }

        int newHeadPosition = k > 0 ? linkedListLength - offset : offset;

        LinkedList newTail = head;
        for (int i = 1; i < newHeadPosition; i++) {
            newTail = newTail.next;
        }

        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
