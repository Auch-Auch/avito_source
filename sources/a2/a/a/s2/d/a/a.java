package a2.a.a.s2.d.a;

import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.shop.list.business.ShopListInfo;
import com.avito.android.shop.list.business.ShopListInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
public final class a<T, R> implements Function<Pair<? extends ShopsListResult, ? extends Shortcuts>, LoadingState<? super ShopListInfo>> {
    public final /* synthetic */ ShopListInteractorImpl a;

    public a(ShopListInteractorImpl shopListInteractorImpl) {
        this.a = shopListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super ShopListInfo> apply(Pair<? extends ShopsListResult, ? extends Shortcuts> pair) {
        Pair<? extends ShopsListResult, ? extends Shortcuts> pair2 = pair;
        ShopListInteractorImpl.access$saveResults(this.a, (ShopsListResult) pair2.getFirst(), (Shortcuts) pair2.getSecond());
        return this.a.a();
    }
}
