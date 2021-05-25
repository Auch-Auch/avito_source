package ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel;

import androidx.lifecycle.LiveData;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.presentation.offer.entity.UrlInfo;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.IAlternativeCompany;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOrderInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0012R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0012¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/IOfferOsagoOrderViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/IAlternativeCompany;", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/ITapQuote;", "Lru/sravni/android/bankproduct/presentation/offer/IOfferRetryErrorViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "osagoNavOrderInfo", "", "initOsagoInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;)V", "Lru/sravni/android/bankproduct/presentation/offer/entity/UrlInfo;", "info", "openWebAction", "(Lru/sravni/android/bankproduct/presentation/offer/entity/UrlInfo;)V", "closeAction", "()V", "Landroidx/lifecycle/LiveData;", "", "getIconStatus", "()Landroidx/lifecycle/LiveData;", "iconStatus", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "getOsagoPaymentInfo", "osagoPaymentInfo", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "getOsagoCompanyOrder", "osagoCompanyOrder", "getUrlInfo", "urlInfo", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderState;", "getOsagoOrderState", "osagoOrderState", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderButtonState;", "getOsagoOrderButtonState", "osagoOrderButtonState", "", "getQuote", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferOsagoOrderViewModel extends IAlternativeCompany, ITapQuote, IOfferRetryErrorViewModel {
    void closeAction();

    @NotNull
    LiveData<Integer> getIconStatus();

    @NotNull
    LiveData<OsagoCompanyOrderDomain> getOsagoCompanyOrder();

    @NotNull
    LiveData<OsagoOrderButtonState> getOsagoOrderButtonState();

    @NotNull
    LiveData<OsagoOrderState> getOsagoOrderState();

    @NotNull
    LiveData<OsagoCompanyOrderInfoDomain> getOsagoPaymentInfo();

    @NotNull
    LiveData<String> getQuote();

    @NotNull
    LiveData<UrlInfo> getUrlInfo();

    void initOsagoInfo(@Nullable OsagoNavOrderInfo osagoNavOrderInfo);

    void openWebAction(@NotNull UrlInfo urlInfo);
}
