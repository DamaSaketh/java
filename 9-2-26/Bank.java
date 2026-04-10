class Bank{
    private  double  balance;

     public void  deposit(double  amount){
        if (amount>0){
            balance+=amount;
            System.out.println(" Deposited:"+amount);
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount<= balance){
            balance-=amount;
            System.out.println(" withdrawn:"+amount);

        }else{
            System.out.println("insufficient balance");
        }
    }
     public void showbalance() {
        System.out.println("current balance "+balance);

    }
     public static void main(String[] args) {
          Bank acc=new Bank();
          acc.deposit(1000);
          acc.withdraw(400);
          acc.withdraw(700);
         
        }
    }
