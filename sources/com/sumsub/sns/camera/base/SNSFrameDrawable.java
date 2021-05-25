package com.sumsub.sns.camera.base;

import a2.g.r.g;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import com.sumsub.sns.core.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010*\u001a\u00020\u001a¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001cR\u0016\u0010,\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001cR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001c¨\u00065"}, d2 = {"Lcom/sumsub/sns/camera/base/SNSFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "setBounds", "(IIII)V", "c", "Landroid/graphics/drawable/Drawable;", "mask", "", "i", "F", "paddingTop", "e", TextureMediaEncoder.FRAME_EVENT, "Landroid/graphics/Bitmap;", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap;", "buffer", "f", "I", "fillColor", AuthSource.BOOKING_ORDER, "border", "j", "paddingBottom", "h", "paddingRight", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", g.a, "paddingLeft", "<init>", "(Landroid/graphics/drawable/Drawable;IFFFF)V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
public final class SNSFrameDrawable extends Drawable {
    public Bitmap a;
    public final Drawable b;
    public final Drawable c;
    public final Paint d;
    public final Drawable e;
    public final int f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFrameDrawable(Drawable drawable, int i2, float f2, float f3, float f4, float f5, int i3, j jVar) {
        this(drawable, i2, (i3 & 4) != 0 ? 0.0f : f2, (i3 & 8) != 0 ? 0.0f : f3, (i3 & 16) != 0 ? 0.0f : f4, (i3 & 32) != 0 ? 0.0f : f5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) getBounds().left, (float) getBounds().top, (Paint) null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.d.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        int i6;
        Pair pair;
        super.setBounds(i2, i3, i4, i5);
        Drawable drawable = this.c;
        if (drawable != null) {
            float coerceAtLeast = e.coerceAtLeast((((float) (i4 - i2)) - this.g) - this.h, 0.0f);
            float coerceAtLeast2 = e.coerceAtLeast((((float) (i5 - i3)) - this.i) - this.j, 0.0f);
            if (coerceAtLeast2 / ((float) e.coerceAtLeast(drawable.getIntrinsicHeight(), 1)) > coerceAtLeast / ((float) e.coerceAtLeast(drawable.getIntrinsicWidth(), 1))) {
                pair = TuplesKt.to(Float.valueOf(coerceAtLeast), Float.valueOf((((float) drawable.getIntrinsicHeight()) * coerceAtLeast) / ((float) e.coerceAtLeast(drawable.getIntrinsicWidth(), 1))));
            } else {
                pair = TuplesKt.to(Float.valueOf((((float) drawable.getIntrinsicWidth()) * coerceAtLeast2) / ((float) e.coerceAtLeast(drawable.getIntrinsicHeight(), 1))), Float.valueOf(coerceAtLeast2));
            }
            float floatValue = ((Number) pair.component1()).floatValue();
            float floatValue2 = ((Number) pair.component2()).floatValue();
            float f2 = (float) 2;
            float f3 = ((coerceAtLeast - floatValue) / f2) + ((float) i2) + this.g;
            float f4 = ((coerceAtLeast2 - floatValue2) / f2) + ((float) i3) + this.i;
            drawable.setBounds((int) f3, (int) f4, (int) (f3 + floatValue), (int) (f4 + floatValue2));
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                drawable2.setBounds(drawable.getBounds());
            }
        }
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            bitmap.recycle();
        }
        int i7 = i4 - i2;
        if (i7 > 0 && (i6 = i5 - i3) > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i7, i6, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Drawable drawable3 = this.c;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.drawColor(this.f, PorterDuff.Mode.SRC_OUT);
            Drawable drawable4 = this.b;
            if (drawable4 != null) {
                drawable4.draw(canvas);
            }
            Unit unit = Unit.INSTANCE;
            this.a = createBitmap;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public SNSFrameDrawable(@Nullable Drawable drawable, int i2, float f2, float f3, float f4, float f5) {
        Drawable findDrawableByLayerId;
        this.e = drawable;
        this.f = i2;
        this.g = f2;
        this.h = f3;
        this.i = f4;
        this.j = f5;
        LayerDrawable layerDrawable = null;
        LayerDrawable layerDrawable2 = (LayerDrawable) (!(drawable instanceof LayerDrawable) ? null : drawable);
        this.b = layerDrawable2 != null ? layerDrawable2.findDrawableByLayerId(R.id.sns_frame_border) : null;
        LayerDrawable layerDrawable3 = drawable instanceof LayerDrawable ? drawable : layerDrawable;
        if (!(layerDrawable3 == null || (findDrawableByLayerId = layerDrawable3.findDrawableByLayerId(R.id.sns_frame_mask)) == null)) {
            drawable = findDrawableByLayerId;
        }
        this.c = drawable;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        Unit unit = Unit.INSTANCE;
        this.d = paint;
    }
}
