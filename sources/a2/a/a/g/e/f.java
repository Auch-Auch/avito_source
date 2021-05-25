package a2.a.a.g.e;

import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.PhoneActionData;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<PhoneActionData> {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public f(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(PhoneActionData phoneActionData) {
        this.a.q();
        AdvertContactsPresenterImpl.g(this.a, phoneActionData.getDeepLink(), true, false, 4);
        AdvertCoreView advertCoreView = this.a.f;
        if (advertCoreView != null) {
            advertCoreView.dismissProgress();
        }
    }
}
