class Bill{
    public static void main(String[] args) {
        double billamount=499.75;
        int storedamount;
        storedamount=(int)billamount;
        System.out.println("original bill amount(double)" + billamount);
        System.out.println("stored bill amount(int)" + storedamount);
        System.out.println("precision lost:" +(billamount-storedamount));

        double displayamount=storedamount;
        System.out.println("implicitcast amount:"+ displayamount);
    }
}