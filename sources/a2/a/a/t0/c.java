package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class c<V> implements Callable<Unit> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;
    public final /* synthetic */ List b;

    public c(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, List list) {
        this.a = favoriteAdvertsListInteractorImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        this.a.d.remove(this.b);
        this.a.e.remove(this.b);
        return Unit.INSTANCE;
    }
}
