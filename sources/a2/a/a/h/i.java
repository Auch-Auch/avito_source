package a2.a.a.h;

import androidx.lifecycle.Observer;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.util.Views;
public final class i<T> implements Observer<Boolean> {
    public final /* synthetic */ AdvertStatsActivity a;

    public i(AdvertStatsActivity advertStatsActivity) {
        this.a = advertStatsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            Views.setVisible(AdvertStatsActivity.access$getToolbarTitle$p(this.a), bool2.booleanValue());
        }
    }
}
