package com.avito.android.bundles.vas_union.item.tabs;

import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/tabs/TabsItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "c", "I", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedIndex", "d", "getSelectedPerformanceTabsTitle", "setSelectedPerformanceTabsTitle", "(Ljava/lang/String;)V", "selectedPerformanceTabsTitle", "", "Lcom/avito/android/design/widget/tab/CommonTab;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "tabs", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class TabsItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final List<CommonTab> b;
    public int c;
    @Nullable
    public String d;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.design.widget.tab.CommonTab> */
    /* JADX WARN: Multi-variable type inference failed */
    public TabsItem(@NotNull String str, @NotNull List<? extends CommonTab> list, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.a = str;
        this.b = list;
        this.c = i;
        this.d = str2;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final int getSelectedIndex() {
        return this.c;
    }

    @Nullable
    public final String getSelectedPerformanceTabsTitle() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final List<CommonTab> getTabs() {
        return this.b;
    }

    public final void setSelectedIndex(int i) {
        this.c = i;
    }

    public final void setSelectedPerformanceTabsTitle(@Nullable String str) {
        this.d = str;
    }
}
