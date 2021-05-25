package com.avito.android.remote;

import com.avito.android.remote.model.ExtendedProfileAdvertsNextPageResult;
import com.avito.android.remote.model.ExtendedProfilePhoneResponse;
import com.avito.android.remote.model.ExtendedProfileResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00052\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000f\u0010\tJ1\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0011\u0010\tJ1\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/ExtendedProfileApi;", "", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ExtendedProfileResult;", "getExtendedProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "url", "Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPageResult;", "getNextPage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse;", "getPhoneAction", "", "call", "confirmCall", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileApi {
    @POST("1/user/{userKey}/extended-profile/call")
    @NotNull
    Observable<TypedResult<Unit>> call(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);

    @POST("1/user/{userKey}/extended-profile/call-confirm")
    @NotNull
    Observable<TypedResult<Unit>> confirmCall(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);

    @GET("1/user/{userKey}/extended-profile")
    @NotNull
    Observable<TypedResult<ExtendedProfileResult>> getExtendedProfile(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);

    @GET
    @NotNull
    Observable<TypedResult<ExtendedProfileAdvertsNextPageResult>> getNextPage(@Url @NotNull String str);

    @GET("1/user/{userKey}/extended-profile/phone")
    @NotNull
    Observable<TypedResult<ExtendedProfilePhoneResponse>> getPhoneAction(@Path("userKey") @NotNull String str, @Nullable @Query("context") String str2);
}
