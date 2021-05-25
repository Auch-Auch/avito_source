package a2.a.a.z0;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.hints.HintsDialogFragment;
import com.avito.conveyor_item.Item;
import java.util.List;
public final class a<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ HintsDialogFragment a;

    public a(HintsDialogFragment hintsDialogFragment) {
        this.a = hintsDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        if (list2 != null) {
            a2.b.a.a.a.s1(list2, this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = HintsDialogFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
