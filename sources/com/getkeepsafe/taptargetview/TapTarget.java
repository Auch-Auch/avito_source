package com.getkeepsafe.taptargetview;

import a2.h.a.c;
import a2.h.a.d;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
public class TapTarget {
    public boolean A;
    public float B;
    public final CharSequence a;
    @Nullable
    public final CharSequence b;
    public float c;
    public int d;
    public Rect e;
    public Drawable f;
    public Typeface g;
    public Typeface h;
    @ColorRes
    public int i;
    @ColorRes
    public int j;
    @ColorRes
    public int k;
    @ColorRes
    public int l;
    @ColorRes
    public int m;
    public Integer n;
    public Integer o;
    public Integer p;
    public Integer q;
    public Integer r;
    @DimenRes
    public int s;
    @DimenRes
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    public TapTarget(Rect rect, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this(charSequence, charSequence2);
        if (rect != null) {
            this.e = rect;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null bounds or title");
    }

    public static TapTarget forBounds(Rect rect, CharSequence charSequence) {
        return forBounds(rect, charSequence, null);
    }

    public static TapTarget forToolbarMenuItem(Toolbar toolbar, @IdRes int i2, CharSequence charSequence) {
        return forToolbarMenuItem(toolbar, i2, charSequence, (CharSequence) null);
    }

    public static TapTarget forToolbarNavigationIcon(Toolbar toolbar, CharSequence charSequence) {
        return forToolbarNavigationIcon(toolbar, charSequence, (CharSequence) null);
    }

    public static TapTarget forToolbarOverflow(Toolbar toolbar, CharSequence charSequence) {
        return forToolbarOverflow(toolbar, charSequence, (CharSequence) null);
    }

    public static TapTarget forView(View view, CharSequence charSequence) {
        return forView(view, charSequence, null);
    }

    @Nullable
    public final Integer a(Context context, @Nullable Integer num, @ColorRes int i2) {
        return i2 != -1 ? Integer.valueOf(ContextCompat.getColor(context, i2)) : num;
    }

    public final int b(Context context, int i2, @DimenRes int i3) {
        if (i3 != -1) {
            return context.getResources().getDimensionPixelSize(i3);
        }
        return (int) TypedValue.applyDimension(2, (float) i2, context.getResources().getDisplayMetrics());
    }

    public Rect bounds() {
        Rect rect = this.e;
        if (rect != null) {
            return rect;
        }
        throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
    }

    public TapTarget cancelable(boolean z2) {
        this.y = z2;
        return this;
    }

    public TapTarget descriptionTextAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Given an invalid alpha value: " + f2);
        }
        this.B = f2;
        return this;
    }

    public TapTarget descriptionTextColor(@ColorRes int i2) {
        this.m = i2;
        return this;
    }

    public TapTarget descriptionTextColorInt(@ColorInt int i2) {
        this.r = Integer.valueOf(i2);
        return this;
    }

    public TapTarget descriptionTextDimen(@DimenRes int i2) {
        this.t = i2;
        return this;
    }

    public TapTarget descriptionTextSize(int i2) {
        if (i2 >= 0) {
            this.v = i2;
            return this;
        }
        throw new IllegalArgumentException("Given negative text size");
    }

    public TapTarget descriptionTypeface(Typeface typeface) {
        if (typeface != null) {
            this.h = typeface;
            return this;
        }
        throw new IllegalArgumentException("Cannot use a null typeface");
    }

    public TapTarget dimColor(@ColorRes int i2) {
        this.k = i2;
        return this;
    }

    public TapTarget dimColorInt(@ColorInt int i2) {
        this.p = Integer.valueOf(i2);
        return this;
    }

    public TapTarget drawShadow(boolean z2) {
        this.x = z2;
        return this;
    }

    public TapTarget icon(Drawable drawable) {
        return icon(drawable, false);
    }

    public TapTarget id(int i2) {
        this.w = i2;
        return this;
    }

    public void onReady(Runnable runnable) {
        runnable.run();
    }

    public TapTarget outerCircleAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Given an invalid alpha value: " + f2);
        }
        this.c = f2;
        return this;
    }

    public TapTarget outerCircleColor(@ColorRes int i2) {
        this.i = i2;
        return this;
    }

    public TapTarget outerCircleColorInt(@ColorInt int i2) {
        this.n = Integer.valueOf(i2);
        return this;
    }

    public TapTarget targetCircleColor(@ColorRes int i2) {
        this.j = i2;
        return this;
    }

    public TapTarget targetCircleColorInt(@ColorInt int i2) {
        this.o = Integer.valueOf(i2);
        return this;
    }

    public TapTarget targetRadius(int i2) {
        this.d = i2;
        return this;
    }

    public TapTarget textColor(@ColorRes int i2) {
        this.l = i2;
        this.m = i2;
        return this;
    }

    public TapTarget textColorInt(@ColorInt int i2) {
        this.q = Integer.valueOf(i2);
        this.r = Integer.valueOf(i2);
        return this;
    }

    public TapTarget textTypeface(Typeface typeface) {
        if (typeface != null) {
            this.g = typeface;
            this.h = typeface;
            return this;
        }
        throw new IllegalArgumentException("Cannot use a null typeface");
    }

    public TapTarget tintTarget(boolean z2) {
        this.z = z2;
        return this;
    }

    public TapTarget titleTextColor(@ColorRes int i2) {
        this.l = i2;
        return this;
    }

    public TapTarget titleTextColorInt(@ColorInt int i2) {
        this.q = Integer.valueOf(i2);
        return this;
    }

    public TapTarget titleTextDimen(@DimenRes int i2) {
        this.s = i2;
        return this;
    }

    public TapTarget titleTextSize(int i2) {
        if (i2 >= 0) {
            this.u = i2;
            return this;
        }
        throw new IllegalArgumentException("Given negative text size");
    }

    public TapTarget titleTypeface(Typeface typeface) {
        if (typeface != null) {
            this.g = typeface;
            return this;
        }
        throw new IllegalArgumentException("Cannot use a null typeface");
    }

    public TapTarget transparentTarget(boolean z2) {
        this.A = z2;
        return this;
    }

    public static TapTarget forBounds(Rect rect, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new TapTarget(rect, charSequence, charSequence2);
    }

    public static TapTarget forToolbarMenuItem(Toolbar toolbar, @IdRes int i2, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, i2, charSequence, charSequence2);
    }

    public static TapTarget forToolbarNavigationIcon(Toolbar toolbar, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, true, charSequence, charSequence2);
    }

    public static TapTarget forToolbarOverflow(Toolbar toolbar, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, false, charSequence, charSequence2);
    }

    public static TapTarget forView(View view, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new d(view, charSequence, charSequence2);
    }

    public TapTarget icon(Drawable drawable, boolean z2) {
        if (drawable != null) {
            this.f = drawable;
            if (!z2) {
                drawable.setBounds(new Rect(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight()));
            }
            return this;
        }
        throw new IllegalArgumentException("Cannot use null drawable");
    }

    public int id() {
        return this.w;
    }

    public static TapTarget forToolbarMenuItem(android.widget.Toolbar toolbar, @IdRes int i2, CharSequence charSequence) {
        return forToolbarMenuItem(toolbar, i2, charSequence, (CharSequence) null);
    }

    public static TapTarget forToolbarNavigationIcon(android.widget.Toolbar toolbar, CharSequence charSequence) {
        return forToolbarNavigationIcon(toolbar, charSequence, (CharSequence) null);
    }

    public static TapTarget forToolbarOverflow(android.widget.Toolbar toolbar, CharSequence charSequence) {
        return forToolbarOverflow(toolbar, charSequence, (CharSequence) null);
    }

    public TapTarget(CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.c = 0.96f;
        this.d = 44;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = -1;
        this.t = -1;
        this.u = 20;
        this.v = 18;
        this.w = -1;
        this.x = false;
        this.y = true;
        this.z = true;
        this.A = false;
        this.B = 0.54f;
        if (charSequence != null) {
            this.a = charSequence;
            this.b = charSequence2;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null title");
    }

    public static TapTarget forToolbarMenuItem(android.widget.Toolbar toolbar, @IdRes int i2, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, i2, charSequence, charSequence2);
    }

    public static TapTarget forToolbarNavigationIcon(android.widget.Toolbar toolbar, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, true, charSequence, charSequence2);
    }

    public static TapTarget forToolbarOverflow(android.widget.Toolbar toolbar, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new c(toolbar, false, charSequence, charSequence2);
    }
}
