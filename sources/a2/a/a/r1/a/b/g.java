package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.model.OrdersPagination;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<String, ObservableSource<? extends LoadingState<? super OrdersPagination>>> {
    public final /* synthetic */ OrdersListViewModel a;

    public g(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadingState<? super OrdersPagination>> apply(String str) {
        String str2 = str;
        OrdersListViewModel ordersListViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        return OrdersListViewModel.access$fetchNextPage(ordersListViewModel, str2);
    }
}
