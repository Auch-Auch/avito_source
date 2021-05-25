package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "", "", "description", "", "clickProlongationInfo", "(Ljava/lang/String;)V", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "osagoDetail", "selectedOsago", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISelectOfferOsago {
    void clickProlongationInfo(@NotNull String str);

    void selectedOsago(@NotNull OfferOsagoDetailDomain offerOsagoDetailDomain);
}
