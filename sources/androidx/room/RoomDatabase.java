package androidx.room;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.avito.android.lib.design.input.FormatterType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l6.w.b;
import l6.w.d;
import l6.w.e;
import l6.w.f;
public abstract class RoomDatabase {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    public Executor a;
    public Executor b;
    public SupportSQLiteOpenHelper c;
    public final InvalidationTracker d;
    public boolean e;
    public boolean f;
    public final ReentrantReadWriteLock g = new ReentrantReadWriteLock();
    public final ThreadLocal<Integer> h = new ThreadLocal<>();
    @Nullable
    @Deprecated
    public List<Callback> mCallbacks;
    @Deprecated
    public volatile SupportSQLiteDatabase mDatabase;

    public static class Builder<T extends RoomDatabase> {
        public final Class<T> a;
        public final String b;
        public final Context c;
        public ArrayList<Callback> d;
        public Executor e;
        public Executor f;
        public SupportSQLiteOpenHelper.Factory g;
        public boolean h;
        public JournalMode i = JournalMode.AUTOMATIC;
        public boolean j;
        public boolean k = true;
        public boolean l;
        public final MigrationContainer m = new MigrationContainer();
        public Set<Integer> n;
        public Set<Integer> o;
        public String p;
        public File q;

        public Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            this.c = context;
            this.a = cls;
            this.b = str;
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback callback) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(callback);
            return this;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... migrationArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.o.add(Integer.valueOf(migration.startVersion));
                this.o.add(Integer.valueOf(migration.endVersion));
            }
            this.m.addMigrations(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            this.h = true;
            return this;
        }

        @NonNull
        @SuppressLint({"RestrictedApi"})
        public T build() {
            Executor executor;
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.a != null) {
                Executor executor2 = this.e;
                if (executor2 == null && this.f == null) {
                    Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                    this.f = iOThreadExecutor;
                    this.e = iOThreadExecutor;
                } else if (executor2 != null && this.f == null) {
                    this.f = executor2;
                } else if (executor2 == null && (executor = this.f) != null) {
                    this.e = executor;
                }
                Set<Integer> set = this.o;
                if (!(set == null || this.n == null)) {
                    for (Integer num : set) {
                        if (this.n.contains(num)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                        }
                    }
                }
                if (this.g == null) {
                    this.g = new FrameworkSQLiteOpenHelperFactory();
                }
                String str = this.p;
                if (!(str == null && this.q == null)) {
                    if (this.b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    } else if (str == null || this.q == null) {
                        this.g = new e(str, this.q, this.g);
                    } else {
                        throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                    }
                }
                Context context = this.c;
                String str2 = this.b;
                SupportSQLiteOpenHelper.Factory factory = this.g;
                MigrationContainer migrationContainer = this.m;
                ArrayList<Callback> arrayList = this.d;
                boolean z = this.h;
                JournalMode journalMode = this.i;
                Objects.requireNonNull(journalMode);
                if (journalMode == JournalMode.AUTOMATIC) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager == null || activityManager.isLowRamDevice()) {
                        journalMode = JournalMode.TRUNCATE;
                    } else {
                        journalMode = JournalMode.WRITE_AHEAD_LOGGING;
                    }
                }
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, arrayList, z, journalMode, this.e, this.f, this.j, this.k, this.l, this.n, this.p, this.q);
                Class<T> cls = this.a;
                String name = cls.getPackage().getName();
                String canonicalName = cls.getCanonicalName();
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String str3 = canonicalName.replace(FormatterType.defaultDecimalSeparator, '_') + "_Impl";
                try {
                    T t = (T) ((RoomDatabase) Class.forName(name.isEmpty() ? str3 : name + "." + str3).newInstance());
                    t.init(databaseConfiguration);
                    return t;
                } catch (ClassNotFoundException unused) {
                    StringBuilder L = a.L("cannot find implementation for ");
                    L.append(cls.getCanonicalName());
                    L.append(". ");
                    L.append(str3);
                    L.append(" does not exist");
                    throw new RuntimeException(L.toString());
                } catch (IllegalAccessException unused2) {
                    StringBuilder L2 = a.L("Cannot access the constructor");
                    L2.append(cls.getCanonicalName());
                    throw new RuntimeException(L2.toString());
                } catch (InstantiationException unused3) {
                    StringBuilder L3 = a.L("Failed to create an instance of ");
                    L3.append(cls.getCanonicalName());
                    throw new RuntimeException(L3.toString());
                }
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        @NonNull
        public Builder<T> createFromAsset(@NonNull String str) {
            this.p = str;
            return this;
        }

        @NonNull
        public Builder<T> createFromFile(@NonNull File file) {
            this.q = file;
            return this;
        }

        @NonNull
        public Builder<T> enableMultiInstanceInvalidation() {
            this.j = this.b != null;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.k = false;
            this.l = true;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            if (this.n == null) {
                this.n = new HashSet(iArr.length);
            }
            for (int i2 : iArr) {
                this.n.add(Integer.valueOf(i2));
            }
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.k = true;
            this.l = true;
            return this;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            this.g = factory;
            return this;
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode journalMode) {
            this.i = journalMode;
            return this;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor executor) {
            this.e = executor;
            return this;
        }

        @NonNull
        public Builder<T> setTransactionExecutor(@NonNull Executor executor) {
            this.f = executor;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    public static class MigrationContainer {
        public HashMap<Integer, TreeMap<Integer, Migration>> a = new HashMap<>();

        public void addMigrations(@NonNull Migration... migrationArr) {
            for (Migration migration : migrationArr) {
                int i = migration.startVersion;
                int i2 = migration.endVersion;
                TreeMap<Integer, Migration> treeMap = this.a.get(Integer.valueOf(i));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    this.a.put(Integer.valueOf(i), treeMap);
                }
                Migration migration2 = treeMap.get(Integer.valueOf(i2));
                if (migration2 != null) {
                    String str = "Overriding migration " + migration2 + " with " + migration;
                }
                treeMap.put(Integer.valueOf(i2), migration);
            }
        }

        @Nullable
        public List<Migration> findMigrationPath(int i, int i2) {
            Set<Integer> set;
            boolean z;
            boolean z2;
            if (i == i2) {
                return Collections.emptyList();
            }
            boolean z3 = i2 > i;
            ArrayList arrayList = new ArrayList();
            do {
                if (z3) {
                    if (i >= i2) {
                        return arrayList;
                    }
                } else if (i <= i2) {
                    return arrayList;
                }
                TreeMap<Integer, Migration> treeMap = this.a.get(Integer.valueOf(i));
                if (treeMap == null) {
                    break;
                }
                if (z3) {
                    set = treeMap.descendingKeySet();
                } else {
                    set = treeMap.keySet();
                }
                Iterator<Integer> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        continue;
                        break;
                    }
                    int intValue = it.next().intValue();
                    if (!z3 ? intValue < i2 || intValue >= i : intValue > i2 || intValue <= i) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        arrayList.add(treeMap.get(Integer.valueOf(intValue)));
                        i = intValue;
                        z = true;
                        continue;
                        break;
                    }
                }
            } while (z);
            return null;
        }
    }

    public RoomDatabase() {
        new ConcurrentHashMap();
        this.d = createInvalidationTracker();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.e) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.h.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        this.d.f(writableDatabase);
        writableDatabase.beginTransaction();
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.g.writeLock();
            try {
                writeLock.lock();
                InvalidationTracker invalidationTracker = this.d;
                b bVar = invalidationTracker.k;
                if (bVar != null) {
                    if (bVar.i.compareAndSet(false, true)) {
                        bVar.g.execute(bVar.m);
                    }
                    invalidationTracker.k = null;
                }
                this.c.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.c.getWritableDatabase().compileStatement(str);
    }

    @NonNull
    public abstract InvalidationTracker createInvalidationTracker();

    @NonNull
    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void endTransaction() {
        this.c.getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            this.d.refreshVersionsAsync();
        }
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        return this.d;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.c;
    }

    @NonNull
    public Executor getQueryExecutor() {
        return this.a;
    }

    @NonNull
    public Executor getTransactionExecutor() {
        return this.b;
    }

    public boolean inTransaction() {
        return this.c.getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration databaseConfiguration) {
        SupportSQLiteOpenHelper createOpenHelper = createOpenHelper(databaseConfiguration);
        this.c = createOpenHelper;
        if (createOpenHelper instanceof d) {
            ((d) createOpenHelper).f = databaseConfiguration;
        }
        boolean z = databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING;
        createOpenHelper.setWriteAheadLoggingEnabled(z);
        this.mCallbacks = databaseConfiguration.callbacks;
        this.a = databaseConfiguration.queryExecutor;
        this.b = new f(databaseConfiguration.transactionExecutor);
        this.e = databaseConfiguration.allowMainThreadQueries;
        this.f = z;
        if (databaseConfiguration.multiInstanceInvalidation) {
            InvalidationTracker invalidationTracker = this.d;
            invalidationTracker.k = new b(databaseConfiguration.context, databaseConfiguration.name, invalidationTracker, invalidationTracker.d.getQueryExecutor());
        }
    }

    public void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        InvalidationTracker invalidationTracker = this.d;
        synchronized (invalidationTracker) {
            if (!invalidationTracker.f) {
                supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
                supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
                supportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                invalidationTracker.f(supportSQLiteDatabase);
                invalidationTracker.g = supportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                invalidationTracker.f = true;
            }
        }
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    @NonNull
    public Cursor query(@NonNull String str, @Nullable Object[] objArr) {
        return this.c.getWritableDatabase().query(new SimpleSQLiteQuery(str, objArr));
    }

    public void runInTransaction(@NonNull Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.c.getWritableDatabase().setTransactionSuccessful();
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery, @Nullable CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.c.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return this.c.getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(@NonNull Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            SneakyThrow.reThrow(e3);
            endTransaction();
            return null;
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}
