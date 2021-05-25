package a2.a.a.f.x.x;

import android.view.View;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
public final class a implements View.OnClickListener {
    public final /* synthetic */ MarketplaceDeliveryPresenter.Listener a;

    public a(MarketplaceDeliveryPresenter.Listener listener) {
        this.a = listener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MarketplaceDeliveryPresenter.Listener listener = this.a;
        if (listener != null) {
            listener.onMarketplaceDeliveryChangeCity();
        }
    }
}
