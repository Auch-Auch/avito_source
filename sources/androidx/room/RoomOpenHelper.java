package androidx.room;

import a2.b.a.a.a;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    @Nullable
    public DatabaseConfiguration a;
    @NonNull
    public final Delegate b;
    @NonNull
    public final String c;
    @NonNull
    public final String d;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @NonNull
        public ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, null);
        }

        @Deprecated
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {
        @Nullable
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, @Nullable String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str, @NonNull String str2) {
        super(delegate.version);
        this.a = databaseConfiguration;
        this.b = delegate;
        this.c = str;
        this.d = str2;
    }

    public final void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.c));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (query.moveToFirst() && query.getInt(0) == 0) {
                z = true;
            }
            query.close();
            this.b.createAllTables(supportSQLiteDatabase);
            if (!z) {
                ValidationResult onValidateSchema = this.b.onValidateSchema(supportSQLiteDatabase);
                if (!onValidateSchema.isValid) {
                    StringBuilder L = a.L("Pre-packaged database has an invalid schema: ");
                    L.append(onValidateSchema.expectedFoundMsg);
                    throw new IllegalStateException(L.toString());
                }
            }
            b(supportSQLiteDatabase);
            this.b.onCreate(supportSQLiteDatabase);
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        onUpgrade(supportSQLiteDatabase, i, i2);
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        Cursor query = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = query.moveToFirst() && query.getInt(0) != 0;
            query.close();
            if (z) {
                Cursor query2 = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
                try {
                    String string = query2.moveToFirst() ? query2.getString(0) : null;
                    query2.close();
                    if (!this.c.equals(string) && !this.d.equals(string)) {
                        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                    }
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            } else {
                ValidationResult onValidateSchema = this.b.onValidateSchema(supportSQLiteDatabase);
                if (onValidateSchema.isValid) {
                    this.b.onPostMigrate(supportSQLiteDatabase);
                    b(supportSQLiteDatabase);
                } else {
                    StringBuilder L = a.L("Pre-packaged database has an invalid schema: ");
                    L.append(onValidateSchema.expectedFoundMsg);
                    throw new IllegalStateException(L.toString());
                }
            }
            this.b.onOpen(supportSQLiteDatabase);
            this.a = null;
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        boolean z;
        List<Migration> findMigrationPath;
        DatabaseConfiguration databaseConfiguration = this.a;
        if (databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i, i2)) == null) {
            z = false;
        } else {
            this.b.onPreMigrate(supportSQLiteDatabase);
            for (Migration migration : findMigrationPath) {
                migration.migrate(supportSQLiteDatabase);
            }
            ValidationResult onValidateSchema = this.b.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.b.onPostMigrate(supportSQLiteDatabase);
                b(supportSQLiteDatabase);
                z = true;
            } else {
                StringBuilder L = a.L("Migration didn't properly handle: ");
                L.append(onValidateSchema.expectedFoundMsg);
                throw new IllegalStateException(L.toString());
            }
        }
        if (!z) {
            DatabaseConfiguration databaseConfiguration2 = this.a;
            if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i, i2)) {
                throw new IllegalStateException(a.S2("A migration from ", i, " to ", i2, " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods."));
            }
            this.b.dropAllTables(supportSQLiteDatabase);
            this.b.createAllTables(supportSQLiteDatabase);
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str) {
        this(databaseConfiguration, delegate, "", str);
    }
}
