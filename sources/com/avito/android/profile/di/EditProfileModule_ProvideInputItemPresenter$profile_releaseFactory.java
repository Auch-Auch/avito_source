package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.InputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideInputItemPresenter$profile_releaseFactory implements Factory<InputItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideInputItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideInputItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideInputItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static InputItemPresenter provideInputItemPresenter$profile_release() {
        return (InputItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideInputItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public InputItemPresenter get() {
        return provideInputItemPresenter$profile_release();
    }
}
