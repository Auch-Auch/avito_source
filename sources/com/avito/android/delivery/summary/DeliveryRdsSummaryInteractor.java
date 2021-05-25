package com.avito.android.delivery.summary;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UrlResult;
import com.avito.android.remote.model.delivery.CreateOrderResult;
import com.avito.android.remote.model.delivery.DeliverySpecificQuantityState;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.util.LoadingState;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJW\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H&¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u00042\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "", "", AnalyticFieldsName.orderId, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "getExistingOrderSummary", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", BookingInfoActivity.EXTRA_ITEM_ID, "fiasGuid", "serviceId", "getOrderSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "fiasGuidTo", "", FirebaseAnalytics.Param.QUANTITY, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;", "checkQuantity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Single;", "pointId", "", "parametersMap", "Lcom/avito/android/remote/model/delivery/OrderIdResult;", "createDeliveryOrderLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "fieldsMap", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/delivery/CreateOrderResult;", "createDeliveryOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "payOrderId", "Lcom/avito/android/remote/model/UrlResult;", "getPaymentUrl", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsSummaryInteractor {
    @NotNull
    Single<DeliverySpecificQuantityState> checkQuantity(@Nullable String str, @Nullable String str2, @Nullable String str3, int i);

    @NotNull
    Single<TypedResult<CreateOrderResult>> createDeliveryOrder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @NotNull Map<String, String> map);

    @NotNull
    Observable<LoadingState<OrderIdResult>> createDeliveryOrderLegacy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @NotNull Map<String, String> map);

    @NotNull
    Observable<LoadingState<DeliverySummaryRds>> getExistingOrderSummary(@NotNull String str);

    @NotNull
    Observable<LoadingState<DeliverySummaryRds>> getOrderSummary(@Nullable String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Observable<LoadingState<UrlResult>> getPaymentUrl(@NotNull String str);
}
