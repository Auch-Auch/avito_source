package a2.a.a.b0;

import com.avito.android.analytics.event.cart.OpenCartEvent;
import com.avito.android.cart_fab.CartFabViewModelImpl;
import com.avito.android.util.SearchContextWrapper;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Integer> {
    public final /* synthetic */ CartFabViewModelImpl a;

    public d(CartFabViewModelImpl cartFabViewModelImpl) {
        this.a = cartFabViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        this.a.l.track(new OpenCartEvent(null, OpenCartEvent.Source.CART_FAB, num, (SearchContextWrapper) this.a.m.orNull()));
    }
}
