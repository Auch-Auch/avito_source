package com.avito.android.remote;

import com.avito.android.remote.model.FavoriteSellersCount;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UnsubscribeResult;
import com.avito.android.remote.model.subscriber.UserSubscribersResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H'¢\u0006\u0004\b\u000b\u0010\fJC\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H'¢\u0006\u0004\b\r\u0010\fJ9\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0005H'¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0005H'¢\u0006\u0004\b\u0013\u0010\u0010J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\bH'¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\b\b\u0001\u0010\u0017\u001a\u00020\u0002H'¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\b\b\u0001\u0010\u0017\u001a\u00020\u0002H'¢\u0006\u0004\b\u001a\u0010\u0019J%\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\b2\b\b\u0001\u0010\u001b\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0019J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\t0\bH'¢\u0006\u0004\b\u001d\u0010\u0016J\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\bH'¢\u0006\u0004\b\u001e\u0010\u0016J\u001b\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\t0\bH'¢\u0006\u0004\b \u0010\u0016J%\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\t0\b2\b\b\u0001\u0010\u001b\u001a\u00020\u0002H'¢\u0006\u0004\b \u0010\u0019J1\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\b2\u0014\b\u0001\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020!H'¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/remote/FavoriteSellersApi;", "", "", "src", "userKey", "", "isPushAllowed", "withCounters", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/Observable;", "subscribeV2", "Lcom/avito/android/remote/model/UnsubscribeResult;", "unsubscribe", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "isActivate", "", "changeNotifications", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "getFavoriteSellers", "()Lio/reactivex/rxjava3/core/Observable;", "hashId", "getSubscribers", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getSubscriptions", "nextPage", "Lcom/avito/android/remote/model/FavoriteSellersCount;", "getFavoriteSellersCount", "clearSellersCount", "Lcom/avito/android/remote/model/subscriber/UserSubscribersResult;", "getUserSubscribers", "", "userIds", "markAsRead", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable subscribe$default(FavoriteSellersApi favoriteSellersApi, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z2 = false;
                }
                return favoriteSellersApi.subscribe(str, str2, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }

        public static /* synthetic */ Observable subscribeV2$default(FavoriteSellersApi favoriteSellersApi, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z2 = false;
                }
                return favoriteSellersApi.subscribeV2(str, str2, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeV2");
        }

        public static /* synthetic */ Observable unsubscribe$default(FavoriteSellersApi favoriteSellersApi, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return favoriteSellersApi.unsubscribe(str, str2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unsubscribe");
        }
    }

    @NotNull
    @NetworkRequestEventId(eventId = 3731)
    @FormUrlEncoded
    @POST("1/profile/favorite-sellers/notifications/activate")
    Observable<TypedResult<Unit>> changeNotifications(@Field("src") @NotNull String str, @Field("hashUserId") @NotNull String str2, @Field("isActivate") boolean z);

    @NotNull
    @NetworkRequestEventId(eventId = 3734)
    @POST("1/profile/favorite-sellers/unread/clear")
    Observable<TypedResult<Unit>> clearSellersCount();

    @GET("6/profile/favorite-sellers")
    @NotNull
    @NetworkRequestEventId(eventId = 3535)
    Observable<TypedResult<FavoriteSellersLoadingResult>> getFavoriteSellers();

    @GET
    @NotNull
    Observable<TypedResult<FavoriteSellersLoadingResult>> getFavoriteSellers(@Url @NotNull String str);

    @GET("1/profile/favorite-sellers/unread/counter")
    @NotNull
    @NetworkRequestEventId(eventId = 3735)
    Observable<TypedResult<FavoriteSellersCount>> getFavoriteSellersCount();

    @GET("2/profile/favorite-sellers/{hashId}/subscribers")
    @NotNull
    @NetworkRequestEventId(eventId = 3737)
    Observable<TypedResult<FavoriteSellersLoadingResult>> getSubscribers(@Path("hashId") @NotNull String str);

    @GET("2/profile/favorite-sellers/{hashId}/subscriptions")
    @NotNull
    @NetworkRequestEventId(eventId = 3737)
    Observable<TypedResult<FavoriteSellersLoadingResult>> getSubscriptions(@Path("hashId") @NotNull String str);

    @GET("1/profile/favorite-sellers/subscribers")
    @NotNull
    Observable<TypedResult<UserSubscribersResult>> getUserSubscribers();

    @GET
    @NotNull
    Observable<TypedResult<UserSubscribersResult>> getUserSubscribers(@Url @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/favorite-sellers/mark-as-read")
    Observable<TypedResult<Unit>> markAsRead(@FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3733)
    @FormUrlEncoded
    @POST("1/profile/favorite-sellers/subscribe")
    Observable<TypedResult<SubscribeResult>> subscribe(@Field("src") @NotNull String str, @Field("hashUserId") @NotNull String str2, @Field("isPushAllowed") boolean z, @Field("withCounters") boolean z2);

    @NotNull
    @FormUrlEncoded
    @POST("2/profile/favorite-sellers/subscribe")
    Observable<TypedResult<SubscribeResult>> subscribeV2(@Field("src") @NotNull String str, @Field("hashUserId") @NotNull String str2, @Field("isPushAllowed") boolean z, @Field("withCounters") boolean z2);

    @NotNull
    @NetworkRequestEventId(eventId = 3736)
    @FormUrlEncoded
    @POST("1/profile/favorite-sellers/unsubscribe")
    Observable<TypedResult<UnsubscribeResult>> unsubscribe(@Field("src") @NotNull String str, @Field("hashUserId") @NotNull String str2, @Field("withCounters") boolean z);
}
