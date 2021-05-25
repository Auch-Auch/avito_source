package a2.p.a;

import android.database.Cursor;
import android.support.annotation.RequiresApi;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Optional;
@RequiresApi(24)
public final class c<T> implements ObservableOperator<Optional<T>, SqlBrite.Query> {
    public final Function<Cursor, T> a;

    public static final class a<T> extends DisposableObserver<SqlBrite.Query> {
        public final Observer<? super Optional<T>> b;
        public final Function<Cursor, T> c;

        public a(Observer<? super Optional<T>> observer, Function<Cursor, T> function) {
            this.b = observer;
            this.c = function;
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
                if (!isDisposed()) {
                    this.b.onNext(Optional.ofNullable(t));
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

    public c(Function<Cursor, T> function) {
        this.a = function;
    }

    @Override // io.reactivex.ObservableOperator
    public Observer<? super SqlBrite.Query> apply(Observer<? super Optional<T>> observer) {
        return new a(observer, this.a);
    }
}
