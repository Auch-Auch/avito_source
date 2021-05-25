package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideSubLocationItemPresenter$profile_releaseFactory implements Factory<SubLocationItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideSubLocationItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideSubLocationItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideSubLocationItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static SubLocationItemPresenter provideSubLocationItemPresenter$profile_release() {
        return (SubLocationItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideSubLocationItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public SubLocationItemPresenter get() {
        return provideSubLocationItemPresenter$profile_release();
    }
}
