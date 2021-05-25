package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
public final class d<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ TariffCountFragment a;

    public d(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        if (list2 != null) {
            this.a.getAdapterPresenter().onDataSourceChanged(new ListDataSource(list2));
        }
    }
}
