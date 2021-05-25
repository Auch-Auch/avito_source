package a2.a.a.t0;

import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class p0<T, R> implements Function<SuccessResult, Integer> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl.i a;
    public final /* synthetic */ List b;

    public p0(FavoriteAdvertsServiceInteractorImpl.i iVar, List list) {
        this.a = iVar;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Integer apply(SuccessResult successResult) {
        FavoritesSyncDao favoritesSyncDao = this.a.a.c;
        List<String> list = this.b;
        Intrinsics.checkNotNullExpressionValue(list, "ids");
        favoritesSyncDao.markSynced(list);
        return Integer.valueOf(this.b.size());
    }
}
