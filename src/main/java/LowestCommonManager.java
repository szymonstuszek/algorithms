import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        Entity entity = getEntity(topManager, reportOne, reportTwo);
        return entity.lowestCommonManager;
    }

    public static Entity getEntity(OrgChart currentEntity, OrgChart reportOne, OrgChart reportTwo) {
        int reportsOfInterestCount = 0;

        for (OrgChart report : currentEntity.directReports) {

            Entity entity = getEntity(report, reportOne, reportTwo);
            if (entity.lowestCommonManager != null) {
                return entity;
            }
            reportsOfInterestCount += entity.reportsOfInterestCount;
        }

        if (currentEntity == reportOne || currentEntity == reportTwo) {
            reportsOfInterestCount++;
        }

        OrgChart lowestCommonManager = reportsOfInterestCount == 2 ? currentEntity : null;
        Entity entity = new Entity(lowestCommonManager, reportsOfInterestCount);
        return entity;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class Entity {
        public OrgChart lowestCommonManager;
        public int reportsOfInterestCount;

        Entity(OrgChart lowestCommonManager, int reportsOfInterestCount) {
            this.lowestCommonManager = lowestCommonManager;
            this.reportsOfInterestCount = reportsOfInterestCount;
        }
    }

}
