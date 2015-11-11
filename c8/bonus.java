/*
 * Complete the function below.
 */

    static int maxDifference(int[] a) {
        if (a == null)
            return -1;
        if (a.length <= 1)
            return -1;
        int min_val = a[0];
        int result = -1;
        for (int i = 1; i < a.length; i++) {
            int val = a[i] - min_val;
            if (val > 0) {
                if (result == -1 || val > result)
                    result = val;
            }
            if (a[i] < min_val) {
                min_val = a[i];
            }
        }
        return result;
    }


