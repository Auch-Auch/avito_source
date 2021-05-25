package com.avito.android.social_management;

import com.avito.android.Features;
import com.avito.android.preferences.SocialNotificationStateStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialManagementInteractorImpl_Factory implements Factory<SocialManagementInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Features> c;
    public final Provider<SocialNotificationStateStorage> d;

    public SocialManagementInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3, Provider<SocialNotificationStateStorage> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SocialManagementInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3, Provider<SocialNotificationStateStorage> provider4) {
        return new SocialManagementInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SocialManagementInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory schedulersFactory, Features features, SocialNotificationStateStorage socialNotificationStateStorage) {
        return new SocialManagementInteractorImpl(profileApi, schedulersFactory, features, socialNotificationStateStorage);
    }

    @Override // javax.inject.Provider
    public SocialManagementInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
