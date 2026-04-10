class Factorials{
    public static void main(String[] args) {
        int num=5;
        long fact =1;
        for(int i=1;i<=num; i++){
            fact *= i;
            }
        System.err.println("factorial=" + fact);
    }
}