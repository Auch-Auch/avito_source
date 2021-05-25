package com.avito.android.orders.di.component;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.orders.di.module.OrdersModule;
import com.avito.android.orders.feature.host.OrdersFragment;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/orders/di/component/OrdersHostComponent;", "", "Lcom/avito/android/orders/feature/host/OrdersFragment;", "fragment", "", "inject", "(Lcom/avito/android/orders/feature/host/OrdersFragment;)V", "Factory", "orders_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {OrdersDependencies.class}, modules = {OrdersModule.class})
@PerFragment
public interface OrdersHostComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JC\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/orders/di/component/OrdersHostComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/View;", "view", "", "initialTab", "ordersToPrefetch", "Lcom/avito/android/orders/di/component/OrdersDependencies;", "ordersDependencies", "Lcom/avito/android/orders/di/component/OrdersHostComponent;", "create", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/orders/di/component/OrdersDependencies;)Lcom/avito/android/orders/di/component/OrdersHostComponent;", "orders_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        OrdersHostComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull View view, @BindsInstance @Named("initial_tab") @Nullable String str, @BindsInstance @Named("orders_to_prefetch") @Nullable String str2, @NotNull OrdersDependencies ordersDependencies);
    }

    void inject(@NotNull OrdersFragment ordersFragment);
}
