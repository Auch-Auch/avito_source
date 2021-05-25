package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
public final class y<T, R> implements Function<Integer, CompletableSource> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl.a a;

    public y(FavoriteAdvertsServiceInteractorImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Integer num) {
        return FavoriteAdvertsServiceInteractorImpl.access$updateFavoriteAdverts(this.a.a);
    }
}
