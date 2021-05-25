package com.avito.android.validation;

import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideInputItemBlueprintFactory implements Factory<MultiStateInputItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<MultiStateInputItemPresenter> b;

    public ParametersListModule_ProvideInputItemBlueprintFactory(ParametersListModule parametersListModule, Provider<MultiStateInputItemPresenter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideInputItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<MultiStateInputItemPresenter> provider) {
        return new ParametersListModule_ProvideInputItemBlueprintFactory(parametersListModule, provider);
    }

    public static MultiStateInputItemBlueprint provideInputItemBlueprint(ParametersListModule parametersListModule, MultiStateInputItemPresenter multiStateInputItemPresenter) {
        return (MultiStateInputItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideInputItemBlueprint(multiStateInputItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiStateInputItemBlueprint get() {
        return provideInputItemBlueprint(this.a, this.b.get());
    }
}
