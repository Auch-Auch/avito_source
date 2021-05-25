package com.avito.android.bottom_navigation.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010,\u001a\u00020\u0007\u0012\b\b\u0001\u0010)\u001a\u00020\u0007\u0012\u0006\u0010-\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\nR\"\u0010$\u001a\u00020\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010)\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\nR\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0013¨\u00060"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/PlusAddAdvertDrawable;", "Lcom/avito/android/bottom_navigation/ui/AddAdvertDrawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "plusPaint", "", "e", "F", "getRadiusSize", "()F", "setRadiusSize", "(F)V", "radiusSize", "value", "getBackgroundColor", "setBackgroundColor", "backgroundColor", "d", "getContentSize", "setContentSize", "contentSize", "c", "I", "getContentColor", "setContentColor", "contentColor", AuthSource.SEND_ABUSE, "backgroundPaint", "circleColor", "plusWidth", "<init>", "(IIFFF)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class PlusAddAdvertDrawable extends AddAdvertDrawable {
    public final Paint a;
    public final Paint b;
    public int c;
    public float d;
    public float e;

    public PlusAddAdvertDrawable(@ColorInt int i, @ColorInt int i2, float f, float f2, float f3) {
        this.c = i2;
        this.d = f2;
        this.e = f3;
        Paint paint = new Paint();
        this.a = paint;
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(getContentColor());
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeWidth(f);
        paint2.setStrokeCap(Paint.Cap.ROUND);
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
        canvas.drawLine(width - (getContentSize() / f), width, (getContentSize() / f) + width, width, this.b);
        canvas.drawLine(width, width - (getContentSize() / f), width, (getContentSize() / f) + width, this.b);
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
