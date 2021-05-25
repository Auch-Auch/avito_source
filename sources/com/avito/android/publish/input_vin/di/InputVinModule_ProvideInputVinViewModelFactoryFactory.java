package com.avito.android.publish.input_vin.di;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.input_vin.InputVinResourceProvider;
import com.avito.android.publish.input_vin.InputVinViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InputVinModule_ProvideInputVinViewModelFactoryFactory implements Factory<InputVinViewModelFactory> {
    public final Provider<PublishParametersInteractor> a;
    public final Provider<CategoryParametersElementConverter> b;
    public final Provider<PublishEventTracker> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<InputVinResourceProvider> e;

    public InputVinModule_ProvideInputVinViewModelFactoryFactory(Provider<PublishParametersInteractor> provider, Provider<CategoryParametersElementConverter> provider2, Provider<PublishEventTracker> provider3, Provider<SchedulersFactory> provider4, Provider<InputVinResourceProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static InputVinModule_ProvideInputVinViewModelFactoryFactory create(Provider<PublishParametersInteractor> provider, Provider<CategoryParametersElementConverter> provider2, Provider<PublishEventTracker> provider3, Provider<SchedulersFactory> provider4, Provider<InputVinResourceProvider> provider5) {
        return new InputVinModule_ProvideInputVinViewModelFactoryFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static InputVinViewModelFactory provideInputVinViewModelFactory(PublishParametersInteractor publishParametersInteractor, CategoryParametersElementConverter categoryParametersElementConverter, PublishEventTracker publishEventTracker, SchedulersFactory schedulersFactory, InputVinResourceProvider inputVinResourceProvider) {
        return (InputVinViewModelFactory) Preconditions.checkNotNullFromProvides(InputVinModule.provideInputVinViewModelFactory(publishParametersInteractor, categoryParametersElementConverter, publishEventTracker, schedulersFactory, inputVinResourceProvider));
    }

    @Override // javax.inject.Provider
    public InputVinViewModelFactory get() {
        return provideInputVinViewModelFactory(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
