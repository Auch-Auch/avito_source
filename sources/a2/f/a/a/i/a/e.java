package a2.f.a.a.i.a;

import a2.b.a.a.a;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.evernote.android.job.patched.internal.util.JobCat;
import java.io.File;
public final class e implements DatabaseErrorHandler {
    public static final JobCat a = new JobCat("DatabaseErrorHandler");

    public void a(String str) {
        if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
            JobCat jobCat = a;
            jobCat.e("deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                a.w(e, a.F2(e, a.L("delete failed: ")), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r4.hasNext() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        a((java.lang.String) r4.next().second);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        a(r4.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002a A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
      PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0025, B:8:0x002c, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0025] */
    @Override // android.database.DatabaseErrorHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCorruption(android.database.sqlite.SQLiteDatabase r4) {
        /*
            r3 = this;
            com.evernote.android.job.patched.internal.util.JobCat r0 = a2.f.a.a.i.a.e.a
            java.lang.String r1 = "Corruption reported by sqlite on database: "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r2 = r4.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.e(r1)
            boolean r0 = r4.isOpen()
            if (r0 != 0) goto L_0x0024
            java.lang.String r4 = r4.getPath()
            r3.a(r4)
            return
        L_0x0024:
            r0 = 0
            java.util.List r0 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x002c, all -> 0x002a }
            goto L_0x002c
        L_0x002a:
            r1 = move-exception
            goto L_0x0030
        L_0x002c:
            r4.close()     // Catch:{ SQLiteException -> 0x0052, all -> 0x002a }
            goto L_0x0053
        L_0x0030:
            if (r0 == 0) goto L_0x004a
            java.util.Iterator r4 = r0.iterator()
        L_0x0036:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r4.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r3.a(r0)
            goto L_0x0036
        L_0x004a:
            java.lang.String r4 = r4.getPath()
            r3.a(r4)
        L_0x0051:
            throw r1
        L_0x0052:
        L_0x0053:
            if (r0 == 0) goto L_0x006d
            java.util.Iterator r4 = r0.iterator()
        L_0x0059:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0074
            java.lang.Object r0 = r4.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r3.a(r0)
            goto L_0x0059
        L_0x006d:
            java.lang.String r4 = r4.getPath()
            r3.a(r4)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.f.a.a.i.a.e.onCorruption(android.database.sqlite.SQLiteDatabase):void");
    }
}
