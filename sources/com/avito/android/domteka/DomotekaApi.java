package com.avito.android.domteka;

import com.avito.android.remote.ApartmentNumberRequestResponse;
import com.avito.android.remote.DomotekaTeaserResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/domteka/DomotekaApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/DomotekaTeaserResponse;", "getDomotekaDynamicTeaser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getDomotekaDynamicTeaserV2", "Lcom/avito/android/remote/ApartmentNumberRequestResponse;", "getApartmentNumberRequestLink", "domoteka_release"}, k = 1, mv = {1, 4, 2})
public interface DomotekaApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/domoteka/getApartmentNumber")
    Observable<ApartmentNumberRequestResponse> getApartmentNumberRequestLink(@Field("itemId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/domoteka/getDynamicTeaser")
    Observable<DomotekaTeaserResponse> getDomotekaDynamicTeaser(@Field("itemId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("2/domoteka/getDynamicTeaser")
    Observable<DomotekaTeaserResponse> getDomotekaDynamicTeaserV2(@Field("itemId") @NotNull String str);
}
