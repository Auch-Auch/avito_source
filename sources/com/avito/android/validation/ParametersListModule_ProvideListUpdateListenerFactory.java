package com.avito.android.validation;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideListUpdateListenerFactory implements Factory<ListUpdateCallback> {
    public final ParametersListModule a;
    public final Provider<SimpleRecyclerAdapter> b;

    public ParametersListModule_ProvideListUpdateListenerFactory(ParametersListModule parametersListModule, Provider<SimpleRecyclerAdapter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideListUpdateListenerFactory create(ParametersListModule parametersListModule, Provider<SimpleRecyclerAdapter> provider) {
        return new ParametersListModule_ProvideListUpdateListenerFactory(parametersListModule, provider);
    }

    public static ListUpdateCallback provideListUpdateListener(ParametersListModule parametersListModule, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return (ListUpdateCallback) Preconditions.checkNotNullFromProvides(parametersListModule.provideListUpdateListener(simpleRecyclerAdapter));
    }

    @Override // javax.inject.Provider
    public ListUpdateCallback get() {
        return provideListUpdateListener(this.a, this.b.get());
    }
}
