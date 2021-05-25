package a2.a.a.t0;

import com.avito.android.favorites.FavoritesListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class v0<T> implements Consumer<Boolean> {
    public final /* synthetic */ FavoritesListPresenterImpl a;

    public v0(FavoritesListPresenterImpl favoritesListPresenterImpl) {
        this.a = favoritesListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        if (bool2.booleanValue()) {
            this.a.e(true);
        }
    }
}
