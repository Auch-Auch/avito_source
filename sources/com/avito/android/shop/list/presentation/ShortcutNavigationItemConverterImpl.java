package com.avito.android.shop.list.presentation;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Shortcuts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemImpl;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverterImpl;", "Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "convert", "(Lcom/avito/android/remote/model/Shortcuts;)Ljava/util/List;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationItemConverterImpl implements ShortcutNavigationItemConverter {
    @Override // com.avito.android.shop.list.presentation.ShortcutNavigationItemConverter
    @NotNull
    public List<ShortcutNavigationItem> convert(@NotNull Shortcuts shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        List<Action> list = shortcuts.getList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            arrayList.add(new ShortcutNavigationItemImpl(String.valueOf(i), t2.getTitle(), t2.getDeepLink(), false));
            i = i2;
        }
        return arrayList;
    }
}
