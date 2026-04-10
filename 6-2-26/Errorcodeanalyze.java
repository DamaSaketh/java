
import java.util.HashMap;
import java.util.Map;

class Errorcodeanalyze{

    public static void main(String[] args) {

        int[] errorCodes={404,500,404,403500,404,401,500,500};
        HashMap<Integer, Integer>countMap=new HashMap<>();
        for (int code:errorCodes){
            countMap.put(code,countMap.getOrDefault(code,0)+1);
        }
        System.out.println("erorr code occurance:");
        for (Map.Entry<Integer, Integer>entry :countMap.entrySet()){
            System.out.println("error code"+ entry.getKey()+"->"+entry.getValue()+"times");
            

        }

        int maxCount = 0;
        int mostFrequentCode = -1;

        for (Map.Entry<Integer, Integer>entry :countMap.entrySet()){
            if (entry.getValue() > maxCount) {
               maxCount=entry.getValue();
               mostFrequentCode = entry.getKey();   
            }           
        }
        System.out.println("\nMost frequent error code:"  + mostFrequentCode + "(" + maxCount +" times)" );
    }
  }
    
    
     
 
