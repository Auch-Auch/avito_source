package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.remote.model.SubscribeResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class d0<T> implements Consumer<SubscribeResult> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ String b;

    public d0(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, String str) {
        this.a = favoriteSellersPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SubscribeResult subscribeResult) {
        FavoriteSellersPresenterImpl.access$restoreRemovedItems(this.a);
        FavoriteSellersPresenterImpl.n(this.a, this.b, Boolean.TRUE, subscribeResult.isNotificationsActivated(), false, 8);
    }
}
