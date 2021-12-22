package triangle_minimum_sum;
import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { 

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=triangle.get(i).size()-1;j>=0;j--){ 
                int val=Math.min(triangle.get(i+1).get(j+1),triangle.get(i+1).get(j));
                // triangle.get(i).get(j)=val;
            }
        }
        return triangle.get(0).get(0);
    }
}
