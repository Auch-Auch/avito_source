package com.avito.android.version_conflict;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VersionConflictIntentFactoryImpl_Factory implements Factory<VersionConflictIntentFactoryImpl> {
    public final Provider<Context> a;

    public VersionConflictIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static VersionConflictIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new VersionConflictIntentFactoryImpl_Factory(provider);
    }

    public static VersionConflictIntentFactoryImpl newInstance(Context context) {
        return new VersionConflictIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public VersionConflictIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
