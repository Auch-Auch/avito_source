package a2.a.a.x.b;

import androidx.lifecycle.Observer;
import com.avito.android.bundles.vas_union.VasUnionFragment;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewState;
import com.avito.conveyor_item.Item;
import java.util.List;
public final class a<T> implements Observer<VasUnionViewState> {
    public final /* synthetic */ VasUnionFragment a;

    public a(VasUnionFragment vasUnionFragment) {
        this.a = vasUnionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VasUnionViewState vasUnionViewState) {
        VasUnionViewState vasUnionViewState2 = vasUnionViewState;
        VasUnionFragment.access$bindProgressOverlay(this.a, vasUnionViewState2.getLoadingState());
        List<Item> items = vasUnionViewState2.getItems();
        if (items != null) {
            VasUnionFragment.access$bindList(this.a, items);
        }
    }
}
