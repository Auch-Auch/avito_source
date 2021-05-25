package com.avito.android.photo_picker.edit.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.photo_picker.edit.EditPhotoViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditPhotoModule_ProvideViewModelFactory implements Factory<EditPhotoViewModel> {
    public final EditPhotoModule a;
    public final Provider<Fragment> b;
    public final Provider<ViewModelProvider.Factory> c;

    public EditPhotoModule_ProvideViewModelFactory(EditPhotoModule editPhotoModule, Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = editPhotoModule;
        this.b = provider;
        this.c = provider2;
    }

    public static EditPhotoModule_ProvideViewModelFactory create(EditPhotoModule editPhotoModule, Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new EditPhotoModule_ProvideViewModelFactory(editPhotoModule, provider, provider2);
    }

    public static EditPhotoViewModel provideViewModel(EditPhotoModule editPhotoModule, Fragment fragment, ViewModelProvider.Factory factory) {
        return (EditPhotoViewModel) Preconditions.checkNotNullFromProvides(editPhotoModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public EditPhotoViewModel get() {
        return provideViewModel(this.a, this.b.get(), this.c.get());
    }
}
