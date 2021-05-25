package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import io.reactivex.rxjava3.functions.Action;
public final class v implements Action {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public v(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        FavoriteSellersView favoriteSellersView = this.a.a;
        if (favoriteSellersView != null) {
            favoriteSellersView.hideProgress();
        }
    }
}
