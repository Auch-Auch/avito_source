package a2.a.a.g.f;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlock;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
public final class b<T> implements Observer<AdvertDeliveryBlock> {
    public final /* synthetic */ AdvertDeliveryBlockView a;

    public b(AdvertDeliveryBlockView advertDeliveryBlockView) {
        this.a = advertDeliveryBlockView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AdvertDeliveryBlock advertDeliveryBlock) {
        AdvertDeliveryBlock advertDeliveryBlock2 = advertDeliveryBlock;
        if (advertDeliveryBlock2 != null) {
            AdvertDeliveryBlockView advertDeliveryBlockView = this.a;
            AdvertDeliveryBlockView.access$bindDeliveryBlock(advertDeliveryBlockView, advertDeliveryBlockView.b, advertDeliveryBlock2);
        }
    }
}
