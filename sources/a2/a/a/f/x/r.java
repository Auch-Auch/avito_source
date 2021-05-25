package a2.a.a.f.x;

import android.content.DialogInterface;
import com.avito.android.advert.item.AdvertDetailsViewImpl;
public final class r implements DialogInterface.OnCancelListener {
    public final /* synthetic */ AdvertDetailsViewImpl.g a;

    public r(AdvertDetailsViewImpl.g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a.I.onPhoneCallCanceled();
    }
}
