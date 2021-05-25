package a7.c.a.a.o.f.a.b.c;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OsagoOrderButtonState;
public final class b<T> implements Consumer<OsagoCompanyOrderInfoDomain> {
    public final /* synthetic */ OfferOsagoOrderViewModel a;
    public final /* synthetic */ String b;

    public b(OfferOsagoOrderViewModel offerOsagoOrderViewModel, String str) {
        this.a = offerOsagoOrderViewModel;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain) {
        OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain2 = osagoCompanyOrderInfoDomain;
        String pollingStatus = osagoCompanyOrderInfoDomain2.getPollingStatus();
        switch (pollingStatus.hashCode()) {
            case -179150628:
                if (pollingStatus.equals("getAlternatives")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel, osagoCompanyOrderInfoDomain2, R.drawable.ic_round_error_sravni, OsagoOrderButtonState.ALTERNATIVE);
                    return;
                }
                break;
            case -90562193:
                if (pollingStatus.equals("noVariants")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel2 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel2, osagoCompanyOrderInfoDomain2, R.drawable.ic_round_error_sravni, OsagoOrderButtonState.GO_TO_CHAT);
                    return;
                }
                break;
            case -74168508:
                if (pollingStatus.equals("getting")) {
                    OfferOsagoOrderViewModel.access$makeOrderOsagoInfo(this.a, osagoCompanyOrderInfoDomain2.getPollingInterval(), osagoCompanyOrderInfoDomain2.getPollingID(), this.b);
                    return;
                }
                break;
            case 96784904:
                if (pollingStatus.equals("error")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel3 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel3, osagoCompanyOrderInfoDomain2, R.drawable.ic_round_error_sravni, OsagoOrderButtonState.GO_TO_CHAT);
                    this.a.c(BaseAnalyticKt.ANALYTIC_FAIL_SERVER);
                    return;
                }
                break;
            case 772624515:
                if (pollingStatus.equals("samePrice")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel4 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel4, osagoCompanyOrderInfoDomain2, R.drawable.ic_complete_sravni, OsagoOrderButtonState.GO_TO_WEB);
                    return;
                }
                break;
            case 805667002:
                if (pollingStatus.equals("higherPrice")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel5 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel5, osagoCompanyOrderInfoDomain2, R.drawable.ic_complete_sravni, OsagoOrderButtonState.GO_TO_WEB);
                    return;
                }
                break;
            case 1213091528:
                if (pollingStatus.equals("lowerPrice")) {
                    OfferOsagoOrderViewModel offerOsagoOrderViewModel6 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
                    OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel6, osagoCompanyOrderInfoDomain2, R.drawable.ic_complete_sravni, OsagoOrderButtonState.GO_TO_WEB);
                    return;
                }
                break;
        }
        OfferOsagoOrderViewModel offerOsagoOrderViewModel7 = this.a;
        Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderInfoDomain2, "orderInfo");
        OfferOsagoOrderViewModel.access$osagoCompanyAnswer(offerOsagoOrderViewModel7, osagoCompanyOrderInfoDomain2, R.drawable.ic_round_error_sravni, OsagoOrderButtonState.GO_TO_CHAT);
        this.a.c(BaseAnalyticKt.ANALYTIC_FAIL_SERVER);
    }
}
