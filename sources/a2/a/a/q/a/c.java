package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.data_source.ListDataSource;
public final class c<T> implements Observer<ListUpdate> {
    public final /* synthetic */ CheckoutFragment a;

    public c(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ListUpdate listUpdate) {
        ListUpdate listUpdate2 = listUpdate;
        if (listUpdate2 != null) {
            this.a.getAdapterPresenter().onDataSourceChanged(new ListDataSource(listUpdate2.getList()));
            RecyclerView.Adapter adapter = CheckoutFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                listUpdate2.getDiffResult().dispatchUpdatesTo(adapter);
            }
        }
    }
}
