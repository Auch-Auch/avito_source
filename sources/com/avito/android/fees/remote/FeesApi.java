package com.avito.android.fees.remote;

import com.avito.android.remote.model.AdvertFeesResponse;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/fees/remote/FeesApi;", "", "", "itemId", "publishSessionId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertFeesResponse;", "getItemFees", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "packageId", "Lcom/avito/android/remote/model/SuccessResult;", "applyItemFeesPackage", "(Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Observable;", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface FeesApi {
    @NotNull
    @FormUrlEncoded
    @POST("2/profile/item/{itemId}/fees/applyPackage")
    Observable<SuccessResult> applyItemFeesPackage(@Path("itemId") @NotNull String str, @Field("packageId") long j);

    @GET("4/profile/item/{itemId}/fees")
    @NotNull
    Observable<AdvertFeesResponse> getItemFees(@Path("itemId") @NotNull String str, @NotNull @Query("publishSessionId") String str2);
}
