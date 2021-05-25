package a2.a.a.t0;

import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class u<T> implements Consumer<SuccessResult> {
    public final /* synthetic */ w a;
    public final /* synthetic */ List b;

    public u(w wVar, List list) {
        this.a = wVar;
        this.b = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SuccessResult successResult) {
        FavoritesSyncDao favoritesSyncDao = this.a.a.e;
        List<String> list = this.b;
        Intrinsics.checkNotNullExpressionValue(list, "ids");
        favoritesSyncDao.markSynced(list);
    }
}
