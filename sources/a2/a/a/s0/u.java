package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class u<T> implements Consumer<Throwable> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public u(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        FavoriteSellersPresenterImpl.access$updateVisibleContent(favoriteSellersPresenterImpl, th2);
    }
}
