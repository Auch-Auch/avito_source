package ru.sravni.android.bankproduct.mock.webclient;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductDetailResponse;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductStatusResponse;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b,\u0010-J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\r\u0010\nJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStub;", "Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getOfferProductList", "", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "requestParams", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "sendRequestLegacy", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "sendRequest", "(Ljava/util/Map;)Lio/reactivex/Observable;", "orderID", "getProductStatus", AnalyticFieldsName.conversationID, "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "getProductDetail", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "I", "countOfferNewParam", AuthSource.SEND_ABUSE, "countOffer", "", "c", "J", "delay", "Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStubInfo;", "e", "Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStubInfo;", "offerProductStubInfo", "<init>", "(JLandroid/content/Context;Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductWebClientStub implements IOfferProductWebClient {
    public int a;
    public int b = 1;
    public final long c;
    public final Context d;
    public final OfferProductWebClientStubInfo e;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductWebClientStub a;

        public a(OfferProductWebClientStub offerProductWebClientStub) {
            this.a = offerProductWebClientStub;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return Integer.valueOf(this.a.b);
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductListResponse a;

        public b(OfferProductListResponse offerProductListResponse) {
            this.a = offerProductListResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toOfferProductListRepo();
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public final /* synthetic */ ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse a;

        public c(ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse offerProductListResponse) {
            this.a = offerProductListResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toOfferProductListRepo();
        }
    }

    public static final class d<V> implements Callable<T> {
        public final /* synthetic */ OfferProductDetailResponse a;

        public d(OfferProductDetailResponse offerProductDetailResponse) {
            this.a = offerProductDetailResponse;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.a;
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductDetailResponse offerProductDetailResponse = (OfferProductDetailResponse) obj;
            Intrinsics.checkParameterIsNotNull(offerProductDetailResponse, "it");
            return offerProductDetailResponse.getItemOfferDetail().toOfferProductListOfferRepo();
        }
    }

    public static final class f<T, R> implements Function<T, R> {
        public static final f a = new f();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusResponse offerProductStatusResponse = (OfferProductStatusResponse) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusResponse, "it");
            return offerProductStatusResponse.getItemOfferStatus().toOfferStatusElementRepo();
        }
    }

    public static final class g<T, R> implements Function<T, R> {
        public static final g a = new g();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusResponse offerProductStatusResponse = (OfferProductStatusResponse) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusResponse, "it");
            return offerProductStatusResponse.getItemOfferStatus().toOfferStatusElementRepo();
        }
    }

    public static final class h<T, R> implements Function<T, R> {
        public static final h a = new h();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusResponse offerProductStatusResponse = (OfferProductStatusResponse) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusResponse, "it");
            return offerProductStatusResponse.getItemOfferStatus().toOfferStatusElementRepo();
        }
    }

    public OfferProductWebClientStub(long j, @NotNull Context context, @NotNull OfferProductWebClientStubInfo offerProductWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(offerProductWebClientStubInfo, "offerProductStubInfo");
        this.c = j;
        this.d = context;
        this.e = offerProductWebClientStubInfo;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParam(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        return getCountOfferProductWithNewParamLegacy(str, list);
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParamLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        this.b++;
        Observable<Integer> map = Observable.just(Unit.INSTANCE).delay(this.c, TimeUnit.SECONDS).map(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…ap { countOfferNewParam }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo> getOfferProductList(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        int i = this.a % 2;
        if (i == 0) {
            str2 = UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductCreditListPath());
        } else if (i != 1) {
            str2 = UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductCreditListPath());
        } else {
            str2 = UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductMfoListPath());
        }
        this.a++;
        Observable<OfferProductListRepo> map = Observable.just(Unit.INSTANCE).delay(this.c, TimeUnit.SECONDS).map(new b((OfferProductListResponse) a2.b.a.a.a.i2(str2, OfferProductListResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…oOfferProductListRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo> getOfferProductListLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        if (this.a % 2 != 1) {
            str2 = UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductListPath());
        } else {
            str2 = UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductMicroCreditListPath());
        }
        this.a++;
        Observable<OfferProductListRepo> map = Observable.just(Unit.INSTANCE).delay(this.c, TimeUnit.SECONDS).map(new c((ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse) a2.b.a.a.a.i2(str2, ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…oOfferProductListRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo> getProductDetail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo> map = Observable.fromCallable(new d((OfferProductDetailResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductCreditDetailPath()), OfferProductDetailResponse.class))).delay(this.c, TimeUnit.SECONDS).map(e.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.fromCallable …rProductListOfferRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> getProductStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderID");
        Observable<OfferProductStatusRepo> map = Observable.just((OfferProductStatusResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductStatusPath()), OfferProductStatusResponse.class)).delay(this.c, TimeUnit.SECONDS).map(f.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(statusAn…fferStatusElementRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> sendRequest(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        Observable<OfferProductStatusRepo> map2 = Observable.just((OfferProductStatusResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductStatusPath()), OfferProductStatusResponse.class)).delay(this.c, TimeUnit.SECONDS).map(g.a);
        Intrinsics.checkExpressionValueIsNotNull(map2, "Observable.just(statusAn…fferStatusElementRepo() }");
        return map2;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.product.IOfferProductWebClient
    @NotNull
    public Observable<OfferProductStatusRepo> sendRequestLegacy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        Observable<OfferProductStatusRepo> map = Observable.just((OfferProductStatusResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.d, this.e.getProductStatusPath()), OfferProductStatusResponse.class)).delay(this.c, TimeUnit.SECONDS).map(h.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(statusAn…fferStatusElementRepo() }");
        return map;
    }
}
