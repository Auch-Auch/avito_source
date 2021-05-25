package com.avito.android.design.widget.circular_progress;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.Interpolator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GlobalAnimationsKt;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00101\u001a\u00020\u0013\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000fJ#\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0018R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010 R$\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010\u0018R\u0016\u0010=\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0018R\u0016\u0010A\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010$R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010\u0018R\u0016\u0010E\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bD\u0010$R\u0016\u0010G\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010\u001cR\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010\u0018R\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0018¨\u0006P"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/DefaultCircularProgressDrawableDelegate;", "Lcom/avito/android/design/widget/circular_progress/CircularProgrssDrawableDelegate;", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V", Tracker.Events.CREATIVE_START, "()V", "stop", "", "currentRotationAngle", "setCurrentRotationAngle", "(F)V", "currentSweepAngle", "setCurrentSweepAngle", "Lkotlin/Function1;", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "endListener", "progressiveStop", "(Lkotlin/jvm/functions/Function1;)V", "e", "F", "rotationSpeed", "", "j", "I", "currentIndexColor", "", "o", "Z", "firstSweepAnimation", "Landroid/animation/ValueAnimator;", "r", "Landroid/animation/ValueAnimator;", "sweepDisappearingAnimator", "k", "f", "minSweepAngle", "t", "endAnimator", "", "c", "[I", "colors", "u", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "parent", "Landroid/view/animation/Interpolator;", AuthSource.BOOKING_ORDER, "Landroid/view/animation/Interpolator;", "sweepInterpolator", "p", "modeAppearing", "h", "Lkotlin/jvm/functions/Function1;", "onEndListener", AuthSource.OPEN_CHANNEL_LIST, AuthSource.SEND_ABUSE, "angleInterpolator", "d", "sweepSpeed", VKApiConst.Q, "sweepAppearingAnimator", "l", "currentRotationAngleOffset", "s", "rotationAnimator", "i", "currentColor", "n", "currentEndRatio", g.a, "maxSweepAngle", "Lcom/avito/android/design/widget/circular_progress/Options;", "options", "<init>", "(Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;Lcom/avito/android/design/widget/circular_progress/Options;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultCircularProgressDrawableDelegate implements CircularProgrssDrawableDelegate {
    public final Interpolator a;
    public final Interpolator b;
    public final int[] c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public Function1<? super CircularProgressDrawable, Unit> h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n = 1.0f;
    public boolean o;
    public boolean p;
    public ValueAnimator q;
    public ValueAnimator r;
    public ValueAnimator s;
    public ValueAnimator t;
    public final CircularProgressDrawable u;

    public DefaultCircularProgressDrawableDelegate(@NotNull CircularProgressDrawable circularProgressDrawable, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(circularProgressDrawable, "parent");
        Intrinsics.checkNotNullParameter(options, "options");
        this.u = circularProgressDrawable;
        Interpolator angleInterpolator = options.getAngleInterpolator();
        this.a = angleInterpolator;
        Interpolator sweepInterpolator = options.getSweepInterpolator();
        this.b = sweepInterpolator;
        int[] colors = options.getColors();
        this.c = colors;
        float sweepSpeed = options.getSweepSpeed();
        this.d = sweepSpeed;
        float rotationSpeed = options.getRotationSpeed();
        this.e = rotationSpeed;
        float minSweepAngle = (float) options.getMinSweepAngle();
        this.f = minSweepAngle;
        float maxSweepAngle = (float) options.getMaxSweepAngle();
        this.g = maxSweepAngle;
        this.i = colors[0];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0f, 360f)");
        this.s = ofFloat;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        ofFloat.setInterpolator(angleInterpolator);
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        valueAnimator.setDuration((long) (((float) 2000) / rotationSpeed));
        ValueAnimator valueAnimator2 = this.s;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        valueAnimator2.addUpdateListener(new e3(0, this));
        ValueAnimator valueAnimator3 = this.s;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        GlobalAnimationsKt.setSafeRepeatCount(valueAnimator3, -1);
        ValueAnimator valueAnimator4 = this.s;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        valueAnimator4.setRepeatMode(1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(minSweepAngle, maxSweepAngle);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ValueAnimator.ofFloat(mi…weepAngle, maxSweepAngle)");
        this.q = ofFloat2;
        if (ofFloat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        ofFloat2.setInterpolator(sweepInterpolator);
        ValueAnimator valueAnimator5 = this.q;
        if (valueAnimator5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        long j2 = (long) (((float) 600) / sweepSpeed);
        valueAnimator5.setDuration(j2);
        ValueAnimator valueAnimator6 = this.q;
        if (valueAnimator6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        valueAnimator6.addUpdateListener(new e3(1, this));
        ValueAnimator valueAnimator7 = this.q;
        if (valueAnimator7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        valueAnimator7.addListener(new SimpleAnimatorListener() { // from class: com.avito.android.design.widget.circular_progress.DefaultCircularProgressDrawableDelegate$setupAnimations$3
            @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                super.onAnimationStart(animator);
                DefaultCircularProgressDrawableDelegate.this.p = true;
            }

            @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener
            public void onPreAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                if (isStartedAndNotCancelled()) {
                    DefaultCircularProgressDrawableDelegate.this.o = false;
                    DefaultCircularProgressDrawableDelegate.access$setDisappearing(DefaultCircularProgressDrawableDelegate.this);
                    DefaultCircularProgressDrawableDelegate.access$getSweepDisappearingAnimator$p(DefaultCircularProgressDrawableDelegate.this).start();
                }
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(maxSweepAngle, minSweepAngle);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ValueAnimator.ofFloat(ma…weepAngle, minSweepAngle)");
        this.r = ofFloat3;
        if (ofFloat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        ofFloat3.setInterpolator(sweepInterpolator);
        ValueAnimator valueAnimator8 = this.r;
        if (valueAnimator8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        valueAnimator8.setDuration(j2);
        ValueAnimator valueAnimator9 = this.r;
        if (valueAnimator9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        valueAnimator9.addUpdateListener(new e3(2, this));
        ValueAnimator valueAnimator10 = this.r;
        if (valueAnimator10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        valueAnimator10.addListener(new SimpleAnimatorListener() { // from class: com.avito.android.design.widget.circular_progress.DefaultCircularProgressDrawableDelegate$setupAnimations$5
            @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener
            public void onPreAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                if (isStartedAndNotCancelled()) {
                    DefaultCircularProgressDrawableDelegate.access$setAppearing(DefaultCircularProgressDrawableDelegate.this);
                    DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate = DefaultCircularProgressDrawableDelegate.this;
                    defaultCircularProgressDrawableDelegate.j = (defaultCircularProgressDrawableDelegate.j + 1) % DefaultCircularProgressDrawableDelegate.this.c.length;
                    DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate2 = DefaultCircularProgressDrawableDelegate.this;
                    defaultCircularProgressDrawableDelegate2.i = defaultCircularProgressDrawableDelegate2.c[DefaultCircularProgressDrawableDelegate.this.j];
                    DefaultCircularProgressDrawableDelegate.this.u.getCurrentPaint().setColor(DefaultCircularProgressDrawableDelegate.this.i);
                    DefaultCircularProgressDrawableDelegate.access$getSweepAppearingAnimator$p(DefaultCircularProgressDrawableDelegate.this).start();
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ValueAnimator.ofFloat(1f, 0f)");
        this.t = ofFloat4;
        if (ofFloat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        ofFloat4.setInterpolator(DefaultCircularProgressDrawableDelegateKt.access$getEND_INTERPOLATOR$p());
        ValueAnimator valueAnimator11 = this.t;
        if (valueAnimator11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        valueAnimator11.setDuration(200L);
        ValueAnimator valueAnimator12 = this.t;
        if (valueAnimator12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        valueAnimator12.addUpdateListener(new e3(3, this));
    }

    public static final /* synthetic */ ValueAnimator access$getEndAnimator$p(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate) {
        ValueAnimator valueAnimator = defaultCircularProgressDrawableDelegate.t;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        return valueAnimator;
    }

    public static final /* synthetic */ ValueAnimator access$getSweepAppearingAnimator$p(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate) {
        ValueAnimator valueAnimator = defaultCircularProgressDrawableDelegate.q;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        return valueAnimator;
    }

    public static final /* synthetic */ ValueAnimator access$getSweepDisappearingAnimator$p(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate) {
        ValueAnimator valueAnimator = defaultCircularProgressDrawableDelegate.r;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        return valueAnimator;
    }

    public static final void access$setAppearing(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate) {
        defaultCircularProgressDrawableDelegate.p = true;
        defaultCircularProgressDrawableDelegate.l += defaultCircularProgressDrawableDelegate.f;
    }

    public static final void access$setDisappearing(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate) {
        defaultCircularProgressDrawableDelegate.p = false;
        defaultCircularProgressDrawableDelegate.l = (((float) 360) - defaultCircularProgressDrawableDelegate.g) + defaultCircularProgressDrawableDelegate.l;
    }

    public static final void access$setEndRatio(DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate, float f2) {
        defaultCircularProgressDrawableDelegate.n = f2;
        defaultCircularProgressDrawableDelegate.u.invalidate();
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f4 = this.m - this.l;
        float f5 = this.k;
        if (!this.p) {
            f4 += ((float) 360) - f5;
        }
        float f6 = f4 % 360.0f;
        float f7 = this.n;
        if (f7 < 1.0f) {
            float f8 = f7 * f5;
            f3 = ((f5 - f8) + f6) % ((float) 360);
            f2 = f8;
        } else {
            f3 = f6;
            f2 = f5;
        }
        canvas.drawArc(this.u.getDrawableBounds(), f3, f2, false, paint);
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void progressiveStop(@NotNull Function1<? super CircularProgressDrawable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "endListener");
        if (this.u.isRunning()) {
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
            }
            if (!valueAnimator.isRunning()) {
                this.h = function1;
                ValueAnimator valueAnimator2 = this.t;
                if (valueAnimator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
                }
                valueAnimator2.addListener(new SimpleAnimatorListener(this) { // from class: com.avito.android.design.widget.circular_progress.DefaultCircularProgressDrawableDelegate$progressiveStop$1
                    public final /* synthetic */ DefaultCircularProgressDrawableDelegate c;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.c = r1;
                    }

                    @Override // com.avito.android.design.widget.circular_progress.SimpleAnimatorListener
                    public void onPreAnimationEnd(@NotNull Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "animation");
                        DefaultCircularProgressDrawableDelegate.access$getEndAnimator$p(this.c).removeListener(this);
                        Function1 function12 = this.c.h;
                        this.c.h = null;
                        if (isStartedAndNotCancelled()) {
                            DefaultCircularProgressDrawableDelegate.access$setEndRatio(this.c, 0.0f);
                            this.c.u.stop();
                            if (function12 != null) {
                                Unit unit = (Unit) function12.invoke(this.c.u);
                            }
                        }
                    }
                });
                ValueAnimator valueAnimator3 = this.t;
                if (valueAnimator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
                }
                valueAnimator3.start();
            }
        }
    }

    public final void setCurrentRotationAngle(float f2) {
        this.m = f2;
        this.u.invalidate();
    }

    public final void setCurrentSweepAngle(float f2) {
        this.k = f2;
        this.u.invalidate();
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void start() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        valueAnimator.cancel();
        this.o = true;
        this.n = 1.0f;
        this.u.getCurrentPaint().setColor(this.i);
        ValueAnimator valueAnimator2 = this.s;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        valueAnimator2.start();
        ValueAnimator valueAnimator3 = this.q;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        valueAnimator3.start();
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void stop() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotationAnimator");
        }
        valueAnimator.cancel();
        ValueAnimator valueAnimator2 = this.q;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepAppearingAnimator");
        }
        valueAnimator2.cancel();
        ValueAnimator valueAnimator3 = this.r;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sweepDisappearingAnimator");
        }
        valueAnimator3.cancel();
        ValueAnimator valueAnimator4 = this.t;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endAnimator");
        }
        valueAnimator4.cancel();
    }
}
