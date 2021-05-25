package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.util.Singles;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.i;
public final class r<T, R> implements Function<List<? extends String>, SingleSource<? extends Object>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

    public r(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        this.a = favoriteAdvertsListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Object> apply(List<? extends String> list) {
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "ids");
        if (!(!list2.isEmpty())) {
            return Singles.toSingle(Unit.INSTANCE);
        }
        Single<T> doOnSuccess = InteropKt.toV2(this.a.c.addToFavorites(CollectionsKt___CollectionsKt.joinToString$default(i.asReversed(list2), ",", null, null, 0, null, null, 62, null))).firstOrError().doOnSuccess(new q(this, list2));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "api.addToFavorites(ids.a…syncDao.markSynced(ids) }");
        return doOnSuccess;
    }
}
