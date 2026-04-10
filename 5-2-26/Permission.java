class Permission{
    public static void main(String[] args) {
        int age =20;
        boolean hasvalidid =true;
        boolean hasactivesubscription=true;
        if(age>=18 && hasvalidid&&hasactivesubscription){
            System.out.println("acces granted");
        }else{
            System.out.println("access denied");
        }
    }
}