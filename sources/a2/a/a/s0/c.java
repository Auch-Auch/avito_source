package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.SubscribableItem;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Disposable> {
    public final /* synthetic */ SubscribableItem a;
    public final /* synthetic */ FavoriteSellersView b;

    public c(SubscribableItem subscribableItem, FavoriteSellersView favoriteSellersView) {
        this.a = subscribableItem;
        this.b = favoriteSellersView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.setNotificationsLoading(true);
        this.b.setNotificationLoading(true);
    }
}
