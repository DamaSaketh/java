class Reverse{
    public static void main(String[] args) {
        int num=5678, rev=0;

        while (num>0){
            rev=rev*10+num%10;
            num=num/10;
        }
        System.out.println("reversed number =" +rev);
    }
}