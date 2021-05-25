package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.remote.model.SearchParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "", "extractCategoryId", "(Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;)Ljava/lang/String;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class ShortcutNavigationItemKt {
    @Nullable
    public static final String extractCategoryId(@NotNull ShortcutNavigationItem shortcutNavigationItem) {
        SearchParams searchParams;
        Intrinsics.checkNotNullParameter(shortcutNavigationItem, "$this$extractCategoryId");
        DeepLink deepLink = shortcutNavigationItem.getDeepLink();
        if (!(deepLink instanceof ItemsSearchLink)) {
            deepLink = null;
        }
        ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
        if (itemsSearchLink == null || (searchParams = itemsSearchLink.getSearchParams()) == null) {
            return null;
        }
        return searchParams.getCategoryId();
    }
}
