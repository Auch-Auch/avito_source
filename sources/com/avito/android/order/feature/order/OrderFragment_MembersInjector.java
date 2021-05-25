package com.avito.android.order.feature.order;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class OrderFragment_MembersInjector implements MembersInjector<OrderFragment> {
    public final Provider<OrderViewModel> a;

    public OrderFragment_MembersInjector(Provider<OrderViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<OrderFragment> create(Provider<OrderViewModel> provider) {
        return new OrderFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.order.feature.order.OrderFragment.viewModel")
    public static void injectViewModel(OrderFragment orderFragment, OrderViewModel orderViewModel) {
        orderFragment.viewModel = orderViewModel;
    }

    public void injectMembers(OrderFragment orderFragment) {
        injectViewModel(orderFragment, this.a.get());
    }
}
