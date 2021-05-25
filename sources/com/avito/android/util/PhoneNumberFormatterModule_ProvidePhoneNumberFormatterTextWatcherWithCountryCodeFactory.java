package com.avito.android.util;

import android.text.TextWatcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory implements Factory<TextWatcher> {
    public final Provider<Formatter<String>> a;

    public PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory(Provider<Formatter<String>> provider) {
        this.a = provider;
    }

    public static PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory create(Provider<Formatter<String>> provider) {
        return new PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory(provider);
    }

    public static TextWatcher providePhoneNumberFormatterTextWatcherWithCountryCode(Formatter<String> formatter) {
        return (TextWatcher) Preconditions.checkNotNullFromProvides(PhoneNumberFormatterModule.providePhoneNumberFormatterTextWatcherWithCountryCode(formatter));
    }

    @Override // javax.inject.Provider
    public TextWatcher get() {
        return providePhoneNumberFormatterTextWatcherWithCountryCode(this.a.get());
    }
}
