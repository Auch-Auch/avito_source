package a2.a.a.s0;

import android.net.Uri;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Consumer<Throwable> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ Uri b;

    public n(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Uri uri) {
        this.a = favoriteSellersPresenterImpl;
        this.b = uri;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        FavoriteSellersPresenterImpl.access$onLoadNextItemsError(favoriteSellersPresenterImpl, th2, this.b);
    }
}
