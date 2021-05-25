package com.avito.android.photo_wizard;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoWizardResourceProviderImpl_Factory implements Factory<PhotoWizardResourceProviderImpl> {
    public final Provider<Resources> a;

    public PhotoWizardResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static PhotoWizardResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new PhotoWizardResourceProviderImpl_Factory(provider);
    }

    public static PhotoWizardResourceProviderImpl newInstance(Resources resources) {
        return new PhotoWizardResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public PhotoWizardResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
