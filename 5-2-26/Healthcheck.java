class Healthcheck{
    public static void main(String[] args) {
        int totalCPU=100;
        int usedCPU=65;
        int totalmemory=16000;
        int usedmemory=12000;
        int cpuusage=(usedCPU*100)/totalCPU;
        int memoryusage =(usedmemory*100)/totalmemory;
        System.out.println("CPU usage:" +cpuusage+"%");
        System.out.println("memory usage:"+ memoryusage+"%");
        String status =(cpuusage<75 && memoryusage<75)?"HEALTHY":"CRITICAL";
        System.out.println("System Status:"+ status);
    }
}