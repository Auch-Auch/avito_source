package com.avito.android.profile.header;

import com.avito.android.analytics.Analytics;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DefaultProfileHeaderPresenter_Factory implements Factory<DefaultProfileHeaderPresenter> {
    public final Provider<UserProfileResourceProvider> a;
    public final Provider<Analytics> b;

    public DefaultProfileHeaderPresenter_Factory(Provider<UserProfileResourceProvider> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DefaultProfileHeaderPresenter_Factory create(Provider<UserProfileResourceProvider> provider, Provider<Analytics> provider2) {
        return new DefaultProfileHeaderPresenter_Factory(provider, provider2);
    }

    public static DefaultProfileHeaderPresenter newInstance(UserProfileResourceProvider userProfileResourceProvider, Analytics analytics) {
        return new DefaultProfileHeaderPresenter(userProfileResourceProvider, analytics);
    }

    @Override // javax.inject.Provider
    public DefaultProfileHeaderPresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
