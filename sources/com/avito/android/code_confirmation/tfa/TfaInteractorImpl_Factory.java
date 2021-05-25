package com.avito.android.code_confirmation.tfa;

import com.avito.android.account.AccountInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TfaInteractorImpl_Factory implements Factory<TfaInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<CodeConfirmationResourceProvider> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<AccountInteractor> e;

    public TfaInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<CodeConfirmationResourceProvider> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AccountInteractor> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static TfaInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<CodeConfirmationResourceProvider> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AccountInteractor> provider5) {
        return new TfaInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TfaInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory3 schedulersFactory3, CodeConfirmationResourceProvider codeConfirmationResourceProvider, TypedErrorThrowableConverter typedErrorThrowableConverter, AccountInteractor accountInteractor) {
        return new TfaInteractorImpl(profileApi, schedulersFactory3, codeConfirmationResourceProvider, typedErrorThrowableConverter, accountInteractor);
    }

    @Override // javax.inject.Provider
    public TfaInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
