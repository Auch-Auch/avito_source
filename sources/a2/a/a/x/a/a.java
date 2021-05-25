package a2.a.a.x.a;

import androidx.lifecycle.Observer;
import com.avito.android.bundles.ui.VasBundlesFragment;
import com.avito.android.bundles.viewmodel.VasBundlesViewState;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
public final class a<T> implements Observer<VasBundlesViewState> {
    public final /* synthetic */ VasBundlesFragment a;

    public a(VasBundlesFragment vasBundlesFragment) {
        this.a = vasBundlesFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VasBundlesViewState vasBundlesViewState) {
        VasBundlesViewState vasBundlesViewState2 = vasBundlesViewState;
        VasBundlesFragment.access$bindProgressOverlay(this.a, vasBundlesViewState2.getLoadingState());
        List<Item> bundles = vasBundlesViewState2.getBundles();
        if (bundles != null) {
            VasBundlesFragment.access$bindList(this.a, bundles);
        }
    }
}
