package androidx.sqlite.db;

import a2.b.a.a.a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.File;
public interface SupportSQLiteOpenHelper extends Closeable {

    public static abstract class Callback {
        public final int version;

        public Callback(int i) {
            this.version = i;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public void onConfigure(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r0 != null) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            r3 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
            if (r3.hasNext() != false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            a((java.lang.String) r3.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
            a(r3.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0017 A[ExcHandler: all (r1v0 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v9 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v1 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0012, B:8:0x0019, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0012] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                r3.getPath()
                boolean r0 = r3.isOpen()
                if (r0 != 0) goto L_0x0011
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
                return
            L_0x0011:
                r0 = 0
                java.util.List r0 = r3.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0019, all -> 0x0017 }
                goto L_0x0019
            L_0x0017:
                r1 = move-exception
                goto L_0x001d
            L_0x0019:
                r3.close()     // Catch:{ IOException -> 0x003f, all -> 0x0017 }
                goto L_0x0040
            L_0x001d:
                if (r0 == 0) goto L_0x0037
                java.util.Iterator r3 = r0.iterator()
            L_0x0023:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x003e
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x0023
            L_0x0037:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x003e:
                throw r1
            L_0x003f:
            L_0x0040:
                if (r0 == 0) goto L_0x005a
                java.util.Iterator r3 = r0.iterator()
            L_0x0046:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0061
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x0046
            L_0x005a:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x0061:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new SQLiteException(a.R2("Can't downgrade database from version ", i, " to ", i2));
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    public static class Configuration {
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;
        public final boolean useNoBackupDirectory;

        public static class Builder {
            public Context a;
            public String b;
            public Callback c;
            public boolean d;

            public Builder(@NonNull Context context) {
                this.a = context;
            }

            @NonNull
            public Configuration build() {
                if (this.c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.d || !TextUtils.isEmpty(this.b)) {
                    return new Configuration(this.a, this.b, this.c, this.d);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            @NonNull
            public Builder callback(@NonNull Callback callback) {
                this.c = callback;
                return this;
            }

            @NonNull
            public Builder name(@Nullable String str) {
                this.b = str;
                return this;
            }

            @NonNull
            public Builder noBackupDirectory(boolean z) {
                this.d = z;
                return this;
            }
        }

        public Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2, boolean z) {
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
        }

        @NonNull
        public static Builder builder(@NonNull Context context2) {
            return new Builder(context2);
        }
    }

    public interface Factory {
        @NonNull
        SupportSQLiteOpenHelper create(@NonNull Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
