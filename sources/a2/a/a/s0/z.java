package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.ViewPortState;
import io.reactivex.rxjava3.functions.Function;
public final class z<T, R> implements Function<ViewPortState, Integer> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public z(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Integer apply(ViewPortState viewPortState) {
        int i;
        ViewPortState viewPortState2 = viewPortState;
        if (viewPortState2.getLastCompletelyVisible() == -1 && viewPortState2.getFirstVisible() == viewPortState2.getLastVisible() && viewPortState2.getFirstVisible() != -1) {
            i = viewPortState2.getFirstVisible();
        } else {
            i = viewPortState2.getLastCompletelyVisible();
        }
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        favoriteSellersPresenterImpl.p = Math.max(favoriteSellersPresenterImpl.p, i);
        return Integer.valueOf(this.a.p);
    }
}
