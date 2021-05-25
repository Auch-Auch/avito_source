package com.avito.android.orders.feature.list;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00150\u0014j\u0002`\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00150\u0014j\u0002`\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/orders/feature/list/OrdersListRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/orders/feature/list/OrdersListRepository;", "repository", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "c", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "ordersItemConverter", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreObservable;", "d", "Lio/reactivex/rxjava3/core/Observable;", "orderLoadingItemBindsObservable", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "e", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "initialData", "<init>", "(Lcom/avito/android/orders/feature/list/OrdersListRepository;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersListViewModelFactory implements ViewModelProvider.Factory {
    public final OrdersListRepository a;
    public final Analytics b;
    public final OrdersItemConverter c;
    public final Observable<Unit> d;
    public final OrderPage e;

    @Inject
    public OrdersListViewModelFactory(@NotNull OrdersListRepository ordersListRepository, @NotNull Analytics analytics, @NotNull OrdersItemConverter ordersItemConverter, @NotNull Observable<Unit> observable, @NotNull OrderPage orderPage) {
        Intrinsics.checkNotNullParameter(ordersListRepository, "repository");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(ordersItemConverter, "ordersItemConverter");
        Intrinsics.checkNotNullParameter(observable, "orderLoadingItemBindsObservable");
        Intrinsics.checkNotNullParameter(orderPage, "initialData");
        this.a = ordersListRepository;
        this.b = analytics;
        this.c = ordersItemConverter;
        this.d = observable;
        this.e = orderPage;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new OrdersListViewModel(this.a, this.b, this.c, this.d, this.e);
    }
}
