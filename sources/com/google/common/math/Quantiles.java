package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Beta
@GwtIncompatible
public final class Quantiles {

    public static final class Scale {
        public final int a;

        public Scale(int i, a aVar) {
            Preconditions.checkArgument(i > 0, "Quantile scale must be positive");
            this.a = i;
        }

        public ScaleAndIndex index(int i) {
            return new ScaleAndIndex(this.a, i, null);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.a, (int[]) iArr.clone(), null);
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.a, Ints.toArray(collection), null);
        }
    }

    public static final class ScaleAndIndex {
        public final int a;
        public final int b;

        public ScaleAndIndex(int i, int i2, a aVar) {
            Quantiles.a(i2, i);
            this.a = i;
            this.b = i2;
        }

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.b(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.b) * ((long) (dArr.length - 1));
            int divide = (int) LongMath.divide(length, (long) this.a, RoundingMode.DOWN);
            int i = (int) (length - (((long) divide) * ((long) this.a)));
            Quantiles.e(divide, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[divide];
            }
            int i2 = divide + 1;
            Quantiles.e(i2, dArr, i2, dArr.length - 1);
            return Quantiles.c(dArr[divide], dArr[i2], (double) i, (double) this.a);
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            int length = jArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = (double) jArr[i];
            }
            return computeInPlace(dArr);
        }

        public double compute(int... iArr) {
            int length = iArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = (double) iArr[i];
            }
            return computeInPlace(dArr);
        }
    }

    public static final class ScaleAndIndexes {
        public final int a;
        public final int[] b;

        public ScaleAndIndexes(int i, int[] iArr, a aVar) {
            for (int i2 : iArr) {
                Quantiles.a(i2, i);
            }
            this.a = i;
            this.b = iArr;
        }

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            int i = 0;
            int i2 = 1;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.b(dArr)) {
                HashMap hashMap = new HashMap();
                int[] iArr = this.b;
                int length = iArr.length;
                while (i < length) {
                    hashMap.put(Integer.valueOf(iArr[i]), Double.valueOf(Double.NaN));
                    i++;
                }
                return Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr6 = this.b;
                if (i3 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i3]) * ((long) (dArr.length - i2));
                int divide = (int) LongMath.divide(length2, (long) this.a, RoundingMode.DOWN);
                int i5 = (int) (length2 - (((long) divide) * ((long) this.a)));
                iArr3[i3] = divide;
                iArr4[i3] = i5;
                iArr5[i4] = divide;
                i4++;
                if (i5 != 0) {
                    iArr5[i4] = divide + 1;
                    i4++;
                }
                i3++;
                i2 = 1;
            }
            Arrays.sort(iArr5, 0, i4);
            Quantiles.d(iArr5, 0, i4 - 1, dArr, 0, dArr.length - 1);
            HashMap hashMap2 = new HashMap();
            while (true) {
                int[] iArr7 = this.b;
                if (i >= iArr7.length) {
                    return Collections.unmodifiableMap(hashMap2);
                }
                int i6 = iArr3[i];
                int i7 = iArr4[i];
                if (i7 == 0) {
                    hashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(dArr[i6]));
                } else {
                    hashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(Quantiles.c(dArr[i6], dArr[i6 + 1], (double) i7, (double) this.a)));
                }
                i++;
            }
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            int length = jArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = (double) jArr[i];
            }
            return computeInPlace(dArr);
        }

        public Map<Integer, Double> compute(int... iArr) {
            int length = iArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = (double) iArr[i];
            }
            return computeInPlace(dArr);
        }
    }

    public static void a(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Quantile indexes must be between 0 and the scale, which is ", i2));
        }
    }

    public static boolean b(double[] dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    public static double c(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return (((d2 - d) * d3) / d4) + d;
    }

    public static void d(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5;
        if (i == i2) {
            i5 = i;
        } else {
            int i6 = i3 + i4;
            int i7 = i6 >>> 1;
            i5 = i;
            int i8 = i2;
            while (true) {
                if (i8 > i5 + 1) {
                    int i9 = (i5 + i8) >>> 1;
                    if (iArr[i9] <= i7) {
                        if (iArr[i9] >= i7) {
                            i5 = i9;
                            break;
                        }
                        i5 = i9;
                    } else {
                        i8 = i9;
                    }
                } else if ((i6 - iArr[i5]) - iArr[i8] > 0) {
                    i5 = i8;
                }
            }
        }
        int i10 = iArr[i5];
        e(i10, dArr, i3, i4);
        int i11 = i5 - 1;
        while (i11 >= i && iArr[i11] == i10) {
            i11--;
        }
        if (i11 >= i) {
            d(iArr, i, i11, dArr, i3, i10 - 1);
        }
        int i12 = i5 + 1;
        while (i12 <= i2 && iArr[i12] == i10) {
            i12++;
        }
        if (i12 <= i2) {
            d(iArr, i12, i2, dArr, i10 + 1, i4);
        }
    }

    public static void e(int i, double[] dArr, int i2, int i3) {
        if (i == i2) {
            int i4 = i2;
            for (int i5 = i2 + 1; i5 <= i3; i5++) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i4];
                dArr[i4] = dArr[i2];
                dArr[i2] = d;
                return;
            }
            return;
        }
        while (i3 > i2) {
            boolean z = true;
            int i6 = (i2 + i3) >>> 1;
            boolean z2 = dArr[i3] < dArr[i6];
            boolean z3 = dArr[i6] < dArr[i2];
            if (dArr[i3] >= dArr[i2]) {
                z = false;
            }
            if (z2 == z3) {
                double d2 = dArr[i6];
                dArr[i6] = dArr[i2];
                dArr[i2] = d2;
            } else if (z2 != z) {
                double d3 = dArr[i2];
                dArr[i2] = dArr[i3];
                dArr[i3] = d3;
            }
            double d4 = dArr[i2];
            int i7 = i3;
            int i8 = i7;
            while (i7 > i2) {
                if (dArr[i7] > d4) {
                    double d5 = dArr[i8];
                    dArr[i8] = dArr[i7];
                    dArr[i7] = d5;
                    i8--;
                }
                i7--;
            }
            double d6 = dArr[i2];
            dArr[i2] = dArr[i8];
            dArr[i8] = d6;
            if (i8 >= i) {
                i3 = i8 - 1;
            }
            if (i8 <= i) {
                i2 = i8 + 1;
            }
        }
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i) {
        return new Scale(i, null);
    }
}
