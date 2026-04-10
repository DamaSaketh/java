class camel{
    private static Dog s1;
    private static Cat s2;
    void  makesound(){
     System.out.println("animal make sound");
    }
     public static void main(String[] args) {
   
    camel.s1=new Dog();
    camel.s2=new Cat();

    s1.makesound();
    s2.makesound();
   }
}
class Dog extends camel{
    @Override 
    void makesound(){
        System.out.println("DOG BARKS");
    }

}
class Cat extends camel{
    @Override 
    void makesound(){
        System.out.println("car meowS");
    }
}
