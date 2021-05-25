package ru.sravni.android.bankproduct.presentation.offer.product.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", "createOfferProductStatusInfo", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;)Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferProductActionInfoKt {
    @NotNull
    public static final OfferProductActionInfo createOfferProductStatusInfo(@NotNull OfferProductDetailDomain offerProductDetailDomain) {
        int i;
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "$this$createOfferProductStatusInfo");
        boolean z = (offerProductDetailDomain.getDetailInfo().getDisplaySettings().getProductType() != ProductTypeEnum.MICRO_CREDIT || offerProductDetailDomain.getDetailInfo().getUrl() == null || offerProductDetailDomain.getDetailInfo().getUrlText() == null) ? false : true;
        boolean z2 = offerProductDetailDomain.getDetailInfo().getStatus() != ProductStatusEnum.ACCEPTED && !z;
        if (z) {
            i = R.string.product_success_mfo;
        } else if (z2) {
            i = R.string.product_success_detail;
        } else {
            i = R.string.product_success_money;
        }
        return new OfferProductActionInfo(offerProductDetailDomain.getDetailInfo().getUrl(), offerProductDetailDomain.getDetailInfo().getUrlText(), offerProductDetailDomain.getOrderID(), i, z2, z);
    }
}
