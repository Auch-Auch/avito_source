package com.avito.android.imv;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImvWebViewBottomSheetIntentFactoryImpl_Factory implements Factory<ImvWebViewBottomSheetIntentFactoryImpl> {
    public final Provider<Application> a;

    public ImvWebViewBottomSheetIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ImvWebViewBottomSheetIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new ImvWebViewBottomSheetIntentFactoryImpl_Factory(provider);
    }

    public static ImvWebViewBottomSheetIntentFactoryImpl newInstance(Application application) {
        return new ImvWebViewBottomSheetIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public ImvWebViewBottomSheetIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
