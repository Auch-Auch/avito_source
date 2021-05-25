package com.avito.android.photo_wizard.converter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class WizardStepsConverterImpl_Factory implements Factory<WizardStepsConverterImpl> {
    public final Provider<DocumentTypesConverter> a;

    public WizardStepsConverterImpl_Factory(Provider<DocumentTypesConverter> provider) {
        this.a = provider;
    }

    public static WizardStepsConverterImpl_Factory create(Provider<DocumentTypesConverter> provider) {
        return new WizardStepsConverterImpl_Factory(provider);
    }

    public static WizardStepsConverterImpl newInstance(DocumentTypesConverter documentTypesConverter) {
        return new WizardStepsConverterImpl(documentTypesConverter);
    }

    @Override // javax.inject.Provider
    public WizardStepsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
