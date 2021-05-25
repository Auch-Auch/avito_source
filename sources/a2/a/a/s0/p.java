package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.FavoriteSellersResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class p<T, R> implements Function<List<? extends FavoriteSellersItem>, Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>> {
    public final /* synthetic */ FavoriteSellersLoadingResult a;

    public p(FavoriteSellersLoadingResult favoriteSellersLoadingResult) {
        this.a = favoriteSellersLoadingResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>> apply(List<? extends FavoriteSellersItem> list) {
        return TuplesKt.to(((FavoriteSellersLoadingResult.Ok) this.a).getResult(), list);
    }
}
