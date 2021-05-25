package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
public abstract class KeyCycleOscillator {
    public CurveFit a;
    public d b;
    public String c;
    public int d = 0;
    public ArrayList<p> e = new ArrayList<>();
    public ConstraintAttribute mCustom;
    public int mVariesBy = 0;

    public class a implements Comparator<p> {
        public a(KeyCycleOscillator keyCycleOscillator) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(p pVar, p pVar2) {
            return Integer.compare(pVar.a, pVar2.a);
        }
    }

    public static class b extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    public static class c extends KeyCycleOscillator {
        public float[] f = new float[1];

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            this.f[0] = get(f2);
            this.mCustom.setInterpolatedValue(view, this.f);
        }
    }

    public static class d {
        public Oscillator a = new Oscillator();
        public float[] b;
        public double[] c;
        public float[] d;
        public float[] e;
        public CurveFit f;
        public double[] g;
        public double[] h;

        public d(int i, int i2, int i3) {
            new HashMap();
            this.a.setType(i);
            this.b = new float[i3];
            this.c = new double[i3];
            this.d = new float[i3];
            this.e = new float[i3];
            float[] fArr = new float[i3];
        }
    }

    public static class e extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setElevation(get(f));
        }
    }

    public static class f extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
        }
    }

    public static class g extends KeyCycleOscillator {
        public boolean f = false;

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2));
            } else if (!this.f) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f2)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    public static class h extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    public static class i extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    public static class j extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    public static class k extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    public static class l extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    public static class m extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    public static class n extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    public static class o extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f) {
            view.setTranslationZ(get(f));
        }
    }

    public static class p {
        public int a;
        public float b;
        public float c;
        public float d;

        public p(int i, float f, float f2, float f3) {
            this.a = i;
            this.b = f3;
            this.c = f2;
            this.d = f;
        }
    }

    public float get(float f2) {
        d dVar = this.b;
        CurveFit curveFit = dVar.f;
        if (curveFit != null) {
            curveFit.getPos((double) f2, dVar.g);
        } else {
            double[] dArr = dVar.g;
            dArr[0] = (double) dVar.e[0];
            dArr[1] = (double) dVar.b[0];
        }
        return (float) ((dVar.a.getValue((double) f2) * dVar.g[1]) + dVar.g[0]);
    }

    public CurveFit getCurveFit() {
        return this.a;
    }

    public float getSlope(float f2) {
        d dVar = this.b;
        CurveFit curveFit = dVar.f;
        if (curveFit != null) {
            double d2 = (double) f2;
            curveFit.getSlope(d2, dVar.h);
            dVar.f.getPos(d2, dVar.g);
        } else {
            double[] dArr = dVar.h;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        double d3 = (double) f2;
        double value = dVar.a.getValue(d3);
        double slope = dVar.a.getSlope(d3);
        double[] dArr2 = dVar.h;
        double d4 = dArr2[0];
        return (float) ((slope * dVar.g[1]) + (value * dArr2[1]) + d4);
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4, ConstraintAttribute constraintAttribute) {
        this.e.add(new p(i2, f2, f3, f4));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.d = i3;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f2);

    public void setType(String str) {
        this.c = str;
    }

    @TargetApi(19)
    public void setup(float f2) {
        int i2;
        int size = this.e.size();
        if (size != 0) {
            Collections.sort(this.e, new a(this));
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            char c2 = 1;
            iArr[1] = 2;
            char c3 = 0;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            this.b = new d(this.d, this.mVariesBy, size);
            Iterator<p> it = this.e.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                p next = it.next();
                float f3 = next.d;
                dArr[i3] = ((double) f3) * 0.01d;
                double[] dArr3 = dArr2[i3];
                float f4 = next.b;
                dArr3[c3] = (double) f4;
                double[] dArr4 = dArr2[i3];
                float f5 = next.c;
                dArr4[c2] = (double) f5;
                d dVar = this.b;
                dVar.c[i3] = ((double) next.a) / 100.0d;
                dVar.d[i3] = f3;
                dVar.e[i3] = f5;
                dVar.b[i3] = f4;
                i3++;
                c2 = 1;
                c3 = 0;
            }
            d dVar2 = this.b;
            int length = dVar2.c.length;
            int[] iArr2 = new int[2];
            iArr2[1] = 2;
            iArr2[0] = length;
            double[][] dArr5 = (double[][]) Array.newInstance(double.class, iArr2);
            float[] fArr = dVar2.b;
            dVar2.g = new double[(fArr.length + 1)];
            dVar2.h = new double[(fArr.length + 1)];
            if (dVar2.c[0] > 0.0d) {
                dVar2.a.addPoint(0.0d, dVar2.d[0]);
            }
            double[] dArr6 = dVar2.c;
            int length2 = dArr6.length - 1;
            if (dArr6[length2] < 1.0d) {
                dVar2.a.addPoint(1.0d, dVar2.d[length2]);
            }
            for (int i4 = 0; i4 < dArr5.length; i4++) {
                dArr5[i4][0] = (double) dVar2.e[i4];
                int i5 = 0;
                while (true) {
                    float[] fArr2 = dVar2.b;
                    if (i5 >= fArr2.length) {
                        break;
                    }
                    dArr5[i5][1] = (double) fArr2[i5];
                    i5++;
                }
                dVar2.a.addPoint(dVar2.c[i4], dVar2.d[i4]);
            }
            dVar2.a.normalize();
            double[] dArr7 = dVar2.c;
            if (dArr7.length > 1) {
                i2 = 0;
                dVar2.f = CurveFit.get(0, dArr7, dArr5);
            } else {
                i2 = 0;
                dVar2.f = null;
            }
            this.a = CurveFit.get(i2, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<p> it = this.e.iterator();
        while (it.hasNext()) {
            p next = it.next();
            StringBuilder Q = a2.b.a.a.a.Q(str, "[");
            Q.append(next.a);
            Q.append(" , ");
            Q.append(decimalFormat.format((double) next.b));
            Q.append("] ");
            str = Q.toString();
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4) {
        this.e.add(new p(i2, f2, f3, f4));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.d = i3;
    }
}
