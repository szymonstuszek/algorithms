import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int sequenceIdx = 0;

        for (int i = 0; i < array.size(); i++) {
            int currentNumberFromSequence = sequence.get(sequenceIdx);

            if (currentNumberFromSequence == array.get(i)) {
                sequenceIdx++;
            }

            if (sequenceIdx == sequence.size()) {
                break;
            }
        }


        return sequenceIdx == sequence.size();
    }
}
