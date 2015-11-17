import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int k = 0; k < K; k++) {
            A.add(1);
            for (int i = A.size() - 2; i >= 1; i--) {
                A.set(i, A.get(i-1) + A.get(i));
            }
            for (Integer a : A) {
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }
}

