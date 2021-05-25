package a2.a.a.q1;

import android.content.DialogInterface;
import com.avito.android.lastclick.LastClick;
import com.avito.android.notifications_settings.NotificationsSettingsActivity;
public final class a implements DialogInterface.OnCancelListener {
    public final /* synthetic */ NotificationsSettingsActivity a;

    public a(NotificationsSettingsActivity notificationsSettingsActivity) {
        this.a = notificationsSettingsActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        LastClick.Updater.update();
        this.a.k = null;
    }
}
