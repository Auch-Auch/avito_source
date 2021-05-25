package a2.a.a.q3.f;

import a2.b.a.a.a;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import com.avito.conveyor_item.Item;
import java.util.List;
public final class l<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ LegacyVisualVasFragment a;

    public l(LegacyVisualVasFragment legacyVisualVasFragment) {
        this.a = legacyVisualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        if (list2 != null) {
            a.s1(list2, this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = LegacyVisualVasFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
