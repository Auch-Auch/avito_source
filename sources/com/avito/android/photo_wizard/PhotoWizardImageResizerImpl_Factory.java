package com.avito.android.photo_wizard;

import dagger.internal.Factory;
public final class PhotoWizardImageResizerImpl_Factory implements Factory<PhotoWizardImageResizerImpl> {

    public static final class a {
        public static final PhotoWizardImageResizerImpl_Factory a = new PhotoWizardImageResizerImpl_Factory();
    }

    public static PhotoWizardImageResizerImpl_Factory create() {
        return a.a;
    }

    public static PhotoWizardImageResizerImpl newInstance() {
        return new PhotoWizardImageResizerImpl();
    }

    @Override // javax.inject.Provider
    public PhotoWizardImageResizerImpl get() {
        return newInstance();
    }
}
