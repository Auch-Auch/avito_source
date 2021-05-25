package ru.sravni.android.bankproduct.repository.offer.osago;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListCompanyDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyAlternativeDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterCreatorKt;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCreatorKt;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/OfferOsagoRepository;", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoRepository;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "filtersInfo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "getPollingListCompany", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;", "companyAlternative", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "getOsagoOrder", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;", "webClient", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "<init>", "(Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoRepository implements IOfferOsagoRepository {
    public final IOfferOsagoWebClient a;
    public final IErrorLogger b;
    public final IThrowableWrapper c;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferOsagoRepository a;

        public a(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferOsagoListRepo offerOsagoListRepo = (OfferOsagoListRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerOsagoListRepo, "offerOsagoListRepo");
            List<OfferOsagoItemDomain> createOfferOsagoDomain = OfferOsagoListCreatorKt.createOfferOsagoDomain(offerOsagoListRepo);
            OfferOsagoRepository.access$checkEmptyTitleOsagoOffer(this.a, offerOsagoListRepo.getSavedSearchID(), offerOsagoListRepo.getPollingID(), createOfferOsagoDomain);
            return offerOsagoListRepo.toOfferOsagoListDomain(createOfferOsagoDomain, OfferFilterCreatorKt.createListOfferFilter(offerOsagoListRepo.getSavedSearchID(), offerOsagoListRepo.getFilters(), this.a.b, this.a.c));
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends OfferOsagoListDomain>> {
        public final /* synthetic */ OfferOsagoRepository a;

        public b(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferOsagoListDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.c.wrap(th2));
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferOsagoRepository a;

        public c(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OsagoCompanyOrderRepo osagoCompanyOrderRepo = (OsagoCompanyOrderRepo) obj;
            Intrinsics.checkParameterIsNotNull(osagoCompanyOrderRepo, "it");
            OfferOsagoRepository.access$checkEmptyTitleOsagoOrder(this.a, osagoCompanyOrderRepo);
            return osagoCompanyOrderRepo.toOsagoCompanyOrderDomain();
        }
    }

    public static final class d<T, R> implements Function<Throwable, ObservableSource<? extends OsagoCompanyOrderDomain>> {
        public final /* synthetic */ OfferOsagoRepository a;

        public d(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OsagoCompanyOrderDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.c.wrap(th2));
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OfferOsagoListCompanyRepo offerOsagoListCompanyRepo = (OfferOsagoListCompanyRepo) obj;
            Intrinsics.checkParameterIsNotNull(offerOsagoListCompanyRepo, "it");
            return offerOsagoListCompanyRepo.toOfferOsagoListCompanyDomain();
        }
    }

    public static final class f<T, R> implements Function<Throwable, ObservableSource<? extends OfferOsagoListCompanyDomain>> {
        public final /* synthetic */ OfferOsagoRepository a;

        public f(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OfferOsagoListCompanyDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.c.wrap(th2));
        }
    }

    public static final class g<T, R> implements Function<T, R> {
        public final /* synthetic */ OfferOsagoRepository a;
        public final /* synthetic */ String b;

        public g(OfferOsagoRepository offerOsagoRepository, String str) {
            this.a = offerOsagoRepository;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            OsagoCompanyOrderInfoRepo osagoCompanyOrderInfoRepo = (OsagoCompanyOrderInfoRepo) obj;
            Intrinsics.checkParameterIsNotNull(osagoCompanyOrderInfoRepo, "it");
            List<OsagoCompanyOrderInfoRepo.CompanyRepo> listCompany = osagoCompanyOrderInfoRepo.getListCompany();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(listCompany, 10));
            for (T t : listCompany) {
                OfferOsagoRepository.access$checkEmptyTitleOsagoOrderPolling(this.a, t, this.b);
                arrayList.add(t.toCompanyDomain());
            }
            return osagoCompanyOrderInfoRepo.toOsagoOrderCompanyInfoDomain(arrayList);
        }
    }

    public static final class h<T, R> implements Function<Throwable, ObservableSource<? extends OsagoCompanyOrderInfoDomain>> {
        public final /* synthetic */ OfferOsagoRepository a;

        public h(OfferOsagoRepository offerOsagoRepository) {
            this.a = offerOsagoRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends OsagoCompanyOrderInfoDomain> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.c.wrap(th2));
        }
    }

    public OfferOsagoRepository(@NotNull IOfferOsagoWebClient iOfferOsagoWebClient, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iOfferOsagoWebClient, "webClient");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.a = iOfferOsagoWebClient;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    public static final void access$checkEmptyTitleOsagoOffer(OfferOsagoRepository offerOsagoRepository, String str, String str2, List list) {
        String str3;
        OfferOsagoDisplaySettingsDomain displaySettings;
        Objects.requireNonNull(offerOsagoRepository);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            OfferOsagoItemDomain offerOsagoItemDomain = (OfferOsagoItemDomain) obj;
            boolean z = false;
            if (offerOsagoItemDomain.getOfferOsagoItemEnum() == OfferOsagoItemEnum.PROLONGATION || offerOsagoItemDomain.getOfferOsagoItemEnum() == OfferOsagoItemEnum.ELEMENT) {
                OfferOsagoDetailDomain offerDomain = offerOsagoItemDomain.getOfferDomain();
                String productName = (offerDomain == null || (displaySettings = offerDomain.getDisplaySettings()) == null) ? null : displaySettings.getProductName();
                if (productName == null || productName.length() == 0) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IErrorLogger iErrorLogger = offerOsagoRepository.b;
            MessagePriority messagePriority = MessagePriority.WARN;
            IThrowableWrapper iThrowableWrapper = offerOsagoRepository.c;
            OfferOsagoDetailDomain offerDomain2 = ((OfferOsagoItemDomain) it.next()).getOfferDomain();
            if (offerDomain2 == null || (str3 = offerDomain2.getProductID()) == null) {
                str3 = "emptyProductID";
            }
            iErrorLogger.logError(messagePriority, iThrowableWrapper.wrap(new EmptyOsagoCompanyNameForOsagoListCompany(str2, str, str3)));
        }
    }

    public static final void access$checkEmptyTitleOsagoOrder(OfferOsagoRepository offerOsagoRepository, OsagoCompanyOrderRepo osagoCompanyOrderRepo) {
        Objects.requireNonNull(offerOsagoRepository);
        if (osagoCompanyOrderRepo.getTitle().length() == 0) {
            offerOsagoRepository.b.logError(MessagePriority.WARN, offerOsagoRepository.c.wrap(new EmptyOsagoCompanyNameForOsagoCompanyOrder(osagoCompanyOrderRepo.getPollingID())));
        }
    }

    public static final void access$checkEmptyTitleOsagoOrderPolling(OfferOsagoRepository offerOsagoRepository, OsagoCompanyOrderInfoRepo.CompanyRepo companyRepo, String str) {
        Objects.requireNonNull(offerOsagoRepository);
        if (companyRepo.getTitle().length() == 0) {
            offerOsagoRepository.b.logError(MessagePriority.WARN, offerOsagoRepository.c.wrap(new EmptyOsagoCompanyNameForOsagoPollingCompany(companyRepo.getProductID(), str, companyRepo.getCompanyID(), companyRepo.getProductID())));
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository
    @NotNull
    public Observable<OfferOsagoListDomain> getOsagoListCompany(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filtersInfo");
        IOfferOsagoWebClient iOfferOsagoWebClient = this.a;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OfferFilterInfoRepo(it.next()));
        }
        Observable<R> onErrorResumeNext = iOfferOsagoWebClient.getOsagoListCompany(str, arrayList).map(new a(this)).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient\n            .g…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository
    @NotNull
    public Observable<OsagoCompanyOrderDomain> getOsagoOrder(@NotNull String str, @Nullable OsagoCompanyAlternativeDomain osagoCompanyAlternativeDomain) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Observable<OsagoCompanyOrderRepo> alternativeOsagoOrder = osagoCompanyAlternativeDomain != null ? this.a.getAlternativeOsagoOrder(str, osagoCompanyAlternativeDomain.getProductID(), osagoCompanyAlternativeDomain.getCompanyID()) : null;
        if (alternativeOsagoOrder == null) {
            alternativeOsagoOrder = this.a.getOsagoOrder(str);
        }
        Observable<R> onErrorResumeNext = alternativeOsagoOrder.map(new c(this)).onErrorResumeNext(new d(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "companyAlternative?.let …error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository
    @NotNull
    public Observable<OfferOsagoListCompanyDomain> getPollingListCompany(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Observable<R> onErrorResumeNext = this.a.getPollingListCompany(str).map(e.a).onErrorResumeNext(new f(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.getPollingList…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository
    @NotNull
    public Observable<OsagoCompanyOrderInfoDomain> getPollingOrderCompany(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchId");
        Observable<R> onErrorResumeNext = this.a.getPollingOrderCompany(str, str2).map(new g(this, str2)).onErrorResumeNext(new h(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient.getPollingOrde…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }
}
