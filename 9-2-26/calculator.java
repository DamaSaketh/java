public  class calculator{
    int add(int a,int b){
        return a+b;
    }
    double add(double a,double b){
        return a+b;
    }
    int add(int a,int b, int c){
        return a+b+c;

    }
    public static void main(String[] args) {
        calculator calc=new calculator();
        System.out.println("add two ints :" +calc.add(10,20));
        System.out.println("add two doubles :" +calc.add(5.5,4.5));
        System.out.println("add three ints:" +calc.add(1,2,3));

    }
}