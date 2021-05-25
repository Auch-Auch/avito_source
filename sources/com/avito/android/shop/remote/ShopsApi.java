package com.avito.android.shop.remote;

import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.shop.info.ShopInfoResult;
import com.avito.android.shop.detailed.remote.ShopDetailedResult;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J]\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J=\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\n2\b\b\u0001\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u001cJ=\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u0002H'¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/shop/remote/ShopsApi;", "", "", "query", "locationId", "categoryId", UrlParams.LAST_STAMP, "", "limit", "offset", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ShopsListResult;", "getShops", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "", "searchParams", "Lcom/avito/android/remote/model/Shortcuts;", "getShopsShortcuts", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "shopId", "pageFrom", "context", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/shop/detailed/remote/ShopDetailedResult;", "getDetailedShop", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/shop/info/ShopInfoResult;", "getShopInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "fromName", "fromMail", "message", "Lcom/avito/android/remote/model/SuccessResult;", "sendShopFeedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopsApi {
    @GET("7/shops/{shopId}")
    @NotNull
    Observable<TypedResult<ShopDetailedResult>> getDetailedShop(@Path("shopId") @NotNull String str, @Nullable @Query("page_from") String str2, @Nullable @Query("context") String str3);

    @GET("1/shops/{shopId}/description")
    @NotNull
    Observable<TypedResult<ShopInfoResult>> getShopInfo(@Path("shopId") @NotNull String str);

    @GET("2/shops")
    @NotNull
    Observable<ShopsListResult> getShops(@Nullable @Query("query") String str, @Nullable @Query("locationId") String str2, @Nullable @Query("categoryId") String str3, @Nullable @Query("lastStamp") String str4, @Nullable @Query("limit") Integer num, @Nullable @Query("offset") Integer num2);

    @GET("1/shops/shortcuts")
    @NotNull
    Observable<Shortcuts> getShopsShortcuts(@QueryMap @NotNull Map<String, String> map);

    @NotNull
    @FormUrlEncoded
    @POST("2/shops/{shopId}/feedback")
    Observable<SuccessResult> sendShopFeedback(@Path("shopId") @NotNull String str, @Field("fromName") @NotNull String str2, @Field("fromMail") @NotNull String str3, @Field("message") @NotNull String str4);
}
