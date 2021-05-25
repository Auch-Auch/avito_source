package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
public final class f<T, R> implements Function<OrdersListViewModel, ObservableSource<? extends String>> {
    public final /* synthetic */ OrdersListViewModel a;

    public f(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends String> apply(OrdersListViewModel ordersListViewModel) {
        this.a.c();
        this.a.d();
        String nextPage = this.a.g.getNextPage();
        if (nextPage == null || nextPage.length() == 0) {
            return Observable.empty();
        }
        return Observable.just(nextPage);
    }
}
