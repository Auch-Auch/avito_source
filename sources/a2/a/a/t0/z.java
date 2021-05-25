package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class z<T> implements Consumer<Disposable> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl.e a;

    public z(FavoriteAdvertsServiceInteractorImpl.e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        FavoriteAdvertsServiceInteractorImpl.access$reportEvent(this.a.a, new FavoriteAdvertsSyncEvent.Started());
    }
}
