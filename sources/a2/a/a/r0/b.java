package a2.a.a.r0;

import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ FavoriteAdvertsInteractorImpl.d a;

    public b(FavoriteAdvertsInteractorImpl.d dVar) {
        this.a = dVar;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.a.c.acceptEvent(new FavoriteAdvertsEvent.FavoritesFull());
    }
}
