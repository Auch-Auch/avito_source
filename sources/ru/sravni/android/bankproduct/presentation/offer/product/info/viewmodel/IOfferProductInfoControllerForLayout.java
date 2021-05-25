package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailItemDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoControllerForLayout;", "", "Landroidx/lifecycle/LiveData;", "", "getTitleInfo", "()Landroidx/lifecycle/LiveData;", "titleInfo", "", "isWaitingSend", "isWaitingRetry", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", "getOfferProductActionInfo", "offerProductActionInfo", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "getStatus", "status", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "getListOfferProductDetailDomain", "listOfferProductDetailDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductInfoControllerForLayout {
    @NotNull
    LiveData<List<OfferProductDetailItemDomainWithLogoInfo>> getListOfferProductDetailDomain();

    @NotNull
    LiveData<OfferProductActionInfo> getOfferProductActionInfo();

    @NotNull
    LiveData<ProductStatusEnum> getStatus();

    @NotNull
    LiveData<String> getTitleInfo();

    @NotNull
    LiveData<Boolean> isWaitingRetry();

    @NotNull
    LiveData<Boolean> isWaitingSend();
}
