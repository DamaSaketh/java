
import java.util.HashSet;

class Duplicate{
    public static void main(String[] args) {
        int[] transactions={101,202,303,101,404,202,505,303};
        HashSet<Integer> seen =new HashSet<>();
        HashSet<Integer> duplicates =new HashSet<>();
        for(int id :transactions){
           if(!seen.add(id)){
               duplicates.add(id);
           }
        }
        System.out.println("duplicate transaction ids:");
        for (int id : duplicates){
        System.out.println(id);
    }

    }
}