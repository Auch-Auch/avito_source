package a2.a.a.t0;

import com.avito.android.favorite.FavoriteModel;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class j0<T, R> implements Function<List<? extends FavoriteModel>, CompletableSource> {
    public static final j0 a = new j0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(List<? extends FavoriteModel> list) {
        return Completable.complete();
    }
}
