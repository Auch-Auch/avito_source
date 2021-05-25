package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenter;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public b(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        FavoriteSellersPresenter.Router router = this.a.b;
        if (router != null) {
            router.openNotificationsSettings();
        }
    }
}
