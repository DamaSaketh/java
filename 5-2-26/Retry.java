class Retry{
    public static void main(String[] args) {
        int retrycount=0;
        boolean issuccess=false;

        while (retrycount<3){
            System.out.println("API CALL attempt:" +(retrycount+1));
            issuccess=Math.random()>0.6;

            if(issuccess){
                System.out.println("API CALL successful");
                break;
            }
            retrycount++;

        }
        if (!issuccess){
            System.out.println("API call failed after 3 retries");
        }

    }
}