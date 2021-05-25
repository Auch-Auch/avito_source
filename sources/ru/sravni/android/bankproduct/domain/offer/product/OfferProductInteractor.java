package ru.sravni.android.bankproduct.domain.offer.product;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductListDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ5\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\nJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0017R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/OfferProductInteractor;", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "", "savedSearchID", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "listFilter", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getOfferProductList", "productID", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "updateOfferProductLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "updateOfferProduct", "", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "requestParams", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "sendRequestLegacy", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "sendRequest", "(Ljava/util/Map;)Lio/reactivex/Observable;", AnalyticFieldsName.orderId, "getProductStatus", AnalyticFieldsName.conversationID, "getProductDetail", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductRepository;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductRepository;", "offerProductRepository", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getSavedSearchID", "()Lio/reactivex/Observable;", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductRepository;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInteractor implements IOfferProductInteractor {
    @NotNull
    public final Observable<String> a;
    public final IOfferProductRepository b;

    public OfferProductInteractor(@NotNull IOfferProductRepository iOfferProductRepository) {
        Intrinsics.checkParameterIsNotNull(iOfferProductRepository, "offerProductRepository");
        this.b = iOfferProductRepository;
        this.a = iOfferProductRepository.getSavedSearchIDChannel();
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParam(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.getCountOfferProductWithNewParam(str, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<Integer> getCountOfferProductWithNewParamLegacy(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.getCountOfferProductWithNewParamLegacy(str, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductListDomain> getOfferProductList(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.getOfferProductList(str, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductListDomain> getOfferProductListLegacy(@NotNull String str, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.getOfferProductListLegacy(str, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductDetailDomain> getProductDetail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        return this.b.getProductDetail(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductStatusDomain> getProductStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.orderId);
        return this.b.getProductStatus(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<String> getSavedSearchID() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductStatusDomain> sendRequest(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        return this.b.sendRequest(map);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductStatusDomain> sendRequestLegacy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        return this.b.sendRequestLegacy(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductDetailDomain> updateOfferProduct(@NotNull String str, @NotNull String str2, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.updateOfferProduct(str, str2, list);
    }

    @Override // ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor
    @NotNull
    public Observable<OfferProductDetailDomain> updateOfferProductLegacy(@NotNull String str, @NotNull String str2, @NotNull List<OfferFilterInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        return this.b.updateOfferProductLegacy(str, str2, list);
    }
}
