package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public static final int F = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> G = new d(Float.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
    public static final Property<View, Float> H = new e(Float.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    public static final Property<View, Float> I = new f(Float.class, "paddingStart");
    public static final Property<View, Float> J = new g(Float.class, "paddingEnd");
    public int A;
    @NonNull
    public final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> B;
    public boolean C;
    public boolean D;
    public boolean E;
    @NonNull
    public ColorStateList originalTextCsl;
    public int s;
    public final a2.j.b.d.k.a t;
    @NonNull
    public final a2.j.b.d.k.k u;
    @NonNull
    public final a2.j.b.d.k.k v;
    public final a2.j.b.d.k.k w;
    public final a2.j.b.d.k.k x;
    public final int y;
    public int z;

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public Rect a;
        public boolean b;
        public boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        public static boolean a(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean b(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((this.b || this.c) && layoutParams.getAnchorId() == view.getId()) {
                return true;
            }
            return false;
        }

        public final boolean c(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!b(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public final boolean d(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!b(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public void extendOrShow(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            a2.j.b.d.k.k kVar;
            if (this.c) {
                kVar = extendedFloatingActionButton.v;
            } else {
                kVar = extendedFloatingActionButton.w;
            }
            int i = ExtendedFloatingActionButton.F;
            extendedFloatingActionButton.i(kVar, null);
        }

        public boolean isAutoHideEnabled() {
            return this.b;
        }

        public boolean isAutoShrinkEnabled() {
            return this.c;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z) {
            this.b = z;
        }

        public void setAutoShrinkEnabled(boolean z) {
            this.c = z;
        }

        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            a2.j.b.d.k.k kVar;
            if (this.c) {
                kVar = extendedFloatingActionButton.u;
            } else {
                kVar = extendedFloatingActionButton.x;
            }
            int i = ExtendedFloatingActionButton.F;
            extendedFloatingActionButton.i(kVar, null);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                c(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                d(view, extendedFloatingActionButton);
                return false;
            }
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && d(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (c(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.b = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    public class a implements k {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getWidth() {
            int measuredWidth = ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return measuredWidth + extendedFloatingActionButton.z + extendedFloatingActionButton.A;
        }
    }

    public class b implements k {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.getCollapsedSize(), ExtendedFloatingActionButton.this.getCollapsedSize());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ a2.j.b.d.k.k b;
        public final /* synthetic */ OnChangedCallback c;

        public c(ExtendedFloatingActionButton extendedFloatingActionButton, a2.j.b.d.k.k kVar, OnChangedCallback onChangedCallback) {
            this.b = kVar;
            this.c = onChangedCallback;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.g();
            if (!this.a) {
                this.b.d(this.c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().width = f.intValue();
            view2.requestLayout();
        }
    }

    public static class e extends Property<View, Float> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().height = f.intValue();
            view2.requestLayout();
        }
    }

    public static class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf((float) ViewCompat.getPaddingStart(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, f.intValue(), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom());
        }
    }

    public static class g extends Property<View, Float> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf((float) ViewCompat.getPaddingEnd(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
        }
    }

    public class h extends a2.j.b.d.k.b {
        public final k g;
        public final boolean h;

        public h(a2.j.b.d.k.a aVar, k kVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.g = kVar;
            this.h = z;
        }

        @Override // a2.j.b.d.k.k
        public boolean a() {
            boolean z = this.h;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return z == extendedFloatingActionButton.C || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // a2.j.b.d.k.k
        public int b() {
            return this.h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        @NonNull
        public AnimatorSet c() {
            MotionSpec i2 = i();
            if (i2.hasPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] propertyValues = i2.getPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                propertyValues[0].setFloatValues((float) ExtendedFloatingActionButton.this.getWidth(), (float) this.g.getWidth());
                i2.setPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, propertyValues);
            }
            if (i2.hasPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] propertyValues2 = i2.getPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                propertyValues2[0].setFloatValues((float) ExtendedFloatingActionButton.this.getHeight(), (float) this.g.getHeight());
                i2.setPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, propertyValues2);
            }
            if (i2.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = i2.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues((float) ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), (float) this.g.getPaddingStart());
                i2.setPropertyValues("paddingStart", propertyValues3);
            }
            if (i2.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = i2.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues((float) ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), (float) this.g.getPaddingEnd());
                i2.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (i2.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = i2.getPropertyValues("labelOpacity");
                boolean z = this.h;
                float f = 0.0f;
                float f2 = z ? 0.0f : 1.0f;
                if (z) {
                    f = 1.0f;
                }
                propertyValues5[0].setFloatValues(f2, f);
                i2.setPropertyValues("labelOpacity", propertyValues5);
            }
            return h(i2);
        }

        @Override // a2.j.b.d.k.k
        public void d(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                if (this.h) {
                    onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
                } else {
                    onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
                }
            }
        }

        @Override // a2.j.b.d.k.k
        public void e() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.C = this.h;
            ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.g.getLayoutParams().width;
                layoutParams.height = this.g.getLayoutParams().height;
                ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void g() {
            super.g();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.D = false;
            extendedFloatingActionButton.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.g.getLayoutParams().width;
                layoutParams.height = this.g.getLayoutParams().height;
            }
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void onAnimationStart(Animator animator) {
            a2.j.b.d.k.a aVar = this.d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.C = this.h;
            extendedFloatingActionButton.D = true;
            extendedFloatingActionButton.setHorizontallyScrolling(true);
        }
    }

    public class i extends a2.j.b.d.k.b {
        public boolean g;

        public i(a2.j.b.d.k.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // a2.j.b.d.k.k
        public boolean a() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            int i = ExtendedFloatingActionButton.F;
            if (extendedFloatingActionButton.getVisibility() == 0) {
                if (extendedFloatingActionButton.s != 1) {
                    return false;
                }
            } else if (extendedFloatingActionButton.s == 2) {
                return false;
            }
            return true;
        }

        @Override // a2.j.b.d.k.k
        public int b() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // a2.j.b.d.k.k
        public void d(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        @Override // a2.j.b.d.k.k
        public void e() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void f() {
            this.d.a = null;
            this.g = true;
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void g() {
            super.g();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.s = 0;
            if (!this.g) {
                extendedFloatingActionButton.setVisibility(8);
            }
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void onAnimationStart(Animator animator) {
            a2.j.b.d.k.a aVar = this.d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            this.g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.s = 1;
        }
    }

    public class j extends a2.j.b.d.k.b {
        public j(a2.j.b.d.k.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // a2.j.b.d.k.k
        public boolean a() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            int i = ExtendedFloatingActionButton.F;
            return extendedFloatingActionButton.h();
        }

        @Override // a2.j.b.d.k.k
        public int b() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // a2.j.b.d.k.k
        public void d(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        @Override // a2.j.b.d.k.k
        public void e() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void g() {
            super.g();
            ExtendedFloatingActionButton.this.s = 0;
        }

        @Override // a2.j.b.d.k.b, a2.j.b.d.k.k
        public void onAnimationStart(Animator animator) {
            a2.j.b.d.k.a aVar = this.d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.s = 2;
        }
    }

    public interface k {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.v).c.add(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.x).c.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.w).c.add(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.u).c.add(animatorListener);
    }

    public void extend() {
        i(this.v, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.B;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i2 = this.y;
        return i2 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i2;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return ((a2.j.b.d.k.b) this.v).f;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return ((a2.j.b.d.k.b) this.x).f;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return ((a2.j.b.d.k.b) this.w).f;
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return ((a2.j.b.d.k.b) this.u).f;
    }

    public final boolean h() {
        if (getVisibility() != 0) {
            if (this.s == 2) {
                return true;
            }
            return false;
        } else if (this.s != 1) {
            return true;
        } else {
            return false;
        }
    }

    public void hide() {
        i(this.x, null);
    }

    public final void i(@NonNull a2.j.b.d.k.k kVar, @Nullable OnChangedCallback onChangedCallback) {
        if (!kVar.a()) {
            if (!((ViewCompat.isLaidOut(this) || (!h() && this.E)) && !isInEditMode())) {
                kVar.e();
                kVar.d(onChangedCallback);
                return;
            }
            measure(0, 0);
            AnimatorSet c2 = kVar.c();
            c2.addListener(new c(this, kVar, onChangedCallback));
            for (Animator.AnimatorListener animatorListener : ((a2.j.b.d.k.b) kVar).c) {
                c2.addListener(animatorListener);
            }
            c2.start();
        }
    }

    public final boolean isExtended() {
        return this.C;
    }

    public final void j() {
        this.originalTextCsl = getTextColors();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.C = false;
            this.u.e();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.v).c.remove(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.x).c.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.w).c.remove(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((a2.j.b.d.k.b) this.u).c.remove(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.E = z2;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        ((a2.j.b.d.k.b) this.v).f = motionSpec;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i2));
    }

    public void setExtended(boolean z2) {
        if (this.C != z2) {
            a2.j.b.d.k.k kVar = z2 ? this.v : this.u;
            if (!kVar.a()) {
                kVar.e();
            }
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ((a2.j.b.d.k.b) this.x).f = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (this.C && !this.D) {
            this.z = ViewCompat.getPaddingStart(this);
            this.A = ViewCompat.getPaddingEnd(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (this.C && !this.D) {
            this.z = i2;
            this.A = i4;
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ((a2.j.b.d.k.b) this.w).f = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        ((a2.j.b.d.k.b) this.u).f = motionSpec;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        j();
    }

    public void show() {
        i(this.w, null);
    }

    public void shrink() {
        i(this.u, null);
    }

    public void silentlyUpdateTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback onChangedCallback) {
        i(this.v, onChangedCallback);
    }

    public void hide(@NonNull OnChangedCallback onChangedCallback) {
        i(this.x, onChangedCallback);
    }

    public void show(@NonNull OnChangedCallback onChangedCallback) {
        i(this.w, onChangedCallback);
    }

    public void shrink(@NonNull OnChangedCallback onChangedCallback) {
        i(this.u, onChangedCallback);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.F
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.s = r10
            a2.j.b.d.k.a r1 = new a2.j.b.d.k.a
            r1.<init>()
            r0.t = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            r11.<init>(r1)
            r0.w = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i
            r12.<init>(r1)
            r0.x = r12
            r13 = 1
            r0.C = r13
            r0.D = r10
            r0.E = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.B = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.y = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.z = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.A = r6
            a2.j.b.d.k.a r6 = new a2.j.b.d.k.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.v = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.u = r10
            r11.f = r2
            r12.f = r3
            r15.f = r4
            r10.f = r5
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.PILL
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder(r14, r2, r8, r9, r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.build()
            r0.setShapeAppearanceModel(r1)
            r16.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        j();
    }
}
