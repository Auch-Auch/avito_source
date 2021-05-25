package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
/* compiled from: java-style lambda group */
/* renamed from: h2  reason: default package */
public final class h2<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public h2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(List<? extends Item> list) {
        int i = this.a;
        if (i == 0) {
            List<? extends Item> list2 = list;
            if (list2 != null) {
                ((EditInfoFragment) this.b).getAdapterPresenter().onDataSourceChanged(new ListDataSource(list2));
            }
        } else if (i == 1) {
            List<? extends Item> list3 = list;
            if (list3 != null) {
                ((EditInfoFragment) this.b).getTabsAdapterPresenter().onDataSourceChanged(new ListDataSource(list3));
                ((EditInfoFragment) this.b).getTabsRecyclerAdapter().notifyDataSetChanged();
            }
        } else {
            throw null;
        }
    }
}
