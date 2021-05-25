package com.avito.android.di.module;

import android.app.Application;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FirebaseInstanceIdModule_ProvideFirebaseInstanceIdFactory implements Factory<FirebaseInstanceId> {
    public final FirebaseInstanceIdModule a;
    public final Provider<Application> b;

    public FirebaseInstanceIdModule_ProvideFirebaseInstanceIdFactory(FirebaseInstanceIdModule firebaseInstanceIdModule, Provider<Application> provider) {
        this.a = firebaseInstanceIdModule;
        this.b = provider;
    }

    public static FirebaseInstanceIdModule_ProvideFirebaseInstanceIdFactory create(FirebaseInstanceIdModule firebaseInstanceIdModule, Provider<Application> provider) {
        return new FirebaseInstanceIdModule_ProvideFirebaseInstanceIdFactory(firebaseInstanceIdModule, provider);
    }

    public static FirebaseInstanceId provideFirebaseInstanceId(FirebaseInstanceIdModule firebaseInstanceIdModule, Application application) {
        return (FirebaseInstanceId) Preconditions.checkNotNullFromProvides(firebaseInstanceIdModule.provideFirebaseInstanceId(application));
    }

    @Override // javax.inject.Provider
    public FirebaseInstanceId get() {
        return provideFirebaseInstanceId(this.a, this.b.get());
    }
}
