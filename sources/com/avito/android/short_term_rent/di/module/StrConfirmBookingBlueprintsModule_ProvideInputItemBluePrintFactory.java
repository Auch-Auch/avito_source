package com.avito.android.short_term_rent.di.module;

import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory implements Factory<InputItemBlueprint> {
    public final Provider<InputItemPresenter> a;

    public StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory(Provider<InputItemPresenter> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory create(Provider<InputItemPresenter> provider) {
        return new StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory(provider);
    }

    public static InputItemBlueprint provideInputItemBluePrint(InputItemPresenter inputItemPresenter) {
        return (InputItemBlueprint) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideInputItemBluePrint(inputItemPresenter));
    }

    @Override // javax.inject.Provider
    public InputItemBlueprint get() {
        return provideInputItemBluePrint(this.a.get());
    }
}
