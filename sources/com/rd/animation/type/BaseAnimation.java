package com.rd.animation.type;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.controller.ValueController;
public abstract class BaseAnimation<T extends Animator> {
    public static final int DEFAULT_ANIMATION_TIME = 350;
    public long animationDuration = 350;
    public T animator;
    public ValueController.UpdateListener listener;

    public BaseAnimation(@Nullable ValueController.UpdateListener updateListener) {
        this.listener = updateListener;
        this.animator = createAnimator();
    }

    @NonNull
    public abstract T createAnimator();

    public BaseAnimation duration(long j) {
        this.animationDuration = j;
        T t = this.animator;
        if (t instanceof ValueAnimator) {
            t.setDuration(j);
        }
        return this;
    }

    public void end() {
        T t = this.animator;
        if (t != null && t.isStarted()) {
            this.animator.end();
        }
    }

    public abstract BaseAnimation progress(float f);

    public void start() {
        T t = this.animator;
        if (t != null && !t.isRunning()) {
            this.animator.start();
        }
    }
}
