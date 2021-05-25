package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentStatusFormModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final PaymentStatusFormModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public PaymentStatusFormModule_ProvideRecyclerAdapterFactory(PaymentStatusFormModule paymentStatusFormModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = paymentStatusFormModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PaymentStatusFormModule_ProvideRecyclerAdapterFactory create(PaymentStatusFormModule paymentStatusFormModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new PaymentStatusFormModule_ProvideRecyclerAdapterFactory(paymentStatusFormModule, provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(PaymentStatusFormModule paymentStatusFormModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(paymentStatusFormModule.provideRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a, this.b.get(), this.c.get());
    }
}
