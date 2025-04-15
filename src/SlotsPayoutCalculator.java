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
            System.out.println("all symbols match! You win the jackpot of $" + (int)(bet*(sym^(col-1))*.1));
            return (int)(bet*(sym^(col-1))*.1);
        }
        
        int MaxNumOfSame = 1;
        for (int i=0; i<a.length-1; i++){
            int numOfSame = 1;
            for (int k=i+1; k<a.length; k++){
                if (a[i].equals(a[k])){
                    numOfSame++;
                }
                
            }
            if (numOfSame>MaxNumOfSame){
                MaxNumOfSame = numOfSame;
            }

        }
        if(MaxNumOfSame>2){
            System.out.println("  " +MaxNumOfSame + " symbols match! You win $" + (int)(bet*(Math.pow(sym,MaxNumOfSame))/NChooseK.C(col,MaxNumOfSame)));
            return (int)(bet*(Math.pow(sym,MaxNumOfSame))/NChooseK.C(col,MaxNumOfSame));
        }
        System.out.println("only " + MaxNumOfSame + " symbols match. You do not win");
        return 0;
    }
    public static int calculatePayout2D(){
        return 0;
    }
}
