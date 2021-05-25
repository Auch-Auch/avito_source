package com.avito.android.delivery.summary.change_contacts;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryRdsEditContactsDialog_MembersInjector implements MembersInjector<DeliveryRdsEditContactsDialog> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<DeliveryRdsEditContactsViewModel> c;

    public DeliveryRdsEditContactsDialog_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<DeliveryRdsEditContactsViewModel> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<DeliveryRdsEditContactsDialog> create(Provider<SimpleRecyclerAdapter> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<DeliveryRdsEditContactsViewModel> provider3) {
        return new DeliveryRdsEditContactsDialog_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        deliveryRdsEditContactsDialog.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog.recyclerAdapter")
    public static void injectRecyclerAdapter(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        deliveryRdsEditContactsDialog.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog.viewModel")
    public static void injectViewModel(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog, DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel) {
        deliveryRdsEditContactsDialog.viewModel = deliveryRdsEditContactsViewModel;
    }

    public void injectMembers(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog) {
        injectRecyclerAdapter(deliveryRdsEditContactsDialog, this.a.get());
        injectAdapterPresenter(deliveryRdsEditContactsDialog, this.b.get());
        injectViewModel(deliveryRdsEditContactsDialog, this.c.get());
    }
}
