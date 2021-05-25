package androidx.constraintlayout.motion.widget;

import a2.b.a.a.a;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import l6.g.a.b.b;
import l6.g.a.b.c;
public class MotionController {
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    public int A = Key.UNSET;
    public View a;
    public int b;
    public int c = -1;
    public c d = new c();
    public c e = new c();
    public b f = new b();
    public b g = new b();
    public CurveFit[] h;
    public CurveFit i;
    public float j = Float.NaN;
    public float k = 0.0f;
    public float l = 1.0f;
    public int[] m;
    public double[] n;
    public double[] o;
    public String[] p;
    public int[] q;
    public int r = 4;
    public float[] s = new float[4];
    public ArrayList<c> t = new ArrayList<>();
    public float[] u = new float[1];
    public ArrayList<Key> v = new ArrayList<>();
    public HashMap<String, TimeCycleSplineSet> w;
    public HashMap<String, SplineSet> x;
    public HashMap<String, KeyCycleOscillator> y;
    public KeyTrigger[] z;

    public MotionController(View view) {
        setView(view);
    }

    public int a(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.h[0].getTimePoints();
        if (iArr != null) {
            Iterator<c> it = this.t.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().l;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : timePoints) {
            this.h[0].getPos(d2, this.n);
            this.d.c(this.m, this.n, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(float[] r22, int r23) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.b(float[], int):void");
    }

    public final float c(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.l;
            if (((double) f5) != 1.0d) {
                float f6 = this.k;
                if (f2 < f6) {
                    f2 = 0.0f;
                }
                if (f2 > f6 && ((double) f2) < 1.0d) {
                    f2 = (f2 - f6) * f5;
                }
            }
        }
        Easing easing = this.d.a;
        float f7 = Float.NaN;
        Iterator<c> it = this.t.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Easing easing2 = next.a;
            if (easing2 != null) {
                float f8 = next.c;
                if (f8 < f2) {
                    easing = easing2;
                    f3 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = next.c;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f7)) {
                f4 = f7;
            }
            float f9 = f4 - f3;
            double d2 = (double) ((f2 - f3) / f9);
            f2 = (((float) easing.get(d2)) * f9) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d2);
            }
        }
        return f2;
    }

    public void d(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float c2 = c(f2, this.u);
        CurveFit[] curveFitArr = this.h;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = (double) c2;
            curveFitArr[0].getSlope(d2, this.o);
            this.h[0].getPos(d2, this.n);
            float f5 = this.u[0];
            while (true) {
                dArr = this.o;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f5);
                i2++;
            }
            CurveFit curveFit = this.i;
            if (curveFit != null) {
                double[] dArr2 = this.n;
                if (dArr2.length > 0) {
                    curveFit.getPos(d2, dArr2);
                    this.i.getSlope(d2, this.o);
                    this.d.f(f3, f4, fArr, this.m, this.o, this.n);
                    return;
                }
                return;
            }
            this.d.f(f3, f4, fArr, this.m, dArr, this.n);
            return;
        }
        c cVar = this.e;
        float f6 = cVar.e;
        c cVar2 = this.d;
        float f7 = f6 - cVar2.e;
        float f8 = cVar.f - cVar2.f;
        fArr[0] = (((cVar.g - cVar2.g) + f7) * f3) + ((1.0f - f3) * f7);
        fArr[1] = (((cVar.h - cVar2.h) + f8) * f4) + ((1.0f - f4) * f8);
    }

    public float e(int i2, float f2, float f3) {
        c cVar = this.e;
        float f4 = cVar.e;
        c cVar2 = this.d;
        float f5 = cVar2.e;
        float f6 = f4 - f5;
        float f7 = cVar.f;
        float f8 = cVar2.f;
        float f9 = f7 - f8;
        float f10 = (cVar2.g / 2.0f) + f5;
        float f11 = (cVar2.h / 2.0f) + f8;
        float hypot = (float) Math.hypot((double) f6, (double) f9);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot((double) f12, (double) f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f13 * f9) + (f12 * f6);
        if (i2 == 0) {
            return f14 / hypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f14 * f14)));
        }
        if (i2 == 2) {
            return f12 / f6;
        }
        if (i2 == 3) {
            return f13 / f6;
        }
        if (i2 == 4) {
            return f12 / f9;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f13 / f9;
    }

    public boolean f(View view, float f2, long j2, KeyCache keyCache) {
        boolean z2;
        TimeCycleSplineSet.d dVar;
        float f3;
        TimeCycleSplineSet.d dVar2;
        float c2 = c(f2, null);
        HashMap<String, SplineSet> hashMap = this.x;
        if (hashMap != null) {
            for (SplineSet splineSet : hashMap.values()) {
                splineSet.setProperty(view, c2);
            }
        }
        HashMap<String, TimeCycleSplineSet> hashMap2 = this.w;
        if (hashMap2 != null) {
            dVar = null;
            z2 = false;
            for (TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.d) {
                    dVar = (TimeCycleSplineSet.d) timeCycleSplineSet;
                } else {
                    z2 |= timeCycleSplineSet.setProperty(view, c2, j2, keyCache);
                }
            }
        } else {
            z2 = false;
            dVar = null;
        }
        CurveFit[] curveFitArr = this.h;
        if (curveFitArr != null) {
            double d2 = (double) c2;
            curveFitArr[0].getPos(d2, this.n);
            this.h[0].getSlope(d2, this.o);
            CurveFit curveFit = this.i;
            if (curveFit != null) {
                double[] dArr = this.n;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                    this.i.getSlope(d2, this.o);
                }
            }
            c cVar = this.d;
            int[] iArr = this.m;
            double[] dArr2 = this.n;
            double[] dArr3 = this.o;
            float f4 = cVar.e;
            float f5 = cVar.f;
            float f6 = cVar.g;
            float f7 = cVar.h;
            if (iArr.length != 0) {
                f3 = f4;
                if (cVar.m.length <= iArr[iArr.length - 1]) {
                    int i2 = iArr[iArr.length - 1] + 1;
                    cVar.m = new double[i2];
                    cVar.n = new double[i2];
                }
            } else {
                f3 = f4;
            }
            float f8 = f6;
            Arrays.fill(cVar.m, Double.NaN);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                cVar.m[iArr[i3]] = dArr2[i3];
                cVar.n[iArr[i3]] = dArr3[i3];
            }
            int i4 = 0;
            float f9 = Float.NaN;
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = f5;
            float f13 = f7;
            float f14 = 0.0f;
            float f15 = 0.0f;
            float f16 = f3;
            while (true) {
                double[] dArr4 = cVar.m;
                if (i4 >= dArr4.length) {
                    break;
                }
                if (!Double.isNaN(dArr4[i4])) {
                    float f17 = (float) (Double.isNaN(cVar.m[i4]) ? 0.0d : cVar.m[i4] + 0.0d);
                    float f18 = (float) cVar.n[i4];
                    if (i4 == 1) {
                        f10 = f18;
                        f16 = f17;
                    } else if (i4 == 2) {
                        f14 = f18;
                        f12 = f17;
                    } else if (i4 == 3) {
                        f11 = f18;
                        f8 = f17;
                    } else if (i4 == 4) {
                        f15 = f18;
                        f13 = f17;
                    } else if (i4 == 5) {
                        f9 = f17;
                    }
                }
                i4++;
            }
            if (Float.isNaN(f9)) {
                if (!Float.isNaN(Float.NaN)) {
                    view.setRotation(Float.NaN);
                }
                dVar2 = dVar;
            } else {
                dVar2 = dVar;
                view.setRotation((float) (Math.toDegrees(Math.atan2((double) ((f15 / 2.0f) + f14), (double) ((f11 / 2.0f) + f10))) + ((double) f9) + ((double) (Float.isNaN(Float.NaN) ? 0.0f : Float.NaN))));
            }
            float f19 = f16 + 0.5f;
            int i5 = (int) f19;
            float f20 = f12 + 0.5f;
            int i6 = (int) f20;
            int i7 = (int) (f19 + f8);
            int i8 = (int) (f20 + f13);
            int i9 = i7 - i5;
            int i10 = i8 - i6;
            if ((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : true) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
            }
            view.layout(i5, i6, i7, i8);
            HashMap<String, SplineSet> hashMap3 = this.x;
            if (hashMap3 != null) {
                for (SplineSet splineSet2 : hashMap3.values()) {
                    if (splineSet2 instanceof SplineSet.d) {
                        double[] dArr5 = this.o;
                        view.setRotation(((SplineSet.d) splineSet2).get(c2) + ((float) Math.toDegrees(Math.atan2(dArr5[1], dArr5[0]))));
                    }
                }
            }
            if (dVar2 != null) {
                double[] dArr6 = this.o;
                view.setRotation(dVar2.get(c2, j2, view, keyCache) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                z2 = dVar2.mContinue | z2;
            }
            int i11 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.h;
                if (i11 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i11].getPos(d2, this.s);
                this.d.k.get(this.p[i11 - 1]).setInterpolatedValue(view, this.s);
                i11++;
            }
            b bVar = this.f;
            if (bVar.b == 0) {
                if (c2 <= 0.0f) {
                    view.setVisibility(bVar.c);
                } else if (c2 >= 1.0f) {
                    view.setVisibility(this.g.c);
                } else if (this.g.c != bVar.c) {
                    view.setVisibility(0);
                }
            }
            if (this.z != null) {
                int i12 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.z;
                    if (i12 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i12].conditionallyFire(c2, view);
                    i12++;
                }
            }
        } else {
            c cVar2 = this.d;
            float f21 = cVar2.e;
            c cVar3 = this.e;
            float b2 = a.b(cVar3.e, f21, c2, f21);
            float f22 = cVar2.f;
            float b3 = a.b(cVar3.f, f22, c2, f22);
            float f23 = cVar2.g;
            float f24 = cVar3.g;
            float b4 = a.b(f24, f23, c2, f23);
            float f25 = cVar2.h;
            float f26 = cVar3.h;
            float f27 = b2 + 0.5f;
            int i13 = (int) f27;
            float f28 = b3 + 0.5f;
            int i14 = (int) f28;
            int i15 = (int) (f27 + b4);
            int b5 = (int) (f28 + a.b(f26, f25, c2, f25));
            int i16 = i15 - i13;
            int i17 = b5 - i14;
            if (!(f24 == f23 && f26 == f25)) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
            }
            view.layout(i13, i14, i15, b5);
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.y;
        if (hashMap4 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.f) {
                    double[] dArr7 = this.o;
                    view.setRotation(((KeyCycleOscillator.f) keyCycleOscillator).get(c2) + ((float) Math.toDegrees(Math.atan2(dArr7[1], dArr7[0]))));
                } else {
                    keyCycleOscillator.setProperty(view, c2);
                }
            }
        }
        return z2;
    }

    public final void g(c cVar) {
        cVar.e((float) ((int) this.a.getX()), (float) ((int) this.a.getY()), (float) this.a.getWidth(), (float) this.a.getHeight());
    }

    public int getDrawPath() {
        int i2 = this.d.b;
        Iterator<c> it = this.t.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().b);
        }
        return Math.max(i2, this.e.b);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.v.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i5 = next.mType;
            if (i5 == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i6 = i4 + 1;
                iArr[i6] = i5;
                int i7 = i6 + 1;
                int i8 = next.a;
                iArr[i7] = i8;
                this.h[0].getPos((double) (((float) i8) / 100.0f), this.n);
                this.d.c(this.m, this.n, fArr, 0);
                int i9 = i7 + 1;
                iArr[i9] = Float.floatToIntBits(fArr[0]);
                int i10 = i9 + 1;
                iArr[i10] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i11 = i10 + 1;
                    iArr[i11] = keyPosition.o;
                    int i12 = i11 + 1;
                    iArr[i12] = Float.floatToIntBits(keyPosition.k);
                    i10 = i12 + 1;
                    iArr[i10] = Float.floatToIntBits(keyPosition.l);
                }
                int i13 = i10 + 1;
                iArr[i4] = i13 - i4;
                i3++;
                i4 = i13;
            }
        }
        return i3;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.v.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i4 = next.a;
            iArr[i2] = (next.mType * 1000) + i4;
            this.h[0].getPos((double) (((float) i4) / 100.0f), this.n);
            this.d.c(this.m, this.n, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    public void setDrawPath(int i2) {
        this.d.b = i2;
    }

    public void setPathMotionArc(int i2) {
        this.A = i2;
    }

    public void setView(View view) {
        this.a = view;
        this.b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void setup(int i2, int i3, float f2, long j2) {
        String str;
        String str2;
        ArrayList arrayList;
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        Object obj;
        Object obj2;
        String str3;
        String str4;
        String str5;
        Object obj3;
        Object obj4;
        Iterator<String> it;
        Object obj5;
        Object obj6;
        Object obj7;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        KeyCycleOscillator.c cVar;
        String str13;
        String str14;
        Object obj8;
        String str15;
        String str16;
        double d2;
        String str17;
        String str18;
        Object obj9;
        String str19;
        char c2;
        KeyCycleOscillator keyCycleOscillator;
        String str20;
        c[] cVarArr;
        int i4;
        String str21;
        String str22;
        double[] dArr;
        double[][] dArr2;
        float[] fArr;
        int[] iArr;
        Object obj10;
        HashSet<String> hashSet3;
        String str23;
        Iterator<String> it2;
        Object obj11;
        TimeCycleSplineSet.b bVar;
        Object obj12;
        char c3;
        Object obj13;
        Object obj14;
        ConstraintAttribute constraintAttribute;
        HashSet<String> hashSet4;
        HashSet<String> hashSet5;
        Iterator<String> it3;
        Object obj15;
        SplineSet.b bVar2;
        Object obj16;
        String str24;
        String str25;
        Object obj17;
        char c4;
        Object obj18;
        SplineSet splineSet;
        ConstraintAttribute constraintAttribute2;
        String str26;
        String str27;
        new HashSet();
        HashSet<String> hashSet6 = new HashSet<>();
        HashSet<String> hashSet7 = new HashSet<>();
        HashSet<String> hashSet8 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i5 = this.A;
        if (i5 != Key.UNSET) {
            this.d.j = i5;
        }
        b bVar3 = this.f;
        b bVar4 = this.g;
        String str28 = "alpha";
        if (bVar3.b(bVar3.a, bVar4.a)) {
            hashSet7.add(str28);
        }
        String str29 = "elevation";
        if (bVar3.b(bVar3.d, bVar4.d)) {
            hashSet7.add(str29);
        }
        int i6 = bVar3.c;
        int i7 = bVar4.c;
        if (i6 != i7 && bVar3.b == 0 && (i6 == 0 || i7 == 0)) {
            hashSet7.add(str28);
        }
        String str30 = "rotation";
        if (bVar3.b(bVar3.e, bVar4.e)) {
            hashSet7.add(str30);
        }
        String str31 = "transitionPathRotate";
        if (!Float.isNaN(bVar3.o) || !Float.isNaN(bVar4.o)) {
            hashSet7.add(str31);
        }
        String str32 = "progress";
        if (!Float.isNaN(bVar3.p) || !Float.isNaN(bVar4.p)) {
            hashSet7.add(str32);
        }
        if (bVar3.b(bVar3.f, bVar4.f)) {
            hashSet7.add("rotationX");
        }
        if (bVar3.b(bVar3.g, bVar4.g)) {
            hashSet7.add("rotationY");
        }
        if (bVar3.b(bVar3.j, bVar4.j)) {
            hashSet7.add("transformPivotX");
        }
        if (bVar3.b(bVar3.k, bVar4.k)) {
            hashSet7.add("transformPivotY");
        }
        String str33 = "scaleX";
        if (bVar3.b(bVar3.h, bVar4.h)) {
            hashSet7.add(str33);
        }
        Object obj19 = "rotationX";
        String str34 = "scaleY";
        if (bVar3.b(bVar3.i, bVar4.i)) {
            hashSet7.add(str34);
        }
        Object obj20 = "rotationY";
        if (bVar3.b(bVar3.l, bVar4.l)) {
            hashSet7.add("translationX");
        }
        Object obj21 = "translationX";
        String str35 = "translationY";
        if (bVar3.b(bVar3.m, bVar4.m)) {
            hashSet7.add(str35);
        }
        boolean b2 = bVar3.b(bVar3.n, bVar4.n);
        String str36 = "translationZ";
        if (b2) {
            hashSet7.add(str36);
        }
        ArrayList<Key> arrayList2 = this.v;
        if (arrayList2 != null) {
            Iterator<Key> it4 = arrayList2.iterator();
            ArrayList arrayList3 = null;
            while (it4.hasNext()) {
                Key next = it4.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    str27 = str35;
                    str26 = str36;
                    c cVar2 = new c(i2, i3, keyPosition, this.d, this.e);
                    this.t.add((-Collections.binarySearch(this.t, cVar2)) - 1, cVar2);
                    int i8 = keyPosition.e;
                    if (i8 != Key.UNSET) {
                        this.c = i8;
                    }
                } else {
                    str26 = str36;
                    str27 = str35;
                    if (next instanceof KeyCycle) {
                        next.getAttributeNames(hashSet8);
                    } else if (next instanceof KeyTimeCycle) {
                        next.getAttributeNames(hashSet6);
                    } else if (next instanceof KeyTrigger) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add((KeyTrigger) next);
                        arrayList3 = arrayList3;
                    } else {
                        next.setInterpolation(hashMap);
                        next.getAttributeNames(hashSet7);
                    }
                }
                it4 = it4;
                str35 = str27;
                str36 = str26;
            }
            str = str36;
            str2 = str35;
            arrayList = arrayList3;
        } else {
            str = str36;
            str2 = str35;
            arrayList = null;
        }
        if (arrayList != null) {
            this.z = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        String str37 = "CUSTOM,";
        if (!hashSet7.isEmpty()) {
            this.x = new HashMap<>();
            Iterator<String> it5 = hashSet7.iterator();
            while (it5.hasNext()) {
                String next2 = it5.next();
                if (next2.startsWith(str37)) {
                    SparseArray sparseArray = new SparseArray();
                    it3 = it5;
                    String str38 = next2.split(",")[1];
                    hashSet5 = hashSet8;
                    for (Iterator<Key> it6 = this.v.iterator(); it6.hasNext(); it6 = it6) {
                        Key next3 = it6.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.d;
                        if (!(hashMap2 == null || (constraintAttribute2 = hashMap2.get(str38)) == null)) {
                            sparseArray.append(next3.a, constraintAttribute2);
                        }
                        hashSet7 = hashSet7;
                    }
                    hashSet4 = hashSet7;
                    bVar2 = new SplineSet.b(next2, sparseArray);
                    obj16 = obj21;
                    str24 = str2;
                    str25 = str;
                    obj15 = obj20;
                } else {
                    hashSet4 = hashSet7;
                    hashSet5 = hashSet8;
                    it3 = it5;
                    switch (next2.hashCode()) {
                        case -1249320806:
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            if (next2.equals(obj18)) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -1249320805:
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            c4 = !next2.equals(obj20) ? (char) 65535 : 1;
                            obj15 = obj20;
                            obj18 = obj19;
                            break;
                        case -1225497657:
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            if (!next2.equals(obj16)) {
                                obj18 = obj19;
                                obj15 = obj20;
                                c4 = 65535;
                                break;
                            } else {
                                obj18 = obj19;
                                obj15 = obj20;
                                c4 = 2;
                                break;
                            }
                        case -1225497656:
                            str24 = str2;
                            str25 = str;
                            if (!next2.equals(str24)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                obj15 = obj20;
                                c4 = 65535;
                                break;
                            } else {
                                obj18 = obj19;
                                obj16 = obj21;
                                obj15 = obj20;
                                c4 = 3;
                                break;
                            }
                        case -1225497655:
                            str25 = str;
                            if (!next2.equals(str25)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                obj15 = obj20;
                                c4 = 65535;
                                break;
                            } else {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                obj15 = obj20;
                                c4 = 4;
                                break;
                            }
                        case -1001078227:
                            if (next2.equals(str32)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 5;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -908189618:
                            if (next2.equals(str33)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 6;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -908189617:
                            if (next2.equals(str34)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 7;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -797520672:
                            if (next2.equals("waveVariesBy")) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = '\b';
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -760884510:
                            if (next2.equals("transformPivotX")) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = '\t';
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -760884509:
                            if (next2.equals("transformPivotY")) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = '\n';
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -40300674:
                            if (next2.equals(str30)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 11;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case -4379043:
                            if (next2.equals(str29)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = '\f';
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case 37232917:
                            if (next2.equals(str31)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = '\r';
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case 92909918:
                            if (next2.equals(str28)) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 14;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        case 156108012:
                            if (next2.equals("waveOffset")) {
                                obj18 = obj19;
                                obj16 = obj21;
                                str24 = str2;
                                str25 = str;
                                obj15 = obj20;
                                c4 = 15;
                                break;
                            }
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                        default:
                            obj18 = obj19;
                            obj16 = obj21;
                            str24 = str2;
                            str25 = str;
                            obj15 = obj20;
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            splineSet = new SplineSet.i();
                            break;
                        case 1:
                            splineSet = new SplineSet.j();
                            break;
                        case 2:
                            splineSet = new SplineSet.m();
                            break;
                        case 3:
                            splineSet = new SplineSet.n();
                            break;
                        case 4:
                            splineSet = new SplineSet.o();
                            break;
                        case 5:
                            splineSet = new SplineSet.g();
                            break;
                        case 6:
                            splineSet = new SplineSet.k();
                            break;
                        case 7:
                            splineSet = new SplineSet.l();
                            break;
                        case '\b':
                            splineSet = new SplineSet.a();
                            break;
                        case '\t':
                            splineSet = new SplineSet.e();
                            break;
                        case '\n':
                            splineSet = new SplineSet.f();
                            break;
                        case 11:
                            splineSet = new SplineSet.h();
                            break;
                        case '\f':
                            splineSet = new SplineSet.c();
                            break;
                        case '\r':
                            splineSet = new SplineSet.d();
                            break;
                        case 14:
                            splineSet = new SplineSet.a();
                            break;
                        case 15:
                            splineSet = new SplineSet.a();
                            break;
                        default:
                            splineSet = null;
                            break;
                    }
                    obj19 = obj18;
                    bVar2 = splineSet;
                }
                if (bVar2 == null) {
                    obj17 = obj16;
                } else {
                    bVar2.setType(next2);
                    obj17 = obj16;
                    this.x.put(next2, bVar2);
                }
                str = str25;
                str2 = str24;
                it5 = it3;
                hashSet8 = hashSet5;
                hashSet7 = hashSet4;
                obj21 = obj17;
                obj20 = obj15;
            }
            hashSet = hashSet7;
            hashSet2 = hashSet8;
            str3 = str2;
            str4 = str;
            obj = obj20;
            obj2 = obj21;
            ArrayList<Key> arrayList4 = this.v;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next4 = it7.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.x);
                    }
                }
            }
            this.f.a(this.x, 0);
            this.g.a(this.x, 100);
            for (Iterator<String> it8 = this.x.keySet().iterator(); it8.hasNext(); it8 = it8) {
                String next5 = it8.next();
                this.x.get(next5).setup(hashMap.containsKey(next5) ? hashMap.get(next5).intValue() : 0);
            }
        } else {
            hashSet = hashSet7;
            hashSet2 = hashSet8;
            str3 = str2;
            str4 = str;
            obj = obj20;
            obj2 = obj21;
        }
        if (!hashSet6.isEmpty()) {
            if (this.w == null) {
                this.w = new HashMap<>();
            }
            Iterator<String> it9 = hashSet6.iterator();
            while (it9.hasNext()) {
                String next6 = it9.next();
                if (!this.w.containsKey(next6)) {
                    if (!next6.startsWith(str37)) {
                        it2 = it9;
                        str23 = str37;
                        switch (next6.hashCode()) {
                            case -1249320806:
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                if (next6.equals(obj13)) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1249320805:
                                obj12 = obj2;
                                obj14 = obj;
                                if (!next6.equals(obj14)) {
                                    obj13 = obj19;
                                    c3 = 65535;
                                    break;
                                } else {
                                    obj13 = obj19;
                                    c3 = 1;
                                    break;
                                }
                            case -1225497657:
                                obj12 = obj2;
                                if (!next6.equals(obj12)) {
                                    obj13 = obj19;
                                    obj14 = obj;
                                    c3 = 65535;
                                    break;
                                } else {
                                    obj13 = obj19;
                                    obj14 = obj;
                                    c3 = 2;
                                    break;
                                }
                            case -1225497656:
                                if (next6.equals(str3)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 3;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -1225497655:
                                if (next6.equals(str4)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 4;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -1001078227:
                                if (next6.equals(str32)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 5;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -908189618:
                                if (next6.equals(str33)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 6;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -908189617:
                                if (next6.equals(str34)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 7;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -40300674:
                                if (next6.equals(str30)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = '\b';
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case -4379043:
                                if (next6.equals(str29)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = '\t';
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case 37232917:
                                if (next6.equals(str31)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = '\n';
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            case 92909918:
                                if (next6.equals(str28)) {
                                    obj13 = obj19;
                                    obj12 = obj2;
                                    obj14 = obj;
                                    c3 = 11;
                                    break;
                                }
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                            default:
                                obj13 = obj19;
                                obj12 = obj2;
                                obj14 = obj;
                                c3 = 65535;
                                break;
                        }
                        switch (c3) {
                            case 0:
                                bVar = new TimeCycleSplineSet.g();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 1:
                                bVar = new TimeCycleSplineSet.h();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 2:
                                bVar = new TimeCycleSplineSet.k();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 3:
                                bVar = new TimeCycleSplineSet.l();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 4:
                                bVar = new TimeCycleSplineSet.m();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 5:
                                bVar = new TimeCycleSplineSet.e();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 6:
                                bVar = new TimeCycleSplineSet.i();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 7:
                                bVar = new TimeCycleSplineSet.j();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case '\b':
                                bVar = new TimeCycleSplineSet.f();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case '\t':
                                bVar = new TimeCycleSplineSet.c();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case '\n':
                                bVar = new TimeCycleSplineSet.d();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            case 11:
                                bVar = new TimeCycleSplineSet.a();
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar.setStartTime(j2);
                                break;
                            default:
                                obj11 = obj14;
                                obj19 = obj13;
                                bVar = null;
                                break;
                        }
                    } else {
                        SparseArray sparseArray2 = new SparseArray();
                        String str39 = next6.split(",")[1];
                        it2 = it9;
                        for (Iterator<Key> it10 = this.v.iterator(); it10.hasNext(); it10 = it10) {
                            Key next7 = it10.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next7.d;
                            if (!(hashMap3 == null || (constraintAttribute = hashMap3.get(str39)) == null)) {
                                sparseArray2.append(next7.a, constraintAttribute);
                            }
                            str37 = str37;
                        }
                        str23 = str37;
                        bVar = new TimeCycleSplineSet.b(next6, sparseArray2);
                        obj12 = obj2;
                        obj11 = obj;
                    }
                    if (bVar != null) {
                        bVar.setType(next6);
                        this.w.put(next6, bVar);
                    }
                    obj = obj11;
                    str37 = str23;
                    obj2 = obj12;
                    it9 = it2;
                }
            }
            str5 = str37;
            obj4 = obj2;
            obj3 = obj;
            ArrayList<Key> arrayList5 = this.v;
            if (arrayList5 != null) {
                Iterator<Key> it11 = arrayList5.iterator();
                while (it11.hasNext()) {
                    Key next8 = it11.next();
                    if (next8 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next8).addTimeValues(this.w);
                    }
                }
            }
            for (String str40 : this.w.keySet()) {
                this.w.get(str40).setup(hashMap.containsKey(str40) ? hashMap.get(str40).intValue() : 0);
            }
        } else {
            str5 = str37;
            obj4 = obj2;
            obj3 = obj;
        }
        int size = this.t.size() + 2;
        c[] cVarArr2 = new c[size];
        cVarArr2[0] = this.d;
        cVarArr2[size - 1] = this.e;
        if (this.t.size() > 0 && this.c == -1) {
            this.c = 0;
        }
        Iterator<c> it12 = this.t.iterator();
        int i9 = 1;
        while (it12.hasNext()) {
            cVarArr2[i9] = it12.next();
            i9++;
        }
        HashSet hashSet9 = new HashSet();
        Iterator<String> it13 = this.e.k.keySet().iterator();
        while (it13.hasNext()) {
            String next9 = it13.next();
            if (this.d.k.containsKey(next9)) {
                StringBuilder sb = new StringBuilder();
                obj10 = obj4;
                sb.append(str5);
                sb.append(next9);
                hashSet3 = hashSet;
                if (!hashSet3.contains(sb.toString())) {
                    hashSet9.add(next9);
                }
            } else {
                obj10 = obj4;
                hashSet3 = hashSet;
            }
            it13 = it13;
            hashSet = hashSet3;
            obj4 = obj10;
        }
        Object obj22 = obj4;
        String[] strArr = (String[]) hashSet9.toArray(new String[0]);
        this.p = strArr;
        this.q = new int[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.p;
            if (i10 < strArr2.length) {
                String str41 = strArr2[i10];
                this.q[i10] = 0;
                int i11 = 0;
                while (true) {
                    if (i11 < size) {
                        if (cVarArr2[i11].k.containsKey(str41)) {
                            int[] iArr2 = this.q;
                            iArr2[i10] = cVarArr2[i11].k.get(str41).noOfInterpValues() + iArr2[i10];
                        } else {
                            i11++;
                        }
                    }
                }
                i10++;
            } else {
                boolean z2 = cVarArr2[0].j != Key.UNSET;
                int length = strArr2.length + 18;
                boolean[] zArr = new boolean[length];
                int i12 = 1;
                while (i12 < size) {
                    c cVar3 = cVarArr2[i12];
                    c cVar4 = cVarArr2[i12 - 1];
                    Objects.requireNonNull(cVar3);
                    zArr[0] = zArr[0] | cVar3.b(cVar3.d, cVar4.d);
                    zArr[1] = zArr[1] | cVar3.b(cVar3.e, cVar4.e) | z2;
                    zArr[2] = zArr[2] | cVar3.b(cVar3.f, cVar4.f) | z2;
                    zArr[3] = zArr[3] | cVar3.b(cVar3.g, cVar4.g);
                    zArr[4] = cVar3.b(cVar3.h, cVar4.h) | zArr[4];
                    i12++;
                    str34 = str34;
                    str32 = str32;
                    str33 = str33;
                    str3 = str3;
                    str4 = str4;
                }
                String str42 = str4;
                String str43 = str3;
                String str44 = str32;
                String str45 = str34;
                String str46 = str33;
                int i13 = 0;
                for (int i14 = 1; i14 < length; i14++) {
                    if (zArr[i14]) {
                        i13++;
                    }
                }
                int[] iArr3 = new int[i13];
                this.m = iArr3;
                this.n = new double[iArr3.length];
                this.o = new double[iArr3.length];
                int i15 = 0;
                for (int i16 = 1; i16 < length; i16++) {
                    if (zArr[i16]) {
                        this.m[i15] = i16;
                        i15++;
                    }
                }
                int[] iArr4 = new int[2];
                iArr4[1] = this.m.length;
                iArr4[0] = size;
                double[][] dArr3 = (double[][]) Array.newInstance(double.class, iArr4);
                double[] dArr4 = new double[size];
                for (int i17 = 0; i17 < size; i17++) {
                    c cVar5 = cVarArr2[i17];
                    double[] dArr5 = dArr3[i17];
                    int[] iArr5 = this.m;
                    float[] fArr2 = {cVar5.d, cVar5.e, cVar5.f, cVar5.g, cVar5.h, cVar5.i};
                    int i18 = 0;
                    int i19 = 0;
                    while (i18 < iArr5.length) {
                        if (iArr5[i18] < 6) {
                            iArr = iArr5;
                            fArr = fArr2;
                            dArr5[i19] = (double) fArr2[iArr5[i18]];
                            i19++;
                        } else {
                            iArr = iArr5;
                            fArr = fArr2;
                        }
                        i18++;
                        iArr5 = iArr;
                        fArr2 = fArr;
                    }
                    dArr4[i17] = (double) cVarArr2[i17].c;
                }
                int i20 = 0;
                while (true) {
                    int[] iArr6 = this.m;
                    if (i20 < iArr6.length) {
                        if (iArr6[i20] < c.o.length) {
                            String t2 = a.t(new StringBuilder(), c.o[this.m[i20]], " [");
                            for (int i21 = 0; i21 < size; i21++) {
                                StringBuilder L = a.L(t2);
                                L.append(dArr3[i21][i20]);
                                t2 = L.toString();
                            }
                        }
                        i20++;
                    } else {
                        this.h = new CurveFit[(this.p.length + 1)];
                        int i22 = 0;
                        while (true) {
                            String[] strArr3 = this.p;
                            if (i22 < strArr3.length) {
                                String str47 = strArr3[i22];
                                int i23 = 0;
                                int i24 = 0;
                                double[] dArr6 = null;
                                double[][] dArr7 = null;
                                while (i23 < size) {
                                    if (cVarArr2[i23].k.containsKey(str47)) {
                                        if (dArr7 == null) {
                                            dArr6 = new double[size];
                                            int[] iArr7 = new int[2];
                                            iArr7[1] = cVarArr2[i23].k.get(str47).noOfInterpValues();
                                            iArr7[0] = size;
                                            dArr7 = (double[][]) Array.newInstance(double.class, iArr7);
                                        }
                                        str22 = str29;
                                        str21 = str30;
                                        dArr6[i24] = (double) cVarArr2[i23].c;
                                        c cVar6 = cVarArr2[i23];
                                        double[] dArr8 = dArr7[i24];
                                        ConstraintAttribute constraintAttribute3 = cVar6.k.get(str47);
                                        str20 = str47;
                                        if (constraintAttribute3.noOfInterpValues() == 1) {
                                            dArr = dArr6;
                                            dArr2 = dArr7;
                                            dArr8[0] = (double) constraintAttribute3.getValueToInterpolate();
                                        } else {
                                            dArr = dArr6;
                                            dArr2 = dArr7;
                                            int noOfInterpValues = constraintAttribute3.noOfInterpValues();
                                            float[] fArr3 = new float[noOfInterpValues];
                                            constraintAttribute3.getValuesToInterpolate(fArr3);
                                            int i25 = 0;
                                            int i26 = 0;
                                            while (i25 < noOfInterpValues) {
                                                dArr8[i26] = (double) fArr3[i25];
                                                i25++;
                                                noOfInterpValues = noOfInterpValues;
                                                i26++;
                                                size = size;
                                                cVarArr2 = cVarArr2;
                                            }
                                        }
                                        i4 = size;
                                        cVarArr = cVarArr2;
                                        i24++;
                                        dArr6 = dArr;
                                        dArr7 = dArr2;
                                    } else {
                                        i4 = size;
                                        cVarArr = cVarArr2;
                                        str20 = str47;
                                        str22 = str29;
                                        str21 = str30;
                                    }
                                    i23++;
                                    str47 = str20;
                                    str29 = str22;
                                    str30 = str21;
                                    size = i4;
                                    cVarArr2 = cVarArr;
                                }
                                i22++;
                                this.h[i22] = CurveFit.get(this.c, Arrays.copyOf(dArr6, i24), (double[][]) Arrays.copyOf(dArr7, i24));
                                size = size;
                                cVarArr2 = cVarArr2;
                            } else {
                                String str48 = str29;
                                String str49 = str30;
                                this.h[0] = CurveFit.get(this.c, dArr4, dArr3);
                                if (cVarArr2[0].j != Key.UNSET) {
                                    int[] iArr8 = new int[size];
                                    double[] dArr9 = new double[size];
                                    int[] iArr9 = new int[2];
                                    iArr9[1] = 2;
                                    iArr9[0] = size;
                                    double[][] dArr10 = (double[][]) Array.newInstance(double.class, iArr9);
                                    for (int i27 = 0; i27 < size; i27++) {
                                        iArr8[i27] = cVarArr2[i27].j;
                                        dArr9[i27] = (double) cVarArr2[i27].c;
                                        dArr10[i27][0] = (double) cVarArr2[i27].e;
                                        dArr10[i27][1] = (double) cVarArr2[i27].f;
                                    }
                                    this.i = CurveFit.getArc(iArr8, dArr9, dArr10);
                                }
                                float f3 = Float.NaN;
                                this.y = new HashMap<>();
                                if (this.v != null) {
                                    Iterator<String> it14 = hashSet2.iterator();
                                    while (it14.hasNext()) {
                                        String next10 = it14.next();
                                        if (!next10.startsWith("CUSTOM")) {
                                            switch (next10.hashCode()) {
                                                case -1249320806:
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    if (next10.equals(obj5)) {
                                                        c2 = 0;
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case -1249320805:
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    if (!next10.equals(obj6)) {
                                                        obj5 = obj19;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        c2 = 1;
                                                        break;
                                                    }
                                                case -1225497657:
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    if (!next10.equals(obj7)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        c2 = 2;
                                                        break;
                                                    }
                                                case -1225497656:
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    if (!next10.equals(str6)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        c2 = 3;
                                                        break;
                                                    }
                                                case -1225497655:
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str7 = str42;
                                                    if (!next10.equals(str7)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str6 = str43;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str6 = str43;
                                                        c2 = 4;
                                                        break;
                                                    }
                                                case -1001078227:
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    if (next10.equals(str8)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 5;
                                                        break;
                                                    }
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case -908189618:
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str9 = str46;
                                                    if (!next10.equals(str9)) {
                                                        str8 = str44;
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str8 = str44;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 6;
                                                        break;
                                                    }
                                                case -908189617:
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    if (next10.equals(str10)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 7;
                                                        break;
                                                    }
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case -797520672:
                                                    str12 = str48;
                                                    str11 = str49;
                                                    if (next10.equals("waveVariesBy")) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str10 = str45;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = '\b';
                                                        break;
                                                    }
                                                    str10 = str45;
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case -40300674:
                                                    str12 = str48;
                                                    str11 = str49;
                                                    if (next10.equals(str11)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str10 = str45;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = '\t';
                                                        break;
                                                    }
                                                    str10 = str45;
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case -4379043:
                                                    str12 = str48;
                                                    if (next10.equals(str12)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str10 = str45;
                                                        str11 = str49;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = '\n';
                                                        break;
                                                    }
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case 37232917:
                                                    if (!next10.equals(str31)) {
                                                        str12 = str48;
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str10 = str45;
                                                        str11 = str49;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 65535;
                                                        break;
                                                    } else {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str12 = str48;
                                                        str10 = str45;
                                                        str11 = str49;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = 11;
                                                        break;
                                                    }
                                                case 92909918:
                                                    if (next10.equals(str28)) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str12 = str48;
                                                        str10 = str45;
                                                        str11 = str49;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = '\f';
                                                        break;
                                                    }
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                case 156108012:
                                                    if (next10.equals("waveOffset")) {
                                                        obj5 = obj19;
                                                        obj6 = obj3;
                                                        obj7 = obj22;
                                                        str12 = str48;
                                                        str10 = str45;
                                                        str11 = str49;
                                                        str8 = str44;
                                                        str9 = str46;
                                                        str6 = str43;
                                                        str7 = str42;
                                                        c2 = '\r';
                                                        break;
                                                    }
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                                default:
                                                    obj5 = obj19;
                                                    obj6 = obj3;
                                                    obj7 = obj22;
                                                    str12 = str48;
                                                    str10 = str45;
                                                    str11 = str49;
                                                    str8 = str44;
                                                    str9 = str46;
                                                    str6 = str43;
                                                    str7 = str42;
                                                    c2 = 65535;
                                                    break;
                                            }
                                            switch (c2) {
                                                case 0:
                                                    keyCycleOscillator = new KeyCycleOscillator.i();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 1:
                                                    keyCycleOscillator = new KeyCycleOscillator.j();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 2:
                                                    keyCycleOscillator = new KeyCycleOscillator.m();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 3:
                                                    keyCycleOscillator = new KeyCycleOscillator.n();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 4:
                                                    keyCycleOscillator = new KeyCycleOscillator.o();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 5:
                                                    keyCycleOscillator = new KeyCycleOscillator.g();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 6:
                                                    keyCycleOscillator = new KeyCycleOscillator.k();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 7:
                                                    keyCycleOscillator = new KeyCycleOscillator.l();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case '\b':
                                                    keyCycleOscillator = new KeyCycleOscillator.b();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case '\t':
                                                    keyCycleOscillator = new KeyCycleOscillator.h();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case '\n':
                                                    keyCycleOscillator = new KeyCycleOscillator.e();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case 11:
                                                    keyCycleOscillator = new KeyCycleOscillator.f();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case '\f':
                                                    keyCycleOscillator = new KeyCycleOscillator.b();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                case '\r':
                                                    keyCycleOscillator = new KeyCycleOscillator.b();
                                                    it = it14;
                                                    cVar = keyCycleOscillator;
                                                    break;
                                                default:
                                                    it = it14;
                                                    cVar = null;
                                                    break;
                                            }
                                        } else {
                                            obj5 = obj19;
                                            it = it14;
                                            cVar = new KeyCycleOscillator.c();
                                            obj6 = obj3;
                                            obj7 = obj22;
                                            str12 = str48;
                                            str10 = str45;
                                            str11 = str49;
                                            str8 = str44;
                                            str9 = str46;
                                            str6 = str43;
                                            str7 = str42;
                                        }
                                        if (cVar == null) {
                                            it14 = it;
                                            str48 = str12;
                                            str49 = str11;
                                            str45 = str10;
                                            str46 = str9;
                                            str44 = str8;
                                            str42 = str7;
                                            str43 = str6;
                                            obj22 = obj7;
                                            obj3 = obj6;
                                        } else {
                                            if (!cVar.variesByPath() || !Float.isNaN(f3)) {
                                                str48 = str12;
                                                str49 = str11;
                                                str45 = str10;
                                                str15 = str9;
                                                str13 = str28;
                                                str14 = str8;
                                                str42 = str7;
                                                str16 = str31;
                                                str43 = str6;
                                                obj8 = obj7;
                                            } else {
                                                float[] fArr4 = new float[2];
                                                str48 = str12;
                                                float f4 = 1.0f / ((float) 99);
                                                float f5 = 0.0f;
                                                str45 = str10;
                                                double d3 = 0.0d;
                                                double d4 = 0.0d;
                                                str49 = str11;
                                                int i28 = 0;
                                                while (i28 < 100) {
                                                    float f6 = ((float) i28) * f4;
                                                    double d5 = (double) f6;
                                                    Easing easing = this.d.a;
                                                    Iterator<c> it15 = this.t.iterator();
                                                    float f7 = Float.NaN;
                                                    float f8 = 0.0f;
                                                    while (it15.hasNext()) {
                                                        c next11 = it15.next();
                                                        Easing easing2 = next11.a;
                                                        if (easing2 != null) {
                                                            float f9 = next11.c;
                                                            if (f9 < f6) {
                                                                easing = easing2;
                                                                f8 = f9;
                                                            } else if (Float.isNaN(f7)) {
                                                                f7 = next11.c;
                                                            }
                                                        }
                                                        it15 = it15;
                                                        str8 = str8;
                                                    }
                                                    if (easing != null) {
                                                        if (Float.isNaN(f7)) {
                                                            f7 = 1.0f;
                                                        }
                                                        float f10 = f7 - f8;
                                                        d2 = (double) ((((float) easing.get((double) ((f6 - f8) / f10))) * f10) + f8);
                                                    } else {
                                                        d2 = d5;
                                                    }
                                                    this.h[0].getPos(d2, this.n);
                                                    this.d.c(this.m, this.n, fArr4, 0);
                                                    if (i28 > 0) {
                                                        str17 = str7;
                                                        str19 = str31;
                                                        str18 = str6;
                                                        obj9 = obj7;
                                                        f5 = (float) (Math.hypot(d3 - ((double) fArr4[1]), d4 - ((double) fArr4[0])) + ((double) f5));
                                                    } else {
                                                        str17 = str7;
                                                        str19 = str31;
                                                        str18 = str6;
                                                        obj9 = obj7;
                                                    }
                                                    i28++;
                                                    d4 = (double) fArr4[0];
                                                    str31 = str19;
                                                    d3 = (double) fArr4[1];
                                                    str9 = str9;
                                                    obj7 = obj9;
                                                    str6 = str18;
                                                    str7 = str17;
                                                    str8 = str8;
                                                    str28 = str28;
                                                }
                                                str15 = str9;
                                                str13 = str28;
                                                str14 = str8;
                                                str42 = str7;
                                                str16 = str31;
                                                str43 = str6;
                                                obj8 = obj7;
                                                f3 = f5;
                                            }
                                            cVar.setType(next10);
                                            this.y.put(next10, cVar);
                                            it14 = it;
                                            str31 = str16;
                                            obj3 = obj6;
                                            str46 = str15;
                                            obj22 = obj8;
                                            str44 = str14;
                                            str28 = str13;
                                        }
                                        obj19 = obj5;
                                    }
                                    Iterator<Key> it16 = this.v.iterator();
                                    while (it16.hasNext()) {
                                        Key next12 = it16.next();
                                        if (next12 instanceof KeyCycle) {
                                            ((KeyCycle) next12).addCycleValues(this.y);
                                        }
                                    }
                                    for (KeyCycleOscillator keyCycleOscillator2 : this.y.values()) {
                                        keyCycleOscillator2.setup(f3);
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder L = a.L(" start: x: ");
        L.append(this.d.e);
        L.append(" y: ");
        L.append(this.d.f);
        L.append(" end: x: ");
        L.append(this.e.e);
        L.append(" y: ");
        L.append(this.e.f);
        return L.toString();
    }
}
