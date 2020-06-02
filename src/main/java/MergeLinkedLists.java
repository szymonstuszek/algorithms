public class MergeLinkedLists {

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList pointerOne = headOne;
        LinkedList prev = null;
        LinkedList pointerTwo = headTwo;

        while(pointerOne != null && pointerTwo != null) {

            if (pointerOne.value < pointerTwo.value) {
                prev = pointerOne;
                pointerOne = pointerOne.next;
            } else {

                if (prev != null) {
                    prev.next = pointerTwo;
                }
                prev = pointerTwo;
                pointerTwo = pointerTwo.next;
                prev.next = pointerOne;
            }
        }

        if (pointerOne == null) {
            prev.next = pointerTwo;
        }
        return headOne.value < headTwo.value ? headOne : headTwo;
    }
}
