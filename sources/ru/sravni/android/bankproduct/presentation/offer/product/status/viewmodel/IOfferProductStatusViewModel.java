package ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductStatusDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/status/viewmodel/IOfferProductStatusViewModel;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "statusInfo", "", "initWithOfferProductStatusDomain", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;)V", "onReadyClicked", "()V", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;", "getStatusList", "()Landroidx/lifecycle/LiveData;", "statusList", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductStatusViewModel {
    @NotNull
    LiveData<OfferProductStatusDomainWithLogoInfo> getStatusList();

    void initWithOfferProductStatusDomain(@Nullable OfferProductStatusNavInfo offerProductStatusNavInfo);

    void onReadyClicked();
}
