package com.squareup.sqlbrite2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.WorkerThread;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public final class BriteDatabase implements Closeable {
    public final SQLiteOpenHelper a;
    public final SqlBrite.Logger b;
    public final ObservableTransformer<SqlBrite.Query, SqlBrite.Query> c;
    public final ThreadLocal<f> d = new ThreadLocal<>();
    public final Observable<Set<String>> e;
    public final Observer<Set<String>> f;
    public final Transaction g = new a();
    public final Consumer<Object> h = new b();
    public final Scheduler i;
    public volatile boolean j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictAlgorithm {
    }

    public interface Transaction extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        @WorkerThread
        void close();

        @WorkerThread
        void end();

        @WorkerThread
        void markSuccessful();

        @WorkerThread
        boolean yieldIfContendedSafely();

        @WorkerThread
        boolean yieldIfContendedSafely(long j, TimeUnit timeUnit);
    }

    public class a implements Transaction {
        public a() {
        }

        @Override // com.squareup.sqlbrite2.BriteDatabase.Transaction, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            end();
        }

        @Override // com.squareup.sqlbrite2.BriteDatabase.Transaction
        public void end() {
            f fVar = BriteDatabase.this.d.get();
            if (fVar != null) {
                BriteDatabase.this.d.set(fVar.a);
                if (BriteDatabase.this.j) {
                    BriteDatabase.this.c("TXN END %s", fVar);
                }
                BriteDatabase.this.getWritableDatabase().endTransaction();
                if (fVar.b) {
                    BriteDatabase.this.d(fVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Not in transaction.");
        }

        @Override // com.squareup.sqlbrite2.BriteDatabase.Transaction
        public void markSuccessful() {
            if (BriteDatabase.this.j) {
                BriteDatabase briteDatabase = BriteDatabase.this;
                briteDatabase.c("TXN SUCCESS %s", briteDatabase.d.get());
            }
            BriteDatabase.this.getWritableDatabase().setTransactionSuccessful();
        }

        @Override // com.squareup.sqlbrite2.BriteDatabase.Transaction
        public boolean yieldIfContendedSafely() {
            return BriteDatabase.this.getWritableDatabase().yieldIfContendedSafely();
        }

        @Override // com.squareup.sqlbrite2.BriteDatabase.Transaction
        public boolean yieldIfContendedSafely(long j, TimeUnit timeUnit) {
            return BriteDatabase.this.getWritableDatabase().yieldIfContendedSafely(timeUnit.toMillis(j));
        }
    }

    public class b implements Consumer<Object> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
            if (BriteDatabase.this.d.get() != null) {
                throw new IllegalStateException("Cannot subscribe to observable query in a transaction.");
            }
        }
    }

    public class c implements Predicate<Set<String>> {
        public final /* synthetic */ String a;

        public c(BriteDatabase briteDatabase, String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Set<String> set) throws Exception {
            return set.contains(this.a);
        }

        public String toString() {
            return this.a;
        }
    }

    public class d implements Predicate<Set<String>> {
        public final /* synthetic */ Iterable a;

        public d(BriteDatabase briteDatabase, Iterable iterable) {
            this.a = iterable;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Set<String> set) throws Exception {
            Set<String> set2 = set;
            for (String str : this.a) {
                if (set2.contains(str)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public final class e extends SqlBrite.Query implements Function<Set<String>, SqlBrite.Query> {
        public final Object a;
        public final String b;
        public final String[] c;

        public e(Object obj, String str, String... strArr) {
            this.a = obj;
            this.b = str;
            this.c = strArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SqlBrite.Query apply(Set<String> set) throws Exception {
            return this;
        }

        @Override // com.squareup.sqlbrite2.SqlBrite.Query
        public Cursor run() {
            if (BriteDatabase.this.d.get() == null) {
                long nanoTime = System.nanoTime();
                Cursor rawQuery = BriteDatabase.this.getReadableDatabase().rawQuery(this.b, this.c);
                if (BriteDatabase.this.j) {
                    BriteDatabase.this.c("QUERY (%sms)\n  tables: %s\n  sql: %s\n  args: %s", Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime)), this.a, this.b.replace("\n", "\n       "), Arrays.toString(this.c));
                }
                return rawQuery;
            }
            throw new IllegalStateException("Cannot execute observable query in a transaction.");
        }

        public String toString() {
            return this.b;
        }
    }

    public static final class f extends LinkedHashSet<String> implements SQLiteTransactionListener {
        public final f a;
        public boolean b;

        public f(f fVar) {
            this.a = fVar;
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            this.b = true;
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            String format = String.format("%08x", Integer.valueOf(System.identityHashCode(this)));
            if (this.a == null) {
                return format;
            }
            StringBuilder Q = a2.b.a.a.a.Q(format, " [");
            Q.append(this.a.toString());
            Q.append(']');
            return Q.toString();
        }
    }

    public BriteDatabase(SQLiteOpenHelper sQLiteOpenHelper, SqlBrite.Logger logger, Observable<Set<String>> observable, Observer<Set<String>> observer, Scheduler scheduler, ObservableTransformer<SqlBrite.Query, SqlBrite.Query> observableTransformer) {
        this.a = sQLiteOpenHelper;
        this.b = logger;
        this.e = observable;
        this.f = observer;
        this.i = scheduler;
        this.c = observableTransformer;
    }

    public static String a(int i2) {
        if (i2 == 0) {
            return "none";
        }
        if (i2 == 1) {
            return "rollback";
        }
        if (i2 == 2) {
            return "abort";
        }
        if (i2 == 3) {
            return "fail";
        }
        if (i2 == 4) {
            return "ignore";
        }
        if (i2 == 5) {
            return "replace";
        }
        return "unknown (" + i2 + ')';
    }

    @CheckResult
    @NonNull
    public final QueryObservable b(Predicate<Set<String>> predicate, String str, String... strArr) {
        if (this.d.get() == null) {
            e eVar = new e(predicate, str, strArr);
            return (QueryObservable) this.e.filter(predicate).map(eVar).startWith((Observable<R>) eVar).observeOn(this.i).compose(this.c).doOnSubscribe(this.h).to(QueryObservable.b);
        }
        throw new IllegalStateException("Cannot create observable query in transaction. Use query() for a query inside a transaction.");
    }

    public void c(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.b.log(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @CheckResult
    @NonNull
    public QueryObservable createQuery(@NonNull String str, @NonNull String str2, @NonNull String... strArr) {
        return b(new c(this, str), str2, strArr);
    }

    public void d(Set<String> set) {
        f fVar = this.d.get();
        if (fVar != null) {
            fVar.addAll(set);
            return;
        }
        if (this.j) {
            c("TRIGGER %s", set);
        }
        this.f.onNext(set);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0034: APUT  (r9v2 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r0v2 java.lang.String) */
    @WorkerThread
    public int delete(@NonNull String str, @Nullable String str2, @Nullable String... strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (this.j) {
            c("DELETE\n  table: %s\n  whereClause: %s\n  whereArgs: %s", str, str2, Arrays.toString(strArr));
        }
        int delete = writableDatabase.delete(str, str2, strArr);
        if (this.j) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(delete);
            objArr[1] = delete != 1 ? "rows" : "row";
            c("DELETE affected %s %s", objArr);
        }
        if (delete > 0) {
            d(Collections.singleton(str));
        }
        return delete;
    }

    @WorkerThread
    public void execute(String str) {
        if (this.j) {
            c("EXECUTE\n  sql: %s", str);
        }
        getWritableDatabase().execSQL(str);
    }

    @WorkerThread
    public void executeAndTrigger(String str, String str2) {
        executeAndTrigger(Collections.singleton(str), str2);
    }

    @WorkerThread
    public long executeInsert(String str, SQLiteStatement sQLiteStatement) {
        return executeInsert(Collections.singleton(str), sQLiteStatement);
    }

    @WorkerThread
    @RequiresApi(11)
    public int executeUpdateDelete(String str, SQLiteStatement sQLiteStatement) {
        return executeUpdateDelete(Collections.singleton(str), sQLiteStatement);
    }

    @WorkerThread
    @CheckResult
    @NonNull
    public SQLiteDatabase getReadableDatabase() {
        return this.a.getReadableDatabase();
    }

    @WorkerThread
    @CheckResult
    @NonNull
    public SQLiteDatabase getWritableDatabase() {
        return this.a.getWritableDatabase();
    }

    @WorkerThread
    public long insert(@NonNull String str, @NonNull ContentValues contentValues) {
        return insert(str, contentValues, 0);
    }

    @CheckResult
    @NonNull
    @RequiresApi(11)
    public Transaction newNonExclusiveTransaction() {
        f fVar = new f(this.d.get());
        this.d.set(fVar);
        if (this.j) {
            c("TXN BEGIN %s", fVar);
        }
        getWritableDatabase().beginTransactionWithListenerNonExclusive(fVar);
        return this.g;
    }

    @CheckResult
    @NonNull
    public Transaction newTransaction() {
        f fVar = new f(this.d.get());
        this.d.set(fVar);
        if (this.j) {
            c("TXN BEGIN %s", fVar);
        }
        getWritableDatabase().beginTransactionWithListener(fVar);
        return this.g;
    }

    @WorkerThread
    @CheckResult
    public Cursor query(@NonNull String str, @NonNull String... strArr) {
        long nanoTime = System.nanoTime();
        Cursor rawQuery = getReadableDatabase().rawQuery(str, strArr);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        if (this.j) {
            c("QUERY (%sms)\n  sql: %s\n  args: %s", Long.valueOf(millis), str.replace("\n", "\n       "), Arrays.toString(strArr));
        }
        return rawQuery;
    }

    public void setLoggingEnabled(boolean z) {
        this.j = z;
    }

    @WorkerThread
    public int update(@NonNull String str, @NonNull ContentValues contentValues, @Nullable String str2, @Nullable String... strArr) {
        return update(str, contentValues, 0, str2, strArr);
    }

    @WorkerThread
    public void executeAndTrigger(Set<String> set, String str) {
        execute(str);
        d(set);
    }

    @WorkerThread
    public long executeInsert(Set<String> set, SQLiteStatement sQLiteStatement) {
        if (this.j) {
            c("EXECUTE\n %s", sQLiteStatement);
        }
        long executeInsert = sQLiteStatement.executeInsert();
        if (executeInsert != -1) {
            d(set);
        }
        return executeInsert;
    }

    @WorkerThread
    @RequiresApi(11)
    public int executeUpdateDelete(Set<String> set, SQLiteStatement sQLiteStatement) {
        if (this.j) {
            c("EXECUTE\n %s", sQLiteStatement);
        }
        int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
        if (executeUpdateDelete > 0) {
            d(set);
        }
        return executeUpdateDelete;
    }

    @WorkerThread
    public long insert(@NonNull String str, @NonNull ContentValues contentValues, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (this.j) {
            c("INSERT\n  table: %s\n  values: %s\n  conflictAlgorithm: %s", str, contentValues, a(i2));
        }
        long insertWithOnConflict = writableDatabase.insertWithOnConflict(str, null, contentValues, i2);
        if (this.j) {
            c("INSERT id: %s", Long.valueOf(insertWithOnConflict));
        }
        if (insertWithOnConflict != -1) {
            d(Collections.singleton(str));
        }
        return insertWithOnConflict;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0043: APUT  (r12v2 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r13v2 java.lang.String) */
    @WorkerThread
    public int update(@NonNull String str, @NonNull ContentValues contentValues, int i2, @Nullable String str2, @Nullable String... strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (this.j) {
            c("UPDATE\n  table: %s\n  values: %s\n  whereClause: %s\n  whereArgs: %s\n  conflictAlgorithm: %s", str, contentValues, str2, Arrays.toString(strArr), a(i2));
        }
        int updateWithOnConflict = writableDatabase.updateWithOnConflict(str, contentValues, str2, strArr, i2);
        if (this.j) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(updateWithOnConflict);
            objArr[1] = updateWithOnConflict != 1 ? "rows" : "row";
            c("UPDATE affected %s %s", objArr);
        }
        if (updateWithOnConflict > 0) {
            d(Collections.singleton(str));
        }
        return updateWithOnConflict;
    }

    @CheckResult
    @NonNull
    public QueryObservable createQuery(@NonNull Iterable<String> iterable, @NonNull String str, @NonNull String... strArr) {
        return b(new d(this, iterable), str, strArr);
    }

    @WorkerThread
    public void execute(String str, Object... objArr) {
        if (this.j) {
            c("EXECUTE\n  sql: %s\n  args: %s", str, Arrays.toString(objArr));
        }
        getWritableDatabase().execSQL(str, objArr);
    }

    @WorkerThread
    public void executeAndTrigger(String str, String str2, Object... objArr) {
        executeAndTrigger(Collections.singleton(str), str2, objArr);
    }

    @WorkerThread
    public void executeAndTrigger(Set<String> set, String str, Object... objArr) {
        execute(str, objArr);
        d(set);
    }
}
