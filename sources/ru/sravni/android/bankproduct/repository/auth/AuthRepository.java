package ru.sravni.android.bankproduct.repository.auth;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.auth.IAuthRepository;
import ru.sravni.android.bankproduct.domain.auth.entity.RegisterInfo;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.auth.entity.RegisterInfoRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/repository/auth/AuthRepository;", "Lru/sravni/android/bankproduct/domain/auth/IAuthRepository;", "", "phone", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/auth/entity/RegisterInfo;", "registerUser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "smsCode", "", "sendSmsCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "tokenRepository", "Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;", "webClient", "<init>", "(Lru/sravni/android/bankproduct/domain/token/ITokenRepository;Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthRepository implements IAuthRepository {
    public final ITokenRepository a;
    public final IAuthWebClient b;
    public final IThrowableWrapper c;

    public static final class a<T, R> implements Function<T, R> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((RegisterInfoRepo) obj, "it");
            return new RegisterInfo();
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends RegisterInfo>> {
        public final /* synthetic */ AuthRepository a;

        public b(AuthRepository authRepository) {
            this.a = authRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends RegisterInfo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.c.wrap(th2));
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public final /* synthetic */ AuthRepository a;

        public c(AuthRepository authRepository) {
            this.a = authRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            TokenData tokenData = (TokenData) obj;
            Intrinsics.checkParameterIsNotNull(tokenData, "tokenData");
            this.a.a.setTokenData(tokenData);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T, R> implements Function<Throwable, ObservableSource<? extends Unit>> {
        public final /* synthetic */ AuthRepository a;

        public d(AuthRepository authRepository) {
            this.a = authRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.c.wrap(th2));
        }
    }

    public AuthRepository(@NotNull ITokenRepository iTokenRepository, @NotNull IAuthWebClient iAuthWebClient, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iTokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(iAuthWebClient, "webClient");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.a = iTokenRepository;
        this.b = iAuthWebClient;
        this.c = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthRepository
    @NotNull
    public Observable<RegisterInfo> registerUser(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Observable<R> onErrorResumeNext = this.b.registerUser(str).map(a.a).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.registerUser(p…error).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthRepository
    @NotNull
    public Observable<Unit> sendSmsCode(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        Intrinsics.checkParameterIsNotNull(str2, "smsCode");
        Observable<R> onErrorResumeNext = this.b.sendSmsCode(str, str2).map(new c(this)).onErrorResumeNext(new d(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.sendSmsCode(ph…bservable()\n            }");
        return onErrorResumeNext;
    }
}
