package com.avito.android.payment.lib.di;

import com.avito.android.payment.PaymentMethodsContentsComparator;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PaymentMethodsModule_RecyclerViewDeclarations_ProvideContentsComparatorFactory implements Factory<PaymentMethodsContentsComparator> {

    public static final class a {
        public static final PaymentMethodsModule_RecyclerViewDeclarations_ProvideContentsComparatorFactory a = new PaymentMethodsModule_RecyclerViewDeclarations_ProvideContentsComparatorFactory();
    }

    public static PaymentMethodsModule_RecyclerViewDeclarations_ProvideContentsComparatorFactory create() {
        return a.a;
    }

    public static PaymentMethodsContentsComparator provideContentsComparator() {
        return (PaymentMethodsContentsComparator) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.RecyclerViewDeclarations.provideContentsComparator());
    }

    @Override // javax.inject.Provider
    public PaymentMethodsContentsComparator get() {
        return provideContentsComparator();
    }
}
