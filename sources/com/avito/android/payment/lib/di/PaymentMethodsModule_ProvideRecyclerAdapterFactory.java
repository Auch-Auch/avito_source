package com.avito.android.payment.lib.di;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public PaymentMethodsModule_ProvideRecyclerAdapterFactory(Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaymentMethodsModule_ProvideRecyclerAdapterFactory create(Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new PaymentMethodsModule_ProvideRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(DataAwareAdapterPresenter dataAwareAdapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.provideRecyclerAdapter(dataAwareAdapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a.get(), this.b.get());
    }
}
