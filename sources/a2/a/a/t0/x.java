package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class x<V> implements Callable<Unit> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

    public x(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        this.a = favoriteAdvertsListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        this.a.d.wipe();
        this.a.e.wipe();
        return Unit.INSTANCE;
    }
}
