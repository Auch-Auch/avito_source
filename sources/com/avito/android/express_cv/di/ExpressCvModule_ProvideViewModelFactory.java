package com.avito.android.express_cv.di;

import com.avito.android.express_cv.ExpressCvViewModel;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideViewModelFactory implements Factory<ExpressCvViewModel> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideViewModelFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideViewModelFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideViewModelFactory(expressCvModule, provider);
    }

    public static ExpressCvViewModel provideViewModel(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (ExpressCvViewModel) Preconditions.checkNotNullFromProvides(expressCvModule.provideViewModel(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public ExpressCvViewModel get() {
        return provideViewModel(this.a, this.b.get());
    }
}
