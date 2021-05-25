package com.avito.android.orders.feature.list.adapter.loading;

import com.avito.android.public_profile.adapter.loading_item.PageLoadingItem;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/orders/feature/list/adapter/loading/OrderLoadingItem;", "Lcom/avito/conveyor_item/Item;", "", "stringId", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderLoadingItem implements Item {
    @NotNull
    public static final OrderLoadingItem INSTANCE = new OrderLoadingItem();

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return PageLoadingItem.ID;
    }
}
