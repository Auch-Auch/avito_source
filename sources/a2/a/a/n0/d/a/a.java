package a2.a.a.n0.d.a;

import android.view.View;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOfferListener;
import com.avito.android.developments_catalog.remote.model.AvitoOffer;
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ AvitoOffer b;

    public a(b bVar, AvitoOffer avitoOffer) {
        this.a = bVar;
        this.b = avitoOffer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AvitoOfferListener avitoOfferListener = this.a.b;
        if (avitoOfferListener != null) {
            avitoOfferListener.onOfferClick(this.b.getDeeplink());
        }
    }
}
