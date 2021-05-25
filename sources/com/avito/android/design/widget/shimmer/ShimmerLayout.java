package com.avito.android.design.widget.shimmer;

import a2.g.r.g;
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
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.GlobalAnimationsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 _2\u00020\u0001:\u0001_B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\bY\u0010ZB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bY\u0010\u000fB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010[\u001a\u00020\u0002¢\u0006\u0004\bY\u0010\\B)\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010[\u001a\u00020\u0002\u0012\u0006\u0010]\u001a\u00020\u0002¢\u0006\u0004\bY\u0010^J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0011J\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0006J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020$¢\u0006\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010.R\u0016\u00102\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00101R\u0016\u0010=\u001a\u00020:8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00101R\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010+R\u0018\u0010M\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010?R\u0018\u0010Q\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010PR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010+¨\u0006`"}, d2 = {"Lcom/avito/android/design/widget/shimmer/ShimmerLayout;", "Landroid/widget/FrameLayout;", "", "angle", "", "setShimmerAngle", "(I)V", "Landroid/graphics/Bitmap;", "getMaskBitmap", "()Landroid/graphics/Bitmap;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AuthSource.BOOKING_ORDER, "()V", "c", "onDetachedFromWindow", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setVisibility", "startShimmerAnimation", "shimmerColor", "setShimmerColor", "durationMillis", "setShimmerAnimationDuration", "", "animationReversed", "setAnimationReversed", "(Z)V", "", "maskWidth", "setMaskWidth", "(F)V", "gradientCenterColorWidth", "setGradientCenterColorWidth", "k", "I", "shimmerAnimationDuration", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "maskRect", "h", "Z", "isAnimationReversed", "maskOffsetX", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "p", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "startAnimationPreDrawListener", "j", "autoStart", "", "getGradientColorDistribution", "()[F", "gradientColorDistribution", "o", "F", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "gradientTexturePaint", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "maskAnimator", "i", "isAnimationStarted", AuthSource.OPEN_CHANNEL_LIST, "shimmerAngle", g.a, "Landroid/graphics/Canvas;", "canvasForShimmerMask", "n", "f", "Landroid/graphics/Bitmap;", "maskBitmap", "Landroid/animation/Animator;", "getShimmerAnimation", "()Landroid/animation/Animator;", "shimmerAnimation", "e", "localMaskBitmap", "l", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShimmerLayout extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/design/widget/shimmer/ShimmerLayout$Companion;", "", "", "DEFAULT_ANGLE", "B", "", "DEFAULT_ANIMATION_DURATION", "I", "MAX_ANGLE_VALUE", "MAX_GRADIENT_CENTER_COLOR_WIDTH_VALUE", "MAX_MASK_WIDTH_VALUE", "MIN_ANGLE_VALUE", "MIN_GRADIENT_CENTER_COLOR_WIDTH_VALUE", "MIN_MASK_WIDTH_VALUE", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ShimmerLayout a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(ShimmerLayout shimmerLayout, int i, int i2) {
            this.a = shimmerLayout;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a = ((Integer) a2.b.a.a.a.g2(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue() + this.b;
            if (this.a.a + this.c >= 0) {
                this.a.invalidate();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f2 = this.o;
        fArr[1] = 0.5f - (f2 / 2.0f);
        fArr[2] = (f2 / 2.0f) + 0.5f;
        return fArr;
    }

    private final Bitmap getMaskBitmap() {
        Bitmap bitmap;
        if (this.f == null) {
            Rect rect = this.b;
            Intrinsics.checkNotNull(rect);
            try {
                bitmap = Bitmap.createBitmap(rect.width(), getHeight(), Bitmap.Config.ALPHA_8);
            } catch (OutOfMemoryError unused) {
                System.gc();
                bitmap = null;
            }
            this.f = bitmap;
        }
        return this.f;
    }

    private final Animator getShimmerAnimation() {
        int i2;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 != null) {
            Intrinsics.checkNotNull(valueAnimator2);
            return valueAnimator2;
        }
        if (this.b == null) {
            this.b = new Rect(0, 0, (int) ((Math.tan(Math.toRadians((double) Math.abs(this.m))) * ((double) getHeight())) + (((double) this.n) / Math.cos(Math.toRadians((double) Math.abs(this.m))))), getHeight());
        }
        int width = getWidth();
        int width2 = getWidth();
        Rect rect = this.b;
        Intrinsics.checkNotNull(rect);
        if (width2 > rect.width()) {
            i2 = -width;
        } else {
            Rect rect2 = this.b;
            Intrinsics.checkNotNull(rect2);
            i2 = -rect2.width();
        }
        Rect rect3 = this.b;
        Intrinsics.checkNotNull(rect3);
        int width3 = rect3.width();
        int i3 = width - i2;
        if (this.h) {
            valueAnimator = ValueAnimator.ofInt(i3, 0);
        } else {
            valueAnimator = ValueAnimator.ofInt(0, i3);
        }
        this.d = valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration((long) this.k);
        }
        ValueAnimator valueAnimator3 = this.d;
        if (valueAnimator3 != null) {
            GlobalAnimationsKt.setSafeRepeatCount(valueAnimator3, -1);
        }
        ValueAnimator valueAnimator4 = this.d;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(new a(this, i2, width3));
        }
        ValueAnimator valueAnimator5 = this.d;
        Intrinsics.checkNotNull(valueAnimator5);
        return valueAnimator5;
    }

    private final void setShimmerAngle(int i2) {
        if (i2 >= -45 && 45 >= i2) {
            this.m = i2;
            b();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.H(new Object[]{(byte) -45, (byte) 45}, 2, "shimmerAngle value must be between %d and %d", "java.lang.String.format(format, *args)").toString());
    }

    /* JADX INFO: finally extract failed */
    public final void a(Context context, AttributeSet attributeSet) {
        int i2;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ShimmerLayout, 0, 0);
        try {
            this.m = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_angle, 20);
            this.k = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_animation_duration, 1500);
            int i3 = R.styleable.ShimmerLayout_shimmer_color;
            int i4 = com.avito.android.lib.design.avito.R.color.avito_white;
            if (Build.VERSION.SDK_INT >= 23) {
                i2 = getContext().getColor(i4);
            } else {
                i2 = getResources().getColor(i4);
            }
            this.l = obtainStyledAttributes.getColor(i3, i2);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_autostart, false);
            this.n = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.o = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.h = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_reverse_animation, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.n);
            Object systemService = context.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "(context.getSystemServic…owManager).defaultDisplay");
            this.n = (float) defaultDisplay.getWidth();
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

    public final void b() {
        if (this.i) {
            c();
            startShimmerAnimation();
        }
    }

    public final void c() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.end();
            ValueAnimator valueAnimator2 = this.d;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.removeAllUpdateListeners();
        }
        this.d = null;
        this.c = null;
        this.i = false;
        this.g = null;
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            bitmap.recycle();
            this.f = null;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.i || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.e = maskBitmap;
        if (maskBitmap != null) {
            if (this.g == null) {
                Bitmap bitmap = this.e;
                Intrinsics.checkNotNull(bitmap);
                this.g = new Canvas(bitmap);
            }
            Canvas canvas2 = this.g;
            Intrinsics.checkNotNull(canvas2);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            Canvas canvas3 = this.g;
            Intrinsics.checkNotNull(canvas3);
            canvas3.save();
            Canvas canvas4 = this.g;
            Intrinsics.checkNotNull(canvas4);
            canvas4.translate(-((float) this.a), 0.0f);
            super.dispatchDraw(this.g);
            Canvas canvas5 = this.g;
            Intrinsics.checkNotNull(canvas5);
            canvas5.restore();
            if (this.c == null) {
                int i2 = this.l;
                int argb = Color.argb(0, Color.red(i2), Color.green(i2), Color.blue(i2));
                float f2 = this.n;
                float height = this.m >= 0 ? (float) getHeight() : (float) 0;
                int i3 = this.l;
                LinearGradient linearGradient = new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians((double) this.m))) * f2, (((float) Math.sin(Math.toRadians((double) this.m))) * f2) + height, new int[]{argb, i3, i3, argb}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
                Bitmap bitmap2 = this.e;
                Intrinsics.checkNotNull(bitmap2);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap2, tileMode, tileMode), PorterDuff.Mode.DST_IN);
                Paint paint = new Paint();
                this.c = paint;
                Intrinsics.checkNotNull(paint);
                paint.setAntiAlias(true);
                Paint paint2 = this.c;
                Intrinsics.checkNotNull(paint2);
                paint2.setDither(true);
                Paint paint3 = this.c;
                Intrinsics.checkNotNull(paint3);
                paint3.setFilterBitmap(true);
                Paint paint4 = this.c;
                Intrinsics.checkNotNull(paint4);
                paint4.setShader(composeShader);
            }
            canvas.save();
            canvas.translate((float) this.a, 0.0f);
            Rect rect = this.b;
            Intrinsics.checkNotNull(rect);
            float f3 = (float) rect.left;
            Rect rect2 = this.b;
            Intrinsics.checkNotNull(rect2);
            float width = (float) rect2.width();
            Rect rect3 = this.b;
            Intrinsics.checkNotNull(rect3);
            Paint paint5 = this.c;
            Intrinsics.checkNotNull(paint5);
            canvas.drawRect(f3, 0.0f, width, (float) rect3.height(), paint5);
            canvas.restore();
            this.e = null;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j && getVisibility() == 0) {
            startShimmerAnimation();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    public final void setAnimationReversed(boolean z) {
        this.h = z;
        b();
    }

    public final void setGradientCenterColorWidth(float f2) {
        if (f2 > ((float) 0) && ((float) 1) > f2) {
            this.o = f2;
            b();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.H(new Object[]{(byte) 0, (byte) 1}, 2, "gradientCenterColorWidth value must be higher than %d and less than %d", "java.lang.String.format(format, *args)").toString());
    }

    public final void setMaskWidth(float f2) {
        if (f2 > ((float) 0) && ((float) 1) >= f2) {
            this.n = f2;
            b();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.H(new Object[]{(byte) 0, (byte) 1}, 2, "maskWidth value must be higher than %d and less or equal to %d", "java.lang.String.format(format, *args)").toString());
    }

    public final void setShimmerAnimationDuration(int i2) {
        this.k = i2;
        b();
    }

    public final void setShimmerColor(int i2) {
        this.l = i2;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0) {
            if (this.p != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.p);
            }
            c();
        } else if (this.j) {
            startShimmerAnimation();
        }
    }

    public final void startShimmerAnimation() {
        if (!this.i) {
            if (getWidth() == 0) {
                this.p = new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.avito.android.design.widget.shimmer.ShimmerLayout$startShimmerAnimation$1
                    public final /* synthetic */ ShimmerLayout a;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.a = r1;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.a.startShimmerAnimation();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.p);
                return;
            }
            getShimmerAnimation().start();
            this.i = true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }
}
