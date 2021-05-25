package l6.g.a.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;
public class f {
    public static final float[][] v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public float g = 0.5f;
    public float h = 0.5f;
    public float i = 0.0f;
    public float j = 1.0f;
    public boolean k = false;
    public float[] l = new float[2];
    public float m;
    public float n;
    public final MotionLayout o;
    public float p = 4.0f;
    public float q = 1.2f;
    public boolean r = true;
    public float s = 1.0f;
    public int t = 0;
    public float u = 10.0f;

    public f(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.o = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.d = obtainStyledAttributes.getResourceId(index, this.d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = obtainStyledAttributes.getInt(index, this.a);
                this.a = i3;
                float[][] fArr = v;
                this.h = fArr[i3][0];
                this.g = fArr[i3][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = obtainStyledAttributes.getInt(index, this.b);
                this.b = i4;
                float[][] fArr2 = w;
                this.i = fArr2[i4][0];
                this.j = fArr2[i4][1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.p = obtainStyledAttributes.getFloat(index, this.p);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.q = obtainStyledAttributes.getFloat(index, this.q);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.r = obtainStyledAttributes.getBoolean(index, this.r);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.s = obtainStyledAttributes.getFloat(index, this.s);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.u = obtainStyledAttributes.getFloat(index, this.u);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.e = obtainStyledAttributes.getResourceId(index, this.e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.c = obtainStyledAttributes.getInt(index, this.c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.t = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f = obtainStyledAttributes.getResourceId(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.e;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public void b(boolean z) {
        if (z) {
            float[][] fArr = w;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = v;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = w;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = v;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = v;
        int i2 = this.a;
        this.h = fArr5[i2][0];
        this.g = fArr5[i2][1];
        float[][] fArr6 = w;
        int i3 = this.b;
        this.i = fArr6[i3][0];
        this.j = fArr6[i3][1];
    }

    public String toString() {
        return this.i + " , " + this.j;
    }
}
