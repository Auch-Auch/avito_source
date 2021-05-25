package com.avito.android.photo_picker.edit;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class EditPhotoFragment_MembersInjector implements MembersInjector<EditPhotoFragment> {
    public final Provider<EditPhotoViewModel> a;

    public EditPhotoFragment_MembersInjector(Provider<EditPhotoViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<EditPhotoFragment> create(Provider<EditPhotoViewModel> provider) {
        return new EditPhotoFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.edit.EditPhotoFragment.viewModel")
    public static void injectViewModel(EditPhotoFragment editPhotoFragment, EditPhotoViewModel editPhotoViewModel) {
        editPhotoFragment.viewModel = editPhotoViewModel;
    }

    public void injectMembers(EditPhotoFragment editPhotoFragment) {
        injectViewModel(editPhotoFragment, this.a.get());
    }
}
