package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class d<T, R> implements Function<Unit, ObservableSource<? extends OrdersListViewModel>> {
    public final /* synthetic */ OrdersListViewModel a;

    public d(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends OrdersListViewModel> apply(Unit unit) {
        return this.a.isLoading() ? Observable.empty() : Observable.just(this.a);
    }
}
