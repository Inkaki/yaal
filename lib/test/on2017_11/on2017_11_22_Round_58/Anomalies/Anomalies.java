package on2017_11.on2017_11_22_Round_58.Anomalies;


import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import static net.egork.misc.ArrayUtils.sort;

public class Anomalies {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        int[] a = in.readIntArray(n);
        sort(a);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || a[i] - a[i - 1] > k) && (i == n - 1 || a[i + 1] - a[i] > k)) {
                answer++;
            }
        }
        out.printLine(answer);
    }
}
