package a2.a.a.t0;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.favorites.remote.FavoritesApi;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class i0<T, R> implements Function<List<? extends String>, ObservableSource<? extends List<? extends FavoriteModel>>> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

    public i0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        this.a = favoriteAdvertsServiceInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends List<? extends FavoriteModel>> apply(List<? extends String> list) {
        List<? extends String> list2 = list;
        FavoritesApi favoritesApi = this.a.a;
        Intrinsics.checkNotNullExpressionValue(list2, "ids");
        return favoritesApi.getFavoritesByIds(CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, null, 62, null)).map(new g0(this)).doAfterNext(new h0(this));
    }
}
