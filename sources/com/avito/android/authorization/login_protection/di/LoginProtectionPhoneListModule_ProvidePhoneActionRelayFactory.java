package com.avito.android.authorization.login_protection.di;

import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class LoginProtectionPhoneListModule_ProvidePhoneActionRelayFactory implements Factory<PublishRelay<PhoneListAction>> {

    public static final class a {
        public static final LoginProtectionPhoneListModule_ProvidePhoneActionRelayFactory a = new LoginProtectionPhoneListModule_ProvidePhoneActionRelayFactory();
    }

    public static LoginProtectionPhoneListModule_ProvidePhoneActionRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<PhoneListAction> providePhoneActionRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(LoginProtectionPhoneListModule.providePhoneActionRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<PhoneListAction> get() {
        return providePhoneActionRelay();
    }
}
