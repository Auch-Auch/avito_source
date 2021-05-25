package ru.sravni.android.bankproduct.domain.token;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R*\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/domain/token/TokenInteractor;", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "", "clearToken", "()V", "restoreTokenData", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "getTokenStatusChannel", "()Lio/reactivex/subjects/PublishSubject;", "tokenStatusChannel", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "subscriptionTokenStatus", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "c", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "tokenRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/token/ITokenRepository;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenInteractor implements ITokenInteractor {
    @NotNull
    public final PublishSubject<HttpResponseStatus> a;
    public Disposable b;
    public final ITokenRepository c;
    public final IErrorLogger d;
    public final IThrowableWrapper e;

    public static final class a<T> implements Consumer<HttpResponseStatus> {
        public final /* synthetic */ TokenInteractor a;

        public a(TokenInteractor tokenInteractor) {
            this.a = tokenInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(HttpResponseStatus httpResponseStatus) {
            this.a.getTokenStatusChannel().onNext(httpResponseStatus);
        }
    }

    public TokenInteractor(@NotNull ITokenRepository iTokenRepository, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iTokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.c = iTokenRepository;
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
        PublishSubject<HttpResponseStatus> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<HttpResponseStatus>()");
        this.a = create;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = iTokenRepository.getTokenStatusChannel().subscribe(new a(this));
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenInteractor
    public void clearToken() {
        this.c.clear();
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenInteractor
    public void restoreTokenData() {
        this.c.restoreTokenData();
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenInteractor
    @NotNull
    public PublishSubject<HttpResponseStatus> getTokenStatusChannel() {
        return this.a;
    }
}
