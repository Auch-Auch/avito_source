package com.avito.android.photo_wizard;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoWizardIntentFactoryImpl_Factory implements Factory<PhotoWizardIntentFactoryImpl> {
    public final Provider<Application> a;

    public PhotoWizardIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static PhotoWizardIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new PhotoWizardIntentFactoryImpl_Factory(provider);
    }

    public static PhotoWizardIntentFactoryImpl newInstance(Application application) {
        return new PhotoWizardIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public PhotoWizardIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
