package a2.a.a.f3;

import androidx.lifecycle.Observer;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.ThemeSettingsFragment;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<List<? extends SpannedItem>> {
    public final /* synthetic */ ThemeSettingsFragment a;

    public a(ThemeSettingsFragment themeSettingsFragment) {
        this.a = themeSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends SpannedItem> list) {
        List<? extends SpannedItem> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        ListDataSource listDataSource = new ListDataSource(list2);
        this.a.getAdapterPresenter().onDataSourceChanged(listDataSource);
        this.a.getGridPositionProvider().onDataSourceChanged(listDataSource);
        this.a.getSerpSpanProvider().onDataSourceChanged(listDataSource);
        this.a.getRecyclerAdapter().notifyDataSetChanged();
    }
}
