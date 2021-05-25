package com.avito.android.safedeal.delivery_courier.time_interval_select;

import com.avito.konveyor.ItemBinder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryCourierTimeIntervalSelectFragment_MembersInjector implements MembersInjector<DeliveryCourierTimeIntervalSelectFragment> {
    public final Provider<DeliveryCourierTimeIntervalSelectViewModel> a;
    public final Provider<ItemBinder> b;

    public DeliveryCourierTimeIntervalSelectFragment_MembersInjector(Provider<DeliveryCourierTimeIntervalSelectViewModel> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<DeliveryCourierTimeIntervalSelectFragment> create(Provider<DeliveryCourierTimeIntervalSelectViewModel> provider, Provider<ItemBinder> provider2) {
        return new DeliveryCourierTimeIntervalSelectFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment.itemBinder")
    public static void injectItemBinder(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment, ItemBinder itemBinder) {
        deliveryCourierTimeIntervalSelectFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment.viewModel")
    public static void injectViewModel(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment, DeliveryCourierTimeIntervalSelectViewModel deliveryCourierTimeIntervalSelectViewModel) {
        deliveryCourierTimeIntervalSelectFragment.viewModel = deliveryCourierTimeIntervalSelectViewModel;
    }

    public void injectMembers(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment) {
        injectViewModel(deliveryCourierTimeIntervalSelectFragment, this.a.get());
        injectItemBinder(deliveryCourierTimeIntervalSelectFragment, this.b.get());
    }
}
