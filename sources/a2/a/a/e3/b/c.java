package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.tariff.count.viewmodel.PricePanelState;
public final class c<T> implements Observer<PricePanelState> {
    public final /* synthetic */ TariffCountFragment a;

    public c(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PricePanelState pricePanelState) {
        PricePanelState pricePanelState2 = pricePanelState;
        if (pricePanelState2 != null) {
            this.a.a().setButtonText(pricePanelState2.getActionTitle());
            this.a.a().setTitle(pricePanelState2.getSumTitle());
        }
    }
}
