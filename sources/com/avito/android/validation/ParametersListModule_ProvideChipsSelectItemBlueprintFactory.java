package com.avito.android.validation;

import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideChipsSelectItemBlueprintFactory implements Factory<ChipsSelectItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<ChipsSelectItemPresenter> b;
    public final Provider<AttributedTextFormatter> c;

    public ParametersListModule_ProvideChipsSelectItemBlueprintFactory(ParametersListModule parametersListModule, Provider<ChipsSelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ParametersListModule_ProvideChipsSelectItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<ChipsSelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ParametersListModule_ProvideChipsSelectItemBlueprintFactory(parametersListModule, provider, provider2);
    }

    public static ChipsSelectItemBlueprint provideChipsSelectItemBlueprint(ParametersListModule parametersListModule, ChipsSelectItemPresenter chipsSelectItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return (ChipsSelectItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideChipsSelectItemBlueprint(chipsSelectItemPresenter, attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public ChipsSelectItemBlueprint get() {
        return provideChipsSelectItemBlueprint(this.a, this.b.get(), this.c.get());
    }
}
