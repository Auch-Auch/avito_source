package a2.a.a.s2.b;

import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class j<T> implements Consumer<Unit> {
    public final /* synthetic */ ShopDetailedPresenterImpl a;

    public j(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
        this.a = shopDetailedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        ShopDetailedPresenter.Router router = this.a.h;
        if (router != null) {
            router.onBackClicked();
        }
    }
}
