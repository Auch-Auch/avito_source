package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T> implements Consumer<Integer> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public a0(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, "visible");
        favoriteSellersPresenterImpl.e(num2.intValue());
    }
}
