package com.avito.android.di.module;

import com.avito.android.image_loader.fresco.FrescoMemoryTrimmableRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreTasksModule_ProvideFrescoMemoryTrimmableRegistry$application_releaseFactory implements Factory<FrescoMemoryTrimmableRegistry> {

    public static final class a {
        public static final CoreTasksModule_ProvideFrescoMemoryTrimmableRegistry$application_releaseFactory a = new CoreTasksModule_ProvideFrescoMemoryTrimmableRegistry$application_releaseFactory();
    }

    public static CoreTasksModule_ProvideFrescoMemoryTrimmableRegistry$application_releaseFactory create() {
        return a.a;
    }

    public static FrescoMemoryTrimmableRegistry provideFrescoMemoryTrimmableRegistry$application_release() {
        return (FrescoMemoryTrimmableRegistry) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideFrescoMemoryTrimmableRegistry$application_release());
    }

    @Override // javax.inject.Provider
    public FrescoMemoryTrimmableRegistry get() {
        return provideFrescoMemoryTrimmableRegistry$application_release();
    }
}
