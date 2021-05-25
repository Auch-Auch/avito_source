package com.google.android.material.progressindicator;

import a2.j.b.d.n.g;
import a2.j.b.d.n.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    public static final int o = R.style.Widget_MaterialComponents_ProgressIndicator;
    public S a;
    public int b;
    public boolean c;
    public boolean d;
    public final int e;
    public final int f;
    public long g = -1;
    public AnimatorDurationScaleProvider h;
    public boolean i = false;
    public int j = 4;
    public final Runnable k = new a();
    public final Runnable l = new b();
    public final Animatable2Compat.AnimationCallback m = new c();
    public final Animatable2Compat.AnimationCallback n = new d();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            if (baseProgressIndicator.f > 0) {
                baseProgressIndicator.g = SystemClock.uptimeMillis();
            }
            baseProgressIndicator.setVisibility(0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            int i = BaseProgressIndicator.SHOW_NONE;
            boolean z = false;
            ((g) baseProgressIndicator.getCurrentDrawable()).setVisible(false, false, true);
            if ((baseProgressIndicator.getProgressDrawable() == null || !baseProgressIndicator.getProgressDrawable().isVisible()) && (baseProgressIndicator.getIndeterminateDrawable() == null || !baseProgressIndicator.getIndeterminateDrawable().isVisible())) {
                z = true;
            }
            if (z) {
                baseProgressIndicator.setVisibility(4);
            }
            BaseProgressIndicator.this.g = -1;
        }
    }

    public class c extends Animatable2Compat.AnimationCallback {
        public c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.setProgressCompat(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.b, baseProgressIndicator.c);
        }
    }

    public class d extends Animatable2Compat.AnimationCallback {
        public d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            if (!baseProgressIndicator.i) {
                baseProgressIndicator.setVisibility(baseProgressIndicator.j);
            }
        }
    }

    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, o), attributeSet, i2);
        Context context2 = getContext();
        this.a = a(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.e = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f = Math.min(obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.h = new AnimatorDurationScaleProvider();
        this.d = true;
    }

    @Nullable
    private h<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().l;
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().l;
        }
    }

    public abstract S a(@NonNull Context context, @NonNull AttributeSet attributeSet);

    public void applyNewVisibility(boolean z) {
        if (this.d) {
            ((g) getCurrentDrawable()).setVisible(b(), false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (getWindowVisibility() == 0) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.isAttachedToWindow(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0032
            int r0 = r4.getWindowVisibility()
            if (r0 != 0) goto L_0x0032
            r0 = r4
        L_0x000f:
            int r3 = r0.getVisibility()
            if (r3 == 0) goto L_0x0016
            goto L_0x0024
        L_0x0016:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0026
            int r0 = r4.getWindowVisibility()
            if (r0 != 0) goto L_0x0024
        L_0x0022:
            r0 = 1
            goto L_0x002b
        L_0x0024:
            r0 = 0
            goto L_0x002b
        L_0x0026:
            boolean r3 = r0 instanceof android.view.View
            if (r3 != 0) goto L_0x002f
            goto L_0x0022
        L_0x002b:
            if (r0 == 0) goto L_0x0032
            r1 = 1
            goto L_0x0032
        L_0x002f:
            android.view.View r0 = (android.view.View) r0
            goto L_0x000f
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.BaseProgressIndicator.b():boolean");
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.a.hideAnimationBehavior;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.a.indicatorColors;
    }

    public int getShowAnimationBehavior() {
        return this.a.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.a.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.a.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.a.trackThickness;
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.k);
            return;
        }
        removeCallbacks(this.l);
        long uptimeMillis = SystemClock.uptimeMillis() - this.g;
        int i2 = this.f;
        if (uptimeMillis >= ((long) i2)) {
            this.l.run();
        } else {
            postDelayed(this.l, ((long) i2) - uptimeMillis);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().m.d(this.m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.n);
        }
        if (b()) {
            if (this.f > 0) {
                this.g = SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.l);
        removeCallbacks(this.k);
        ((g) getCurrentDrawable()).hideNow();
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.n);
            getIndeterminateDrawable().m.g();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.n);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        h<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int e2 = currentDrawingDelegate.e();
            int d2 = currentDrawingDelegate.d();
            if (e2 < 0) {
                i4 = getMeasuredWidth();
            } else {
                i4 = e2 + getPaddingLeft() + getPaddingRight();
            }
            if (d2 < 0) {
                i5 = getMeasuredHeight();
            } else {
                i5 = d2 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(i4, i5);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        applyNewVisibility(i2 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        applyNewVisibility(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.h = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().c = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().c = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.a.hideAnimationBehavior = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z != isIndeterminate()) {
            if (!b() || !z) {
                g gVar = (g) getCurrentDrawable();
                if (gVar != null) {
                    gVar.hideNow();
                }
                super.setIndeterminate(z);
                g gVar2 = (g) getCurrentDrawable();
                if (gVar2 != null) {
                    gVar2.setVisible(b(), false, false);
                }
                this.i = false;
                return;
            }
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((g) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.a.indicatorColors = iArr;
            getIndeterminateDrawable().m.c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            setProgressCompat(i2, false);
        }
    }

    public void setProgressCompat(int i2, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null && !z) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.b = i2;
            this.c = z;
            this.i = true;
            if (!getIndeterminateDrawable().isVisible() || this.h.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.m.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().m.e();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevel((int) ((((float) getProgress()) / ((float) getMax())) * 10000.0f));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.a.showAnimationBehavior = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s = this.a;
        if (s.trackColor != i2) {
            s.trackColor = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s = this.a;
        if (s.trackCornerRadius != i2) {
            s.trackCornerRadius = Math.min(i2, s.trackThickness / 2);
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s = this.a;
        if (s.trackThickness != i2) {
            s.trackThickness = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 == 0 || i2 == 4 || i2 == 8) {
            this.j = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.e > 0) {
            removeCallbacks(this.k);
            postDelayed(this.k, (long) this.e);
            return;
        }
        this.k.run();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
