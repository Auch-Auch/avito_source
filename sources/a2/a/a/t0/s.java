package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class s<T, R> implements Function<Object, SingleSource<? extends Unit>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

    public s(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        this.a = favoriteAdvertsListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Unit> apply(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return FavoriteAdvertsListInteractorImpl.access$uploadRemovedIds(this.a);
    }
}
