package a2.a.a.f.x;

import android.content.DialogInterface;
import com.avito.android.advert.item.AdvertDetailsViewImpl;
import com.avito.android.lastclick.LastClick;
public final class q implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AdvertDetailsViewImpl.g a;

    public q(AdvertDetailsViewImpl.g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        LastClick.Updater.update();
        this.a.a.I.onPhoneCallDismissed();
    }
}
