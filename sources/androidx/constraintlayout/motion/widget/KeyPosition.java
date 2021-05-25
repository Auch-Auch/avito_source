package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
public class KeyPosition extends l6.g.a.b.a {
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public String f = null;
    public int g = Key.UNSET;
    public int h = 0;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public int o = 0;
    public float p = Float.NaN;
    public float q = Float.NaN;

    public static class a {
        public static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            a.append(R.styleable.KeyPosition_framePosition, 2);
            a.append(R.styleable.KeyPosition_transitionEasing, 3);
            a.append(R.styleable.KeyPosition_curveFit, 4);
            a.append(R.styleable.KeyPosition_drawPath, 5);
            a.append(R.styleable.KeyPosition_percentX, 6);
            a.append(R.styleable.KeyPosition_percentY, 7);
            a.append(R.styleable.KeyPosition_keyPositionType, 9);
            a.append(R.styleable.KeyPosition_sizePercent, 8);
            a.append(R.styleable.KeyPosition_percentWidth, 11);
            a.append(R.styleable.KeyPosition_percentHeight, 12);
            a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // l6.g.a.b.a
    public boolean intersects(int i2, int i3, RectF rectF, RectF rectF2, float f2, float f3) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX();
        float centerY2 = rectF2.centerY();
        int i4 = this.o;
        if (i4 == 1) {
            float f4 = centerX2 - centerX;
            float f5 = centerY2 - centerY;
            float f6 = this.k;
            float f7 = (f4 * f6) + centerX;
            float f8 = this.l;
            this.p = ((-f5) * f8) + f7;
            this.q = (f4 * f8) + (f5 * f6) + centerY;
        } else if (i4 != 2) {
            float f9 = centerX2 - centerX;
            float f10 = centerY2 - centerY;
            float f11 = 0.0f;
            float f12 = Float.isNaN(this.k) ? 0.0f : this.k;
            float f13 = Float.isNaN(this.n) ? 0.0f : this.n;
            float f14 = Float.isNaN(this.l) ? 0.0f : this.l;
            if (!Float.isNaN(this.m)) {
                f11 = this.m;
            }
            this.p = (float) ((int) ((f11 * f10) + (f12 * f9) + centerX));
            this.q = (float) ((int) ((f10 * f14) + (f9 * f13) + centerY));
        } else {
            float f15 = this.k;
            float f16 = (float) 0;
            this.p = (((float) (i2 - 0)) * f15) + f16;
            this.q = (((float) (i3 - 0)) * f15) + f16;
        }
        return Math.abs(f2 - this.p) < 20.0f && Math.abs(f3 - this.q) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            switch (a.a.get(index)) {
                case 1:
                    if (!MotionLayout.IS_IN_EDIT_MODE) {
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.b = obtainStyledAttributes.getResourceId(index, this.b);
                            break;
                        }
                    } else {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.b);
                        this.b = resourceId;
                        if (resourceId == -1) {
                            this.c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    }
                case 2:
                    this.a = obtainStyledAttributes.getInt(index, this.a);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                    break;
                case 5:
                    this.h = obtainStyledAttributes.getInt(index, this.h);
                    break;
                case 6:
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                    break;
                case 7:
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    break;
                case 8:
                    float f2 = obtainStyledAttributes.getFloat(index, this.j);
                    this.i = f2;
                    this.j = f2;
                    break;
                case 9:
                    this.o = obtainStyledAttributes.getInt(index, this.o);
                    break;
                case 10:
                    this.g = obtainStyledAttributes.getInt(index, this.g);
                    break;
                case 11:
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                    break;
                case 12:
                    this.j = obtainStyledAttributes.getFloat(index, this.j);
                    break;
                default:
                    Integer.toHexString(index);
                    a.a.get(index);
                    break;
            }
        }
    }

    @Override // l6.g.a.b.a
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        int i2 = this.o;
        if (i2 == 1) {
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float centerX2 = rectF2.centerX() - centerX;
            float centerY2 = rectF2.centerY() - centerY;
            float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
            if (((double) hypot) < 1.0E-4d) {
                System.out.println("distance ~ 0");
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                return;
            }
            float f4 = centerX2 / hypot;
            float f5 = centerY2 / hypot;
            float f6 = f3 - centerY;
            float f7 = f2 - centerX;
            float f8 = ((f4 * f6) - (f7 * f5)) / hypot;
            float f9 = ((f5 * f6) + (f4 * f7)) / hypot;
            if (strArr[0] == null) {
                strArr[0] = "percentX";
                strArr[1] = "percentY";
                fArr[0] = f9;
                fArr[1] = f8;
            } else if ("percentX".equals(strArr[0])) {
                fArr[0] = f9;
                fArr[1] = f8;
            }
        } else if (i2 != 2) {
            float centerX3 = rectF.centerX();
            float centerY3 = rectF.centerY();
            float centerX4 = rectF2.centerX() - centerX3;
            float centerY4 = rectF2.centerY() - centerY3;
            if (strArr[0] == null) {
                strArr[0] = "percentX";
                fArr[0] = (f2 - centerX3) / centerX4;
                strArr[1] = "percentY";
                fArr[1] = (f3 - centerY3) / centerY4;
            } else if ("percentX".equals(strArr[0])) {
                fArr[0] = (f2 - centerX3) / centerX4;
                fArr[1] = (f3 - centerY3) / centerY4;
            } else {
                fArr[1] = (f2 - centerX3) / centerX4;
                fArr[0] = (f3 - centerY3) / centerY4;
            }
        } else {
            rectF.centerX();
            rectF.centerY();
            rectF2.centerX();
            rectF2.centerY();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            if (strArr[0] == null) {
                strArr[0] = "percentX";
                fArr[0] = f2 / ((float) width);
                strArr[1] = "percentY";
                fArr[1] = f3 / ((float) height);
            } else if ("percentX".equals(strArr[0])) {
                fArr[0] = f2 / ((float) width);
                fArr[1] = f3 / ((float) height);
            } else {
                fArr[1] = f2 / ((float) width);
                fArr[0] = f3 / ((float) height);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f = obj.toString();
                return;
            case 1:
                this.i = a(obj);
                return;
            case 2:
                this.j = a(obj);
                return;
            case 3:
                this.h = b(obj);
                return;
            case 4:
                float a3 = a(obj);
                this.i = a3;
                this.j = a3;
                return;
            case 5:
                this.k = a(obj);
                return;
            case 6:
                this.l = a(obj);
                return;
            default:
                return;
        }
    }
}
