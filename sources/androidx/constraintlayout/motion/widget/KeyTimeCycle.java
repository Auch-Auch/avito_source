package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public int e = -1;
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public int r = 0;
    public float s = Float.NaN;
    public float t = 0.0f;

    public static class a {
        public static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.d = new HashMap<>();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r1.equals("scaleY") == false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r12) {
        /*
        // Method dump skipped, instructions count: 602
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("progress");
        }
        if (this.d.size() > 0) {
            Iterator<String> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            switch (a.a.get(index)) {
                case 1:
                    this.f = obtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 2:
                    this.g = obtainStyledAttributes.getDimension(index, this.g);
                    break;
                case 3:
                case 11:
                default:
                    Integer.toHexString(index);
                    a.a.get(index);
                    break;
                case 4:
                    this.h = obtainStyledAttributes.getFloat(index, this.h);
                    break;
                case 5:
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                    break;
                case 6:
                    this.j = obtainStyledAttributes.getFloat(index, this.j);
                    break;
                case 7:
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    break;
                case 8:
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                    break;
                case 9:
                    obtainStyledAttributes.getString(index);
                    break;
                case 10:
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
                case 12:
                    this.a = obtainStyledAttributes.getInt(index, this.a);
                    break;
                case 13:
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                    break;
                case 14:
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
                    break;
                case 15:
                    this.n = obtainStyledAttributes.getDimension(index, this.n);
                    break;
                case 16:
                    this.o = obtainStyledAttributes.getDimension(index, this.o);
                    break;
                case 17:
                    this.p = obtainStyledAttributes.getDimension(index, this.p);
                    break;
                case 18:
                    this.q = obtainStyledAttributes.getFloat(index, this.q);
                    break;
                case 19:
                    this.r = obtainStyledAttributes.getInt(index, this.r);
                    break;
                case 20:
                    this.s = obtainStyledAttributes.getFloat(index, this.s);
                    break;
                case 21:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.t = obtainStyledAttributes.getDimension(index, this.t);
                        break;
                    } else {
                        this.t = obtainStyledAttributes.getFloat(index, this.t);
                        break;
                    }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.e != -1) {
            if (!Float.isNaN(this.f)) {
                hashMap.put("alpha", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.g)) {
                hashMap.put("elevation", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.h)) {
                hashMap.put("rotation", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.i)) {
                hashMap.put("rotationX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.j)) {
                hashMap.put("rotationY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("translationX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("translationY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.p)) {
                hashMap.put("translationZ", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("scaleX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("scaleY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("progress", Integer.valueOf(this.e));
            }
            if (this.d.size() > 0) {
                for (String str : this.d.keySet()) {
                    hashMap.put(a2.b.a.a.a.c3("CUSTOM,", str), Integer.valueOf(this.e));
                }
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
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 1;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = '\f';
                    break;
                }
                break;
            case 1317633238:
                if (str.equals("mTranslationZ")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                obj.toString();
                return;
            case 1:
                this.i = a(obj);
                return;
            case 2:
                this.j = a(obj);
                return;
            case 3:
                this.n = a(obj);
                return;
            case 4:
                this.o = a(obj);
                return;
            case 5:
                this.q = a(obj);
                return;
            case 6:
                this.l = a(obj);
                return;
            case 7:
                this.m = a(obj);
                return;
            case '\b':
                this.h = a(obj);
                return;
            case '\t':
                this.g = a(obj);
                return;
            case '\n':
                this.k = a(obj);
                return;
            case 11:
                this.f = a(obj);
                return;
            case '\f':
                this.e = b(obj);
                return;
            case '\r':
                this.p = a(obj);
                return;
            default:
                return;
        }
    }
}
