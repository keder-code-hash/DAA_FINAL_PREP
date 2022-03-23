public class Solution {
    public int countCollisions(String directions) {
        int count=0,i=1;
        directions+=""+'E';
        while(i<directions.length()){
            if(i>=2 && (directions.charAt(i)=='L' || directions.charAt(i)=='R') && (directions.charAt(i-2)=='S')){
                i+=1;
                count+=1;
                System.out.println("hii");
            }
            else if((directions.charAt(i)=='R' && directions.charAt(i+1)=='L') || (directions.charAt(i)=='L' && directions.charAt(i+1)=='R')){
                count+=2;
                i+=2;
            }
            else if((directions.charAt(i)=='R' && directions.charAt(i+1)=='S') || (directions.charAt(i)=='L' && directions.charAt(i+1)=='S') || (directions.charAt(i)=='S' && directions.charAt(i+1)=='R') || (directions.charAt(i)=='S' && directions.charAt(i+1)=='L')){
                
                count++;
                i++;
            } 
            else{
                i+=2; 
            }
        }
        return count;
    }
} 