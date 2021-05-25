package com.avito.android.subscriptions.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionDeeplinkResult;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.remote.model.TypedResult;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u00072\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0007H'¢\u0006\u0004\b\u0014\u0010\u000bJ5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u00152\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0016\b\u0001\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/SearchSubscription;", "getSearchSubscriptions", "()Lio/reactivex/rxjava3/core/Observable;", "", "subscriptionId", "Lcom/avito/android/remote/model/SubscriptionResult;", "deleteSubscription", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", SDKConstants.PARAM_A2U_BODY, "", "pushFrequency", "addSearchSubscription", "(Ljava/util/Map;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "id", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "getSearchSubscription", "", "updateLastViewState", "updateSearchSubscription", "(Ljava/lang/String;ZLjava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "filterId", "searchParams", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SubscriptionDeeplinkResult;", "getSearchSubscriptionControlDeeplink", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public interface SubscriptionsApi {
    @NotNull
    @FormUrlEncoded
    @POST("2/subscriptions/{filterId}")
    Observable<SearchSubscription> addSearchSubscription(@Path("filterId") @NotNull String str, @Field("pushFrequency") @Nullable Integer num);

    @NotNull
    @NetworkRequestEventId(eventId = 3838)
    @FormUrlEncoded
    @POST("2/subscription")
    Observable<SearchSubscription> addSearchSubscription(@FieldMap @NotNull Map<String, String> map, @Field("pushFrequency") @Nullable Integer num);

    @DELETE("2/subscriptions/{subscriptionId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3840)
    Observable<SubscriptionResult> deleteSubscription(@Path("subscriptionId") @NotNull String str);

    @GET("2/subscriptions/{filterId}")
    @NotNull
    Observable<SearchSubscription> getSearchSubscription(@Path("filterId") @NotNull String str);

    @GET("2/subscription/controlDeeplink")
    @NotNull
    Observable<TypedResult<SubscriptionDeeplinkResult>> getSearchSubscriptionControlDeeplink(@Nullable @Query("filterId") String str, @QueryMap @Nullable Map<String, String> map);

    @GET("3/subscriptions")
    @NotNull
    @NetworkRequestEventId(eventId = 3534)
    Observable<List<SearchSubscription>> getSearchSubscriptions();

    @PUT("2/subscriptions/{subscriptionId}")
    @NotNull
    @FormUrlEncoded
    Observable<SubscriptionResult> updateSearchSubscription(@Path("subscriptionId") @NotNull String str, @Field("isUpdateLastViewTime") boolean z, @Field("pushFrequency") @Nullable Integer num);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable addSearchSubscription$default(SubscriptionsApi subscriptionsApi, Map map, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                return subscriptionsApi.addSearchSubscription(map, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSearchSubscription");
        }

        public static /* synthetic */ Observable updateSearchSubscription$default(SubscriptionsApi subscriptionsApi, String str, boolean z, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    num = null;
                }
                return subscriptionsApi.updateSearchSubscription(str, z, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSearchSubscription");
        }

        public static /* synthetic */ Observable addSearchSubscription$default(SubscriptionsApi subscriptionsApi, String str, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                return subscriptionsApi.addSearchSubscription(str, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSearchSubscription");
        }
    }
}
