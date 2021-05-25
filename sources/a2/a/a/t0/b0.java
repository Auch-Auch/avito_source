package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import java.util.List;
import java.util.concurrent.Callable;
public final class b0<V> implements Callable<Integer> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

    public b0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        this.a = favoriteAdvertsServiceInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        List<String> markedForRemoveIds = this.a.c.getMarkedForRemoveIds();
        this.a.c.remove(markedForRemoveIds);
        this.a.d.remove(markedForRemoveIds);
        return Integer.valueOf(markedForRemoveIds.size());
    }
}
