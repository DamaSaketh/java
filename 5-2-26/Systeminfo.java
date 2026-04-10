class Systeminfo{
    public static void main(String[] args) {
        System.out.println("java version:" +System.getProperty("java.version"));
        System.out.println("JVM  vendor:" +System.getProperty("java.vendor"));
        System.out.println("OS name:" +System.getProperty("os.namr"));
        System.out.println("OS architecture:" +System.getProperty("os.arch"));
    }
}