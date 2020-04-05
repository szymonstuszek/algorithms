import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(this);

            while (!queue.isEmpty()) {

                Node currentNode = queue.poll();
                array.add(currentNode.name);

                for (int i = 0; i < currentNode.children.size(); i++) {
                    queue.add(currentNode.children.get(i));
                }

            }

            return array;
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
