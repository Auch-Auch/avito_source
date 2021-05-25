package com.avito.konveyor.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import com.avito.konveyor.blueprint.ViewTypeProvider;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "getCount", "()I", "Lcom/avito/konveyor/blueprint/ItemView;", "view", VKApiConst.POSITION, "", "", "payloads", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;ILjava/util/List;)V", "getViewType", "(I)I", "", "getItemId", "(I)J", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "viewTypeProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "c", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemBinder", "<init>", "(Lcom/avito/konveyor/blueprint/ViewTypeProvider;Lcom/avito/konveyor/blueprint/ItemPresenter;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleAdapterPresenter implements AdapterPresenter {
    public DataSource<? extends Item> a = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
    public final ViewTypeProvider b;
    public final ItemPresenter<ItemView, Item> c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.konveyor.blueprint.ItemView, ? super com.avito.konveyor.blueprint.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleAdapterPresenter(@NotNull ViewTypeProvider viewTypeProvider, @NotNull ItemPresenter<? super ItemView, ? super Item> itemPresenter) {
        Intrinsics.checkNotNullParameter(viewTypeProvider, "viewTypeProvider");
        Intrinsics.checkNotNullParameter(itemPresenter, "itemBinder");
        this.b = viewTypeProvider;
        this.c = itemPresenter;
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void bindView(@NotNull ItemView itemView, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(list, "payloads");
        ItemPresenter<ItemView, Item> itemPresenter = this.c;
        if (itemPresenter instanceof PayloadItemPresenter) {
            ((PayloadItemPresenter) itemPresenter).bindView(itemView, (Item) this.a.getItem(i), i, list);
        } else {
            itemPresenter.bindView(itemView, (Item) this.a.getItem(i), i);
        }
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public long getItemId(int i) {
        return ((Item) this.a.getItem(i)).getId();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getViewType(int i) {
        return this.b.getItemViewType((Item) this.a.getItem(i));
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public boolean isEmpty() {
        return AdapterPresenter.DefaultImpls.isEmpty(this);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }
}
