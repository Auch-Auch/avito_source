package com.avito.android.payment.di.module;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopUpFormModule_ProvideListUpdateListenerFactory implements Factory<ListUpdateCallback> {
    public final TopUpFormModule a;
    public final Provider<SimpleRecyclerAdapter> b;

    public TopUpFormModule_ProvideListUpdateListenerFactory(TopUpFormModule topUpFormModule, Provider<SimpleRecyclerAdapter> provider) {
        this.a = topUpFormModule;
        this.b = provider;
    }

    public static TopUpFormModule_ProvideListUpdateListenerFactory create(TopUpFormModule topUpFormModule, Provider<SimpleRecyclerAdapter> provider) {
        return new TopUpFormModule_ProvideListUpdateListenerFactory(topUpFormModule, provider);
    }

    public static ListUpdateCallback provideListUpdateListener(TopUpFormModule topUpFormModule, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (ListUpdateCallback) Preconditions.checkNotNullFromProvides(topUpFormModule.provideListUpdateListener(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public ListUpdateCallback get() {
        return provideListUpdateListener(this.a, this.b.get());
    }
}
