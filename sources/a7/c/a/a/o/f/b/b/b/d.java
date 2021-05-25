package a7.c.a.a.o.f.b.b.b;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductListViewModel;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
public final class d<T> implements Consumer<OfferProductStatusDomain> {
    public final /* synthetic */ OfferProductListViewModel a;

    public d(OfferProductListViewModel offerProductListViewModel) {
        this.a = offerProductListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(OfferProductStatusDomain offerProductStatusDomain) {
        OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
        this.a.isWaitingSend().setValue(Boolean.FALSE);
        INavigator iNavigator = this.a.r;
        int i = R.id.action_offerProductListFragment_to_offerProductStatusFragment;
        OfferProductListViewModel offerProductListViewModel = this.a;
        Intrinsics.checkExpressionValueIsNotNull(offerProductStatusDomain2, "offerProductStatusDomain");
        INavigator.DefaultImpls.route$default(iNavigator, i, UtilFunctionsKt.toSravniJson(OfferProductListViewModel.access$createNavInfo(offerProductListViewModel, offerProductStatusDomain2)), null, 4, null);
    }
}
