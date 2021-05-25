package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import io.reactivex.rxjava3.functions.Action;
public final class m implements Action {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public m(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.showContent();
    }
}
