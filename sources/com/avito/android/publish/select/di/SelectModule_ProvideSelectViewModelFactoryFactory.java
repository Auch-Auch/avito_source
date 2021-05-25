package com.avito.android.publish.select.di;

import com.avito.android.publish.select.SelectViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectModule_ProvideSelectViewModelFactoryFactory implements Factory<SelectViewModelFactory> {
    public final SelectModule a;
    public final Provider<SchedulersFactory> b;

    public SelectModule_ProvideSelectViewModelFactoryFactory(SelectModule selectModule, Provider<SchedulersFactory> provider) {
        this.a = selectModule;
        this.b = provider;
    }

    public static SelectModule_ProvideSelectViewModelFactoryFactory create(SelectModule selectModule, Provider<SchedulersFactory> provider) {
        return new SelectModule_ProvideSelectViewModelFactoryFactory(selectModule, provider);
    }

    public static SelectViewModelFactory provideSelectViewModelFactory(SelectModule selectModule, SchedulersFactory schedulersFactory) {
        return (SelectViewModelFactory) Preconditions.checkNotNullFromProvides(selectModule.provideSelectViewModelFactory(schedulersFactory));
    }

    @Override // javax.inject.Provider
    public SelectViewModelFactory get() {
        return provideSelectViewModelFactory(this.a, this.b.get());
    }
}
