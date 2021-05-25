package ru.sravni.android.bankproduct.mock.auth;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import retrofit2.Response;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.entity.AccessToken;
import ru.sravni.android.bankproduct.mock.auth.entity.RefreshToken;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/mock/auth/AuthService;", "Lru/sravni/android/bankproduct/mock/auth/IAuthService;", "Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;", SDKConstants.PARAM_ACCESS_TOKEN, "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "grantToken", "(Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)Lio/reactivex/Observable;", "T", "requestObservable", "", "getAccessedData", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "refreshTokenString", "refreshToken", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "httpResponseStatus", "Lretrofit2/HttpException;", "createHttpException", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)Lretrofit2/HttpException;", AuthSource.SEND_ABUSE, "(Lru/sravni/android/bankproduct/mock/auth/entity/AccessToken;)Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "", "J", "delay", "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", "tokenDataStorageInMemory", "<init>", "(JLru/sravni/android/bankproduct/repository/token/ITokenDataStorage;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthService implements IAuthService {
    public final long a;
    public final ITokenDataStorage b;

    public AuthService(long j, @NotNull ITokenDataStorage iTokenDataStorage) {
        Intrinsics.checkParameterIsNotNull(iTokenDataStorage, "tokenDataStorageInMemory");
        this.a = j;
        this.b = iTokenDataStorage;
    }

    public final TokenData a(AccessToken accessToken) {
        String sravniJson = UtilFunctionsKt.toSravniJson(accessToken);
        Intrinsics.checkExpressionValueIsNotNull(sravniJson, "accessToken.toSravniJson()");
        String sravniJson2 = UtilFunctionsKt.toSravniJson(accessToken.getRefreshToken());
        Intrinsics.checkExpressionValueIsNotNull(sravniJson2, "accessToken.refreshToken.toSravniJson()");
        return new TokenData(sravniJson2, sravniJson, accessToken.getExpiresAt(), 0, 8, null);
    }

    @NotNull
    public final HttpException createHttpException(@NotNull HttpResponseStatus httpResponseStatus) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "httpResponseStatus");
        return new HttpException(Response.error(httpResponseStatus.getCode(), ResponseBody.Companion.create("{}", MediaType.Companion.parse("text"))));
    }

    @Override // ru.sravni.android.bankproduct.mock.auth.IAuthAccessData
    @NotNull
    public <T> Observable<T> getAccessedData(@NotNull Observable<T> observable, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(observable, "requestObservable");
        Intrinsics.checkParameterIsNotNull(str, SDKConstants.PARAM_ACCESS_TOKEN);
        try {
            Object fromJson = new Gson().fromJson(str, (Class<Object>) AccessToken.class);
            if (fromJson == null) {
                Intrinsics.throwNpe();
            }
            AccessToken accessToken = (AccessToken) fromJson;
            TokenData a3 = a(accessToken);
            if (!Intrinsics.areEqual(a3, this.b.getTokenData())) {
                this.b.setTokenData(a3);
            }
            HttpResponseStatus tokenStatus = accessToken.getTokenStatus();
            if (tokenStatus == HttpResponseStatus.SUCCESS) {
                return observable;
            }
            Observable<T> error = Observable.error(createHttpException(tokenStatus));
            Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(\n      …          )\n            )");
            return error;
        } catch (Throwable unused) {
            Observable<T> error2 = Observable.error(createHttpException(HttpResponseStatus.UNAUTHORIZED_404));
            Intrinsics.checkExpressionValueIsNotNull(error2, "Observable.error(\n      …ORIZED_404)\n            )");
            return error2;
        }
    }

    @Override // ru.sravni.android.bankproduct.mock.auth.IAuthGrantToken
    @NotNull
    public Observable<TokenData> grantToken(@Nullable AccessToken accessToken) {
        Observable<TokenData> delay = accessToken != null ? Observable.just(a(accessToken)).delay(this.a, TimeUnit.SECONDS) : null;
        if (delay != null) {
            return delay;
        }
        Observable<TokenData> error = Observable.error(new Throwable("Mock Access Token is unpredictable null"));
        Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(Throwab… is unpredictable null\"))");
        return error;
    }

    @Override // ru.sravni.android.bankproduct.mock.auth.IAuthRefreshToken
    @NotNull
    public Observable<TokenData> refreshToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "refreshTokenString");
        RefreshToken refreshToken = (RefreshToken) new Gson().fromJson(str, (Class<Object>) RefreshToken.class);
        if (refreshToken != null) {
            HttpResponseStatus responseStatus = refreshToken.getResponseStatus();
            Observable<TokenData> grantToken = grantToken(refreshToken.getNextAccessToken());
            if (responseStatus != HttpResponseStatus.SUCCESS) {
                grantToken = Observable.error(createHttpException(responseStatus));
                Intrinsics.checkExpressionValueIsNotNull(grantToken, "Observable.error(\n      …          )\n            )");
            }
            if (grantToken != null) {
                return grantToken;
            }
        }
        throw new Throwable("Unexpected error");
    }
}
