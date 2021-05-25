package com.avito.android.orders.feature.list;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.remote.orders.model.OrdersPageModel;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListRepositoryImpl;", "Lcom/avito/android/orders/feature/list/OrdersListRepository;", "", "nextPage", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/orders/model/OrdersPageModel;", "loadOrdersNextPage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/orders/OrdersApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/orders/OrdersApi;", "api", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/orders/OrdersApi;Lcom/avito/android/Features;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersListRepositoryImpl implements OrdersListRepository {
    public final SchedulersFactory3 a;
    public final OrdersApi b;
    public final Features c;

    @Inject
    public OrdersListRepositoryImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull OrdersApi ordersApi, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(ordersApi, "api");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = schedulersFactory3;
        this.b = ordersApi;
        this.c = features;
    }

    @Override // com.avito.android.orders.feature.list.OrdersListRepository
    @NotNull
    public Single<TypedResult<OrdersPageModel>> loadOrdersNextPage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "nextPage");
        return a.e2(this.a, this.b.getOrdersNextPage(str, this.c.getSupportsOrderPage().invoke().booleanValue()), "api.getOrdersNextPage(\n …scribeOn(schedulers.io())");
    }
}
