package com.avito.android.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory implements Factory<Formatter<String>> {

    public static final class a {
        public static final PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory a = new PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory();
    }

    public static PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory create() {
        return a.a;
    }

    public static Formatter<String> providePhoneNumberFormatter() {
        return (Formatter) Preconditions.checkNotNullFromProvides(PhoneNumberFormatterModule.providePhoneNumberFormatter());
    }

    @Override // javax.inject.Provider
    public Formatter<String> get() {
        return providePhoneNumberFormatter();
    }
}
