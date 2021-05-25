package ru.sravni.android.bankproduct.utils.mock;

import a2.b.a.a.a;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;
import retrofit2.Response;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "httpResponseStatus", "Lretrofit2/HttpException;", "createHttpException", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)Lretrofit2/HttpException;", "T", "Lio/reactivex/Observable;", "requestObservable", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "tokenData", "getAccessedData", "(Lio/reactivex/Observable;Lru/sravni/android/bankproduct/domain/token/entity/TokenData;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class TokenMockUtilKt {
    @NotNull
    public static final HttpException createHttpException(@NotNull HttpResponseStatus httpResponseStatus) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "httpResponseStatus");
        return new HttpException(Response.error(httpResponseStatus.getCode(), ResponseBody.Companion.create("{}", MediaType.Companion.parse("text"))));
    }

    @NotNull
    public static final <T> Observable<T> getAccessedData(@NotNull Observable<T> observable, @NotNull TokenData tokenData) {
        Intrinsics.checkParameterIsNotNull(observable, "requestObservable");
        Intrinsics.checkParameterIsNotNull(tokenData, "tokenData");
        TokenStatus tokenStatus = (TokenStatus) a.i2(tokenData.getAccess_token(), TokenStatus.class);
        if (tokenStatus != null) {
            if (tokenStatus.getResponseStatus() != HttpResponseStatus.SUCCESS) {
                observable = Observable.error(createHttpException(tokenStatus.getResponseStatus()));
                Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.error(\n      …s\n            )\n        )");
            }
            if (observable != null) {
                return observable;
            }
        }
        throw new Exception("Unexpected Error");
    }
}
