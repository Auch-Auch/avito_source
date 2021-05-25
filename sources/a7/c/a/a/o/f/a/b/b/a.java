package a7.c.a.a.o.f.a.b.b;

import android.content.DialogInterface;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel;
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ IOfferOsagoOrderViewModel a;

    public a(IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel) {
        this.a = iOfferOsagoOrderViewModel;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.closeAction();
    }
}
