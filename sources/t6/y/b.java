package t6.y;

import a2.b.a.a.a;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
public class b extends a {
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final char digitToChar(int i) {
        if (i >= 0 && 9 >= i) {
            return (char) (i + 48);
        }
        throw new IllegalArgumentException(a.Q2("Int ", i, " is not a decimal digit"));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final int digitToInt(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        throw new IllegalArgumentException(a.L2("Char ", c, " is not a decimal digit"));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    @Nullable
    public static final Integer digitToIntOrNull(char c) {
        if ('0' <= c && '9' >= c) {
            return Integer.valueOf(c - '0');
        }
        return null;
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return equals(c, c2, z);
    }

    public static final boolean isSurrogate(char c) {
        return 55296 <= c && 57343 >= c;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final char digitToChar(int i, int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException(a.Q2("Invalid radix: ", i2, ". Valid radix values are in range 2..36"));
        } else if (i < 0 || i >= i2) {
            throw new IllegalArgumentException(a.R2("Digit ", i, " does not represent a valid digit in radix ", i2));
        } else {
            return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final int digitToInt(char c, int i) {
        Integer digitToIntOrNull = digitToIntOrNull(c, i);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    @Nullable
    public static final Integer digitToIntOrNull(char c, int i) {
        if (2 > i || 36 < i) {
            throw new IllegalArgumentException(a.Q2("Invalid radix: ", i, ". Valid radix values are in range 2..36"));
        } else if ('0' <= c && '9' >= c) {
            int i2 = c - 48;
            if (i2 < i) {
                return Integer.valueOf(i2);
            }
            return null;
        } else {
            int i3 = (c - (Intrinsics.compare(c, 90) <= 0 ? 65 : 97)) + 10;
            if (10 <= i3 && i > i3) {
                return Integer.valueOf(i3);
            }
            return null;
        }
    }
}
