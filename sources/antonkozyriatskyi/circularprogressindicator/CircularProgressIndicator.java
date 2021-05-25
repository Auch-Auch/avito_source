package antonkozyriatskyi.circularprogressindicator;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import m6.a.b;
import m6.a.c;
public class CircularProgressIndicator extends View {
    public static final int CAP_BUTT = 1;
    public static final int CAP_ROUND = 0;
    public static final int DIRECTION_CLOCKWISE = 0;
    public static final int DIRECTION_COUNTERCLOCKWISE = 1;
    public static final int LINEAR_GRADIENT = 1;
    public static final int NO_GRADIENT = 0;
    public static final int RADIAL_GRADIENT = 2;
    public static final int SWEEP_GRADIENT = 3;
    public Paint a;
    public Paint b;
    public Paint c;
    public Paint d;
    public int e = 270;
    public int f = 0;
    public RectF g;
    public String h;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public double m = 100.0d;
    public double n = 0.0d;
    public boolean o;
    public boolean p;
    public int q = 1;
    public ValueAnimator r;
    @NonNull
    public ProgressTextAdapter s;
    @Nullable
    public OnProgressChangeListener t;
    @NonNull
    public Interpolator u = new AccelerateDecelerateInterpolator();

    @Retention(RetentionPolicy.SOURCE)
    public @interface Cap {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientType {
    }

    public interface OnProgressChangeListener {
        void onProgressChanged(double d, double d2);
    }

    public interface ProgressTextAdapter {
        @NonNull
        String formatText(double d);
    }

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CircularProgressIndicator.this.setGradient(this.a, this.b);
        }
    }

    public CircularProgressIndicator(Context context) {
        super(context);
        d(context, null);
    }

    public final void a(int i2, int i3) {
        float f2 = (float) i2;
        this.k = f2 / 2.0f;
        float strokeWidth = this.c.getStrokeWidth();
        float strokeWidth2 = this.a.getStrokeWidth();
        float strokeWidth3 = this.b.getStrokeWidth();
        float max = (this.l ? Math.max(strokeWidth, Math.max(strokeWidth2, strokeWidth3)) : Math.max(strokeWidth2, strokeWidth3)) / 2.0f;
        RectF rectF = this.g;
        rectF.left = max;
        rectF.top = max;
        rectF.right = f2 - max;
        rectF.bottom = ((float) i3) - max;
        this.k = rectF.width() / 2.0f;
        b();
    }

    public final Rect b() {
        Rect rect = new Rect();
        Paint paint = this.d;
        String str = this.h;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.i = this.g.centerX() - (((float) rect.width()) / 2.0f);
        this.j = (((float) rect.height()) / 2.0f) + this.g.centerY();
        return rect;
    }

    public final int c(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    public final void d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2;
        Paint.Cap cap;
        int i3;
        int i4;
        int i5;
        int parseColor = Color.parseColor("#3F51B5");
        int parseColor2 = Color.parseColor("#e0e0e0");
        int c2 = c(8.0f);
        int applyDimension = (int) TypedValue.applyDimension(2, 24.0f, getResources().getDisplayMetrics());
        this.l = true;
        Paint.Cap cap2 = Paint.Cap.ROUND;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularProgressIndicator);
            parseColor = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_progressColor, parseColor);
            parseColor2 = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_progressBackgroundColor, parseColor2);
            c2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressIndicator_progressStrokeWidth, c2);
            i2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressIndicator_progressBackgroundStrokeWidth, c2);
            i5 = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_textColor, parseColor);
            applyDimension = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressIndicator_textSize, applyDimension);
            this.l = obtainStyledAttributes.getBoolean(R.styleable.CircularProgressIndicator_drawDot, true);
            i4 = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_dotColor, parseColor);
            i3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressIndicator_dotWidth, c2);
            int i6 = obtainStyledAttributes.getInt(R.styleable.CircularProgressIndicator_startAngle, 270);
            this.e = i6;
            if (i6 < 0 || i6 > 360) {
                this.e = 270;
            }
            this.o = obtainStyledAttributes.getBoolean(R.styleable.CircularProgressIndicator_enableProgressAnimation, true);
            this.p = obtainStyledAttributes.getBoolean(R.styleable.CircularProgressIndicator_fillBackground, false);
            this.q = obtainStyledAttributes.getInt(R.styleable.CircularProgressIndicator_direction, 1);
            cap = obtainStyledAttributes.getInt(R.styleable.CircularProgressIndicator_progressCap, 0) == 0 ? Paint.Cap.ROUND : Paint.Cap.BUTT;
            String string = obtainStyledAttributes.getString(R.styleable.CircularProgressIndicator_formattingPattern);
            if (string != null) {
                this.s = new PatternProgressTextAdapter(string);
            } else {
                this.s = new DefaultProgressTextAdapter();
            }
            f();
            int color = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_gradientType, 0);
            if (color != 0) {
                int color2 = obtainStyledAttributes.getColor(R.styleable.CircularProgressIndicator_gradientEndColor, -1);
                if (color2 != -1) {
                    post(new a(color, color2));
                } else {
                    throw new IllegalArgumentException("did you forget to specify gradientColorEnd?");
                }
            }
            obtainStyledAttributes.recycle();
        } else {
            i4 = parseColor;
            i2 = c2;
            i3 = i2;
            cap = cap2;
            i5 = i4;
        }
        Paint paint = new Paint();
        this.a = paint;
        paint.setStrokeCap(cap);
        this.a.setStrokeWidth((float) c2);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(parseColor);
        this.a.setAntiAlias(true);
        Paint.Style style = this.p ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE;
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(style);
        this.b.setStrokeWidth((float) i2);
        this.b.setColor(parseColor2);
        this.b.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setStrokeCap(Paint.Cap.ROUND);
        this.c.setStrokeWidth((float) i3);
        this.c.setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.setColor(i4);
        this.c.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.d = textPaint;
        textPaint.setStrokeCap(Paint.Cap.ROUND);
        this.d.setColor(i5);
        this.d.setAntiAlias(true);
        this.d.setTextSize((float) applyDimension);
        this.g = new RectF();
    }

    public final void e() {
        a(getWidth(), getHeight());
        requestLayout();
        invalidate();
    }

    public final void f() {
        this.h = this.s.formatText(this.n);
    }

    public int getDirection() {
        return this.q;
    }

    @ColorInt
    public int getDotColor() {
        return this.c.getColor();
    }

    public float getDotWidth() {
        return this.c.getStrokeWidth();
    }

    public int getGradientType() {
        Shader shader = this.a.getShader();
        if (shader instanceof LinearGradient) {
            return 1;
        }
        if (shader instanceof RadialGradient) {
            return 2;
        }
        return shader instanceof SweepGradient ? 3 : 0;
    }

    @NonNull
    public Interpolator getInterpolator() {
        return this.u;
    }

    public double getMaxProgress() {
        return this.m;
    }

    @Nullable
    public OnProgressChangeListener getOnProgressChangeListener() {
        return this.t;
    }

    public double getProgress() {
        return this.n;
    }

    @ColorInt
    public int getProgressBackgroundColor() {
        return this.b.getColor();
    }

    public float getProgressBackgroundStrokeWidth() {
        return this.b.getStrokeWidth();
    }

    @ColorInt
    public int getProgressColor() {
        return this.a.getColor();
    }

    public int getProgressStrokeCap() {
        return this.a.getStrokeCap() == Paint.Cap.ROUND ? 0 : 1;
    }

    public float getProgressStrokeWidth() {
        return this.a.getStrokeWidth();
    }

    @NonNull
    public ProgressTextAdapter getProgressTextAdapter() {
        return this.s;
    }

    public int getStartAngle() {
        return this.e;
    }

    @ColorInt
    public int getTextColor() {
        return this.d.getColor();
    }

    public float getTextSize() {
        return this.d.getTextSize();
    }

    public boolean isAnimationEnabled() {
        return this.o;
    }

    public boolean isDotEnabled() {
        return this.l;
    }

    public boolean isFillBackgroundEnabled() {
        return this.p;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.g, 0.0f, 360.0f, false, this.b);
        canvas.drawArc(this.g, (float) this.e, (float) this.f, false, this.a);
        if (this.l) {
            double radians = Math.toRadians((double) (this.e + this.f + 180));
            canvas.drawPoint(this.g.centerX() - (this.k * ((float) Math.cos(radians))), this.g.centerY() - (this.k * ((float) Math.sin(radians))), this.c);
        }
        canvas.drawText(this.h, this.i, this.j, this.d);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        Rect rect = new Rect();
        Paint paint = this.d;
        String str = this.h;
        paint.getTextBounds(str, 0, str.length(), rect);
        float strokeWidth = this.c.getStrokeWidth();
        float strokeWidth2 = this.a.getStrokeWidth();
        float strokeWidth3 = this.b.getStrokeWidth();
        float max = (float) (Math.max(paddingBottom + paddingTop, paddingLeft + paddingRight) + c(150.0f) + ((int) (this.l ? Math.max(strokeWidth, Math.max(strokeWidth2, strokeWidth3)) : Math.max(strokeWidth2, strokeWidth3))));
        int max2 = (int) ((0.1f * max) + ((float) Math.max(rect.width(), rect.height())) + max);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(max2, size);
        } else if (mode != 1073741824) {
            size = max2;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(max2, size2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        int min = Math.min((size2 - paddingTop) - paddingBottom, (size - paddingLeft) - paddingRight);
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        a(i2, i3);
        Shader shader = this.a.getShader();
        if (shader instanceof RadialGradient) {
            RadialGradient radialGradient = (RadialGradient) shader;
        }
    }

    public void setAnimationEnabled(boolean z) {
        ValueAnimator valueAnimator;
        this.o = z;
        if (!z && (valueAnimator = this.r) != null) {
            valueAnimator.cancel();
        }
    }

    public void setCurrentProgress(double d2) {
        if (d2 > this.m) {
            this.m = d2;
        }
        setProgress(d2, this.m);
    }

    public void setDirection(int i2) {
        this.q = i2;
        invalidate();
    }

    public void setDotColor(@ColorInt int i2) {
        this.c.setColor(i2);
        invalidate();
    }

    public void setDotWidthDp(@Dimension int i2) {
        setDotWidthPx(c((float) i2));
    }

    public void setDotWidthPx(@Dimension int i2) {
        this.c.setStrokeWidth((float) i2);
        e();
    }

    public void setFillBackgroundEnabled(boolean z) {
        if (z != this.p) {
            this.p = z;
            this.b.setStyle(z ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE);
            invalidate();
        }
    }

    public void setGradient(int i2, @ColorInt int i3) {
        Shader shader;
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        int color = this.a.getColor();
        Shader shader2 = null;
        if (i2 != 1) {
            if (i2 == 2) {
                shader = new RadialGradient(width, height, width, color, i3, Shader.TileMode.MIRROR);
            } else if (i2 == 3) {
                shader = new SweepGradient(width, height, new int[]{color, i3}, (float[]) null);
            }
            shader2 = shader;
        } else {
            shader2 = new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), color, i3, Shader.TileMode.CLAMP);
        }
        if (shader2 != null) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) this.e, width, height);
            shader2.setLocalMatrix(matrix);
        }
        this.a.setShader(shader2);
        invalidate();
    }

    public void setInterpolator(@NonNull Interpolator interpolator) {
        this.u = interpolator;
    }

    public void setMaxProgress(double d2) {
        this.m = d2;
        if (d2 < this.n) {
            setCurrentProgress(d2);
        }
        invalidate();
    }

    public void setOnProgressChangeListener(@Nullable OnProgressChangeListener onProgressChangeListener) {
        this.t = onProgressChangeListener;
    }

    public void setProgress(double d2, double d3) {
        double d4 = d2 / d3;
        double d5 = this.q == 1 ? -(d4 * 360.0d) : d4 * 360.0d;
        double d6 = this.n;
        this.m = d3;
        double min = Math.min(d2, d3);
        this.n = min;
        OnProgressChangeListener onProgressChangeListener = this.t;
        if (onProgressChangeListener != null) {
            onProgressChangeListener.onProgressChanged(min, this.m);
        }
        f();
        b();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.o) {
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("angle", this.f, (int) d5);
            ValueAnimator ofObject = ValueAnimator.ofObject(new m6.a.a(this), Double.valueOf(d6), Double.valueOf(this.n));
            this.r = ofObject;
            ofObject.setDuration(1000L);
            this.r.setValues(ofInt);
            this.r.setInterpolator(this.u);
            this.r.addUpdateListener(new b(this));
            this.r.addListener(new c(this, d5));
            this.r.start();
            return;
        }
        this.f = (int) d5;
        invalidate();
    }

    public void setProgressBackgroundColor(@ColorInt int i2) {
        this.b.setColor(i2);
        invalidate();
    }

    public void setProgressBackgroundStrokeWidthDp(@Dimension int i2) {
        setProgressBackgroundStrokeWidthPx(c((float) i2));
    }

    public void setProgressBackgroundStrokeWidthPx(@Dimension int i2) {
        this.b.setStrokeWidth((float) i2);
        e();
    }

    public void setProgressColor(@ColorInt int i2) {
        this.a.setColor(i2);
        invalidate();
    }

    public void setProgressStrokeCap(int i2) {
        Paint.Cap cap = i2 == 0 ? Paint.Cap.ROUND : Paint.Cap.BUTT;
        if (this.a.getStrokeCap() != cap) {
            this.a.setStrokeCap(cap);
            invalidate();
        }
    }

    public void setProgressStrokeWidthDp(@Dimension int i2) {
        setProgressStrokeWidthPx(c((float) i2));
    }

    public void setProgressStrokeWidthPx(@Dimension int i2) {
        this.a.setStrokeWidth((float) i2);
        e();
    }

    public void setProgressTextAdapter(@Nullable ProgressTextAdapter progressTextAdapter) {
        if (progressTextAdapter != null) {
            this.s = progressTextAdapter;
        } else {
            this.s = new DefaultProgressTextAdapter();
        }
        f();
        e();
    }

    public void setShouldDrawDot(boolean z) {
        this.l = z;
        if (this.c.getStrokeWidth() > this.a.getStrokeWidth()) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public void setStartAngle(@IntRange(from = 0, to = 360) int i2) {
        this.e = i2;
        invalidate();
    }

    public void setTextColor(@ColorInt int i2) {
        this.d.setColor(i2);
        Rect rect = new Rect();
        Paint paint = this.d;
        String str = this.h;
        paint.getTextBounds(str, 0, str.length(), rect);
        invalidate(rect);
    }

    public void setTextSizePx(@Dimension int i2) {
        float measureText = this.d.measureText(this.h) / this.d.getTextSize();
        float width = this.g.width() - (this.l ? Math.max(this.c.getStrokeWidth(), this.a.getStrokeWidth()) : this.a.getStrokeWidth());
        if (((float) i2) * measureText >= width) {
            i2 = (int) (width / measureText);
        }
        this.d.setTextSize((float) i2);
        invalidate(b());
    }

    public void setTextSizeSp(@Dimension int i2) {
        setTextSizePx((int) TypedValue.applyDimension(2, (float) i2, getResources().getDisplayMetrics()));
    }

    public CircularProgressIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public CircularProgressIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context, attributeSet);
    }

    @TargetApi(21)
    public CircularProgressIndicator(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        d(context, attributeSet);
    }
}
