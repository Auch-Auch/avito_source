package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "Lru/sravni/android/bankproduct/presentation/offer/product/IProductActionGetter;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "offerDomain", "", "clickProduct", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;)V", "offerProductDetailDomain", "sendOffer", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISelectOfferProduct extends IProductActionGetter {
    void clickProduct(@NotNull OfferProductDetailDomain offerProductDetailDomain);

    void sendOffer(@NotNull OfferProductDetailDomain offerProductDetailDomain);
}
