package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;
public class HyperSpline {
    public int a;
    public Cubic[][] b;
    public int c;
    public double[] d;
    public double e;
    public double[][] f;

    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        public double a;
        public double b;
        public double c;
        public double d;

        public Cubic(double d2, double d3, double d4, double d5) {
            this.a = d2;
            this.b = d3;
            this.c = d4;
            this.d = d5;
        }

        public double eval(double d2) {
            return (((((this.d * d2) + this.c) * d2) + this.b) * d2) + this.a;
        }

        public double vel(double d2) {
            return (((this.c * 0.5d) + (this.d * 0.3333333333333333d * d2)) * d2) + this.b;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (true) {
            i = 0;
            if (d3 >= 1.0d) {
                break;
            }
            double d5 = 0.0d;
            while (i < cubicArr.length) {
                double d6 = dArr[i];
                double eval = cubicArr[i].eval(d3);
                dArr[i] = eval;
                double d7 = d6 - eval;
                d5 += d7 * d7;
                i++;
            }
            if (d3 > 0.0d) {
                d4 += Math.sqrt(d5);
            }
            d3 += 0.1d;
        }
        while (i < cubicArr.length) {
            double d8 = dArr[i];
            double eval2 = cubicArr[i].eval(1.0d);
            dArr[i] = eval2;
            double d9 = d8 - eval2;
            d2 += d9 * d9;
            i++;
        }
        return Math.sqrt(d2) + d4;
    }

    public void getPos(double d2, double[] dArr) {
        double d3 = d2 * this.e;
        int i = 0;
        while (true) {
            double[] dArr2 = this.d;
            if (i >= dArr2.length - 1 || dArr2[i] >= d3) {
                break;
            }
            d3 -= dArr2[i];
            i++;
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.b[i2][i].eval(d3 / this.d[i]);
        }
    }

    public void getVelocity(double d2, double[] dArr) {
        double d3 = d2 * this.e;
        int i = 0;
        while (true) {
            double[] dArr2 = this.d;
            if (i >= dArr2.length - 1 || dArr2[i] >= d3) {
                break;
            }
            d3 -= dArr2[i];
            i++;
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.b[i2][i].vel(d3 / this.d[i]);
        }
    }

    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.c = length;
        int length2 = dArr.length;
        this.a = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.f = (double[][]) Array.newInstance(double.class, iArr);
        this.b = new Cubic[this.c][];
        for (int i2 = 0; i2 < this.c; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                this.f[i2][i3] = dArr[i3][i2];
            }
        }
        int i4 = 0;
        while (true) {
            i = this.c;
            if (i4 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.b;
            double[][] dArr2 = this.f;
            int length3 = dArr2[i4].length;
            double[] dArr3 = dArr2[i4];
            double[] dArr4 = new double[length3];
            double[] dArr5 = new double[length3];
            double[] dArr6 = new double[length3];
            int i5 = length3 - 1;
            dArr4[0] = 0.5d;
            for (int i6 = 1; i6 < i5; i6++) {
                dArr4[i6] = 1.0d / (4.0d - dArr4[i6 - 1]);
            }
            int i7 = i5 - 1;
            dArr4[i5] = 1.0d / (2.0d - dArr4[i7]);
            dArr5[0] = (dArr3[1] - dArr3[0]) * 3.0d * dArr4[0];
            int i8 = 1;
            while (i8 < i5) {
                int i9 = i8 + 1;
                int i10 = i8 - 1;
                dArr5[i8] = (((dArr3[i9] - dArr3[i10]) * 3.0d) - dArr5[i10]) * dArr4[i8];
                i8 = i9;
            }
            dArr5[i5] = (((dArr3[i5] - dArr3[i7]) * 3.0d) - dArr5[i7]) * dArr4[i5];
            dArr6[i5] = dArr5[i5];
            while (i7 >= 0) {
                dArr6[i7] = dArr5[i7] - (dArr4[i7] * dArr6[i7 + 1]);
                i7--;
            }
            Cubic[] cubicArr2 = new Cubic[i5];
            int i11 = 0;
            while (i11 < i5) {
                int i12 = i11 + 1;
                cubicArr2[i11] = new Cubic((double) ((float) dArr3[i11]), dArr6[i11], (((dArr3[i12] - dArr3[i11]) * 3.0d) - (dArr6[i11] * 2.0d)) - dArr6[i12], ((dArr3[i11] - dArr3[i12]) * 2.0d) + dArr6[i11] + dArr6[i12]);
                i11 = i12;
            }
            cubicArr[i4] = cubicArr2;
            i4++;
        }
        this.d = new double[(this.a - 1)];
        this.e = 0.0d;
        Cubic[] cubicArr3 = new Cubic[i];
        for (int i13 = 0; i13 < this.d.length; i13++) {
            for (int i14 = 0; i14 < this.c; i14++) {
                cubicArr3[i14] = this.b[i14][i13];
            }
            double d2 = this.e;
            double[] dArr7 = this.d;
            double approxLength = approxLength(cubicArr3);
            dArr7[i13] = approxLength;
            this.e = d2 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d2, float[] fArr) {
        double d3 = d2 * this.e;
        int i = 0;
        while (true) {
            double[] dArr = this.d;
            if (i >= dArr.length - 1 || dArr[i] >= d3) {
                break;
            }
            d3 -= dArr[i];
            i++;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = (float) this.b[i2][i].eval(d3 / this.d[i]);
        }
    }

    public double getPos(double d2, int i) {
        double[] dArr;
        double d3 = d2 * this.e;
        int i2 = 0;
        while (true) {
            dArr = this.d;
            if (i2 >= dArr.length - 1 || dArr[i2] >= d3) {
                break;
            }
            d3 -= dArr[i2];
            i2++;
        }
        return this.b[i][i2].eval(d3 / dArr[i2]);
    }
}
