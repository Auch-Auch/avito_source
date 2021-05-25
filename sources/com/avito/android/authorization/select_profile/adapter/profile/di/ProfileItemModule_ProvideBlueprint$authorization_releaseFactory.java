package com.avito.android.authorization.select_profile.adapter.profile.di;

import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileItemModule_ProvideBlueprint$authorization_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final ProfileItemModule a;
    public final Provider<ProfileItemPresenter> b;

    public ProfileItemModule_ProvideBlueprint$authorization_releaseFactory(ProfileItemModule profileItemModule, Provider<ProfileItemPresenter> provider) {
        this.a = profileItemModule;
        this.b = provider;
    }

    public static ProfileItemModule_ProvideBlueprint$authorization_releaseFactory create(ProfileItemModule profileItemModule, Provider<ProfileItemPresenter> provider) {
        return new ProfileItemModule_ProvideBlueprint$authorization_releaseFactory(profileItemModule, provider);
    }

    public static ItemBlueprint<?, ?> provideBlueprint$authorization_release(ProfileItemModule profileItemModule, ProfileItemPresenter profileItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(profileItemModule.provideBlueprint$authorization_release(profileItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideBlueprint$authorization_release(this.a, this.b.get());
    }
}
