package com.avito.android.code_confirmation.di;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory implements Factory<CodeConfirmationInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<CodeConfirmationResourceProvider> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<String> e;
    public final Provider<Boolean> f;

    public CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationResourceProvider> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<String> provider5, Provider<Boolean> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationResourceProvider> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<String> provider5, Provider<Boolean> provider6) {
        return new CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CodeConfirmationInteractor provideCodeConfirmationInteractor$code_confirmation_release(ProfileApi profileApi, SchedulersFactory schedulersFactory, CodeConfirmationResourceProvider codeConfirmationResourceProvider, TypedErrorThrowableConverter typedErrorThrowableConverter, String str, boolean z) {
        return (CodeConfirmationInteractor) Preconditions.checkNotNullFromProvides(CodeConfirmationModule.provideCodeConfirmationInteractor$code_confirmation_release(profileApi, schedulersFactory, codeConfirmationResourceProvider, typedErrorThrowableConverter, str, z));
    }

    @Override // javax.inject.Provider
    public CodeConfirmationInteractor get() {
        return provideCodeConfirmationInteractor$code_confirmation_release(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get().booleanValue());
    }
}
