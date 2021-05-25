package com.avito.android.order.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.order.feature.order.OrderFragment;
import com.avito.android.order.feature.order.OrderRepository;
import com.avito.android.order.feature.order.OrderRepositoryImpl;
import com.avito.android.order.feature.order.OrderViewModel;
import com.avito.android.order.feature.order.OrderViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/order/di/module/OrderModule;", "", "Lcom/avito/android/order/feature/order/OrderFragment;", "fragment", "Lcom/avito/android/order/feature/order/OrderViewModelFactory;", "viewModelFactory", "Lcom/avito/android/order/feature/order/OrderViewModel;", "provideViewModel$order_release", "(Lcom/avito/android/order/feature/order/OrderFragment;Lcom/avito/android/order/feature/order/OrderViewModelFactory;)Lcom/avito/android/order/feature/order/OrderViewModel;", "provideViewModel", "<init>", "()V", "Dependencies", "order_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class OrderModule {
    @NotNull
    public static final OrderModule INSTANCE = new OrderModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/order/di/module/OrderModule$Dependencies;", "", "Lcom/avito/android/order/feature/order/OrderRepositoryImpl;", "orderRepository", "Lcom/avito/android/order/feature/order/OrderRepository;", "bindsOrderRepository", "(Lcom/avito/android/order/feature/order/OrderRepositoryImpl;)Lcom/avito/android/order/feature/order/OrderRepository;", "order_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @Binds
        @NotNull
        OrderRepository bindsOrderRepository(@NotNull OrderRepositoryImpl orderRepositoryImpl);
    }

    @Provides
    @NotNull
    public final OrderViewModel provideViewModel$order_release(@NotNull OrderFragment orderFragment, @NotNull OrderViewModelFactory orderViewModelFactory) {
        Intrinsics.checkNotNullParameter(orderFragment, "fragment");
        Intrinsics.checkNotNullParameter(orderViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(orderFragment, orderViewModelFactory).get(OrderViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…derViewModel::class.java)");
        return (OrderViewModel) viewModel;
    }
}
