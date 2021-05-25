package com.avito.android.remote;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.AdvertStrSwitchResponse;
import com.avito.android.remote.model.RequestPayUrlResponse;
import com.avito.android.remote.model.StrBookingCalculateDetailsResponse;
import com.avito.android.remote.model.StrBookingCalculationReviewResponse;
import com.avito.android.remote.model.StrBookingCalendar;
import com.avito.android.remote.model.StrItemBookingSellerCalendarResponse;
import com.avito.android.remote.model.StrPayoutRedirectResponse;
import com.avito.android.remote.model.StrSellerCalendarParameters;
import com.avito.android.remote.model.StrSellerCalendarParametersUpdateResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VerifiedByAvitoSuccessRequested;
import com.avito.android.remote.model.hotels.HotelsFiltersResult;
import com.avito.android.remote.model.hotels.HotelsSearchResult;
import com.avito.android.remote.model.hotels.HotelsSuggestResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JO\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\f\u0010\rJO\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000f\u0010\rJ}\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t2\u0014\b\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n0\t2\b\b\u0001\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\n0\t2\b\b\u0001\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u0002H'¢\u0006\u0004\b\"\u0010#J%\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b%\u0010\u001fJ9\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\u0002H'¢\u0006\u0004\b(\u0010)J;\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0014\b\u0001\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010H'¢\u0006\u0004\b,\u0010-JO\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\u00022\u0014\b\u0001\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010H'¢\u0006\u0004\b.\u0010/J/\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\n0\t2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u0002H'¢\u0006\u0004\b1\u0010#J/\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\n0\t2\b\b\u0001\u00102\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0002H'¢\u0006\u0004\b5\u0010#J\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002060\tH'¢\u0006\u0004\b7\u00108J%\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\n0\t2\b\b\u0001\u00109\u001a\u00020\u0002H'¢\u0006\u0004\b;\u0010\u001fJ1\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\n0\t2\u0014\b\u0001\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010H'¢\u0006\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/avito/android/remote/ShortTermRentApi;", "", "", "checkInDate", "checkOutDate", "", "guestsCount", "itemId", "workflow", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/StrBookingCalculateDetailsResponse;", "getBookingCalculateDetails", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/StrBookingCalculationReviewResponse;", "getBookingCalculateReview", "", "contacts", "rangeMap", "redirectMap", "Lcom/avito/android/remote/model/RequestPayUrlResponse;", "requestPayUrl", "(Ljava/util/Map;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "isEnabled", "Lcom/avito/android/remote/model/AdvertStrSwitchResponse;", "onlineBookingToggle", "(ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "bookingId", "Lcom/avito/android/remote/model/StrPayoutRedirectResponse;", "getStrPayoutProceedUrl", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "currentDate", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse;", "getSellerCalendar", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/StrSellerCalendarParameters;", "baseSellerCalendarParameters", "startDate", "endDate", "rangeSellerCalendarParameters", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/StrSellerCalendarParametersUpdateResponse;", "updateBaseSellerCalendarParameters", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "updateRangeSellerCalendarParameters", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/StrBookingCalendar;", "bookingCalendar", "name", "phone", "Lcom/avito/android/remote/model/VerifiedByAvitoSuccessRequested;", "requestAvitoVerification", "Lcom/avito/android/remote/model/hotels/HotelsFiltersResult;", "getHotelsFiltersData", "()Lio/reactivex/rxjava3/core/Observable;", "queryString", "Lcom/avito/android/remote/model/hotels/HotelsSuggestResult;", "getHotelsSuggest", "filters", "Lcom/avito/android/remote/model/hotels/HotelsSearchResult;", "searchHotels", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface ShortTermRentApi {
    @GET("1/str/seller/booking/calendar/parameters/base")
    @NotNull
    @NetworkRequestEventId(eventId = 3834)
    Observable<TypedResult<StrSellerCalendarParameters>> baseSellerCalendarParameters(@NotNull @Query("itemId") String str);

    @GET("1/str/item/booking/calendar/data")
    @NotNull
    @NetworkRequestEventId(eventId = 3830)
    Observable<TypedResult<StrBookingCalendar>> bookingCalendar(@NotNull @Query("itemId") String str, @NotNull @Query("startDate") String str2);

    @GET("1/str/booking/calculate/details")
    @NotNull
    @NetworkRequestEventId(eventId = 3826)
    Observable<TypedResult<StrBookingCalculateDetailsResponse>> getBookingCalculateDetails(@NotNull @Query("checkInDate") String str, @NotNull @Query("checkOutDate") String str2, @Query("guestsCount") int i, @NotNull @Query("itemId") String str3, @Nullable @Query("workflow") String str4);

    @GET("1/str/booking/calculation/review")
    @NotNull
    @NetworkRequestEventId(eventId = 3827)
    Observable<TypedResult<StrBookingCalculationReviewResponse>> getBookingCalculateReview(@NotNull @Query("checkInDate") String str, @NotNull @Query("checkOutDate") String str2, @Query("guestsCount") int i, @NotNull @Query("itemId") String str3, @Nullable @Query("workflow") String str4);

    @GET("1/hotels/get")
    @NotNull
    Observable<HotelsFiltersResult> getHotelsFiltersData();

    @GET("1/hotels/suggest")
    @NotNull
    Observable<TypedResult<HotelsSuggestResult>> getHotelsSuggest(@NotNull @Query("query") String str);

    @GET("1/str/item/booking/seller/calendar/data")
    @NotNull
    @NetworkRequestEventId(eventId = 3832)
    Observable<TypedResult<StrItemBookingSellerCalendarResponse>> getSellerCalendar(@NotNull @Query("itemId") String str, @NotNull @Query("currentDate") String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3829)
    @FormUrlEncoded
    @POST("1/str/booking/request/payout")
    Observable<TypedResult<StrPayoutRedirectResponse>> getStrPayoutProceedUrl(@Field("bookingId") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3833)
    @FormUrlEncoded
    @POST("1/str/item/toggleEnabled")
    Observable<TypedResult<AdvertStrSwitchResponse>> onlineBookingToggle(@Field("isEnabled") boolean z, @Field("itemId") @NotNull String str);

    @GET("1/str/seller/booking/calendar/parameters/range")
    @NotNull
    @NetworkRequestEventId(eventId = 3836)
    Observable<TypedResult<StrSellerCalendarParameters>> rangeSellerCalendarParameters(@NotNull @Query("itemId") String str, @NotNull @Query("startDate") String str2, @NotNull @Query("endDate") String str3);

    @POST("1/str/verificationRequest")
    @NotNull
    Observable<TypedResult<VerifiedByAvitoSuccessRequested>> requestAvitoVerification(@NotNull @Query("name") String str, @NotNull @Query("phone") String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3828)
    @FormUrlEncoded
    @POST("1/str/booking/request/pay")
    Observable<TypedResult<RequestPayUrlResponse>> requestPayUrl(@FieldMap @NotNull Map<String, String> map, @Field("guestsCount") int i, @Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map2, @FieldMap @NotNull Map<String, String> map3, @Field("workflow") @Nullable String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/hotels/search")
    Observable<TypedResult<HotelsSearchResult>> searchHotels(@FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3835)
    @FormUrlEncoded
    @POST("1/str/seller/booking/calendar/parameters/base/update")
    Observable<TypedResult<StrSellerCalendarParametersUpdateResponse>> updateBaseSellerCalendarParameters(@Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3837)
    @FormUrlEncoded
    @POST("1/str/seller/booking/calendar/parameters/range/update")
    Observable<TypedResult<StrSellerCalendarParametersUpdateResponse>> updateRangeSellerCalendarParameters(@Field("itemId") @NotNull String str, @Field("startDate") @NotNull String str2, @Field("endDate") @NotNull String str3, @FieldMap @NotNull Map<String, String> map);
}
