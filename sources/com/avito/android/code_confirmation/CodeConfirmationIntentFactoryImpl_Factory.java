package com.avito.android.code_confirmation;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CodeConfirmationIntentFactoryImpl_Factory implements Factory<CodeConfirmationIntentFactoryImpl> {
    public final Provider<Context> a;

    public CodeConfirmationIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static CodeConfirmationIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new CodeConfirmationIntentFactoryImpl_Factory(provider);
    }

    public static CodeConfirmationIntentFactoryImpl newInstance(Context context) {
        return new CodeConfirmationIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public CodeConfirmationIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
