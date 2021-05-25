package com.avito.android.shop.list.presentation;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Shortcuts;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "convert", "(Lcom/avito/android/remote/model/Shortcuts;)Ljava/util/List;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutNavigationItemConverter {
    @NotNull
    List<ShortcutNavigationItem> convert(@NotNull Shortcuts shortcuts);
}
