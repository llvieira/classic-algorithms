public class Pow {
    public int pow(int x, int n, int d) {
        long result;

        while (n > 0) {
            if ((n & 1) == 0) {
                result = (x * x) % d;
                n /= 2;
            } else {
                result = 
            }
        }        

        return (int)((pow + d)) % d;
    }
    
    private long calcPow(int x, int n, int d) {
         


        while (n > 0) {

        }

        x = x % d;

        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        if ((n & 1) == 0) {
            return calcPow((x * x) % d, n >> 1, d);
        }
        
        return x * calcPow(x, n - 1, d) % d;
    } 

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.pow(71045970, 41535484, 64735492));
    }
}
