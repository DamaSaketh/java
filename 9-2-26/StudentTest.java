class Student{
    private  int id;
    private  String name;
    private int marks;


    
    public int getid(){
        return id;

    }
    public void setid(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    
    }
    public void setName(String name){
        this.name=name;
    }
    public int getMarks(){
        return marks;

    }

    public  void  setMarks(int marks){
        this.marks=marks;
    }
    
    public char calclategrade(){
        if(marks>= 90){
        return 'A';
        }else if(marks>=75){
            return 'B';
        
        }else{
            return 'C';
        }
    }
       
        public static void main(String[] args) {
            Student s=new Student();
            s.setMarks(85);
            s.setid(1);
            s.setName("rahul");
            
            System.out.println("Student"+s.getName());
            System.out.println("Marks "+s.getMarks());
            System.out.println("Grade "+s.calclategrade());

        }
    }

    
    
