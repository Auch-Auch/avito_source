package com.avito.android.photo_wizard;

import android.content.Context;
import com.avito.android.photo_wizard.remote.PhotoWizardApi;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UploadPicturesInteractorImpl_Factory implements Factory<UploadPicturesInteractorImpl> {
    public final Provider<PhotoWizardApi> a;
    public final Provider<Context> b;
    public final Provider<PrivatePhotosStorage> c;
    public final Provider<String> d;

    public UploadPicturesInteractorImpl_Factory(Provider<PhotoWizardApi> provider, Provider<Context> provider2, Provider<PrivatePhotosStorage> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UploadPicturesInteractorImpl_Factory create(Provider<PhotoWizardApi> provider, Provider<Context> provider2, Provider<PrivatePhotosStorage> provider3, Provider<String> provider4) {
        return new UploadPicturesInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static UploadPicturesInteractorImpl newInstance(PhotoWizardApi photoWizardApi, Context context, PrivatePhotosStorage privatePhotosStorage, String str) {
        return new UploadPicturesInteractorImpl(photoWizardApi, context, privatePhotosStorage, str);
    }

    @Override // javax.inject.Provider
    public UploadPicturesInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
