package ru.sravni.android.bankproduct.network.auth;

import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.sravni.android.bankproduct.network.auth.request.AuthorizationCodeRequest;
import ru.sravni.android.bankproduct.network.auth.request.AuthorizationCreateRequest;
import ru.sravni.android.bankproduct.network.auth.response.TokenInfoResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/network/auth/IAuthApi;", "", "Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCreateRequest;", "registerInfo", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "registerUser", "(Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCreateRequest;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCodeRequest;", "Lru/sravni/android/bankproduct/network/auth/response/TokenInfoResponse;", "sendSmsCode", "(Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCodeRequest;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IAuthApi {
    @POST("v1/auth")
    @NotNull
    Observable<ResponseBody> registerUser(@Body @NotNull AuthorizationCreateRequest authorizationCreateRequest);

    @POST("v1/auth/code")
    @NotNull
    Observable<TokenInfoResponse> sendSmsCode(@Body @NotNull AuthorizationCodeRequest authorizationCodeRequest);
}
