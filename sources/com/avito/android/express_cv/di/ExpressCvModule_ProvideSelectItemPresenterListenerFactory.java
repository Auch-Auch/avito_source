package com.avito.android.express_cv.di;

import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideSelectItemPresenterListenerFactory implements Factory<SelectItemPresenter.ClickListener> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProvideSelectItemPresenterListenerFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProvideSelectItemPresenterListenerFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProvideSelectItemPresenterListenerFactory(expressCvModule, provider);
    }

    public static SelectItemPresenter.ClickListener provideSelectItemPresenterListener(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (SelectItemPresenter.ClickListener) Preconditions.checkNotNullFromProvides(expressCvModule.provideSelectItemPresenterListener(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public SelectItemPresenter.ClickListener get() {
        return provideSelectItemPresenterListener(this.a, this.b.get());
    }
}
