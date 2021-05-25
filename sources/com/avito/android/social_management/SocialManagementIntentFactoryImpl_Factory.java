package com.avito.android.social_management;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialManagementIntentFactoryImpl_Factory implements Factory<SocialManagementIntentFactoryImpl> {
    public final Provider<Context> a;

    public SocialManagementIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static SocialManagementIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new SocialManagementIntentFactoryImpl_Factory(provider);
    }

    public static SocialManagementIntentFactoryImpl newInstance(Context context) {
        return new SocialManagementIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public SocialManagementIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
