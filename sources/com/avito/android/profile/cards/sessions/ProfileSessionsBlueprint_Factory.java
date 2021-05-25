package com.avito.android.profile.cards.sessions;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileSessionsBlueprint_Factory implements Factory<ProfileSessionsBlueprint> {
    public final Provider<ProfileSessionsItemPresenter> a;

    public ProfileSessionsBlueprint_Factory(Provider<ProfileSessionsItemPresenter> provider) {
        this.a = provider;
    }

    public static ProfileSessionsBlueprint_Factory create(Provider<ProfileSessionsItemPresenter> provider) {
        return new ProfileSessionsBlueprint_Factory(provider);
    }

    public static ProfileSessionsBlueprint newInstance(ProfileSessionsItemPresenter profileSessionsItemPresenter) {
        return new ProfileSessionsBlueprint(profileSessionsItemPresenter);
    }

    @Override // javax.inject.Provider
    public ProfileSessionsBlueprint get() {
        return newInstance(this.a.get());
    }
}
