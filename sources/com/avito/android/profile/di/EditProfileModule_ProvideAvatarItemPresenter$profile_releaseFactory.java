package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.AvatarItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideAvatarItemPresenter$profile_releaseFactory implements Factory<AvatarItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideAvatarItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideAvatarItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideAvatarItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static AvatarItemPresenter provideAvatarItemPresenter$profile_release() {
        return (AvatarItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideAvatarItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public AvatarItemPresenter get() {
        return provideAvatarItemPresenter$profile_release();
    }
}
