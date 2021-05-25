package com.avito.android.remote;

import com.avito.android.remote.model.StartSupportChatResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/SupportApi;", "", "", "problemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/StartSupportChatResponse;", "startSupportChat", "(I)Lio/reactivex/rxjava3/core/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SupportApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/supportChat/start")
    Observable<StartSupportChatResponse> startSupportChat(@Field("problemId") int i);
}
