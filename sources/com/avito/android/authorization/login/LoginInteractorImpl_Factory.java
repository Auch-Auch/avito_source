package com.avito.android.authorization.login;

import com.avito.android.account.AccountInteractor;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginInteractorImpl_Factory implements Factory<LoginInteractorImpl> {
    public final Provider<AccountInteractor> a;
    public final Provider<CodeConfirmationInteractor> b;

    public LoginInteractorImpl_Factory(Provider<AccountInteractor> provider, Provider<CodeConfirmationInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LoginInteractorImpl_Factory create(Provider<AccountInteractor> provider, Provider<CodeConfirmationInteractor> provider2) {
        return new LoginInteractorImpl_Factory(provider, provider2);
    }

    public static LoginInteractorImpl newInstance(AccountInteractor accountInteractor, CodeConfirmationInteractor codeConfirmationInteractor) {
        return new LoginInteractorImpl(accountInteractor, codeConfirmationInteractor);
    }

    @Override // javax.inject.Provider
    public LoginInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
