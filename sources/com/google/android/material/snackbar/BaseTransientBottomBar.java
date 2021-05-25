package com.google.android.material.snackbar;

import a2.j.b.d.q.h;
import a2.j.b.d.q.i;
import a2.j.b.d.q.j;
import a2.j.b.d.q.k;
import a2.j.b.d.q.l;
import a2.j.b.d.q.m;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    @NonNull
    public static final Handler t = new Handler(Looper.getMainLooper(), new a());
    public static final int[] u = {R.attr.snackbarStyle};
    public static final String v = BaseTransientBottomBar.class.getSimpleName();
    @NonNull
    public final ViewGroup a;
    public final Context b;
    @NonNull
    public final ContentViewCallback c;
    public int d;
    public boolean e;
    @Nullable
    public View f;
    public boolean g;
    public final ViewTreeObserver.OnGlobalLayoutListener h;
    @RequiresApi(29)
    public final Runnable i;
    @Nullable
    public Rect j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public List<BaseCallback<B>> p;
    public Behavior q;
    @Nullable
    public final AccessibilityManager r;
    @NonNull
    public m.b s;
    @NonNull
    public final SnackbarBaseLayout view;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public void onDismissed(B b, int i) {
        }

        public void onShown(B b) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull
        public final BehaviorDelegate k = new BehaviorDelegate(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return this.k.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.k.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        public m.b a;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    m.b().f(this.a);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                m.b().e(this.a);
            }
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.s;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        public static final View.OnTouchListener h = new a();
        public OnLayoutChangeListener a;
        public OnAttachStateChangeListener b;
        public int c;
        public final float d;
        public final float e;
        public ColorStateList f;
        public PorterDuff.Mode g;

        public static class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        public float getActionTextColorAlpha() {
            return this.e;
        }

        public int getAnimationMode() {
            return this.c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.d;
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.b;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.b;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            OnLayoutChangeListener onLayoutChangeListener = this.a;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        public void setAnimationMode(int i) {
            this.c = i;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (!(drawable == null || this.f == null)) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f);
                DrawableCompat.setTintMode(drawable, this.g);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.g);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.g = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.b = onAttachStateChangeListener;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : h);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.a = onLayoutChangeListener;
        }

        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Drawable drawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(i, 0));
            }
            this.c = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.d = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(h);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
                if (this.f != null) {
                    drawable = DrawableCompat.wrap(gradientDrawable);
                    DrawableCompat.setTintList(drawable, this.f);
                } else {
                    drawable = DrawableCompat.wrap(gradientDrawable);
                }
                ViewCompat.setBackground(this, drawable);
            }
        }
    }

    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 0) {
                BaseTransientBottomBar<?> baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.view.setOnAttachStateChangeListener(new j(baseTransientBottomBar));
                if (baseTransientBottomBar.view.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.view.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                        SwipeDismissBehavior<? extends View> swipeDismissBehavior = baseTransientBottomBar.q;
                        if (swipeDismissBehavior == null) {
                            swipeDismissBehavior = baseTransientBottomBar.getNewBehavior();
                        }
                        if (swipeDismissBehavior instanceof Behavior) {
                            ((Behavior) swipeDismissBehavior).k.setBaseTransientBottomBar(baseTransientBottomBar);
                        }
                        swipeDismissBehavior.setListener(new l(baseTransientBottomBar));
                        layoutParams2.setBehavior(swipeDismissBehavior);
                        if (baseTransientBottomBar.f == null) {
                            layoutParams2.insetEdge = 80;
                        }
                    }
                    baseTransientBottomBar.o = baseTransientBottomBar.a();
                    baseTransientBottomBar.g();
                    baseTransientBottomBar.view.setVisibility(4);
                    baseTransientBottomBar.a.addView(baseTransientBottomBar.view);
                }
                if (ViewCompat.isLaidOut(baseTransientBottomBar.view)) {
                    baseTransientBottomBar.f();
                } else {
                    baseTransientBottomBar.view.setOnLayoutChangeListener(new k(baseTransientBottomBar));
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (!baseTransientBottomBar2.e() || baseTransientBottomBar2.view.getVisibility() != 0) {
                    baseTransientBottomBar2.c(i2);
                } else if (baseTransientBottomBar2.view.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                    ofFloat.addUpdateListener(new a2.j.b.d.q.d(baseTransientBottomBar2));
                    ofFloat.setDuration(75L);
                    ofFloat.addListener(new a2.j.b.d.q.c(baseTransientBottomBar2, i2));
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(0, baseTransientBottomBar2.b());
                    valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new h(baseTransientBottomBar2, i2));
                    valueAnimator.addUpdateListener(new i(baseTransientBottomBar2));
                    valueAnimator.start();
                }
                return true;
            }
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.g) {
                baseTransientBottomBar.o = baseTransientBottomBar.a();
                BaseTransientBottomBar.this.g();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.view != null && (context = baseTransientBottomBar.b) != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                int[] iArr = new int[2];
                baseTransientBottomBar2.view.getLocationOnScreen(iArr);
                int height = (i - (baseTransientBottomBar2.view.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.view.getTranslationY());
                BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                if (height < baseTransientBottomBar3.n) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.view.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        int i2 = BaseTransientBottomBar.ANIMATION_MODE_SLIDE;
                        String str = BaseTransientBottomBar.v;
                        return;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i3 = marginLayoutParams.bottomMargin;
                    BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                    marginLayoutParams.bottomMargin = (baseTransientBottomBar4.n - height) + i3;
                    baseTransientBottomBar4.view.requestLayout();
                }
            }
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public d() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.k = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.l = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.m = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.g();
            return windowInsetsCompat;
        }
    }

    public class e extends AccessibilityDelegateCompat {
        public e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            BaseTransientBottomBar.this.dismiss();
            return true;
        }
    }

    public class f implements m.b {
        public f() {
        }

        @Override // a2.j.b.d.q.m.b
        public void a(int i) {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // a2.j.b.d.q.m.b
        public void show() {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view2, contentViewCallback);
    }

    public final int a() {
        View view2 = this.f;
        if (view2 == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (this.a.getHeight() + iArr2[1]) - i2;
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(baseCallback);
        return this;
    }

    public final int b() {
        int height = this.view.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void c(int i2) {
        m b2 = m.b();
        m.b bVar = this.s;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.c = null;
                if (b2.d != null) {
                    b2.h();
                }
            }
        }
        List<BaseCallback<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).onDismissed(this, i2);
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    public void d() {
        m b2 = m.b();
        m.b bVar = this.s;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.g(b2.c);
            }
        }
        List<BaseCallback<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).onShown(this);
            }
        }
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int i2) {
        m b2 = m.b();
        m.b bVar = this.s;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.a(b2.c, i2);
            } else if (b2.d(bVar)) {
                b2.a(b2.d, i2);
            }
        }
    }

    public boolean e() {
        AccessibilityManager accessibilityManager = this.r;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void f() {
        if (e()) {
            this.view.post(new a2.j.b.d.q.a(this));
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        d();
    }

    public final void g() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.j) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + (this.f != null ? this.o : this.k);
            marginLayoutParams.leftMargin = rect.left + this.l;
            marginLayoutParams.rightMargin = rect.right + this.m;
            this.view.requestLayout();
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = false;
                if (this.n > 0 && !this.e) {
                    ViewGroup.LayoutParams layoutParams2 = this.view.getLayoutParams();
                    if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior() instanceof SwipeDismissBehavior)) {
                        z = true;
                    }
                }
                if (z) {
                    this.view.removeCallbacks(this.i);
                    this.view.post(this.i);
                }
            }
        }
    }

    @Nullable
    public View getAnchorView() {
        return this.f;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.q;
    }

    @NonNull
    public Context getContext() {
        return this.b;
    }

    public int getDuration() {
        return this.d;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(u);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.g;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.e;
    }

    public boolean isShown() {
        boolean c2;
        m b2 = m.b();
        m.b bVar = this.s;
        synchronized (b2.a) {
            c2 = b2.c(bVar);
        }
        return c2;
    }

    public boolean isShownOrQueued() {
        boolean z;
        m b2 = m.b();
        m.b bVar = this.s;
        synchronized (b2.a) {
            if (!b2.c(bVar)) {
                if (!b2.d(bVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> baseCallback) {
        List<BaseCallback<B>> list;
        if (baseCallback == null || (list = this.p) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View view2) {
        ViewUtils.removeOnGlobalLayoutListener(this.f, this.h);
        this.f = view2;
        ViewUtils.addOnGlobalLayoutListener(view2, this.h);
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z) {
        this.g = z;
    }

    @NonNull
    public B setAnimationMode(int i2) {
        this.view.setAnimationMode(i2);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior behavior) {
        this.q = behavior;
        return this;
    }

    @NonNull
    public B setDuration(int i2) {
        this.d = i2;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean z) {
        this.e = z;
        return this;
    }

    public void show() {
        m b2 = m.b();
        int duration = getDuration();
        m.b bVar = this.s;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                m.c cVar = b2.c;
                cVar.b = duration;
                b2.b.removeCallbacksAndMessages(cVar);
                b2.g(b2.c);
                return;
            }
            if (b2.d(bVar)) {
                b2.d.b = duration;
            } else {
                b2.d = new m.c(duration, bVar);
            }
            m.c cVar2 = b2.c;
            if (cVar2 == null || !b2.a(cVar2, 4)) {
                b2.c = null;
                b2.h();
            }
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback) {
        this.g = false;
        this.h = new b();
        this.i = new c();
        this.s = new f();
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback != null) {
            this.a = viewGroup;
            this.c = contentViewCallback;
            this.b = context;
            ThemeEnforcement.checkAppCompatTheme(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
            this.view = snackbarBaseLayout;
            if (view2 instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view2;
                float actionTextColorAlpha = snackbarBaseLayout.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.b.setTextColor(MaterialColors.layer(MaterialColors.getColor(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.b.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            snackbarBaseLayout.addView(view2);
            ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
            ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
            ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new d());
            ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new e());
            this.r = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    @NonNull
    public B setAnchorView(@IdRes int i2) {
        View findViewById = this.a.findViewById(i2);
        if (findViewById != null) {
            return setAnchorView(findViewById);
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Unable to find anchor view with id: ", i2));
    }
}
