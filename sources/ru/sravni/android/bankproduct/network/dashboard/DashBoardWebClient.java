package ru.sravni.android.bankproduct.network.dashboard;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.OfferCalculationElementRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/DashBoardWebClient;", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;", "Lio/reactivex/Observable;", "", "Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "getOfferCalculatedList", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "getChatProgress", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/network/dashboard/IDashBoardApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/dashboard/IDashBoardApi;", "getDashBoardApi", "()Lru/sravni/android/bankproduct/network/dashboard/IDashBoardApi;", "dashBoardApi", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "<init>", "(Lru/sravni/android/bankproduct/network/dashboard/IDashBoardApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardWebClient implements IDashBoardWebClient {
    @NotNull
    public final IDashBoardApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<ChatProgressRepo>> {
        public final /* synthetic */ DashBoardWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DashBoardWebClient dashBoardWebClient) {
            super(1);
            this.a = dashBoardWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ChatProgressRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.getDashBoardApi().getChatProgress(tokenData2.getAccess_token()).map(a7.c.a.a.n.c.a.a);
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends ChatProgressRepo>> {
        public final /* synthetic */ DashBoardWebClient a;

        public b(DashBoardWebClient dashBoardWebClient) {
            this.a = dashBoardWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ChatProgressRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.b.wrap(th2));
        }
    }

    public static final class c extends Lambda implements Function1<TokenData, Observable<List<? extends OfferCalculationElementRepo>>> {
        public final /* synthetic */ DashBoardWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DashBoardWebClient dashBoardWebClient) {
            super(1);
            this.a = dashBoardWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<List<? extends OfferCalculationElementRepo>> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.getDashBoardApi().getOfferCalculatedList(tokenData2.getAccess_token()).map(a7.c.a.a.n.c.b.a);
        }
    }

    public static final class d<T, R> implements Function<Throwable, ObservableSource<? extends List<? extends OfferCalculationElementRepo>>> {
        public final /* synthetic */ DashBoardWebClient a;

        public d(DashBoardWebClient dashBoardWebClient) {
            this.a = dashBoardWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends OfferCalculationElementRepo>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.b.wrap(th2));
        }
    }

    public DashBoardWebClient(@NotNull IDashBoardApi iDashBoardApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iDashBoardApi, "dashBoardApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iDashBoardApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient
    @NotNull
    public Observable<ChatProgressRepo> getChatProgress() {
        Observable<ChatProgressRepo> onErrorResumeNext = this.c.wrapWithTokenRefresh(new a(this)).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.wrapWithT…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @NotNull
    public final IDashBoardApi getDashBoardApi() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient
    @NotNull
    public Observable<List<OfferCalculationElementRepo>> getOfferCalculatedList() {
        Observable<List<OfferCalculationElementRepo>> onErrorResumeNext = this.c.wrapWithTokenRefresh(new c(this)).onErrorResumeNext(new d(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.wrapWithT…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }
}
