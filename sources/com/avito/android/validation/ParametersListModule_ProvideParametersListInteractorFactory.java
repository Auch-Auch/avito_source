package com.avito.android.validation;

import com.avito.android.util.BuildInfo;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideParametersListInteractorFactory implements Factory<ParametersListInteractor> {
    public final ParametersListModule a;
    public final Provider<ParametersValidator> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ValidationLogger> d;
    public final Provider<Formatter<String>> e;
    public final Provider<CategoryParameterStringValueConverter> f;
    public final Provider<BuildInfo> g;

    public ParametersListModule_ProvideParametersListInteractorFactory(ParametersListModule parametersListModule, Provider<ParametersValidator> provider, Provider<SchedulersFactory> provider2, Provider<ValidationLogger> provider3, Provider<Formatter<String>> provider4, Provider<CategoryParameterStringValueConverter> provider5, Provider<BuildInfo> provider6) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static ParametersListModule_ProvideParametersListInteractorFactory create(ParametersListModule parametersListModule, Provider<ParametersValidator> provider, Provider<SchedulersFactory> provider2, Provider<ValidationLogger> provider3, Provider<Formatter<String>> provider4, Provider<CategoryParameterStringValueConverter> provider5, Provider<BuildInfo> provider6) {
        return new ParametersListModule_ProvideParametersListInteractorFactory(parametersListModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ParametersListInteractor provideParametersListInteractor(ParametersListModule parametersListModule, ParametersValidator parametersValidator, SchedulersFactory schedulersFactory, ValidationLogger validationLogger, Formatter<String> formatter, CategoryParameterStringValueConverter categoryParameterStringValueConverter, BuildInfo buildInfo) {
        return (ParametersListInteractor) Preconditions.checkNotNullFromProvides(parametersListModule.provideParametersListInteractor(parametersValidator, schedulersFactory, validationLogger, formatter, categoryParameterStringValueConverter, buildInfo));
    }

    @Override // javax.inject.Provider
    public ParametersListInteractor get() {
        return provideParametersListInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
