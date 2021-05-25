package t6.s;

import kotlin.jvm.JvmField;
public final class a {
    @JvmField
    public static final double a = Math.log(2.0d);
    @JvmField
    public static final double b;
    @JvmField
    public static final double c;
    @JvmField
    public static final double d;
    @JvmField
    public static final double e;
    @JvmField
    public static final double f;

    static {
        double ulp = Math.ulp(1.0d);
        b = ulp;
        double sqrt = Math.sqrt(ulp);
        c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        d = sqrt2;
        double d2 = (double) 1;
        e = d2 / sqrt;
        f = d2 / sqrt2;
    }
}
