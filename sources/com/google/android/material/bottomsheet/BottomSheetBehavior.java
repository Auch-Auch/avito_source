package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int R = R.style.Widget_Design_BottomSheet_Modal;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    @Nullable
    public ViewDragHelper A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    @Nullable
    public WeakReference<V> H;
    @Nullable
    public WeakReference<View> I;
    @NonNull
    public final ArrayList<BottomSheetCallback> J = new ArrayList<>();
    @Nullable
    public VelocityTracker K;
    public int L;
    public int M;
    public boolean N;
    @Nullable
    public Map<View, Integer> O;
    public int P = -1;
    public final ViewDragHelper.Callback Q = new b();
    public int a = 0;
    public boolean b = true;
    public boolean c = false;
    public float d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public MaterialShapeDrawable j;
    public int k;
    public boolean l;
    public ShapeAppearanceModel m;
    public boolean n;
    public BottomSheetBehavior<V>.c o = null;
    @Nullable
    public ValueAnimator p;
    public int q;
    public int r;
    public int s;
    public float t = 0.5f;
    public int u;
    public float v = -1.0f;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public int z = 4;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f);

        public abstract void onStateChanged(@NonNull View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
            parcel.writeInt(this.f ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            boolean z = false;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
            this.f = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.b = bottomSheetBehavior.z;
            this.c = bottomSheetBehavior.e;
            this.d = bottomSheetBehavior.b;
            this.e = bottomSheetBehavior.w;
            this.f = bottomSheetBehavior.x;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.b = i;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        public a(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.h(this.a, this.b);
        }
    }

    public class b extends ViewDragHelper.Callback {
        public b() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i, expandedOffset, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.w) {
                return bottomSheetBehavior.G;
            }
            return bottomSheetBehavior.u;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.y) {
                    bottomSheetBehavior.g(1);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.d(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f, float f2) {
            int i;
            int i2 = 4;
            if (f2 < 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.b) {
                    i = bottomSheetBehavior.r;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior2.s;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                        BottomSheetBehavior.this.k(view, i2, i, true);
                    }
                    i = bottomSheetBehavior2.q;
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.w && bottomSheetBehavior3.j(view, f2)) {
                    if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior4.getExpandedOffset() + bottomSheetBehavior4.G) / 2)) {
                            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                            if (bottomSheetBehavior5.b) {
                                i = bottomSheetBehavior5.r;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.q) < Math.abs(view.getTop() - BottomSheetBehavior.this.s)) {
                                i = BottomSheetBehavior.this.q;
                            } else {
                                i = BottomSheetBehavior.this.s;
                                i2 = 6;
                                BottomSheetBehavior.this.k(view, i2, i, true);
                            }
                        }
                    }
                    i = BottomSheetBehavior.this.G;
                    i2 = 5;
                    BottomSheetBehavior.this.k(view, i2, i, true);
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.b) {
                        int i4 = bottomSheetBehavior6.s;
                        if (top3 < i4) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior6.u)) {
                                i = BottomSheetBehavior.this.q;
                            } else {
                                i = BottomSheetBehavior.this.s;
                            }
                        } else if (Math.abs(top3 - i4) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                            i = BottomSheetBehavior.this.s;
                        } else {
                            i = BottomSheetBehavior.this.u;
                            BottomSheetBehavior.this.k(view, i2, i, true);
                        }
                        i2 = 6;
                        BottomSheetBehavior.this.k(view, i2, i, true);
                    } else if (Math.abs(top3 - bottomSheetBehavior6.r) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                        i = BottomSheetBehavior.this.r;
                    } else {
                        i = BottomSheetBehavior.this.u;
                        BottomSheetBehavior.this.k(view, i2, i, true);
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior7.b) {
                        i = bottomSheetBehavior7.u;
                    } else {
                        int top4 = view.getTop();
                        if (Math.abs(top4 - BottomSheetBehavior.this.s) < Math.abs(top4 - BottomSheetBehavior.this.u)) {
                            i = BottomSheetBehavior.this.s;
                            i2 = 6;
                        } else {
                            i = BottomSheetBehavior.this.u;
                        }
                    }
                    BottomSheetBehavior.this.k(view, i2, i, true);
                }
            }
            i2 = 3;
            BottomSheetBehavior.this.k(view, i2, i, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.z;
            if (i2 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.L == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    public class c implements Runnable {
        public final View a;
        public boolean b;
        public int c;

        public c(View view, int i) {
            this.a = view;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.A;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.g(this.c);
            } else {
                ViewCompat.postOnAnimation(this.a, this);
            }
            this.b = false;
        }
    }

    public BottomSheetBehavior() {
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void a() {
        int b2 = b();
        if (this.b) {
            this.u = Math.max(this.G - b2, this.r);
        } else {
            this.u = this.G - b2;
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.J.contains(bottomSheetCallback)) {
            this.J.add(bottomSheetCallback);
        }
    }

    public final int b() {
        int i2;
        if (this.f) {
            return Math.min(Math.max(this.g, this.G - ((this.F * 9) / 16)), this.E);
        }
        if (this.l || (i2 = this.k) <= 0) {
            return this.e;
        }
        return Math.max(this.e, i2 + this.h);
    }

    public final void c(@NonNull Context context, AttributeSet attributeSet, boolean z2, @Nullable ColorStateList colorStateList) {
        if (this.i) {
            this.m = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, R).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.m);
            this.j = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.j.setTint(typedValue.data);
                return;
            }
            this.j.setFillColor(colorStateList);
        }
    }

    public void d(int i2) {
        float f2;
        float f3;
        V v2 = this.H.get();
        if (!(v2 == null || this.J.isEmpty())) {
            int i3 = this.u;
            if (i2 > i3 || i3 == getExpandedOffset()) {
                int i4 = this.u;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.G - i4);
            } else {
                int i5 = this.u;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - getExpandedOffset());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.J.size(); i6++) {
                this.J.get(i6).onSlide(v2, f4);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.p = null;
    }

    @Nullable
    @VisibleForTesting
    public View e(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View e2 = e(viewGroup.getChildAt(i2));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    public final void f(V v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v2, accessibilityActionCompat, null, new a2.j.b.d.f.c(this, i2));
    }

    public void g(int i2) {
        V v2;
        if (this.z != i2) {
            this.z = i2;
            WeakReference<V> weakReference = this.H;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    n(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    n(false);
                }
                m(i2);
                for (int i3 = 0; i3 < this.J.size(); i3++) {
                    this.J.get(i3).onStateChanged(v2, i2);
                }
                l();
            }
        }
    }

    public int getExpandedOffset() {
        return this.b ? this.r : this.q;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getHalfExpandedRatio() {
        return this.t;
    }

    public int getPeekHeight() {
        if (this.f) {
            return -1;
        }
        return this.e;
    }

    public int getSaveFlags() {
        return this.a;
    }

    public boolean getSkipCollapsed() {
        return this.x;
    }

    public int getState() {
        return this.z;
    }

    public void h(@NonNull View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.u;
        } else if (i2 == 6) {
            i3 = this.s;
            if (this.b && i3 <= (i4 = this.r)) {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = getExpandedOffset();
        } else if (!this.w || i2 != 5) {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Illegal state argument: ", i2));
        } else {
            i3 = this.G;
        }
        k(view, i2, i3, false);
    }

    public final void i(int i2) {
        V v2 = this.H.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(v2)) {
                h(v2, i2);
            } else {
                v2.post(new a(v2, i2));
            }
        }
    }

    public boolean isDraggable() {
        return this.y;
    }

    public boolean isFitToContents() {
        return this.b;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.l;
    }

    public boolean isHideable() {
        return this.w;
    }

    public boolean j(@NonNull View view, float f2) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        if (Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.u)) / ((float) b()) > 0.5f) {
            return true;
        }
        return false;
    }

    public void k(View view, int i2, int i3, boolean z2) {
        ViewDragHelper viewDragHelper = this.A;
        if (viewDragHelper != null && (!z2 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : viewDragHelper.settleCapturedViewAt(view.getLeft(), i3))) {
            g(2);
            m(i2);
            if (this.o == null) {
                this.o = new c(view, i2);
            }
            BottomSheetBehavior<V>.c cVar = this.o;
            if (!cVar.b) {
                cVar.c = i2;
                ViewCompat.postOnAnimation(view, cVar);
                this.o.b = true;
                return;
            }
            cVar.c = i2;
            return;
        }
        g(i2);
    }

    public final void l() {
        V v2;
        WeakReference<V> weakReference = this.H;
        if (weakReference != null && (v2 = weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(v2, 524288);
            ViewCompat.removeAccessibilityAction(v2, 262144);
            ViewCompat.removeAccessibilityAction(v2, 1048576);
            int i2 = this.P;
            if (i2 != -1) {
                ViewCompat.removeAccessibilityAction(v2, i2);
            }
            int i3 = 6;
            if (this.z != 6) {
                this.P = ViewCompat.addAccessibilityAction(v2, v2.getResources().getString(R.string.bottomsheet_action_expand_halfway), new a2.j.b.d.f.c(this, 6));
            }
            if (this.w && this.z != 5) {
                f(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            int i4 = this.z;
            if (i4 == 3) {
                if (this.b) {
                    i3 = 4;
                }
                f(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i3);
            } else if (i4 == 4) {
                if (this.b) {
                    i3 = 3;
                }
                f(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i3);
            } else if (i4 == 6) {
                f(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                f(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    public final void m(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.n != z2) {
                this.n = z2;
                if (this.j != null && (valueAnimator = this.p) != null) {
                    if (valueAnimator.isRunning()) {
                        this.p.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.p.setFloatValues(1.0f - f2, f2);
                    this.p.start();
                }
            }
        }
    }

    public final void n(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.H;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.O == null) {
                        this.O = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.H.get()) {
                        if (z2) {
                            this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.c) {
                                ViewCompat.setImportantForAccessibility(childAt, 4);
                            }
                        } else if (this.c && (map = this.O) != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.O.get(childAt).intValue());
                        }
                    }
                }
                if (!z2) {
                    this.O = null;
                } else if (this.c) {
                    this.H.get().sendAccessibilityEvent(8);
                }
            }
        }
    }

    public final void o(boolean z2) {
        V v2;
        if (this.H != null) {
            a();
            if (this.z == 4 && (v2 = this.H.get()) != null) {
                if (z2) {
                    i(this.z);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v2.isShown() || !this.y) {
            this.B = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.M = (int) motionEvent.getY();
            if (this.z != 2) {
                WeakReference<View> weakReference = this.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x2, this.M)) {
                    this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.N = true;
                }
            }
            this.B = this.L == -1 && !coordinatorLayout.isPointInChildBounds(v2, x2, this.M);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.N = false;
            this.L = -1;
            if (this.B) {
                this.B = false;
                return false;
            }
        }
        if (!this.B && (viewDragHelper = this.A) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.I;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        if (actionMasked != 2 || view == null || this.B || this.z == 1 || coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.A == null || Math.abs(((float) this.M) - motionEvent.getY()) <= ((float) this.A.getTouchSlop())) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.f) {
                ViewUtils.doOnApplyWindowInsets(v2, new a2.j.b.d.f.b(this));
            }
            this.H = new WeakReference<>(v2);
            if (this.i && (materialShapeDrawable = this.j) != null) {
                ViewCompat.setBackground(v2, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.j;
            if (materialShapeDrawable2 != null) {
                float f2 = this.v;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(v2);
                }
                materialShapeDrawable2.setElevation(f2);
                boolean z2 = this.z == 3;
                this.n = z2;
                this.j.setInterpolation(z2 ? 0.0f : 1.0f);
            }
            l();
            if (ViewCompat.getImportantForAccessibility(v2) == 0) {
                ViewCompat.setImportantForAccessibility(v2, 1);
            }
        }
        if (this.A == null) {
            this.A = ViewDragHelper.create(coordinatorLayout, this.Q);
        }
        int top = v2.getTop();
        coordinatorLayout.onLayoutChild(v2, i2);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        this.s = (int) ((1.0f - this.t) * ((float) this.G));
        a();
        int i3 = this.z;
        if (i3 == 3) {
            ViewCompat.offsetTopAndBottom(v2, getExpandedOffset());
        } else if (i3 == 6) {
            ViewCompat.offsetTopAndBottom(v2, this.s);
        } else if (this.w && i3 == 5) {
            ViewCompat.offsetTopAndBottom(v2, this.G);
        } else if (i3 == 4) {
            ViewCompat.offsetTopAndBottom(v2, this.u);
        } else if (i3 == 1 || i3 == 2) {
            ViewCompat.offsetTopAndBottom(v2, top - v2.getTop());
        }
        this.I = new WeakReference<>(e(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.I;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.z != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.I;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                        g(3);
                    } else if (this.y) {
                        iArr[1] = i3;
                        ViewCompat.offsetTopAndBottom(v2, -i3);
                        g(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.u;
                    if (i5 > i6 && !this.w) {
                        iArr[1] = top - i6;
                        ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                        g(4);
                    } else if (this.y) {
                        iArr[1] = i3;
                        ViewCompat.offsetTopAndBottom(v2, -i3);
                        g(1);
                    } else {
                        return;
                    }
                }
                d(v2.getTop());
                this.C = i3;
                this.D = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.getSuperState());
        int i2 = this.a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.e = savedState.c;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.b = savedState.d;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.w = savedState.e;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.x = savedState.f;
            }
        }
        int i3 = savedState.b;
        if (i3 == 1 || i3 == 2) {
            this.z = 4;
        } else {
            this.z = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.C = 0;
        this.D = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2) {
        int i3;
        float f2;
        int i4 = 3;
        if (v2.getTop() == getExpandedOffset()) {
            g(3);
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (weakReference != null && view == weakReference.get() && this.D) {
            if (this.C > 0) {
                if (this.b) {
                    i3 = this.r;
                } else {
                    int top = v2.getTop();
                    int i5 = this.s;
                    if (top > i5) {
                        i3 = i5;
                    } else {
                        i3 = this.q;
                    }
                }
                k(v2, i4, i3, false);
                this.D = false;
            }
            if (this.w) {
                VelocityTracker velocityTracker = this.K;
                if (velocityTracker == null) {
                    f2 = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.d);
                    f2 = this.K.getYVelocity(this.L);
                }
                if (j(v2, f2)) {
                    i3 = this.G;
                    i4 = 5;
                    k(v2, i4, i3, false);
                    this.D = false;
                }
            }
            if (this.C == 0) {
                int top2 = v2.getTop();
                if (!this.b) {
                    int i6 = this.s;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.u)) {
                            i3 = this.q;
                            k(v2, i4, i3, false);
                            this.D = false;
                        }
                        i3 = this.s;
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.u)) {
                        i3 = this.s;
                    } else {
                        i3 = this.u;
                    }
                } else if (Math.abs(top2 - this.r) < Math.abs(top2 - this.u)) {
                    i3 = this.r;
                    k(v2, i4, i3, false);
                    this.D = false;
                } else {
                    i3 = this.u;
                }
            } else if (this.b) {
                i3 = this.u;
            } else {
                int top3 = v2.getTop();
                if (Math.abs(top3 - this.s) < Math.abs(top3 - this.u)) {
                    i3 = this.s;
                } else {
                    i3 = this.u;
                }
            }
            i4 = 4;
            k(v2, i4, i3, false);
            this.D = false;
            i4 = 6;
            k(v2, i4, i3, false);
            this.D = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.A;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B && Math.abs(((float) this.M) - motionEvent.getY()) > ((float) this.A.getTouchSlop())) {
            this.A.captureChildView(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.B;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.J.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.J.clear();
        if (bottomSheetCallback != null) {
            this.J.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z2) {
        this.y = z2;
    }

    public void setExpandedOffset(int i2) {
        if (i2 >= 0) {
            this.q = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z2) {
        if (this.b != z2) {
            this.b = z2;
            if (this.H != null) {
                a();
            }
            g((!this.b || this.z != 6) ? this.z : 3);
            l();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z2) {
        this.l = z2;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.t = f2;
        if (this.H != null) {
            this.s = (int) ((1.0f - f2) * ((float) this.G));
        }
    }

    public void setHideable(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            if (!z2 && this.z == 5) {
                setState(4);
            }
            l();
        }
    }

    public void setPeekHeight(int i2) {
        setPeekHeight(i2, false);
    }

    public void setSaveFlags(int i2) {
        this.a = i2;
    }

    public void setSkipCollapsed(boolean z2) {
        this.x = z2;
    }

    public void setState(int i2) {
        if (i2 != this.z) {
            if (this.H != null) {
                i(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.w && i2 == 5)) {
                this.z = i2;
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z2) {
        this.c = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f
            if (r4 != 0) goto L_0x0015
            r3.f = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.f
            if (r2 != 0) goto L_0x0017
            int r2 = r3.e
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.e = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.o(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.i = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            c(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i3));
        } else {
            c(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(500L);
        this.p.addUpdateListener(new a2.j.b.d.f.a(this));
        this.v = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i4 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i4);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        } else {
            setPeekHeight(i2);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i5);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i5, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
