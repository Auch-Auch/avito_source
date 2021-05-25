package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.transitionseverywhere.R;
import com.transitionseverywhere.utils.TransitionUtils;
public class Scale extends Visibility {
    public float L = 0.0f;

    public class a extends TransitionListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public a(Scale scale, View view, float f, float f2) {
            this.a = view;
            this.b = f;
            this.c = f2;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            this.a.setScaleX(this.b);
            this.a.setScaleY(this.c);
            transition.removeListener(this);
        }
    }

    public Scale() {
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put("scale:scaleX", Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put("scale:scaleY", Float.valueOf(transitionValues.view.getScaleY()));
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onAppear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return q(view, this.L, 1.0f, transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return q(view, 1.0f, this.L, transitionValues);
    }

    @Nullable
    public final Animator q(@NonNull View view, float f, float f2, @Nullable TransitionValues transitionValues) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        float f3 = scaleX * f;
        float f4 = scaleX * f2;
        float f5 = f * scaleY;
        float f6 = f2 * scaleY;
        if (transitionValues != null) {
            Float f7 = (Float) transitionValues.values.get("scale:scaleX");
            Float f8 = (Float) transitionValues.values.get("scale:scaleY");
            if (!(f7 == null || f7.floatValue() == scaleX)) {
                f3 = f7.floatValue();
            }
            if (!(f8 == null || f8.floatValue() == scaleY)) {
                f5 = f8.floatValue();
            }
        }
        view.setScaleX(f3);
        view.setScaleY(f5);
        Animator mergeAnimators = TransitionUtils.mergeAnimators(ObjectAnimator.ofFloat(view, View.SCALE_X, f3, f4), ObjectAnimator.ofFloat(view, View.SCALE_Y, f5, f6));
        addListener(new a(this, view, scaleX, scaleY));
        return mergeAnimators;
    }

    @NonNull
    public Scale setDisappearedScale(float f) {
        if (f >= 0.0f) {
            this.L = f;
            return this;
        }
        throw new IllegalArgumentException("disappearedScale cannot be negative!");
    }

    public Scale(float f) {
        setDisappearedScale(f);
    }

    public Scale(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Scale);
        setDisappearedScale(obtainStyledAttributes.getFloat(R.styleable.Scale_disappearedScale, this.L));
        obtainStyledAttributes.recycle();
    }
}
