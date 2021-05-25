package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public int e = 0;
    public int f = -1;
    public float g = Float.NaN;
    public float h = 0.0f;
    public float i = Float.NaN;
    public int j = -1;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;
    public float t = Float.NaN;
    public float u = Float.NaN;

    public static class a {
        public static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            a.append(R.styleable.KeyCycle_framePosition, 2);
            a.append(R.styleable.KeyCycle_transitionEasing, 3);
            a.append(R.styleable.KeyCycle_curveFit, 4);
            a.append(R.styleable.KeyCycle_waveShape, 5);
            a.append(R.styleable.KeyCycle_wavePeriod, 6);
            a.append(R.styleable.KeyCycle_waveOffset, 7);
            a.append(R.styleable.KeyCycle_waveVariesBy, 8);
            a.append(R.styleable.KeyCycle_android_alpha, 9);
            a.append(R.styleable.KeyCycle_android_elevation, 10);
            a.append(R.styleable.KeyCycle_android_rotation, 11);
            a.append(R.styleable.KeyCycle_android_rotationX, 12);
            a.append(R.styleable.KeyCycle_android_rotationY, 13);
            a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            a.append(R.styleable.KeyCycle_android_scaleX, 15);
            a.append(R.styleable.KeyCycle_android_scaleY, 16);
            a.append(R.styleable.KeyCycle_android_translationX, 17);
            a.append(R.styleable.KeyCycle_android_translationY, 18);
            a.append(R.styleable.KeyCycle_android_translationZ, 19);
            a.append(R.styleable.KeyCycle_motionProgress, 20);
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.d = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.d.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(str).setPoint(this.a, this.f, this.j, this.g, this.h, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value)) {
                    hashMap.get(str).setPoint(this.a, this.f, this.j, this.g, this.h, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        StringBuilder L = a2.b.a.a.a.L("add ");
        L.append(hashMap.size());
        L.append(" values");
        Debug.logStack("KeyCycle", L.toString(), 2);
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            str.hashCode();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
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
                case 156108012:
                    if (str.equals("waveOffset")) {
                        c = '\f';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    splineSet.setPoint(this.a, this.o);
                    break;
                case 1:
                    splineSet.setPoint(this.a, this.p);
                    break;
                case 2:
                    splineSet.setPoint(this.a, this.s);
                    break;
                case 3:
                    splineSet.setPoint(this.a, this.t);
                    break;
                case 4:
                    splineSet.setPoint(this.a, this.u);
                    break;
                case 5:
                    splineSet.setPoint(this.a, this.i);
                    break;
                case 6:
                    splineSet.setPoint(this.a, this.q);
                    break;
                case 7:
                    splineSet.setPoint(this.a, this.r);
                    break;
                case '\b':
                    splineSet.setPoint(this.a, this.m);
                    break;
                case '\t':
                    splineSet.setPoint(this.a, this.l);
                    break;
                case '\n':
                    splineSet.setPoint(this.a, this.n);
                    break;
                case 11:
                    splineSet.setPoint(this.a, this.k);
                    break;
                case '\f':
                    splineSet.setPoint(this.a, this.h);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.k)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationZ");
        }
        if (this.d.size() > 0) {
            Iterator<String> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public float getValue(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.o;
            case 1:
                return this.p;
            case 2:
                return this.s;
            case 3:
                return this.t;
            case 4:
                return this.u;
            case 5:
                return this.i;
            case 6:
                return this.q;
            case 7:
                return this.r;
            case '\b':
                return this.m;
            case '\t':
                return this.l;
            case '\n':
                return this.n;
            case 11:
                return this.k;
            case '\f':
                return this.h;
            default:
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle);
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
                    obtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                    break;
                case 5:
                    this.f = obtainStyledAttributes.getInt(index, this.f);
                    break;
                case 6:
                    this.g = obtainStyledAttributes.getFloat(index, this.g);
                    break;
                case 7:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    } else {
                        this.h = obtainStyledAttributes.getFloat(index, this.h);
                        break;
                    }
                case 8:
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                    break;
                case 9:
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                    break;
                case 10:
                    this.l = obtainStyledAttributes.getDimension(index, this.l);
                    break;
                case 11:
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
                    break;
                case 12:
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                    break;
                case 13:
                    this.p = obtainStyledAttributes.getFloat(index, this.p);
                    break;
                case 14:
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                    break;
                case 15:
                    this.q = obtainStyledAttributes.getFloat(index, this.q);
                    break;
                case 16:
                    this.r = obtainStyledAttributes.getFloat(index, this.r);
                    break;
                case 17:
                    this.s = obtainStyledAttributes.getDimension(index, this.s);
                    break;
                case 18:
                    this.t = obtainStyledAttributes.getDimension(index, this.t);
                    break;
                case 19:
                    this.u = obtainStyledAttributes.getDimension(index, this.u);
                    break;
                case 20:
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                    break;
                default:
                    Integer.toHexString(index);
                    a.a.get(index);
                    break;
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\f';
                    break;
                }
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
                    c = '\r';
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 14;
                    break;
                }
                break;
            case 1317633238:
                if (str.equals("mTranslationZ")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                obj.toString();
                return;
            case 1:
                this.o = a(obj);
                return;
            case 2:
                this.p = a(obj);
                return;
            case 3:
                this.s = a(obj);
                return;
            case 4:
                this.t = a(obj);
                return;
            case 5:
                this.i = a(obj);
                return;
            case 6:
                this.q = a(obj);
                return;
            case 7:
                this.r = a(obj);
                return;
            case '\b':
                this.m = a(obj);
                return;
            case '\t':
                this.l = a(obj);
                return;
            case '\n':
                this.n = a(obj);
                return;
            case 11:
                this.k = a(obj);
                return;
            case '\f':
                this.h = a(obj);
                return;
            case '\r':
                this.g = a(obj);
                return;
            case 14:
                this.e = b(obj);
                return;
            case 15:
                this.u = a(obj);
                return;
            default:
                return;
        }
    }
}
