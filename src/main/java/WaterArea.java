

public class WaterArea {

    public static int waterArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int[] maxes = new int[heights.length];
        int leftMax = heights[0];
        int rightMax = heights[heights.length - 1];

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > leftMax) {
                leftMax = heights[i];
            }
            maxes[i] = leftMax;
        }

        maxes[heights.length - 1] = 0;

        for(int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                rightMax = heights[i];
            }
            maxes[i] = Math.min(maxes[i], rightMax);
        }

        int water = 0;

        for(int i = 0; i < heights.length; i++) {
            int current = maxes[i] - heights[i];

            if (current > 0) {
                water += current;
            }
        }

        return water;
    }
}
