package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.transitionseverywhere.utils.TransitionUtils;
@TargetApi(14)
public class Translation extends Transition {
    public static final String[] J = {"Translation:translationX", "Translation:translationY"};
    @Nullable
    public static final Property<View, PointF> K = new a(PointF.class, "translation");

    public class a extends Property<View, PointF> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(@NonNull View view) {
            View view2 = view;
            return new PointF(view2.getTranslationX(), view2.getTranslationY());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            view2.setTranslationX(pointF2.x);
            view2.setTranslationY(pointF2.y);
        }
    }

    public Translation() {
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        float floatValue = ((Float) transitionValues.values.get("Translation:translationX")).floatValue();
        float floatValue2 = ((Float) transitionValues.values.get("Translation:translationY")).floatValue();
        float floatValue3 = ((Float) transitionValues2.values.get("Translation:translationX")).floatValue();
        float floatValue4 = ((Float) transitionValues2.values.get("Translation:translationY")).floatValue();
        transitionValues2.view.setTranslationX(floatValue);
        transitionValues2.view.setTranslationY(floatValue2);
        Property<View, PointF> property = K;
        if (property != null) {
            return ObjectAnimator.ofObject(transitionValues2.view, (Property<View, V>) property, (TypeConverter) null, getPathMotion().getPath(floatValue, floatValue2, floatValue3, floatValue4));
        }
        if (floatValue == floatValue3) {
            objectAnimator = null;
        } else {
            objectAnimator = ObjectAnimator.ofFloat(transitionValues2.view, View.TRANSLATION_X, floatValue, floatValue3);
        }
        if (floatValue2 != floatValue4) {
            objectAnimator2 = ObjectAnimator.ofFloat(transitionValues2.view, View.TRANSLATION_Y, floatValue2, floatValue4);
        }
        return TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return J;
    }

    public final void o(@NonNull TransitionValues transitionValues) {
        transitionValues.values.put("Translation:translationX", Float.valueOf(transitionValues.view.getTranslationX()));
        transitionValues.values.put("Translation:translationY", Float.valueOf(transitionValues.view.getTranslationY()));
    }

    public Translation(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
