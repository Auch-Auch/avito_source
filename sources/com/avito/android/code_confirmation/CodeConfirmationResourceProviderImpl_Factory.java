package com.avito.android.code_confirmation;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CodeConfirmationResourceProviderImpl_Factory implements Factory<CodeConfirmationResourceProviderImpl> {
    public final Provider<Resources> a;

    public CodeConfirmationResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static CodeConfirmationResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new CodeConfirmationResourceProviderImpl_Factory(provider);
    }

    public static CodeConfirmationResourceProviderImpl newInstance(Resources resources) {
        return new CodeConfirmationResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public CodeConfirmationResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
