package com.avito.android.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory implements Factory<Formatter<String>> {

    public static final class a {
        public static final PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory a = new PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory();
    }

    public static PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory create() {
        return a.a;
    }

    public static Formatter<String> provideNationalPhoneNumberFormatterWithCountryCode() {
        return (Formatter) Preconditions.checkNotNullFromProvides(PhoneNumberFormatterModule.provideNationalPhoneNumberFormatterWithCountryCode());
    }

    @Override // javax.inject.Provider
    public Formatter<String> get() {
        return provideNationalPhoneNumberFormatterWithCountryCode();
    }
}
