package ru.sravni.android.bankproduct.repository.offer.product;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductListDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterCreatorKt;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListCreatorKt;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b5\u00106J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ5\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\nJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0002¢\u0006\u0004\b \u0010!J)\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007*\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010)R*\u00100\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00020\u00020+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/OfferProductRepository;", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductRepository;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "filtersInfo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getOfferProductList", "productID", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "updateOfferProductLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "updateOfferProduct", "", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "requestParams", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "sendRequestLegacy", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "sendRequest", "(Ljava/util/Map;)Lio/reactivex/Observable;", "orderID", "getProductStatus", AnalyticFieldsName.conversationID, "getProductDetail", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", AuthSource.BOOKING_ORDER, "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", AuthSource.SEND_ABUSE, "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;", "Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;", "webClient", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/subjects/PublishSubject;", "getSavedSearchIDChannel", "()Lio/reactivex/subjects/PublishSubject;", "savedSearchIDChannel", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "c", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "<init>", "(Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductRepository implements IOfferProductRepository {
    @NotNull
    public final PublishSubject<String> a;
    public final IOfferProductWebClient b;
    public final IErrorLogger c;
    public final IThrowableWrapper d;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends Integer>> {
        public final /* synthetic */ OfferProductRepository a;

        public a(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Integer> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends Integer>> {
        public final /* synthetic */ OfferProductRepository a;

        public b(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Integer> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductListRepo.OfferGroupRepo.OfferRepo offerRepo = (OfferProductListRepo.OfferGroupRepo.OfferRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerRepo, "it");
            return offerRepo.toOfferProductDetailDomain();
        }
    }

    public static final class d<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductDetailDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public d(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductDetailDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductRepository a;

        public e(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusRepo offerProductStatusRepo = (OfferProductStatusRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusRepo, "it");
            OfferProductRepository.access$checkEmptyTitleCreditStatus(this.a, offerProductStatusRepo);
            return offerProductStatusRepo.toOfferProductStatusDomain();
        }
    }

    public static final class f<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductStatusDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public f(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductStatusDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class g<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductRepository a;

        public g(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusRepo offerProductStatusRepo = (OfferProductStatusRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusRepo, "it");
            this.a.getSavedSearchIDChannel().onNext(offerProductStatusRepo.getSavedSearchID());
            return offerProductStatusRepo.toOfferProductStatusDomain();
        }
    }

    public static final class h<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductStatusDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public h(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductStatusDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class i<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductRepository a;

        public i(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductStatusRepo offerProductStatusRepo = (OfferProductStatusRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerProductStatusRepo, "it");
            this.a.getSavedSearchIDChannel().onNext(offerProductStatusRepo.getSavedSearchID());
            return offerProductStatusRepo.toOfferProductStatusDomain();
        }
    }

    public static final class j<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductStatusDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public j(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductStatusDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class k<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductRepository a;
        public final /* synthetic */ String b;

        public k(OfferProductRepository offerProductRepository, String str) {
            this.a = offerProductRepository;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            T t;
            OfferProductListRepo offerProductListRepo = (OfferProductListRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerProductListRepo, "offerProductListRepo");
            List access$getProductOffers = OfferProductRepository.access$getProductOffers(this.a, offerProductListRepo);
            OfferProductRepository.access$checkEmptyTitleCreditOffer(this.a, offerProductListRepo.getSavedSearchID(), access$getProductOffers);
            Iterator<T> it = access$getProductOffers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                OfferProductDetailDomain offerDomain = t.getOfferDomain();
                if (Intrinsics.areEqual(offerDomain != null ? offerDomain.getProductId() : null, this.b)) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                return t2.getOfferDomain();
            }
            return null;
        }
    }

    public static final class l<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductDetailDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public l(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductDetailDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public static final class m<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferProductRepository a;

        public m(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferProductListRepo offerProductListRepo = (OfferProductListRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerProductListRepo, "offerProductListRepo");
            List<OfferProductItemDomain> access$getProductOffers = OfferProductRepository.access$getProductOffers(this.a, offerProductListRepo);
            OfferProductRepository.access$checkEmptyTitleCreditOffer(this.a, offerProductListRepo.getSavedSearchID(), access$getProductOffers);
            return offerProductListRepo.toOfferProductListDomain(access$getProductOffers, OfferFilterCreatorKt.createListOfferFilter(offerProductListRepo.getSavedSearchID(), offerProductListRepo.getFilters(), this.a.c, this.a.d));
        }
    }

    public static final class n<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductListDomain>> {
        public final /* synthetic */ OfferProductRepository a;

        public n(OfferProductRepository offerProductRepository) {
            this.a = offerProductRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferProductListDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.d.wrap(th2));
        }
    }

    public OfferProductRepository(@NotNull IOfferProductWebClient iOfferProductWebClient, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iOfferProductWebClient, "webClient");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.b = iOfferProductWebClient;
        this.c = iErrorLogger;
        this.d = iThrowableWrapper;
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<String>()");
        this.a = create;
    }

    public static final void access$checkEmptyTitleCreditOffer(OfferProductRepository offerProductRepository, String str, List list) {
        String str2;
        String str3;
        String str4;
        OfferProductDetailInfoDomain detailInfo;
        OfferProductDisplaySettingsDomain displaySettings;
        Objects.requireNonNull(offerProductRepository);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            OfferProductItemDomain offerProductItemDomain = (OfferProductItemDomain) obj;
            boolean z = false;
            if (offerProductItemDomain.getOfferProductItemEnum() == OfferProductItemEnum.ELEMENT) {
                OfferProductDetailDomain offerDomain = offerProductItemDomain.getOfferDomain();
                String bankName = (offerDomain == null || (detailInfo = offerDomain.getDetailInfo()) == null || (displaySettings = detailInfo.getDisplaySettings()) == null) ? null : displaySettings.getBankName();
                if (bankName == null || bankName.length() == 0) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            OfferProductItemDomain offerProductItemDomain2 = (OfferProductItemDomain) it.next();
            IErrorLogger iErrorLogger = offerProductRepository.c;
            MessagePriority messagePriority = MessagePriority.WARN;
            IThrowableWrapper iThrowableWrapper = offerProductRepository.d;
            OfferProductDetailDomain offerDomain2 = offerProductItemDomain2.getOfferDomain();
            if (offerDomain2 == null || (str2 = offerDomain2.getBankId()) == null) {
                str2 = "emptyBankID";
            }
            OfferProductDetailDomain offerDomain3 = offerProductItemDomain2.getOfferDomain();
            if (offerDomain3 == null || (str3 = offerDomain3.getOrderID()) == null) {
                str3 = "emptyOrderID";
            }
            OfferProductDetailDomain offerDomain4 = offerProductItemDomain2.getOfferDomain();
            if (offerDomain4 == null || (str4 = offerDomain4.getProductId()) == null) {
                str4 = "emptyProductID";
            }
            iErrorLogger.logError(messagePriority, iThrowableWrapper.wrap(new EmptyProductCompanyNameForProductListCompany(str3, str2, str, str4)));
        }
    }

    public static final void access$checkEmptyTitleCreditStatus(OfferProductRepository offerProductRepository, OfferProductStatusRepo offerProductStatusRepo) {
        Objects.requireNonNull(offerProductRepository);
        if (offerProductStatusRepo.getDisplaySettings().getBankName().length() == 0) {
            IErrorLogger iErrorLogger = offerProductRepository.c;
            MessagePriority messagePriority = MessagePriority.WARN;
            IThrowableWrapper iThrowableWrapper = offerProductRepository.d;
            String savedSearchID = offerProductStatusRepo.getSavedSearchID();
            String bankID = offerProductStatusRepo.getBankID();
            String orderID = offerProductStatusRepo.getOrderID();
            if (orderID == null) {
                orderID = "emptyOrderID";
            }
            iErrorLogger.logError(messagePriority, iThrowableWrapper.wrap(new EmptyProductCompanyNameForProductStatusCompany(orderID, bankID, savedSearchID, offerProductStatusRepo.getProductID())));
        }
    }

    public static final List access$getProductOffers(OfferProductRepository offerProductRepository, OfferProductListRepo offerProductListRepo) {
        Objects.requireNonNull(offerProductRepository);
        return OfferProductListCreatorKt.createOfferProductDomain(offerProductListRepo);
    }

    public final Observable<OfferProductDetailDomain> a(@NotNull Observable<OfferProductListRepo> observable, String str) {
        Observable<R> onErrorResumeNext = observable.map(new k(this, str)).onErrorResumeNext(new l(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "this\n            .map { …error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    public final Observable<OfferProductListDomain> b(@NotNull Observable<OfferProductListRepo> observable) {
        Observable<R> onErrorResumeNext = observable.map(new m(this)).onErrorResumeNext(new n(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "this\n            .map { …error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParam(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        Observable<Integer> onErrorResumeNext = iOfferProductWebClient.getCountOfferProductWithNewParam(str, arrayList).onErrorResumeNext(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient\n        .getCo…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParamLegacy(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        Observable<Integer> onErrorResumeNext = iOfferProductWebClient.getCountOfferProductWithNewParamLegacy(str, arrayList).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient\n            .g…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductListDomain> getOfferProductList(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        return b(iOfferProductWebClient.getOfferProductList(str, arrayList));
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductListDomain> getOfferProductListLegacy(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        return b(iOfferProductWebClient.getOfferProductListLegacy(str, arrayList));
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductDetailDomain> getProductDetail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Observable<R> onErrorResumeNext = this.b.getProductDetail(str).map(c.a).onErrorResumeNext(new d(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.getProductDeta…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductStatusDomain> getProductStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderID");
        Observable<R> onErrorResumeNext = this.b.getProductStatus(str).map(new e(this)).onErrorResumeNext(new f(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.getProductStat…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductStatusDomain> sendRequest(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        Observable<R> onErrorResumeNext = this.b.sendRequest(map).map(new g(this)).onErrorResumeNext(new h(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.sendRequest(re…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductStatusDomain> sendRequestLegacy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        Observable<R> onErrorResumeNext = this.b.sendRequestLegacy(str).map(new i(this)).onErrorResumeNext(new j(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.sendRequestLeg…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductDetailDomain> updateOfferProduct(@NotNull String str, @NotNull String str2, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        return a(iOfferProductWebClient.getOfferProductList(str2, arrayList), str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public Observable<OfferProductDetailDomain> updateOfferProductLegacy(@NotNull String str, @NotNull String str2, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferProductWebClient iOfferProductWebClient = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        return a(iOfferProductWebClient.getOfferProductListLegacy(str2, arrayList), str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository
    @NotNull
    public PublishSubject<String> getSavedSearchIDChannel() {
        return this.a;
    }
}
