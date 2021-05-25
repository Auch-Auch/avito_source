package com.squareup.sqlbrite2;

import android.database.Cursor;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Optional;
public final class QueryObservable extends Observable<SqlBrite.Query> {
    public static final Function<Observable<SqlBrite.Query>, QueryObservable> b = new a();
    public final Observable<SqlBrite.Query> a;

    public static class a implements Function<Observable<SqlBrite.Query>, QueryObservable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public QueryObservable apply(Observable<SqlBrite.Query> observable) throws Exception {
            return new QueryObservable(observable);
        }
    }

    public QueryObservable(Observable<SqlBrite.Query> observable) {
        this.a = observable;
    }

    @CheckResult
    @NonNull
    public final <T> Observable<List<T>> mapToList(@NonNull Function<Cursor, T> function) {
        return lift(SqlBrite.Query.mapToList(function));
    }

    @CheckResult
    @NonNull
    public final <T> Observable<T> mapToOne(@NonNull Function<Cursor, T> function) {
        return lift(SqlBrite.Query.mapToOne(function));
    }

    @CheckResult
    @NonNull
    public final <T> Observable<T> mapToOneOrDefault(@NonNull Function<Cursor, T> function, @NonNull T t) {
        return lift(SqlBrite.Query.mapToOneOrDefault(function, t));
    }

    @NonNull
    @CheckResult
    @RequiresApi(24)
    public final <T> Observable<Optional<T>> mapToOptional(@NonNull Function<Cursor, T> function) {
        return lift(SqlBrite.Query.mapToOptional(function));
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super SqlBrite.Query> observer) {
        this.a.subscribe(observer);
    }
}
