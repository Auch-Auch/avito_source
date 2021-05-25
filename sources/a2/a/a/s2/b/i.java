package a2.a.a.s2.b;

import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<String> {
    public final /* synthetic */ ShopDetailedPresenterImpl a;

    public i(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
        this.a = shopDetailedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        ShopDetailedPresenterImpl shopDetailedPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        ShopDetailedPresenterImpl.access$onQuerySubmitted(shopDetailedPresenterImpl, str2);
    }
}
