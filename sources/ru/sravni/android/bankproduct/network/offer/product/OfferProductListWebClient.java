package ru.sravni.android.bankproduct.network.offer.product;

import a7.c.a.a.n.e.b.i;
import a7.c.a.a.n.e.b.j;
import a7.c.a.a.n.e.b.k;
import a7.c.a.a.n.e.b.l;
import a7.c.a.a.n.e.b.m;
import a7.c.a.a.n.e.b.n;
import a7.c.a.a.n.e.b.o;
import a7.c.a.a.n.e.b.p;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequestKt;
import ru.sravni.android.bankproduct.network.offer.product.request.OfferSendRequest;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\r\u0010\nJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00100\u00100\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u001a0\u001a0\u00072\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/OfferProductListWebClient;", "Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getOfferProductList", "", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "requestParams", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "sendRequestLegacy", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "sendRequest", "(Ljava/util/Map;)Lio/reactivex/Observable;", "orderID", "kotlin.jvm.PlatformType", "getProductStatus", AnalyticFieldsName.conversationID, "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "getProductDetail", "Lru/sravni/android/bankproduct/network/offer/product/IOfferProductListApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/offer/product/IOfferProductListApi;", "offerApi", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "<init>", "(Lru/sravni/android/bankproduct/network/offer/product/IOfferProductListApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListWebClient implements IOfferProductWebClient {
    public final IOfferProductListApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<Integer>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(OfferProductListWebClient offerProductListWebClient, List list, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = list;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<Integer> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getCountOfferProductWithNewParam(tokenData2.getAccess_token(), this.c, OfferFilterRequestKt.makeOfferFilterRequest(this.b)).map(a7.c.a.a.n.e.b.a.a).onErrorResumeNext(new a7.c.a.a.n.e.b.b(this));
        }
    }

    public static final class b extends Lambda implements Function1<TokenData, Observable<Integer>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OfferProductListWebClient offerProductListWebClient, List list, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = list;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<Integer> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getCountOfferProductWithNewParamLegacy(tokenData2.getAccess_token(), this.c, OfferFilterRequestKt.makeOfferFilterRequest(this.b)).map(a7.c.a.a.n.e.b.c.a).onErrorResumeNext(new a7.c.a.a.n.e.b.d(this));
        }
    }

    public static final class c extends Lambda implements Function1<TokenData, Observable<OfferProductListRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(OfferProductListWebClient offerProductListWebClient, List list, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = list;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductListRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getOfferProductList(tokenData2.getAccess_token(), this.c, OfferFilterRequestKt.makeOfferFilterRequest(this.b)).map(a7.c.a.a.n.e.b.e.a).onErrorResumeNext(new a7.c.a.a.n.e.b.f(this));
        }
    }

    public static final class d extends Lambda implements Function1<TokenData, Observable<OfferProductListRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(OfferProductListWebClient offerProductListWebClient, List list, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = list;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductListRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getOfferProductListLegacy(tokenData2.getAccess_token(), this.c, OfferFilterRequestKt.makeOfferFilterRequest(this.b)).map(a7.c.a.a.n.e.b.g.a).onErrorResumeNext(new a7.c.a.a.n.e.b.h(this));
        }
    }

    public static final class e extends Lambda implements Function1<TokenData, Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(OfferProductListWebClient offerProductListWebClient, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getProductDetail(tokenData2.getAccess_token(), this.b).map(i.a).onErrorResumeNext(new j(this));
        }
    }

    public static final class f extends Lambda implements Function1<TokenData, Observable<OfferProductStatusRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(OfferProductListWebClient offerProductListWebClient, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductStatusRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.getProductStatus(tokenData2.getAccess_token(), this.b).map(k.a).onErrorResumeNext(new l(this));
        }
    }

    public static final class g extends Lambda implements Function1<TokenData, Observable<OfferProductStatusRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ Map b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(OfferProductListWebClient offerProductListWebClient, Map map) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductStatusRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.sendProductOrderToBank(tokenData2.getAccess_token(), new OfferSendRequest(this.b)).map(m.a).onErrorResumeNext(new n(this));
        }
    }

    public static final class h extends Lambda implements Function1<TokenData, Observable<OfferProductStatusRepo>> {
        public final /* synthetic */ OfferProductListWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(OfferProductListWebClient offerProductListWebClient, String str) {
            super(1);
            this.a = offerProductListWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<OfferProductStatusRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.sendProductOrderToBankLegacy(tokenData2.getAccess_token(), new ru.sravni.android.bankproduct.network.offer.product.request.legacy.OfferSendRequest(this.b)).map(o.a).onErrorResumeNext(new p(this));
        }
    }

    public OfferProductListWebClient(@NotNull IOfferProductListApi iOfferProductListApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iOfferProductListApi, "offerApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iOfferProductListApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParam(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return this.c.wrapWithTokenRefresh(new a(this, list, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParamLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return this.c.wrapWithTokenRefresh(new b(this, list, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo> getOfferProductList(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return this.c.wrapWithTokenRefresh(new c(this, list, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo> getOfferProductListLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return this.c.wrapWithTokenRefresh(new d(this, list, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo> getProductDetail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        return this.c.wrapWithTokenRefresh(new e(this, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> getProductStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderID");
        return this.c.wrapWithTokenRefresh(new f(this, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> sendRequest(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        return this.c.wrapWithTokenRefresh(new g(this, map));
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> sendRequestLegacy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        return this.c.wrapWithTokenRefresh(new h(this, str));
    }
}
