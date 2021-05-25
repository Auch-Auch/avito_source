package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.express_cv.ExpressCvViewModelFactory;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideViewModelImplFactory implements Factory<ExpressCvViewModelImpl> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelFactory> b;
    public final Provider<Activity> c;

    public ExpressCvModule_ProvideViewModelImplFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelFactory> provider, Provider<Activity> provider2) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ExpressCvModule_ProvideViewModelImplFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelFactory> provider, Provider<Activity> provider2) {
        return new ExpressCvModule_ProvideViewModelImplFactory(expressCvModule, provider, provider2);
    }

    public static ExpressCvViewModelImpl provideViewModelImpl(ExpressCvModule expressCvModule, ExpressCvViewModelFactory expressCvViewModelFactory, Activity activity) {
        return (ExpressCvViewModelImpl) Preconditions.checkNotNullFromProvides(expressCvModule.provideViewModelImpl(expressCvViewModelFactory, activity));
    }

    @Override // javax.inject.Provider
    public ExpressCvViewModelImpl get() {
        return provideViewModelImpl(this.a, this.b.get(), this.c.get());
    }
}
