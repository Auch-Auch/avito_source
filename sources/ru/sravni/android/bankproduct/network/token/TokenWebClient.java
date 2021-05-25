package ru.sravni.android.bankproduct.network.token;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.token.request.AuthorizationRefreshRequest;
import ru.sravni.android.bankproduct.network.token.response.AuthorizationRefreshResponse;
import ru.sravni.android.bankproduct.network.token.response.AuthorizationRefreshResponseKt;
import ru.sravni.android.bankproduct.repository.token.ITokenWebClient;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/network/token/TokenWebClient;", "Lru/sravni/android/bankproduct/repository/token/ITokenWebClient;", "", "refreshToken", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/network/token/ITokenApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/token/ITokenApi;", "authApi", "<init>", "(Lru/sravni/android/bankproduct/network/token/ITokenApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenWebClient implements ITokenWebClient {
    public final ITokenApi a;
    public final IThrowableWrapper b;

    public static final class a<T, R> implements Function<T, R> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            AuthorizationRefreshResponse authorizationRefreshResponse = (AuthorizationRefreshResponse) obj;
            Intrinsics.checkParameterIsNotNull(authorizationRefreshResponse, "it");
            return AuthorizationRefreshResponseKt.toConvertTokenData(authorizationRefreshResponse);
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends TokenData>> {
        public final /* synthetic */ TokenWebClient a;

        public b(TokenWebClient tokenWebClient) {
            this.a = tokenWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TokenData> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public TokenWebClient(@NotNull ITokenApi iTokenApi, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iTokenApi, "authApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.a = iTokenApi;
        this.b = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenWebClient
    @NotNull
    public Observable<TokenData> refreshToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "refreshToken");
        Observable<R> onErrorResumeNext = this.a.refresh(new AuthorizationRefreshRequest(str)).map(a.a).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "authApi.refresh(Authoriz…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }
}
