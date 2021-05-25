package com.avito.android.remote;

import com.avito.android.remote.model.CallFeedbackResult;
import com.avito.android.remote.model.CallFeedbackShow;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/CallFeedbackApi;", "", "", "callId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/CallFeedbackShow;", "getItems", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "itemId", "Lcom/avito/android/remote/model/CallFeedbackResult;", "setItem", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackApi {
    @GET("1/call/feedback/{callId}/show")
    @NotNull
    Observable<TypedResult<CallFeedbackShow>> getItems(@Path("callId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/call/feedback/{callId}/result")
    Observable<TypedResult<CallFeedbackResult>> setItem(@Path("callId") @NotNull String str, @Field("id") @NotNull String str2);
}
