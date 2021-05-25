package com.avito.android.orders.feature.host;

import android.os.Bundle;
import com.avito.android.orders.di.component.OrdersHostComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "tab", "ordersToPrefetch", "Lcom/avito/android/orders/feature/host/OrdersFragment;", "createOrdersFragment", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/orders/feature/host/OrdersFragment;", "orders_release"}, k = 2, mv = {1, 4, 2})
public final class OrdersFragmentKt {
    @NotNull
    public static final OrdersFragment createOrdersFragment(@Nullable String str, @Nullable String str2) {
        OrdersFragment ordersFragment = new OrdersFragment();
        Bundle bundle = new Bundle(2);
        bundle.putString("orders_tab", str);
        bundle.putString(OrdersHostComponentKt.ORDERS_TO_PREFETCH, str2);
        Unit unit = Unit.INSTANCE;
        ordersFragment.setArguments(bundle);
        return ordersFragment;
    }
}
