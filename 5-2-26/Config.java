class Config{
    public static void main(String[] args) {
        byte var1=100;
        double var2=85.5;
        boolean var4=true;
        String var5="production";
        System.out.println("environment:" + var5);
        System.out.println("max users :"+ var1);
        System.out.println("featureenabled:" +var4);
        if ((double)var1>var2){
            System.out.println("warning: system limits("+ var1 +")exceed the allowed threshold ("+var2+")!");

        }

        
    }
}