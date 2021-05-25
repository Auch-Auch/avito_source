package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseCrashlyticsImpl_Factory implements Factory<FirebaseCrashlyticsImpl> {
    public final Provider<FirebaseCrashlyticsInitialization> a;

    public FirebaseCrashlyticsImpl_Factory(Provider<FirebaseCrashlyticsInitialization> provider) {
        this.a = provider;
    }

    public static FirebaseCrashlyticsImpl_Factory create(Provider<FirebaseCrashlyticsInitialization> provider) {
        return new FirebaseCrashlyticsImpl_Factory(provider);
    }

    public static FirebaseCrashlyticsImpl newInstance(FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization) {
        return new FirebaseCrashlyticsImpl(firebaseCrashlyticsInitialization);
    }

    @Override // javax.inject.Provider
    public FirebaseCrashlyticsImpl get() {
        return newInstance(this.a.get());
    }
}
