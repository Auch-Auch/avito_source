package com.avito.android.design.widget.circular_progress;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.view.animation.Interpolator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0003MLNJ\u001f\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010\u0016J\u000f\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010\u0016J!\u0010'\u001a\u00020\n2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0%¢\u0006\u0004\b'\u0010(J\u001f\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\u001cR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0019\u00108\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b/\u00105\u001a\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0019\u0010A\u001a\u00020<8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "", "visible", "restart", "setVisible", "(ZZ)Z", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "cf", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", Tracker.Events.CREATIVE_START, "()V", "stop", "invalidate", "size", "setSize", "isRunning", "()Z", "getIntrinsicWidth", "getIntrinsicHeight", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "progressiveStop", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "editMode", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "newBuilder", "(Landroid/content/Context;Z)Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", AuthSource.SEND_ABUSE, "Landroid/os/PowerManager;", "f", "Landroid/os/PowerManager;", "powerManager", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "getDrawableBounds", "()Landroid/graphics/RectF;", "drawableBounds", "d", "Z", "running", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "getCurrentPaint", "()Landroid/graphics/Paint;", "currentPaint", "Lcom/avito/android/design/widget/circular_progress/CircularProgrssDrawableDelegate;", "e", "Lcom/avito/android/design/widget/circular_progress/CircularProgrssDrawableDelegate;", "delegate", "Lcom/avito/android/design/widget/circular_progress/Options;", g.a, "Lcom/avito/android/design/widget/circular_progress/Options;", "options", "c", "Ljava/lang/Integer;", "Companion", "Builder", "Style", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CircularProgressDrawable extends Drawable implements Animatable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_ROUNDED = 1;
    @NotNull
    public final RectF a = new RectF();
    @NotNull
    public final Paint b;
    public Integer c;
    public boolean d;
    public CircularProgrssDrawableDelegate e;
    public final PowerManager f;
    public final Options g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Companion;", "", "", "STYLE_NORMAL", "I", "STYLE_ROUNDED", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Style;", "", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Style {
    }

    public CircularProgressDrawable(PowerManager powerManager, Options options, j jVar) {
        this.f = powerManager;
        this.g = options;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(options.getBorderWidth());
        paint.setStrokeCap(options.getStyle() == 1 ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        paint.setColor(options.getColors()[0]);
        a();
    }

    public static /* synthetic */ Builder newBuilder$default(CircularProgressDrawable circularProgressDrawable, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return circularProgressDrawable.newBuilder(context, z);
    }

    public final void a() {
        if (UtilsKt.isPowerSaveModeEnabled(this.f)) {
            CircularProgrssDrawableDelegate circularProgrssDrawableDelegate = this.e;
            if (circularProgrssDrawableDelegate == null || !(circularProgrssDrawableDelegate instanceof PowerSaveModeCicularProgressDrawableDelegate)) {
                if (circularProgrssDrawableDelegate != null) {
                    circularProgrssDrawableDelegate.stop();
                }
                this.e = new PowerSaveModeCicularProgressDrawableDelegate(this);
                return;
            }
            return;
        }
        CircularProgrssDrawableDelegate circularProgrssDrawableDelegate2 = this.e;
        if (circularProgrssDrawableDelegate2 == null || (circularProgrssDrawableDelegate2 instanceof PowerSaveModeCicularProgressDrawableDelegate)) {
            if (circularProgrssDrawableDelegate2 != null) {
                circularProgrssDrawableDelegate2.stop();
            }
            this.e = new DefaultCircularProgressDrawableDelegate(this, this.g);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        CircularProgrssDrawableDelegate circularProgrssDrawableDelegate;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (isRunning() && (circularProgrssDrawableDelegate = this.e) != null) {
            circularProgrssDrawableDelegate.draw(canvas, this.b);
        }
    }

    @NotNull
    public final Paint getCurrentPaint() {
        return this.b;
    }

    @NotNull
    public final RectF getDrawableBounds() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Integer num = this.c;
        return num != null ? num.intValue() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Integer num = this.c;
        return num != null ? num.intValue() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void invalidate() {
        if (getCallback() == null) {
            stop();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d;
    }

    @NotNull
    public final Builder newBuilder(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Builder(context, z).colors(this.g.getColors()).angleInterpolator(this.g.getAngleInterpolator()).sweepInterpolator(this.g.getSweepInterpolator()).maxSweepAngle(this.g.getMaxSweepAngle()).minSweepAngle(this.g.getMinSweepAngle()).rotationSpeed(this.g.getRotationSpeed()).sweepSpeed(this.g.getSweepSpeed()).strokeWidth(this.g.getBorderWidth()).style(this.g.getStyle());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        super.onBoundsChange(rect);
        float borderWidth = this.g.getBorderWidth();
        RectF rectF = this.a;
        float f2 = borderWidth / 2.0f;
        rectF.left = ((float) rect.left) + f2 + 0.5f;
        rectF.right = (((float) rect.right) - f2) - 0.5f;
        rectF.top = ((float) rect.top) + f2 + 0.5f;
        rectF.bottom = (((float) rect.bottom) - f2) - 0.5f;
    }

    public final void progressiveStop(@NotNull Function1<? super CircularProgressDrawable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CircularProgrssDrawableDelegate circularProgrssDrawableDelegate = this.e;
        if (circularProgrssDrawableDelegate != null) {
            circularProgrssDrawableDelegate.progressiveStop(function1);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public final void setSize(int i) {
        this.c = Integer.valueOf(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (z2) {
            start();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        a();
        CircularProgrssDrawableDelegate circularProgrssDrawableDelegate = this.e;
        if (circularProgrssDrawableDelegate != null) {
            circularProgrssDrawableDelegate.start();
        }
        this.d = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.d = false;
        CircularProgrssDrawableDelegate circularProgrssDrawableDelegate = this.e;
        if (circularProgrssDrawableDelegate != null) {
            circularProgrssDrawableDelegate.stop();
        }
        invalidateSelf();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R(\u00101\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b*\u0010!\u0012\u0004\b/\u00100\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001eR\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106¨\u0006>"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "", "", "color", "(I)Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "", "colors", "([I)Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "", "sweepSpeed", "(F)Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "rotationSpeed", "minSweepAngle", "maxSweepAngle", "strokeWidth", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroid/view/animation/Interpolator;", "interpolator", "sweepInterpolator", "(Landroid/view/animation/Interpolator;)Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "angleInterpolator", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "build", "()Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "c", "Landroid/view/animation/Interpolator;", "mSweepInterpolator", "d", "mAngleInterpolator", "e", "F", "mBorderWidth", "i", "I", "mMaxSweepAngle", g.a, "mRotationSpeed", "h", "mMinSweepAngle", AuthSource.SEND_ABUSE, "[I", "mColors", "j", "getMStyle$ui_components_release", "()I", "setMStyle$ui_components_release", "(I)V", "getMStyle$ui_components_release$annotations", "()V", "mStyle", "f", "mSweepSpeed", "Landroid/os/PowerManager;", AuthSource.BOOKING_ORDER, "Landroid/os/PowerManager;", "mPowerManager", "Landroid/content/Context;", "context", "", "editMode", "<init>", "(Landroid/content/Context;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public int[] a;
        public PowerManager b;
        public Interpolator c;
        public Interpolator d;
        public float e;
        public float f;
        public float g;
        public int h;
        public int i;
        public int j;

        @JvmOverloads
        public Builder(@NotNull Context context) {
            this(context, false, 2, null);
        }

        @JvmOverloads
        public Builder(@NotNull Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.c = CircularProgressDrawableKt.b;
            this.d = CircularProgressDrawableKt.a;
            this.e = context.getResources().getDimension(R.dimen.cpb_default_stroke_width);
            this.f = 1.0f;
            this.g = 1.0f;
            if (z) {
                this.a = new int[]{Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue)};
                this.h = 20;
                this.i = 300;
            } else {
                this.a = new int[]{Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white)};
                this.h = context.getResources().getInteger(R.integer.cpb_default_min_sweep_angle);
                this.i = context.getResources().getInteger(R.integer.cpb_default_max_sweep_angle);
            }
            this.j = 1;
            this.b = UtilsKt.powerManager(context);
        }

        public static /* synthetic */ void getMStyle$ui_components_release$annotations() {
        }

        @NotNull
        public final Builder angleInterpolator(@NotNull Interpolator interpolator) {
            Intrinsics.checkNotNullParameter(interpolator, "interpolator");
            UtilsKt.checkNotNull(interpolator, "Angle interpolator");
            this.d = interpolator;
            return this;
        }

        @NotNull
        public final CircularProgressDrawable build() {
            Interpolator interpolator = this.d;
            Interpolator interpolator2 = this.c;
            float f2 = this.e;
            int[] iArr = this.a;
            if (iArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColors");
            }
            Options options = new Options(interpolator, interpolator2, f2, iArr, this.f, this.g, this.h, this.i, this.j);
            PowerManager powerManager = this.b;
            if (powerManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPowerManager");
            }
            return new CircularProgressDrawable(powerManager, options, null);
        }

        @NotNull
        public final Builder color(int i2) {
            this.a = new int[]{i2};
            return this;
        }

        @NotNull
        public final Builder colors(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "colors");
            UtilsKt.checkColors(iArr);
            this.a = iArr;
            return this;
        }

        public final int getMStyle$ui_components_release() {
            return this.j;
        }

        @NotNull
        public final Builder maxSweepAngle(int i2) {
            UtilsKt.checkAngle(i2);
            this.i = i2;
            return this;
        }

        @NotNull
        public final Builder minSweepAngle(int i2) {
            UtilsKt.checkAngle(i2);
            this.h = i2;
            return this;
        }

        @NotNull
        public final Builder rotationSpeed(float f2) {
            UtilsKt.checkSpeed(f2);
            this.g = f2;
            return this;
        }

        public final void setMStyle$ui_components_release(int i2) {
            this.j = i2;
        }

        @NotNull
        public final Builder strokeWidth(float f2) {
            UtilsKt.checkPositiveOrZero(f2, "StrokeWidth");
            this.e = f2;
            return this;
        }

        @NotNull
        public final Builder style(int i2) {
            this.j = i2;
            return this;
        }

        @NotNull
        public final Builder sweepInterpolator(@NotNull Interpolator interpolator) {
            Intrinsics.checkNotNullParameter(interpolator, "interpolator");
            UtilsKt.checkNotNull(interpolator, "Sweep interpolator");
            this.c = interpolator;
            return this;
        }

        @NotNull
        public final Builder sweepSpeed(float f2) {
            UtilsKt.checkSpeed(f2);
            this.f = f2;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Context context, boolean z, int i2, j jVar) {
            this(context, (i2 & 2) != 0 ? false : z);
        }
    }
}
