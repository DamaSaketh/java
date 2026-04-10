class  armstrong{
    public static void main(String[] args) {
        int num=153,temp,sum=0;
        temp=num;
        while(temp>0){
          int digit=temp%10;
          sum=sum+(digit*digit*digit);
          temp=temp/10;


        }
        if (sum==num)
        System.err.println("armstrong number");
        else
        System.err.println("not a armstrong number");
    }
}