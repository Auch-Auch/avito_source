package a2.a.a.t2;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
public final class d<T> implements Observer<List<? extends ShopSettingsItem>> {
    public final /* synthetic */ ShopSettingsFragment a;

    public d(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends ShopSettingsItem> list) {
        List<? extends ShopSettingsItem> list2 = list;
        if (list2 != null) {
            this.a.getAdapterPresenter().onDataSourceChanged(new ListDataSource(list2));
        }
    }
}
