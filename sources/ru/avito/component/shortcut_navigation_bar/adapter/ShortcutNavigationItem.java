package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "Lcom/avito/conveyor_item/Item;", "", "getText", "()Ljava/lang/String;", "text", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "()V", "Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemImpl;", "Lru/avito/component/shortcut_navigation_bar/adapter/ClarifyButtonItem;", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class ShortcutNavigationItem implements Item {
    public ShortcutNavigationItem() {
    }

    @Nullable
    public abstract DeepLink getDeepLink();

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public abstract String getText();

    public ShortcutNavigationItem(j jVar) {
    }
}
