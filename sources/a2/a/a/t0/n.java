package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.remote.model.FavoritesRemoveAllResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class n<T, R> implements Function<FavoritesRemoveAllResponse, List<? extends String>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl.t a;

    public n(FavoriteAdvertsListInteractorImpl.t tVar) {
        this.a = tVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends String> apply(FavoritesRemoveAllResponse favoritesRemoveAllResponse) {
        FavoritesRemoveAllResponse favoritesRemoveAllResponse2 = favoritesRemoveAllResponse;
        Intrinsics.checkNotNullParameter(favoritesRemoveAllResponse2, "it");
        List<String> removedIds = favoritesRemoveAllResponse2.getRemovedIds();
        if (removedIds == null) {
            removedIds = CollectionsKt__CollectionsKt.emptyList();
        }
        this.a.a.e.markForRemove(removedIds, true);
        return removedIds;
    }
}
