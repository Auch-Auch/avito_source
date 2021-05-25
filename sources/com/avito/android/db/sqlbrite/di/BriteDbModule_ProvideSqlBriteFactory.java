package com.avito.android.db.sqlbrite.di;

import com.squareup.sqlbrite2.SqlBrite;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class BriteDbModule_ProvideSqlBriteFactory implements Factory<SqlBrite> {

    public static final class a {
        public static final BriteDbModule_ProvideSqlBriteFactory a = new BriteDbModule_ProvideSqlBriteFactory();
    }

    public static BriteDbModule_ProvideSqlBriteFactory create() {
        return a.a;
    }

    public static SqlBrite provideSqlBrite() {
        return (SqlBrite) Preconditions.checkNotNullFromProvides(BriteDbModule.provideSqlBrite());
    }

    @Override // javax.inject.Provider
    public SqlBrite get() {
        return provideSqlBrite();
    }
}
