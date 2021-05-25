package com.avito.android.di.module;

import com.avito.android.provider.InputItemFormatterProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory implements Factory<InputItemFormatterProvider> {

    public static final class a {
        public static final InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory a = new InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory();
    }

    public static InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory create() {
        return a.a;
    }

    public static InputItemFormatterProvider provideInputItemFormatter$formatters_provider_release() {
        return (InputItemFormatterProvider) Preconditions.checkNotNullFromProvides(InputItemFormatterProviderModule.provideInputItemFormatter$formatters_provider_release());
    }

    @Override // javax.inject.Provider
    public InputItemFormatterProvider get() {
        return provideInputItemFormatter$formatters_provider_release();
    }
}
