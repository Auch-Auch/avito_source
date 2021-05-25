package a2.a.a.r1.a.b;

import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.model.OrdersPagination;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<LoadingState<? super OrdersPagination>> {
    public final /* synthetic */ OrdersListViewModel a;

    public i(OrdersListViewModel ordersListViewModel) {
        this.a = ordersListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super OrdersPagination> loadingState) {
        LoadingState<? super OrdersPagination> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            OrdersListViewModel.access$handleNewPageLoaded(this.a, (LoadingState.Loaded) loadingState2);
        } else if (loadingState2 instanceof LoadingState.Error) {
            OrdersListViewModel.access$handleLoadingError(this.a, (LoadingState.Error) loadingState2);
        }
    }
}
