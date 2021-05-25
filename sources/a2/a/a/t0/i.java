package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<List<? extends String>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl.r a;

    public i(FavoriteAdvertsListInteractorImpl.r rVar) {
        this.a = rVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends String> list) {
        List<? extends String> list2 = list;
        FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        FavoriteAdvertsListInteractorImpl.access$reportRemovedFromFavorites(favoriteAdvertsListInteractorImpl, list2, null);
    }
}
