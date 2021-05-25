package l6.x.a.a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
public class b implements SupportSQLiteOpenHelper {
    public final Context a;
    public final String b;
    public final SupportSQLiteOpenHelper.Callback c;
    public final boolean d;
    public final Object e = new Object();
    public a f;
    public boolean g;

    public static class a extends SQLiteOpenHelper {
        public final a[] a;
        public final SupportSQLiteOpenHelper.Callback b;
        public boolean c;

        /* renamed from: l6.x.a.a.b$a$a  reason: collision with other inner class name */
        public class C0543a implements DatabaseErrorHandler {
            public final /* synthetic */ SupportSQLiteOpenHelper.Callback a;
            public final /* synthetic */ a[] b;

            public C0543a(SupportSQLiteOpenHelper.Callback callback, a[] aVarArr) {
                this.a = callback;
                this.b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.a.onCorruption(a.c(this.b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, a[] aVarArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.version, new C0543a(callback, aVarArr));
            this.b = callback;
            this.a = aVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.a == r3) == false) goto L_0x000e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static l6.x.a.a.a c(l6.x.a.a.a[] r2, android.database.sqlite.SQLiteDatabase r3) {
            /*
                r0 = 0
                r1 = r2[r0]
                if (r1 == 0) goto L_0x000e
                android.database.sqlite.SQLiteDatabase r1 = r1.a
                if (r1 != r3) goto L_0x000b
                r1 = 1
                goto L_0x000c
            L_0x000b:
                r1 = 0
            L_0x000c:
                if (r1 != 0) goto L_0x0015
            L_0x000e:
                l6.x.a.a.a r1 = new l6.x.a.a.a
                r1.<init>(r3)
                r2[r0] = r1
            L_0x0015:
                r2 = r2[r0]
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.x.a.a.b.a.c(l6.x.a.a.a[], android.database.sqlite.SQLiteDatabase):l6.x.a.a.a");
        }

        public synchronized SupportSQLiteDatabase a() {
            this.c = false;
            SQLiteDatabase readableDatabase = getReadableDatabase();
            if (this.c) {
                close();
                return a();
            }
            return b(readableDatabase);
        }

        public a b(SQLiteDatabase sQLiteDatabase) {
            return c(this.a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.a[0] = null;
        }

        public synchronized SupportSQLiteDatabase d() {
            this.c = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (this.c) {
                close();
                return d();
            }
            return b(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.b.onConfigure(c(this.a, sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.b.onCreate(c(this.a, sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.onDowngrade(c(this.a, sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                this.b.onOpen(c(this.a, sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.onUpgrade(c(this.a, sQLiteDatabase), i, i2);
        }
    }

    public b(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z) {
        this.a = context;
        this.b = str;
        this.c = callback;
        this.d = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.e) {
            if (this.f == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.b == null || !this.d) {
                    this.f = new a(this.a, this.b, aVarArr, this.c);
                } else {
                    this.f = new a(this.a, new File(this.a.getNoBackupFilesDir(), this.b).getAbsolutePath(), aVarArr, this.c);
                }
                this.f.setWriteAheadLoggingEnabled(this.g);
            }
            aVar = this.f;
        }
        return aVar;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return a().a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return a().d();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.e) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.g = z;
        }
    }
}
