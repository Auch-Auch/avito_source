package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int Q = R.style.Widget_Design_TabLayout;
    public static final Pools.Pool<Tab> R = new Pools.SynchronizedPool(16);
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public a2.j.b.d.r.b E;
    @Nullable
    public BaseOnTabSelectedListener F;
    public final ArrayList<BaseOnTabSelectedListener> G;
    @Nullable
    public BaseOnTabSelectedListener H;
    public ValueAnimator I;
    @Nullable
    public ViewPager J;
    @Nullable
    public PagerAdapter K;
    public DataSetObserver L;
    public TabLayoutOnPageChangeListener M;
    public b N;
    public boolean O;
    public final Pools.Pool<TabView> P;
    public final ArrayList<Tab> a;
    @Nullable
    public Tab b;
    @NonNull
    public final d c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public ColorStateList i;
    public ColorStateList j;
    public ColorStateList k;
    @NonNull
    public Drawable l;
    public int m;
    public PorterDuff.Mode n;
    public float o;
    public float p;
    public final int q;
    public int r;
    public final int s;
    public final int t;
    public final int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @NonNull
        public final WeakReference<TabLayout> a;
        public int b;
        public int c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z = false;
                boolean z2 = i3 != 2 || this.b == 1;
                if (!(i3 == 2 && this.b == 0)) {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.c;
                tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.b == 0));
            }
        }
    }

    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int l = 0;
        public Tab a;
        public TextView b;
        public ImageView c;
        @Nullable
        public View d;
        @Nullable
        public BadgeDrawable e;
        @Nullable
        public View f;
        @Nullable
        public TextView g;
        @Nullable
        public ImageView h;
        @Nullable
        public Drawable i;
        public int j = 2;

        public TabView(@NonNull Context context) {
            super(context);
            j(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.d, TabLayout.this.e, TabLayout.this.f, TabLayout.this.g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @Nullable
        private BadgeDrawable getBadge() {
            return this.e;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.e == null) {
                this.e = BadgeDrawable.create(getContext());
            }
            g();
            BadgeDrawable badgeDrawable = this.e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Nullable
        public final FrameLayout c(@NonNull View view) {
            if ((view == this.c || view == this.b) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        public final boolean d() {
            return this.e != null;
        }

        @Override // android.view.View, android.view.ViewGroup
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.i;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.i.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(@Nullable View view) {
            if (d() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                BadgeUtils.attachBadgeDrawable(this.e, view, c(view));
                this.d = view;
            }
        }

        public final void f() {
            if (d()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.d;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.e, view);
                    this.d = null;
                }
            }
        }

        public final void g() {
            Tab tab;
            Tab tab2;
            if (d()) {
                if (this.f != null) {
                    f();
                } else if (this.c != null && (tab2 = this.a) != null && tab2.getIcon() != null) {
                    View view = this.d;
                    ImageView imageView = this.c;
                    if (view != imageView) {
                        f();
                        e(this.c);
                        return;
                    }
                    h(imageView);
                } else if (this.b == null || (tab = this.a) == null || tab.getTabLabelVisibility() != 1) {
                    f();
                } else {
                    View view2 = this.d;
                    TextView textView = this.b;
                    if (view2 != textView) {
                        f();
                        e(this.b);
                        return;
                    }
                    h(textView);
                }
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.b, this.c, this.f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public int getContentWidth() {
            View[] viewArr = {this.b, this.c, this.f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        @Nullable
        public Tab getTab() {
            return this.a;
        }

        public final void h(@NonNull View view) {
            if (d() && view == this.d) {
                BadgeUtils.setBadgeDrawableBounds(this.e, view, c(view));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.tabs.TabLayout$TabView */
        /* JADX WARN: Multi-variable type inference failed */
        public final void i() {
            FrameLayout frameLayout;
            FrameLayout frameLayout2;
            Tab tab = this.a;
            Drawable drawable = null;
            View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f = customView;
                TextView textView = this.b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) customView.findViewById(16908308);
                this.g = textView2;
                if (textView2 != null) {
                    this.j = TextViewCompat.getMaxLines(textView2);
                }
                this.h = (ImageView) customView.findViewById(16908294);
            } else {
                View view = this.f;
                if (view != null) {
                    removeView(view);
                    this.f = null;
                }
                this.g = null;
                this.h = null;
            }
            boolean z = false;
            if (this.f == null) {
                if (this.c == null) {
                    if (BadgeUtils.USE_COMPAT_PARENT) {
                        frameLayout2 = new FrameLayout(getContext());
                        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                        addView(frameLayout2, 0);
                    } else {
                        frameLayout2 = this;
                    }
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout2, false);
                    this.c = imageView2;
                    frameLayout2.addView(imageView2, 0);
                }
                if (!(tab == null || tab.getIcon() == null)) {
                    drawable = DrawableCompat.wrap(tab.getIcon()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, TabLayout.this.j);
                    PorterDuff.Mode mode = TabLayout.this.n;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.b == null) {
                    if (BadgeUtils.USE_COMPAT_PARENT) {
                        frameLayout = new FrameLayout(getContext());
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                        addView(frameLayout);
                    } else {
                        frameLayout = this;
                    }
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
                    this.b = textView3;
                    frameLayout.addView(textView3);
                    this.j = TextViewCompat.getMaxLines(this.b);
                }
                TextViewCompat.setTextAppearance(this.b, TabLayout.this.h);
                ColorStateList colorStateList = TabLayout.this.i;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                k(this.b, this.c);
                g();
                ImageView imageView3 = this.c;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new a2.j.b.d.r.c(this, imageView3));
                }
                TextView textView4 = this.b;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new a2.j.b.d.r.c(this, textView4));
                }
            } else {
                TextView textView5 = this.g;
                if (!(textView5 == null && this.h == null)) {
                    k(textView5, this.h);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.d)) {
                setContentDescription(tab.d);
            }
            if (tab != null && tab.isSelected()) {
                z = true;
            }
            setSelected(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void j(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.q
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r0)
                r5.i = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.i
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.i = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.k
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.k
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.D
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.ViewCompat.setBackground(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.j(android.content.Context):void");
        }

        public final void k(@Nullable TextView textView, @Nullable ImageView imageView) {
            Tab tab = this.a;
            CharSequence charSequence = null;
            Drawable mutate = (tab == null || tab.getIcon() == null) ? null : DrawableCompat.wrap(this.a.getIcon()).mutate();
            Tab tab2 = this.a;
            CharSequence text = tab2 != null ? tab2.getText() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (textView != null) {
                if (z) {
                    textView.setText(text);
                    if (this.a.g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int dpToPx = (!z || imageView.getVisibility() != 0) ? 0 : (int) ViewUtils.dpToPx(getContext(), 8);
                if (TabLayout.this.A) {
                    if (dpToPx != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, dpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (dpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = dpToPx;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.a;
            if (tab3 != null) {
                charSequence = tab3.d;
            }
            if (!z) {
                text = charSequence;
            }
            TooltipCompat.setTooltipText(this, text);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.e.getContentDescription()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.a.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0096;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.getTabMaxWidth()
                if (r2 <= 0) goto L_0x001e
                if (r1 == 0) goto L_0x0014
                if (r0 <= r2) goto L_0x001e
            L_0x0014:
                com.google.android.material.tabs.TabLayout r8 = com.google.android.material.tabs.TabLayout.this
                int r8 = r8.r
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L_0x001e:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.b
                if (r0 == 0) goto L_0x00a6
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.o
                int r1 = r7.j
                android.widget.ImageView r2 = r7.c
                r3 = 1
                if (r2 == 0) goto L_0x0038
                int r2 = r2.getVisibility()
                if (r2 != 0) goto L_0x0038
                r1 = 1
                goto L_0x0046
            L_0x0038:
                android.widget.TextView r2 = r7.b
                if (r2 == 0) goto L_0x0046
                int r2 = r2.getLineCount()
                if (r2 <= r3) goto L_0x0046
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.p
            L_0x0046:
                android.widget.TextView r2 = r7.b
                float r2 = r2.getTextSize()
                android.widget.TextView r4 = r7.b
                int r4 = r4.getLineCount()
                android.widget.TextView r5 = r7.b
                int r5 = androidx.core.widget.TextViewCompat.getMaxLines(r5)
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x0060
                if (r5 < 0) goto L_0x00a6
                if (r1 == r5) goto L_0x00a6
            L_0x0060:
                com.google.android.material.tabs.TabLayout r5 = com.google.android.material.tabs.TabLayout.this
                int r5 = r5.z
                r6 = 0
                if (r5 != r3) goto L_0x0097
                if (r2 <= 0) goto L_0x0097
                if (r4 != r3) goto L_0x0097
                android.widget.TextView r2 = r7.b
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L_0x0096
                float r4 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r4
                int r4 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r7.getPaddingRight()
                int r4 = r4 - r5
                float r4 = (float) r4
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0097
            L_0x0096:
                r3 = 0
            L_0x0097:
                if (r3 == 0) goto L_0x00a6
                android.widget.TextView r2 = r7.b
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.b
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            L_0x00a6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.a.select();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@Nullable Tab tab) {
            if (tab != this.a) {
                this.a = tab;
                i();
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public final ViewPager a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab tab) {
            this.a.setCurrentItem(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {
        public boolean a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.J == viewPager) {
                tabLayout.i(pagerAdapter2, this.a);
            }
        }
    }

    public class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.g();
        }
    }

    public class d extends LinearLayout {
        public ValueAnimator a;
        public int b = -1;
        public float c;
        public int d = -1;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                d.this.c(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.b = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.b = this.a;
            }
        }

        public d(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void a() {
            View childAt = getChildAt(this.b);
            TabLayout tabLayout = TabLayout.this;
            a2.j.b.d.r.b bVar = tabLayout.E;
            Drawable drawable = tabLayout.l;
            Objects.requireNonNull(bVar);
            RectF a3 = a2.j.b.d.r.b.a(tabLayout, childAt);
            drawable.setBounds((int) a3.left, drawable.getBounds().top, (int) a3.right, drawable.getBounds().bottom);
        }

        public void b(int i) {
            Rect bounds = TabLayout.this.l.getBounds();
            TabLayout.this.l.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        public final void c(View view, View view2, float f) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.E.b(tabLayout, view, view2, f, tabLayout.l);
            } else {
                Drawable drawable = TabLayout.this.l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.l.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public final void d(boolean z, int i, int i2) {
            View childAt = getChildAt(this.b);
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                a();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.a = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration((long) i2);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i));
                valueAnimator.start();
                return;
            }
            this.a.removeAllUpdateListeners();
            this.a.addUpdateListener(aVar);
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height = TabLayout.this.l.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.l.getIntrinsicHeight();
            }
            int i = TabLayout.this.y;
            int i2 = 0;
            if (i == 0) {
                i2 = getHeight() - height;
                height = getHeight();
            } else if (i == 1) {
                i2 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i != 2) {
                if (i != 3) {
                    height = 0;
                } else {
                    height = getHeight();
                }
            }
            if (TabLayout.this.l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.l.getBounds();
                TabLayout.this.l.setBounds(bounds.left, i2, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.l;
                if (tabLayout.m != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.m, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawable, TabLayout.this.m);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                d(false, this.b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.w == 1 || tabLayout.z == 2) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.w = 0;
                            tabLayout2.m(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.d != i) {
                requestLayout();
                this.d = i;
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    public static ColorStateList e(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.a.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Tab tab = this.a.get(i2);
                if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.A) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            return this.u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.c.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.c.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public final void a(View view) {
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            Tab newTab = newTab();
            CharSequence charSequence = tabItem.text;
            if (charSequence != null) {
                newTab.setText(charSequence);
            }
            Drawable drawable = tabItem.icon;
            if (drawable != null) {
                newTab.setIcon(drawable);
            }
            int i2 = tabItem.customLayout;
            if (i2 != 0) {
                newTab.setCustomView(i2);
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                newTab.setContentDescription(tabItem.getContentDescription());
            }
            addTab(newTab);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.a.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public final void b(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                d dVar = this.c;
                int childCount = dVar.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        z2 = false;
                        break;
                    } else if (dVar.getChildAt(i3).getWidth() <= 0) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    int scrollX = getScrollX();
                    int d2 = d(i2, 0.0f);
                    if (scrollX != d2) {
                        f();
                        this.I.setIntValues(scrollX, d2);
                        this.I.start();
                    }
                    d dVar2 = this.c;
                    int i4 = this.x;
                    ValueAnimator valueAnimator = dVar2.a;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        dVar2.a.cancel();
                    }
                    dVar2.d(true, i2, i4);
                    return;
                }
            }
            setScrollPosition(i2, 0.0f, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 != 2) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r4 = this;
            int r0 = r4.z
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x000b
            if (r0 != r1) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r0 = 0
            goto L_0x0014
        L_0x000b:
            int r0 = r4.v
            int r3 = r4.d
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L_0x0014:
            com.google.android.material.tabs.TabLayout$d r3 = r4.c
            androidx.core.view.ViewCompat.setPaddingRelative(r3, r0, r2, r2, r2)
            int r0 = r4.z
            r2 = 1
            if (r0 == 0) goto L_0x002b
            if (r0 == r2) goto L_0x0023
            if (r0 == r1) goto L_0x0023
            goto L_0x0042
        L_0x0023:
            int r0 = r4.w
            com.google.android.material.tabs.TabLayout$d r0 = r4.c
            r0.setGravity(r2)
            goto L_0x0042
        L_0x002b:
            int r0 = r4.w
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0034
            if (r0 == r1) goto L_0x003a
            goto L_0x0042
        L_0x0034:
            com.google.android.material.tabs.TabLayout$d r0 = r4.c
            r0.setGravity(r2)
            goto L_0x0042
        L_0x003a:
            com.google.android.material.tabs.TabLayout$d r0 = r4.c
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r1)
        L_0x0042:
            r4.m(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.c():void");
    }

    public void clearOnTabSelectedListeners() {
        this.G.clear();
    }

    public Tab createTabFromPool() {
        Tab acquire = R.acquire();
        return acquire == null ? new Tab() : acquire;
    }

    public final int d(int i2, float f2) {
        int i3 = this.z;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.c.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.c.getChildCount() ? this.c.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i6 : left - i6;
    }

    public final void f() {
        if (this.I == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.I = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.I.setDuration((long) this.x);
            this.I.addUpdateListener(new a());
        }
    }

    public void g() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.K;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                addTab(newTab().setText(this.K.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.J;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public int getSelectedTabPosition() {
        Tab tab = this.b;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.a.get(i2);
    }

    public int getTabCount() {
        return this.a.size();
    }

    public int getTabGravity() {
        return this.w;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.C;
    }

    public int getTabIndicatorGravity() {
        return this.y;
    }

    public int getTabMaxWidth() {
        return this.r;
    }

    public int getTabMode() {
        return this.z;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.k;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.l;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.i;
    }

    public final void h(int i2) {
        TabView tabView = (TabView) this.c.getChildAt(i2);
        this.c.removeViewAt(i2);
        if (tabView != null) {
            tabView.setTab(null);
            tabView.setSelected(false);
            this.P.release(tabView);
        }
        requestLayout();
    }

    public boolean hasUnboundedRipple() {
        return this.D;
    }

    public void i(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.K;
        if (!(pagerAdapter2 == null || (dataSetObserver = this.L) == null)) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.K = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.L == null) {
                this.L = new c();
            }
            pagerAdapter.registerDataSetObserver(this.L);
        }
        g();
    }

    public boolean isInlineLabel() {
        return this.A;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.B;
    }

    public final void j(@Nullable ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.J;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.M;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            b bVar = this.N;
            if (bVar != null) {
                this.J.removeOnAdapterChangeListener(bVar);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.H;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.H = null;
        }
        if (viewPager != null) {
            this.J = viewPager;
            if (this.M == null) {
                this.M = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.M;
            tabLayoutOnPageChangeListener2.c = 0;
            tabLayoutOnPageChangeListener2.b = 0;
            viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.H = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                i(adapter, z2);
            }
            if (this.N == null) {
                this.N = new b();
            }
            b bVar2 = this.N;
            bVar2.a = z2;
            viewPager.addOnAdapterChangeListener(bVar2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.J = null;
            i(null, false);
        }
        this.O = z3;
    }

    public final void k() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).b();
        }
    }

    public final void l(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.z == 1 && this.w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void m(boolean z2) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            l((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        Pools.Pool<TabView> pool = this.P;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.setTab(createTabFromPool);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(createTabFromPool.d)) {
            acquire.setContentDescription(createTabFromPool.c);
        } else {
            acquire.setContentDescription(createTabFromPool.d);
        }
        createTabFromPool.view = acquire;
        int i2 = createTabFromPool.h;
        if (i2 != -1) {
            acquire.setId(i2);
        }
        return createTabFromPool;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.J == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                j((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager(null);
            this.O = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).i) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.i.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.t
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.r = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.z
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = 1
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public boolean releaseFromTabPool(Tab tab) {
        return R.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.c.getChildCount() - 1; childCount >= 0; childCount--) {
            h(childCount);
        }
        Iterator<Tab> it = this.a.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.a();
            releaseFromTabPool(next);
        }
        this.b = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i2) {
        Tab tab = this.b;
        int position = tab != null ? tab.getPosition() : 0;
        h(i2);
        Tab remove = this.a.remove(i2);
        if (remove != null) {
            remove.a();
            releaseFromTabPool(remove);
        }
        int size = this.a.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.a.get(i3).e = i3;
        }
        if (position == i2) {
            selectTab(this.a.isEmpty() ? null : this.a.get(Math.max(0, i2 - 1)));
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.setElevation(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    TabView tabView = (TabView) childAt;
                    tabView.setOrientation(!TabLayout.this.A ? 1 : 0);
                    TextView textView = tabView.g;
                    if (textView == null && tabView.h == null) {
                        tabView.k(tabView.b, tabView.c);
                    } else {
                        tabView.k(textView, tabView.h);
                    }
                }
            }
            c();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.I.addListener(animatorListener);
    }

    public void setScrollPosition(int i2, float f2, boolean z2) {
        setScrollPosition(i2, f2, z2, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.l = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.m = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.y != i2) {
            this.y = i2;
            ViewCompat.postInvalidateOnAnimation(this.c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.c.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.w != i2) {
            this.w = i2;
            c();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            k();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.C = i2;
        if (i2 == 0) {
            this.E = new a2.j.b.d.r.b();
        } else if (i2 == 1) {
            this.E = new a2.j.b.d.r.a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.B = z2;
        ViewCompat.postInvalidateOnAnimation(this.c);
    }

    public void setTabMode(int i2) {
        if (i2 != this.z) {
            this.z = i2;
            c();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    Context context = getContext();
                    int i3 = TabView.l;
                    ((TabView) childAt).j(context);
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            k();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        i(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    Context context = getContext();
                    int i3 = TabView.l;
                    ((TabView) childAt).j(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        @Nullable
        public Object a;
        @Nullable
        public Drawable b;
        @Nullable
        public CharSequence c;
        @Nullable
        public CharSequence d;
        public int e = -1;
        @Nullable
        public View f;
        @LabelVisibility
        public int g = 1;
        public int h = -1;
        @Nullable
        public TabLayout parent;
        @NonNull
        public TabView view;

        public void a() {
            this.parent = null;
            this.view = null;
            this.a = null;
            this.b = null;
            this.h = -1;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void b() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.i();
            }
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.f;
        }

        @Nullable
        public Drawable getIcon() {
            return this.b;
        }

        public int getId() {
            return this.h;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.e;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.g;
        }

        @Nullable
        public Object getTag() {
            return this.a;
        }

        @Nullable
        public CharSequence getText() {
            return this.c;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            TabView tabView = this.view;
            if (tabView.d != null) {
                tabView.f();
            }
            tabView.e = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view2) {
            this.f = view2;
            b();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.b = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.m(true);
            }
            b();
            if (BadgeUtils.USE_COMPAT_PARENT) {
                TabView tabView = this.view;
                int i = TabView.l;
                if (tabView.d() && this.view.e.isVisible()) {
                    this.view.invalidate();
                }
            }
            return this;
        }

        @NonNull
        public Tab setId(int i) {
            this.h = i;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i);
            }
            return this;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int i) {
            this.g = i;
            TabLayout tabLayout = this.parent;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.m(true);
            }
            b();
            if (BadgeUtils.USE_COMPAT_PARENT) {
                TabView tabView = this.view;
                int i2 = TabView.l;
                if (tabView.d() && this.view.e.isVisible()) {
                    this.view.invalidate();
                }
            }
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.a = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.c = charSequence;
            b();
            return this;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i, (ViewGroup) this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.d = charSequence;
            b();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.G.contains(baseOnTabSelectedListener)) {
            this.G.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab, int i2) {
        addTab(tab, i2, this.a.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.G.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z2) {
        Tab tab2 = this.b;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            if (z2) {
                if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                    setScrollPosition(position, 0.0f, true);
                } else {
                    b(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            this.b = tab;
            if (tab2 != null) {
                for (int size = this.G.size() - 1; size >= 0; size--) {
                    this.G.get(size).onTabUnselected(tab2);
                }
            }
            if (tab != null) {
                for (int size2 = this.G.size() - 1; size2 >= 0; size2--) {
                    this.G.get(size2).onTabSelected(tab);
                }
            }
        } else if (tab2 != null) {
            for (int size3 = this.G.size() - 1; size3 >= 0; size3--) {
                this.G.get(size3).onTabReselected(tab);
            }
            b(tab.getPosition());
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.F;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.F = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.c.getChildCount()) {
            if (z3) {
                d dVar = this.c;
                ValueAnimator valueAnimator = dVar.a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    dVar.a.cancel();
                }
                dVar.b = i2;
                dVar.c = f2;
                dVar.c(dVar.getChildAt(i2), dVar.getChildAt(dVar.b + 1), dVar.c);
            }
            ValueAnimator valueAnimator2 = this.I;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.I.cancel();
            }
            scrollTo(d(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z2) {
        j(viewPager, z2, false);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
        // Method dump skipped, instructions count: 444
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addTab(@NonNull Tab tab, boolean z2) {
        addTab(tab, this.a.size(), z2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void addTab(@NonNull Tab tab, int i2, boolean z2) {
        if (tab.parent == this) {
            tab.e = i2;
            this.a.add(i2, tab);
            int size = this.a.size();
            while (true) {
                i2++;
                if (i2 >= size) {
                    break;
                }
                this.a.get(i2).e = i2;
            }
            TabView tabView = tab.view;
            tabView.setSelected(false);
            tabView.setActivated(false);
            d dVar = this.c;
            int position = tab.getPosition();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            l(layoutParams);
            dVar.addView(tabView, position, layoutParams);
            if (z2) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(e(i2, i3));
    }
}
