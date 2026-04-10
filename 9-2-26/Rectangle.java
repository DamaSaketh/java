class Rectangle{ 
    private double length;
    private double width;

    public Rectangle(double length,double width) {
        this.length=length;
        this.width=width;
    }
    public double calculteArea(){
        return length*width;
    }
  
    public static void main(String[] args) {
        Rectangle r=new Rectangle(10, 5);
        System.out.println("area  of rectangle:"+ r.calculteArea());
    }
}

