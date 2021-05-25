package a2.a.a.o;

import android.view.View;
import com.avito.android.autoteka_details.AutotekaDetailsNavigation;
import com.avito.android.autoteka_details.AutotekaDetailsViewImpl;
public final class a implements View.OnClickListener {
    public final /* synthetic */ AutotekaDetailsViewImpl a;

    public a(AutotekaDetailsViewImpl autotekaDetailsViewImpl) {
        this.a = autotekaDetailsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getNavigationClick().accept(new AutotekaDetailsNavigation.Back());
    }
}
