package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentStatusFormModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final PaymentStatusFormModule a;
    public final Provider<ItemBinder> b;

    public PaymentStatusFormModule_ProvideAdapterPresenterFactory(PaymentStatusFormModule paymentStatusFormModule, Provider<ItemBinder> provider) {
        this.a = paymentStatusFormModule;
        this.b = provider;
    }

    public static PaymentStatusFormModule_ProvideAdapterPresenterFactory create(PaymentStatusFormModule paymentStatusFormModule, Provider<ItemBinder> provider) {
        return new PaymentStatusFormModule_ProvideAdapterPresenterFactory(paymentStatusFormModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(PaymentStatusFormModule paymentStatusFormModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(paymentStatusFormModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
