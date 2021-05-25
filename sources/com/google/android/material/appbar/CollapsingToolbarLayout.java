package com.google.android.material.appbar;

import a2.j.b.d.a.e;
import a2.j.b.d.a.i;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.Objects;
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int x = R.style.Widget_Design_CollapsingToolbar;
    public boolean a;
    public int b;
    @Nullable
    public ViewGroup c;
    @Nullable
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Rect j;
    @NonNull
    public final CollapsingTextHelper k;
    public boolean l;
    public boolean m;
    @Nullable
    public Drawable n;
    @Nullable
    public Drawable o;
    public int p;
    public boolean q;
    public ValueAnimator r;
    public long s;
    public int t;
    public AppBarLayout.OnOffsetChangedListener u;
    public int v;
    @Nullable
    public WindowInsetsCompat w;

    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            Objects.requireNonNull(collapsingToolbarLayout);
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(collapsingToolbarLayout) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(collapsingToolbarLayout.w, windowInsetsCompat2)) {
                collapsingToolbarLayout.w = windowInsetsCompat2;
                collapsingToolbarLayout.requestLayout();
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.v = i;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.w;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i d = CollapsingToolbarLayout.d(childAt);
                int i3 = layoutParams.a;
                if (i3 == 1) {
                    d.b(MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.c(childAt)));
                } else if (i3 == 2) {
                    d.b(Math.round(((float) (-i)) * layoutParams.b));
                }
            }
            CollapsingToolbarLayout.this.f();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.o != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.k.setExpansionFraction(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop)));
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public static int b(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @NonNull
    public static i d(@NonNull View view) {
        int i2 = R.id.view_offset_helper;
        i iVar = (i) view.getTag(i2);
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(view);
        view.setTag(i2, iVar2);
        return iVar2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0028 */
    public final void a() {
        if (this.a) {
            ViewGroup viewGroup = null;
            this.c = null;
            this.d = null;
            int i2 = this.b;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.c = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.d = view;
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.c = viewGroup;
            }
            e();
            this.a = false;
        }
    }

    public final int c(@NonNull View view) {
        return ((getHeight() - d(view).b) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.c == null && (drawable = this.n) != null && this.p > 0) {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            this.k.draw(canvas);
        }
        if (this.o != null && this.p > 0) {
            WindowInsetsCompat windowInsetsCompat = this.w;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.o.setBounds(0, -this.v, getWidth(), systemWindowInsetTop - this.v);
                this.o.mutate().setAlpha(this.p);
                this.o.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r3 = true;
     */
    @Override // android.view.ViewGroup
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.n
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002d
            int r3 = r4.p
            if (r3 <= 0) goto L_0x002d
            android.view.View r3 = r4.d
            if (r3 == 0) goto L_0x0014
            if (r3 != r4) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r6 != r3) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            android.view.ViewGroup r3 = r4.c
            if (r6 != r3) goto L_0x001a
        L_0x0018:
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r4.p
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r4.n
            r0.draw(r5)
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            boolean r5 = super.drawChild(r5, r6, r7)
            if (r5 != 0) goto L_0x0038
            if (r0 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.k;
        if (collapsingTextHelper != null) {
            z |= collapsingTextHelper.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.l && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (this.l && this.c != null) {
            if (this.e == null) {
                this.e = new View(getContext());
            }
            if (this.e.getParent() == null) {
                this.c.addView(this.e, -1, -1);
            }
        }
    }

    public final void f() {
        if (this.n != null || this.o != null) {
            setScrimsShown(getHeight() + this.v < getScrimVisibleHeightTrigger());
        }
    }

    public int getCollapsedTitleGravity() {
        return this.k.getCollapsedTextGravity();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.k.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.k.getExpandedTypeface();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.k.getMaxLines();
    }

    public int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.t;
        if (i2 >= 0) {
            return i2;
        }
        WindowInsetsCompat windowInsetsCompat = this.w;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.o;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.l) {
            return this.k.getText();
        }
        return null;
    }

    public boolean isTitleEnabled() {
        return this.l;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.u == null) {
                this.u = new b();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.u);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.u;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        CharSequence charSequence;
        View view;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.w;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            i d2 = d(getChildAt(i11));
            d2.b = d2.a.getTop();
            d2.c = d2.a.getLeft();
        }
        if (this.l && (view = this.e) != null) {
            boolean z2 = true;
            boolean z3 = ViewCompat.isAttachedToWindow(view) && this.e.getVisibility() == 0;
            this.m = z3;
            if (z3) {
                if (ViewCompat.getLayoutDirection(this) != 1) {
                    z2 = false;
                }
                View view2 = this.d;
                if (view2 == null) {
                    view2 = this.c;
                }
                int c2 = c(view2);
                DescendantOffsetUtils.getDescendantRect(this, this.e, this.j);
                ViewGroup viewGroup = this.c;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    i8 = toolbar.getTitleMarginStart();
                    i7 = toolbar.getTitleMarginEnd();
                    i6 = toolbar.getTitleMarginTop();
                    i9 = toolbar.getTitleMarginBottom();
                } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                    i9 = 0;
                    i8 = 0;
                    i7 = 0;
                    i6 = 0;
                } else {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    i8 = toolbar2.getTitleMarginStart();
                    i7 = toolbar2.getTitleMarginEnd();
                    i6 = toolbar2.getTitleMarginTop();
                    i9 = toolbar2.getTitleMarginBottom();
                }
                CollapsingTextHelper collapsingTextHelper = this.k;
                Rect rect = this.j;
                int i12 = rect.left + (z2 ? i7 : i8);
                int i13 = rect.top + c2 + i6;
                int i14 = rect.right;
                if (!z2) {
                    i8 = i7;
                }
                collapsingTextHelper.setCollapsedBounds(i12, i13, i14 - i8, (rect.bottom + c2) - i9);
                this.k.setExpandedBounds(z2 ? this.h : this.f, this.j.top + this.g, (i4 - i2) - (z2 ? this.f : this.h), (i5 - i3) - this.i);
                this.k.recalculate();
            }
        }
        if (this.c != null && this.l && TextUtils.isEmpty(this.k.getText())) {
            ViewGroup viewGroup2 = this.c;
            if (viewGroup2 instanceof Toolbar) {
                charSequence = ((Toolbar) viewGroup2).getTitle();
            } else {
                charSequence = viewGroup2 instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup2).getTitle() : null;
            }
            setTitle(charSequence);
        }
        f();
        int childCount3 = getChildCount();
        for (int i15 = 0; i15 < childCount3; i15++) {
            d(getChildAt(i15)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.w;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            View view = this.d;
            if (view == null || view == this) {
                setMinimumHeight(b(viewGroup));
            } else {
                setMinimumHeight(b(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.k.setCollapsedTextGravity(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.k.setCollapsedTextAppearance(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.k.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.n = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.k.setExpandedTextGravity(i2);
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.k.setExpandedTextAppearance(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.k.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.k.setExpandedTypeface(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.k.setMaxLines(i2);
    }

    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.p) {
            if (!(this.n == null || (viewGroup = this.c) == null)) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.p = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.s = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.t != i2) {
            this.t = i2;
            f();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.o, ViewCompat.getLayoutDirection(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.k.setText(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            setContentDescription(getTitle());
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.o.setVisible(z, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.n.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.k.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.q != z) {
            int i2 = 255;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                a();
                ValueAnimator valueAnimator = this.r;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.r = valueAnimator2;
                    valueAnimator2.setDuration(this.s);
                    this.r.setInterpolator(i2 > this.p ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    this.r.addUpdateListener(new e(this));
                } else if (valueAnimator.isRunning()) {
                    this.r.cancel();
                }
                this.r.setIntValues(this.p, i2);
                this.r.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.q = z;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        public int a = 0;
        public float b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.a;
        }

        public float getParallaxMultiplier() {
            return this.b;
        }

        public void setCollapseMode(int i) {
            this.a = i;
        }

        public void setParallaxMultiplier(float f) {
            this.b = f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
