package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    @NonNull
    public final ImageView a;
    public TintInfo b;
    public TintInfo c;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.a = imageView;
    }

    public void a() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 && i == 21) {
                if (this.c == null) {
                    this.c = new TintInfo();
                }
                TintInfo tintInfo = this.c;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.a);
                if (imageTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = imageTintList;
                }
                PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.a);
                if (imageTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = imageTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.b(drawable, tintInfo, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            TintInfo tintInfo2 = this.b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.b(drawable, tintInfo2, this.a.getDrawableState());
            }
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new TintInfo();
        }
        TintInfo tintInfo = this.b;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        a();
    }

    public void c(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new TintInfo();
        }
        TintInfo tintInfo = this.b;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        a();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        Context context = this.a.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.a;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (!(drawable != null || (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = AppCompatResources.getDrawable(this.a.getContext(), resourceId)) == null)) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            int i2 = R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i2)) {
                ImageViewCompat.setImageTintList(this.a, obtainStyledAttributes.getColorStateList(i2));
            }
            int i3 = R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                ImageViewCompat.setImageTintMode(this.a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.a.getContext(), i);
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            this.a.setImageDrawable(drawable);
        } else {
            this.a.setImageDrawable(null);
        }
        a();
    }
}
