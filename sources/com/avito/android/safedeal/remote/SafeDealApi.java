package com.avito.android.safedeal.remote;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.safedeal.remote.model.DeliveryTypeResponse;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.android.safedeal.remote.model.SafeDealPayoutRedirectResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00052\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00060\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00060\u0005H'¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00060\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/safedeal/remote/SafeDealApi;", "", "", "itemId", "searchContext", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "getDeliveryType", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "orderID", "Lcom/avito/android/safedeal/remote/model/SafeDealPayoutRedirectResponse;", "getSafeDealPayoutProceedUrl", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "itemID", "serviceID", "", "isEnabled", "", "toggleServiceForItem", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings;", "deliveryProfileSettings", "()Lio/reactivex/rxjava3/core/Observable;", "toggleService", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface SafeDealApi {
    @GET("1/attributeAggregator/profile/services/settings/android")
    @NotNull
    Observable<TypedResult<ProfileDeliverySettings>> deliveryProfileSettings();

    @GET("1/attributeAggregator/item/services")
    @NotNull
    Observable<TypedResult<DeliveryTypeResponse>> getDeliveryType(@NotNull @Query("itemId") String str, @Nullable @Query("context") String str2);

    @GET("1/sd/order/request/payout")
    @NotNull
    Observable<TypedResult<SafeDealPayoutRedirectResponse>> getSafeDealPayoutProceedUrl(@NotNull @Query("orderId") String str);

    @POST("1/attributeAggregator/profile/service/toggle")
    @NotNull
    Observable<TypedResult<Unit>> toggleService(@NotNull @Query("serviceId") String str, @Query("isEnabled") boolean z);

    @POST("1/attributeAggregator/item/service/toggle")
    @NotNull
    Observable<TypedResult<Unit>> toggleServiceForItem(@NotNull @Query("itemId") String str, @NotNull @Query("serviceId") String str2, @Query("isEnabled") boolean z);
}
