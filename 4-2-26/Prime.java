class Prime{
    public static void main(String[] args) {
        int num=7;
        boolean isprime=true;
        for (int i=2;i<= Math.sqrt(num); i++){
            if(num%i==0){
                isprime=false;
                break;
            }
        }
        if(isprime){
            System.out.println(num+"is a prime number");

        }else{
            System.out.println(num+"is not a prime number");
        }
    }
}