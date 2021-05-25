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
public abstract class SplineSet {
    public int a;
    public String b;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public float[] mValues = new float[10];

    public static class a extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    public static class b extends SplineSet {
        public SparseArray<ConstraintAttribute> c;
        public float[] d;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            String str2 = str.split(",")[1];
            this.c = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            this.mCurveFit.getPos((double) f, this.d);
            this.c.valueAt(0).setInterpolatedValue(view, this.d);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i) {
            int size = this.c.size();
            int noOfInterpValues = this.c.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.d = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = noOfInterpValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((double) this.c.keyAt(i2)) * 0.01d;
                this.c.valueAt(i2).getValuesToInterpolate(this.d);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.d;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    public static class c extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setElevation(get(f));
        }
    }

    public static class d extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
        }
    }

    public static class e extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    public static class f extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    public static class g extends SplineSet {
        public boolean c = false;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
            } else if (!this.c) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.c = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    public static class h extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    public static class i extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    public static class j extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    public static class k extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    public static class l extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    public static class m extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    public static class n extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    public static class o extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setTranslationZ(get(f));
        }
    }

    public float get(float f2) {
        return (float) this.mCurveFit.getPos((double) f2, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f2) {
        return (float) this.mCurveFit.getSlope((double) f2, 0);
    }

    public void setPoint(int i2, float f2) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.a + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i3 = this.a;
        iArr2[i3] = i2;
        this.mValues[i3] = f2;
        this.a = i3 + 1;
    }

    public abstract void setProperty(View view, float f2);

    public void setType(String str) {
        this.b = str;
    }

    public void setup(int i2) {
        int i3 = this.a;
        if (i3 != 0) {
            int[] iArr = this.mTimePoints;
            float[] fArr = this.mValues;
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
                            float f2 = fArr[i10];
                            fArr[i10] = fArr[i9];
                            fArr[i9] = f2;
                            i10++;
                        }
                        i9++;
                    }
                    int i12 = iArr[i10];
                    iArr[i10] = iArr[i7];
                    iArr[i7] = i12;
                    float f3 = fArr[i10];
                    fArr[i10] = fArr[i7];
                    fArr[i7] = f3;
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
            for (int i17 = 1; i17 < this.a; i17++) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i17 - 1] != iArr3[i17]) {
                    i16++;
                }
            }
            double[] dArr = new double[i16];
            int[] iArr4 = new int[2];
            iArr4[1] = 1;
            iArr4[0] = i16;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr4);
            int i18 = 0;
            for (int i19 = 0; i19 < this.a; i19++) {
                if (i19 > 0) {
                    int[] iArr5 = this.mTimePoints;
                    if (iArr5[i19] == iArr5[i19 - 1]) {
                    }
                }
                dArr[i18] = ((double) this.mTimePoints[i19]) * 0.01d;
                dArr2[i18][0] = (double) this.mValues[i19];
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
            Q.append(decimalFormat.format((double) this.mValues[i2]));
            Q.append("] ");
            str = Q.toString();
        }
        return str;
    }
}
