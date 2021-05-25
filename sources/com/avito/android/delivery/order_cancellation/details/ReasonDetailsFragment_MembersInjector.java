package com.avito.android.delivery.order_cancellation.details;

import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ReasonDetailsFragment_MembersInjector implements MembersInjector<ReasonDetailsFragment> {
    public final Provider<ReasonDetailsViewModel> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<OrderCancellationResourceProvider> d;

    public ReasonDetailsFragment_MembersInjector(Provider<ReasonDetailsViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<OrderCancellationResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ReasonDetailsFragment> create(Provider<ReasonDetailsViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<OrderCancellationResourceProvider> provider4) {
        return new ReasonDetailsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment.adapterPresenter")
    public static void injectAdapterPresenter(ReasonDetailsFragment reasonDetailsFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        reasonDetailsFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(ReasonDetailsFragment reasonDetailsFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        reasonDetailsFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment.resourceProvider")
    public static void injectResourceProvider(ReasonDetailsFragment reasonDetailsFragment, OrderCancellationResourceProvider orderCancellationResourceProvider) {
        reasonDetailsFragment.resourceProvider = orderCancellationResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment.viewModel")
    public static void injectViewModel(ReasonDetailsFragment reasonDetailsFragment, ReasonDetailsViewModel reasonDetailsViewModel) {
        reasonDetailsFragment.viewModel = reasonDetailsViewModel;
    }

    public void injectMembers(ReasonDetailsFragment reasonDetailsFragment) {
        injectViewModel(reasonDetailsFragment, this.a.get());
        injectRecyclerAdapter(reasonDetailsFragment, this.b.get());
        injectAdapterPresenter(reasonDetailsFragment, this.c.get());
        injectResourceProvider(reasonDetailsFragment, this.d.get());
    }
}
