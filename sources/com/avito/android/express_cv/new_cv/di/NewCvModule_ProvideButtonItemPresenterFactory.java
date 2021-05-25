package com.avito.android.express_cv.new_cv.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_ProvideButtonItemPresenterFactory implements Factory<ButtonItemPresenter> {
    public final NewCvModule a;
    public final Provider<ButtonItemPresenter.Listener> b;

    public NewCvModule_ProvideButtonItemPresenterFactory(NewCvModule newCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        this.a = newCvModule;
        this.b = provider;
    }

    public static NewCvModule_ProvideButtonItemPresenterFactory create(NewCvModule newCvModule, Provider<ButtonItemPresenter.Listener> provider) {
        return new NewCvModule_ProvideButtonItemPresenterFactory(newCvModule, provider);
    }

    public static ButtonItemPresenter provideButtonItemPresenter(NewCvModule newCvModule, Lazy<ButtonItemPresenter.Listener> lazy) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(newCvModule.provideButtonItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
