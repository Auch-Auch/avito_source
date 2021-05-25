package ru.sravni.android.bankproduct.repository.token;

import a2.g.r.g;
import a7.c.a.a.p.b.d;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenDataGetter;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b.\u0010/J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JR\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072'\u0010\f\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072'\u0010\u0010\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR6\u0010#\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u001e*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00030\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002XD¢\u0006\u0006\n\u0004\b$\u0010\u0015R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lru/sravni/android/bankproduct/repository/token/TokenRefresher;", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "refresh", "()Lio/reactivex/Observable;", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tokenData", "authRequest", "unAuthRequest", "sendAuthorizedOrUnauthorizedQuery", "(Lkotlin/jvm/functions/Function1;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "baseRequest", "wrapWithTokenRefresh", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "", AuthSource.SEND_ABUSE, "I", "REFRESHING", "c", "refreshState", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "throwableWrapper", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "d", "Lio/reactivex/subjects/PublishSubject;", "getTokenRefreshChannel", "()Lio/reactivex/subjects/PublishSubject;", "tokenRefreshChannel", AuthSource.BOOKING_ORDER, "NOT_REFRESHING", "Lru/sravni/android/bankproduct/domain/token/ITokenDataGetter;", "f", "Lru/sravni/android/bankproduct/domain/token/ITokenDataGetter;", "tokenGetter", "Lru/sravni/android/bankproduct/repository/token/ITokenWebClient;", "e", "Lru/sravni/android/bankproduct/repository/token/ITokenWebClient;", "tokenApi", "<init>", "(Lru/sravni/android/bankproduct/repository/token/ITokenWebClient;Lru/sravni/android/bankproduct/domain/token/ITokenDataGetter;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenRefresher implements ITokenRefresher {
    public final int a = 1;
    public final int b = 2;
    public int c = 2;
    @NotNull
    public final PublishSubject<DataContainer<TokenData>> d;
    public final ITokenWebClient e;
    public final ITokenDataGetter f;
    public final IThrowableWrapper g;

    public static final class a<T> implements Consumer<DataContainer<? extends TokenData>> {
        public final /* synthetic */ TokenRefresher a;

        public a(TokenRefresher tokenRefresher) {
            this.a = tokenRefresher;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends TokenData> dataContainer) {
            TokenRefresher tokenRefresher = this.a;
            tokenRefresher.c = tokenRefresher.b;
            this.a.getTokenRefreshChannel().onNext(dataContainer);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ TokenRefresher a;

        public b(TokenRefresher tokenRefresher) {
            this.a = tokenRefresher;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            TokenRefresher tokenRefresher = this.a;
            tokenRefresher.c = tokenRefresher.b;
            this.a.getTokenRefreshChannel().onNext(new DataContainer<>(null, this.a.g.wrap(th)));
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ TokenRefresher a;

        public c(TokenRefresher tokenRefresher) {
            this.a = tokenRefresher;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            TokenRefresher tokenRefresher = this.a;
            tokenRefresher.c = tokenRefresher.b;
        }
    }

    public TokenRefresher(@NotNull ITokenWebClient iTokenWebClient, @NotNull ITokenDataGetter iTokenDataGetter, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iTokenWebClient, "tokenApi");
        Intrinsics.checkParameterIsNotNull(iTokenDataGetter, "tokenGetter");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "throwableWrapper");
        this.e = iTokenWebClient;
        this.f = iTokenDataGetter;
        this.g = iThrowableWrapper;
        PublishSubject<DataContainer<TokenData>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<DataContainer<TokenData>>()");
        this.d = create;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenRefresher
    @NotNull
    public Observable<DataContainer<TokenData>> refresh() {
        Observable<R> observable;
        int i = this.c;
        int i2 = this.a;
        if (i == i2) {
            return getTokenRefreshChannel();
        }
        this.c = i2;
        TokenData tokenData = this.f.getTokenData();
        if (tokenData != null) {
            observable = this.e.refreshToken(tokenData.getRefresh_token()).map(a7.c.a.a.p.b.c.a).onErrorResumeNext(new d(this));
            Intrinsics.checkExpressionValueIsNotNull(observable, "tokenApi.refreshToken(to…      )\n                }");
        } else {
            observable = Observable.just(new DataContainer(null, this.g.wrap(new NullTokenWhenTryRefreshTokenException())));
            Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.just(\n       …ception()))\n            )");
        }
        Observable<DataContainer<TokenData>> doOnDispose = observable.doOnNext(new a(this)).doOnError(new b(this)).doOnDispose(new c(this));
        Intrinsics.checkExpressionValueIsNotNull(doOnDispose, "getRefreshTokenObservabl…RESHING\n                }");
        return doOnDispose;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenRefresher
    @NotNull
    public <T> Observable<T> sendAuthorizedOrUnauthorizedQuery(@NotNull Function1<? super TokenData, ? extends Observable<T>> function1, @NotNull Observable<T> observable) {
        Intrinsics.checkParameterIsNotNull(function1, "authRequest");
        Intrinsics.checkParameterIsNotNull(observable, "unAuthRequest");
        return this.f.getTokenData() != null ? wrapWithTokenRefresh(function1) : observable;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenRefresher
    @NotNull
    public <T> Observable<T> wrapWithTokenRefresh(@NotNull Function1<? super TokenData, ? extends Observable<T>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "baseRequest");
        TokenData tokenData = this.f.getTokenData();
        if (tokenData != null) {
            Observable<T> onErrorResumeNext = ((Observable) function1.invoke(tokenData)).onErrorResumeNext(new a7.c.a.a.p.b.b(this, function1));
            Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "baseRequest(tokenData).o…)\n            }\n        }");
            return onErrorResumeNext;
        }
        Observable<T> error = Observable.error(this.g.wrap(new NullTokenWhenTryAuthedRequestException()));
        Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(throwab…uthedRequestException()))");
        return error;
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenRefresher
    @NotNull
    public PublishSubject<DataContainer<TokenData>> getTokenRefreshChannel() {
        return this.d;
    }
}
