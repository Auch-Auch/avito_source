package a7.c.a.a.o.f.b.b.b;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductFilterViewModel;
public final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
    public final /* synthetic */ OfferProductFilterViewModel a;

    public a(OfferProductFilterViewModel offerProductFilterViewModel) {
        this.a = offerProductFilterViewModel;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        this.a.j.setWaitCountForPanel(true);
        return OfferProductFilterViewModel.access$getListCount(this.a, list);
    }
}
