package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.remote.model.FavoritesRemoveAllResponse;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<FavoritesRemoveAllResponse, ObservableSource<? extends Unit>> {
    public final /* synthetic */ f a;

    public d(f fVar) {
        this.a = fVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Unit> apply(FavoritesRemoveAllResponse favoritesRemoveAllResponse) {
        Intrinsics.checkNotNullParameter(favoritesRemoveAllResponse, "it");
        return FavoriteAdvertsListInteractorImpl.access$wipeLocalAdverts(this.a.a.a);
    }
}
