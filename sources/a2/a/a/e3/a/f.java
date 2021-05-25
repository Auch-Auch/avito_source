package a2.a.a.e3.a;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.change.TariffChangeFragment;
import com.avito.android.tariff.change.page.TariffTab;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.Iterator;
import java.util.List;
public final class f<T> implements Observer<List<? extends TariffTab>> {
    public final /* synthetic */ TariffChangeFragment a;

    public f(TariffChangeFragment tariffChangeFragment) {
        this.a = tariffChangeFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends TariffTab> list) {
        List<? extends TariffTab> list2 = list;
        if (list2 != null) {
            this.a.i.onDataSourceChanged(new ListDataSource(list2));
            RecyclerView.Adapter adapter = this.a.b().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            Iterator<? extends TariffTab> it = list2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((TariffTab) it.next()).isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            this.a.b().setCurrentItem(i, false);
            this.a.b().unregisterOnPageChangeCallback(this.a.j);
            this.a.b().registerOnPageChangeCallback(this.a.j);
        }
    }
}
