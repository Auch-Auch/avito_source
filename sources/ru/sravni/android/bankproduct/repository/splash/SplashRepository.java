package ru.sravni.android.bankproduct.repository.splash;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.splash.ISplashRepository;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/repository/splash/SplashRepository;", "Lru/sravni/android/bankproduct/domain/splash/ISplashRepository;", "", "newCount", "", "setShowCount", "(I)V", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/repository/splash/ISplashScreenInfoStorage;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/splash/ISplashScreenInfoStorage;", "splashScreenInfoStorage", "Lio/reactivex/Observable;", "getShownCount", "()Lio/reactivex/Observable;", "shownCount", "<init>", "(Lru/sravni/android/bankproduct/repository/splash/ISplashScreenInfoStorage;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SplashRepository implements ISplashRepository {
    public final ISplashScreenInfoStorage a;
    public final IErrorLogger b;
    public final IThrowableWrapper c;

    public SplashRepository(@NotNull ISplashScreenInfoStorage iSplashScreenInfoStorage, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iSplashScreenInfoStorage, "splashScreenInfoStorage");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.a = iSplashScreenInfoStorage;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.splash.ISplashRepository
    @NotNull
    public Observable<Integer> getShownCount() {
        try {
            Observable<Integer> just = Observable.just(Integer.valueOf(this.a.getWelcomeScreenShowCount()));
            Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(count)");
            return just;
        } catch (Throwable th) {
            Observable<Integer> error = Observable.error(th);
            Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(err)");
            return error;
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.splash.ISplashRepository
    public void setShowCount(int i) {
        try {
            this.a.setWelcomeScreenShowCount(i);
        } catch (Throwable th) {
            this.b.logError(MessagePriority.ERROR, this.c.wrap(th));
        }
    }
}
