package solve1;

public class Server implements ISearchable{

    private int number;
    private Node[] nodes;

    public Server(int num, Node[] nod){
        number = num;
        nodes = nod;
    }

    public int getNumber (){
        return number;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public boolean getIsFailed() {
        return nodes[nodes.length - 1].isFailed;
    }

    @Override
    public boolean isFailed(int number) {
        for (Node node : nodes) {
            if (number == node.getNumber()) {
                return node.isFailed;
            }
        }
        return true;
    }

    @Override
    public int[] getSearchList() {
        int [] nodeList = new int[nodes.length];
        int i = 0;
        for (Node node : nodes) {
            nodeList [i] = node.getNumber();
            i++;
        }
        return nodeList;
    }
}

