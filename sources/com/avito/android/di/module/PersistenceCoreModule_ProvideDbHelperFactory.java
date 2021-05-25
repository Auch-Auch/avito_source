package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.db.DbHelper;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideDbHelperFactory implements Factory<DbHelper> {
    public final PersistenceCoreModule a;
    public final Provider<Application> b;
    public final Provider<BuildInfo> c;

    public PersistenceCoreModule_ProvideDbHelperFactory(PersistenceCoreModule persistenceCoreModule, Provider<Application> provider, Provider<BuildInfo> provider2) {
        this.a = persistenceCoreModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PersistenceCoreModule_ProvideDbHelperFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Application> provider, Provider<BuildInfo> provider2) {
        return new PersistenceCoreModule_ProvideDbHelperFactory(persistenceCoreModule, provider, provider2);
    }

    public static DbHelper provideDbHelper(PersistenceCoreModule persistenceCoreModule, Application application, BuildInfo buildInfo) {
        return (DbHelper) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideDbHelper(application, buildInfo));
    }

    @Override // javax.inject.Provider
    public DbHelper get() {
        return provideDbHelper(this.a, this.b.get(), this.c.get());
    }
}
