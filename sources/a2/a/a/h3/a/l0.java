package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import io.reactivex.rxjava3.functions.Consumer;
public final class l0<T> implements Consumer<CharityInteractor.Dialog> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    public l0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CharityInteractor.Dialog dialog) {
        CharityInteractor.Dialog dialog2 = dialog;
        MyAdvertDetailsView myAdvertDetailsView = this.a.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.showInfoBanner(dialog2.getBody(), dialog2.getClickEvent());
        }
    }
}
