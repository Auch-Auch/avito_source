package a2.a.a.y0;

import android.view.View;
import com.avito.android.help_center.HelpCenterViewImpl;
import kotlin.Unit;
public final class b implements View.OnClickListener {
    public final /* synthetic */ HelpCenterViewImpl a;

    public b(HelpCenterViewImpl helpCenterViewImpl) {
        this.a = helpCenterViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getNavigationClick().accept(Unit.INSTANCE);
    }
}
