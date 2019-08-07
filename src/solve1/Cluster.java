package solve1;

import java.util.Random;

public class Cluster implements ISearchable {

    private Server[] servers;

    public Cluster(Server[] serv){
        servers = serv;
    }

    public void sendMassage(){
        Random random = new Random();
        int failedServerIndex = random.nextInt(servers.length - 1);
        Server failedServer = servers[failedServerIndex];
        Node[] nodesList = failedServer.getNodes();
        
        int failedNodeIndex = random.nextInt(nodesList.length - 1);
        Node failedNode = nodesList[failedNodeIndex];
        for (Server server : servers) {
            for (Node node : server.getNodes()) {
                if (node.getNumber() >= failedNode.getNumber()){
                    node.isFailed = true;
                }
            }
        }
        System.out.println("Відправлено повідомлення що на сервері № " + failedServer.getNumber() + " в ноді № " + failedNode.getNumber() + " стався розрив.");
    }

    @Override
    public boolean isFailed(int number) {
        for (Server server : servers) {
            if (number == server.getNumber()) {
                return server.getIsFailed();
            }
        }
        return true;
    }

    @Override
    public int[] getSearchList() {
        int [] serverList = new int[servers.length];
        int i = 0;
        for (Server server : servers) {
            serverList [i] = server.getNumber();
            i++;
        }
        return serverList;
    }

    public Server getServer(int serverNumber) {
        for (Server server: servers) {
            if (server.getNumber() == serverNumber)
                return server;
        }
        return null;
    }
}
