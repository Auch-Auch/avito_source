package a2.a.a.f.u;

import android.view.View;
import com.avito.android.advert.badge_details.BadgeDetailsViewImpl;
import kotlin.Unit;
public final class c implements View.OnClickListener {
    public final /* synthetic */ BadgeDetailsViewImpl.b a;

    public c(BadgeDetailsViewImpl.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a.f.accept(Unit.INSTANCE);
    }
}
