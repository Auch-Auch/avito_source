package com.avito.android.orders.feature.host.viewpager;

import a2.b.a.a.a;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProviderImpl;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "", "tabId", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "getTabListDataSource", "(Ljava/lang/String;)Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "", "items", "", "updateItems", "(Ljava/util/Map;)V", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "dataSource", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersInitialDataProviderImpl implements OrdersInitialDataProvider {
    public Map<String, OrderPage> a;

    @Override // com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider
    @NotNull
    public OrderPage getTabListDataSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tabId");
        Map<String, OrderPage> map = this.a;
        Intrinsics.checkNotNull(map);
        OrderPage orderPage = map.get(str);
        if (orderPage != null) {
            return orderPage;
        }
        StringBuilder Q = a.Q(str, " is not in the data source ");
        Q.append(this.a);
        throw new IllegalStateException(Q.toString().toString());
    }

    @Override // com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider
    public void updateItems(@NotNull Map<String, OrderPage> map) {
        Intrinsics.checkNotNullParameter(map, "items");
        this.a = map;
    }
}
