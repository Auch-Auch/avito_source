package com.avito.android.photo_wizard;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_wizard.converter.WizardStepsConverter;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class PhotoWizardViewModelFactory_Factory implements Factory<PhotoWizardViewModelFactory> {
    public final Provider<String> a;
    public final Provider<List<VerificationStep>> b;
    public final Provider<WizardStepsConverter> c;
    public final Provider<UploadPicturesInteractor> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<PhotoWizardResourceProvider> f;
    public final Provider<Analytics> g;

    public PhotoWizardViewModelFactory_Factory(Provider<String> provider, Provider<List<VerificationStep>> provider2, Provider<WizardStepsConverter> provider3, Provider<UploadPicturesInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<PhotoWizardResourceProvider> provider6, Provider<Analytics> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static PhotoWizardViewModelFactory_Factory create(Provider<String> provider, Provider<List<VerificationStep>> provider2, Provider<WizardStepsConverter> provider3, Provider<UploadPicturesInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<PhotoWizardResourceProvider> provider6, Provider<Analytics> provider7) {
        return new PhotoWizardViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PhotoWizardViewModelFactory newInstance(String str, List<VerificationStep> list, WizardStepsConverter wizardStepsConverter, UploadPicturesInteractor uploadPicturesInteractor, SchedulersFactory3 schedulersFactory3, PhotoWizardResourceProvider photoWizardResourceProvider, Analytics analytics) {
        return new PhotoWizardViewModelFactory(str, list, wizardStepsConverter, uploadPicturesInteractor, schedulersFactory3, photoWizardResourceProvider, analytics);
    }

    @Override // javax.inject.Provider
    public PhotoWizardViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
