package a2.a.a.g.m;

import android.view.View;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
import com.avito.android.remote.model.Action;
public final class a implements View.OnClickListener {
    public final /* synthetic */ Action a;
    public final /* synthetic */ AdvertStrBlockViewImpl b;

    public a(Action action, AdvertStrBlockViewImpl advertStrBlockViewImpl) {
        this.a = action;
        this.b = advertStrBlockViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.e.onOpenCalendarButtonClick(this.a.getDeepLink());
    }
}
