class APIresponse{
    public static void main(String[] args) {
        int[] responsetimes={1200, 1800, 2500, 900, 3200, 1500, 2100};
        int slowthreshold=2000;
        int slowcount=0;
        int totaltime=0;
        System.out.println("slow API response times(>2000ms):");

        for (int time:responsetimes){
            totaltime+=time;

            if (time>slowthreshold){
                System.out.println(time+"ms");
                slowcount++;

            }

        }
        double averagerespnsetime=(double)totaltime/responsetimes.length;

        System.out.println("\naverage response time:"+averagerespnsetime+"ms");
        System.out.println("number of low APIs:"+ slowcount);


        
        }
}