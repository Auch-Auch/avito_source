package com.avito.android.util;

import android.text.TextWatcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherFactory implements Factory<TextWatcher> {
    public final Provider<Formatter<String>> a;

    public PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherFactory(Provider<Formatter<String>> provider) {
        this.a = provider;
    }

    public static PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherFactory create(Provider<Formatter<String>> provider) {
        return new PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherFactory(provider);
    }

    public static TextWatcher providePhoneNumberFormatterTextWatcher(Formatter<String> formatter) {
        return (TextWatcher) Preconditions.checkNotNullFromProvides(PhoneNumberFormatterModule.providePhoneNumberFormatterTextWatcher(formatter));
    }

    @Override // javax.inject.Provider
    public TextWatcher get() {
        return providePhoneNumberFormatterTextWatcher(this.a.get());
    }
}
