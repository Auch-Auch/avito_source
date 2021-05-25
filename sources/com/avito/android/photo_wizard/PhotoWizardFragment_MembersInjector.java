package com.avito.android.photo_wizard;

import com.avito.android.Features;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhotoWizardFragment_MembersInjector implements MembersInjector<PhotoWizardFragment> {
    public final Provider<PhotoWizardViewModelFactory> a;
    public final Provider<WizardPhotoPickerPresenter> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<Features> d;

    public PhotoWizardFragment_MembersInjector(Provider<PhotoWizardViewModelFactory> provider, Provider<WizardPhotoPickerPresenter> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<PhotoWizardFragment> create(Provider<PhotoWizardViewModelFactory> provider, Provider<WizardPhotoPickerPresenter> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4) {
        return new PhotoWizardFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.photo_wizard.PhotoWizardFragment.features")
    public static void injectFeatures(PhotoWizardFragment photoWizardFragment, Features features) {
        photoWizardFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.photo_wizard.PhotoWizardFragment.intentFactory")
    public static void injectIntentFactory(PhotoWizardFragment photoWizardFragment, ImplicitIntentFactory implicitIntentFactory) {
        photoWizardFragment.intentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.photo_wizard.PhotoWizardFragment.presenter")
    public static void injectPresenter(PhotoWizardFragment photoWizardFragment, WizardPhotoPickerPresenter wizardPhotoPickerPresenter) {
        photoWizardFragment.presenter = wizardPhotoPickerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.photo_wizard.PhotoWizardFragment.viewModelFactory")
    public static void injectViewModelFactory(PhotoWizardFragment photoWizardFragment, PhotoWizardViewModelFactory photoWizardViewModelFactory) {
        photoWizardFragment.viewModelFactory = photoWizardViewModelFactory;
    }

    public void injectMembers(PhotoWizardFragment photoWizardFragment) {
        injectViewModelFactory(photoWizardFragment, this.a.get());
        injectPresenter(photoWizardFragment, this.b.get());
        injectIntentFactory(photoWizardFragment, this.c.get());
        injectFeatures(photoWizardFragment, this.d.get());
    }
}
