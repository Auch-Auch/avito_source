package androidx.constraintlayout.motion.utils;

import a2.b.a.a.a;
import java.util.Arrays;
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    public float[] a = new float[0];
    public double[] b = new double[0];
    public double[] c;
    public int d;
    public double e = 6.283185307179586d;

    public double a(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.a;
        int i2 = i - 1;
        double d3 = (double) (fArr[i] - fArr[i2]);
        double[] dArr = this.b;
        double d4 = d3 / (dArr[i] - dArr[i2]);
        return (((double) fArr[i2]) - (d4 * dArr[i2])) + (d2 * d4);
    }

    public void addPoint(double d2, float f) {
        int length = this.a.length + 1;
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.b = Arrays.copyOf(this.b, length);
        this.a = Arrays.copyOf(this.a, length);
        this.c = new double[length];
        double[] dArr = this.b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.b[binarySearch] = d2;
        this.a[binarySearch] = f;
    }

    public double b(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.a;
        int i2 = i - 1;
        double d3 = (double) (fArr[i] - fArr[i2]);
        double[] dArr = this.b;
        double d4 = d3 / (dArr[i] - dArr[i2]);
        return ((((d2 * d2) - (dArr[i2] * dArr[i2])) * d4) / 2.0d) + ((d2 - dArr[i2]) * (((double) fArr[i2]) - (dArr[i2] * d4))) + this.c[i2];
    }

    public double getSlope(double d2) {
        switch (this.d) {
            case 1:
                return 0.0d;
            case 2:
                return Math.signum((((b(d2) * 4.0d) + 3.0d) % 4.0d) - 2.0d) * a(d2) * 4.0d;
            case 3:
                return a(d2) * 2.0d;
            case 4:
                return (-a(d2)) * 2.0d;
            case 5:
                return Math.sin(b(d2) * this.e) * a(d2) * (-this.e);
            case 6:
                return ((((b(d2) * 4.0d) + 2.0d) % 4.0d) - 2.0d) * a(d2) * 4.0d;
            default:
                return Math.cos(b(d2) * this.e) * a(d2) * this.e;
        }
    }

    public double getValue(double d2) {
        double abs;
        switch (this.d) {
            case 1:
                return Math.signum(0.5d - (b(d2) % 1.0d));
            case 2:
                abs = Math.abs((((b(d2) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((b(d2) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((b(d2) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(b(d2) * this.e);
            case 6:
                double abs2 = 1.0d - Math.abs(((b(d2) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(b(d2) * this.e);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d2 = 0.0d;
        int i = 0;
        while (true) {
            float[] fArr = this.a;
            if (i >= fArr.length) {
                break;
            }
            d2 += (double) fArr[i];
            i++;
        }
        int i2 = 1;
        double d3 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr2 = this.a;
            if (i3 >= fArr2.length) {
                break;
            }
            int i4 = i3 - 1;
            double[] dArr = this.b;
            d3 += (dArr[i3] - dArr[i4]) * ((double) ((fArr2[i4] + fArr2[i3]) / 2.0f));
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr3 = this.a;
            if (i5 >= fArr3.length) {
                break;
            }
            fArr3[i5] = (float) (((double) fArr3[i5]) * (d2 / d3));
            i5++;
        }
        this.c[0] = 0.0d;
        while (true) {
            float[] fArr4 = this.a;
            if (i2 < fArr4.length) {
                int i6 = i2 - 1;
                double[] dArr2 = this.b;
                double d4 = dArr2[i2] - dArr2[i6];
                double[] dArr3 = this.c;
                dArr3[i2] = (d4 * ((double) ((fArr4[i6] + fArr4[i2]) / 2.0f))) + dArr3[i6];
                i2++;
            } else {
                return;
            }
        }
    }

    public void setType(int i) {
        this.d = i;
    }

    public String toString() {
        StringBuilder L = a.L("pos =");
        L.append(Arrays.toString(this.b));
        L.append(" period=");
        L.append(Arrays.toString(this.a));
        return L.toString();
    }
}
