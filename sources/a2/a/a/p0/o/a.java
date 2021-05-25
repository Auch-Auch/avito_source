package a2.a.a.p0.o;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.express_cv.new_cv.NewCvFragment;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
public final class a<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ NewCvFragment a;

    public a(NewCvFragment newCvFragment) {
        this.a = newCvFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        if (list2 != null) {
            a2.b.a.a.a.s1(list2, this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = NewCvFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter == null) {
                NewCvFragment.access$getRecyclerView$p(this.a).setAdapter(new SimpleRecyclerAdapter(this.a.getAdapterPresenter(), this.a.getItemBinder()));
                return;
            }
            adapter.notifyDataSetChanged();
        }
    }
}
