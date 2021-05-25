package com.avito.android.profile.di;

import com.avito.android.profile.edit.refactoring.adapter.TextItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideTextlockItemPresenter$profile_releaseFactory implements Factory<TextItemPresenter> {

    public static final class a {
        public static final EditProfileModule_ProvideTextlockItemPresenter$profile_releaseFactory a = new EditProfileModule_ProvideTextlockItemPresenter$profile_releaseFactory();
    }

    public static EditProfileModule_ProvideTextlockItemPresenter$profile_releaseFactory create() {
        return a.a;
    }

    public static TextItemPresenter provideTextlockItemPresenter$profile_release() {
        return (TextItemPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideTextlockItemPresenter$profile_release());
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return provideTextlockItemPresenter$profile_release();
    }
}
