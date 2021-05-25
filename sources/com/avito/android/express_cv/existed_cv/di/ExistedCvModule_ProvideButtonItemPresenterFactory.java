package com.avito.android.express_cv.existed_cv.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExistedCvModule_ProvideButtonItemPresenterFactory implements Factory<ButtonItemPresenter> {
    public final ExistedCvModule a;
    public final Provider<ButtonItemPresenter.Listener> b;

    public ExistedCvModule_ProvideButtonItemPresenterFactory(ExistedCvModule existedCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        this.a = existedCvModule;
        this.b = provider;
    }

    public static ExistedCvModule_ProvideButtonItemPresenterFactory create(ExistedCvModule existedCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        return new ExistedCvModule_ProvideButtonItemPresenterFactory(existedCvModule, provider);
    }

    public static ButtonItemPresenter provideButtonItemPresenter(ExistedCvModule existedCvModule, Lazy<ButtonItemPresenter.Listener> lazy) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(existedCvModule.provideButtonItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
