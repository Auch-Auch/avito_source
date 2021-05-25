package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.remote.model.FavoriteSellersResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Pair;
public final class r<T, R> implements Function<Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>, SingleSource<? extends Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public r(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>> apply(Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>> pair) {
        return this.a.s.executeCounterUpdate().andThen(Single.just(pair));
    }
}
