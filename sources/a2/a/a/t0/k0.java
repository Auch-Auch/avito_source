package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import java.util.List;
import java.util.concurrent.Callable;
public final class k0<V> implements Callable<List<? extends String>> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

    public k0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        this.a = favoriteAdvertsServiceInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends String> call() {
        return this.a.c.getAddedToFavoritesIds();
    }
}
