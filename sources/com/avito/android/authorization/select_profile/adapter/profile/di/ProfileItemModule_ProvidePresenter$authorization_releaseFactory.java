package com.avito.android.authorization.select_profile.adapter.profile.di;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileItemModule_ProvidePresenter$authorization_releaseFactory implements Factory<ProfileItemPresenter> {
    public final ProfileItemModule a;
    public final Provider<PublishRelay<SelectProfileField>> b;

    public ProfileItemModule_ProvidePresenter$authorization_releaseFactory(ProfileItemModule profileItemModule, Provider<PublishRelay<SelectProfileField>> provider) {
        this.a = profileItemModule;
        this.b = provider;
    }

    public static ProfileItemModule_ProvidePresenter$authorization_releaseFactory create(ProfileItemModule profileItemModule, Provider<PublishRelay<SelectProfileField>> provider) {
        return new ProfileItemModule_ProvidePresenter$authorization_releaseFactory(profileItemModule, provider);
    }

    public static ProfileItemPresenter providePresenter$authorization_release(ProfileItemModule profileItemModule, PublishRelay<SelectProfileField> publishRelay) {
        return (ProfileItemPresenter) Preconditions.checkNotNullFromProvides(profileItemModule.providePresenter$authorization_release(publishRelay));
    }

    @Override // javax.inject.Provider
    public ProfileItemPresenter get() {
        return providePresenter$authorization_release(this.a, this.b.get());
    }
}
