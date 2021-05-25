package ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductStatusDomainWithLogoInfo;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/status/viewmodel/OfferProductStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/status/viewmodel/IOfferProductStatusViewModel;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "statusInfo", "", "initWithOfferProductStatusDomain", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;)V", "onReadyClicked", "()V", "c", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "statusNavInfo", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "f", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "e", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;", "d", "Landroidx/lifecycle/MutableLiveData;", "getStatusList", "()Landroidx/lifecycle/MutableLiveData;", "statusList", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusViewModel extends ViewModel implements IOfferProductStatusViewModel {
    public OfferProductStatusNavInfo c;
    @NotNull
    public final MutableLiveData<OfferProductStatusDomainWithLogoInfo> d = new MutableLiveData<>();
    public final INavigator e;
    public final IErrorLogger f;

    public OfferProductStatusViewModel(@NotNull INavigator iNavigator, @NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.e = iNavigator;
        this.f = iErrorLogger;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.IOfferProductStatusViewModel
    public void initWithOfferProductStatusDomain(@Nullable OfferProductStatusNavInfo offerProductStatusNavInfo) {
        this.c = offerProductStatusNavInfo;
        if (offerProductStatusNavInfo != null) {
            getStatusList().postValue(new OfferProductStatusDomainWithLogoInfo(offerProductStatusNavInfo.getStatusDomain(), new LogoInfo(offerProductStatusNavInfo.getStatusDomain().getDisplaySettings().getBankLogoUrlSVG(), ILogoLoadCallback.Companion.createDefaultCallback$default(ILogoLoadCallback.Companion, this.f, null, 2, null))));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.IOfferProductStatusViewModel
    public void onReadyClicked() {
        Unit unit;
        Integer backDestinationId;
        OfferProductStatusNavInfo offerProductStatusNavInfo = this.c;
        if (offerProductStatusNavInfo == null || (backDestinationId = offerProductStatusNavInfo.getBackDestinationId()) == null) {
            unit = null;
        } else {
            this.e.popBackStack(backDestinationId.intValue(), false);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.e.popBack();
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.IOfferProductStatusViewModel
    @NotNull
    public MutableLiveData<OfferProductStatusDomainWithLogoInfo> getStatusList() {
        return this.d;
    }
}
