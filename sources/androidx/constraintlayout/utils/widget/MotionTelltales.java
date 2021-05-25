package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
public class MotionTelltales extends MockView {
    public Paint k;
    public MotionLayout l;
    public float[] m;
    public Matrix n;
    public int o;
    public int p;
    public float q;

    public MotionTelltales(Context context) {
        super(context);
        this.k = new Paint();
        this.m = new float[2];
        this.n = new Matrix();
        this.o = 0;
        this.p = -65281;
        this.q = 0.25f;
        a(context, null);
    }

    @Override // androidx.constraintlayout.utils.widget.MockView
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.p = obtainStyledAttributes.getColor(index, this.p);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.o = obtainStyledAttributes.getInt(index, this.o);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.q = obtainStyledAttributes.getFloat(index, this.q);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.k.setColor(this.p);
        this.k.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.n);
        if (this.l == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.l = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i = 0; i < 5; i++) {
            float f = fArr[i];
            for (int i2 = 0; i2 < 5; i2++) {
                float f2 = fArr[i2];
                this.l.getViewVelocity(this, f2, f, this.m, this.o);
                this.n.mapVectors(this.m);
                float f3 = ((float) width) * f2;
                float f4 = ((float) height) * f;
                float[] fArr2 = this.m;
                float f5 = fArr2[0];
                float f6 = this.q;
                float f7 = f4 - (fArr2[1] * f6);
                this.n.mapVectors(fArr2);
                canvas.drawLine(f3, f4, f3 - (f5 * f6), f7, this.k);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new Paint();
        this.m = new float[2];
        this.n = new Matrix();
        this.o = 0;
        this.p = -65281;
        this.q = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new Paint();
        this.m = new float[2];
        this.n = new Matrix();
        this.o = 0;
        this.p = -65281;
        this.q = 0.25f;
        a(context, attributeSet);
    }
}
