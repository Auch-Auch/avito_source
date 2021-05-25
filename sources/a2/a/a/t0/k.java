package a2.a.a.t0;

import com.avito.android.remote.model.FavoritesRemoveAllResponse;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<FavoritesRemoveAllResponse, Unit> {
    public static final k a = new k();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(FavoritesRemoveAllResponse favoritesRemoveAllResponse) {
        Intrinsics.checkNotNullParameter(favoritesRemoveAllResponse, "it");
        return Unit.INSTANCE;
    }
}
