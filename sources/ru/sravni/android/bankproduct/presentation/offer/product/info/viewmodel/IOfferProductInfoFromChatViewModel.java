package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromChat;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromChatViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IClickOfferProduct;", "Lru/sravni/android/bankproduct/presentation/offer/IOfferRetryErrorViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "detailInfoFromChat", "", "initWithDetailInfo", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;)V", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoControllerForLayout;", "getOfferProductInfoController", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoControllerForLayout;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductInfoFromChatViewModel extends IClickOfferProduct, IOfferRetryErrorViewModel {
    @NotNull
    IOfferProductInfoControllerForLayout getOfferProductInfoController();

    void initWithDetailInfo(@NotNull OfferProductDetailInfoFromChat offerProductDetailInfoFromChat);
}
