package com.avito.android.validation;

import com.avito.android.Features;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ParametersListModule_ProvideParametersListPresenterFactory implements Factory<ParametersListPresenter> {
    public final ParametersListModule a;
    public final Provider<ParametersListInteractor> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<Set<ItemPresenter<?, ?>>> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<Features> f;

    public ParametersListModule_ProvideParametersListPresenterFactory(ParametersListModule parametersListModule, Provider<ParametersListInteractor> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<SchedulersFactory> provider4, Provider<Features> provider5) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static ParametersListModule_ProvideParametersListPresenterFactory create(ParametersListModule parametersListModule, Provider<ParametersListInteractor> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<SchedulersFactory> provider4, Provider<Features> provider5) {
        return new ParametersListModule_ProvideParametersListPresenterFactory(parametersListModule, provider, provider2, provider3, provider4, provider5);
    }

    public static ParametersListPresenter provideParametersListPresenter(ParametersListModule parametersListModule, ParametersListInteractor parametersListInteractor, DataAwareAdapterPresenter dataAwareAdapterPresenter, Set<ItemPresenter<?, ?>> set, SchedulersFactory schedulersFactory, Features features) {
        return (ParametersListPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideParametersListPresenter(parametersListInteractor, dataAwareAdapterPresenter, set, schedulersFactory, features));
    }

    @Override // javax.inject.Provider
    public ParametersListPresenter get() {
        return provideParametersListPresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
