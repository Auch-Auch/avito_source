package com.avito.android.payment.di.module;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final PaymentGenericFormModule a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public PaymentGenericFormModule_ProvideRecyclerAdapterFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = paymentGenericFormModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PaymentGenericFormModule_ProvideRecyclerAdapterFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new PaymentGenericFormModule_ProvideRecyclerAdapterFactory(paymentGenericFormModule, provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(PaymentGenericFormModule paymentGenericFormModule, DataAwareAdapterPresenter dataAwareAdapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideRecyclerAdapter(dataAwareAdapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a, this.b.get(), this.c.get());
    }
}
