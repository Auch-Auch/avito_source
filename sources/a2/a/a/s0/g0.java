package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g0<T> implements Consumer<Throwable> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public g0(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        FavoriteSellersPresenterImpl.b(favoriteSellersPresenterImpl, th2, null, 2);
    }
}
