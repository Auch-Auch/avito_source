package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import javax.annotation.Nullable;
@TargetApi(19)
public class DraweeTransition extends Transition {
    public final ScalingUtils.ScaleType a;
    public final ScalingUtils.ScaleType b;
    @Nullable
    public final PointF c;
    @Nullable
    public final PointF d;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ScalingUtils.InterpolatingScaleType a;

        public a(DraweeTransition draweeTransition, ScalingUtils.InterpolatingScaleType interpolatingScaleType) {
            this.a = interpolatingScaleType;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ GenericDraweeView a;

        public b(GenericDraweeView genericDraweeView) {
            this.a = genericDraweeView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ((GenericDraweeHierarchy) this.a.getHierarchy()).setActualImageScaleType(DraweeTransition.this.b);
            if (DraweeTransition.this.d != null) {
                ((GenericDraweeHierarchy) this.a.getHierarchy()).setActualImageFocusPoint(DraweeTransition.this.d);
            }
        }
    }

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        this.a = scaleType;
        this.b = scaleType2;
        this.c = pointF;
        this.d = pointF2;
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        return createTransitionSet(scaleType, scaleType2, null, null);
    }

    public final void a(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            Rect rect = (Rect) transitionValues.values.get("draweeTransition:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("draweeTransition:bounds");
            if (!(rect == null || rect2 == null)) {
                if (this.a == this.b && this.c == this.d) {
                    return null;
                }
                GenericDraweeView genericDraweeView = (GenericDraweeView) transitionValues.view;
                ScalingUtils.InterpolatingScaleType interpolatingScaleType = new ScalingUtils.InterpolatingScaleType(this.a, this.b, rect, rect2, this.c, this.d);
                ((GenericDraweeHierarchy) genericDraweeView.getHierarchy()).setActualImageScaleType(interpolatingScaleType);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new a(this, interpolatingScaleType));
                ofFloat.addListener(new b(genericDraweeView));
                return ofFloat;
            }
        }
        return null;
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new DraweeTransition(scaleType, scaleType2, pointF, pointF2));
        return transitionSet;
    }

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
    }
}
