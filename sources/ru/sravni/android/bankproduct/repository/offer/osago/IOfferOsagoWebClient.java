package ru.sravni.android.bankproduct.repository.offer.osago;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/IOfferOsagoWebClient;", "", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "getPollingListCompany", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "getOsagoOrder", "productID", "companyID", "getAlternativeOsagoOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferOsagoWebClient {
    @NotNull
    Observable<OsagoCompanyOrderRepo> getAlternativeOsagoOrder(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Observable<OfferOsagoListRepo> getOsagoListCompany(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list);

    @NotNull
    Observable<OsagoCompanyOrderRepo> getOsagoOrder(@NotNull String str);

    @NotNull
    Observable<OfferOsagoListCompanyRepo> getPollingListCompany(@NotNull String str);

    @NotNull
    Observable<OsagoCompanyOrderInfoRepo> getPollingOrderCompany(@NotNull String str, @NotNull String str2);
}
