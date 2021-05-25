package com.avito.android.express_cv.di;

import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvidePrimaryParametersListenerFactory implements Factory<PrimaryParametersListener> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvidePrimaryParametersListenerFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvidePrimaryParametersListenerFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvidePrimaryParametersListenerFactory(expressCvModule, provider);
    }

    public static PrimaryParametersListener providePrimaryParametersListener(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (PrimaryParametersListener) Preconditions.checkNotNullFromProvides(expressCvModule.providePrimaryParametersListener(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public PrimaryParametersListener get() {
        return providePrimaryParametersListener(this.a, this.b.get());
    }
}
