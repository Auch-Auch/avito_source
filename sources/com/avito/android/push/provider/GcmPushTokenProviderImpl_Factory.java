package com.avito.android.push.provider;

import com.avito.android.preferences.TokenStorage;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GcmPushTokenProviderImpl_Factory implements Factory<GcmPushTokenProviderImpl> {
    public final Provider<FirebaseInstanceId> a;
    public final Provider<TokenStorage> b;

    public GcmPushTokenProviderImpl_Factory(Provider<FirebaseInstanceId> provider, Provider<TokenStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GcmPushTokenProviderImpl_Factory create(Provider<FirebaseInstanceId> provider, Provider<TokenStorage> provider2) {
        return new GcmPushTokenProviderImpl_Factory(provider, provider2);
    }

    public static GcmPushTokenProviderImpl newInstance(FirebaseInstanceId firebaseInstanceId, TokenStorage tokenStorage) {
        return new GcmPushTokenProviderImpl(firebaseInstanceId, tokenStorage);
    }

    @Override // javax.inject.Provider
    public GcmPushTokenProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
