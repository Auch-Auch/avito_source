package com.avito.android.orders.feature.common.converter;

import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.remote.orders.model.OrdersTab;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "", "Lcom/avito/android/remote/orders/model/OrdersTab;", "tab", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "convert", "(Lcom/avito/android/remote/orders/model/OrdersTab;)Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "orders_release"}, k = 1, mv = {1, 4, 2})
public interface OrdersTabItemConverter {
    @NotNull
    OrdersTabItem convert(@NotNull OrdersTab ordersTab);
}
