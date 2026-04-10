     public class Login{
        static int totallogins=0;
        String SessionID;
        public Login(String id){
            this.SessionID=id;
            totallogins++;
            System.out.println("login successful!");
            System.out.println("user ID:"+this.SessionID);
            System.out.println("global login count:" +totallogins);
            System.out.println("----------------------");
        }
    public static void main(String[] args) {
        Login u1 = new Login("id_011");
        Login u2 = new Login("ID_002");
        Login u3 = new Login("ID_003");

        System.out.println("==SYSTEM AUDIT==");
        System.out.println("Active session 1 :"+u1.SessionID);
        System.out.println("Active session 2:"+u2.SessionID);
        System.out.println("Active session 3:"+u3.SessionID);
        System.out.println("totallogged in users:"+totallogins);

        
    }

 }
