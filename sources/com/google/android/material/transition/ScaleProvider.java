package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class ScaleProvider implements VisibilityAnimatorProvider {
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;

    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public a(View view, float f, float f2) {
            this.a = view;
            this.b = f;
            this.c = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setScaleX(this.b);
            this.a.setScaleY(this.c);
        }
    }

    public ScaleProvider() {
        this(true);
    }

    public static Animator a(View view, float f2, float f3) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f2, scaleX * f3), PropertyValuesHolder.ofFloat(View.SCALE_Y, f2 * scaleY, f3 * scaleY));
        ofPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return ofPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.e) {
            return a(view, this.c, this.d);
        }
        return a(view, this.b, this.a);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (!this.f) {
            return null;
        }
        if (this.e) {
            return a(view, this.a, this.b);
        }
        return a(view, this.d, this.c);
    }

    public float getIncomingEndScale() {
        return this.d;
    }

    public float getIncomingStartScale() {
        return this.c;
    }

    public float getOutgoingEndScale() {
        return this.b;
    }

    public float getOutgoingStartScale() {
        return this.a;
    }

    public boolean isGrowing() {
        return this.e;
    }

    public boolean isScaleOnDisappear() {
        return this.f;
    }

    public void setGrowing(boolean z) {
        this.e = z;
    }

    public void setIncomingEndScale(float f2) {
        this.d = f2;
    }

    public void setIncomingStartScale(float f2) {
        this.c = f2;
    }

    public void setOutgoingEndScale(float f2) {
        this.b = f2;
    }

    public void setOutgoingStartScale(float f2) {
        this.a = f2;
    }

    public void setScaleOnDisappear(boolean z) {
        this.f = z;
    }

    public ScaleProvider(boolean z) {
        this.a = 1.0f;
        this.b = 1.1f;
        this.c = 0.8f;
        this.d = 1.0f;
        this.f = true;
        this.e = z;
    }
}
