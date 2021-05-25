package a2.a.a.f.x.t;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoViewImpl;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AdvertDetailsCreditInfoViewImpl a;
    public final /* synthetic */ View b;

    public a(AdvertDetailsCreditInfoViewImpl advertDetailsCreditInfoViewImpl, View view) {
        this.a = advertDetailsCreditInfoViewImpl;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.v = null;
    }
}
