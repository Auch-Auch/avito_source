package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Consumer<Unit> {
    public final /* synthetic */ m a;
    public final /* synthetic */ List b;

    public l(m mVar, List list) {
        this.a = mVar;
        this.b = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl = this.a.a.a;
        List list = this.b;
        Intrinsics.checkNotNullExpressionValue(list, "inactiveIds");
        FavoriteAdvertsListInteractorImpl.access$reportRemovedFromFavorites(favoriteAdvertsListInteractorImpl, list, null);
    }
}
