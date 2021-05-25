package com.avito.android.util;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/util/AnimationUtils;", "", "Landroid/content/Context;", "context", "", "duration", "Landroid/view/animation/Animation;", "getFadeInAnimation", "(Landroid/content/Context;J)Landroid/view/animation/Animation;", "getFadeOutAnimation", "Landroid/view/View;", "view", "", "alpha", "", "setAlpha", "(Landroid/view/View;F)V", "", "toY", "animateTranslation", "(Landroid/view/View;IJ)V", "DURATION_SHORT", "J", "DURATION_MEDIUM", "DURATION_LONG", "<init>", "()V", "SimpleAnimationListener", "SimpleAnimatorListener", "android_release"}, k = 1, mv = {1, 4, 2})
public final class AnimationUtils {
    public static final long DURATION_LONG = 450;
    public static final long DURATION_MEDIUM = 300;
    public static final long DURATION_SHORT = 150;
    @NotNull
    public static final AnimationUtils INSTANCE = new AnimationUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/AnimationUtils$SimpleAnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "(Landroid/view/animation/Animation;)V", "onAnimationEnd", "onAnimationRepeat", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class SimpleAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/util/AnimationUtils$SimpleAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static class SimpleAnimatorListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
        }
    }

    public final void animateTranslation(@NotNull View view, int i, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.animate().translationY((float) i).setDuration(j).start();
    }

    @NotNull
    public final Animation getFadeInAnimation(@Nullable Context context, long j) {
        Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(context, 17432576);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "animation");
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        loadAnimation.setFillAfter(true);
        loadAnimation.setDuration(j);
        return loadAnimation;
    }

    @NotNull
    public final Animation getFadeOutAnimation(@Nullable Context context, long j) {
        Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(context, 17432577);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "animation");
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        loadAnimation.setFillAfter(true);
        loadAnimation.setDuration(j);
        return loadAnimation;
    }

    public final void setAlpha(@NotNull View view, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAlpha(f);
    }
}
