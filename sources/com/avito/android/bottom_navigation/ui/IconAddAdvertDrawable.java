package com.avito.android.bottom_navigation.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u00100\u001a\u00020/\u0012\b\b\u0001\u00101\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0001\u00102\u001a\u00020\u0007\u0012\u0006\u0010'\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020 ¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\nR\"\u0010'\u001a\u00020 8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R$\u0010.\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\n¨\u00065"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/IconAddAdvertDrawable;", "Lcom/avito/android/bottom_navigation/ui/AddAdvertDrawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "Landroid/graphics/drawable/Drawable;", AuthSource.BOOKING_ORDER, "Landroid/graphics/drawable/Drawable;", "iconDrawable", "c", "I", "iconColor", "Landroid/graphics/Paint;", AuthSource.SEND_ABUSE, "Landroid/graphics/Paint;", "backgroundPaint", "value", "getBackgroundColor", "setBackgroundColor", "backgroundColor", "", "d", "F", "getContentSize", "()F", "setContentSize", "(F)V", "contentSize", "e", "getRadiusSize", "setRadiusSize", "radiusSize", "getContentColor", "setContentColor", "contentColor", "Landroid/content/Context;", "context", "circleColor", "iconResId", "<init>", "(Landroid/content/Context;IIIFF)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class IconAddAdvertDrawable extends AddAdvertDrawable {
    public final Paint a;
    public final Drawable b;
    public int c;
    public float d;
    public float e;

    public IconAddAdvertDrawable(@NotNull Context context, @ColorInt int i, @ColorInt int i2, @DrawableRes int i3, float f, float f2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = i2;
        this.d = f;
        this.e = f2;
        Paint paint = new Paint();
        this.a = paint;
        this.b = ContextCompat.getDrawable(context, i3);
        paint.setColor(getBackgroundColor());
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = (float) 2;
        float width = ((float) getBounds().width()) / f;
        canvas.drawCircle(width, width, getRadiusSize(), this.a);
        int contentSize = (int) (width - (getContentSize() / f));
        int contentSize2 = (int) ((getContentSize() / f) + width);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(new Rect(contentSize, contentSize, contentSize2, contentSize2));
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public int getBackgroundColor() {
        return this.a.getColor();
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public int getContentColor() {
        return this.c;
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public float getContentSize() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public float getRadiusSize() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public void setBackgroundColor(int i) {
        this.a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public void setContentColor(int i) {
        this.c = i;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public void setContentSize(float f) {
        this.d = f;
    }

    @Override // com.avito.android.bottom_navigation.ui.AddAdvertDrawable
    public void setRadiusSize(float f) {
        this.e = f;
    }
}
