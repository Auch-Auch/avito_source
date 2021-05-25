package a2.a.a.y0.d;

import android.view.View;
import com.avito.android.help_center.help_center_request.HelpCenterRequestViewImpl;
import kotlin.Unit;
public final class a implements View.OnClickListener {
    public final /* synthetic */ HelpCenterRequestViewImpl a;

    public a(HelpCenterRequestViewImpl helpCenterRequestViewImpl) {
        this.a = helpCenterRequestViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getNavigationClick().accept(Unit.INSTANCE);
    }
}
