package a2.a.a.g.e;

import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public a(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        AdvertContactsView advertContactsView = this.a.d;
        if (advertContactsView != null) {
            advertContactsView.setEnabled(false);
        }
        AdvertContactsView advertContactsView2 = this.a.e;
        if (advertContactsView2 != null) {
            advertContactsView2.setEnabled(false);
        }
    }
}
