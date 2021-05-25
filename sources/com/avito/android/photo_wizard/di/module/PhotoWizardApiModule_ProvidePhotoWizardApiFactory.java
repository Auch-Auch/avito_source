package com.avito.android.photo_wizard.di.module;

import com.avito.android.photo_wizard.remote.PhotoWizardApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoWizardApiModule_ProvidePhotoWizardApiFactory implements Factory<PhotoWizardApi> {
    public final Provider<RetrofitFactory> a;

    public PhotoWizardApiModule_ProvidePhotoWizardApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PhotoWizardApiModule_ProvidePhotoWizardApiFactory create(Provider<RetrofitFactory> provider) {
        return new PhotoWizardApiModule_ProvidePhotoWizardApiFactory(provider);
    }

    public static PhotoWizardApi providePhotoWizardApi(RetrofitFactory retrofitFactory) {
        return (PhotoWizardApi) Preconditions.checkNotNullFromProvides(PhotoWizardApiModule.INSTANCE.providePhotoWizardApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PhotoWizardApi get() {
        return providePhotoWizardApi(this.a.get());
    }
}
