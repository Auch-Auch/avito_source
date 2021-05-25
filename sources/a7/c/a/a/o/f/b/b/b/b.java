package a7.c.a.a.o.f.b.b.b;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductFilterViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
public final class b<T> implements Consumer<Integer> {
    public final /* synthetic */ OfferProductFilterViewModel a;

    public b(OfferProductFilterViewModel offerProductFilterViewModel) {
        this.a = offerProductFilterViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        this.a.j.setWaitCountForPanel(false);
        IPanelButtonsController iPanelButtonsController = this.a.j;
        Intrinsics.checkExpressionValueIsNotNull(num2, "count");
        iPanelButtonsController.setCountForPanel(num2.intValue());
    }
}
