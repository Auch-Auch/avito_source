package com.avito.android.validation;

import com.avito.android.blueprints.publish.VehicleRegNumberInputItemBlueprint;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory implements Factory<VehicleRegNumberInputItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<VehicleRegNumberInputItemPresenter> b;

    public ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory(ParametersListModule parametersListModule, Provider<VehicleRegNumberInputItemPresenter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<VehicleRegNumberInputItemPresenter> provider) {
        return new ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory(parametersListModule, provider);
    }

    public static VehicleRegNumberInputItemBlueprint provideVehicleRegNumberInputItemBlueprint(ParametersListModule parametersListModule, VehicleRegNumberInputItemPresenter vehicleRegNumberInputItemPresenter) {
        return (VehicleRegNumberInputItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideVehicleRegNumberInputItemBlueprint(vehicleRegNumberInputItemPresenter));
    }

    @Override // javax.inject.Provider
    public VehicleRegNumberInputItemBlueprint get() {
        return provideVehicleRegNumberInputItemBlueprint(this.a, this.b.get());
    }
}
