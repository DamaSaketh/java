class Studentmarks{
    public static void main(String[] args) {
        int[] marks={85, 45, -10, 67, 102, 35, 90, 28};
        int passcount=0;
        int failcount=0;
        int invalidcount=0;
        
        for (int mark:marks){
            if (mark<0||mark>100){
                System.out.println("invalid mrk detected:" +mark);
                invalidcount++;

            }
            else if (mark>=40){
                passcount++;
            }
            else {
                failcount++;
            }
         } 
         System.out.println("\nsummary:");
         System.out.println("pass students :"+passcount);
         System.out.println("fail students :"+failcount);
         System.out.println("invalid entries :"+invalidcount);
     }

}