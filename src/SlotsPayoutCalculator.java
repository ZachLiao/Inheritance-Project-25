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
            System.out.println("all symbols match! You win the jackpot of $" + (int)(bet*1/((1/sym)^(col-1))*.1));
            return (int)(bet*1/((1/sym)^(col-1))*.1);
        }
        int MaxNumOfSame = 1;
        for (int i=0; i<a.length-1; i++){
            int numOfSame = 1;
            for (int k=i+1; k<a.length-1; k++){
                if (a[i].equals(a[k+1])){
                    numOfSame++;
                    if(k == a.length-2 && a[k].equals(a[k+1])){
                        numOfSame++;
                    }
                }
                
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
