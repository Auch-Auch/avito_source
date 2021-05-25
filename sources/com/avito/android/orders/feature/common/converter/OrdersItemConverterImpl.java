package com.avito.android.orders.feature.common.converter;

import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.remote.orders.model.OrderData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/orders/feature/common/converter/OrdersItemConverterImpl;", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "", "Lcom/avito/android/remote/orders/model/OrderData;", "orders", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersItemConverterImpl implements OrdersItemConverter {
    @Override // com.avito.android.orders.feature.common.converter.OrdersItemConverter
    @NotNull
    public List<OrderItem> convert(@NotNull List<OrderData> list) {
        Intrinsics.checkNotNullParameter(list, "orders");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new OrderItem(t.getOrderId(), t.getTitle(), t.getDate(), t.getDeepLink(), t.getPrice(), t.getStatus(), t.getItems(), t.getImages(), t.getClickEvent()));
        }
        return arrayList;
    }
}
