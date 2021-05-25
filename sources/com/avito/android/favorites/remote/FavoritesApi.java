package com.avito.android.favorites.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.FavoritesCount;
import com.avito.android.remote.model.FavoritesLoadingResult;
import com.avito.android.remote.model.FavoritesRemoveAllResponse;
import com.avito.android.remote.model.FavoritesResponse;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0002H'¢\u0006\u0004\b\u000f\u0010\u0005J%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u000f\u0010\u0012J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0010H'¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0010H'¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0010H'¢\u0006\u0004\b\u0017\u0010\u0012J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r0\u0002H'¢\u0006\u0004\b\u0019\u0010\u0005J\u001b\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\r0\u0002H'¢\u0006\u0004\b\u001b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorites/remote/FavoritesApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/FavoritesRemoveAllResponse;", "clearFavorites", "()Lio/reactivex/rxjava3/core/Observable;", "removeInactiveFavorites", "", "page", "limit", "Lcom/avito/android/remote/model/FavoritesResponse;", "getFavorites", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/FavoritesLoadingResult;", "getFavoritesV3", "", "nextPage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "ids", "getFavoritesByIds", "Lcom/avito/android/remote/model/SuccessResult;", "addToFavorites", "removeFromFavorites", "Lcom/avito/android/remote/model/FavoritesCount;", "getFavoritesCount", "", "clearFavoritesCount", "favorite_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritesApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getFavorites$default(FavoritesApi favoritesApi, Integer num, Integer num2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = null;
                }
                if ((i & 2) != 0) {
                    num2 = null;
                }
                return favoritesApi.getFavorites(num, num2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFavorites");
        }
    }

    @NotNull
    @NetworkRequestEventId(eventId = 3740)
    @FormUrlEncoded
    @POST("3/profile/favorites/add")
    Observable<SuccessResult> addToFavorites(@Field("ids") @NotNull String str);

    @POST("2/profile/favorites/clear")
    @NotNull
    Observable<FavoritesRemoveAllResponse> clearFavorites();

    @POST("1/profile/favorites/unread/clear")
    @NotNull
    Observable<TypedResult<Unit>> clearFavoritesCount();

    @GET("2/profile/favorites?includeRefs=1")
    @NotNull
    @NetworkRequestEventId(eventId = 3533)
    Observable<FavoritesResponse> getFavorites(@Nullable @Query("page") Integer num, @Nullable @Query("limit") Integer num2);

    @GET("4/items?includeRefs=1")
    @NotNull
    Observable<FavoritesResponse> getFavoritesByIds(@NotNull @Query("ids") String str);

    @GET("1/profile/favorites/unread/counter")
    @NotNull
    Observable<TypedResult<FavoritesCount>> getFavoritesCount();

    @GET("3/profile/favorites")
    @NotNull
    @NetworkRequestEventId(eventId = 3533)
    Observable<TypedResult<FavoritesLoadingResult>> getFavoritesV3();

    @GET
    @NotNull
    @NetworkRequestEventId(eventId = 3533)
    Observable<TypedResult<FavoritesLoadingResult>> getFavoritesV3(@Url @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3741)
    @FormUrlEncoded
    @POST("3/profile/favorites/remove")
    Observable<SuccessResult> removeFromFavorites(@Field("ids") @NotNull String str);

    @POST("2/profile/favorites/inactive/remove")
    @NotNull
    Observable<FavoritesRemoveAllResponse> removeInactiveFavorites();
}
