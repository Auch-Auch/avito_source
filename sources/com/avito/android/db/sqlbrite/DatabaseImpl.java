package com.avito.android.db.sqlbrite;

import android.content.ContentValues;
import android.database.Cursor;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.QueryObservable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/db/sqlbrite/DatabaseImpl;", "Lcom/avito/android/db/sqlbrite/Database;", "", "sql", "", "execute", "(Ljava/lang/String;)V", "table", "whereClause", "", "whereArgs", PhoneActionStrings.REMOVE, "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Landroid/content/ContentValues;", "contentValues", "", "insert", "(Ljava/lang/String;Landroid/content/ContentValues;)J", "update", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/squareup/sqlbrite2/BriteDatabase$Transaction;", "newTransaction", "()Lcom/squareup/sqlbrite2/BriteDatabase$Transaction;", "args", "Lcom/squareup/sqlbrite2/QueryObservable;", "createQuery", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/squareup/sqlbrite2/QueryObservable;", "Landroid/database/Cursor;", "query", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "Lcom/squareup/sqlbrite2/BriteDatabase;", AuthSource.SEND_ABUSE, "Lcom/squareup/sqlbrite2/BriteDatabase;", UserDataStore.DATE_OF_BIRTH, "<init>", "(Lcom/squareup/sqlbrite2/BriteDatabase;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DatabaseImpl implements Database {
    public final BriteDatabase a;

    public DatabaseImpl(@NotNull BriteDatabase briteDatabase) {
        Intrinsics.checkNotNullParameter(briteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.a = briteDatabase;
    }

    @Override // com.avito.android.db.sqlbrite.Database
    @NotNull
    public QueryObservable createQuery(@NotNull String str, @NotNull String str2, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(str2, "sql");
        Intrinsics.checkNotNullParameter(strArr, "args");
        QueryObservable createQuery = this.a.createQuery(str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(createQuery, "db.createQuery(table, sql, *args)");
        return createQuery;
    }

    @Override // com.avito.android.db.sqlbrite.Database
    public void delete(@NotNull String str, @Nullable String str2, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(strArr, "whereArgs");
        this.a.delete(str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // com.avito.android.db.sqlbrite.Database
    public void execute(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.a.execute(str);
    }

    @Override // com.avito.android.db.sqlbrite.Database
    public long insert(@NotNull String str, @NotNull ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        return this.a.insert(str, contentValues, 5);
    }

    @Override // com.avito.android.db.sqlbrite.Database
    @NotNull
    public BriteDatabase.Transaction newTransaction() {
        BriteDatabase.Transaction newTransaction = this.a.newTransaction();
        Intrinsics.checkNotNullExpressionValue(newTransaction, "db.newTransaction()");
        return newTransaction;
    }

    @Override // com.avito.android.db.sqlbrite.Database
    @NotNull
    public Cursor query(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(strArr, "args");
        Cursor query = this.a.query(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(query, "db.query(sql, *args)");
        return query;
    }

    @Override // com.avito.android.db.sqlbrite.Database
    public void update(@NotNull String str, @NotNull ContentValues contentValues, @Nullable String str2, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Intrinsics.checkNotNullParameter(strArr, "whereArgs");
        this.a.update(str, contentValues, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
