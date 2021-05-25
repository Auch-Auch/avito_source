package a2.a.a.e3.i;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ TariffPackageInfoFragment a;

    public a(TariffPackageInfoFragment tariffPackageInfoFragment) {
        this.a = tariffPackageInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        adapterPresenter.onDataSourceChanged(new ListDataSource(list2));
        this.a.getRecyclerAdapter().notifyDataSetChanged();
    }
}
