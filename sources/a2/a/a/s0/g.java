package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessor;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<List<? extends FavoriteSellersItem>, List<? extends FavoriteSellersItem>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public g(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends FavoriteSellersItem> apply(List<? extends FavoriteSellersItem> list) {
        List<? extends FavoriteSellersItem> list2 = list;
        FavoriteSellerAdvertsStatusProcessor favoriteSellerAdvertsStatusProcessor = this.a.z;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return favoriteSellerAdvertsStatusProcessor.updateStatuses(list2);
    }
}
