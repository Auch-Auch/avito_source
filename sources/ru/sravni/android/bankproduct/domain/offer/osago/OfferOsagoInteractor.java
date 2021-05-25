package ru.sravni.android.bankproduct.domain.offer.osago;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListCompanyDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyAlternativeDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/OfferOsagoInteractor;", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "listFilter", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "getPollingListCompany", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;", "companyAlternative", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "getOsagoOrder", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoRepository;", "offerOsagoRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoRepository;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoInteractor implements IOfferOsagoInteractor {
    public final IOfferOsagoRepository a;

    public OfferOsagoInteractor(@NotNull IOfferOsagoRepository iOfferOsagoRepository) {
        Intrinsics.checkParameterIsNotNull(iOfferOsagoRepository, "offerOsagoRepository");
        this.a = iOfferOsagoRepository;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor
    @NotNull
    public Observable<OfferOsagoListDomain> getOsagoListCompany(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.a.getOsagoListCompany(str, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor
    @NotNull
    public Observable<OsagoCompanyOrderDomain> getOsagoOrder(@NotNull String str, @Nullable OsagoCompanyAlternativeDomain osagoCompanyAlternativeDomain) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        return this.a.getOsagoOrder(str, osagoCompanyAlternativeDomain);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor
    @NotNull
    public Observable<OfferOsagoListCompanyDomain> getPollingListCompany(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        return this.a.getPollingListCompany(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor
    @NotNull
    public Observable<OsagoCompanyOrderInfoDomain> getPollingOrderCompany(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchId");
        return this.a.getPollingOrderCompany(str, str2);
    }
}
