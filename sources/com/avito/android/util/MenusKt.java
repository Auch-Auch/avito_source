package com.avito.android.util;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroid/view/Menu;", "Landroid/content/Context;", "context", "", "resId", "", "tint", "(Landroid/view/Menu;Landroid/content/Context;I)V", "colorAttr", "tintByAttr", "android_release"}, k = 2, mv = {1, 4, 2})
public final class MenusKt {
    public static final void tint(@NotNull Menu menu, @NotNull Context context, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(menu, "$this$tint");
        Intrinsics.checkNotNullParameter(context, "context");
        int size = menu.size();
        if (size != 0) {
            Iterator it = e.until(0, size).iterator();
            while (it.hasNext()) {
                MenuItem item = menu.getItem(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(item, "getItem(i)");
                MenuItemsKt.tintIconByColorRes(item, context, i);
            }
        }
    }

    public static final void tintByAttr(@NotNull Menu menu, @NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(menu, "$this$tintByAttr");
        Intrinsics.checkNotNullParameter(context, "context");
        int size = menu.size();
        if (size != 0) {
            Iterator it = e.until(0, size).iterator();
            while (it.hasNext()) {
                MenuItem item = menu.getItem(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(item, "getItem(i)");
                MenuItemsKt.tintIconByAttr(item, context, i);
            }
        }
    }
}
