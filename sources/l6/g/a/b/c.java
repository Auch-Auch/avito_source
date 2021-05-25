package l6.g.a.b;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import java.util.LinkedHashMap;
public class c implements Comparable<c> {
    public static String[] o = {VKApiConst.POSITION, "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};
    public Easing a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public LinkedHashMap<String, ConstraintAttribute> k;
    public int l;
    public double[] m;
    public double[] n;

    public c() {
        this.b = 0;
        this.i = Float.NaN;
        this.j = Key.UNSET;
        this.k = new LinkedHashMap<>();
        this.l = 0;
        this.m = new double[18];
        this.n = new double[18];
    }

    public void a(ConstraintSet.Constraint constraint) {
        this.a = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.j = motion.mPathMotionArc;
        this.i = motion.mPathRotate;
        this.b = motion.mDrawPath;
        float f2 = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.k.put(str, constraintAttribute);
            }
        }
    }

    public final boolean b(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (Float.isNaN(f2) != Float.isNaN(f3)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f3) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void c(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.e;
        float f3 = this.f;
        float f4 = this.g;
        float f5 = this.h;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        fArr[i2] = (f4 / 2.0f) + f2 + 0.0f;
        fArr[i2 + 1] = (f5 / 2.0f) + f3 + 0.0f;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull c cVar) {
        return Float.compare(this.d, cVar.d);
    }

    public void d(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.e;
        float f3 = this.f;
        float f4 = this.g;
        float f5 = this.h;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i5 = i2 + 1;
        fArr[i2] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f3 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f7 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f3 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f8 + 0.0f;
        fArr[i10] = f2 + 0.0f;
        fArr[i10 + 1] = f8 + 0.0f;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = f5;
    }

    public void f(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (((f5 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
        fArr[1] = (((f7 * 1.0f) + f10) * f3) + ((1.0f - f3) * f10) + 0.0f;
    }

    public c(int i2, int i3, KeyPosition keyPosition, c cVar, c cVar2) {
        float f2;
        int i4;
        this.b = 0;
        this.i = Float.NaN;
        this.j = Key.UNSET;
        this.k = new LinkedHashMap<>();
        this.l = 0;
        this.m = new double[18];
        this.n = new double[18];
        int i5 = keyPosition.o;
        if (i5 == 1) {
            float f3 = ((float) keyPosition.a) / 100.0f;
            this.c = f3;
            this.b = keyPosition.h;
            float f4 = Float.isNaN(keyPosition.i) ? f3 : keyPosition.i;
            float f5 = Float.isNaN(keyPosition.j) ? f3 : keyPosition.j;
            float f6 = cVar2.g - cVar.g;
            float f7 = cVar2.h - cVar.h;
            this.d = this.c;
            f3 = !Float.isNaN(keyPosition.k) ? keyPosition.k : f3;
            float f8 = cVar.e;
            float f9 = cVar.g;
            float f10 = cVar.f;
            float f11 = cVar.h;
            float f12 = ((cVar2.g / 2.0f) + cVar2.e) - ((f9 / 2.0f) + f8);
            float f13 = ((cVar2.h / 2.0f) + cVar2.f) - ((f11 / 2.0f) + f10);
            float f14 = f12 * f3;
            float f15 = f6 * f4;
            float f16 = f15 / 2.0f;
            this.e = (float) ((int) ((f8 + f14) - f16));
            float f17 = f3 * f13;
            float f18 = f7 * f5;
            float f19 = f18 / 2.0f;
            this.f = (float) ((int) ((f10 + f17) - f19));
            this.g = (float) ((int) (f9 + f15));
            this.h = (float) ((int) (f11 + f18));
            float f20 = Float.isNaN(keyPosition.l) ? 0.0f : keyPosition.l;
            this.l = 1;
            float f21 = (float) ((int) ((cVar.e + f14) - f16));
            this.e = f21;
            float f22 = (float) ((int) ((cVar.f + f17) - f19));
            this.f = f22;
            this.e = f21 + ((-f13) * f20);
            this.f = f22 + (f12 * f20);
            this.a = Easing.getInterpolator(keyPosition.f);
            this.j = keyPosition.g;
        } else if (i5 != 2) {
            float f23 = ((float) keyPosition.a) / 100.0f;
            this.c = f23;
            this.b = keyPosition.h;
            float f24 = Float.isNaN(keyPosition.i) ? f23 : keyPosition.i;
            float f25 = Float.isNaN(keyPosition.j) ? f23 : keyPosition.j;
            float f26 = cVar2.g;
            float f27 = cVar.g;
            float f28 = f26 - f27;
            float f29 = cVar2.h;
            float f30 = cVar.h;
            float f31 = f29 - f30;
            this.d = this.c;
            float f32 = cVar.e;
            float f33 = cVar.f;
            float f34 = ((f26 / 2.0f) + cVar2.e) - ((f27 / 2.0f) + f32);
            float f35 = ((f29 / 2.0f) + cVar2.f) - ((f30 / 2.0f) + f33);
            float f36 = f28 * f24;
            float f37 = f36 / 2.0f;
            this.e = (float) ((int) (((f34 * f23) + f32) - f37));
            float f38 = (f35 * f23) + f33;
            float f39 = f31 * f25;
            float f40 = f39 / 2.0f;
            this.f = (float) ((int) (f38 - f40));
            this.g = (float) ((int) (f27 + f36));
            this.h = (float) ((int) (f30 + f39));
            float f41 = Float.isNaN(keyPosition.k) ? f23 : keyPosition.k;
            float f42 = Float.isNaN(keyPosition.n) ? 0.0f : keyPosition.n;
            f23 = !Float.isNaN(keyPosition.l) ? keyPosition.l : f23;
            if (Float.isNaN(keyPosition.m)) {
                i4 = 2;
                f2 = 0.0f;
            } else {
                f2 = keyPosition.m;
                i4 = 2;
            }
            this.l = i4;
            this.e = (float) ((int) (((f2 * f35) + ((f41 * f34) + cVar.e)) - f37));
            this.f = (float) ((int) (((f35 * f23) + ((f34 * f42) + cVar.f)) - f40));
            this.a = Easing.getInterpolator(keyPosition.f);
            this.j = keyPosition.g;
        } else {
            float f43 = ((float) keyPosition.a) / 100.0f;
            this.c = f43;
            this.b = keyPosition.h;
            float f44 = Float.isNaN(keyPosition.i) ? f43 : keyPosition.i;
            float f45 = Float.isNaN(keyPosition.j) ? f43 : keyPosition.j;
            float f46 = cVar2.g;
            float f47 = cVar.g;
            float f48 = f46 - f47;
            float f49 = cVar2.h;
            float f50 = cVar.h;
            float f51 = f49 - f50;
            this.d = this.c;
            float f52 = cVar.e;
            float f53 = cVar.f;
            float f54 = (f46 / 2.0f) + cVar2.e;
            float f55 = (f49 / 2.0f) + cVar2.f;
            float f56 = f48 * f44;
            this.e = (float) ((int) ((((f54 - ((f47 / 2.0f) + f52)) * f43) + f52) - (f56 / 2.0f)));
            float f57 = f51 * f45;
            this.f = (float) ((int) ((((f55 - ((f50 / 2.0f) + f53)) * f43) + f53) - (f57 / 2.0f)));
            this.g = (float) ((int) (f47 + f56));
            this.h = (float) ((int) (f50 + f57));
            this.l = 3;
            if (!Float.isNaN(keyPosition.k)) {
                this.e = (float) ((int) (keyPosition.k * ((float) ((int) (((float) i2) - this.g)))));
            }
            if (!Float.isNaN(keyPosition.l)) {
                this.f = (float) ((int) (keyPosition.l * ((float) ((int) (((float) i3) - this.h)))));
            }
            this.a = Easing.getInterpolator(keyPosition.f);
            this.j = keyPosition.g;
        }
    }
}
