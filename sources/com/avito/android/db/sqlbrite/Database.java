package com.avito.android.db.sqlbrite;

import android.content.ContentValues;
import android.database.Cursor;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.QueryObservable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/db/sqlbrite/Database;", "", "", "table", "sql", "", "args", "Lcom/squareup/sqlbrite2/QueryObservable;", "createQuery", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/squareup/sqlbrite2/QueryObservable;", "Lcom/squareup/sqlbrite2/BriteDatabase$Transaction;", "newTransaction", "()Lcom/squareup/sqlbrite2/BriteDatabase$Transaction;", "Landroid/content/ContentValues;", "contentValues", "", "insert", "(Ljava/lang/String;Landroid/content/ContentValues;)J", "whereClause", "whereArgs", "", "update", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V", PhoneActionStrings.REMOVE, "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "execute", "(Ljava/lang/String;)V", "Landroid/database/Cursor;", "query", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface Database {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void delete$default(Database database, String str, String str2, String[] strArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                database.delete(str, str2, strArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public static /* synthetic */ void update$default(Database database, String str, ContentValues contentValues, String str2, String[] strArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                database.update(str, contentValues, str2, strArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
    }

    @NotNull
    QueryObservable createQuery(@NotNull String str, @NotNull String str2, @NotNull String... strArr);

    void delete(@NotNull String str, @Nullable String str2, @NotNull String... strArr);

    void execute(@NotNull String str);

    long insert(@NotNull String str, @NotNull ContentValues contentValues);

    @NotNull
    BriteDatabase.Transaction newTransaction();

    @NotNull
    Cursor query(@NotNull String str, @NotNull String... strArr);

    void update(@NotNull String str, @NotNull ContentValues contentValues, @Nullable String str2, @NotNull String... strArr);
}
