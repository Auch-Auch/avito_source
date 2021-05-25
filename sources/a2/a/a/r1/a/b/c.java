package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.model.OrdersPagination;
import com.avito.android.remote.orders.model.OrdersPageModel;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<LoadingState<? super OrdersPageModel>, LoadingState<? super OrdersPagination>> {
    public final /* synthetic */ OrdersListViewModel a;

    public c(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super OrdersPagination> apply(LoadingState<? super OrdersPageModel> loadingState) {
        LoadingState<? super OrdersPageModel> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            return new LoadingState.Loaded(new OrdersPagination(((OrdersPageModel) loaded.getData()).getNextPage(), this.a.l.convert(((OrdersPageModel) loaded.getData()).getOrderDataList())));
        }
        LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
        if (Intrinsics.areEqual(loadingState2, loading)) {
            return loading;
        }
        if (loadingState2 instanceof LoadingState.Error) {
            return new LoadingState.Error(((LoadingState.Error) loadingState2).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
