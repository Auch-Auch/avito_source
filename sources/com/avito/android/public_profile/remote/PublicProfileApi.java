package com.avito.android.public_profile.remote;

import com.avito.android.public_profile.remote.model.LegacyPublicProfileResult;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.remote.model.PublicProfileResult;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000b\u0010\tJO\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/public_profile/remote/PublicProfileApi;", "", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/public_profile/remote/model/LegacyPublicProfileResult;", "getLegacyPublicUserProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/model/PublicProfileResult;", "getPublicUserProfile", "", "offset", "limit", "shortcut", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "getProfileAdverts", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface PublicProfileApi {
    @GET("6/user/{userKey}/profile")
    @NotNull
    @NetworkRequestEventId(eventId = 3845)
    Observable<TypedResult<LegacyPublicProfileResult>> getLegacyPublicUserProfile(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);

    @GET("1/user/{userKey}/profile/items")
    @NotNull
    Observable<ProfileAdvertsResult> getProfileAdverts(@Path("userKey") @NotNull String str, @Nullable @Query("offset") Integer num, @Nullable @Query("limit") Integer num2, @Nullable @Query("shortcut") String str2, @Nullable @Query("context") String str3);

    @GET("7/user/{userKey}/profile")
    @NotNull
    @NetworkRequestEventId(eventId = 3845)
    Observable<TypedResult<PublicProfileResult>> getPublicUserProfile(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);
}
