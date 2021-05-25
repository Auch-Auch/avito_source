package a2.a.a.s0;

import android.net.Uri;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItem;
import com.avito.android.remote.model.FavoriteSellersResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class s<T, R> implements Function<Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>>, List<? extends FavoriteSellersItem>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public s(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends FavoriteSellersItem> apply(Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>> pair) {
        Pair<? extends FavoriteSellersResult, ? extends List<? extends FavoriteSellersItem>> pair2 = pair;
        FavoriteSellersResult favoriteSellersResult = (FavoriteSellersResult) pair2.component1();
        List<? extends FavoriteSellersItem> list = (List) pair2.component2();
        this.a.G.setResult(favoriteSellersResult);
        Uri nextPage = favoriteSellersResult.getNextPage();
        if (nextPage == null) {
            return list;
        }
        Intrinsics.checkNotNullExpressionValue(list, "items");
        return CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) list, new LoadingItem(nextPage));
    }
}
