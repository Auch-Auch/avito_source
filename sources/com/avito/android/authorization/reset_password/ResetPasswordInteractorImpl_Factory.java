package com.avito.android.authorization.reset_password;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResetPasswordInteractorImpl_Factory implements Factory<ResetPasswordInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<CodeConfirmationInteractor> b;
    public final Provider<CodeConfirmationInteractor> c;
    public final Provider<ResetPasswordResourceProvider> d;
    public final Provider<TypedErrorThrowableConverter> e;
    public final Provider<SchedulersFactory> f;

    public ResetPasswordInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<CodeConfirmationInteractor> provider2, Provider<CodeConfirmationInteractor> provider3, Provider<ResetPasswordResourceProvider> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<SchedulersFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ResetPasswordInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<CodeConfirmationInteractor> provider2, Provider<CodeConfirmationInteractor> provider3, Provider<ResetPasswordResourceProvider> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<SchedulersFactory> provider6) {
        return new ResetPasswordInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ResetPasswordInteractorImpl newInstance(ProfileApi profileApi, CodeConfirmationInteractor codeConfirmationInteractor, Lazy<CodeConfirmationInteractor> lazy, ResetPasswordResourceProvider resetPasswordResourceProvider, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory schedulersFactory) {
        return new ResetPasswordInteractorImpl(profileApi, codeConfirmationInteractor, lazy, resetPasswordResourceProvider, typedErrorThrowableConverter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ResetPasswordInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), DoubleCheck.lazy(this.c), this.d.get(), this.e.get(), this.f.get());
    }
}
