package ru.sravni.android.bankproduct.domain.splash;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/domain/splash/SplashInteractor;", "Lru/sravni/android/bankproduct/domain/splash/ISplashInteractor;", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "tokenRepository", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "c", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/splash/ISplashRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/splash/ISplashRepository;", "splashRepository", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/splash/AfterSplashScreen;", "getNextScreenShow", "()Lio/reactivex/Observable;", "nextScreenShow", "", "delayInSeconds", "<init>", "(JLru/sravni/android/bankproduct/domain/splash/ISplashRepository;Lru/sravni/android/bankproduct/domain/token/ITokenRepository;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SplashInteractor implements ISplashInteractor {
    public final ISplashRepository a;
    public final ITokenRepository b;
    public final IErrorLogger c;
    public final IThrowableWrapper d;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ SplashInteractor a;

        public a(SplashInteractor splashInteractor) {
            this.a = splashInteractor;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return SplashInteractor.access$getAfterScreen(this.a);
        }
    }

    public static final class b<T, R> implements Function<Throwable, AfterSplashScreen> {
        public final /* synthetic */ SplashInteractor a;

        public b(SplashInteractor splashInteractor) {
            this.a = splashInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public AfterSplashScreen apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return SplashInteractor.access$errorAction(this.a, th2);
        }
    }

    public SplashInteractor(long j, @NotNull ISplashRepository iSplashRepository, @NotNull ITokenRepository iTokenRepository, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iSplashRepository, "splashRepository");
        Intrinsics.checkParameterIsNotNull(iTokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.a = iSplashRepository;
        this.b = iTokenRepository;
        this.c = iErrorLogger;
        this.d = iThrowableWrapper;
    }

    public static final AfterSplashScreen access$errorAction(SplashInteractor splashInteractor, Throwable th) {
        splashInteractor.c.logError(MessagePriority.ERROR, splashInteractor.d.wrap(th));
        return AfterSplashScreen.DASHBOARD;
    }

    public static final AfterSplashScreen access$getAfterScreen(SplashInteractor splashInteractor) {
        if (splashInteractor.b.getTokenData() != null) {
            return AfterSplashScreen.DASHBOARD;
        }
        return AfterSplashScreen.AUTH;
    }

    @Override // ru.sravni.android.bankproduct.domain.splash.ISplashInteractor
    @NotNull
    public Observable<AfterSplashScreen> getNextScreenShow() {
        this.b.restoreTokenData();
        Observable<AfterSplashScreen> onErrorReturn = Observable.just(Unit.INSTANCE).map(new a(this)).onErrorReturn(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorReturn, "Observable.just(Unit)\n  …eturn { errorAction(it) }");
        return onErrorReturn;
    }
}
