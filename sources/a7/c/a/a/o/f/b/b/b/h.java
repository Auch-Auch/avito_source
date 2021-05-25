package a7.c.a.a.o.f.b.b.b;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductListViewModel;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.ProductNavOffersInfo;
public final class h<T> implements Consumer<OfferProductStatusDomain> {
    public final /* synthetic */ OfferProductListViewModel a;
    public final /* synthetic */ OfferProductDetailDomain b;

    public h(OfferProductListViewModel offerProductListViewModel, OfferProductDetailDomain offerProductDetailDomain) {
        this.a = offerProductListViewModel;
        this.b = offerProductDetailDomain;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(OfferProductStatusDomain offerProductStatusDomain) {
        String str;
        OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
        this.a.isWaitingSend().setValue(Boolean.FALSE);
        INavigator iNavigator = this.a.r;
        int i = R.id.action_offerProductListFragment_to_offerProductStatusFragment;
        OfferProductListViewModel offerProductListViewModel = this.a;
        Intrinsics.checkExpressionValueIsNotNull(offerProductStatusDomain2, "statusDomain");
        INavigator.DefaultImpls.route$default(iNavigator, i, UtilFunctionsKt.toSravniJson(OfferProductListViewModel.access$createNavInfo(offerProductListViewModel, offerProductStatusDomain2)), null, 4, null);
        IOfferAnalytic iOfferAnalytic = this.a.C;
        String orderID = offerProductStatusDomain2.getOrderID();
        if (orderID == null) {
            orderID = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        }
        IProductNameDictionary iProductNameDictionary = this.a.E;
        ProductNavOffersInfo productNavOffersInfo = this.a.n;
        if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
            str = "";
        }
        IOfferAnalytic.DefaultImpls.offerSend$default(iOfferAnalytic, orderID, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName(), this.b.getDetailInfo().getDisplaySettings().getBankName(), this.b.getDetailInfo().getDisplaySettings().getOfferTitle(), this.a.B.getPreviousModuleName(), null, null, this.a.B.getCurrentModuleName(), 96, null);
    }
}
