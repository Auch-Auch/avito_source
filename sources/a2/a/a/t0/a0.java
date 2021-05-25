package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T> implements Consumer<Throwable> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl.e a;

    public a0(FavoriteAdvertsServiceInteractorImpl.e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        FavoriteAdvertsServiceInteractorImpl.access$reportEvent(favoriteAdvertsServiceInteractorImpl, new FavoriteAdvertsSyncEvent.Failed(th2));
    }
}
