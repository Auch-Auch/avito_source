package com.avito.android.autoteka.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.AutotekaItemResponse;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/autoteka/remote/AutotekaApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/AutotekaItemResponse;", "getAutotekaItem", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "getAutotekaTeaser", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaApi {
    @GET("2/autoteka/item/{itemId}")
    @NotNull
    Observable<TypedResult<AutotekaItemResponse>> getAutotekaItem(@Path("itemId") @NotNull String str);

    @GET("1/swaha/v1/autoteka/teaser/{itemId}?platform=android")
    @NotNull
    @NetworkRequestEventId(eventId = 3843)
    Observable<AutotekaTeaserResponse> getAutotekaTeaser(@Path("itemId") @NotNull String str);
}
