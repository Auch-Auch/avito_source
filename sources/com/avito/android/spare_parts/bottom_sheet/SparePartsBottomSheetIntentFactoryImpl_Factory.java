package com.avito.android.spare_parts.bottom_sheet;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsBottomSheetIntentFactoryImpl_Factory implements Factory<SparePartsBottomSheetIntentFactoryImpl> {
    public final Provider<Application> a;

    public SparePartsBottomSheetIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static SparePartsBottomSheetIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new SparePartsBottomSheetIntentFactoryImpl_Factory(provider);
    }

    public static SparePartsBottomSheetIntentFactoryImpl newInstance(Application application) {
        return new SparePartsBottomSheetIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public SparePartsBottomSheetIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
