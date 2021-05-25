package com.avito.android.phone_confirmation;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneConfirmationIntentFactoryImpl_Factory implements Factory<PhoneConfirmationIntentFactoryImpl> {
    public final Provider<Context> a;

    public PhoneConfirmationIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PhoneConfirmationIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new PhoneConfirmationIntentFactoryImpl_Factory(provider);
    }

    public static PhoneConfirmationIntentFactoryImpl newInstance(Context context) {
        return new PhoneConfirmationIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public PhoneConfirmationIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
