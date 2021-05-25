package ru.sravni.android.bankproduct.repository.offer.product;

import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\r\u0010\nJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/IOfferProductWebClient;", "", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getOfferProductList", "", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "requestParams", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "sendRequestLegacy", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "sendRequest", "(Ljava/util/Map;)Lio/reactivex/Observable;", "orderID", "getProductStatus", AnalyticFieldsName.conversationID, "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "getProductDetail", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductWebClient {
    @NotNull
    Observable<Integer> getCountOfferProductWithNewParam(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list);

    @NotNull
    Observable<Integer> getCountOfferProductWithNewParamLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list);

    @NotNull
    Observable<OfferProductListRepo> getOfferProductList(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list);

    @NotNull
    Observable<OfferProductListRepo> getOfferProductListLegacy(@NotNull String str, @NotNull List<OfferFilterInfoRepo> list);

    @NotNull
    Observable<OfferProductListRepo.OfferGroupRepo.OfferRepo> getProductDetail(@NotNull String str);

    @NotNull
    Observable<OfferProductStatusRepo> getProductStatus(@NotNull String str);

    @NotNull
    Observable<OfferProductStatusRepo> sendRequest(@NotNull Map<String, String> map);

    @NotNull
    Observable<OfferProductStatusRepo> sendRequestLegacy(@NotNull String str);
}
