package com.avito.android.feedback_adverts;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackAdvertsIntentFactoryImpl_Factory implements Factory<FeedbackAdvertsIntentFactoryImpl> {
    public final Provider<Application> a;

    public FeedbackAdvertsIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static FeedbackAdvertsIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new FeedbackAdvertsIntentFactoryImpl_Factory(provider);
    }

    public static FeedbackAdvertsIntentFactoryImpl newInstance(Application application) {
        return new FeedbackAdvertsIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public FeedbackAdvertsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
