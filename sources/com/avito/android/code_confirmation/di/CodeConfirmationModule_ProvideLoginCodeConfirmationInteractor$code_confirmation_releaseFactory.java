package com.avito.android.code_confirmation.di;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory implements Factory<CodeConfirmationInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<CodeConfirmationResourceProvider> c;

    public CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationResourceProvider> provider3) {
        return new CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory(provider, provider2, provider3);
    }

    public static CodeConfirmationInteractor provideLoginCodeConfirmationInteractor$code_confirmation_release(ProfileApi profileApi, SchedulersFactory schedulersFactory, CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        return (CodeConfirmationInteractor) Preconditions.checkNotNullFromProvides(CodeConfirmationModule.provideLoginCodeConfirmationInteractor$code_confirmation_release(profileApi, schedulersFactory, codeConfirmationResourceProvider));
    }

    @Override // javax.inject.Provider
    public CodeConfirmationInteractor get() {
        return provideLoginCodeConfirmationInteractor$code_confirmation_release(this.a.get(), this.b.get(), this.c.get());
    }
}
