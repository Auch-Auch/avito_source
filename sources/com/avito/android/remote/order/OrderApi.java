package com.avito.android.remote.order;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.order.model.OrderLastUpdate;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/order/OrderApi;", "", "", AnalyticFieldsName.orderId, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/order/model/OrderLastUpdate;", "getOrderLastUpdate", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "order_release"}, k = 1, mv = {1, 4, 2})
public interface OrderApi {
    @GET("1/profile/order/lastUpdate")
    @NotNull
    Single<TypedResult<OrderLastUpdate>> getOrderLastUpdate(@NotNull @Query("orderId") String str);
}
