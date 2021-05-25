package com.avito.android.authorization.login_protection.formatter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginProtectionPhoneFormatterImpl_Factory implements Factory<LoginProtectionPhoneFormatterImpl> {
    public final Provider<Boolean> a;

    public LoginProtectionPhoneFormatterImpl_Factory(Provider<Boolean> provider) {
        this.a = provider;
    }

    public static LoginProtectionPhoneFormatterImpl_Factory create(Provider<Boolean> provider) {
        return new LoginProtectionPhoneFormatterImpl_Factory(provider);
    }

    public static LoginProtectionPhoneFormatterImpl newInstance(boolean z) {
        return new LoginProtectionPhoneFormatterImpl(z);
    }

    @Override // javax.inject.Provider
    public LoginProtectionPhoneFormatterImpl get() {
        return newInstance(this.a.get().booleanValue());
    }
}
