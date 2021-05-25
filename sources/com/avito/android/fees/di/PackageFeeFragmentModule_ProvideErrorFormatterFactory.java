package com.avito.android.fees.di;

import com.avito.android.util.ErrorFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PackageFeeFragmentModule_ProvideErrorFormatterFactory implements Factory<ErrorFormatter> {
    public final PackageFeeFragmentModule a;

    public PackageFeeFragmentModule_ProvideErrorFormatterFactory(PackageFeeFragmentModule packageFeeFragmentModule) {
        this.a = packageFeeFragmentModule;
    }

    public static PackageFeeFragmentModule_ProvideErrorFormatterFactory create(PackageFeeFragmentModule packageFeeFragmentModule) {
        return new PackageFeeFragmentModule_ProvideErrorFormatterFactory(packageFeeFragmentModule);
    }

    public static ErrorFormatter provideErrorFormatter(PackageFeeFragmentModule packageFeeFragmentModule) {
        return (ErrorFormatter) Preconditions.checkNotNullFromProvides(packageFeeFragmentModule.provideErrorFormatter());
    }

    @Override // javax.inject.Provider
    public ErrorFormatter get() {
        return provideErrorFormatter(this.a);
    }
}
