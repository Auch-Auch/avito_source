package com.avito.android.basket_legacy.di.checkout;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.component.button.ButtonItemPresenter;
public final class LegacyCheckoutUiModule_ProvideButtonItemPresenter$basket_releaseFactory implements Factory<ButtonItemPresenter> {
    public final LegacyCheckoutUiModule a;

    public LegacyCheckoutUiModule_ProvideButtonItemPresenter$basket_releaseFactory(LegacyCheckoutUiModule legacyCheckoutUiModule) {
        this.a = legacyCheckoutUiModule;
    }

    public static LegacyCheckoutUiModule_ProvideButtonItemPresenter$basket_releaseFactory create(LegacyCheckoutUiModule legacyCheckoutUiModule) {
        return new LegacyCheckoutUiModule_ProvideButtonItemPresenter$basket_releaseFactory(legacyCheckoutUiModule);
    }

    public static ButtonItemPresenter provideButtonItemPresenter$basket_release(LegacyCheckoutUiModule legacyCheckoutUiModule) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(legacyCheckoutUiModule.provideButtonItemPresenter$basket_release());
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter$basket_release(this.a);
    }
}
