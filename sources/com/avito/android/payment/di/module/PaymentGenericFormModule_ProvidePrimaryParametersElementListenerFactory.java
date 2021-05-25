package com.avito.android.payment.di.module;

import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.payment.form.PaymentGenericFormPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvidePrimaryParametersElementListenerFactory implements Factory<PrimaryParametersListener> {
    public final PaymentGenericFormModule a;
    public final Provider<PaymentGenericFormPresenter> b;

    public PaymentGenericFormModule_ProvidePrimaryParametersElementListenerFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<PaymentGenericFormPresenter> provider) {
        this.a = paymentGenericFormModule;
        this.b = provider;
    }

    public static PaymentGenericFormModule_ProvidePrimaryParametersElementListenerFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<PaymentGenericFormPresenter> provider) {
        return new PaymentGenericFormModule_ProvidePrimaryParametersElementListenerFactory(paymentGenericFormModule, provider);
    }

    public static PrimaryParametersListener providePrimaryParametersElementListener(PaymentGenericFormModule paymentGenericFormModule, PaymentGenericFormPresenter paymentGenericFormPresenter) {
        return (PrimaryParametersListener) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.providePrimaryParametersElementListener(paymentGenericFormPresenter));
    }

    @Override // javax.inject.Provider
    public PrimaryParametersListener get() {
        return providePrimaryParametersElementListener(this.a, this.b.get());
    }
}
