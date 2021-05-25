package com.avito.android.orders.di.component;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.orders.di.module.OrdersListModule;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.orders.feature.list.OrdersListFragment;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/orders/di/component/OrdersListFragmentComponent;", "", "Lcom/avito/android/orders/feature/list/OrdersListFragment;", "fragment", "", "inject", "(Lcom/avito/android/orders/feature/list/OrdersListFragment;)V", "Factory", "orders_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {OrdersDependencies.class}, modules = {OrdersListModule.class})
@PerFragment
public interface OrdersListFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J]\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0012\b\u0001\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n2\u0012\b\u0001\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\f0\bj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/orders/di/component/OrdersListFragmentComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/View;", "view", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "initialData", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreRelay;", "ordersLoadMoreRelay", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksRelay;", "orderItemClicksRelay", "Lcom/avito/android/orders/di/component/OrdersDependencies;", "ordersDependencies", "Lcom/avito/android/orders/di/component/OrdersListFragmentComponent;", "create", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/avito/android/orders/di/component/OrdersDependencies;)Lcom/avito/android/orders/di/component/OrdersListFragmentComponent;", "orders_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        OrdersListFragmentComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull View view, @BindsInstance @NotNull OrderPage orderPage, @BindsInstance @NotNull PublishRelay<Unit> publishRelay, @BindsInstance @NotNull PublishRelay<OrderItem> publishRelay2, @NotNull OrdersDependencies ordersDependencies);
    }

    void inject(@NotNull OrdersListFragment ordersListFragment);
}
