import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs, deps);

        return getOrderedJobs(graph);
    }


    public static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> jobsWithNoPrerequisites = new ArrayList<>();

        for (int i = 0; i < graph.nodes.size(); i++) {
            JobNode currentNode = graph.nodes.get(i);
            if (currentNode.prerequisites == 0) {
                jobsWithNoPrerequisites.add(currentNode);
            }
        }


        while (jobsWithNoPrerequisites.size() > 0) {

            JobNode jobWithNoPrerequisites = jobsWithNoPrerequisites.get(jobsWithNoPrerequisites.size() - 1);
            jobsWithNoPrerequisites.remove(jobsWithNoPrerequisites.size() - 1);
            orderedJobs.add(0, jobWithNoPrerequisites.job);
            removeDependencies(jobWithNoPrerequisites, jobsWithNoPrerequisites);
        }

        boolean isCyclic = false;

        for (JobNode node : graph.nodes) {
            if (node.prerequisites > 0) {
                isCyclic = true;
                break;
            }
        }

        return isCyclic ? new ArrayList<>() : orderedJobs;
    }

    public static void removeDependencies(JobNode jobNode, List<JobNode> jobsWithNoPrerequisites) {

        while (jobNode.dependencies.size() > 0) {
            int lastIndex = jobNode.dependencies.size() - 1;
            JobNode dependentNode = jobNode.dependencies.get(lastIndex);
            dependentNode.prerequisites--;
            jobNode.dependencies.remove(lastIndex);

            if (dependentNode.prerequisites == 0) {
                jobsWithNoPrerequisites.add(dependentNode);
            }
        }

    }

    public static class JobGraph {
        private List<JobNode> nodes = new ArrayList<>();
        private Map<Integer, JobNode> jobGraph = new HashMap<>();

        public JobGraph(List<Integer> jobs, List<Integer[]> deps) {
            for (Integer job: jobs) {
                addNode(job);
            }

            for (Integer[] dep : deps) {
                addDependency(dep[0], dep[1]);
            }
        }

        public void addDependency(int prerequisiteNodeValue, int jobNodeValue) {
            JobNode prerequisiteNode = getNode(prerequisiteNodeValue);
            JobNode jobNode = getNode(jobNodeValue);
            jobNode.dependencies.add(prerequisiteNode);
            prerequisiteNode.prerequisites++;
        }

        public JobNode getNode(int job) {
            if (!jobGraph.containsKey(job)) {
                addNode(job);
            }
            return jobGraph.get(job);
        }

        public void addNode(int job) {
            JobNode jobNode = new JobNode(job);
            this.nodes.add(jobNode);
            this.jobGraph.put(job, jobNode);
        }
    }

    static class JobNode {
        private int job;
        private List<JobNode> dependencies = new ArrayList<>();
        private int prerequisites;

        public JobNode(int job) {
            this.job = job;
        }
    }
}
