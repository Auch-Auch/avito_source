package com.avito.android.remote;

import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.FeeMethodsResult;
import com.avito.android.remote.model.TariffCountPriceResult;
import com.avito.android.remote.model.TariffCountResult;
import com.avito.android.remote.model.TariffInfoResult;
import com.avito.android.remote.model.TariffLandingResult;
import com.avito.android.remote.model.TariffPackageInfoResult;
import com.avito.android.remote.model.TariffRegionResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.change.TariffAutoProlongResult;
import com.avito.android.remote.model.change.TariffChangeResult;
import com.avito.android.remote.model.edit.TariffEditInfoResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000bJ/\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\t2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\t2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\u0012J/\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\t2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0012J%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u000bJ/\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\t2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u0012J%\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u000bJ%\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001f\u0010\u000bJ%\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00050\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b!\u0010\u000bJ\u001b\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00050\tH'¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00050\t2\b\b\u0001\u0010%\u001a\u00020\u0002H'¢\u0006\u0004\b'\u0010\u000bJ\u001b\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\tH'¢\u0006\u0004\b(\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/remote/TariffApi;", "", "", "context", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/FeeMethodsResult;", "getFeeMethodsV3", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Observable;", "getFeeMethodsV4", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TariffRegionResult;", "getTariffRegions", "contractId", "packageId", "Lcom/avito/android/remote/model/TariffPackageInfoResult;", "getTariffPackageInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "id", "checkoutContext", "Lcom/avito/android/remote/model/DeepLinkResponse;", "commitTariffLegacy", "commitTariff", "Lcom/avito/android/remote/model/TariffCountResult;", "getTariffCount", "Lcom/avito/android/remote/model/TariffCountPriceResult;", "getTariffCountPrice", "Lcom/avito/android/remote/model/TariffLandingResult;", "getTariffLanding", "Lcom/avito/android/remote/model/TariffInfoResult;", "getTariffExpiredInfo", "Lcom/avito/android/remote/model/edit/TariffEditInfoResult;", "getTariffInfo", "Lcom/avito/android/remote/model/change/TariffChangeResult;", "getTariffChangeInfo", "()Lio/reactivex/rxjava3/core/Observable;", "autoProlong", "Lcom/avito/android/remote/model/change/TariffAutoProlongResult;", "postTariffAutoProlong", "getApplyChange", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffApi {
    @NotNull
    @FormUrlEncoded
    @POST("2/tariff/commit")
    Observable<TypedResult<DeepLinkResponse>> commitTariff(@Field("id") @NotNull String str, @Field("checkoutContext") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/tariff/commit")
    Observable<TypedResult<DeepLinkResponse>> commitTariffLegacy(@Field("id") @NotNull String str, @Field("checkoutContext") @NotNull String str2);

    @POST("1/tariff/editInfo/applyChange")
    @NotNull
    Observable<TypedResult<Object>> getApplyChange();

    @GET("3/fees/feesMethods")
    @NotNull
    Single<TypedResult<FeeMethodsResult>> getFeeMethodsV3(@NotNull @Query("checkoutContext") String str);

    @GET("4/fees/feesMethods")
    @NotNull
    Observable<TypedResult<FeeMethodsResult>> getFeeMethodsV4(@NotNull @Query("checkoutContext") String str);

    @GET("1/tariff/change")
    @NotNull
    Observable<TypedResult<TariffChangeResult>> getTariffChangeInfo();

    @GET("1/tariff/count")
    @NotNull
    Observable<TypedResult<TariffCountResult>> getTariffCount(@NotNull @Query("checkoutContext") String str);

    @GET("1/tariff/count/price")
    @NotNull
    Observable<TypedResult<TariffCountPriceResult>> getTariffCountPrice(@NotNull @Query("id") String str, @NotNull @Query("checkoutContext") String str2);

    @GET("1/tariff/expiredInfo")
    @NotNull
    Observable<TypedResult<TariffInfoResult>> getTariffExpiredInfo(@NotNull @Query("checkoutContext") String str);

    @GET("1/tariff/info")
    @NotNull
    Observable<TypedResult<TariffEditInfoResult>> getTariffInfo(@NotNull @Query("checkoutContext") String str);

    @GET("2/tariff/landing")
    @NotNull
    Observable<TypedResult<TariffLandingResult>> getTariffLanding(@NotNull @Query("checkoutContext") String str);

    @GET("1/tariff/package")
    @NotNull
    Observable<TypedResult<TariffPackageInfoResult>> getTariffPackageInfo(@NotNull @Query("contractId") String str, @NotNull @Query("packageId") String str2);

    @GET("1/tariff/region")
    @NotNull
    Observable<TypedResult<TariffRegionResult>> getTariffRegions(@NotNull @Query("checkoutContext") String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/tariff/set/autoprolong")
    Observable<TypedResult<TariffAutoProlongResult>> postTariffAutoProlong(@Field("autoProlong") @NotNull String str);
}
