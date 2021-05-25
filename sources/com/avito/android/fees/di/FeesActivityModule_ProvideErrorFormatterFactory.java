package com.avito.android.fees.di;

import com.avito.android.util.ErrorFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class FeesActivityModule_ProvideErrorFormatterFactory implements Factory<ErrorFormatter> {
    public final FeesActivityModule a;

    public FeesActivityModule_ProvideErrorFormatterFactory(FeesActivityModule feesActivityModule) {
        this.a = feesActivityModule;
    }

    public static FeesActivityModule_ProvideErrorFormatterFactory create(FeesActivityModule feesActivityModule) {
        return new FeesActivityModule_ProvideErrorFormatterFactory(feesActivityModule);
    }

    public static ErrorFormatter provideErrorFormatter(FeesActivityModule feesActivityModule) {
        return (ErrorFormatter) Preconditions.checkNotNullFromProvides(feesActivityModule.provideErrorFormatter());
    }

    @Override // javax.inject.Provider
    public ErrorFormatter get() {
        return provideErrorFormatter(this.a);
    }
}
