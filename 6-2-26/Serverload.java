class Serverload{
    public static void main(String[] args) {
        int[] cpuload={65,72,80,55,90,60,75};
        int highest=cpuload[0];
        int lowest=cpuload[0];
        int sum=0;
        
        for (int load: cpuload){
            if (load>highest){
                highest=load;

            }
            if(load<lowest){
                lowest=load;

            }
            sum+=load;
        }
        double average=(double)sum/cpuload.length;
        System.out.println("highest CPU load:" +highest+"%");
        System.out.println("lowest CPU load:" +lowest+"%");
        System.out.println("average CPU load:" +average+"%");

    }
}