package com.avito.android.remote;

import com.avito.android.remote.model.SessionsResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J?\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0011\u0010\u0012JK\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/SessionsApi;", "", "", "fromTimestamp", "", "timezoneOffset", "", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SessionsResult;", "getSessions", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "deviceId", "sessionHashId", "loginType", "", "deleteOneSession", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "deleteOtherSessions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "sessions_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/profile/sessions/delete/one")
    Observable<TypedResult<Unit>> deleteOneSession(@Field("deviceId") @Nullable String str, @Field("sessionIdHash") @Nullable String str2, @Field("loginType") @Nullable String str3);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/sessions/delete/other")
    Observable<TypedResult<Unit>> deleteOtherSessions(@Field("deviceId") @Nullable String str, @Field("sessionIdHash") @Nullable String str2, @Field("loginType") @Nullable String str3, @Field("source") @Nullable String str4);

    @GET("1/profile/sessions/list")
    @NotNull
    Observable<TypedResult<SessionsResult>> getSessions(@Nullable @Query("cursor") Long l, @Nullable @Query("timezone") Integer num, @Nullable @Query("source") String str);
}
