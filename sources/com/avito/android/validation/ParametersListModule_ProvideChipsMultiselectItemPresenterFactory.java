package com.avito.android.validation;

import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideChipsMultiselectItemPresenterFactory implements Factory<ChipsMultiselectItemPresenter> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideChipsMultiselectItemPresenterFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideChipsMultiselectItemPresenterFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideChipsMultiselectItemPresenterFactory(parametersListModule);
    }

    public static ChipsMultiselectItemPresenter provideChipsMultiselectItemPresenter(ParametersListModule parametersListModule) {
        return (ChipsMultiselectItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideChipsMultiselectItemPresenter());
    }

    @Override // javax.inject.Provider
    public ChipsMultiselectItemPresenter get() {
        return provideChipsMultiselectItemPresenter(this.a);
    }
}
