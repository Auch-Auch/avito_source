package androidx.room;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class InvalidationTracker {
    public static final String[] m = {"UPDATE", "DELETE", "INSERT"};
    @NonNull
    public final HashMap<String, Integer> a;
    public final String[] b;
    @NonNull
    public Map<String, Set<String>> c;
    public final RoomDatabase d;
    public AtomicBoolean e;
    public volatile boolean f;
    public volatile SupportSQLiteStatement g;
    public b h;
    public final l6.w.a i;
    @SuppressLint({"RestrictedApi"})
    @VisibleForTesting
    public final SafeIterableMap<Observer, c> j;
    public l6.w.b k;
    @VisibleForTesting
    public Runnable l;

    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor query = InvalidationTracker.this.d.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.g.executeUpdateDelete();
            }
            return hashSet;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
            r0.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
            throw r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[ExcHandler:  FINALLY, Splitter:B:1:0x000d] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r0 = r0.d
                java.util.concurrent.locks.ReentrantReadWriteLock r0 = r0.g
                java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
                r1 = 1
                r2 = 0
                r3 = 0
                r0.lock()     // Catch:{ all -> 0x0065 }
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this     // Catch:{ all -> 0x0065 }
                boolean r4 = r4.a()     // Catch:{ all -> 0x0065 }
                if (r4 != 0) goto L_0x001c
                r0.unlock()
                return
            L_0x001c:
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this     // Catch:{ SQLiteException | IllegalStateException -> 0x006a }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.e     // Catch:{ SQLiteException | IllegalStateException -> 0x006a }
                boolean r4 = r4.compareAndSet(r1, r2)     // Catch:{ SQLiteException | IllegalStateException -> 0x006a }
                if (r4 != 0) goto L_0x002a
                r0.unlock()
                return
            L_0x002a:
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r4 = r4.d
                boolean r4 = r4.inTransaction()
                if (r4 == 0) goto L_0x0038
                r0.unlock()
                return
            L_0x0038:
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r4 = r4.d
                boolean r5 = r4.f
                if (r5 == 0) goto L_0x0060
                androidx.sqlite.db.SupportSQLiteOpenHelper r4 = r4.getOpenHelper()
                androidx.sqlite.db.SupportSQLiteDatabase r4 = r4.getWritableDatabase()
                r4.beginTransaction()
                java.util.Set r5 = r11.a()     // Catch:{ all -> 0x005a }
                r4.setTransactionSuccessful()     // Catch:{ all -> 0x0058 }
                r4.endTransaction()     // Catch:{ SQLiteException | IllegalStateException -> 0x0056, all -> 0x0065 }
                goto L_0x006b
            L_0x0056:
                goto L_0x006b
            L_0x0058:
                r6 = move-exception
                goto L_0x005c
            L_0x005a:
                r6 = move-exception
                r5 = r3
            L_0x005c:
                r4.endTransaction()     // Catch:{ SQLiteException | IllegalStateException -> 0x0056, all -> 0x0065 }
                throw r6     // Catch:{ SQLiteException | IllegalStateException -> 0x0056, all -> 0x0065 }
            L_0x0060:
                java.util.Set r5 = r11.a()
                goto L_0x006b
            L_0x0065:
                r1 = move-exception
                r0.unlock()
                throw r1
            L_0x006a:
                r5 = r3
            L_0x006b:
                r0.unlock()
                if (r5 == 0) goto L_0x00cd
                boolean r0 = r5.isEmpty()
                if (r0 != 0) goto L_0x00cd
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$c> r0 = r0.j
                monitor-enter(r0)
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this     // Catch:{ all -> 0x00ca }
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$c> r4 = r4.j     // Catch:{ all -> 0x00ca }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00ca }
            L_0x0083:
                boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00ca }
                if (r6 == 0) goto L_0x00c8
                java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00ca }
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x00ca }
                java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00ca }
                androidx.room.InvalidationTracker$c r6 = (androidx.room.InvalidationTracker.c) r6     // Catch:{ all -> 0x00ca }
                int[] r7 = r6.a     // Catch:{ all -> 0x00ca }
                int r7 = r7.length     // Catch:{ all -> 0x00ca }
                r9 = r3
                r8 = 0
            L_0x009a:
                if (r8 >= r7) goto L_0x00c0
                int[] r10 = r6.a     // Catch:{ all -> 0x00ca }
                r10 = r10[r8]     // Catch:{ all -> 0x00ca }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00ca }
                boolean r10 = r5.contains(r10)     // Catch:{ all -> 0x00ca }
                if (r10 == 0) goto L_0x00bd
                if (r7 != r1) goto L_0x00af
                java.util.Set<java.lang.String> r9 = r6.d     // Catch:{ all -> 0x00ca }
                goto L_0x00bd
            L_0x00af:
                if (r9 != 0) goto L_0x00b6
                java.util.HashSet r9 = new java.util.HashSet     // Catch:{ all -> 0x00ca }
                r9.<init>(r7)     // Catch:{ all -> 0x00ca }
            L_0x00b6:
                java.lang.String[] r10 = r6.b     // Catch:{ all -> 0x00ca }
                r10 = r10[r8]     // Catch:{ all -> 0x00ca }
                r9.add(r10)     // Catch:{ all -> 0x00ca }
            L_0x00bd:
                int r8 = r8 + 1
                goto L_0x009a
            L_0x00c0:
                if (r9 == 0) goto L_0x0083
                androidx.room.InvalidationTracker$Observer r6 = r6.c     // Catch:{ all -> 0x00ca }
                r6.onInvalidated(r9)     // Catch:{ all -> 0x00ca }
                goto L_0x0083
            L_0x00c8:
                monitor-exit(r0)     // Catch:{ all -> 0x00ca }
                goto L_0x00cd
            L_0x00ca:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00ca }
                throw r1
            L_0x00cd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.a.run():void");
        }
    }

    public static class b {
        public final long[] a;
        public final boolean[] b;
        public final int[] c;
        public boolean d;
        public boolean e;

        public b(int i) {
            long[] jArr = new long[i];
            this.a = jArr;
            boolean[] zArr = new boolean[i];
            this.b = zArr;
            this.c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        @Nullable
        public int[] a() {
            synchronized (this) {
                if (this.d) {
                    if (!this.e) {
                        int length = this.a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.a[i] > 0;
                                boolean[] zArr = this.b;
                                if (z != zArr[i]) {
                                    int[] iArr = this.c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.c[i] = 0;
                                }
                                zArr[i] = z;
                                i++;
                            } else {
                                this.e = true;
                                this.d = false;
                                return this.c;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public static class c {
        public final int[] a;
        public final String[] b;
        public final Observer c;
        public final Set<String> d;

        public c(Observer observer, int[] iArr, String[] strArr) {
            this.c = observer;
            this.a = iArr;
            this.b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.d = null;
        }

        public void a(String[] strArr) {
            Set<String> set = null;
            if (this.b.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.b[0])) {
                        set = this.d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.b;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i2++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.c.onInvalidated(set);
            }
        }
    }

    public static class d extends Observer {
        public final InvalidationTracker b;
        public final WeakReference<Observer> c;

        public d(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.a);
            this.b = invalidationTracker;
            this.c = new WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            Observer observer = this.c.get();
            if (observer == null) {
                this.b.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    public boolean a() {
        if (!this.d.isOpen()) {
            return false;
        }
        if (!this.f) {
            this.d.getOpenHelper().getWritableDatabase();
        }
        if (!this.f) {
            return false;
        }
        return true;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@NonNull Observer observer) {
        c putIfAbsent;
        boolean z;
        String[] b2 = b(observer.a);
        int length = b2.length;
        int[] iArr = new int[length];
        int length2 = b2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.a.get(b2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                StringBuilder L = a2.b.a.a.a.L("There is no table with name ");
                L.append(b2[i2]);
                throw new IllegalArgumentException(L.toString());
            }
        }
        c cVar = new c(observer, iArr, b2);
        synchronized (this.j) {
            putIfAbsent = this.j.putIfAbsent(observer, cVar);
        }
        if (putIfAbsent == null) {
            b bVar = this.h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long[] jArr = bVar.a;
                    long j2 = jArr[i4];
                    jArr[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                e();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new d(this, observer));
    }

    public final String[] b(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                hashSet.addAll(this.c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void c(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            a2.b.a.a.a.n1(sb, str, "_", str2, "`");
            a2.b.a.a.a.n1(sb, " AFTER ", str2, " ON `", str);
            a2.b.a.a.a.n1(sb, "` BEGIN UPDATE ", "room_table_modification_log", " SET ", "invalidated");
            a2.b.a.a.a.n1(sb, " = 1", " WHERE ", "table_id", " = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    public final void d(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            supportSQLiteDatabase.execSQL(a2.b.a.a.a.v(sb, str, "_", str2, "`"));
        }
    }

    public void e() {
        if (this.d.isOpen()) {
            f(this.d.getOpenHelper().getWritableDatabase());
        }
    }

    public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!supportSQLiteDatabase.inTransaction()) {
            while (true) {
                ReentrantReadWriteLock.ReadLock readLock = this.d.g.readLock();
                readLock.lock();
                try {
                    int[] a3 = this.h.a();
                    if (a3 == null) {
                        try {
                            return;
                        } catch (SQLiteException | IllegalStateException unused) {
                            return;
                        }
                    } else {
                        int length = a3.length;
                        supportSQLiteDatabase.beginTransaction();
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                int i3 = a3[i2];
                                if (i3 == 1) {
                                    c(supportSQLiteDatabase, i2);
                                } else if (i3 == 2) {
                                    d(supportSQLiteDatabase, i2);
                                }
                            } catch (Throwable th) {
                                supportSQLiteDatabase.endTransaction();
                                throw th;
                            }
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        supportSQLiteDatabase.endTransaction();
                        b bVar = this.h;
                        synchronized (bVar) {
                            bVar.e = false;
                        }
                        readLock.unlock();
                    }
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public void notifyObserversByTableNames(String... strArr) {
        synchronized (this.j) {
            Iterator<Map.Entry<Observer, c>> it = this.j.iterator();
            while (it.hasNext()) {
                Map.Entry<Observer, c> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().a(strArr);
                }
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.e.compareAndSet(false, true)) {
            this.d.getQueryExecutor().execute(this.l);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        e();
        this.l.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@NonNull Observer observer) {
        c remove;
        boolean z;
        synchronized (this.j) {
            remove = this.j.remove(observer);
        }
        if (remove != null) {
            b bVar = this.h;
            int[] iArr = remove.a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long[] jArr = bVar.a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                e();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.e = new AtomicBoolean(false);
        this.f = false;
        this.j = new SafeIterableMap<>();
        this.l = new a();
        this.d = roomDatabase;
        this.h = new b(strArr.length);
        this.a = new HashMap<>();
        this.c = map2;
        this.i = new l6.w.a(roomDatabase);
        int length = strArr.length;
        this.b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.a.put(lowerCase, Integer.valueOf(i2));
            String str2 = map.get(strArr[i2]);
            if (str2 != null) {
                this.b[i2] = str2.toLowerCase(locale);
            } else {
                this.b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z, Callable<T> callable) {
        l6.w.a aVar = this.i;
        String[] b2 = b(strArr);
        for (String str : b2) {
            if (!this.a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(a2.b.a.a.a.c3("There is no table with name ", str));
            }
        }
        Objects.requireNonNull(aVar);
        return new l6.w.c(aVar.b, aVar, z, callable, b2);
    }

    public static abstract class Observer {
        public final String[] a;

        public Observer(@NonNull String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.a = strArr2;
            strArr2[strArr.length] = str;
        }

        public boolean a() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }
}
