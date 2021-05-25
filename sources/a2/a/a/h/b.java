package a2.a.a.h;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.advert_stats.recycler.ListUpdate;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
public final class b<T> implements Observer<ListUpdate> {
    public final /* synthetic */ AdvertStatsActivity a;

    public b(AdvertStatsActivity advertStatsActivity) {
        this.a = advertStatsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ListUpdate listUpdate) {
        ListUpdate listUpdate2 = listUpdate;
        if (listUpdate2 != null) {
            this.a.getAdapterPresenter().onDataSourceChanged(new ListDataSource(listUpdate2.getList()));
            RecyclerView.Adapter adapter = AdvertStatsActivity.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter == null) {
                AdvertStatsActivity.access$getRecyclerView$p(this.a).setAdapter(new SimpleRecyclerAdapter(this.a.getAdapterPresenter(), this.a.getItemBinder()));
                return;
            }
            listUpdate2.getDiffResult().dispatchUpdatesTo(adapter);
        }
    }
}
