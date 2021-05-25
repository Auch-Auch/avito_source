package a7.c.a.a.o.f.a.b.c;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel;
public final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
    public final /* synthetic */ OfferOsagoOrderViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public a(OfferOsagoOrderViewModel offerOsagoOrderViewModel, String str, String str2) {
        this.a = offerOsagoOrderViewModel;
        this.b = str;
        this.c = str2;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkParameterIsNotNull((Long) obj, "it");
        return this.a.s.getPollingOrderCompany(this.b, this.c);
    }
}
