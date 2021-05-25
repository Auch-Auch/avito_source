package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.SubscribableItem;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class f0<T> implements Consumer<Disposable> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ SubscribableItem b;

    public f0(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, SubscribableItem subscribableItem) {
        this.a = favoriteSellersPresenterImpl;
        this.b = subscribableItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.b.setSubscribeLoading(true);
        FavoriteSellersView favoriteSellersView = this.a.a;
        if (favoriteSellersView != null) {
            favoriteSellersView.dismissUndoSnackbar();
        }
        FavoriteSellersView favoriteSellersView2 = this.a.a;
        if (favoriteSellersView2 != null) {
            favoriteSellersView2.setUnsubscribeLoading(true);
        }
    }
}
