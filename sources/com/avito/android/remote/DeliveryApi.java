package com.avito.android.remote;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.remote.model.OrderCancellationReasons;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UrlResult;
import com.avito.android.remote.model.delivery.CreateOrderResult;
import com.avito.android.remote.model.delivery.DeliveryCourierPayoutRedirectResponse;
import com.avito.android.remote.model.delivery.DeliveryLocationCoordinatesResult;
import com.avito.android.remote.model.delivery.DeliveryMultiPointDetailInfo;
import com.avito.android.remote.model.delivery.DeliveryPayoutRedirectResponse;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.remote.model.delivery.DeliverySpecificQuantityState;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParamsUpdate;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderPayment;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\fJ/\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00060\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\fJI\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00060\u0005H'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0001\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00060\u00052\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0 2\u0014\b\u0001\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0 2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010$2\u0014\b\u0001\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0 2\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0004\b)\u0010*JG\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00060\u00052\b\b\u0001\u0010+\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H'¢\u0006\u0004\b.\u0010/J%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b1\u0010\fJ;\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00060\u00052\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0002H'¢\u0006\u0004\b4\u00105J]\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00060\u00052\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u00022\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u00172\u0014\b\u0001\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H'¢\u0006\u0004\b9\u0010:Ji\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00060;2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u00022\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H'¢\u0006\u0004\b=\u0010>JC\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00060;2\b\b\u0001\u00102\u001a\u00020\u00022\b\b\u0001\u0010?\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u00022\b\b\u0001\u00106\u001a\u00020\u0017H'¢\u0006\u0004\bA\u0010BJ/\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u0002H'¢\u0006\u0004\bE\u0010\tJ/\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u0002H'¢\u0006\u0004\bF\u0010\tJ9\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u00022\b\b\u0001\u0010G\u001a\u00020\u0002H'¢\u0006\u0004\bI\u00105JE\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u00022\u0014\b\u0001\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H'¢\u0006\u0004\bK\u0010/J%\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00060\u00052\b\b\u0001\u00102\u001a\u00020\u0002H'¢\u0006\u0004\bM\u0010\fJ%\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00060\u00052\b\b\u0001\u00102\u001a\u00020\u0002H'¢\u0006\u0004\bN\u0010\fJE\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u00060\u00052\b\b\u0001\u00102\u001a\u00020\u00022\b\b\u0001\u0010O\u001a\u00020\u00022\u0014\b\u0001\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 H'¢\u0006\u0004\bQ\u0010/J%\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\bS\u0010\f¨\u0006T"}, d2 = {"Lcom/avito/android/remote/DeliveryApi;", "", "", AnalyticFieldsName.orderId, "searchContext", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/UrlResult;", "getPaymentUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/delivery/DeliveryPayoutRedirectResponse;", "getDeliveryPayoutProceedUrl", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "cancelDeliveryOrder", "itemId", "", "enabled", "Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "advertItemToggleDelivery", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/OrderCancellationReasons;", "getCancellationReasons", "", "reasonId", "reasonTitle", "reasonText", "sendCancelReason", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/delivery/DeliveryLocationCoordinatesResult;", "getLocationCoordinates", "()Lio/reactivex/rxjava3/core/Observable;", "", "", "topLeft", "bottomRight", "", "clusterRadius", "userCoords", "useOrderHistory", "Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;", "getDeliveryPointsRect", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Float;Ljava/util/Map;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "fiasGuid", "serviceIds", "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "getDeliveryPointShortInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "getDeliveryExistingSummary", BookingInfoActivity.EXTRA_ITEM_ID, "serviceId", "getDeliverySummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", FirebaseAnalytics.Param.QUANTITY, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/delivery/OrderIdResult;", "createDeliveryOrderLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/delivery/CreateOrderResult;", "createDeliveryOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "fiasGuidTo", "Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;", "checkItemQuantity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Single;", "source", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "getDeliveryCourierOrderParamsV1", "getDeliveryCourierOrderParams", "location", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals;", "getDeliveryCourierTimeIntervalSelect", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParamsUpdate;", "submitCourierOrderUpdate", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", "getCourierDeliverySummaryV1", "getCourierDeliverySummary", "providerKey", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderPayment;", "createCourierDeliveryOrder", "Lcom/avito/android/remote/model/delivery/DeliveryCourierPayoutRedirectResponse;", "getDeliveryCourierPayoutProceedUrl", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryApi {
    @NotNull
    @NetworkRequestEventId(eventId = 3627)
    @FormUrlEncoded
    @POST("1/delivery/item/{itemId}/toggleDelivery")
    Observable<TypedResult<AdvertDeliverySwitchResponse>> advertItemToggleDelivery(@Path("itemId") @NotNull String str, @Field("enabled") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3630)
    @POST("1/delivery/order/{orderId}/cancel")
    Observable<TypedResult<Unit>> cancelDeliveryOrder(@Path("orderId") @NotNull String str);

    @GET("1/cart/item/check/quantity")
    @NotNull
    Single<TypedResult<DeliverySpecificQuantityState>> checkItemQuantity(@NotNull @Query("itemId") String str, @NotNull @Query("fiasGuidTo") String str2, @NotNull @Query("serviceId") String str3, @Query("quantity") int i);

    @POST("1/deliveryCourier/order/create")
    @NotNull
    Observable<TypedResult<DeliveryCourierOrderPayment>> createCourierDeliveryOrder(@NotNull @Query("itemId") String str, @NotNull @Query("providerKey") String str2, @QueryMap @NotNull Map<String, String> map);

    @NotNull
    @FormUrlEncoded
    @POST("1/order/create")
    Single<TypedResult<CreateOrderResult>> createDeliveryOrder(@Field("itemId") @Nullable String str, @Field("fiasGuid") @NotNull String str2, @Field("serviceId") @NotNull String str3, @Field("quantity") @Nullable Integer num, @Field("context") @Nullable String str4, @FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3603)
    @POST("1/delivery/order/create")
    Observable<TypedResult<OrderIdResult>> createDeliveryOrderLegacy(@Nullable @Query("itemId") String str, @NotNull @Query("fiasGuid") String str2, @NotNull @Query("serviceId") String str3, @Nullable @Query("quantity") Integer num, @QueryMap @NotNull Map<String, String> map);

    @GET("2/delivery/order/{orderId}/cancel/reasons")
    @NotNull
    @NetworkRequestEventId(eventId = 3631)
    Observable<TypedResult<OrderCancellationReasons>> getCancellationReasons(@Path("orderId") @NotNull String str);

    @GET("2/deliveryCourier/order/summary/android")
    @NotNull
    Observable<TypedResult<DeliveryCourierSummary>> getCourierDeliverySummary(@NotNull @Query("itemId") String str);

    @GET("1/deliveryCourier/order/summary/android")
    @NotNull
    Observable<TypedResult<DeliveryCourierSummary>> getCourierDeliverySummaryV1(@NotNull @Query("itemId") String str);

    @GET("2/deliveryCourier/order/params/android")
    @NotNull
    Observable<TypedResult<DeliveryCourierOrderParams>> getDeliveryCourierOrderParams(@NotNull @Query("orderId") String str, @NotNull @Query("source") String str2);

    @GET("1/deliveryCourier/order/params/android")
    @NotNull
    Observable<TypedResult<DeliveryCourierOrderParams>> getDeliveryCourierOrderParamsV1(@NotNull @Query("orderId") String str, @NotNull @Query("source") String str2);

    @GET("1/deliveryCourier/order/request/payout")
    @NotNull
    Observable<TypedResult<DeliveryCourierPayoutRedirectResponse>> getDeliveryCourierPayoutProceedUrl(@NotNull @Query("orderId") String str);

    @GET("1/deliveryCourier/timeInterval/select")
    @NotNull
    Observable<TypedResult<DeliveryCourierTimeIntervals>> getDeliveryCourierTimeIntervalSelect(@NotNull @Query("orderId") String str, @NotNull @Query("source") String str2, @NotNull @Query("location") String str3);

    @GET("3/delivery/order/summary")
    @NotNull
    Observable<TypedResult<DeliverySummaryRds>> getDeliveryExistingSummary(@NotNull @Query("orderId") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3633)
    @POST("1/delivery/order/{orderId}/payout")
    Observable<TypedResult<DeliveryPayoutRedirectResponse>> getDeliveryPayoutProceedUrl(@Path("orderId") @NotNull String str);

    @GET("3/delivery/point/short")
    @NotNull
    Observable<TypedResult<DeliveryMultiPointDetailInfo>> getDeliveryPointShortInfo(@NotNull @Query("fiasGuid") String str, @Nullable @Query("itemId") String str2, @QueryMap @NotNull Map<String, String> map);

    @GET("6/items/delivery/points/map")
    @NotNull
    Observable<TypedResult<DeliveryPointsRectResult>> getDeliveryPointsRect(@Nullable @Query("itemId") String str, @QueryMap @NotNull Map<String, Double> map, @QueryMap @NotNull Map<String, Double> map2, @Nullable @Query("clusterRadius") Float f, @QueryMap @NotNull Map<String, Double> map3, @Nullable @Query("useOrderHistory") Boolean bool);

    @GET("2/delivery/summary")
    @NotNull
    @NetworkRequestEventId(eventId = 3638)
    Observable<TypedResult<DeliverySummaryRds>> getDeliverySummary(@Nullable @Query("itemId") String str, @NotNull @Query("fiasGuid") String str2, @NotNull @Query("serviceId") String str3);

    @GET("1/location/coords/current")
    @NotNull
    @NetworkRequestEventId(eventId = 3681)
    Observable<TypedResult<DeliveryLocationCoordinatesResult>> getLocationCoordinates();

    @NotNull
    @NetworkRequestEventId(eventId = 3632)
    @FormUrlEncoded
    @POST("1/delivery/order/{orderId}/pay")
    Observable<TypedResult<UrlResult>> getPaymentUrl(@Path("orderId") @NotNull String str, @Field("context") @Nullable String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3630)
    @FormUrlEncoded
    @POST("1/delivery/order/{orderId}/cancel")
    Observable<TypedResult<Unit>> sendCancelReason(@Path("orderId") @NotNull String str, @Field("reasonId") @Nullable Integer num, @Field("reasonTitle") @Nullable String str2, @Field("reasonText") @Nullable String str3);

    @POST("1/deliveryCourier/order/params/update")
    @NotNull
    Observable<TypedResult<DeliveryCourierOrderParamsUpdate>> submitCourierOrderUpdate(@NotNull @Query("orderId") String str, @NotNull @Query("source") String str2, @QueryMap @NotNull Map<String, String> map);
}
