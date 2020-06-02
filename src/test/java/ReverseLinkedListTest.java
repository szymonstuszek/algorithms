import org.junit.Test;

public class ReverseLinkedListTest {


    @Test
    public void testReverseLinkedList() {
        ReverseLinkedList.LinkedList p1 = new ReverseLinkedList.LinkedList(0);
        ReverseLinkedList.LinkedList p2 = new ReverseLinkedList.LinkedList(1);
        ReverseLinkedList.LinkedList p3 = new ReverseLinkedList.LinkedList(2);
        ReverseLinkedList.LinkedList p4 = new ReverseLinkedList.LinkedList(3);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;

        ReverseLinkedList.reverseLinkedList(p1);
    }
}
