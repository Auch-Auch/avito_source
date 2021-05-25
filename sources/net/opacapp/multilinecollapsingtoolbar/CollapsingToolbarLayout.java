package net.opacapp.multilinecollapsingtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Objects;
import v6.b.a.c;
import v6.b.a.d;
import v6.b.a.e;
import v6.b.a.f;
import v6.b.a.g;
import v6.b.a.h;
import v6.b.a.i;
import v6.b.a.j;
public class CollapsingToolbarLayout extends FrameLayout {
    public boolean a;
    public int b;
    public Toolbar c;
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Rect k;
    public final v6.b.a.b l;
    public boolean m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public int q;
    public boolean r;
    public f s;
    public long t;
    public int u;
    public AppBarLayout.OnOffsetChangedListener v;
    public int w;
    public WindowInsetsCompat x;

    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            Objects.requireNonNull(collapsingToolbarLayout);
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(collapsingToolbarLayout) ? windowInsetsCompat : null;
            WindowInsetsCompat windowInsetsCompat3 = collapsingToolbarLayout.x;
            if (!(windowInsetsCompat3 == windowInsetsCompat2 || (windowInsetsCompat3 != null && windowInsetsCompat3.equals(windowInsetsCompat2)))) {
                collapsingToolbarLayout.x = windowInsetsCompat2;
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
            int round;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.x;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                j d = CollapsingToolbarLayout.d(childAt);
                int i3 = layoutParams.a;
                if (i3 == 1) {
                    int i4 = -i;
                    int c = CollapsingToolbarLayout.this.c(childAt);
                    if (i4 < 0) {
                        i4 = 0;
                    } else if (i4 > c) {
                        i4 = c;
                    }
                    if (d.d != i4) {
                        d.d = i4;
                        d.a();
                    }
                } else if (i3 == 2 && d.d != (round = Math.round(((float) (-i)) * layoutParams.b))) {
                    d.d = round;
                    d.a();
                }
            }
            CollapsingToolbarLayout.this.f();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            v6.b.a.b bVar = CollapsingToolbarLayout.this.l;
            float abs = ((float) Math.abs(i)) / ((float) height);
            if (abs < 0.0f) {
                abs = 0.0f;
            } else if (abs > 1.0f) {
                abs = 1.0f;
            }
            if (abs != bVar.c) {
                bVar.c = abs;
                bVar.b(abs);
            }
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public static int b(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static j d(View view) {
        int i2 = R.id.view_offset_helper;
        j jVar = (j) view.getTag(i2);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(view);
        view.setTag(i2, jVar2);
        return jVar2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0028 */
    public final void a() {
        if (this.a) {
            Toolbar toolbar = null;
            this.c = null;
            this.d = null;
            int i2 = this.b;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.c = toolbar2;
                if (toolbar2 != null) {
                    ViewParent parent = toolbar2.getParent();
                    View view = toolbar2;
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
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.c = toolbar;
            }
            e();
            this.a = false;
        }
    }

    public final int c(View view) {
        return ((getHeight() - d(view).b) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            v6.b.a.b bVar = this.l;
            Objects.requireNonNull(bVar);
            int save = canvas.save();
            if (bVar.w != null && bVar.b) {
                float f2 = bVar.q;
                float f3 = bVar.r;
                bVar.D.setTextSize(bVar.A);
                float ascent = bVar.D.ascent();
                float f4 = bVar.z;
                float f5 = ascent * f4;
                if (f4 != 1.0f) {
                    canvas.scale(f4, f4, f2, f3);
                }
                float lineLeft = (bVar.Q.getLineLeft(0) + bVar.q) - (bVar.T * 2.0f);
                canvas.translate(lineLeft, f3);
                bVar.D.setAlpha((int) (bVar.S * 255.0f));
                bVar.Q.draw(canvas);
                canvas.translate(f2 - lineLeft, 0.0f);
                bVar.D.setAlpha((int) (bVar.R * 255.0f));
                CharSequence charSequence = bVar.N;
                float f6 = -f5;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6 / bVar.z, bVar.D);
                bVar.D.setAlpha(255);
                canvas.drawText(bVar.w, bVar.Q.getLineStart(0), bVar.Q.getLineEnd(0), 0.0f, f6 / bVar.z, bVar.D);
            }
            canvas.restoreToCount(save);
        }
        if (this.p != null && this.q > 0) {
            WindowInsetsCompat windowInsetsCompat = this.x;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.p.setBounds(0, -this.w, getWidth(), systemWindowInsetTop - this.w);
                this.p.mutate().setAlpha(this.q);
                this.p.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.o == null || this.q <= 0) {
            return drawChild;
        }
        int i2 = this.f;
        if (!(i2 >= 0 && i2 == indexOfChild(view) + 1)) {
            return drawChild;
        }
        this.o.mutate().setAlpha(this.q);
        this.o.draw(canvas);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState) | false;
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        v6.b.a.b bVar = this.l;
        if (bVar != null) {
            bVar.B = drawableState;
            ColorStateList colorStateList2 = bVar.l;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = bVar.k) != null && colorStateList.isStateful())) {
                bVar.i();
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.m && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (this.m && this.c != null) {
            if (this.e == null) {
                this.e = new View(getContext());
            }
            if (this.e.getParent() == null) {
                this.c.addView(this.e, -1, -1);
            }
        }
    }

    public final void f() {
        if (this.o != null || this.p != null) {
            setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
        }
    }

    public int getCollapsedTitleGravity() {
        return this.l.h;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.l.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.l.g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.i;
    }

    public int getExpandedTitleMarginStart() {
        return this.g;
    }

    public int getExpandedTitleMarginTop() {
        return this.h;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.l.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getMaxLines() {
        return this.l.U;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2;
        }
        WindowInsetsCompat windowInsetsCompat = this.x;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.m) {
            return this.l.v;
        }
        return null;
    }

    public boolean isTitleEnabled() {
        return this.m;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.v == null) {
                this.v = new b();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.v);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.v;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        int i6;
        int i7;
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.x;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.m && (view = this.e) != null) {
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.e.getVisibility() == 0;
            this.n = z2;
            if (z2) {
                boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                View view2 = this.d;
                if (view2 == null) {
                    view2 = this.c;
                }
                int c2 = c(view2);
                View view3 = this.e;
                Rect rect = this.k;
                rect.set(0, 0, view3.getWidth(), view3.getHeight());
                ThreadLocal<Matrix> threadLocal = i.a;
                Matrix matrix = threadLocal.get();
                if (matrix == null) {
                    matrix = new Matrix();
                    threadLocal.set(matrix);
                } else {
                    matrix.reset();
                }
                i.a(this, view3, matrix);
                ThreadLocal<RectF> threadLocal2 = i.b;
                RectF rectF = threadLocal2.get();
                if (rectF == null) {
                    rectF = new RectF();
                    threadLocal2.set(rectF);
                }
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
                v6.b.a.b bVar = this.l;
                int i9 = this.k.left;
                if (z3) {
                    i6 = this.c.getTitleMarginEnd();
                } else {
                    i6 = this.c.getTitleMarginStart();
                }
                int i10 = i9 + i6;
                int titleMarginTop = this.c.getTitleMarginTop() + this.k.top + c2;
                int i11 = this.k.right;
                if (z3) {
                    i7 = this.c.getTitleMarginStart();
                } else {
                    i7 = this.c.getTitleMarginEnd();
                }
                int i12 = i11 + i7;
                int titleMarginBottom = (this.k.bottom + c2) - this.c.getTitleMarginBottom();
                if (!v6.b.a.b.j(bVar.e, i10, titleMarginTop, i12, titleMarginBottom)) {
                    bVar.e.set(i10, titleMarginTop, i12, titleMarginBottom);
                    bVar.C = true;
                    bVar.g();
                }
                v6.b.a.b bVar2 = this.l;
                int i13 = z3 ? this.i : this.g;
                int i14 = this.k.top + this.h;
                int i15 = (i4 - i2) - (z3 ? this.g : this.i);
                int i16 = (i5 - i3) - this.j;
                if (!v6.b.a.b.j(bVar2.d, i13, i14, i15, i16)) {
                    bVar2.d.set(i13, i14, i15, i16);
                    bVar2.C = true;
                    bVar2.g();
                }
                this.l.i();
            }
        }
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            j d2 = d(getChildAt(i17));
            d2.b = d2.a.getTop();
            d2.c = d2.a.getLeft();
            d2.a();
        }
        if (this.c != null) {
            if (this.m && TextUtils.isEmpty(this.l.v)) {
                this.l.n(this.c.getTitle());
            }
            View view4 = this.d;
            if (view4 == null || view4 == this) {
                setMinimumHeight(b(this.c));
                this.f = indexOfChild(this.c);
            } else {
                setMinimumHeight(b(view4));
                this.f = indexOfChild(this.d);
            }
        } else {
            this.f = -1;
        }
        f();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        v6.b.a.b bVar = this.l;
        if (bVar.h != i2) {
            bVar.h = i2;
            bVar.i();
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.l.k(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        v6.b.a.b bVar = this.l;
        if (bVar.s != typeface) {
            bVar.s = typeface;
            bVar.i();
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
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
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
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
        v6.b.a.b bVar = this.l;
        if (bVar.g != i2) {
            bVar.g = i2;
            bVar.i();
        }
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.j = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.g = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.l.l(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        v6.b.a.b bVar = this.l;
        if (bVar.k != colorStateList) {
            bVar.k = colorStateList;
            bVar.i();
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        v6.b.a.b bVar = this.l;
        if (bVar.t != typeface) {
            bVar.t = typeface;
            bVar.i();
        }
    }

    public void setMaxLines(int i2) {
        v6.b.a.b bVar = this.l;
        if (i2 != bVar.U) {
            bVar.U = i2;
            bVar.d();
            bVar.i();
        }
    }

    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.q) {
            if (!(this.o == null || (toolbar = this.c) == null)) {
                ViewCompat.postInvalidateOnAnimation(toolbar);
            }
            this.q = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.u != i2) {
            this.u = i2;
            f();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.p, ViewCompat.getLayoutDirection(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
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
        this.l.n(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.o.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        v6.b.a.b bVar = this.l;
        if (bVar.l != colorStateList) {
            bVar.l = colorStateList;
            bVar.i();
        }
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.r != z) {
            int i2 = 255;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                a();
                f fVar = this.s;
                if (fVar == null) {
                    h hVar = new h();
                    this.s = new f(hVar);
                    hVar.a.setDuration(this.t);
                    ((h) this.s.a).a.setInterpolator(i2 > this.q ? v6.b.a.a.b : v6.b.a.a.c);
                    f fVar2 = this.s;
                    c cVar = new c(this);
                    h hVar2 = (h) fVar2.a;
                    hVar2.a.addUpdateListener(new g(hVar2, new e(fVar2, cVar)));
                } else if (((h) fVar.a).a.isRunning()) {
                    ((h) this.s.a).a.cancel();
                }
                ((h) this.s.a).a.setIntValues(this.q, i2);
                ((h) this.s.a).a.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.r = z;
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.k = new Rect();
        this.u = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(d.a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (!z) {
            v6.b.a.b bVar = new v6.b.a.b(this);
            this.l = bVar;
            bVar.E = v6.b.a.a.d;
            bVar.i();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i2, R.style.Widget_Design_MultilineCollapsingToolbar);
            int i3 = obtainStyledAttributes2.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START);
            if (bVar.g != i3) {
                bVar.g = i3;
                bVar.i();
            }
            int i4 = obtainStyledAttributes2.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627);
            if (bVar.h != i4) {
                bVar.h = i4;
                bVar.i();
            }
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
            this.j = dimensionPixelSize;
            this.i = dimensionPixelSize;
            this.h = dimensionPixelSize;
            this.g = dimensionPixelSize;
            int i5 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
            if (obtainStyledAttributes2.hasValue(i5)) {
                this.g = obtainStyledAttributes2.getDimensionPixelSize(i5, 0);
            }
            int i6 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
            if (obtainStyledAttributes2.hasValue(i6)) {
                this.i = obtainStyledAttributes2.getDimensionPixelSize(i6, 0);
            }
            int i7 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
            if (obtainStyledAttributes2.hasValue(i7)) {
                this.h = obtainStyledAttributes2.getDimensionPixelSize(i7, 0);
            }
            int i8 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
            if (obtainStyledAttributes2.hasValue(i8)) {
                this.j = obtainStyledAttributes2.getDimensionPixelSize(i8, 0);
            }
            this.m = obtainStyledAttributes2.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
            setTitle(obtainStyledAttributes2.getText(R.styleable.CollapsingToolbarLayout_title));
            bVar.l(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
            bVar.k(R.style.ActionBar_Title);
            int i9 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
            if (obtainStyledAttributes2.hasValue(i9)) {
                bVar.l(obtainStyledAttributes2.getResourceId(i9, 0));
            }
            int i10 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
            if (obtainStyledAttributes2.hasValue(i10)) {
                bVar.k(obtainStyledAttributes2.getResourceId(i10, 0));
            }
            this.u = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
            this.t = (long) obtainStyledAttributes2.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
            setContentScrim(obtainStyledAttributes2.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
            setStatusBarScrim(obtainStyledAttributes2.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
            this.b = obtainStyledAttributes2.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
            obtainStyledAttributes2.recycle();
            setWillNotDraw(false);
            ViewCompat.setOnApplyWindowInsetsListener(this, new a());
            int integer = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayoutExtension, i2, 0).getInteger(R.styleable.CollapsingToolbarLayoutExtension_maxLines, 3);
            if (integer != bVar.U) {
                bVar.U = integer;
                bVar.d();
                bVar.i();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
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

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
