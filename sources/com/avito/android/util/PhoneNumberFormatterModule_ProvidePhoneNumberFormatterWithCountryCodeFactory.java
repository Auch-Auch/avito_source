package com.avito.android.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory implements Factory<Formatter<String>> {

    public static final class a {
        public static final PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory a = new PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory();
    }

    public static PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory create() {
        return a.a;
    }

    public static Formatter<String> providePhoneNumberFormatterWithCountryCode() {
        return (Formatter) Preconditions.checkNotNullFromProvides(PhoneNumberFormatterModule.providePhoneNumberFormatterWithCountryCode());
    }

    @Override // javax.inject.Provider
    public Formatter<String> get() {
        return providePhoneNumberFormatterWithCountryCode();
    }
}
