class Salaryincrement{
    public static void main(String[] args) {
        
        double[ ]salaries={25000,32000,40000,55000};
        System.out.println("updated salaries after 10%hike");
        for (int i=0;i<salaries.length;i++){
            salaries[i]=salaries[i]+(salaries[i]*0.10);
            System.out.println("employee" +(i+1)+":"+salaries[i]);

        }
    }
}