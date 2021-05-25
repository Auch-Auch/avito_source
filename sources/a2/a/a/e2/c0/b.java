package a2.a.a.e2.c0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.select.SelectFragment;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
public final class b<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ SelectFragment a;

    public b(SelectFragment selectFragment) {
        this.a = selectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        AdapterPresentersKt.updateItems(adapterPresenter, list2);
        this.a.getAdapter().notifyDataSetChanged();
    }
}
