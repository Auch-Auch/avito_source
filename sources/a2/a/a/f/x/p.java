package a2.a.a.f.x;

import android.content.DialogInterface;
import com.avito.android.advert.item.AdvertDetailsViewImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.lastclick.LastClick;
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ AdvertDetailsViewImpl.g a;

    public p(AdvertDetailsViewImpl.g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LastClick.Updater.update();
        AdvertContactsPresenter advertContactsPresenter = this.a.a.I;
        AdvertDetailsViewImpl.g gVar = this.a;
        advertContactsPresenter.onPhoneCallConfirmed(gVar.b, gVar.c);
    }
}
