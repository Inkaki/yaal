package net.egork;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import net.egork.numbers.IntegerUtils;
import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;
import static net.egork.io.IOUtils.*;
import static net.egork.misc.MiscUtils.*;
import static net.egork.misc.ArrayUtils.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class TaskF {
    private static final long MOD = (long) (1e9 + 9);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long k = in.readLong();
        int d = in.readInt();
        int m = in.readInt();
        if (m % d != 0) {
            out.printLine(0);
            return;
        }
        long answer = 1;
        int delta = m / d;
        for (int i = 2; i * i <= delta; i++) {
            if (delta % i == 0) {
                int power = 0;
                do {
                    power++;
                    delta /= i;
                } while (delta % i == 0);
                long mult = IntegerUtils.power(power + 1, k, MOD) - 2 * IntegerUtils.power(power, k, MOD);
                mult += IntegerUtils.power(power - 1, k, MOD);
                answer *= mult;
                answer %= MOD;
            }
        }
        if (delta != 1) {
            answer *= IntegerUtils.power(2, k, MOD) - 2;
            answer %= MOD;
        }
        if (answer < 0) {
            answer += MOD;
        }
        out.printLine(answer);
    }
}
