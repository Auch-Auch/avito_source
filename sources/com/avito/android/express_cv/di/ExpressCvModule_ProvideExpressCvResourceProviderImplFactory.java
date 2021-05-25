package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.express_cv.ExpressCvResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideExpressCvResourceProviderImplFactory implements Factory<ExpressCvResourceProvider> {
    public final ExpressCvModule a;
    public final Provider<Activity> b;

    public ExpressCvModule_ProvideExpressCvResourceProviderImplFactory(ExpressCvModule expressCvModule, Provider<Activity> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideExpressCvResourceProviderImplFactory create(ExpressCvModule expressCvModule, Provider<Activity> provider) {
        return new ExpressCvModule_ProvideExpressCvResourceProviderImplFactory(expressCvModule, provider);
    }

    public static ExpressCvResourceProvider provideExpressCvResourceProviderImpl(ExpressCvModule expressCvModule, Activity activity) {
        return (ExpressCvResourceProvider) Preconditions.checkNotNullFromProvides(expressCvModule.provideExpressCvResourceProviderImpl(activity));
    }

    @Override // javax.inject.Provider
    public ExpressCvResourceProvider get() {
        return provideExpressCvResourceProviderImpl(this.a, this.b.get());
    }
}
