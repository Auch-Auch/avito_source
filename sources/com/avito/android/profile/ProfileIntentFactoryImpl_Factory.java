package com.avito.android.profile;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.social.SocialTypeToStringMapper;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileIntentFactoryImpl_Factory implements Factory<ProfileIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<SocialTypeToStringMapper> b;
    public final Provider<CoreActivityIntentFactory> c;

    public ProfileIntentFactoryImpl_Factory(Provider<Application> provider, Provider<SocialTypeToStringMapper> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ProfileIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<SocialTypeToStringMapper> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new ProfileIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static ProfileIntentFactoryImpl newInstance(Application application, SocialTypeToStringMapper socialTypeToStringMapper, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new ProfileIntentFactoryImpl(application, socialTypeToStringMapper, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public ProfileIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
