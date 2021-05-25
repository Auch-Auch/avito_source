package com.avito.android.component.badge_bar;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/badge_bar/ExpandableDataSource;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/conveyor_item/Item;", "d", "I", "wrappedStateCount", AuthSource.SEND_ABUSE, "Z", "getExpanded", "setExpanded", "(Z)V", PanelStateKt.PANEL_EXPANDED, "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "contentItems", "getCount", "()I", "count", "c", "Lcom/avito/conveyor_item/Item;", "expandItem", "<init>", "(Ljava/util/List;Lcom/avito/conveyor_item/Item;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ExpandableDataSource implements DataSource<Item> {
    public boolean a;
    public final List<Item> b;
    public final Item c;
    public final int d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableDataSource(@NotNull List<? extends Item> list, @NotNull Item item, int i) {
        Intrinsics.checkNotNullParameter(list, "contentItems");
        Intrinsics.checkNotNullParameter(item, "expandItem");
        this.b = list;
        this.c = item;
        this.d = i;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        int size = this.b.size();
        int size2 = this.a ? this.b.size() : this.d;
        return size2 < size ? size2 + 1 : size;
    }

    public final boolean getExpanded() {
        return this.a;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public final void setExpanded(boolean z) {
        this.a = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandableDataSource(List list, Item item, int i, int i2, j jVar) {
        this(list, item, (i2 & 4) != 0 ? list.size() : i);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public Item getItem(int i) {
        int size = this.a ? this.b.size() : this.d;
        if (i >= 0 && size > i) {
            return this.b.get(i);
        }
        return this.c;
    }
}
