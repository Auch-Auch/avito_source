package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import y6.a.a.c;
import y6.a.a.d;
public class GifTextView extends TextView {
    public d.b a;

    public GifTextView(Context context) {
        super(context);
    }

    private void setCompoundDrawablesVisible(boolean z) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        for (Drawable drawable : compoundDrawables) {
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        for (Drawable drawable2 : compoundDrawablesRelative) {
            if (drawable2 != null) {
                drawable2.setVisible(z, false);
            }
        }
    }

    public final Drawable a(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i);
        if (!isInEditMode() && d.a.contains(resourceTypeName)) {
            try {
                return new GifDrawable(resources, i);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i, getContext().getTheme());
    }

    public final void b(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            Drawable a3 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable a4 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable a5 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable a6 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable a8 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable a9 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (a8 != null) {
                    a3 = a8;
                }
                if (a9 == null) {
                    a9 = a5;
                }
            } else {
                if (a8 != null) {
                    a5 = a8;
                }
                if (a9 == null) {
                    a9 = a3;
                }
                a3 = a5;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(a3, a4, a9, a6);
            setBackground(a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            d.b bVar = new d.b(this, attributeSet, i, i2);
            this.a = bVar;
            if (bVar.b >= 0) {
                for (Drawable drawable : getCompoundDrawables()) {
                    d.a(this.a.b, drawable);
                }
                for (Drawable drawable2 : getCompoundDrawablesRelative()) {
                    d.a(this.a.b, drawable2);
                }
                d.a(this.a.b, getBackground());
            }
        }
        this.a = new d.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        cVar.a(compoundDrawables[0], 0);
        cVar.a(compoundDrawables[1], 1);
        cVar.a(compoundDrawables[2], 2);
        cVar.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        cVar.a(compoundDrawablesRelative[0], 4);
        cVar.a(compoundDrawablesRelative[2], 5);
        cVar.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.a.a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new c(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setBackground(a(i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(i), a(i2), a(i3), a(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(a(i), a(i2), a(i3), a(i4));
    }

    public void setFreezesAnimation(boolean z) {
        this.a.a = z;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet, i, 0);
    }

    @RequiresApi(21)
    public GifTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(attributeSet, i, i2);
    }
}
