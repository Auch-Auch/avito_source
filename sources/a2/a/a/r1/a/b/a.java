package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListRepository;
import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.model.OrdersPageModel;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<String, SingleSource<? extends TypedResult<OrdersPageModel>>> {
    public final /* synthetic */ OrdersListViewModel a;

    public a(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends TypedResult<OrdersPageModel>> apply(String str) {
        String str2 = str;
        OrdersListRepository ordersListRepository = this.a.j;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        return ordersListRepository.loadOrdersNextPage(str2);
    }
}
