class animal{
    void  makesound(){
        System.out.println("Animal make a sound");

    }
     public static void main(String[] args) {
       
        animal a1=new Dog();
        animal a2=new Cat();

        a1.makesound();
        a2.makesound();
    }
}


class Dog extends animal{
    @Override
    void  makesound(){
        System.out.println("dog barks");
    }
}
class Cat extends animal{
    @Override
    void makesound(){
        System.out.println("cat meows");
    }
}
    




