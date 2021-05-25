package com.avito.android.order.di.component;

import com.avito.android.di.PerFragment;
import com.avito.android.order.di.module.OrderModule;
import com.avito.android.order.feature.order.OrderFragment;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/order/di/component/OrderComponent;", "", "Lcom/avito/android/order/feature/order/OrderFragment;", "fragment", "", "inject", "(Lcom/avito/android/order/feature/order/OrderFragment;)V", "Factory", "order_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {OrderDependencies.class}, modules = {OrderModule.class})
@PerFragment
public interface OrderComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/order/di/component/OrderComponent$Factory;", "", "Lcom/avito/android/order/feature/order/OrderFragment;", "fragment", "", AnalyticFieldsName.orderId, "Lcom/avito/android/order/di/component/OrderDependencies;", "orderDependencies", "Lcom/avito/android/order/di/component/OrderComponent;", "create", "(Lcom/avito/android/order/feature/order/OrderFragment;Ljava/lang/String;Lcom/avito/android/order/di/component/OrderDependencies;)Lcom/avito/android/order/di/component/OrderComponent;", "order_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        OrderComponent create(@BindsInstance @NotNull OrderFragment orderFragment, @BindsInstance @Named("order_id") @NotNull String str, @NotNull OrderDependencies orderDependencies);
    }

    void inject(@NotNull OrderFragment orderFragment);
}
