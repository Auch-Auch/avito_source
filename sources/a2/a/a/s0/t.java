package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class t<T> implements Consumer<List<? extends FavoriteSellersItem>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public t(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends FavoriteSellersItem> list) {
        this.a.l = false;
        this.a.q = 0;
    }
}
