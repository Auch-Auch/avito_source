package a2.a.a.u2;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
public final class b<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ ShopSettingsSelectFragment a;

    public b(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        this.a = shopSettingsSelectFragment;
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
