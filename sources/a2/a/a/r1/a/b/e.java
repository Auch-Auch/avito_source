package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<OrdersListViewModel> {
    public final /* synthetic */ OrdersListViewModel a;

    public e(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(OrdersListViewModel ordersListViewModel) {
        this.a.setLoading(true);
    }
}
