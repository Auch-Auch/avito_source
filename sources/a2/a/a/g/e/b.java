package a2.a.a.g.e;

import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public b(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        AdvertContactsView advertContactsView = this.a.d;
        if (advertContactsView != null) {
            advertContactsView.setEnabled(true);
        }
        AdvertContactsView advertContactsView2 = this.a.e;
        if (advertContactsView2 != null) {
            advertContactsView2.setEnabled(true);
        }
    }
}
