package com.avito.android.payment.di.module;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideListUpdateListenerFactory implements Factory<ListUpdateCallback> {
    public final PaymentGenericFormModule a;
    public final Provider<SimpleRecyclerAdapter> b;

    public PaymentGenericFormModule_ProvideListUpdateListenerFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<SimpleRecyclerAdapter> provider) {
        this.a = paymentGenericFormModule;
        this.b = provider;
    }

    public static PaymentGenericFormModule_ProvideListUpdateListenerFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<SimpleRecyclerAdapter> provider) {
        return new PaymentGenericFormModule_ProvideListUpdateListenerFactory(paymentGenericFormModule, provider);
    }

    public static ListUpdateCallback provideListUpdateListener(PaymentGenericFormModule paymentGenericFormModule, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (ListUpdateCallback) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideListUpdateListener(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public ListUpdateCallback get() {
        return provideListUpdateListener(this.a, this.b.get());
    }
}
