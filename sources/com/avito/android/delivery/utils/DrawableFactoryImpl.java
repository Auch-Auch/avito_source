package com.avito.android.delivery.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/delivery/utils/DrawableFactoryImpl;", "Lcom/avito/android/delivery/utils/DrawableFactory;", "", "layoutId", "textViewId", "", "text", "Landroid/graphics/drawable/Drawable;", "getTextDrawable", "(IILjava/lang/CharSequence;)Landroid/graphics/drawable/Drawable;", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DrawableFactoryImpl implements DrawableFactory {
    public final LayoutInflater a;

    @Inject
    public DrawableFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LayoutInflater.from(context);
    }

    @Override // com.avito.android.delivery.utils.DrawableFactory
    @NotNull
    public Drawable getTextDrawable(@LayoutRes int i, @IdRes int i2, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        LayoutInflater layoutInflater = this.a;
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (i2 != 0) {
            View findViewById = inflate.findViewById(i2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<TextView>(textViewId)");
            TextViews.bindText$default((TextView) findViewById, charSequence, false, 2, null);
        }
        Resources resources = inflate.getResources();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        inflate.measure(makeMeasureSpec, makeMeasureSpec);
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        inflate.draw(new Canvas(createBitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(meas…raw(Canvas(it))\n        }");
        return new BitmapDrawable(resources, createBitmap);
    }
}
