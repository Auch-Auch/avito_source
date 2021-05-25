package com.avito.android.express_cv.di;

import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideCvDataFactory implements Factory<ExistedCvDataProvider> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideCvDataFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideCvDataFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideCvDataFactory(expressCvModule, provider);
    }

    public static ExistedCvDataProvider provideCvData(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (ExistedCvDataProvider) Preconditions.checkNotNullFromProvides(expressCvModule.provideCvData(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public ExistedCvDataProvider get() {
        return provideCvData(this.a, this.b.get());
    }
}
