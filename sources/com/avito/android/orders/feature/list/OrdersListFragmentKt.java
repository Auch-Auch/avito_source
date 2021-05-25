package com.avito.android.orders.feature.list;

import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"(\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "loadMoreRelaysCache", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", AuthSource.BOOKING_ORDER, "itemClicksRelayCache", "orders_release"}, k = 2, mv = {1, 4, 2})
public final class OrdersListFragmentKt {
    public static final Map<String, PublishRelay<Unit>> a = new LinkedHashMap();
    public static final Map<String, PublishRelay<OrderItem>> b = new LinkedHashMap();

    public static final /* synthetic */ void access$putIfAbsentLocal(Map map, Object obj, Object obj2) {
        if (map.get(obj) == null) {
            map.put(obj, obj2);
        }
    }
}
