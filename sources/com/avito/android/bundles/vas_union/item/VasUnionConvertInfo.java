package com.avito.android.bundles.vas_union.item;

import com.avito.android.bundles.vas_union.item.tabs.TabsInfo;
import com.avito.android.bundles.vas_union.item.tabs.TabsItem;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/VasUnionConvertInfo;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItem;", "getHeaderItem", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItem;", "headerItem", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsInfo;", "c", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsInfo;", "getTabsInfo", "()Lcom/avito/android/bundles/vas_union/item/tabs/TabsInfo;", "tabsInfo", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bundles/vas_union/item/tabs/TabsItem;", "getTabsItem", "()Lcom/avito/android/bundles/vas_union/item/tabs/TabsItem;", "tabsItem", "Lcom/avito/android/bundles/vas_union/item/ContinueInfo;", "d", "Lcom/avito/android/bundles/vas_union/item/ContinueInfo;", "getContinueInfo", "()Lcom/avito/android/bundles/vas_union/item/ContinueInfo;", "continueInfo", "<init>", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItem;Lcom/avito/android/bundles/vas_union/item/tabs/TabsItem;Lcom/avito/android/bundles/vas_union/item/tabs/TabsInfo;Lcom/avito/android/bundles/vas_union/item/ContinueInfo;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionConvertInfo {
    @NotNull
    public final PaidServiceHeaderItem a;
    @NotNull
    public final TabsItem b;
    @NotNull
    public final TabsInfo c;
    @Nullable
    public final ContinueInfo d;

    public VasUnionConvertInfo(@NotNull PaidServiceHeaderItem paidServiceHeaderItem, @NotNull TabsItem tabsItem, @NotNull TabsInfo tabsInfo, @Nullable ContinueInfo continueInfo) {
        Intrinsics.checkNotNullParameter(paidServiceHeaderItem, "headerItem");
        Intrinsics.checkNotNullParameter(tabsItem, "tabsItem");
        Intrinsics.checkNotNullParameter(tabsInfo, "tabsInfo");
        this.a = paidServiceHeaderItem;
        this.b = tabsItem;
        this.c = tabsInfo;
        this.d = continueInfo;
    }

    @Nullable
    public final ContinueInfo getContinueInfo() {
        return this.d;
    }

    @NotNull
    public final PaidServiceHeaderItem getHeaderItem() {
        return this.a;
    }

    @NotNull
    public final TabsInfo getTabsInfo() {
        return this.c;
    }

    @NotNull
    public final TabsItem getTabsItem() {
        return this.b;
    }
}
