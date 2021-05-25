package com.avito.android.design.widget.search_view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.ColorInt;
import com.avito.android.ui_components.R;
import com.avito.android.util.MenuItemsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/Menu;", "Landroid/content/Context;", "context", "", "color", "", "tintIcons", "(Landroid/view/Menu;Landroid/content/Context;I)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class ToolbarSearchViewKt {
    public static final void access$foreach(Menu menu, Function1 function1) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(i)");
            function1.invoke(item);
        }
    }

    public static final void tintIcons(@NotNull Menu menu, @NotNull Context context, @ColorInt int i) {
        Intrinsics.checkNotNullParameter(menu, "$this$tintIcons");
        Intrinsics.checkNotNullParameter(context, "context");
        int size = menu.size();
        if (size != 0) {
            Iterator it = e.until(0, size).iterator();
            while (it.hasNext()) {
                MenuItem item = menu.getItem(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(item, "item");
                if (!(item.getItemId() == R.id.discard_search || item.getItemId() == R.id.search_action)) {
                    MenuItemsKt.tintIcon(item, context, i);
                }
            }
        }
    }
}
