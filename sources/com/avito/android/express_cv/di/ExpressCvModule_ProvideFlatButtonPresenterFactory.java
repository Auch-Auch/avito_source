package com.avito.android.express_cv.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.express_cv.existed_cv.item.FlatButtonPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideFlatButtonPresenterFactory implements Factory<FlatButtonPresenter> {
    public final ExpressCvModule a;
    public final Provider<ButtonItemPresenter.Listener> b;

    public ExpressCvModule_ProvideFlatButtonPresenterFactory(ExpressCvModule expressCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideFlatButtonPresenterFactory create(ExpressCvModule expressCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        return new ExpressCvModule_ProvideFlatButtonPresenterFactory(expressCvModule, provider);
    }

    public static FlatButtonPresenter provideFlatButtonPresenter(ExpressCvModule expressCvModule, Lazy<ButtonItemPresenter.Listener> lazy) {
        return (FlatButtonPresenter) Preconditions.checkNotNullFromProvides(expressCvModule.provideFlatButtonPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public FlatButtonPresenter get() {
        return provideFlatButtonPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
