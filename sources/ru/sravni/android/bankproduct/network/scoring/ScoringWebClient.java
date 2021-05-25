package ru.sravni.android.bankproduct.network.scoring;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.scoring.IScoringWebClient;
import ru.sravni.android.bankproduct.repository.scoring.entity.ScoringInfoRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/network/scoring/ScoringWebClient;", "Lru/sravni/android/bankproduct/repository/scoring/IScoringWebClient;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "getScoring", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/network/scoring/IScoringApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/scoring/IScoringApi;", "scoringApi", "<init>", "(Lru/sravni/android/bankproduct/network/scoring/IScoringApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringWebClient implements IScoringWebClient {
    public final IScoringApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<ScoringInfoRepo>> {
        public final /* synthetic */ ScoringWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ScoringWebClient scoringWebClient) {
            super(1);
            this.a = scoringWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ScoringInfoRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getScoring(tokenData2.getAccess_token()).map(a7.c.a.a.n.g.a.a);
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends ScoringInfoRepo>> {
        public final /* synthetic */ ScoringWebClient a;

        public b(ScoringWebClient scoringWebClient) {
            this.a = scoringWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ScoringInfoRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.b.wrap(th2));
        }
    }

    public ScoringWebClient(@NotNull IScoringApi iScoringApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iScoringApi, "scoringApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iScoringApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.scoring.IScoringWebClient
    @NotNull
    public Observable<ScoringInfoRepo> getScoring() {
        Observable<ScoringInfoRepo> onErrorResumeNext = this.c.wrapWithTokenRefresh(new a(this)).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.wrapWithT…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }
}
