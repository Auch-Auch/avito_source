package com.avito.android.authorization.login;

import android.content.res.Resources;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginResourceProviderImpl_Factory implements Factory<LoginResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<CodeConfirmationResourceProvider> b;

    public LoginResourceProviderImpl_Factory(Provider<Resources> provider, Provider<CodeConfirmationResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LoginResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<CodeConfirmationResourceProvider> provider2) {
        return new LoginResourceProviderImpl_Factory(provider, provider2);
    }

    public static LoginResourceProviderImpl newInstance(Resources resources, CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        return new LoginResourceProviderImpl(resources, codeConfirmationResourceProvider);
    }

    @Override // javax.inject.Provider
    public LoginResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
