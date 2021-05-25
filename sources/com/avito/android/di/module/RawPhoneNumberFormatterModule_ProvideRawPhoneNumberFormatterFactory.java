package com.avito.android.di.module;

import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RawPhoneNumberFormatterModule_ProvideRawPhoneNumberFormatterFactory implements Factory<Formatter<String>> {
    public final RawPhoneNumberFormatterModule a;

    public RawPhoneNumberFormatterModule_ProvideRawPhoneNumberFormatterFactory(RawPhoneNumberFormatterModule rawPhoneNumberFormatterModule) {
        this.a = rawPhoneNumberFormatterModule;
    }

    public static RawPhoneNumberFormatterModule_ProvideRawPhoneNumberFormatterFactory create(RawPhoneNumberFormatterModule rawPhoneNumberFormatterModule) {
        return new RawPhoneNumberFormatterModule_ProvideRawPhoneNumberFormatterFactory(rawPhoneNumberFormatterModule);
    }

    public static Formatter<String> provideRawPhoneNumberFormatter(RawPhoneNumberFormatterModule rawPhoneNumberFormatterModule) {
        return (Formatter) Preconditions.checkNotNullFromProvides(rawPhoneNumberFormatterModule.provideRawPhoneNumberFormatter());
    }

    @Override // javax.inject.Provider
    public Formatter<String> get() {
        return provideRawPhoneNumberFormatter(this.a);
    }
}
