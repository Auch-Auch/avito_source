package a2.a.a.p0;

import androidx.lifecycle.Observer;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.konveyor.data_source.ListDataSource;
public final class d<T> implements Observer<ListDataSource<CvTabItem>> {
    public final /* synthetic */ ExpressCvActivity a;

    public d(ExpressCvActivity expressCvActivity) {
        this.a = expressCvActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ListDataSource<CvTabItem> listDataSource) {
        ListDataSource<CvTabItem> listDataSource2 = listDataSource;
        if (listDataSource2 != null) {
            this.a.getTabsDataProvider().onDataSourceChanged(listDataSource2);
            this.a.getPagerAdapter().notifyDataSetChanged();
            this.a.getLayoutAdapter().notifyDataSetChanged();
        }
    }
}
