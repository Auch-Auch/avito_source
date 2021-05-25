package l6.b.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
public class c {
    @NonNull
    public final View a;
    public final AppCompatDrawableManager b;
    public int c = -1;
    public TintInfo d;
    public TintInfo e;
    public TintInfo f;

    public c(@NonNull View view) {
        this.a = view;
        this.b = AppCompatDrawableManager.get();
    }

    public void a() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 ? i == 21 : this.d != null) {
                if (this.f == null) {
                    this.f = new TintInfo();
                }
                TintInfo tintInfo = this.f;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.a);
                if (backgroundTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.a);
                if (backgroundTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = backgroundTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.b(background, tintInfo, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            TintInfo tintInfo2 = this.e;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.b(background, tintInfo2, this.a.getDrawableState());
                return;
            }
            TintInfo tintInfo3 = this.d;
            if (tintInfo3 != null) {
                AppCompatDrawableManager.b(background, tintInfo3, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        TintInfo tintInfo = this.e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        TintInfo tintInfo = this.e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public void d(@Nullable AttributeSet attributeSet, int i) {
        Context context = this.a.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        View view = this.a;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i2 = R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.c = obtainStyledAttributes.getResourceId(i2, -1);
                ColorStateList a3 = this.b.a(this.a.getContext(), this.c);
                if (a3 != null) {
                    g(a3);
                }
            }
            int i3 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i3)) {
                ViewCompat.setBackgroundTintList(this.a, obtainStyledAttributes.getColorStateList(i3));
            }
            int i4 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i4)) {
                ViewCompat.setBackgroundTintMode(this.a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i4, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void e() {
        this.c = -1;
        g(null);
        a();
    }

    public void f(int i) {
        this.c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.b;
        g(appCompatDrawableManager != null ? appCompatDrawableManager.a(this.a.getContext(), i) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new TintInfo();
            }
            TintInfo tintInfo = this.d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new TintInfo();
        }
        TintInfo tintInfo = this.e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new TintInfo();
        }
        TintInfo tintInfo = this.e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        a();
    }
}
