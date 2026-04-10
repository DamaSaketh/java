class Batchjob{
    public static void main(String[] args) {
        int[] records={10,-5,20,0,30};
        for (int record:records){
            if (record<0){
                System.out.println("invalid record skipped");
                continue;
            }
            if(record==0){
                System.out.println("critical error detected.stopping job");
            }
            System.out.println("processing record:" +record);
        }
    }
}