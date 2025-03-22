public class SlotsPayoutCalculator {
    
    public static int calculatePayout(String[] a, int col, int sym, int bet){
        boolean allMatch = true;
        for (int i=0; i<a.length-1; i++){
            if (!a[i].equals(a[i+1])){
                allMatch = false;
            }
        }
        if(allMatch){
            //probability of all match is (1/sym)^(col-1)
            return (int)(bet*1/((1/sym)^(col-1))*.9);
        }
        return 3;
    }
}
