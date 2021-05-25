package a2.a.a.e3.h;

import a2.b.a.a.a;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.region.RegionFragment;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Pair;
public final class c<T> implements Observer<Pair<? extends List<? extends Item>, ? extends DiffUtil.DiffResult>> {
    public final /* synthetic */ RegionFragment a;

    public c(RegionFragment regionFragment) {
        this.a = regionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Pair<? extends List<? extends Item>, ? extends DiffUtil.DiffResult> pair) {
        Pair<? extends List<? extends Item>, ? extends DiffUtil.DiffResult> pair2 = pair;
        if (pair2 != null) {
            DiffUtil.DiffResult diffResult = (DiffUtil.DiffResult) pair2.component2();
            a.s1((List) pair2.component1(), this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = RegionFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                diffResult.dispatchUpdatesTo(adapter);
            }
        }
    }
}
