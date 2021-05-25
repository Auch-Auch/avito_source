package a2.a.a.t0;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.remote.model.FavoritesResponse;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class g0<T, R> implements Function<FavoritesResponse, List<? extends FavoriteModel>> {
    public final /* synthetic */ i0 a;

    public g0(i0 i0Var) {
        this.a = i0Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends FavoriteModel> apply(FavoritesResponse favoritesResponse) {
        FavoritesResponse favoritesResponse2 = favoritesResponse;
        return this.a.a.i.convert(favoritesResponse2.getFavorites(), favoritesResponse2.getReferences());
    }
}
