package a2.a.a.f.x.t;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoViewImpl;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AdvertDetailsCreditInfoViewImpl a;
    public final /* synthetic */ View b;

    public b(AdvertDetailsCreditInfoViewImpl advertDetailsCreditInfoViewImpl, View view) {
        this.a = advertDetailsCreditInfoViewImpl;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.w = null;
        this.a.u = null;
        PhoneChooserView.Listener listener = this.a.t;
        if (listener != null) {
            listener.onPhoneChooserClosed();
        }
    }
}
