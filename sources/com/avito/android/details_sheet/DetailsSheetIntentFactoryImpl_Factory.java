package com.avito.android.details_sheet;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DetailsSheetIntentFactoryImpl_Factory implements Factory<DetailsSheetIntentFactoryImpl> {
    public final Provider<Application> a;

    public DetailsSheetIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static DetailsSheetIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new DetailsSheetIntentFactoryImpl_Factory(provider);
    }

    public static DetailsSheetIntentFactoryImpl newInstance(Application application) {
        return new DetailsSheetIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public DetailsSheetIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
