package com.squareup.sqlbrite2;

import a2.p.a.c;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.WorkerThread;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
public final class SqlBrite {
    public static final Logger c = new a();
    public static final ObservableTransformer<Query, Query> d = new b();
    public final Logger a;
    public final ObservableTransformer<Query, Query> b;

    public static final class Builder {
        public Logger a = SqlBrite.c;
        public ObservableTransformer<Query, Query> b = SqlBrite.d;

        @CheckResult
        public SqlBrite build() {
            return new SqlBrite(this.a, this.b);
        }

        @CheckResult
        public Builder logger(@NonNull Logger logger) {
            Objects.requireNonNull(logger, "logger == null");
            this.a = logger;
            return this;
        }

        @CheckResult
        public Builder queryTransformer(@NonNull ObservableTransformer<Query, Query> observableTransformer) {
            Objects.requireNonNull(observableTransformer, "queryTransformer == null");
            this.b = observableTransformer;
            return this;
        }
    }

    public interface Logger {
        void log(String str);
    }

    public static abstract class Query {

        public class a implements ObservableOnSubscribe<T> {
            public final /* synthetic */ Function a;

            public a(Function function) {
                this.a = function;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                Cursor run = Query.this.run();
                if (run != null) {
                    while (run.moveToNext() && !observableEmitter.isDisposed()) {
                        try {
                            observableEmitter.onNext((T) this.a.apply(run));
                        } finally {
                            run.close();
                        }
                    }
                }
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onComplete();
                }
            }
        }

        @CheckResult
        @NonNull
        public static <T> ObservableOperator<List<T>, Query> mapToList(@NonNull Function<Cursor, T> function) {
            return new a2.p.a.a(function);
        }

        @CheckResult
        @NonNull
        public static <T> ObservableOperator<T, Query> mapToOne(@NonNull Function<Cursor, T> function) {
            return new a2.p.a.b(function, null);
        }

        @CheckResult
        @NonNull
        public static <T> ObservableOperator<T, Query> mapToOneOrDefault(@NonNull Function<Cursor, T> function, @NonNull T t) {
            Objects.requireNonNull(t, "defaultValue == null");
            return new a2.p.a.b(function, t);
        }

        @NonNull
        @CheckResult
        @RequiresApi(24)
        public static <T> ObservableOperator<Optional<T>, Query> mapToOptional(@NonNull Function<Cursor, T> function) {
            return new c(function);
        }

        @CheckResult
        @NonNull
        public final <T> Observable<T> asRows(Function<Cursor, T> function) {
            return Observable.create(new a(function));
        }

        @WorkerThread
        @CheckResult
        @Nullable
        public abstract Cursor run();
    }

    public static class a implements Logger {
        @Override // com.squareup.sqlbrite2.SqlBrite.Logger
        public void log(String str) {
        }
    }

    public static class b implements ObservableTransformer<Query, Query> {
        /* Return type fixed from 'io.reactivex.ObservableSource' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.Observable] */
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<Query> apply(Observable<Query> observable) {
            return observable;
        }
    }

    public SqlBrite(@NonNull Logger logger, @NonNull ObservableTransformer<Query, Query> observableTransformer) {
        this.a = logger;
        this.b = observableTransformer;
    }

    @CheckResult
    @NonNull
    public BriteContentResolver wrapContentProvider(@NonNull ContentResolver contentResolver, @NonNull Scheduler scheduler) {
        return new BriteContentResolver(contentResolver, this.a, scheduler, this.b);
    }

    @CheckResult
    @NonNull
    public BriteDatabase wrapDatabaseHelper(@NonNull SQLiteOpenHelper sQLiteOpenHelper, @NonNull Scheduler scheduler) {
        PublishSubject create = PublishSubject.create();
        return new BriteDatabase(sQLiteOpenHelper, this.a, create, create, scheduler, this.b);
    }
}
