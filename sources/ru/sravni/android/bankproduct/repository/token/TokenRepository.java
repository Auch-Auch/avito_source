package ru.sravni.android.bankproduct.repository.token;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010,\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010(\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u000fR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lru/sravni/android/bankproduct/repository/token/TokenRepository;", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "", "refresh", "()V", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "tokenData", "setTokenData", "(Lru/sravni/android/bankproduct/domain/token/entity/TokenData;)V", "getTokenData", "()Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "clear", "restoreTokenData", "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", "f", "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", "tokenDataStorageInMemory", "", "d", "I", "tokenExpireMinutes", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "i", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "h", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "refreshSubscription", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "getTokenStatusChannel", "()Lio/reactivex/subjects/PublishSubject;", "tokenStatusChannel", AuthSource.BOOKING_ORDER, "tokenSubscription", "e", "tokenDataSharedPreferenceStorage", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", g.a, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "<init>", "(Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenRepository implements ITokenRepository {
    @NotNull
    public final PublishSubject<HttpResponseStatus> a;
    public Disposable b;
    public Disposable c;
    public final int d;
    public final ITokenDataStorage e;
    public final ITokenDataStorage f;
    public final IErrorLogger g;
    public final IThrowableWrapper h;
    public final ITokenRefresher i;

    public static final class a<T> implements Consumer<DataContainer<? extends TokenData>> {
        public final /* synthetic */ TokenRepository a;

        public a(TokenRepository tokenRepository) {
            this.a = tokenRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends TokenData> dataContainer) {
            DataContainer<? extends TokenData> dataContainer2 = dataContainer;
            if (dataContainer2.getValue() != null) {
                this.a.setTokenData((TokenData) dataContainer2.getValue());
            } else if (dataContainer2.getError() != null) {
                this.a.getTokenStatusChannel().onNext(HttpResponseStatus.Companion.fromCode(dataContainer2.getError().getErrDescription().getCode()));
                this.a.g.logError(MessagePriority.ERROR, this.a.h.wrap(dataContainer2.getError()));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ TokenRepository a;

        public b(TokenRepository tokenRepository) {
            this.a = tokenRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.g.logError(MessagePriority.ERROR, this.a.h.wrap(th));
        }
    }

    public static final class c<T> implements Consumer<DataContainer<? extends TokenData>> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends TokenData> dataContainer) {
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ TokenRepository a;

        public d(TokenRepository tokenRepository) {
            this.a = tokenRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.g.logError(MessagePriority.ERROR, this.a.h.wrap(th));
        }
    }

    public TokenRepository(@NotNull ITokenDataStorage iTokenDataStorage, @NotNull ITokenDataStorage iTokenDataStorage2, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iTokenDataStorage, "tokenDataSharedPreferenceStorage");
        Intrinsics.checkParameterIsNotNull(iTokenDataStorage2, "tokenDataStorageInMemory");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.e = iTokenDataStorage;
        this.f = iTokenDataStorage2;
        this.g = iErrorLogger;
        this.h = iThrowableWrapper;
        this.i = iTokenRefresher;
        PublishSubject<HttpResponseStatus> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<HttpResponseStatus>()");
        this.a = create;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = iTokenRefresher.getTokenRefreshChannel().subscribe(new a(this), new b(this));
        this.d = 25;
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenRepository
    public void clear() {
        this.f.clear();
        this.e.clear();
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenDataGetter
    @Nullable
    public TokenData getTokenData() {
        return this.f.getTokenData();
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenRepository
    public void refresh() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.i.refresh().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(c.a, new d(this));
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenRepository
    public void restoreTokenData() {
        try {
            TokenData tokenData = this.e.getTokenData();
            this.f.clear();
            if (tokenData != null) {
                this.f.setTokenData(tokenData);
            }
            getTokenStatusChannel().onNext(HttpResponseStatus.SUCCESS);
            if (tokenData != null && TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - tokenData.getSaveTime()) > ((long) this.d)) {
                refresh();
            }
        } catch (Throwable th) {
            clear();
            this.g.logError(MessagePriority.ERROR, this.h.wrap(th));
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenRepository
    public void setTokenData(@NotNull TokenData tokenData) {
        Intrinsics.checkParameterIsNotNull(tokenData, "tokenData");
        getTokenStatusChannel().onNext(HttpResponseStatus.SUCCESS);
        this.f.setTokenData(tokenData);
        try {
            this.e.setTokenData(tokenData);
        } catch (Throwable th) {
            this.g.logError(MessagePriority.ERROR, this.h.wrap(th));
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenRepository
    @NotNull
    public PublishSubject<HttpResponseStatus> getTokenStatusChannel() {
        return this.a;
    }
}
