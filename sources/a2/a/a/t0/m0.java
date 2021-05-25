package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.i;
public final class m0<T, R> implements Function<List<? extends String>, SingleSource<? extends Integer>> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

    public m0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        this.a = favoriteAdvertsServiceInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Integer> apply(List<? extends String> list) {
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "ids");
        if (!list2.isEmpty()) {
            return this.a.a.addToFavorites(CollectionsKt___CollectionsKt.joinToString$default(i.asReversed(list2), ",", null, null, 0, null, null, 62, null)).firstOrError().map(new l0(this, list2));
        }
        return Single.just(Integer.valueOf(list2.size()));
    }
}
