package com.avito.android.validation;

import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory implements Factory<MultiStateSwitcherItemPresenter> {
    public final ParametersListModule a;
    public final Provider<AttributedTextFormatter> b;

    public ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory(ParametersListModule parametersListModule, Provider<AttributedTextFormatter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory create(ParametersListModule parametersListModule, Provider<AttributedTextFormatter> provider) {
        return new ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory(parametersListModule, provider);
    }

    public static MultiStateSwitcherItemPresenter provideMultiStateSwitcherItemPresenter(ParametersListModule parametersListModule, AttributedTextFormatter attributedTextFormatter) {
        return (MultiStateSwitcherItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideMultiStateSwitcherItemPresenter(attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public MultiStateSwitcherItemPresenter get() {
        return provideMultiStateSwitcherItemPresenter(this.a, this.b.get());
    }
}
