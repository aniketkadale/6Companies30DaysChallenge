import java.util.*;
public class Que10 {
    public static void main(String[] args) {
        String str[] = {"john", "johnny", "jackie", "johnny", "john" ,
            "jackie", "jamie", "jamie", "john", "johnny", "jamie",
            "johnny", "john"};

            int n = 13;

            System.out.println(Arrays.toString(winner(str, n)));
        
    }

    public static String[] winner(String arr[], int n) {
       
        HashMap<String, Integer> mp = new HashMap<>();
         for(int i = 0; i < n; i++) {
            String key = arr[i];
            if(mp.containsKey(key) == true) {
                int freq = mp.get(key);
                freq++;
                mp.put(key, freq);
            } else
            {
                mp.put(key, 1);
            }
        }
        
        int maxx = 0; 
        String answer = ""; 
        
      
        for (Map.Entry<String,Integer> entry : mp.entrySet())  { 
            String key  = entry.getKey(); 
            Integer val = entry.getValue();
          
            if (val > maxx) { 
                maxx = val; 
                answer = key; 
            } 
        
            else if (val == maxx && 
                answer.compareTo(key) > 0) 
                answer = key; 
        } 
        
        
        String result[] = {answer,maxx+""};
        
        
        return result;
    }
    
}
