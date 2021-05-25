package com.avito.android.express_cv.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.express_cv.ExpressCvDataConverter;
import com.avito.android.express_cv.ExpressCvRepository;
import com.avito.android.express_cv.ExpressCvResourceProvider;
import com.avito.android.express_cv.ExpressCvViewModelFactory;
import com.avito.android.express_cv.ParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProviderViewModelFactoryFactory implements Factory<ExpressCvViewModelFactory> {
    public final ExpressCvModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ExpressCvRepository> c;
    public final Provider<ExpressCvDataConverter> d;
    public final Provider<LocalPretendInteractor> e;
    public final Provider<ParametersConverter> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<ActivityIntentFactory> h;
    public final Provider<ExpressCvResourceProvider> i;
    public final Provider<Features> j;

    public ExpressCvModule_ProviderViewModelFactoryFactory(ExpressCvModule expressCvModule, Provider<SchedulersFactory> provider, Provider<ExpressCvRepository> provider2, Provider<ExpressCvDataConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<ParametersConverter> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<ExpressCvResourceProvider> provider8, Provider<Features> provider9) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
    }

    public static ExpressCvModule_ProviderViewModelFactoryFactory create(ExpressCvModule expressCvModule, Provider<SchedulersFactory> provider, Provider<ExpressCvRepository> provider2, Provider<ExpressCvDataConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<ParametersConverter> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<ExpressCvResourceProvider> provider8, Provider<Features> provider9) {
        return new ExpressCvModule_ProviderViewModelFactoryFactory(expressCvModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ExpressCvViewModelFactory providerViewModelFactory(ExpressCvModule expressCvModule, SchedulersFactory schedulersFactory, ExpressCvRepository expressCvRepository, ExpressCvDataConverter expressCvDataConverter, LocalPretendInteractor localPretendInteractor, ParametersConverter parametersConverter, DeepLinkIntentFactory deepLinkIntentFactory, ActivityIntentFactory activityIntentFactory, ExpressCvResourceProvider expressCvResourceProvider, Features features) {
        return (ExpressCvViewModelFactory) Preconditions.checkNotNullFromProvides(expressCvModule.providerViewModelFactory(schedulersFactory, expressCvRepository, expressCvDataConverter, localPretendInteractor, parametersConverter, deepLinkIntentFactory, activityIntentFactory, expressCvResourceProvider, features));
    }

    @Override // javax.inject.Provider
    public ExpressCvViewModelFactory get() {
        return providerViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
