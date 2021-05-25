package androidx.constraintlayout.motion.utils;

import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.Arrays;
public class Easing {
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", AdBreak.BreakType.LINEAR};
    public static Easing b = new Easing();
    public String a = "identity";

    public static class a extends Easing {
        public double c;
        public double d;
        public double e;
        public double f;

        public a(String str) {
            this.a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.d = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.e = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.f = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        public final double a(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.e * d6) + (this.c * d5) + (d2 * d2 * d2);
        }

        public final double b(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.f * d6) + (this.d * d5) + (d2 * d2 * d2);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 0.01d) {
                d3 *= 0.5d;
                d4 = a(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double a = a(d5);
            double d6 = d4 + d3;
            double a3 = a(d6);
            double b = b(d5);
            return (((d2 - a) * (b(d6) - b)) / (a3 - a)) + b;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 1.0E-4d) {
                d3 *= 0.5d;
                d4 = a(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (b(d6) - b(d5)) / (a(d6) - a(d5));
        }
    }

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(AdBreak.BreakType.LINEAR)) {
                    c = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(1, 1, 0, 0)");
            case 3:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Arrays.toString(NAMED_EASING);
                return b;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.a;
    }
}
