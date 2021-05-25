package com.avito.android.remote.orders;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.model.OrdersModel;
import com.avito.android.remote.orders.model.OrdersPageModel;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00072\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/orders/OrdersApi;", "", "", "location", "", "supportsOrderPage", "ordersToPrefetch", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/orders/model/OrdersModel;", "getOrders", "(Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "nextPage", "Lcom/avito/android/remote/orders/model/OrdersPageModel;", "getOrdersNextPage", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "orders_release"}, k = 1, mv = {1, 4, 2})
public interface OrdersApi {
    @GET("1/profile/orders")
    @NotNull
    Single<TypedResult<OrdersModel>> getOrders(@NotNull @Query("location") String str, @Query("supportsOrderPage") boolean z, @Nullable @Query("ordersToPrefetch") String str2);

    @GET
    @NotNull
    Single<TypedResult<OrdersPageModel>> getOrdersNextPage(@Url @NotNull String str, @Query("supportsOrderPage") boolean z);
}
