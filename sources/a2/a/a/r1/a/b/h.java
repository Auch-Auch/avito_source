package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.model.OrdersPagination;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<LoadingState<? super OrdersPagination>> {
    public final /* synthetic */ OrdersListViewModel a;

    public h(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super OrdersPagination> loadingState) {
        this.a.setLoading(false);
    }
}
