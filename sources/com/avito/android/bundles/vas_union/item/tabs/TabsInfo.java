package com.avito.android.bundles.vas_union.item.tabs;

import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/tabs/TabsInfo;", "", "Lcom/avito/android/design/widget/tab/CommonTab;", "selectedTab", "", "Lcom/avito/conveyor_item/Item;", "getItemsForTab", "(Lcom/avito/android/design/widget/tab/CommonTab;)Ljava/util/List;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/tab/CommonTab;", "getSelectedTab", "()Lcom/avito/android/design/widget/tab/CommonTab;", "setSelectedTab", "(Lcom/avito/android/design/widget/tab/CommonTab;)V", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getTabs", "()Ljava/util/Map;", "tabs", "<init>", "(Ljava/util/Map;Lcom/avito/android/design/widget/tab/CommonTab;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class TabsInfo {
    @NotNull
    public final Map<CommonTab, List<Item>> a;
    @NotNull
    public CommonTab b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<com.avito.android.design.widget.tab.CommonTab, ? extends java.util.List<? extends com.avito.conveyor_item.Item>> */
    /* JADX WARN: Multi-variable type inference failed */
    public TabsInfo(@NotNull Map<CommonTab, ? extends List<? extends Item>> map, @NotNull CommonTab commonTab) {
        Intrinsics.checkNotNullParameter(map, "tabs");
        Intrinsics.checkNotNullParameter(commonTab, "selectedTab");
        this.a = map;
        this.b = commonTab;
    }

    @NotNull
    public final List<Item> getItemsForTab(@NotNull CommonTab commonTab) {
        Intrinsics.checkNotNullParameter(commonTab, "selectedTab");
        List<Item> list = this.a.get(commonTab);
        return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public final CommonTab getSelectedTab() {
        return this.b;
    }

    @NotNull
    public final Map<CommonTab, List<Item>> getTabs() {
        return this.a;
    }

    public final void setSelectedTab(@NotNull CommonTab commonTab) {
        Intrinsics.checkNotNullParameter(commonTab, "<set-?>");
        this.b = commonTab;
    }
}
