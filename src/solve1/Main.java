package solve1;

public class Main {

    public static void main(String[] args) {
        // generate input data
        ClusterGenerator generator = new ClusterGenerator();
        Cluster cluster = generator.generate();

        // break connection
        cluster.sendMassage();

        FailSearchEngine searchEngine = new FailSearchEngine();
        int serverNumber = searchEngine.search(cluster);
        Server failedServer = cluster.getServer(serverNumber);
        int nodeNumber = searchEngine.search(failedServer);
        System.out.println("На сервері № " + serverNumber + " після ноди № " + nodeNumber + " виник розрив звязку.");
    }

}
