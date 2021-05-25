package a2.a.a.f.x;

import androidx.lifecycle.Observer;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<DfpCreditInfo> {
    public final /* synthetic */ AdvertDetailsFragment a;

    public a(AdvertDetailsFragment advertDetailsFragment) {
        this.a = advertDetailsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DfpCreditInfo dfpCreditInfo) {
        DfpCreditInfo dfpCreditInfo2 = dfpCreditInfo;
        if (dfpCreditInfo2 instanceof DfpCreditInfo.CreditCalculator) {
            DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) dfpCreditInfo2;
            this.a.getAdvertDetailsItemsPresenter().bindCreditBrokerLink(creditCalculator.getLinkType(), creditCalculator.getMonthlyPaymentFormatted());
        }
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter = this.a.getAdvertDetailsCreditInfoPresenter();
        Intrinsics.checkNotNullExpressionValue(dfpCreditInfo2, "it");
        advertDetailsCreditInfoPresenter.showCreditInfo(dfpCreditInfo2);
    }
}
