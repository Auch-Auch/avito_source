package a2.a.a.g.e;

import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Disposable> {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public e(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        AdvertCoreView advertCoreView = this.a.f;
        if (advertCoreView != null) {
            advertCoreView.showProgress();
        }
    }
}
