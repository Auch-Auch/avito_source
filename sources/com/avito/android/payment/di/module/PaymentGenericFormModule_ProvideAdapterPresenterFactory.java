package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final PaymentGenericFormModule a;
    public final Provider<ItemBinder> b;

    public PaymentGenericFormModule_ProvideAdapterPresenterFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<ItemBinder> provider) {
        this.a = paymentGenericFormModule;
        this.b = provider;
    }

    public static PaymentGenericFormModule_ProvideAdapterPresenterFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<ItemBinder> provider) {
        return new PaymentGenericFormModule_ProvideAdapterPresenterFactory(paymentGenericFormModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(PaymentGenericFormModule paymentGenericFormModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
