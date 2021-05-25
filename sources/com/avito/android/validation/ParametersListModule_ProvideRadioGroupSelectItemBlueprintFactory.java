package com.avito.android.validation;

import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory implements Factory<RadioGroupSelectItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<RadioGroupSelectItemPresenter> b;

    public ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory(ParametersListModule parametersListModule, Provider<RadioGroupSelectItemPresenter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<RadioGroupSelectItemPresenter> provider) {
        return new ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory(parametersListModule, provider);
    }

    public static RadioGroupSelectItemBlueprint provideRadioGroupSelectItemBlueprint(ParametersListModule parametersListModule, RadioGroupSelectItemPresenter radioGroupSelectItemPresenter) {
        return (RadioGroupSelectItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideRadioGroupSelectItemBlueprint(radioGroupSelectItemPresenter));
    }

    @Override // javax.inject.Provider
    public RadioGroupSelectItemBlueprint get() {
        return provideRadioGroupSelectItemBlueprint(this.a, this.b.get());
    }
}
