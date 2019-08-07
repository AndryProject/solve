package solve1;

public class FailSearchEngine {

    public int search(ISearchable searchable) {
        int[] searchList = searchable.getSearchList();
        int searchRightLimit = searchList.length - 1;
        int searchLeftLimit = 0;

        while (searchRightLimit - searchLeftLimit != 1){
            int checkNumber = (searchRightLimit + searchLeftLimit + 1) / 2;
            if (searchable.isFailed(searchList[checkNumber])){
                searchRightLimit = checkNumber;
            }
            else {
                searchLeftLimit = checkNumber;
            }
        }

        return searchList[searchRightLimit];
    }
}
