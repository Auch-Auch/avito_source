package com.avito.android.analytics_firebase;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseEventObserver_Factory implements Factory<FirebaseEventObserver> {
    public final Provider<FirebaseEventTracker> a;
    public final Provider<SchedulersFactory> b;

    public FirebaseEventObserver_Factory(Provider<FirebaseEventTracker> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FirebaseEventObserver_Factory create(Provider<FirebaseEventTracker> provider, Provider<SchedulersFactory> provider2) {
        return new FirebaseEventObserver_Factory(provider, provider2);
    }

    public static FirebaseEventObserver newInstance(FirebaseEventTracker firebaseEventTracker, SchedulersFactory schedulersFactory) {
        return new FirebaseEventObserver(firebaseEventTracker, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public FirebaseEventObserver get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
