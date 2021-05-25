package io.supercharge.shimmerlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
public class ShimmerLayout extends FrameLayout {
    public int a;
    public Rect b;
    public Paint c;
    public ValueAnimator d;
    public Bitmap e;
    public Bitmap f;
    public Canvas g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public ViewTreeObserver.OnPreDrawListener p;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.startShimmerAnimation();
            return true;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerLayout.this.a = ((Integer) valueAnimator.getAnimatedValue()).intValue() + this.a;
            ShimmerLayout shimmerLayout = ShimmerLayout.this;
            if (shimmerLayout.a + this.b >= 0) {
                shimmerLayout.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f2 = this.o;
        fArr[1] = 0.5f - (f2 / 2.0f);
        fArr[2] = (f2 / 2.0f) + 0.5f;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        Bitmap bitmap;
        if (this.f == null) {
            try {
                bitmap = Bitmap.createBitmap(this.b.width(), getHeight(), Bitmap.Config.ALPHA_8);
            } catch (OutOfMemoryError unused) {
                System.gc();
                bitmap = null;
            }
            this.f = bitmap;
        }
        return this.f;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0079: APUT  (r1v1 int[]), (0 ??[int, short, byte, char]), (0 int) */
    private Animator getShimmerAnimation() {
        int i2;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.b == null) {
            this.b = new Rect(0, 0, (int) ((Math.tan(Math.toRadians((double) Math.abs(this.m))) * ((double) getHeight())) + (((double) (((float) (getWidth() / 2)) * this.n)) / Math.cos(Math.toRadians((double) Math.abs(this.m))))), getHeight());
        }
        int width = getWidth();
        if (getWidth() > this.b.width()) {
            i2 = -width;
        } else {
            i2 = -this.b.width();
        }
        int width2 = this.b.width();
        int i3 = width - i2;
        int[] iArr = new int[2];
        if (this.h) {
            iArr[0] = i3;
            iArr[1] = 0;
            valueAnimator = ValueAnimator.ofInt(iArr);
        } else {
            iArr[0] = 0;
            iArr[1] = i3;
            valueAnimator = ValueAnimator.ofInt(iArr);
        }
        this.d = valueAnimator;
        valueAnimator.setDuration((long) this.k);
        this.d.setRepeatCount(-1);
        this.d.addUpdateListener(new b(i2, width2));
        return this.d;
    }

    public final void a() {
        if (this.i) {
            b();
            startShimmerAnimation();
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.d.removeAllUpdateListeners();
        }
        this.d = null;
        this.c = null;
        this.i = false;
        this.g = null;
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(Canvas canvas) {
        if (!this.i || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.e = maskBitmap;
        if (maskBitmap != null) {
            if (this.g == null) {
                this.g = new Canvas(this.e);
            }
            this.g.drawColor(0, PorterDuff.Mode.CLEAR);
            this.g.save();
            this.g.translate((float) (-this.a), 0.0f);
            super.dispatchDraw(this.g);
            this.g.restore();
            if (this.c == null) {
                int i2 = this.l;
                int argb = Color.argb(0, Color.red(i2), Color.green(i2), Color.blue(i2));
                float width = ((float) (getWidth() / 2)) * this.n;
                float height = this.m >= 0 ? (float) getHeight() : 0.0f;
                int i3 = this.l;
                LinearGradient linearGradient = new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians((double) this.m))) * width, (((float) Math.sin(Math.toRadians((double) this.m))) * width) + height, new int[]{argb, i3, i3, argb}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
                Bitmap bitmap = this.e;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
                Paint paint = new Paint();
                this.c = paint;
                paint.setAntiAlias(true);
                this.c.setDither(true);
                this.c.setFilterBitmap(true);
                this.c.setShader(composeShader);
            }
            canvas.save();
            canvas.translate((float) this.a, 0.0f);
            Rect rect = this.b;
            canvas.drawRect((float) rect.left, 0.0f, (float) rect.width(), (float) this.b.height(), this.c);
            canvas.restore();
            this.e = null;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z) {
        this.h = z;
        a();
    }

    public void setGradientCenterColorWidth(float f2) {
        if (f2 <= 0.0f || 1.0f <= f2) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
        this.o = f2;
        a();
    }

    public void setMaskWidth(float f2) {
        if (f2 <= 0.0f || 1.0f < f2) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
        this.n = f2;
        a();
    }

    public void setShimmerAngle(int i2) {
        if (i2 < -45 || 45 < i2) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, (byte) 45));
        }
        this.m = i2;
        a();
    }

    public void setShimmerAnimationDuration(int i2) {
        this.k = i2;
        a();
    }

    public void setShimmerColor(int i2) {
        this.l = i2;
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0) {
            stopShimmerAnimation();
        } else if (this.j) {
            startShimmerAnimation();
        }
    }

    public void startShimmerAnimation() {
        if (!this.i) {
            if (getWidth() == 0) {
                this.p = new a();
                getViewTreeObserver().addOnPreDrawListener(this.p);
                return;
            }
            getShimmerAnimation().start();
            this.i = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.p);
        }
        b();
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ShimmerLayout, 0, 0);
        try {
            this.m = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_angle, 20);
            this.k = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_animation_duration, 1500);
            int i4 = R.styleable.ShimmerLayout_shimmer_color;
            int i5 = R.color.shimmer_color;
            if (Build.VERSION.SDK_INT >= 23) {
                i3 = getContext().getColor(i5);
            } else {
                i3 = getResources().getColor(i5);
            }
            this.l = obtainStyledAttributes.getColor(i4, i3);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_auto_start, false);
            this.n = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.o = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.h = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_reverse_animation, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.n);
            setGradientCenterColorWidth(this.o);
            setShimmerAngle(this.m);
            if (this.j && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
