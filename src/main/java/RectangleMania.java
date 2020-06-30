import java.util.HashSet;
import java.util.Set;

public class RectangleMania {

    public static int rectangleMania(Point[] coords) {
        Set<String> coordsTable = getCoordsTable(coords);
        return getRectangleCount(coords, coordsTable);
    }

    private static int getRectangleCount(Point[] coords, Set<String> coordsTable) {
        int rectangleCount = 0;
        for (Point coord1 : coords) {
            for (Point coord2 : coords) {
                if (!isInUpperRight(coord1, coord2)) {
                    continue;
                }
                String upperCoordString = coordToString(new Point(coord1.x, coord2.y));
                String rightCoordString = coordToString(new Point(coord2.x, coord1.y));
                if (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString)) {
                    rectangleCount++;
                }
            }

        }
        return rectangleCount;
    }

    private static Set<String> getCoordsTable(Point[] coords) {
        Set<String> coordsTable = new HashSet<>();
        for (Point coord : coords) {
            String coordString = coordToString(coord);
            coordsTable.add(coordString);
        }
        return coordsTable;
    }

    private static boolean isInUpperRight(Point coord1, Point coord2) {
        return coord2.x > coord1.x && coord2.y > coord1.y;
    }

    private static String coordToString(Point coord) {
        return coord.x + "-" + coord.y;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
