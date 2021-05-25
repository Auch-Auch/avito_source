package com.avito.android.payment.lib.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_RecyclerViewDeclarations_ProvideListUpdateListenerFactory implements Factory<ListUpdateCallback> {
    public final Provider<SimpleRecyclerAdapter> a;

    public PaymentMethodsModule_RecyclerViewDeclarations_ProvideListUpdateListenerFactory(Provider<SimpleRecyclerAdapter> provider) {
        this.a = provider;
    }

    public static PaymentMethodsModule_RecyclerViewDeclarations_ProvideListUpdateListenerFactory create(Provider<SimpleRecyclerAdapter> provider) {
        return new PaymentMethodsModule_RecyclerViewDeclarations_ProvideListUpdateListenerFactory(provider);
    }

    public static ListUpdateCallback provideListUpdateListener(SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (ListUpdateCallback) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.RecyclerViewDeclarations.provideListUpdateListener(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public ListUpdateCallback get() {
        return provideListUpdateListener(this.a.get());
    }
}
