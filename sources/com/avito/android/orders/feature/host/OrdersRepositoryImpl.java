package com.avito.android.orders.feature.host;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.remote.orders.model.OrdersModel;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import java.util.Calendar;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersRepositoryImpl;", "Lcom/avito/android/orders/feature/host/OrdersRepository;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/orders/model/OrdersModel;", "loadOrders", "()Lio/reactivex/rxjava3/core/Single;", "", "d", "Ljava/lang/String;", "ordersToPrefetch", "Lcom/avito/android/remote/orders/OrdersApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/orders/OrdersApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/orders/OrdersApi;Lcom/avito/android/Features;Ljava/lang/String;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersRepositoryImpl implements OrdersRepository {
    public final SchedulersFactory3 a;
    public final OrdersApi b;
    public final Features c;
    public final String d;

    @Inject
    public OrdersRepositoryImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull OrdersApi ordersApi, @NotNull Features features, @Named("orders_to_prefetch") @Nullable String str) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(ordersApi, "api");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = schedulersFactory3;
        this.b = ordersApi;
        this.c = features;
        this.d = str;
    }

    @Override // com.avito.android.orders.feature.host.OrdersRepository
    @NotNull
    public Single<TypedResult<OrdersModel>> loadOrders() {
        OrdersApi ordersApi = this.b;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        TimeZone timeZone = instance.getTimeZone();
        Intrinsics.checkNotNullExpressionValue(timeZone, "Calendar.getInstance().timeZone");
        String id = timeZone.getID();
        Intrinsics.checkNotNullExpressionValue(id, "Calendar.getInstance().timeZone.id");
        return a.e2(this.a, ordersApi.getOrders(id, this.c.getSupportsOrderPage().invoke().booleanValue(), this.d), "api.getOrders(\n         …scribeOn(schedulers.io())");
    }
}
