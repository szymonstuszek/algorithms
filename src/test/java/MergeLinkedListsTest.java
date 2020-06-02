import org.junit.Test;

public class MergeLinkedListsTest {


    @Test
    public void testMergeLinkedLists() {
        MergeLinkedLists.LinkedList list1P1 = new MergeLinkedLists.LinkedList(2);
        MergeLinkedLists.LinkedList list1P2 = new MergeLinkedLists.LinkedList(6);
        MergeLinkedLists.LinkedList list1P3 = new MergeLinkedLists.LinkedList(7);
        MergeLinkedLists.LinkedList list1P4 = new MergeLinkedLists.LinkedList(8);

        MergeLinkedLists.LinkedList list2P1 = new MergeLinkedLists.LinkedList(1);
        MergeLinkedLists.LinkedList list2P2 = new MergeLinkedLists.LinkedList(3);
        MergeLinkedLists.LinkedList list2P3 = new MergeLinkedLists.LinkedList(4);
        MergeLinkedLists.LinkedList list2P4 = new MergeLinkedLists.LinkedList(5);
        MergeLinkedLists.LinkedList list2P5 = new MergeLinkedLists.LinkedList(9);
        MergeLinkedLists.LinkedList list2P6 = new MergeLinkedLists.LinkedList(10);

        list1P1.next = list1P2;
        list1P2.next = list1P3;
        list1P3.next = list1P4;

        list2P1.next = list2P2;
        list2P2.next = list2P3;
        list2P3.next = list2P4;
        list2P4.next = list2P5;
        list2P5.next = list2P6;

        MergeLinkedLists.mergeLinkedLists(list1P1, list2P1);
    }

    @Test
    public void testMergeLinkedLists2() {
        MergeLinkedLists.LinkedList list1P1 = new MergeLinkedLists.LinkedList(2);
        MergeLinkedLists.LinkedList list1P2 = new MergeLinkedLists.LinkedList(4);

        MergeLinkedLists.LinkedList list2P1 = new MergeLinkedLists.LinkedList(1);
        MergeLinkedLists.LinkedList list2P2 = new MergeLinkedLists.LinkedList(3);

        list1P1.next = list1P2;

        list2P1.next = list2P2;

        MergeLinkedLists.mergeLinkedLists(list1P1, list2P1);
    }
}
