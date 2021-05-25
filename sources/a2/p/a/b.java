package a2.p.a;

import android.database.Cursor;
import android.support.annotation.Nullable;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
public final class b<T> implements ObservableOperator<T, SqlBrite.Query> {
    public final Function<Cursor, T> a;
    public final T b;

    public static final class a<T> extends DisposableObserver<SqlBrite.Query> {
        public final Observer<? super T> b;
        public final Function<Cursor, T> c;
        public final T d;

        public a(Observer<? super T> observer, Function<Cursor, T> function, T t) {
            this.b = observer;
            this.c = function;
            this.d = t;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!isDisposed()) {
                this.b.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                this.b.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            T t = null;
            try {
                Cursor run = ((SqlBrite.Query) obj).run();
                if (run != null) {
                    try {
                        if (run.moveToNext()) {
                            t = this.c.apply(run);
                            if (t == null) {
                                this.b.onError(new NullPointerException("QueryToOne mapper returned null"));
                                return;
                            } else if (run.moveToNext()) {
                                throw new IllegalStateException("Cursor returned more than 1 row");
                            }
                        }
                        run.close();
                    } finally {
                        run.close();
                    }
                }
                if (isDisposed()) {
                    return;
                }
                if (t != null) {
                    this.b.onNext(t);
                    return;
                }
                T t2 = this.d;
                if (t2 != null) {
                    this.b.onNext(t2);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        @Override // io.reactivex.observers.DisposableObserver
        public void onStart() {
            this.b.onSubscribe(this);
        }
    }

    public b(Function<Cursor, T> function, @Nullable T t) {
        this.a = function;
        this.b = t;
    }

    @Override // io.reactivex.ObservableOperator
    public Observer<? super SqlBrite.Query> apply(Observer<? super T> observer) {
        return new a(observer, this.a, this.b);
    }
}
