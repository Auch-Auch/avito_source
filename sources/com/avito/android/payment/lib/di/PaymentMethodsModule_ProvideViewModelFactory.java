package com.avito.android.payment.lib.di;

import android.app.Activity;
import com.avito.android.payment.lib.PaymentMethodsViewModel;
import com.avito.android.payment.lib.PaymentMethodsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_ProvideViewModelFactory implements Factory<PaymentMethodsViewModel> {
    public final Provider<PaymentMethodsViewModelFactory> a;
    public final Provider<Activity> b;

    public PaymentMethodsModule_ProvideViewModelFactory(Provider<PaymentMethodsViewModelFactory> provider, Provider<Activity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaymentMethodsModule_ProvideViewModelFactory create(Provider<PaymentMethodsViewModelFactory> provider, Provider<Activity> provider2) {
        return new PaymentMethodsModule_ProvideViewModelFactory(provider, provider2);
    }

    public static PaymentMethodsViewModel provideViewModel(PaymentMethodsViewModelFactory paymentMethodsViewModelFactory, Activity activity) {
        return (PaymentMethodsViewModel) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.provideViewModel(paymentMethodsViewModelFactory, activity));
    }

    @Override // javax.inject.Provider
    public PaymentMethodsViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
