package com.avito.android.remote;

import com.avito.android.remote.model.PhoneResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/AsyncPhoneApi;", "", "", "itemId", "context", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/PhoneResponse;", "getPhoneAction", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "async-phone_release"}, k = 1, mv = {1, 4, 2})
public interface AsyncPhoneApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getPhoneAction$default(AsyncPhoneApi asyncPhoneApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return asyncPhoneApi.getPhoneAction(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPhoneAction");
        }
    }

    @GET("1/items/{itemId}/phone")
    @NotNull
    @NetworkRequestEventId(eventId = 3677)
    Observable<TypedResult<PhoneResponse>> getPhoneAction(@Path("itemId") @NotNull String str, @Nullable @Query("context") String str2);
}
