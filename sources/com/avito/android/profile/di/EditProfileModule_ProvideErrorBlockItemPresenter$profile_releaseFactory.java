package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.ErrorLabelItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideErrorBlockItemPresenter$profile_releaseFactory implements Factory<ErrorLabelItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideErrorBlockItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideErrorBlockItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideErrorBlockItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static ErrorLabelItemPresenter provideErrorBlockItemPresenter$profile_release() {
        return (ErrorLabelItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideErrorBlockItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public ErrorLabelItemPresenter get() {
        return provideErrorBlockItemPresenter$profile_release();
    }
}
