package com.avito.android.db.sqlbrite.di;

import com.avito.android.db.sqlbrite.Database;
import com.avito.android.util.BuildInfo;
import com.squareup.sqlbrite2.BriteDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BriteDbModule_ProvideDatabaseFactory implements Factory<Database> {
    public final Provider<BriteDatabase> a;
    public final Provider<BuildInfo> b;

    public BriteDbModule_ProvideDatabaseFactory(Provider<BriteDatabase> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BriteDbModule_ProvideDatabaseFactory create(Provider<BriteDatabase> provider, Provider<BuildInfo> provider2) {
        return new BriteDbModule_ProvideDatabaseFactory(provider, provider2);
    }

    public static Database provideDatabase(BriteDatabase briteDatabase, BuildInfo buildInfo) {
        return (Database) Preconditions.checkNotNullFromProvides(BriteDbModule.provideDatabase(briteDatabase, buildInfo));
    }

    @Override // javax.inject.Provider
    public Database get() {
        return provideDatabase(this.a.get(), this.b.get());
    }
}
