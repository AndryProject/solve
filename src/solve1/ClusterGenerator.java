package solve1;

import java.util.Random;

public class ClusterGenerator {

    public Cluster generate() {

        int totalNodesQuantity = 0;
        int minServerNumber = 10;
        int maxServerNumber = 100;
        int serversQuantity = generatRandomValue(minServerNumber, maxServerNumber);
        Server[] serverList = new Server[serversQuantity];

        for (int serverNumber = 0; serverNumber < serversQuantity; serverNumber++){
            int minNodNumber = 3;
            int maxNodNumber = 50;
            int nodesQuantity = generatRandomValue(minNodNumber, maxNodNumber);
            Node[] nodesList = new Node[nodesQuantity];

            for (int nodeNumber = 0; nodeNumber < nodesQuantity; nodeNumber++){
                nodesList [nodeNumber] = new Node(totalNodesQuantity + nodeNumber + 1);
            }

            totalNodesQuantity += nodesList.length;
            serverList[serverNumber] = new Server(serverNumber + 1, nodesList);
        }

        return new Cluster(serverList);
    }

    private int generatRandomValue (int minValue, int maxValue){
        Random random = new Random();
        int quantity = random.nextInt(maxValue - minValue) + minValue;

        return quantity;
    }
}
