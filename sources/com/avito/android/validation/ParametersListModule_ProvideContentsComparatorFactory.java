package com.avito.android.validation;

import com.avito.android.util.ParametersListRdsContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideContentsComparatorFactory implements Factory<ParametersListRdsContentsComparator> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideContentsComparatorFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideContentsComparatorFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideContentsComparatorFactory(parametersListModule);
    }

    public static ParametersListRdsContentsComparator provideContentsComparator(ParametersListModule parametersListModule) {
        return (ParametersListRdsContentsComparator) Preconditions.checkNotNullFromProvides(parametersListModule.provideContentsComparator());
    }

    @Override // javax.inject.Provider
    public ParametersListRdsContentsComparator get() {
        return provideContentsComparator(this.a);
    }
}
