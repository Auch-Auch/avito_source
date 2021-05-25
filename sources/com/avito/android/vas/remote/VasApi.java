package com.avito.android.vas.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\bJ/\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000bJ%\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\bJE\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u00022\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00122\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/vas/remote/VasApi;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "getPerformanceVas", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "checkoutContext", "getPerformanceVasV2", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/vas/visual/VasVisualResult;", "getVisualVas", "getVisualVasV3", "Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;", "getAppliedVas", "itemId", "", "slugs", "Lcom/avito/android/remote/model/DeepLinkResponse;", "vasContext", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "vas_release"}, k = 1, mv = {1, 4, 2})
public interface VasApi {
    @GET("1/profile/item/{itemId}/vas/applied")
    @NotNull
    @NetworkRequestEventId(eventId = 3755)
    Observable<TypedResult<AppliedVasResult>> getAppliedVas(@Path("itemId") @NotNull String str);

    @GET("1/profile/item/{itemId}/vas/performance")
    @NotNull
    @NetworkRequestEventId(eventId = 3760)
    Observable<TypedResult<VasPerformanceResult>> getPerformanceVas(@Path("itemId") @NotNull String str);

    @GET("2/profile/item/{itemId}/vas/performance")
    @NotNull
    Observable<TypedResult<VasPerformanceResult>> getPerformanceVasV2(@Path("itemId") @NotNull String str, @NotNull @Query("checkoutContext") String str2);

    @GET("1/profile/item/{itemId}/vas/visual")
    @NotNull
    @NetworkRequestEventId(eventId = 3762)
    Observable<TypedResult<VasVisualResult>> getVisualVas(@Path("itemId") @NotNull String str);

    @GET("3/profile/item/{itemId}/vas/visual")
    @NotNull
    Observable<TypedResult<VasVisualResult>> getVisualVasV3(@Path("itemId") @NotNull String str, @NotNull @Query("checkoutContext") String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/vas/context")
    Observable<TypedResult<DeepLinkResponse>> vasContext(@Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @Field("checkoutContext") @NotNull String str2);
}
