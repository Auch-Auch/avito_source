package a2.a.a.s2.b;

import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl;
import com.avito.android.shop.detailed.ShopNotFoundException;
import com.avito.android.shop.detailed.remote.ShopDetailedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<ShopDetailedResult, ObservableSource<? extends ShopElement>> {
    public final /* synthetic */ ShopDetailedInteractorImpl a;

    public e(ShopDetailedInteractorImpl shopDetailedInteractorImpl) {
        this.a = shopDetailedInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends ShopElement> apply(ShopDetailedResult shopDetailedResult) {
        ShopDetailedResult shopDetailedResult2 = shopDetailedResult;
        if (shopDetailedResult2 instanceof ShopDetailedResult.Ok) {
            ShopDetailedResult.Ok ok = (ShopDetailedResult.Ok) shopDetailedResult2;
            this.a.a = ok.getShopDetailed();
            Observable just = Observable.just(ok.getShopDetailed());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        } else if (shopDetailedResult2 instanceof ShopDetailedResult.NotFound) {
            return Observable.error(new ShopNotFoundException(((ShopDetailedResult.NotFound) shopDetailedResult2).getMessage()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
