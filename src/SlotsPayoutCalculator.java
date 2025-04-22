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
    public static int calculatePayout2D(String[][] a, int col, int row, int sym, int bet){
        boolean allMatch = true;
        for(int r=0; r<row; r++){
            for (int c=0; c<col; c++){
                if (!a[r][c].equals(a[0][0])){
                    allMatch = false;
                }
            }
        }
        if (allMatch){
            System.out.println("ALL TILES MATCH! MASSIVE JACKPOT! You win $" + (int)(bet*(sym^(col*row-1))*.1));
            return (int)(bet*(sym^(col*row-1))*.1);
        }
        int maxNumberOfRowsSame = 0;
        int maxNumberOfColsSame = 0;
        for (int r=0; r<row; r++){
            boolean rowMatches = true;
            for(int c=0; c<col; c++){
                if (!a[r][c].equals(a[r][0])){
                    rowMatches = false;
                }
            }
            if (rowMatches){
                maxNumberOfRowsSame++;
            }
        }
        for (int c=0; c<col; c++){
            boolean colMatches = true;
            for (int r=0; r<row; r++){
                if (!a[r][c].equals(a[0][c])){
                    colMatches = false;
                }
            }
            if (colMatches){
                maxNumberOfColsSame++;
            }
        }
        if (maxNumberOfColsSame>0 && maxNumberOfRowsSame>0){
            System.out.println("You matched " + maxNumberOfColsSame + " columns and " + maxNumberOfRowsSame + " rows and win $" + (int)(bet*(Math.pow(Math.pow(sym,(row + col)/2),maxNumberOfColsSame + maxNumberOfRowsSame))/NChooseK.C((col + row)/2,maxNumberOfColsSame + maxNumberOfRowsSame)*0.1));
            return (int)(bet*(Math.pow(Math.pow(sym,(row + col)/2),maxNumberOfColsSame + maxNumberOfRowsSame))/NChooseK.C((col + row)/2,maxNumberOfColsSame + maxNumberOfRowsSame)*0.1);
        }
        if (maxNumberOfColsSame>0 && maxNumberOfColsSame>=maxNumberOfRowsSame){
            System.out.println(maxNumberOfColsSame + " columns match! You win $" + (int)(bet*(Math.pow(Math.pow(sym,row),maxNumberOfColsSame))/NChooseK.C(col,maxNumberOfColsSame)*0.1));
            return (int)(bet*(Math.pow(Math.pow(sym,row),maxNumberOfColsSame))/NChooseK.C(col,maxNumberOfColsSame)*0.1);
        }
        if (maxNumberOfRowsSame>0){
            System.out.println(maxNumberOfRowsSame + " rows match! You win $" + (int)(bet*(Math.pow(Math.pow(sym,col),maxNumberOfRowsSame))/NChooseK.C(row,maxNumberOfRowsSame)*0.1));
            return (int)(bet*(Math.pow(Math.pow(sym,col),maxNumberOfRowsSame))/NChooseK.C(row,maxNumberOfRowsSame)*0.1);
        }
        System.out.println("You did not match any rows or columns. You do not win");
        return 0;
    }
}
