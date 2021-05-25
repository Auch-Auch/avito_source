package com.avito.android.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000e\u001a#\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroid/view/MenuItem;", "", "hide", "(Landroid/view/MenuItem;)V", "show", "", "title", "bindTitle", "(Landroid/view/MenuItem;Ljava/lang/CharSequence;)V", "Landroid/content/Context;", "context", "", "resId", "tintIconByColorRes", "(Landroid/view/MenuItem;Landroid/content/Context;I)V", "colorAttr", "tintIconByAttr", "color", "tintIcon", "android_release"}, k = 2, mv = {1, 4, 2})
public final class MenuItemsKt {
    public static final void bindTitle(@NotNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(menuItem, "$this$bindTitle");
        if (charSequence == null || charSequence.length() == 0) {
            hide(menuItem);
            return;
        }
        show(menuItem);
        menuItem.setTitle(charSequence);
    }

    public static final void hide(@Nullable MenuItem menuItem) {
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
    }

    public static final void show(@Nullable MenuItem menuItem) {
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
    }

    public static final void tintIcon(@NotNull MenuItem menuItem, @NotNull Context context, @ColorInt int i) {
        Intrinsics.checkNotNullParameter(menuItem, "$this$tintIcon");
        Intrinsics.checkNotNullParameter(context, "context");
        if (menuItem.getIcon() != null) {
            Drawable mutate = DrawableCompat.wrap(menuItem.getIcon()).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "DrawableCompat.wrap(icon).mutate()");
            mutate.setTint(i);
            menuItem.setIcon(mutate);
        }
    }

    public static final void tintIconByAttr(@NotNull MenuItem menuItem, @NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(menuItem, "$this$tintIconByAttr");
        Intrinsics.checkNotNullParameter(context, "context");
        tintIcon(menuItem, context, Contexts.getColorByAttr(context, i));
    }

    public static final void tintIconByColorRes(@NotNull MenuItem menuItem, @NotNull Context context, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(menuItem, "$this$tintIconByColorRes");
        Intrinsics.checkNotNullParameter(context, "context");
        tintIcon(menuItem, context, ContextCompat.getColor(context, i));
    }
}
