package ru.sravni.android.bankproduct.network.token;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.sravni.android.bankproduct.network.token.request.AuthorizationRefreshRequest;
import ru.sravni.android.bankproduct.network.token.response.AuthorizationRefreshResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/network/token/ITokenApi;", "", "Lru/sravni/android/bankproduct/network/token/request/AuthorizationRefreshRequest;", "refreshRequest", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/token/response/AuthorizationRefreshResponse;", "refresh", "(Lru/sravni/android/bankproduct/network/token/request/AuthorizationRefreshRequest;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ITokenApi {
    @POST("v1/auth/refresh")
    @NotNull
    Observable<AuthorizationRefreshResponse> refresh(@Body @NotNull AuthorizationRefreshRequest authorizationRefreshRequest);
}
