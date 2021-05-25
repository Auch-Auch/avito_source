package com.avito.android.express_cv.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProviveButtonItemPresenterListenerFactory implements Factory<ButtonItemPresenter.Listener> {
    public final ExpressCvModule a;
    public final Provider<ExpressCvViewModelImpl> b;

    public ExpressCvModule_ProviveButtonItemPresenterListenerFactory(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        this.a = expressCvModule;
        this.b = provider;
    }

    public static ExpressCvModule_ProviveButtonItemPresenterListenerFactory create(ExpressCvModule expressCvModule, Provider<ExpressCvViewModelImpl> provider) {
        return new ExpressCvModule_ProviveButtonItemPresenterListenerFactory(expressCvModule, provider);
    }

    public static ButtonItemPresenter.Listener proviveButtonItemPresenterListener(ExpressCvModule expressCvModule, ExpressCvViewModelImpl expressCvViewModelImpl) {
        return (ButtonItemPresenter.Listener) Preconditions.checkNotNullFromProvides(expressCvModule.proviveButtonItemPresenterListener(expressCvViewModelImpl));
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter.Listener get() {
        return proviveButtonItemPresenterListener(this.a, this.b.get());
    }
}
