package com.avito.android.order.feature.order;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.order.OrderApi;
import com.avito.android.remote.order.model.OrderLastUpdate;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/order/feature/order/OrderRepositoryImpl;", "Lcom/avito/android/order/feature/order/OrderRepository;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/order/model/OrderLastUpdate;", "getOrderLastUpdate", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/order/OrderApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/order/OrderApi;", "api", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", AnalyticFieldsName.orderId, "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/order/OrderApi;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory3;)V", "order_release"}, k = 1, mv = {1, 4, 2})
public final class OrderRepositoryImpl implements OrderRepository {
    public final OrderApi a;
    public final String b;
    public final SchedulersFactory3 c;

    @Inject
    public OrderRepositoryImpl(@NotNull OrderApi orderApi, @Named("order_id") @NotNull String str, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(orderApi, "api");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = orderApi;
        this.b = str;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.order.feature.order.OrderRepository
    @NotNull
    public Single<TypedResult<OrderLastUpdate>> getOrderLastUpdate() {
        Single<TypedResult<OrderLastUpdate>> observeOn = this.a.getOrderLastUpdate(this.b).subscribeOn(this.c.io()).observeOn(this.c.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.getOrderLastUpdate(o…(schedulers.mainThread())");
        return observeOn;
    }
}
