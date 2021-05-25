package com.avito.android.express_cv.di;

import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideLocalPretendInteractorFactory implements Factory<LocalPretendInteractor> {
    public final ExpressCvModule a;
    public final Provider<ParametersValidator> b;

    public ExpressCvModule_ProvideLocalPretendInteractorFactory(ExpressCvModule expressCvModule, Provider<ParametersValidator> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideLocalPretendInteractorFactory create(ExpressCvModule expressCvModule, Provider<ParametersValidator> provider) {
        return new ExpressCvModule_ProvideLocalPretendInteractorFactory(expressCvModule, provider);
    }

    public static LocalPretendInteractor provideLocalPretendInteractor(ExpressCvModule expressCvModule, ParametersValidator parametersValidator) {
        return (LocalPretendInteractor) Preconditions.checkNotNullFromProvides(expressCvModule.provideLocalPretendInteractor(parametersValidator));
    }

    @Override // javax.inject.Provider
    public LocalPretendInteractor get() {
        return provideLocalPretendInteractor(this.a, this.b.get());
    }
}
