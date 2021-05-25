package a7.c.a.a.o.f.b.a.b;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromListViewModel;
public final class a<T> implements Consumer<OfferProductStatusDomain> {
    public final /* synthetic */ OfferProductInfoFromListViewModel a;

    public a(OfferProductInfoFromListViewModel offerProductInfoFromListViewModel) {
        this.a = offerProductInfoFromListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(OfferProductStatusDomain offerProductStatusDomain) {
        OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
        OfferProductInfoFromListViewModel offerProductInfoFromListViewModel = this.a;
        Intrinsics.checkExpressionValueIsNotNull(offerProductStatusDomain2, "offerProductStatusDomain");
        OfferProductInfoFromListViewModel.access$checkStatus(offerProductInfoFromListViewModel, offerProductStatusDomain2);
    }
}
