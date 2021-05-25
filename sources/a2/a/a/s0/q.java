package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersCacheExpiredException;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.FavoriteSellersResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
public final class q<T, R> implements Function<FavoriteSellersLoadingResult, SingleSource<? extends Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public q(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>> apply(FavoriteSellersLoadingResult favoriteSellersLoadingResult) {
        FavoriteSellersLoadingResult favoriteSellersLoadingResult2 = favoriteSellersLoadingResult;
        if (favoriteSellersLoadingResult2 instanceof FavoriteSellersLoadingResult.Ok) {
            return this.a.y.convert(((FavoriteSellersLoadingResult.Ok) favoriteSellersLoadingResult2).getResult()).map(new p(favoriteSellersLoadingResult2));
        }
        if (favoriteSellersLoadingResult2 instanceof FavoriteSellersLoadingResult.ListExpiredError) {
            return Single.error(new FavoriteSellersCacheExpiredException(((FavoriteSellersLoadingResult.ListExpiredError) favoriteSellersLoadingResult2).getMessage()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
