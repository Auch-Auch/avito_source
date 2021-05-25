package com.avito.android.payment.di.module;

import com.avito.android.payment.form.PaymentGenericFormItemsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PaymentGenericFormModule_ProvideContentsComparatorFactory implements Factory<PaymentGenericFormItemsComparator> {
    public final PaymentGenericFormModule a;

    public PaymentGenericFormModule_ProvideContentsComparatorFactory(PaymentGenericFormModule paymentGenericFormModule) {
        this.a = paymentGenericFormModule;
    }

    public static PaymentGenericFormModule_ProvideContentsComparatorFactory create(PaymentGenericFormModule paymentGenericFormModule) {
        return new PaymentGenericFormModule_ProvideContentsComparatorFactory(paymentGenericFormModule);
    }

    public static PaymentGenericFormItemsComparator provideContentsComparator(PaymentGenericFormModule paymentGenericFormModule) {
        return (PaymentGenericFormItemsComparator) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideContentsComparator());
    }

    @Override // javax.inject.Provider
    public PaymentGenericFormItemsComparator get() {
        return provideContentsComparator(this.a);
    }
}
