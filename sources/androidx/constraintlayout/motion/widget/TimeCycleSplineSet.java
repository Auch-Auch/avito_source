package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
public abstract class TimeCycleSplineSet {
    public int a;
    public String b;
    public float[] c = new float[3];
    public long d;
    public float e = Float.NaN;
    public boolean mContinue = false;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public float[][] mValues = ((float[][]) Array.newInstance(float.class, 10, 3));
    public int mWaveShape = 0;

    public static class a extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class b extends TimeCycleSplineSet {
        public String f;
        public SparseArray<ConstraintAttribute> g;
        public SparseArray<float[]> h = new SparseArray<>();
        public float[] i;
        public float[] j;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f = str.split(",")[1];
            this.g = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            this.mCurveFit.getPos((double) f2, this.i);
            float[] fArr = this.i;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.d;
            if (Float.isNaN(this.e)) {
                float a = keyCache.a(view, this.f, 0);
                this.e = a;
                if (Float.isNaN(a)) {
                    this.e = 0.0f;
                }
            }
            float f5 = (float) ((((((double) j3) * 1.0E-9d) * ((double) f3)) + ((double) this.e)) % 1.0d);
            this.e = f5;
            this.d = j2;
            float calcWave = calcWave(f5);
            this.mContinue = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.j;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.mContinue;
                float[] fArr3 = this.i;
                this.mContinue = z | (((double) fArr3[i2]) != 0.0d);
                fArr2[i2] = (fArr3[i2] * calcWave) + f4;
                i2++;
            }
            this.g.valueAt(0).setInterpolatedValue(view, this.j);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.g.size();
            int noOfInterpValues = this.g.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i3 = noOfInterpValues + 2;
            this.i = new float[i3];
            this.j = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.g.keyAt(i4);
                float[] valueAt = this.h.valueAt(i4);
                dArr[i4] = ((double) keyAt) * 0.01d;
                this.g.valueAt(i4).getValuesToInterpolate(this.i);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.i;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                dArr2[i4][noOfInterpValues] = (double) valueAt[0];
                dArr2[i4][noOfInterpValues + 1] = (double) valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }
    }

    public static class c extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setElevation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class d extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    public static class e extends TimeCycleSplineSet {
        public boolean f = false;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2, j, view, keyCache));
            } else if (this.f) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f2, j, view, keyCache)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    public static class f extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class g extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class h extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class i extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class j extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class k extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class l extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class m extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationZ(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public float calcWave(float f2) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f2 * 6.2831855f);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f2 * 6.2831855f));
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f2 * 6.2831855f));
        }
        return 1.0f - abs;
    }

    public float get(float f2, long j2, View view, KeyCache keyCache) {
        this.mCurveFit.getPos((double) f2, this.c);
        float[] fArr = this.c;
        boolean z = true;
        float f3 = fArr[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.e)) {
            float a3 = keyCache.a(view, this.b, 0);
            this.e = a3;
            if (Float.isNaN(a3)) {
                this.e = 0.0f;
            }
        }
        float f4 = (float) ((((((double) (j2 - this.d)) * 1.0E-9d) * ((double) f3)) + ((double) this.e)) % 1.0d);
        this.e = f4;
        String str = this.b;
        if (!keyCache.a.containsKey(view)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            hashMap.put(str, new float[]{f4});
            keyCache.a.put(view, hashMap);
        } else {
            HashMap<String, float[]> hashMap2 = keyCache.a.get(view);
            if (!hashMap2.containsKey(str)) {
                hashMap2.put(str, new float[]{f4});
                keyCache.a.put(view, hashMap2);
            } else {
                float[] fArr2 = hashMap2.get(str);
                if (fArr2.length <= 0) {
                    fArr2 = Arrays.copyOf(fArr2, 1);
                }
                fArr2[0] = f4;
                hashMap2.put(str, fArr2);
            }
        }
        this.d = j2;
        float f5 = this.c[0];
        float calcWave = (calcWave(this.e) * f5) + this.c[2];
        if (f5 == 0.0f && i2 == 0) {
            z = false;
        }
        this.mContinue = z;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.mTimePoints;
        int i4 = this.a;
        iArr[i4] = i2;
        float[][] fArr = this.mValues;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.mWaveShape = Math.max(this.mWaveShape, i3);
        this.a++;
    }

    public abstract boolean setProperty(View view, float f2, long j2, KeyCache keyCache);

    public void setStartTime(long j2) {
        this.d = j2;
    }

    public void setType(String str) {
        this.b = str;
    }

    public void setup(int i2) {
        int i3 = this.a;
        if (i3 != 0) {
            int[] iArr = this.mTimePoints;
            float[][] fArr = this.mValues;
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3 - 1;
            iArr2[1] = 0;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int i8 = iArr[i7];
                    int i9 = i6;
                    int i10 = i9;
                    while (i9 < i7) {
                        if (iArr[i9] <= i8) {
                            int i11 = iArr[i10];
                            iArr[i10] = iArr[i9];
                            iArr[i9] = i11;
                            float[] fArr2 = fArr[i10];
                            fArr[i10] = fArr[i9];
                            fArr[i9] = fArr2;
                            i10++;
                        }
                        i9++;
                    }
                    int i12 = iArr[i10];
                    iArr[i10] = iArr[i7];
                    iArr[i7] = i12;
                    float[] fArr3 = fArr[i10];
                    fArr[i10] = fArr[i7];
                    fArr[i7] = fArr3;
                    int i13 = i4 + 1;
                    iArr2[i4] = i10 - 1;
                    int i14 = i13 + 1;
                    iArr2[i13] = i6;
                    int i15 = i14 + 1;
                    iArr2[i14] = i7;
                    i4 = i15 + 1;
                    iArr2[i15] = i10 + 1;
                }
            }
            int i16 = 1;
            int i17 = 0;
            while (true) {
                int[] iArr3 = this.mTimePoints;
                if (i16 >= iArr3.length) {
                    break;
                }
                if (iArr3[i16] != iArr3[i16 - 1]) {
                    i17++;
                }
                i16++;
            }
            if (i17 == 0) {
                i17 = 1;
            }
            double[] dArr = new double[i17];
            int[] iArr4 = new int[2];
            iArr4[1] = 3;
            iArr4[0] = i17;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr4);
            int i18 = 0;
            for (int i19 = 0; i19 < this.a; i19++) {
                if (i19 > 0) {
                    int[] iArr5 = this.mTimePoints;
                    if (iArr5[i19] == iArr5[i19 - 1]) {
                    }
                }
                dArr[i18] = ((double) this.mTimePoints[i19]) * 0.01d;
                double[] dArr3 = dArr2[i18];
                float[][] fArr4 = this.mValues;
                dArr3[0] = (double) fArr4[i19][0];
                dArr2[i18][1] = (double) fArr4[i19][1];
                dArr2[i18][2] = (double) fArr4[i19][2];
                i18++;
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.a; i2++) {
            StringBuilder Q = a2.b.a.a.a.Q(str, "[");
            Q.append(this.mTimePoints[i2]);
            Q.append(" , ");
            Q.append(decimalFormat.format(this.mValues[i2]));
            Q.append("] ");
            str = Q.toString();
        }
        return str;
    }
}
