package a2.a.a.t0;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class h0<T> implements Consumer<List<? extends FavoriteModel>> {
    public final /* synthetic */ i0 a;

    public h0(i0 i0Var) {
        this.a = i0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends FavoriteModel> list) {
        List<? extends FavoriteModel> list2 = list;
        FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(list2, "items");
        FavoriteAdvertsServiceInteractorImpl.access$saveFavoriteItemsToAdvertsDao(favoriteAdvertsServiceInteractorImpl, list2);
        FavoriteAdvertsServiceInteractorImpl.access$updateLastSyncTime(this.a.a);
    }
}
