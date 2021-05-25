package ru.sravni.android.bankproduct.network.auth;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.auth.request.AuthorizationCodeRequest;
import ru.sravni.android.bankproduct.network.auth.request.AuthorizationCreateRequest;
import ru.sravni.android.bankproduct.network.auth.response.TokenInfoResponse;
import ru.sravni.android.bankproduct.network.auth.response.TokenInfoResponseKt;
import ru.sravni.android.bankproduct.repository.auth.IAuthWebClient;
import ru.sravni.android.bankproduct.repository.auth.entity.RegisterInfoRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/network/auth/AuthWebClient;", "Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;", "", "phone", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/auth/entity/RegisterInfoRepo;", "registerUser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "smsCode", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "sendSmsCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/network/auth/IAuthApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/auth/IAuthApi;", "authApi", "<init>", "(Lru/sravni/android/bankproduct/network/auth/IAuthApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthWebClient implements IAuthWebClient {
    public final IAuthApi a;
    public final IThrowableWrapper b;

    public static final class a<T, R> implements Function<T, R> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((ResponseBody) obj, "it");
            return new RegisterInfoRepo();
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends RegisterInfoRepo>> {
        public final /* synthetic */ AuthWebClient a;

        public b(AuthWebClient authWebClient) {
            this.a = authWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends RegisterInfoRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            TokenInfoResponse tokenInfoResponse = (TokenInfoResponse) obj;
            Intrinsics.checkParameterIsNotNull(tokenInfoResponse, "tokenInfoResponse");
            return TokenInfoResponseKt.toConvertTokenData(tokenInfoResponse);
        }
    }

    public static final class d<T, R> implements Function<Throwable, ObservableSource<? extends TokenData>> {
        public final /* synthetic */ AuthWebClient a;

        public d(AuthWebClient authWebClient) {
            this.a = authWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TokenData> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public AuthWebClient(@NotNull IAuthApi iAuthApi, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iAuthApi, "authApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.a = iAuthApi;
        this.b = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.repository.auth.IAuthWebClient
    @NotNull
    public Observable<RegisterInfoRepo> registerUser(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Observable<R> onErrorResumeNext = this.a.registerUser(new AuthorizationCreateRequest(str)).map(a.a).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "authApi.registerUser(Aut…error).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.auth.IAuthWebClient
    @NotNull
    public Observable<TokenData> sendSmsCode(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Intrinsics.checkParameterIsNotNull(str2, "smsCode");
        Observable<R> onErrorResumeNext = this.a.sendSmsCode(new AuthorizationCodeRequest(str, str2)).map(c.a).onErrorResumeNext(new d(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "authApi.sendSmsCode(Auth…error).typeObservable() }");
        return onErrorResumeNext;
    }
}
