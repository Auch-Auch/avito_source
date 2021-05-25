package com.avito.android.validation;

import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.util.ParametersListRdsContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final ParametersListModule a;
    public final Provider<ParametersListRdsContentsComparator> b;

    public ParametersListModule_ProvideDiffCalculatorFactory(ParametersListModule parametersListModule, Provider<ParametersListRdsContentsComparator> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideDiffCalculatorFactory create(ParametersListModule parametersListModule, Provider<ParametersListRdsContentsComparator> provider) {
        return new ParametersListModule_ProvideDiffCalculatorFactory(parametersListModule, provider);
    }

    public static DiffCalculator provideDiffCalculator(ParametersListModule parametersListModule, ParametersListRdsContentsComparator parametersListRdsContentsComparator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(parametersListModule.provideDiffCalculator(parametersListRdsContentsComparator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a, this.b.get());
    }
}
