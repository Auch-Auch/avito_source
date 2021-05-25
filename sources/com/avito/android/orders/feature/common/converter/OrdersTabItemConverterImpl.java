package com.avito.android.orders.feature.common.converter;

import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.remote.orders.model.OrdersTab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverterImpl;", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "Lcom/avito/android/remote/orders/model/OrdersTab;", "tab", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "convert", "(Lcom/avito/android/remote/orders/model/OrdersTab;)Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersTabItemConverterImpl implements OrdersTabItemConverter {
    @Override // com.avito.android.orders.feature.common.converter.OrdersTabItemConverter
    @NotNull
    public OrdersTabItem convert(@NotNull OrdersTab ordersTab) {
        Intrinsics.checkNotNullParameter(ordersTab, "tab");
        String counter = ordersTab.getCounter();
        return new OrdersTabItem(ordersTab.getTitle(), ordersTab.getId(), counter != null ? l.toIntOrNull(counter) : null);
    }
}
