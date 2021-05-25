package com.avito.android.bundles.vas_union.item.performance.tabs;

import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "tabs", "", "c", "I", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedIndex", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceTabsItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final List<Tab> b;
    public int c;

    public PerformanceTabsItem(@NotNull String str, @NotNull List<Tab> list, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.a = str;
        this.b = list;
        this.c = i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final int getSelectedIndex() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final List<Tab> getTabs() {
        return this.b;
    }

    public final void setSelectedIndex(int i) {
        this.c = i;
    }
}
