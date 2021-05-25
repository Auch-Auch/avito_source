package a2.a.a.h;

import android.view.View;
import com.avito.android.advert_stats.AdvertStatsActivity;
public final class k implements View.OnClickListener {
    public final /* synthetic */ AdvertStatsActivity a;

    public k(AdvertStatsActivity advertStatsActivity) {
        this.a = advertStatsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
