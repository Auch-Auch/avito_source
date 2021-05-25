package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.vas_performance.ui.VisualVasFragment;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.data_source.ListDataSource;
public final class h0<T> implements Observer<ListUpdate> {
    public final /* synthetic */ VisualVasFragment a;

    public h0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ListUpdate listUpdate) {
        ListUpdate listUpdate2 = listUpdate;
        if (listUpdate2 != null) {
            this.a.getAdapterPresenter().onDataSourceChanged(new ListDataSource(listUpdate2.getList()));
            RecyclerView.Adapter adapter = VisualVasFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                listUpdate2.getDiffResult().dispatchUpdatesTo(adapter);
            }
        }
    }
}
