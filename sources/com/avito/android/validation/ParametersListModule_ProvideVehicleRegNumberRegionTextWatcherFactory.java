package com.avito.android.validation;

import android.text.TextWatcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory implements Factory<TextWatcher> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory(parametersListModule);
    }

    public static TextWatcher provideVehicleRegNumberRegionTextWatcher(ParametersListModule parametersListModule) {
        return (TextWatcher) Preconditions.checkNotNullFromProvides(parametersListModule.provideVehicleRegNumberRegionTextWatcher());
    }

    @Override // javax.inject.Provider
    public TextWatcher get() {
        return provideVehicleRegNumberRegionTextWatcher(this.a);
    }
}
