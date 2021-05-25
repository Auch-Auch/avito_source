package com.avito.android.lib.design.deprecated.select;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/ClearDrawableHolder;", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/lib/design/deprecated/select/SelectState;", "state", "Landroid/content/Context;", "context", "", "setState", "(Lcom/avito/android/lib/design/deprecated/select/SelectState;Landroid/content/Context;)V", "Landroid/graphics/drawable/RippleDrawable;", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/RippleDrawable;", "drawable", "<init>", "(Landroid/content/Context;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ClearDrawableHolder implements DrawableHolder {
    public final RippleDrawable a;

    public ClearDrawableHolder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getDrawable(R.drawable.design_background_clear);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        this.a = (RippleDrawable) drawable;
    }

    @Override // com.avito.android.lib.design.deprecated.select.DrawableHolder
    @NotNull
    public Drawable getDrawable() {
        return this.a;
    }

    @Override // com.avito.android.lib.design.deprecated.select.DrawableHolder
    public void setState(@NotNull SelectState selectState, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(selectState, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a.setColor(ColorStateList.valueOf(Contexts.getColorByAttr(context, selectState.getRippleBackgroundAttr())));
    }
}
