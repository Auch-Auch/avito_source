package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.PhoneInputItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvidePhoneInputItemPresenter$profile_releaseFactory implements Factory<PhoneInputItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvidePhoneInputItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvidePhoneInputItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvidePhoneInputItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static PhoneInputItemPresenter providePhoneInputItemPresenter$profile_release() {
        return (PhoneInputItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.providePhoneInputItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public PhoneInputItemPresenter get() {
        return providePhoneInputItemPresenter$profile_release();
    }
}
