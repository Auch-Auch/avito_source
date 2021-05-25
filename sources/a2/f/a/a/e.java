package a2.f.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e {
    public static final JobCat g = new JobCat("JobStorage");
    public final SharedPreferences a;
    public final a b = new a();
    public AtomicInteger c;
    public final Set<String> d;
    public final b e;
    public final ReadWriteLock f = new ReentrantReadWriteLock();

    public class a extends LruCache<Integer, JobRequest> {
        public a() {
            super(30);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            if (r4 != null) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
            if (r4 == null) goto L_0x005e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
        @Override // android.util.LruCache
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.evernote.android.job.JobRequest create(java.lang.Integer r13) {
            /*
                r12 = this;
                java.lang.Integer r13 = (java.lang.Integer) r13
                a2.f.a.a.e r0 = a2.f.a.a.e.this
                int r13 = r13.intValue()
                boolean r1 = r0.b(r13)
                r2 = 0
                if (r1 == 0) goto L_0x0010
                goto L_0x0061
            L_0x0010:
                r1 = 0
                r3 = 1
                java.lang.String r7 = "_id=?"
                android.database.sqlite.SQLiteDatabase r0 = r0.c()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
                java.lang.String r5 = "jobs"
                r6 = 0
                java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ Exception -> 0x003f, all -> 0x003d }
                java.lang.String r4 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
                r8[r1] = r4     // Catch:{ Exception -> 0x003f, all -> 0x003d }
                r9 = 0
                r10 = 0
                r11 = 0
                r4 = r0
                android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
                if (r4 == 0) goto L_0x003a
                boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x0038 }
                if (r5 == 0) goto L_0x003a
                com.evernote.android.job.JobRequest r2 = com.evernote.android.job.JobRequest.a(r4)     // Catch:{ Exception -> 0x0038 }
                goto L_0x005b
            L_0x0038:
                r5 = move-exception
                goto L_0x004a
            L_0x003a:
                if (r4 == 0) goto L_0x005e
                goto L_0x005b
            L_0x003d:
                r13 = move-exception
                goto L_0x0064
            L_0x003f:
                r4 = move-exception
                r5 = r4
                r4 = r2
                goto L_0x004a
            L_0x0043:
                r13 = move-exception
                r0 = r2
                goto L_0x0064
            L_0x0046:
                r0 = move-exception
                r5 = r0
                r0 = r2
                r4 = r0
            L_0x004a:
                com.evernote.android.job.util.JobCat r6 = a2.f.a.a.e.g     // Catch:{ all -> 0x0062 }
                java.lang.String r7 = "could not load id %d"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0062 }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0062 }
                r3[r1] = r13     // Catch:{ all -> 0x0062 }
                r6.e(r5, r7, r3)     // Catch:{ all -> 0x0062 }
                if (r4 == 0) goto L_0x005e
            L_0x005b:
                r4.close()     // Catch:{ Exception -> 0x005e }
            L_0x005e:
                a2.f.a.a.e.a(r0)
            L_0x0061:
                return r2
            L_0x0062:
                r13 = move-exception
                r2 = r4
            L_0x0064:
                if (r2 == 0) goto L_0x0069
                r2.close()     // Catch:{ Exception -> 0x0069 }
            L_0x0069:
                a2.f.a.a.e.a(r0)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.f.a.a.e.a.create(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b extends SQLiteOpenHelper {
        public b(Context context, String str, d dVar) {
            super(context, str, null, 6, new f());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table jobs (_id integer primary key, tag text not null, startMs integer, endMs integer, backoffMs integer, backoffPolicy text not null, intervalMs integer, requirementsEnforced integer, requiresCharging integer, requiresDeviceIdle integer, exact integer, networkType text not null, extras text, numFailures integer, scheduledAt integer, started integer, flexMs integer, flexSupport integer, lastRun integer, transient integer, requiresBatteryNotLow integer, requiresStorageNotLow integer);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            while (i < i2) {
                if (i == 1) {
                    sQLiteDatabase.execSQL("alter table jobs add column isTransient integer;");
                } else if (i == 2) {
                    sQLiteDatabase.execSQL("alter table jobs add column flexMs integer;");
                    sQLiteDatabase.execSQL("alter table jobs add column flexSupport integer;");
                    ContentValues contentValues = new ContentValues();
                    long j = JobRequest.MIN_INTERVAL;
                    contentValues.put("intervalMs", Long.valueOf(j));
                    sQLiteDatabase.update("jobs", contentValues, "intervalMs>0 AND intervalMs<" + j, new String[0]);
                    sQLiteDatabase.execSQL("update jobs set flexMs = intervalMs;");
                } else if (i == 3) {
                    sQLiteDatabase.execSQL("alter table jobs add column lastRun integer;");
                } else if (i == 4) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL("create table jobs_new (_id integer primary key, tag text not null, startMs integer, endMs integer, backoffMs integer, backoffPolicy text not null, intervalMs integer, requirementsEnforced integer, requiresCharging integer, requiresDeviceIdle integer, exact integer, networkType text not null, " + AppLinkData.ARGUMENTS_EXTRAS_KEY + " text, numFailures integer, scheduledAt integer, started integer, flexMs integer, flexSupport integer, lastRun integer);");
                        sQLiteDatabase.execSQL("INSERT INTO jobs_new SELECT _id,tag,startMs,endMs,backoffMs,backoffPolicy,intervalMs,requirementsEnforced,requiresCharging,requiresDeviceIdle,exact,networkType,extras,numFailures,scheduledAt,isTransient,flexMs,flexSupport,lastRun FROM jobs");
                        sQLiteDatabase.execSQL("DROP TABLE jobs");
                        sQLiteDatabase.execSQL("ALTER TABLE jobs_new RENAME TO jobs");
                        sQLiteDatabase.execSQL("alter table jobs add column transient integer;");
                        sQLiteDatabase.setTransactionSuccessful();
                    } finally {
                        sQLiteDatabase.endTransaction();
                    }
                } else if (i == 5) {
                    sQLiteDatabase.execSQL("alter table jobs add column requiresBatteryNotLow integer;");
                    sQLiteDatabase.execSQL("alter table jobs add column requiresStorageNotLow integer;");
                } else {
                    throw new IllegalStateException("not implemented");
                }
                i++;
            }
        }
    }

    public e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("evernote_jobs", 0);
        this.a = sharedPreferences;
        this.e = new b(context, "evernote_jobs.db", null);
        Set<String> stringSet = sharedPreferences.getStringSet("FAILED_DELETE_IDS", new HashSet());
        this.d = stringSet;
        if (!stringSet.isEmpty()) {
            new d(this, "CleanupFinishedJobsThread").start();
        }
    }

    public static void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null && JobConfig.isCloseDatabase()) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            }
        }
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.d) {
            z = !this.d.isEmpty() && this.d.contains(String.valueOf(i));
        }
        return z;
    }

    @NonNull
    @VisibleForTesting
    public SQLiteDatabase c() {
        try {
            return this.e.getWritableDatabase();
        } catch (SQLiteCantOpenDatabaseException e2) {
            g.e(e2);
            new f().a("evernote_jobs.db");
            return this.e.getWritableDatabase();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0033 A[SYNTHETIC, Splitter:B:25:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0051 A[SYNTHETIC, Splitter:B:32:0x0051] */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.c()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.lang.String r3 = "SELECT MAX(_id) FROM jobs"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x0019
            boolean r3 = r1.moveToFirst()     // Catch:{ Exception -> 0x0025 }
            if (r3 == 0) goto L_0x0019
            int r3 = r1.getInt(r0)     // Catch:{ Exception -> 0x0025 }
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            a(r2)
            goto L_0x003a
        L_0x0023:
            r0 = move-exception
            goto L_0x004f
        L_0x0025:
            r3 = move-exception
            goto L_0x002c
        L_0x0027:
            r0 = move-exception
            r2 = r1
            goto L_0x004f
        L_0x002a:
            r3 = move-exception
            r2 = r1
        L_0x002c:
            com.evernote.android.job.util.JobCat r4 = a2.f.a.a.e.g     // Catch:{ all -> 0x0023 }
            r4.e(r3)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0036
            r1.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            a(r2)
            r3 = 0
        L_0x003a:
            int r1 = com.evernote.android.job.JobConfig.getJobIdOffset()
            android.content.SharedPreferences r2 = r5.a
            java.lang.String r4 = "JOB_ID_COUNTER_v2"
            int r0 = r2.getInt(r4, r0)
            int r0 = java.lang.Math.max(r3, r0)
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.f.a.a.e.d():int");
    }

    public void e(JobRequest jobRequest) {
        this.f.writeLock().lock();
        try {
            h(jobRequest);
            this.b.put(Integer.valueOf(jobRequest.getJobId()), jobRequest);
        } finally {
            this.f.writeLock().unlock();
        }
    }

    public void f(JobRequest jobRequest) {
        g(jobRequest, jobRequest.getJobId());
    }

    public final boolean g(@Nullable JobRequest jobRequest, int i) {
        this.f.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            this.b.remove(Integer.valueOf(i));
            sQLiteDatabase = c();
            sQLiteDatabase.delete("jobs", "_id=?", new String[]{String.valueOf(i)});
            a(sQLiteDatabase);
            this.f.writeLock().unlock();
            return true;
        } catch (Exception e2) {
            g.e(e2, "could not delete %d %s", Integer.valueOf(i), jobRequest);
            synchronized (this.d) {
                this.d.add(String.valueOf(i));
                this.a.edit().putStringSet("FAILED_DELETE_IDS", this.d).apply();
                a(sQLiteDatabase);
                this.f.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            a(sQLiteDatabase);
            this.f.writeLock().unlock();
            throw th;
        }
    }

    public final void h(JobRequest jobRequest) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Objects.requireNonNull(jobRequest);
        ContentValues contentValues = new ContentValues();
        JobRequest.Builder builder = jobRequest.a;
        contentValues.put("_id", Integer.valueOf(builder.a));
        contentValues.put("tag", builder.b);
        contentValues.put("startMs", Long.valueOf(builder.c));
        contentValues.put("endMs", Long.valueOf(builder.d));
        contentValues.put("backoffMs", Long.valueOf(builder.e));
        contentValues.put("backoffPolicy", builder.f.toString());
        contentValues.put("intervalMs", Long.valueOf(builder.g));
        contentValues.put("flexMs", Long.valueOf(builder.h));
        contentValues.put("requirementsEnforced", Boolean.valueOf(builder.i));
        contentValues.put("requiresCharging", Boolean.valueOf(builder.j));
        contentValues.put("requiresDeviceIdle", Boolean.valueOf(builder.k));
        contentValues.put("requiresBatteryNotLow", Boolean.valueOf(builder.l));
        contentValues.put("requiresStorageNotLow", Boolean.valueOf(builder.m));
        contentValues.put("exact", Boolean.valueOf(builder.n));
        contentValues.put("networkType", builder.o.toString());
        PersistableBundleCompat persistableBundleCompat = builder.p;
        if (persistableBundleCompat != null) {
            contentValues.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, persistableBundleCompat.saveToXml());
        } else if (!TextUtils.isEmpty(builder.q)) {
            contentValues.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, builder.q);
        }
        contentValues.put(FacebookRequestErrorClassification.KEY_TRANSIENT, Boolean.valueOf(builder.s));
        contentValues.put("numFailures", Integer.valueOf(jobRequest.b));
        contentValues.put("scheduledAt", Long.valueOf(jobRequest.c));
        contentValues.put("started", Boolean.valueOf(jobRequest.d));
        contentValues.put("flexSupport", Boolean.valueOf(jobRequest.e));
        contentValues.put("lastRun", Long.valueOf(jobRequest.f));
        try {
            sQLiteDatabase = c();
            try {
                if (sQLiteDatabase.insertWithOnConflict("jobs", null, contentValues, 5) >= 0) {
                    a(sQLiteDatabase);
                    return;
                }
                throw new SQLException("Couldn't insert job request into database");
            } catch (Throwable th2) {
                th = th2;
                a(sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
            a(sQLiteDatabase);
            throw th;
        }
    }

    public void i(JobRequest jobRequest, ContentValues contentValues) {
        this.f.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            this.b.put(Integer.valueOf(jobRequest.getJobId()), jobRequest);
            sQLiteDatabase = c();
            sQLiteDatabase.update("jobs", contentValues, "_id=?", new String[]{String.valueOf(jobRequest.getJobId())});
        } catch (Exception e2) {
            g.e(e2, "could not update %s", jobRequest);
        } catch (Throwable th) {
            a(sQLiteDatabase);
            this.f.writeLock().unlock();
            throw th;
        }
        a(sQLiteDatabase);
        this.f.writeLock().unlock();
    }
}
