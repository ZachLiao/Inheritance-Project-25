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
            System.out.println("all symbols match! You win the jackpot");
            return (int)(bet*1/((1/sym)^(col-1))*.1);
        }
        int numOfSame = 1;
        int MaxNumOfSame = 1;
        for (int i=0; i<a.length; i++){
            for (int k=i; k<a.length; k++){
                if (a[k].equals(a[k+1])){
                    numOfSame++;
                }
                else k = a.length;
            }
            if (numOfSame>MaxNumOfSame){
                MaxNumOfSame = numOfSame;
            }

        }
        if(MaxNumOfSame>2){
            System.out.println(MaxNumOfSame + " symbols match! You win $" + (int)(bet*1/((1/sym)^(MaxNumOfSame))*.1) );
            return (int)(bet*1/((1/sym)^(MaxNumOfSame))*.1);
        }
        System.out.println("only " + MaxNumOfSame + " symbols match. You do not win");
        return 0;
    }
}
