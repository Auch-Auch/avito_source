package com.avito.android.analytics_firebase;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseImpl_Factory implements Factory<FirebaseImpl> {
    public final Provider<Context> a;

    public FirebaseImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static FirebaseImpl_Factory create(Provider<Context> provider) {
        return new FirebaseImpl_Factory(provider);
    }

    public static FirebaseImpl newInstance(Context context) {
        return new FirebaseImpl(context);
    }

    @Override // javax.inject.Provider
    public FirebaseImpl get() {
        return newInstance(this.a.get());
    }
}
