import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {

    public static String underscorifySubstring(String str, String substring) {
        List<Integer[]> locations = getSubstringLocations(str, substring);
        List<Integer[]> mergedLocations = collapse(locations);

        return underscorify(str, mergedLocations);
    }

    public static List<Integer[]> getSubstringLocations(String str, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int startIdx = 0;

        while (startIdx < str.length()) {
            int location = str.indexOf(substring, startIdx);

            if (location != -1) {
                locations.add(new Integer[]{location, location + substring.length()});
                startIdx = startIdx + 1;
            } else {
                break;
            }
        }
        return locations;
    }


    public static List<Integer[]> collapse(List<Integer[]> locations) {
        if(locations.size() == 0) {
            return locations;
        }

        List<Integer[]> finalLocations = new ArrayList<>();
        finalLocations.add(locations.get(0));
        Integer[] previous = locations.get(0);

        for (int i = 1; i < locations.size(); i++) {
            Integer[] current = locations.get(i);
            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                finalLocations.add(current);
                previous = current;
            }
        }

        return finalLocations;
    }

    public static String underscorify(String str, List<Integer[]> locations) {
        int stringIdx = 0;
        int locationsIdx = 0;
        boolean betweenUnderscores = false;
        List<String> result = new ArrayList<>();
        int i = 0;

        while (stringIdx < str.length() && locationsIdx < locations.size()) {

            if (stringIdx == locations.get(locationsIdx)[i]) {
                result.add("_");
                betweenUnderscores = !betweenUnderscores;
                if (!betweenUnderscores) {
                    locationsIdx++;
                }
                i = i == 1 ? 0 : 1;
            }
            result.add(String.valueOf(str.charAt(stringIdx)));
            stringIdx += 1;
        }

        if (locationsIdx < locations.size()) {
            result.add("_");
        } else if (stringIdx < str.length()) {
            result.add(str.substring(stringIdx));
        }

        return String.join("", result);
    }
}
