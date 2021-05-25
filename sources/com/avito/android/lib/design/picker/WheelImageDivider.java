package com.avito.android.lib.design.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelImageDivider;", "Landroid/widget/FrameLayout;", "Landroid/graphics/drawable/Drawable;", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawable", "", AuthSource.BOOKING_ORDER, "I", "getResource", "()I", "resource", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class WheelImageDivider extends FrameLayout {
    @Nullable
    public final Drawable a;
    public final int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WheelImageDivider(@NotNull Context context, @Nullable Drawable drawable, @DrawableRes int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = drawable;
        this.b = i;
        LayoutInflater.from(context).inflate(R.layout.design_picker_wheel_image_divider, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wheelDividerImage);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.wheelDividerImage)");
        ImageView imageView = (ImageView) findViewById;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageResource(i);
        }
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.a;
    }

    public final int getResource() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WheelImageDivider(Context context, Drawable drawable, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : drawable, (i2 & 4) != 0 ? 0 : i);
    }
}
