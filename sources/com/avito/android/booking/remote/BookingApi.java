package com.avito.android.booking.remote;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.booking.remote.model.BookingInfoModel;
import com.avito.android.booking.remote.model.BookingOrderCreationResponse;
import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/booking/remote/BookingApi;", "", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/booking/remote/model/BookingInfoModel;", "getBookingInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "enabled", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "setBookingEnabled", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "loadBookingOrderData", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/booking/remote/model/BookingOrderCreationResponse;", "createBookingOrder", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingApi {
    @POST("1/car/booking/order/create")
    @NotNull
    Observable<TypedResult<BookingOrderCreationResponse>> createBookingOrder(@NotNull @Query("itemId") String str, @QueryMap @NotNull Map<String, String> map);

    @GET("1/car/booking/info")
    @NotNull
    Observable<TypedResult<BookingInfoModel>> getBookingInfo(@NotNull @Query("itemId") String str, @NotNull @Query("fromBlock") String str2);

    @GET("1/car/booking/order")
    @NotNull
    Observable<TypedResult<BookingOrderResponse>> loadBookingOrderData(@NotNull @Query("itemId") String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/car/booking/setEnabled")
    Single<TypedResult<SimpleMessageResult>> setBookingEnabled(@Field("itemId") @NotNull String str, @Field("enabled") boolean z);
}
