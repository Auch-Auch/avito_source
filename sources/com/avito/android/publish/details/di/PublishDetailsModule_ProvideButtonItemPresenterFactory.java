package com.avito.android.publish.details.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.publish.details.PublishDetailsPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideButtonItemPresenterFactory implements Factory<ButtonItemPresenter> {
    public final PublishDetailsModule a;
    public final Provider<PublishDetailsPresenter> b;

    public PublishDetailsModule_ProvideButtonItemPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<PublishDetailsPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideButtonItemPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<PublishDetailsPresenter> provider) {
        return new PublishDetailsModule_ProvideButtonItemPresenterFactory(publishDetailsModule, provider);
    }

    public static ButtonItemPresenter provideButtonItemPresenter(PublishDetailsModule publishDetailsModule, Lazy<PublishDetailsPresenter> lazy) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideButtonItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
