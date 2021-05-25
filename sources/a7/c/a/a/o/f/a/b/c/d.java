package a7.c.a.a.o.f.a.b.c;

import android.os.Handler;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.entity.UrlInfo;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel;
public final class d implements Runnable {
    public final /* synthetic */ OfferOsagoOrderViewModel a;
    public final /* synthetic */ UrlInfo b;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = this.a;
            OfferOsagoOrderViewModel.access$sendOfferSendEvent(dVar.a, dVar.b);
            this.a.a.r.popBackStack(R.id.chatFragment, false);
        }
    }

    public d(OfferOsagoOrderViewModel offerOsagoOrderViewModel, UrlInfo urlInfo) {
        this.a = offerOsagoOrderViewModel;
        this.b = urlInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new Handler().postDelayed(new a(this), 500);
    }
}
