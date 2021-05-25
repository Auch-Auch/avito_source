package com.avito.android.authorization.account_manager;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AvitoAuthenticatorService_MembersInjector implements MembersInjector<AvitoAuthenticatorService> {
    public final Provider<AvitoAccountAuthenticator> a;

    public AvitoAuthenticatorService_MembersInjector(Provider<AvitoAccountAuthenticator> provider) {
        this.a = provider;
    }

    public static MembersInjector<AvitoAuthenticatorService> create(Provider<AvitoAccountAuthenticator> provider) {
        return new AvitoAuthenticatorService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.authorization.account_manager.AvitoAuthenticatorService.authenticator")
    public static void injectAuthenticator(AvitoAuthenticatorService avitoAuthenticatorService, AvitoAccountAuthenticator avitoAccountAuthenticator) {
        avitoAuthenticatorService.authenticator = avitoAccountAuthenticator;
    }

    public void injectMembers(AvitoAuthenticatorService avitoAuthenticatorService) {
        injectAuthenticator(avitoAuthenticatorService, this.a.get());
    }
}
