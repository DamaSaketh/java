class  Servercheck{
    public static void main(String[] args) {
        int[] serverstatus={1,0,0,1,0,0,0,1,1,0};
        int totaldowntime=0;
        int longestdowntime=0;
        int currentdowntime=0;

        for (int status:serverstatus){
            if(status==0){
                totaldowntime++;
                currentdowntime++;
                if(currentdowntime>longestdowntime){
                    longestdowntime=currentdowntime;

                }
            }else{
                currentdowntime=0;

            }
        }
        System.out.println("total downtime hours:"+totaldowntime);
        System.out.println("longest continous downtime:"+longestdowntime+"hours");

    }
}