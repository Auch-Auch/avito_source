package com.avito.android.express_cv.di;

import com.avito.android.express_cv.ExpressCvViewModelImpl;
import com.avito.android.express_cv.NewCvDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideNewCvDataProviderFactory implements Factory<NewCvDataProvider> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideNewCvDataProviderFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideNewCvDataProviderFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideNewCvDataProviderFactory(expressCvModule, provider);
    }

    public static NewCvDataProvider provideNewCvDataProvider(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (NewCvDataProvider) Preconditions.checkNotNullFromProvides(expressCvModule.provideNewCvDataProvider(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public NewCvDataProvider get() {
        return provideNewCvDataProvider(this.a, this.b.get());
    }
}
