package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
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
    public float r = Float.NaN;
    public float s = Float.NaN;

    public static class a {
        public static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            a.append(R.styleable.KeyAttribute_android_elevation, 2);
            a.append(R.styleable.KeyAttribute_android_rotation, 4);
            a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            a.append(R.styleable.KeyAttribute_motionTarget, 10);
            a.append(R.styleable.KeyAttribute_framePosition, 12);
            a.append(R.styleable.KeyAttribute_curveFit, 13);
            a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            a.append(R.styleable.KeyAttribute_android_translationX, 15);
            a.append(R.styleable.KeyAttribute_android_translationY, 16);
            a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.d = new HashMap<>();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        if (r1.equals("scaleY") == false) goto L_0x00f4;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r6) {
        /*
        // Method dump skipped, instructions count: 580
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.addValues(java.util.HashMap):void");
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
        if (!Float.isNaN(this.k)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute);
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
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                    break;
                case 8:
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
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
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                    break;
                case 15:
                    this.p = obtainStyledAttributes.getDimension(index, this.p);
                    break;
                case 16:
                    this.q = obtainStyledAttributes.getDimension(index, this.q);
                    break;
                case 17:
                    this.r = obtainStyledAttributes.getDimension(index, this.r);
                    break;
                case 18:
                    this.s = obtainStyledAttributes.getFloat(index, this.s);
                    break;
                case 19:
                    this.k = obtainStyledAttributes.getDimension(index, this.k);
                    break;
                case 20:
                    this.l = obtainStyledAttributes.getDimension(index, this.l);
                    break;
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
            if (!Float.isNaN(this.k)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.p)) {
                hashMap.put("translationX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("translationY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.r)) {
                hashMap.put("translationZ", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("scaleX", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("scaleY", Integer.valueOf(this.e));
            }
            if (!Float.isNaN(this.s)) {
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
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 5;
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 6;
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = 7;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\b';
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\t';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = '\n';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 11;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\f';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
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
            case 1941332754:
                if (str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.s = a(obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.i = a(obj);
                return;
            case 3:
                this.j = a(obj);
                return;
            case 4:
                this.p = a(obj);
                return;
            case 5:
                this.q = a(obj);
                return;
            case 6:
                this.k = a(obj);
                return;
            case 7:
                this.l = a(obj);
                return;
            case '\b':
                this.n = a(obj);
                return;
            case '\t':
                this.o = a(obj);
                return;
            case '\n':
                this.h = a(obj);
                return;
            case 11:
                this.g = a(obj);
                return;
            case '\f':
                this.m = a(obj);
                return;
            case '\r':
                this.f = a(obj);
                return;
            case 14:
                this.e = b(obj);
                return;
            case 15:
                this.r = a(obj);
                return;
            case 16:
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                    return;
                } else {
                    Boolean.parseBoolean(obj.toString());
                    return;
                }
            default:
                return;
        }
    }
}
