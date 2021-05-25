package com.avito.android.short_term_rent.di.module;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory implements Factory<ButtonItemBlueprint> {
    public final Provider<ButtonItemPresenter> a;

    public StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory(Provider<ButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory create(Provider<ButtonItemPresenter> provider) {
        return new StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory(provider);
    }

    public static ButtonItemBlueprint provideButtonBlueprint(ButtonItemPresenter buttonItemPresenter) {
        return (ButtonItemBlueprint) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideButtonBlueprint(buttonItemPresenter));
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return provideButtonBlueprint(this.a.get());
    }
}
