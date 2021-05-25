package com.avito.android.validation;

import android.text.TextWatcher;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory implements Factory<VehicleRegNumberInputItemPresenter> {
    public final ParametersListModule a;
    public final Provider<TextWatcher> b;
    public final Provider<AttributedTextFormatter> c;

    public ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory(ParametersListModule parametersListModule, Provider<TextWatcher> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory create(ParametersListModule parametersListModule, Provider<TextWatcher> provider, Provider<AttributedTextFormatter> provider2) {
        return new ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory(parametersListModule, provider, provider2);
    }

    public static VehicleRegNumberInputItemPresenter provideVehicleRegNumberInputItemPresenter(ParametersListModule parametersListModule, TextWatcher textWatcher, AttributedTextFormatter attributedTextFormatter) {
        return (VehicleRegNumberInputItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideVehicleRegNumberInputItemPresenter(textWatcher, attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public VehicleRegNumberInputItemPresenter get() {
        return provideVehicleRegNumberInputItemPresenter(this.a, this.b.get(), this.c.get());
    }
}
