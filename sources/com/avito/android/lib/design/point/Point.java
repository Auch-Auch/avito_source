package com.avito.android.lib.design.point;

import a2.g.r.g;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020\u0003\u0012\b\b\u0002\u0010U\u001a\u00020\u0003¢\u0006\u0004\bV\u0010WJ\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0011J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0011J\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010'R*\u00108\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b4\u0010'\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u0007R*\u0010>\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001f8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010!\"\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010:R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010F\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010#R\u0016\u0010G\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010:R\u0016\u0010I\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010BR\u0016\u0010K\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010+R*\u0010O\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\bL\u0010'\u001a\u0004\bM\u00106\"\u0004\bN\u0010\u0007¨\u0006X"}, d2 = {"Lcom/avito/android/lib/design/point/Point;", "Landroid/view/View;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "()V", "startAnimation", "stopAnimation", "toggleAnimation", "desiredSize", "measureSpec", "d", "(II)I", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "e", AuthSource.BOOKING_ORDER, "", "c", "()Z", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "animationPaint", "paint", "f", "I", "highlightSize", "", "k", "J", "animationDuration", "Landroid/animation/Animator;", "i", "Landroid/animation/Animator;", "animator", AuthSource.OPEN_CHANNEL_LIST, "animationRepeatCount", "value", "n", "getSize", "()I", "setSize", "size", "p", "Z", "getWithStroke", "setWithStroke", "(Z)V", "withStroke", "calculateSizeWithAnimation", "", g.a, "F", "highlightMinAlpha", "h", "highLightMaxAlpha", "strokePaint", "isAnimationPreviewDisabled", "j", "animationProgress", "l", "animationDelay", "o", "getStrokeWidth", "setStrokeWidth", "strokeWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Point extends View implements AppearanceChangeableView {
    public final Paint a;
    public final Paint b;
    public Paint c;
    public boolean d;
    public boolean e;
    public int f;
    public float g;
    public float h;
    public Animator i;
    public float j;
    public long k;
    public long l;
    public int m;
    public int n;
    public int o;
    public boolean p;

    public static final class a extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ Point a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Point point) {
            super(1);
            this.a = point;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            this.a.j = f.floatValue();
            this.a.b.setAlpha((int) (e.coerceIn(this.a.g + ((this.a.h - this.a.g) * this.a.j), this.a.g, this.a.h) * ((float) 255)));
            ViewCompat.postInvalidateOnAnimation(this.a);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public Point(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public Point(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public Point(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Point(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.point : i2, (i4 & 8) != 0 ? R.style.Design_Widget_Point : i3);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.Point_point_color, 0);
        this.a.setColor(color);
        setSize(typedArray.getDimensionPixelOffset(R.styleable.Point_point_size, this.n));
        setStrokeWidth(typedArray.getDimensionPixelOffset(R.styleable.Point_point_strokeWidth, this.o));
        this.c.setStrokeWidth((float) this.o);
        this.c.setColor(typedArray.getColor(R.styleable.Point_point_strokeColor, 0));
        this.f = typedArray.getDimensionPixelSize(R.styleable.Point_point_highlightSize, this.f);
        this.g = typedArray.getFloat(R.styleable.Point_point_highlightMinAlpha, 0.0f);
        this.h = typedArray.getFloat(R.styleable.Point_point_highlightMaxAlpha, 0.0f);
        this.b.setColor(color);
        this.b.setAlpha((int) (this.h * ((float) 255)));
        this.k = (long) typedArray.getInteger(R.styleable.Point_point_animationDuration, 0);
        this.l = (long) typedArray.getInteger(R.styleable.Point_point_animationDelay, 0);
        this.m = typedArray.getInteger(R.styleable.Point_point_animationRepeatCount, this.m);
    }

    public final void b() {
        Animator animator = this.i;
        if (animator != null) {
            animator.cancel();
        }
        this.i = null;
        this.j = 0.0f;
        this.b.setAlpha((int) (this.h * ((float) 255)));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final boolean c() {
        return this.i != null;
    }

    public final int d(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i2 : size;
        }
        return Math.min(i2, size);
    }

    public final void e() {
        this.i = new PointAnimationFactory().createAnimator(this.k, this.l, this.m, new a(this));
    }

    public final int getSize() {
        return this.n;
    }

    public final int getStrokeWidth() {
        return this.o;
    }

    public final boolean getWithStroke() {
        return this.p;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        if (isInEditMode() && !this.e) {
            if (canvas != null) {
                canvas.drawCircle(width, height, (((float) this.f) / 2.0f) * 1.46f, this.b);
            }
            if (canvas != null) {
                canvas.drawCircle(width, height, ((float) this.f) / 2.0f, this.b);
            }
        }
        if (canvas != null) {
            canvas.drawCircle(width, height, (((float) this.f) * this.j) / 2.0f, this.b);
        }
        if (this.p && canvas != null) {
            canvas.drawCircle(width, height, ((float) this.n) / 2.0f, this.c);
        }
        if (canvas != null) {
            canvas.drawCircle(width, height, ((float) this.n) / 2.0f, this.a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Integer valueOf = Integer.valueOf(this.o * 2);
        valueOf.intValue();
        if (!this.p) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        boolean z = this.d;
        if (z) {
            i4 = (int) (((float) this.f) * 1.46f);
        } else if (!z) {
            i4 = intValue + this.n;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        setMeasuredDimension(d(i4, i2), d(i4, i3));
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, R.styleable.Point);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i2) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i2);
    }

    public final void setSize(int i2) {
        this.n = i2;
        requestLayout();
    }

    public final void setStrokeWidth(int i2) {
        this.o = i2;
        requestLayout();
    }

    public final void setWithStroke(boolean z) {
        this.p = z;
        requestLayout();
    }

    public final void startAnimation() {
        if (!c()) {
            e();
            Animator animator = this.i;
            if (animator != null) {
                animator.start();
            }
        }
    }

    public final void stopAnimation() {
        if (c()) {
            b();
        }
    }

    public final void toggleAnimation() {
        if (!c()) {
            e();
            Animator animator = this.i;
            if (animator != null) {
                animator.start();
                return;
            }
            return;
        }
        b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Point(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.b = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        this.c = paint3;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Point, i2, i3);
        setWithStroke(obtainStyledAttributes.getBoolean(R.styleable.Point_point_withStroke, false));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Point_point_withInfiniteAnimation, false);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.Point_point_calculateSizeWithAnimation, this.d);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.Point_point_disableAnimationPreview, this.e);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (z) {
            startAnimation();
        }
    }
}
