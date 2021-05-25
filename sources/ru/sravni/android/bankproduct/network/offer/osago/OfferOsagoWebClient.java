package ru.sravni.android.bankproduct.network.offer.osago;

import a7.c.a.a.n.e.a.f;
import a7.c.a.a.n.e.a.g;
import a7.c.a.a.n.e.a.h;
import a7.c.a.a.n.e.a.i;
import a7.c.a.a.n.e.a.j;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequestKt;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/OfferOsagoWebClient;", "Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "getPollingListCompany", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "getOsagoOrder", "productID", "companyID", "getAlternativeOsagoOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/network/offer/osago/IOfferOsagoApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/offer/osago/IOfferOsagoApi;", "offerApi", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "<init>", "(Lru/sravni/android/bankproduct/network/offer/osago/IOfferOsagoApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoWebClient implements IOfferOsagoWebClient {
    public final IOfferOsagoApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<OsagoCompanyOrderRepo>> {
        public final /* synthetic */ OfferOsagoWebClient a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(OfferOsagoWebClient offerOsagoWebClient, String str, String str2, String str3) {
            super(1);
            this.a = offerOsagoWebClient;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OsagoCompanyOrderRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getAlternativeOsagoOrder(tokenData2.getAccess_token(), this.b, this.c, this.d).map(a7.c.a.a.n.e.a.a.a).onErrorResumeNext(new a7.c.a.a.n.e.a.b(this));
        }
    }

    public static final class b extends Lambda implements Function1<TokenData, Observable<OfferOsagoListRepo>> {
        public final /* synthetic */ OfferOsagoWebClient a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OfferOsagoWebClient offerOsagoWebClient, List list, String str) {
            super(1);
            this.a = offerOsagoWebClient;
            this.b = list;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferOsagoListRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getOsagoListCompany(tokenData2.getAccess_token(), this.c, OfferFilterRequestKt.makeOfferFilterRequest(this.b)).map(a7.c.a.a.n.e.a.c.a).onErrorResumeNext(new a7.c.a.a.n.e.a.d(this));
        }
    }

    public static final class c extends Lambda implements Function1<TokenData, Observable<OsagoCompanyOrderRepo>> {
        public final /* synthetic */ OfferOsagoWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(OfferOsagoWebClient offerOsagoWebClient, String str) {
            super(1);
            this.a = offerOsagoWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OsagoCompanyOrderRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getOsagoOrder(tokenData2.getAccess_token(), this.b).map(a7.c.a.a.n.e.a.e.a).onErrorResumeNext(new f(this));
        }
    }

    public static final class d extends Lambda implements Function1<TokenData, Observable<OfferOsagoListCompanyRepo>> {
        public final /* synthetic */ OfferOsagoWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(OfferOsagoWebClient offerOsagoWebClient, String str) {
            super(1);
            this.a = offerOsagoWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferOsagoListCompanyRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getPollingListCompany(tokenData2.getAccess_token(), this.b).map(g.a).onErrorResumeNext(new h(this));
        }
    }

    public static final class e extends Lambda implements Function1<TokenData, Observable<OsagoCompanyOrderInfoRepo>> {
        public final /* synthetic */ OfferOsagoWebClient a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(OfferOsagoWebClient offerOsagoWebClient, String str, String str2) {
            super(1);
            this.a = offerOsagoWebClient;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OsagoCompanyOrderInfoRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getPollingOrderCompany(tokenData2.getAccess_token(), this.b, this.c).map(i.a).onErrorResumeNext(new j(this));
        }
    }

    public OfferOsagoWebClient(@NotNull IOfferOsagoApi iOfferOsagoApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iOfferOsagoApi, "offerApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iOfferOsagoApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderRepo> getAlternativeOsagoOrder(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, "savedSearchID", str2, "productID", str3, "companyID");
        return this.c.wrapWithTokenRefresh(new a(this, str, str2, str3));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OfferOsagoListRepo> getOsagoListCompany(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return this.c.wrapWithTokenRefresh(new b(this, list, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderRepo> getOsagoOrder(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        return this.c.wrapWithTokenRefresh(new c(this, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OfferOsagoListCompanyRepo> getPollingListCompany(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        return this.c.wrapWithTokenRefresh(new d(this, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderInfoRepo> getPollingOrderCompany(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchId");
        return this.c.wrapWithTokenRefresh(new e(this, str, str2));
    }
}
