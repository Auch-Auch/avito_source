package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class o0<T, R> implements Function<Integer, SingleSource<? extends Integer>> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

    public o0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        this.a = favoriteAdvertsServiceInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Integer> apply(Integer num) {
        return this.a.a().map(new n0(num));
    }
}
