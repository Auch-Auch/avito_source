package com.avito.android.photo_gallery.zoom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
public class AnimatedZoomableController extends AbstractAnimatedZoomableController {
    public final ValueAnimator y;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            animatedZoomableController.calculateInterpolation(animatedZoomableController.getWorkingTransform(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            AnimatedZoomableController animatedZoomableController2 = AnimatedZoomableController.this;
            AnimatedZoomableController.super.setTransform(animatedZoomableController2.getWorkingTransform());
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        public final void a() {
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            AnimatedZoomableController.this.setAnimating(false);
            AnimatedZoomableController.this.getDetector().restartGesture();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            FLog.v(AnimatedZoomableController.this.getLogTag(), "setTransformAnimated: animation cancelled");
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FLog.v(AnimatedZoomableController.this.getLogTag(), "setTransformAnimated: animation finished");
            a();
        }
    }

    @SuppressLint({"NewApi"})
    public AnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.y = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
    }

    public static AnimatedZoomableController newInstance() {
        return new AnimatedZoomableController(TransformGestureDetector.newInstance());
    }

    @Override // com.avito.android.photo_gallery.zoom.AbstractAnimatedZoomableController
    public Class<?> getLogTag() {
        return AnimatedZoomableController.class;
    }

    @Override // com.avito.android.photo_gallery.zoom.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    public void setTransformAnimated(Matrix matrix, long j, @Nullable Runnable runnable) {
        FLog.v(getLogTag(), "setTransformAnimated: duration %d ms", Long.valueOf(j));
        stopAnimation();
        Preconditions.checkArgument(j > 0);
        Preconditions.checkState(!isAnimating());
        setAnimating(true);
        this.y.setDuration(j);
        getTransform().getValues(getStartValues());
        matrix.getValues(getStopValues());
        this.y.addUpdateListener(new a());
        this.y.addListener(new b(runnable));
        this.y.start();
    }

    @Override // com.avito.android.photo_gallery.zoom.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    public void stopAnimation() {
        if (isAnimating()) {
            FLog.v(getLogTag(), "stopAnimation");
            this.y.cancel();
            this.y.removeAllUpdateListeners();
            this.y.removeAllListeners();
        }
    }
}
