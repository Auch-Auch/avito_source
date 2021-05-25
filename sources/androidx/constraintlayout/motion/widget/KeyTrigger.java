package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    public String e = null;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    public View k;
    public float l;
    public boolean m;
    public boolean n;
    public boolean o;
    public float p;
    public Method q;
    public Method r;
    public Method s;
    public float t;
    public boolean u;
    public RectF v;
    public RectF w;

    public static class a {
        public static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            a.append(R.styleable.KeyTrigger_onCross, 4);
            a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            a.append(R.styleable.KeyTrigger_motionTarget, 7);
            a.append(R.styleable.KeyTrigger_triggerId, 6);
            a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }
    }

    public KeyTrigger() {
        int i2 = Key.UNSET;
        this.f = i2;
        this.g = null;
        this.h = null;
        this.i = i2;
        this.j = i2;
        this.k = null;
        this.l = 0.1f;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = Float.NaN;
        this.u = false;
        this.v = new RectF();
        this.w = new RectF();
        this.mType = 5;
        this.d = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public final void c(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0110 A[SYNTHETIC, Splitter:B:72:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0145 A[SYNTHETIC, Splitter:B:85:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r9, android.view.View r10) {
        /*
        // Method dump skipped, instructions count: 422
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            switch (a.a.get(index)) {
                case 1:
                    this.g = obtainStyledAttributes.getString(index);
                    continue;
                case 2:
                    this.h = obtainStyledAttributes.getString(index);
                    continue;
                case 4:
                    this.e = obtainStyledAttributes.getString(index);
                    continue;
                case 5:
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    continue;
                case 6:
                    this.i = obtainStyledAttributes.getResourceId(index, this.i);
                    continue;
                case 7:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.b);
                        this.b = resourceId;
                        if (resourceId == -1) {
                            this.c = obtainStyledAttributes.getString(index);
                        } else {
                            continue;
                        }
                    } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.c = obtainStyledAttributes.getString(index);
                    } else {
                        this.b = obtainStyledAttributes.getResourceId(index, this.b);
                    }
                case 8:
                    int integer = obtainStyledAttributes.getInteger(index, this.a);
                    this.a = integer;
                    this.p = (((float) integer) + 0.5f) / 100.0f;
                    continue;
                case 9:
                    this.j = obtainStyledAttributes.getResourceId(index, this.j);
                    continue;
                case 10:
                    this.u = obtainStyledAttributes.getBoolean(index, this.u);
                    continue;
                case 11:
                    this.f = obtainStyledAttributes.getResourceId(index, this.f);
                    break;
            }
            Integer.toHexString(index);
            a.a.get(index);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }
}
