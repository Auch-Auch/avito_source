package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.tariff.count.viewmodel.Price;
import com.avito.android.util.LoadingState;
public final class g<T> implements Observer<LoadingState<? super Price>> {
    public final /* synthetic */ TariffCountFragment a;

    public g(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super Price> loadingState) {
        LoadingState<? super Price> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.a().setPriceLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            this.a.a().setPrices(((Price) loaded.getData()).getTotalPrice(), ((Price) loaded.getData()).getOldPrice());
        }
    }
}
