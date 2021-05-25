package com.avito.android.location.di.module;

import com.avito.android.util.WeakHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory implements Factory<WeakHandler> {

    public static final class a {
        public static final FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory a = new FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory();
    }

    public static FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory create() {
        return a.a;
    }

    public static WeakHandler provideWeakHandler$user_location_release() {
        return (WeakHandler) Preconditions.checkNotNullFromProvides(FindDetectLocationModule.provideWeakHandler$user_location_release());
    }

    @Override // javax.inject.Provider
    public WeakHandler get() {
        return provideWeakHandler$user_location_release();
    }
}
