package com.avito.android.call_feedback;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackIntentFactoryImpl_Factory implements Factory<CallFeedbackIntentFactoryImpl> {
    public final Provider<Application> a;

    public CallFeedbackIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static CallFeedbackIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new CallFeedbackIntentFactoryImpl_Factory(provider);
    }

    public static CallFeedbackIntentFactoryImpl newInstance(Application application) {
        return new CallFeedbackIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public CallFeedbackIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
