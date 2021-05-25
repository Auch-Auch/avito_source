package a2.a.a.y0;

import android.view.MenuItem;
import com.avito.android.help_center.HelpCenterViewImpl;
import com.avito.android.help_center.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class a implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ HelpCenterViewImpl a;

    public a(HelpCenterViewImpl helpCenterViewImpl) {
        this.a = helpCenterViewImpl;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "it");
        if (menuItem.getItemId() != R.id.home) {
            return false;
        }
        this.a.getHomeClick().accept(Unit.INSTANCE);
        return true;
    }
}
