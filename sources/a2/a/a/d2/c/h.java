package a2.a.a.d2.c;

import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<SubscribeInfo> {
    public final /* synthetic */ SubscriptionsPresenterImpl a;

    public h(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
        this.a = subscriptionsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SubscribeInfo subscribeInfo) {
        SubscriptionsPresenter.DefaultImpls.updateSellersSubscription$default(this.a, subscribeInfo, false, 2, null);
    }
}
