package com.avito.android.db.sqlbrite.di;

import com.avito.android.db.DbHelper;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.db.sqlbrite.DatabaseImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.facebook.appevents.UserDataStore;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/db/sqlbrite/di/BriteDbModule;", "", "Lcom/squareup/sqlbrite2/SqlBrite;", "provideSqlBrite", "()Lcom/squareup/sqlbrite2/SqlBrite;", "sqlBrite", "Lcom/avito/android/db/DbHelper;", "helper", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/squareup/sqlbrite2/BriteDatabase;", "provideBriteDatabase", "(Lcom/squareup/sqlbrite2/SqlBrite;Lcom/avito/android/db/DbHelper;Lcom/avito/android/util/SchedulersFactory;)Lcom/squareup/sqlbrite2/BriteDatabase;", UserDataStore.DATE_OF_BIRTH, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/db/sqlbrite/Database;", "provideDatabase", "(Lcom/squareup/sqlbrite2/BriteDatabase;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/db/sqlbrite/Database;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BriteDbModule {
    @NotNull
    public static final BriteDbModule INSTANCE = new BriteDbModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final BriteDatabase provideBriteDatabase(@NotNull SqlBrite sqlBrite, @NotNull DbHelper dbHelper, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(sqlBrite, "sqlBrite");
        Intrinsics.checkNotNullParameter(dbHelper, "helper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        BriteDatabase wrapDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, schedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(wrapDatabaseHelper, "sqlBrite.wrapDatabaseHel…, schedulersFactory.io())");
        return wrapDatabaseHelper;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final Database provideDatabase(@NotNull BriteDatabase briteDatabase, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(briteDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        briteDatabase.setLoggingEnabled(buildInfo.isDebug());
        return new DatabaseImpl(briteDatabase);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SqlBrite provideSqlBrite() {
        SqlBrite build = new SqlBrite.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "SqlBrite.Builder().build()");
        return build;
    }
}
