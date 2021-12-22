package pascals_triangle;
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result =new ArrayList<List<Integer>>(); 
        result.add(new ArrayList<>(1));
        for(int i=1;i<numRows;i++){
            ArrayList<Integer> newList=new ArrayList<Integer>();
            for(int j=1;j<i;j++){
                newList.add(result.get(i).get(j-1)+result.get(i).get(j));
            }
            result.add(newList);
        }
        return result;
    }
}
// 1
// 1 1
// 1 2 1
// 1 3 3 1