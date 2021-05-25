package com.avito.android.order.di.component;

import com.avito.android.order.di.component.OrderComponent;
import com.avito.android.order.di.module.OrderModule_ProvideViewModel$order_releaseFactory;
import com.avito.android.order.feature.order.OrderFragment;
import com.avito.android.order.feature.order.OrderFragment_MembersInjector;
import com.avito.android.order.feature.order.OrderRepositoryImpl;
import com.avito.android.order.feature.order.OrderViewModelFactory;
import com.avito.android.remote.order.OrderApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Preconditions;
public final class DaggerOrderComponent implements OrderComponent {
    public final OrderFragment a;
    public final OrderDependencies b;
    public final String c;

    public static final class b implements OrderComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.order.di.component.OrderComponent.Factory
        public OrderComponent create(OrderFragment orderFragment, String str, OrderDependencies orderDependencies) {
            Preconditions.checkNotNull(orderFragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(orderDependencies);
            return new DaggerOrderComponent(orderDependencies, orderFragment, str, null);
        }
    }

    public DaggerOrderComponent(OrderDependencies orderDependencies, OrderFragment orderFragment, String str, a aVar) {
        this.a = orderFragment;
        this.b = orderDependencies;
        this.c = str;
    }

    public static OrderComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.order.di.component.OrderComponent
    public void inject(OrderFragment orderFragment) {
        OrderFragment_MembersInjector.injectViewModel(orderFragment, OrderModule_ProvideViewModel$order_releaseFactory.provideViewModel$order_release(this.a, new OrderViewModelFactory(new OrderRepositoryImpl((OrderApi) Preconditions.checkNotNullFromComponent(this.b.orderApi()), this.c, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3())))));
    }
}
