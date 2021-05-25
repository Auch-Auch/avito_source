package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final ExpressCvModule a;
    public final Provider<Activity> b;

    public ExpressCvModule_ProvideLocalPretendInteractorResourceProviderFactory(ExpressCvModule expressCvModule, Provider<Activity> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideLocalPretendInteractorResourceProviderFactory create(ExpressCvModule expressCvModule, Provider<Activity> provider) {
        return new ExpressCvModule_ProvideLocalPretendInteractorResourceProviderFactory(expressCvModule, provider);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(ExpressCvModule expressCvModule, Activity activity) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(expressCvModule.provideLocalPretendInteractorResourceProvider(activity));
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a, this.b.get());
    }
}
