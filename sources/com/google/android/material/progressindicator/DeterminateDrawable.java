package com.google.android.material.progressindicator;

import a2.j.b.d.n.g;
import a2.j.b.d.n.h;
import a2.j.b.d.n.j;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends g {
    public static final FloatPropertyCompat<DeterminateDrawable> q = new a("indicatorLevel");
    public h<S> l;
    public final SpringForce m;
    public final SpringAnimation n;
    public float o;
    public boolean p = false;

    public static class a extends FloatPropertyCompat<DeterminateDrawable> {
        public a(String str) {
            super(str);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.o * 10000.0f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(DeterminateDrawable determinateDrawable, float f) {
            DeterminateDrawable determinateDrawable2 = determinateDrawable;
            determinateDrawable2.o = f / 10000.0f;
            determinateDrawable2.invalidateSelf();
        }
    }

    public DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull h<S> hVar) {
        super(context, baseProgressIndicatorSpec);
        this.l = hVar;
        hVar.b = this;
        SpringForce springForce = new SpringForce();
        this.m = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, q);
        this.n = springAnimation;
        springAnimation.setSpring(springForce);
        if (this.h != 1.0f) {
            this.h = 1.0f;
            invalidateSelf();
        }
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new a2.j.b.d.n.a(circularProgressIndicatorSpec));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    @Override // a2.j.b.d.n.g, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // a2.j.b.d.n.g
    public boolean d(boolean z, boolean z2, boolean z3) {
        boolean d = super.d(z, z2, z3);
        float systemAnimatorDurationScale = this.c.getSystemAnimatorDurationScale(this.a.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.p = true;
        } else {
            this.p = false;
            this.m.setStiffness(50.0f / systemAnimatorDurationScale);
        }
        return d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            h<S> hVar = this.l;
            float c = c();
            hVar.a.a();
            hVar.a(canvas, c);
            this.l.c(canvas, this.i);
            this.l.b(canvas, this.i, 0.0f, this.o, MaterialColors.compositeARGBWithAlpha(this.b.indicatorColors[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l.e();
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // a2.j.b.d.n.g
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // a2.j.b.d.n.g
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // a2.j.b.d.n.g
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.n.cancel();
        this.o = ((float) getLevel()) / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.p) {
            this.n.cancel();
            this.o = ((float) i) / 10000.0f;
            invalidateSelf();
            return true;
        }
        this.n.setStartValue(this.o * 10000.0f);
        this.n.animateToFinalPosition((float) i);
        return true;
    }

    @Override // a2.j.b.d.n.g, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // a2.j.b.d.n.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // a2.j.b.d.n.g, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @Override // a2.j.b.d.n.g
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2, boolean z3) {
        return super.setVisible(z, z2, z3);
    }
}
