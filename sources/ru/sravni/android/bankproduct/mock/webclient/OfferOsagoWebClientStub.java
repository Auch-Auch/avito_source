package ru.sravni.android.bankproduct.mock.webclient;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListCompanyResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoCompanyOrderResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoOrderCompanyInfoResponse;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b1\u00102J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010$¨\u00063"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/OfferOsagoWebClientStub;", "Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "getPollingListCompany", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "getOsagoOrder", "productID", "companyID", "getAlternativeOsagoOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "mockStringStatus", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse;", "Lru/sravni/android/bankproduct/mock/webclient/OfferOsagoWebClientStubInfo;", "f", "Lru/sravni/android/bankproduct/mock/webclient/OfferOsagoWebClientStubInfo;", "offerOsagoStubInfo", "", "c", "I", "orderCount", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "pollingCount", "", "d", "J", "delay", AuthSource.BOOKING_ORDER, "pollingOrderCount", "<init>", "(JLandroid/content/Context;Lru/sravni/android/bankproduct/mock/webclient/OfferOsagoWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoWebClientStub implements IOfferOsagoWebClient {
    public int a;
    public int b;
    public int c;
    public final long d;
    public final Context e;
    public final OfferOsagoWebClientStubInfo f;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ OsagoCompanyOrderRepo a;

        public a(OsagoCompanyOrderRepo osagoCompanyOrderRepo) {
            this.a = osagoCompanyOrderRepo;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a;
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferOsagoListResponse a;

        public b(OfferOsagoListResponse offerOsagoListResponse) {
            this.a = offerOsagoListResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toOfferOsagoListRepo();
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public final /* synthetic */ OsagoCompanyOrderRepo a;

        public c(OsagoCompanyOrderRepo osagoCompanyOrderRepo) {
            this.a = osagoCompanyOrderRepo;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a;
        }
    }

    public static final class d<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferOsagoListCompanyResponse a;

        public d(OfferOsagoListCompanyResponse offerOsagoListCompanyResponse) {
            this.a = offerOsagoListCompanyResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.toOfferOsagoListCompanyRepo();
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public final /* synthetic */ Ref.ObjectRef a;

        public e(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.element;
        }
    }

    public OfferOsagoWebClientStub(long j, @NotNull Context context, @NotNull OfferOsagoWebClientStubInfo offerOsagoWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(offerOsagoWebClientStubInfo, "offerOsagoStubInfo");
        this.d = j;
        this.e = context;
        this.f = offerOsagoWebClientStubInfo;
    }

    public final OfferOsagoListCompanyResponse a(String str) {
        return (OfferOsagoListCompanyResponse) a2.b.a.a.a.i2(str, OfferOsagoListCompanyResponse.class);
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderRepo> getAlternativeOsagoOrder(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, "savedSearchID", str2, "productID", str3, "companyID");
        Observable<OsagoCompanyOrderRepo> map = Observable.just(Unit.INSTANCE).delay(this.d, TimeUnit.SECONDS).map(new a(OsagoCompanyOrderRepo.copy$default(((OsagoCompanyOrderResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoCompanyOrderPath()), OsagoCompanyOrderResponse.class)).getItem().toOsagoCompanyOrderRepo(), null, null, 0, null, "Альфастрахование", null, 47, null)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de… { osagoOderCompanyRepo }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OfferOsagoListRepo> getOsagoListCompany(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        Observable<OfferOsagoListRepo> map = Observable.just(Unit.INSTANCE).delay(this.d, TimeUnit.SECONDS).map(new b((OfferOsagoListResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoListPath()), OfferOsagoListResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de….toOfferOsagoListRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderRepo> getOsagoOrder(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Observable<OsagoCompanyOrderRepo> map = Observable.just(Unit.INSTANCE).delay(this.d, TimeUnit.SECONDS).map(new c(((OsagoCompanyOrderResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoCompanyOrderPath()), OsagoCompanyOrderResponse.class)).getItem().toOsagoCompanyOrderRepo()));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de… { osagoOderCompanyRepo }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OfferOsagoListCompanyRepo> getPollingListCompany(@NotNull String str) {
        OfferOsagoListCompanyResponse offerOsagoListCompanyResponse;
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        String readStringFromAsset = UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoListCompanyErrorStatusPath());
        String readStringFromAsset2 = UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoListCompanyInProgressStatusPath());
        String readStringFromAsset3 = UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoListCompanyFinishedStatusPath());
        int i = this.a % 3;
        if (i == 0) {
            offerOsagoListCompanyResponse = a(readStringFromAsset2);
        } else if (i != 1) {
            offerOsagoListCompanyResponse = a(readStringFromAsset);
        } else {
            offerOsagoListCompanyResponse = a(readStringFromAsset3);
        }
        this.a++;
        Observable<OfferOsagoListCompanyRepo> map = Observable.just(Unit.INSTANCE).delay(this.d, TimeUnit.SECONDS).map(new d(offerOsagoListCompanyResponse));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…rOsagoListCompanyRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.offer.osago.IOfferOsagoWebClient
    @NotNull
    public Observable<OsagoCompanyOrderInfoRepo> getPollingOrderCompany(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchId");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T t = (T) ((OsagoOrderCompanyInfoResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getOsagoCompanyInfoOrderPath()), OsagoOrderCompanyInfoResponse.class)).getItem().toOsagoOrderCompanyInfoRepo();
        objectRef.element = t;
        if (this.b == 2) {
            this.b = 0;
            this.c++;
            objectRef.element = (T) OsagoCompanyOrderInfoRepo.copy$default(t, null, 0, "getAlternatives", "Страховая ответила отказом", null, null, "Вы можете выбрать страховку в другой компании", 0, null, null, null, 1971, null);
        }
        this.b++;
        Observable<OsagoCompanyOrderInfoRepo> map = Observable.just(Unit.INSTANCE).delay(this.d, TimeUnit.SECONDS).map(new e(objectRef));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…agoOrderCompanyInfoRepo }");
        return map;
    }
}
