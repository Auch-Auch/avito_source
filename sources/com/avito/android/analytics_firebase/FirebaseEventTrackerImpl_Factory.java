package com.avito.android.analytics_firebase;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseEventTrackerImpl_Factory implements Factory<FirebaseEventTrackerImpl> {
    public final Provider<Firebase> a;

    public FirebaseEventTrackerImpl_Factory(Provider<Firebase> provider) {
        this.a = provider;
    }

    public static FirebaseEventTrackerImpl_Factory create(Provider<Firebase> provider) {
        return new FirebaseEventTrackerImpl_Factory(provider);
    }

    public static FirebaseEventTrackerImpl newInstance(Firebase firebase) {
        return new FirebaseEventTrackerImpl(firebase);
    }

    @Override // javax.inject.Provider
    public FirebaseEventTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
