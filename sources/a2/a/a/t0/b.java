package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import java.util.List;
import java.util.concurrent.Callable;
public final class b<V> implements Callable<List<? extends String>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

    public b(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        this.a = favoriteAdvertsListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends String> call() {
        return this.a.d.getInactiveIds();
    }
}
