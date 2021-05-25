package com.avito.android.profile_phones.phone_management;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneManagementIntentFactoryImpl_Factory implements Factory<PhoneManagementIntentFactoryImpl> {
    public final Provider<Context> a;

    public PhoneManagementIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PhoneManagementIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new PhoneManagementIntentFactoryImpl_Factory(provider);
    }

    public static PhoneManagementIntentFactoryImpl newInstance(Context context) {
        return new PhoneManagementIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public PhoneManagementIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
