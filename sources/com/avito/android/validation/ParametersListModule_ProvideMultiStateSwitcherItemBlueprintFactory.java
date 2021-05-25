package com.avito.android.validation;

import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory implements Factory<MultiStateSwitcherItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<MultiStateSwitcherItemPresenter> b;

    public ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory(ParametersListModule parametersListModule, Provider<MultiStateSwitcherItemPresenter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<MultiStateSwitcherItemPresenter> provider) {
        return new ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory(parametersListModule, provider);
    }

    public static MultiStateSwitcherItemBlueprint provideMultiStateSwitcherItemBlueprint(ParametersListModule parametersListModule, MultiStateSwitcherItemPresenter multiStateSwitcherItemPresenter) {
        return (MultiStateSwitcherItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideMultiStateSwitcherItemBlueprint(multiStateSwitcherItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiStateSwitcherItemBlueprint get() {
        return provideMultiStateSwitcherItemBlueprint(this.a, this.b.get());
    }
}
