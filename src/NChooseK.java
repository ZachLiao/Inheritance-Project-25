public class NChooseK {

    // Static method to calculate n choose k using int
    public static int C(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        
        // Take advantage of symmetry: C(n, k) == C(n, n - k)
        if (k > n - k) {
            k = n - k;
        }

        int result = 1;
        
        // Calculate C(n, k) using an iterative approach
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        
        return result;
    }
}