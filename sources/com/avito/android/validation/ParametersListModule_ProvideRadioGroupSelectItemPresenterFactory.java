package com.avito.android.validation;

import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory implements Factory<RadioGroupSelectItemPresenter> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory(parametersListModule);
    }

    public static RadioGroupSelectItemPresenter provideRadioGroupSelectItemPresenter(ParametersListModule parametersListModule) {
        return (RadioGroupSelectItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideRadioGroupSelectItemPresenter());
    }

    @Override // javax.inject.Provider
    public RadioGroupSelectItemPresenter get() {
        return provideRadioGroupSelectItemPresenter(this.a);
    }
}
