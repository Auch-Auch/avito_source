package com.avito.android.calls.remote;

import com.avito.android.remote.CallClientCredentialsResult;
import com.avito.android.remote.CallContactsResult;
import com.avito.android.remote.CallInfo;
import com.avito.android.remote.OneTimeLoginKeyResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Deprecated;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004H'¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00102\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0013JC\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00102\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0013J9\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0002H'¢\u0006\u0004\b\u001f\u0010\bJ/\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010!\u001a\u00020 2\b\b\u0001\u0010\"\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0010H'¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0010H'¢\u0006\u0004\b'\u0010&J\u001b\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H'¢\u0006\u0004\b(\u0010\u000bJ\u001b\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H'¢\u0006\u0004\b)\u0010\u000b¨\u0006*"}, d2 = {"Lcom/avito/android/calls/remote/CallsApi;", "", "", "key", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/OneTimeLoginKeyResult;", "calculateOneTimeLoginKey", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/CallClientCredentialsResult;", "getCallClientCredentials", "()Lio/reactivex/rxjava3/core/Single;", "itemId", "categoryId", "networkType", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/CallContactsResult;", "getCallContactsOld", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getCallContacts", "prevCallId", "nextCallId", "getCallContactsByPreviousCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "recipientLogin", "callId", "callerLogin", "requestStartCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/CallInfo;", "getCallInfo", "Lokhttp3/MultipartBody$Part;", "uploadId", "file", "uploadLogs", "(Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;)Lio/reactivex/rxjava3/core/Single;", "onRegisterPushToken", "()Lio/reactivex/rxjava3/core/Observable;", "onUnregisterPushToken", "meAvailable", "meUnavailable", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallsApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/ip-calls/calcToken")
    Single<TypedResult<OneTimeLoginKeyResult>> calculateOneTimeLoginKey(@Field("oneTimeKey") @NotNull String str);

    @GET("1/ip-calls/me")
    @NotNull
    Single<TypedResult<CallClientCredentialsResult>> getCallClientCredentials();

    @NotNull
    @FormUrlEncoded
    @POST("4/ip-calls/canCallByItem")
    Observable<TypedResult<CallContactsResult>> getCallContacts(@Field("itemID") @NotNull String str, @Field("itemCategory") @NotNull String str2, @Field("networkType") @NotNull String str3, @Field("source") @NotNull String str4);

    @NotNull
    @FormUrlEncoded
    @POST("3/ip-calls/recallByCallUUID")
    Single<TypedResult<CallContactsResult>> getCallContactsByPreviousCall(@Field("callUUID") @NotNull String str, @Field("nextCallUUID") @NotNull String str2, @Field("networkType") @NotNull String str3);

    @NotNull
    @Deprecated(message = "Use v4 instead")
    @FormUrlEncoded
    @POST("3/ip-calls/canCallByItem")
    Observable<TypedResult<CallContactsResult>> getCallContactsOld(@Field("itemID") @NotNull String str, @Field("itemCategory") @NotNull String str2, @Field("networkType") @NotNull String str3, @Field("source") @NotNull String str4);

    @GET("1/ip-calls/calls/get")
    @NotNull
    Single<TypedResult<CallInfo>> getCallInfo(@NotNull @Query("callUUID") String str);

    @POST("1/ip-calls/me/available")
    @NotNull
    Single<TypedResult<Object>> meAvailable();

    @POST("1/ip-calls/me/unavailable")
    @NotNull
    Single<TypedResult<Object>> meUnavailable();

    @NotNull
    @Deprecated(message = "Use meAvailable")
    @POST("3/ip-calls/regPushToken")
    Observable<TypedResult<Object>> onRegisterPushToken();

    @NotNull
    @Deprecated(message = "Use meUnavailable")
    @POST("2/ip-calls/unregPushToken")
    Observable<TypedResult<Object>> onUnregisterPushToken();

    @NotNull
    @FormUrlEncoded
    @POST("1/ip-calls/calls")
    Single<TypedResult<Object>> requestStartCall(@Field("recipientLogin") @NotNull String str, @Field("callUUID") @NotNull String str2, @Field("itemID") @NotNull String str3, @Field("callerLogin") @Nullable String str4);

    @NotNull
    @POST("1/ip-calls/uploadLog")
    @Multipart
    Single<TypedResult<Object>> uploadLogs(@NotNull @Part MultipartBody.Part part, @NotNull @Part MultipartBody.Part part2);
}
