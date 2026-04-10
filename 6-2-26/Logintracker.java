class Logintracker{
    public static void main(String[] args) {
        int[] loginattemts={1,4,2,5,3};

        for (int i=0; i<loginattemts.length; i++){
            if(loginattemts[i]>3){
                System.out.println("alert: user" +(i+1)+"has"+loginattemts[i]+"failed login attempts!");
            }
        }
    }
}