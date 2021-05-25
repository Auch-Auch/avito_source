package defpackage;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewImpl;
/* compiled from: java-style lambda group */
/* renamed from: g0  reason: default package */
public final class g0 implements Toolbar.OnMenuItemClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public g0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i = this.a;
        if (i != 0) {
            Integer num = null;
            if (i == 1) {
                if (menuItem != null) {
                    num = Integer.valueOf(menuItem.getItemId());
                }
                int i2 = R.id.settings;
                if (num != null && num.intValue() == i2) {
                    ((ProfileHeaderViewImpl) this.b).h.accept(ProfileHeaderView.ClickTarget.Settings.INSTANCE);
                } else {
                    int i3 = R.id.notification;
                    if (num == null || num.intValue() != i3) {
                        return false;
                    }
                    ((ProfileHeaderViewImpl) this.b).h.accept(ProfileHeaderView.ClickTarget.Notifications.INSTANCE);
                }
                return true;
            }
            throw null;
        } else if (menuItem == null || menuItem.getItemId() != R.id.start_publish) {
            return false;
        } else {
            ((ProfileHeaderViewImpl) this.b).h.accept(ProfileHeaderView.ClickTarget.StartPublish.INSTANCE);
            return true;
        }
    }
}
