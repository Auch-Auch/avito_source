package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class y<T> implements Consumer<Long> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public y(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Long l) {
        this.a.j();
    }
}
