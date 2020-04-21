import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStack {
    static class Stack {
        private final static String MIN = "min";
        private final static String MAX = "max";

        private List<Integer> stack = new ArrayList<>();
        private List<Map<String, Integer>> minMaxStack = new ArrayList<>();


        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            int lastIndex = stack.size() - 1;
            minMaxStack.remove(lastIndex);
            return stack.remove(lastIndex);
        }

        public void push(Integer number) {
            Map<String, Integer> newEntry = new HashMap<>();
            newEntry.put(MIN, number);
            newEntry.put(MAX, number);

            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastEntry = minMaxStack.get(minMaxStack.size() - 1);
                newEntry.replace(MIN, Math.min(number, lastEntry.get(MIN)));
                newEntry.replace(MAX, Math.max(number, lastEntry.get(MAX)));
            }

            minMaxStack.add(newEntry);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get(MIN);
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get(MAX);
        }
    }
}
