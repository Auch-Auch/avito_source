package com.avito.android.db.sqlbrite.di;

import com.avito.android.db.DbHelper;
import com.avito.android.util.SchedulersFactory;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BriteDbModule_ProvideBriteDatabaseFactory implements Factory<BriteDatabase> {
    public final Provider<SqlBrite> a;
    public final Provider<DbHelper> b;
    public final Provider<SchedulersFactory> c;

    public BriteDbModule_ProvideBriteDatabaseFactory(Provider<SqlBrite> provider, Provider<DbHelper> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BriteDbModule_ProvideBriteDatabaseFactory create(Provider<SqlBrite> provider, Provider<DbHelper> provider2, Provider<SchedulersFactory> provider3) {
        return new BriteDbModule_ProvideBriteDatabaseFactory(provider, provider2, provider3);
    }

    public static BriteDatabase provideBriteDatabase(SqlBrite sqlBrite, DbHelper dbHelper, SchedulersFactory schedulersFactory) {
        return (BriteDatabase) Preconditions.checkNotNullFromProvides(BriteDbModule.provideBriteDatabase(sqlBrite, dbHelper, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public BriteDatabase get() {
        return provideBriteDatabase(this.a.get(), this.b.get(), this.c.get());
    }
}
