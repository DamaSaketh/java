interface  Shape{
    double calculatearea();
     public static void main(String[] args) {
        Shape s1=new Circle(5);
        Shape s2=new Square(4);
        System.out.println("area of circle"+ s1.calculatearea());
         System.out.println("area of square"+ s2.calculatearea());
    }
}
    
class Circle implements Shape{
    
  
    double radius;

    Circle(double radius) {
        this.radius=radius;
    }
    public double calculaterea(){  
        return 3.14*radius*radius;
    }

    @Override
    public double calculatearea() {
        return 3.14*radius*radius;
    }

 }
 class Square implements Shape{
    double side;

    Square(double side) {
        this.side=side;
    }
    @Override
    public double calculatearea(){
       
        return side*side;
    } 
 }

