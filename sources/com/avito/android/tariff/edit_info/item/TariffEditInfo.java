package com.avito.android.tariff.edit_info.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.edit_info.item.tabs.PeriodTab;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R+\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/TariffEditInfo;", "", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "selectedTab", "", "Lcom/avito/conveyor_item/Item;", "getItemsForTab", "(Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;)Ljava/util/List;", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getTabs", "()Ljava/util/Map;", "tabs", "c", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "getSelectedTab", "()Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "setSelectedTab", "(Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffEditInfo {
    @NotNull
    public final String a;
    @NotNull
    public final Map<PeriodTab, List<Item>> b;
    @NotNull
    public PeriodTab c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<com.avito.android.tariff.edit_info.item.tabs.PeriodTab, ? extends java.util.List<? extends com.avito.conveyor_item.Item>> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffEditInfo(@NotNull String str, @NotNull Map<PeriodTab, ? extends List<? extends Item>> map, @NotNull PeriodTab periodTab) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(map, "tabs");
        Intrinsics.checkNotNullParameter(periodTab, "selectedTab");
        this.a = str;
        this.b = map;
        this.c = periodTab;
    }

    @NotNull
    public final List<Item> getItemsForTab(@NotNull PeriodTab periodTab) {
        Intrinsics.checkNotNullParameter(periodTab, "selectedTab");
        List<Item> list = this.b.get(periodTab);
        return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public final PeriodTab getSelectedTab() {
        return this.c;
    }

    @NotNull
    public final Map<PeriodTab, List<Item>> getTabs() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    public final void setSelectedTab(@NotNull PeriodTab periodTab) {
        Intrinsics.checkNotNullParameter(periodTab, "<set-?>");
        this.c = periodTab;
    }
}
