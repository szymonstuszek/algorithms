import java.util.Arrays;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);


        for (int i = 1; i < rewards.length; i++) {
            int currentValue = scores[i];
            int valueOnLeft = scores[i - 1];

            if (currentValue > valueOnLeft) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        for (int i = rewards.length - 2; i >= 0; i--) {
            int currentValue = scores[i];
            int valueOnRight = scores[i + 1];

            if (currentValue > valueOnRight) {

                if (rewards[i] <= rewards[i + 1]) {
                    rewards[i] = rewards[i + 1] + 1;
                }
            }
        }

        return Arrays.stream(rewards).sum();
    }
}
