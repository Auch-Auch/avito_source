package com.avito.android.user_adverts.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.CountResult;
import com.avito.android.remote.model.IncomeInfo;
import com.avito.android.remote.model.IncomeResultV2;
import com.avito.android.remote.model.OrdersInfo;
import com.avito.android.remote.model.ProfileItemsConfig;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UserAdvertsResult;
import com.avito.android.remote.model.UserAdvertsShortcuts;
import com.avito.android.remote.model.UserSearchSuggests;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ3\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\n\u0010\tJ'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\rJ\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0001\u0010\u0012\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u0013H'¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00060\u0013H'¢\u0006\u0004\b\u001d\u0010\u0019J\u001b\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00060\u0013H'¢\u0006\u0004\b\u001f\u0010\u0019J\u001b\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00060\u0005H'¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00060\u0005H'¢\u0006\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "", "", "shortcut", "isFirstTab", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/UserAdvertsResult;", "getUserAdvertsV11", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getUserAdverts", "query", "searchUserAdverts", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/UserSearchSuggests;", "getSearchSuggest", "nextPage", "getNextUserAdverts", "bannerId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "closeInfoBanner", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/UserAdvertsShortcuts;", "getUserAdvertsShortcuts", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/CountResult;", "getExpiredItemsCount", "Lcom/avito/android/remote/model/IncomeResultV2;", "getItemsIncomeV2", "Lcom/avito/android/remote/model/IncomeInfo;", "getIncomeInfo", "Lcom/avito/android/remote/model/ProfileItemsConfig;", "getProfileSearchConfig", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/OrdersInfo;", "getOrdersInfo", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single getUserAdverts$default(UserAdvertsApi userAdvertsApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return userAdvertsApi.getUserAdverts(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserAdverts");
        }

        public static /* synthetic */ Single getUserAdvertsV11$default(UserAdvertsApi userAdvertsApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return userAdvertsApi.getUserAdvertsV11(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserAdvertsV11");
        }
    }

    @DELETE("1/infobanner/{id}")
    @NotNull
    @NetworkRequestEventId(eventId = 3654)
    Observable<SuccessResult> closeInfoBanner(@Path("id") @NotNull String str);

    @GET("1/profile/items/expired/count")
    @NotNull
    @NetworkRequestEventId(eventId = 3765)
    Observable<TypedResult<CountResult>> getExpiredItemsCount();

    @GET("2/profile/items/income/show")
    @NotNull
    Observable<TypedResult<IncomeInfo>> getIncomeInfo();

    @GET("2/profile/items/income")
    @NotNull
    Observable<TypedResult<IncomeResultV2>> getItemsIncomeV2();

    @GET
    @NotNull
    Single<TypedResult<UserAdvertsResult>> getNextUserAdverts(@Url @NotNull String str);

    @GET("1/profile/orders/summary")
    @NotNull
    Single<TypedResult<OrdersInfo>> getOrdersInfo();

    @GET("1/profile/items/bootstrap")
    @NotNull
    Single<TypedResult<ProfileItemsConfig>> getProfileSearchConfig();

    @GET("1/profile/items/suggest")
    @NotNull
    Single<TypedResult<UserSearchSuggests>> getSearchSuggest(@NotNull @Query("q") String str);

    @GET("12/profile/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3763)
    Single<TypedResult<UserAdvertsResult>> getUserAdverts(@Nullable @Query("shortcut") String str, @Nullable @Query("isFirstTab") String str2);

    @GET("3/profile/items/shortcuts")
    @NotNull
    @NetworkRequestEventId(eventId = 3768)
    Observable<UserAdvertsShortcuts> getUserAdvertsShortcuts();

    @GET("11/profile/items")
    @NotNull
    @NetworkRequestEventId(eventId = 3763)
    Single<TypedResult<UserAdvertsResult>> getUserAdvertsV11(@Nullable @Query("shortcut") String str, @Nullable @Query("isFirstTab") String str2);

    @GET("11/profile/items")
    @NotNull
    Single<TypedResult<UserAdvertsResult>> searchUserAdverts(@Nullable @Query("q") String str);
}
