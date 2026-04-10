class Datavalidation{
    public static void main(String[] args) {
        int[]sourcedata={10,20,30,40,50};
        int[]destinationdata={10,25,30,45,50};
        boolean isidentical=true;

        if(sourcedata.length !=destinationdata.length){
            System.out.println("data mismatch :array lengths are different");
            return;
        }
        System.out.println("mismatched indexes:");
        for(int i=0;i<sourcedata.length;i++){
            if(sourcedata[i]!=destinationdata[i]){
                System.out.println(
                " index"+i+
                "->source:"+sourcedata[i]+
                "destination:"+destinationdata[i]);
                isidentical=false;

            }

        }
        if(isidentical){
            System.out.println("data sync successfully:arrays are identical");
        }else{
            System.out.println("data sync failed:mismatche found");
        }
        }
    }
