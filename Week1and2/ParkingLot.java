class Spot{
    String plate;
    boolean used;
    long time;
}

public class ParkingLot{
    Spot[] table=new Spot[500];

    int hash(String s){
        return Math.abs(s.hashCode())%table.length;
    }

    int park(String plate){
        int h=hash(plate);
        int i=0;
        while(true){
            int idx=(h+i)%table.length;
            if(table[idx]==null || !table[idx].used){
                table[idx]=new Spot();
                table[idx].plate=plate;
                table[idx].used=true;
                table[idx].time=System.currentTimeMillis();
                return idx;
            }
            i++;
        }
    }

    long exit(String plate){
        for(int i=0;i<table.length;i++){
            if(table[i]!=null && plate.equals(table[i].plate)){
                long t=System.currentTimeMillis()-table[i].time;
                table[i].used=false;
                return t;
            }
        }
        return -1;
    }
}