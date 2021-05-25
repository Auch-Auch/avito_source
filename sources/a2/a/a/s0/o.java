package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.performance.ContentTracker;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class o<T> implements Consumer<Disposable> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ boolean b;

    public o(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, boolean z) {
        this.a = favoriteSellersPresenterImpl;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        FavoriteSellersView favoriteSellersView;
        if (!this.b && (favoriteSellersView = this.a.a) != null) {
            favoriteSellersView.showProgress();
        }
        this.a.H.loading(ContentTracker.StorageType.Remote);
        this.a.s.clearSellers();
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        favoriteSellersPresenterImpl.e(favoriteSellersPresenterImpl.p);
    }
}
