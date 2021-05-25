package com.avito.android.util;

import a2.b.a.a.a;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import androidx.annotation.ColorInt;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "color", "wrapForTinting", "(Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/ColorStateList;", "colorStateList", "(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)Landroid/graphics/drawable/Drawable;", "", "applyColor", "(Landroid/graphics/drawable/Drawable;I)V", "ripple", "(Landroid/content/res/ColorStateList;)Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Bitmap;", "getBitmap", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class DrawablesKt {
    public static final void applyColor(@NotNull Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(drawable, "$this$applyColor");
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i);
        } else if (drawable instanceof ShapeDrawable) {
            Paint paint = ((ShapeDrawable) drawable).getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setColor(i);
            drawable.invalidateSelf();
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i);
        } else {
            StringBuilder L = a.L("Can't apply color to ");
            L.append(drawable.getClass().getSimpleName());
            L.append(" => using color filter instead");
            Logs.verbose$default("Drawables.kt", L.toString(), null, 4, null);
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
    }

    @Nullable
    public static final Bitmap getBitmap(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$this$getBitmap");
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(intr… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @Nullable
    public static final Drawable ripple(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            return new RippleDrawable(colorStateList, null, null);
        }
        return null;
    }

    @Deprecated(message = "Set tint and tintMode to View directly")
    @NotNull
    public static final Drawable wrapForTinting(@NotNull Drawable drawable, @ColorInt int i) {
        Intrinsics.checkNotNullParameter(drawable, "$this$wrapForTinting");
        Drawable wrap = DrawableCompat.wrap(drawable);
        wrap.setTintMode(PorterDuff.Mode.SRC_ATOP);
        wrap.mutate().setTint(i);
        Intrinsics.checkNotNullExpressionValue(wrap, "drawable");
        return wrap;
    }

    @Deprecated(message = "Set tint to View directly")
    @NotNull
    public static final Drawable wrapForTinting(@NotNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(drawable, "$this$wrapForTinting");
        Drawable wrap = DrawableCompat.wrap(drawable);
        wrap.mutate().setTintList(colorStateList);
        Intrinsics.checkNotNullExpressionValue(wrap, "drawable");
        return wrap;
    }
}
