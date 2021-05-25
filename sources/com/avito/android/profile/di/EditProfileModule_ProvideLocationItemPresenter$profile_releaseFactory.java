package com.avito.android.profile.di;

import com.avito.android.profile.edit.adapter.LocationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideLocationItemPresenter$profile_releaseFactory implements Factory<LocationItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideLocationItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideLocationItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideLocationItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static LocationItemPresenter provideLocationItemPresenter$profile_release() {
        return (LocationItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideLocationItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public LocationItemPresenter get() {
        return provideLocationItemPresenter$profile_release();
    }
}
