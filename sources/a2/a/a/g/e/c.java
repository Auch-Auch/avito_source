package a2.a.a.g.e;

import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import ru.avito.messenger.api.entity.Channel;
public final class c<T> implements Consumer<Channel> {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public c(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Channel channel) {
        AdvertCoreView advertCoreView = this.a.f;
        if (advertCoreView != null) {
            AdvertCoreView.DefaultImpls.displayMessage$default(advertCoreView, this.a.E.successfulJobApplication(), null, null, null, 14, null);
        }
    }
}
