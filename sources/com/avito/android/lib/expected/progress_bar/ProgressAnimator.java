package com.avito.android.lib.expected.progress_bar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007JO\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u0010.\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010!¨\u00062"}, d2 = {"Lcom/avito/android/lib/expected/progress_bar/ProgressAnimator;", "", "", "progressAnimationDuration", "colorAnimationDuration", "", "setAnimationDuration", "(JJ)V", "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "progressBar", "", "startProgress", "endProgress", "", "startFillColor", "endFillColor", "startEmptyColor", "endEmptyColor", Tracker.Events.CREATIVE_START, "(Lcom/avito/android/lib/expected/progress_bar/ProgressBar;FFIIII)V", "stop", "()V", "", "isRunning", "()Z", "duration", "startDelay", "Lkotlin/Function1;", "Landroid/animation/ValueAnimator;", "updateListener", AuthSource.SEND_ABUSE, "(JJLkotlin/jvm/functions/Function1;)Landroid/animation/ValueAnimator;", "c", "Landroid/animation/ValueAnimator;", "fillColorAnimator", "Landroid/animation/AnimatorSet;", "f", "Landroid/animation/AnimatorSet;", "animator", "e", "progressAnimator", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "J", "colorAnimationDelay", "d", "emptyColorAnimator", "delay", "<init>", "(JJJ)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressAnimator {
    public long a;
    public ProgressBar b;
    public ValueAnimator c;
    public ValueAnimator d;
    public ValueAnimator e;
    public AnimatorSet f;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<ValueAnimator, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ValueAnimator valueAnimator) {
            int i = this.a;
            if (i == 0) {
                ValueAnimator valueAnimator2 = valueAnimator;
                Intrinsics.checkNotNullParameter(valueAnimator2, "it");
                ProgressBar progressBar = ((ProgressAnimator) this.b).b;
                if (progressBar != null) {
                    Object animatedValue = valueAnimator2.getAnimatedValue();
                    Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                    progressBar.setEmptyColor(((Integer) animatedValue).intValue());
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ValueAnimator valueAnimator3 = valueAnimator;
                Intrinsics.checkNotNullParameter(valueAnimator3, "it");
                ProgressBar progressBar2 = ((ProgressAnimator) this.b).b;
                if (progressBar2 != null) {
                    Object animatedValue2 = valueAnimator3.getAnimatedValue();
                    Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
                    progressBar2.setFillColor(((Integer) animatedValue2).intValue());
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                ValueAnimator valueAnimator4 = valueAnimator;
                Intrinsics.checkNotNullParameter(valueAnimator4, "it");
                ProgressBar progressBar3 = ((ProgressAnimator) this.b).b;
                if (progressBar3 != null) {
                    Object animatedValue3 = valueAnimator4.getAnimatedValue();
                    Objects.requireNonNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                    progressBar3.setProgress(((Float) animatedValue3).floatValue());
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public ProgressAnimator() {
        this(0, 0, 0, 7, null);
    }

    public ProgressAnimator(long j, long j2, long j3) {
        long max = Math.max(j - j2, 0L) + j3;
        this.a = max;
        this.c = a(j2, max, new a(1, this));
        this.d = a(j2, this.a, new a(0, this));
        this.e = a(j, j3, new a(2, this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.e, this.c, this.d);
        animatorSet.addListener(new AnimationUtils.SimpleAnimatorListener(this) { // from class: com.avito.android.lib.expected.progress_bar.ProgressAnimator$$special$$inlined$apply$lambda$1
            public final /* synthetic */ ProgressAnimator a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                ProgressAnimator.access$setProgressBar$p(this.a, null);
            }
        });
        this.f = animatorSet;
    }

    public static /* synthetic */ void setAnimationDuration$default(ProgressAnimator progressAnimator, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        progressAnimator.setAnimationDuration(j, j2);
    }

    public static /* synthetic */ void start$default(ProgressAnimator progressAnimator, ProgressBar progressBar, float f2, float f3, int i, int i2, int i3, int i4, int i5, Object obj) {
        progressAnimator.start(progressBar, (i5 & 2) != 0 ? progressBar.getProgress() : f2, f3, (i5 & 8) != 0 ? progressBar.getFillColor() : i, i2, (i5 & 32) != 0 ? progressBar.getEmptyColor() : i3, i4);
    }

    public final ValueAnimator a(long j, long j2, Function1<? super ValueAnimator, Unit> function1) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(j);
        valueAnimator.setStartDelay(j2);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.avito.android.lib.expected.progress_bar.ProgressAnimator$sam$i$android_animation_ValueAnimator_AnimatorUpdateListener$0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final /* synthetic */ void onAnimationUpdate(ValueAnimator valueAnimator2) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(valueAnimator2), "invoke(...)");
            }
        });
        return valueAnimator;
    }

    public final boolean isRunning() {
        return this.f.isRunning();
    }

    public final void setAnimationDuration(long j, long j2) {
        this.e.setDuration(j);
        this.a = Math.max(j - j2, 0L);
        this.c.setDuration(j2);
        this.c.setStartDelay(this.a);
        this.d.setDuration(j2);
        this.d.setStartDelay(this.a);
    }

    public final void start(@NotNull ProgressBar progressBar, float f2, float f3, @ColorInt int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        this.b = progressBar;
        progressBar.setFairProgress(true);
        ValueAnimator valueAnimator = this.c;
        valueAnimator.setIntValues(Arrays.copyOf(new int[]{i, i2}, 2));
        valueAnimator.setEvaluator(ArgbEvaluatorCompat.getInstance());
        ValueAnimator valueAnimator2 = this.d;
        valueAnimator2.setIntValues(Arrays.copyOf(new int[]{i3, i4}, 2));
        valueAnimator2.setEvaluator(ArgbEvaluatorCompat.getInstance());
        this.e.setFloatValues(f2, f3);
        if (!this.f.isRunning()) {
            this.f.start();
        }
    }

    public final void stop() {
        this.f.end();
        this.b = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressAnimator(long j, long j2, long j3, int i, j jVar) {
        this((i & 1) != 0 ? 250 : j, (i & 2) != 0 ? 120 : j2, (i & 4) != 0 ? 0 : j3);
    }
}
