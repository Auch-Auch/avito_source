package com.avito.android.design.widget.circular_progress;

import android.animation.Animator;
import androidx.annotation.CallSuper;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/SimpleAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onPreAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "", AuthSource.SEND_ABUSE, "Z", "isStarted", "isStartedAndNotCancelled", "()Z", AuthSource.BOOKING_ORDER, "isCanceled", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class SimpleAnimatorListener implements Animator.AnimatorListener {
    public boolean a;
    public boolean b;

    public final boolean isStartedAndNotCancelled() {
        return this.a && !this.b;
    }

    @Override // android.animation.Animator.AnimatorListener
    @CallSuper
    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.b = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    @CallSuper
    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        onPreAnimationEnd(animator);
        this.a = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    @CallSuper
    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.b = false;
        this.a = true;
    }

    public void onPreAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }
}
