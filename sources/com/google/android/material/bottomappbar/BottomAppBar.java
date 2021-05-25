package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int m0 = R.style.Widget_MaterialComponents_BottomAppBar;
    public final int P;
    public final MaterialShapeDrawable Q;
    @Nullable
    public Animator R;
    @Nullable
    public Animator S;
    public int T;
    public int U;
    public boolean V;
    public final boolean W;
    public final boolean a0;
    public final boolean b0;
    public int c0;
    @MenuRes
    public int d0;
    public boolean e0;
    public boolean f0;
    public Behavior g0;
    public int h0;
    public int i0;
    public int j0;
    @NonNull
    public AnimatorListenerAdapter k0;
    @NonNull
    public TransformationCallback<FloatingActionButton> l0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        @NonNull
        public final Rect e = new Rect();
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h = new a();

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = Behavior.this.f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.getMeasuredContentRect(Behavior.this.e);
                int height = Behavior.this.e.height();
                bottomAppBar.E(height);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.g == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.P;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.P;
                    }
                }
            }
        }

        public Behavior() {
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i) {
            this.f = new WeakReference<>(bottomAppBar);
            int i2 = BottomAppBar.m0;
            View y = bottomAppBar.y();
            if (y != null && !ViewCompat.isLaidOut(y)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) y.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (y instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) y;
                    floatingActionButton.addOnLayoutChangeListener(this.h);
                    floatingActionButton.addOnHideAnimationListener(bottomAppBar.k0);
                    floatingActionButton.addOnShowAnimationListener(new a2.j.b.d.d.d(bottomAppBar));
                    floatingActionButton.addTransformationCallback(bottomAppBar.l0);
                }
                bottomAppBar.D();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            if (!bottomAppBar.e0) {
                bottomAppBar.B(bottomAppBar.T, bottomAppBar.f0);
            }
        }
    }

    public class b implements TransformationCallback<FloatingActionButton> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
        @Override // com.google.android.material.animation.TransformationCallback
        public void onScaleChanged(@NonNull FloatingActionButton floatingActionButton) {
            FloatingActionButton floatingActionButton2 = floatingActionButton;
            BottomAppBar.this.Q.setInterpolation(floatingActionButton2.getVisibility() == 0 ? floatingActionButton2.getScaleY() : 0.0f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
        @Override // com.google.android.material.animation.TransformationCallback
        public void onTranslationChanged(@NonNull FloatingActionButton floatingActionButton) {
            FloatingActionButton floatingActionButton2 = floatingActionButton;
            float translationX = floatingActionButton2.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().e = translationX;
                BottomAppBar.this.Q.invalidateSelf();
            }
            float f = 0.0f;
            float max = Math.max(0.0f, -floatingActionButton2.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().d != max) {
                BottomAppBar.this.getTopEdgeTreatment().b(max);
                BottomAppBar.this.Q.invalidateSelf();
            }
            MaterialShapeDrawable materialShapeDrawable = BottomAppBar.this.Q;
            if (floatingActionButton2.getVisibility() == 0) {
                f = floatingActionButton2.getScaleY();
            }
            materialShapeDrawable.setInterpolation(f);
        }
    }

    public class c implements ViewUtils.OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
            boolean z;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            if (bottomAppBar.W) {
                bottomAppBar.h0 = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            BottomAppBar bottomAppBar2 = BottomAppBar.this;
            boolean z2 = true;
            boolean z3 = false;
            if (bottomAppBar2.a0) {
                z = bottomAppBar2.j0 != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.j0 = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            BottomAppBar bottomAppBar3 = BottomAppBar.this;
            if (bottomAppBar3.b0) {
                if (bottomAppBar3.i0 == windowInsetsCompat.getSystemWindowInsetRight()) {
                    z2 = false;
                }
                BottomAppBar.this.i0 = windowInsetsCompat.getSystemWindowInsetRight();
                z3 = z2;
            }
            if (z || z3) {
                BottomAppBar bottomAppBar4 = BottomAppBar.this;
                Animator animator = bottomAppBar4.S;
                if (animator != null) {
                    animator.cancel();
                }
                Animator animator2 = bottomAppBar4.R;
                if (animator2 != null) {
                    animator2.cancel();
                }
                BottomAppBar.this.D();
                BottomAppBar.this.C();
            }
            return windowInsetsCompat;
        }
    }

    public class d extends FloatingActionButton.OnVisibilityChangedListener {
        public final /* synthetic */ int a;

        public class a extends FloatingActionButton.OnVisibilityChangedListener {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onShown(FloatingActionButton floatingActionButton) {
                BottomAppBar.r(BottomAppBar.this);
            }
        }

        public d(int i) {
            this.a = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            int i = this.a;
            int i2 = BottomAppBar.m0;
            floatingActionButton.setTranslationX(bottomAppBar.z(i));
            floatingActionButton.show(new a());
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.r(BottomAppBar.this);
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.e0 = false;
            bottomAppBar.S = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.c0++;
        }
    }

    public static class f extends AbsSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();
        public int b;
        public boolean c;

        public static class a implements Parcelable.ClassLoaderCreator<f> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public f createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new f[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new f(parcel, null);
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        public f(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getBottomInset() {
        return this.h0;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return z(this.T);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getLeftInset() {
        return this.j0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getRightInset() {
        return this.i0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.Q.getShapeAppearanceModel().getTopEdge();
    }

    public static void r(BottomAppBar bottomAppBar) {
        bottomAppBar.c0--;
    }

    public final boolean A() {
        FloatingActionButton x = x();
        return x != null && x.isOrWillBeShown();
    }

    public final void B(int i, boolean z) {
        if (!ViewCompat.isLaidOut(this)) {
            this.e0 = false;
            replaceMenu(this.d0);
            return;
        }
        Animator animator = this.S;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!A()) {
            i = 0;
            z = false;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - ((float) getActionMenuViewTranslationX(actionMenuView, i, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new a2.j.b.d.d.b(this, actionMenuView, i, z));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(ofFloat2, ofFloat);
                arrayList.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(ofFloat);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        this.S = animatorSet2;
        animatorSet2.addListener(new e());
        this.S.start();
    }

    public final void C() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.S == null) {
            actionMenuView.setAlpha(1.0f);
            if (!A()) {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, 0, false));
            } else {
                actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, this.T, this.f0));
            }
        }
    }

    public final void D() {
        getTopEdgeTreatment().e = getFabTranslationX();
        View y = y();
        this.Q.setInterpolation((!this.f0 || !A()) ? 0.0f : 1.0f);
        if (y != null) {
            y.setTranslationY(getFabTranslationY());
            y.setTranslationX(getFabTranslationX());
        }
    }

    public boolean E(@Px int i) {
        float f2 = (float) i;
        if (f2 == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f2);
        this.Q.invalidateSelf();
        return true;
    }

    public void createFabDefaultXAnimation(int i, List<Animator> list) {
        FloatingActionButton x = x();
        if (x != null && !x.isOrWillBeHidden()) {
            this.c0++;
            x.hide(new d(i));
        }
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = isLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                if (isLayoutRtl) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((isLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (isLayoutRtl ? this.i0 : -this.j0));
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.Q.getTintList();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d;
    }

    public int getFabAlignmentMode() {
        return this.T;
    }

    public int getFabAnimationMode() {
        return this.U;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().b;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().a;
    }

    public boolean getHideOnScroll() {
        return this.V;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.Q);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.S;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.R;
            if (animator2 != null) {
                animator2.cancel();
            }
            D();
        }
        C();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        this.T = fVar.b;
        this.f0 = fVar.c;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.b = this.T;
        fVar.c = this.f0;
        return fVar;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void replaceMenu(@MenuRes int i) {
        if (i != 0) {
            this.d0 = 0;
            getMenu().clear();
            inflateMenu(i);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.Q, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().b(f2);
            this.Q.invalidateSelf();
            D();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.Q.setElevation(f2);
        getBehavior().setAdditionalHiddenOffsetY(this, this.Q.getShadowRadius() - this.Q.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i) {
        setFabAlignmentModeAndReplaceMenu(i, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i, @MenuRes int i2) {
        this.d0 = i2;
        this.e0 = true;
        B(i, this.f0);
        if (this.T != i && ViewCompat.isLaidOut(this)) {
            Animator animator = this.R;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.U == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(x(), "translationX", z(i));
                ofFloat.setDuration(300L);
                arrayList.add(ofFloat);
            } else {
                createFabDefaultXAnimation(i, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.R = animatorSet;
            animatorSet.addListener(new a2.j.b.d.d.a(this));
            this.R.start();
        }
        this.T = i;
    }

    public void setFabAnimationMode(int i) {
        this.U = i;
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().b = f2;
            this.Q.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().a = f2;
            this.Q.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.V = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Nullable
    public final FloatingActionButton x() {
        View y = y();
        if (y instanceof FloatingActionButton) {
            return (FloatingActionButton) y;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View y() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.y():android.view.View");
    }

    public final float z(int i) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i2 = 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.P + (isLayoutRtl ? this.j0 : this.i0));
        if (isLayoutRtl) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.g0 == null) {
            this.g0 = new Behavior();
        }
        return this.g0;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.bottomappbar.BottomAppBar.m0
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            com.google.android.material.shape.MaterialShapeDrawable r11 = new com.google.android.material.shape.MaterialShapeDrawable
            r11.<init>()
            r10.Q = r11
            r7 = 0
            r10.c0 = r7
            r10.d0 = r7
            r10.e0 = r7
            r0 = 1
            r10.f0 = r0
            com.google.android.material.bottomappbar.BottomAppBar$a r0 = new com.google.android.material.bottomappbar.BottomAppBar$a
            r0.<init>()
            r10.k0 = r0
            com.google.android.material.bottomappbar.BottomAppBar$b r0 = new com.google.android.material.bottomappbar.BottomAppBar$b
            r0.<init>()
            r10.l0 = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r0, r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.T = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.U = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.V = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.W = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.a0 = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.b0 = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.P = r0
            com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment r0 = new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
            r0.<init>(r3, r4, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r3 = com.google.android.material.shape.ShapeAppearanceModel.builder()
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = r3.setTopEdge(r0)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.build()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.setShadowCompatibilityMode(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.setPaintStyle(r0)
            r11.initializeElevationOverlay(r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r1)
            androidx.core.view.ViewCompat.setBackground(r10, r11)
            com.google.android.material.bottomappbar.BottomAppBar$c r11 = new com.google.android.material.bottomappbar.BottomAppBar$c
            r11.<init>()
            com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
