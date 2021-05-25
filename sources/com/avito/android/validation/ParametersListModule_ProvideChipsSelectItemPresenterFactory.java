package com.avito.android.validation;

import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideChipsSelectItemPresenterFactory implements Factory<ChipsSelectItemPresenter> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideChipsSelectItemPresenterFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideChipsSelectItemPresenterFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideChipsSelectItemPresenterFactory(parametersListModule);
    }

    public static ChipsSelectItemPresenter provideChipsSelectItemPresenter(ParametersListModule parametersListModule) {
        return (ChipsSelectItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideChipsSelectItemPresenter());
    }

    @Override // javax.inject.Provider
    public ChipsSelectItemPresenter get() {
        return provideChipsSelectItemPresenter(this.a);
    }
}
