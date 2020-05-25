import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiscStacking {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        if (disks.size() == 1) {
            return disks;
        }

        disks.sort(Comparator.comparing(disk -> disk[2]));
        int highestDiskIndex = 0;

        int[] heights = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }

        int[] sequence = new int[disks.size()];
        Arrays.fill(sequence, Integer.MIN_VALUE);

        for (int i = 1; i < disks.size(); i++) {
            for (int j = 0; j < i; j++) {

                if (canPutDisksOnTopOfEachOther(disks.get(j), disks.get(i))) {
                    if (heights[j] + disks.get(i)[2] >= heights[i]) {
                        heights[i] = heights[j] + disks.get(i)[2];
                        sequence[i] = j;
                    }


                }
            }
            if (heights[i] >= heights[highestDiskIndex]) {
                highestDiskIndex = i;
            }
        }

        return getDisksFromSequence(disks, sequence, highestDiskIndex);
    }

    public static List<Integer[]> getDisksFromSequence(List<Integer[]> disks, int[] sequence, int currentIndex) {
        List<Integer[]> result = new ArrayList<>();

        while (currentIndex != Integer.MIN_VALUE) {
            Integer[] diskToAdd = disks.get(currentIndex);
            result.add(0, diskToAdd);
            currentIndex = sequence[currentIndex];
        }

        return result;
    }

    public static boolean canPutDisksOnTopOfEachOther(Integer[] topDisk1, Integer[] bottomDisk2) {
        return topDisk1[0] < bottomDisk2[0] && topDisk1[1] < bottomDisk2[1] && topDisk1[2] < bottomDisk2[2];
    }
}
