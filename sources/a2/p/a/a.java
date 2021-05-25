package a2.p.a;

import android.database.Cursor;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.List;
public final class a<T> implements ObservableOperator<List<T>, SqlBrite.Query> {
    public final Function<Cursor, T> a;

    /* renamed from: a2.p.a.a$a  reason: collision with other inner class name */
    public static final class C0101a<T> extends DisposableObserver<SqlBrite.Query> {
        public final Observer<? super List<T>> b;
        public final Function<Cursor, T> c;

        public C0101a(Observer<? super List<T>> observer, Function<Cursor, T> function) {
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

        /* JADX INFO: finally extract failed */
        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            try {
                Cursor run = ((SqlBrite.Query) obj).run();
                if (run == null) {
                    return;
                }
                if (!isDisposed()) {
                    ArrayList arrayList = new ArrayList(run.getCount());
                    while (run.moveToNext()) {
                        try {
                            arrayList.add(this.c.apply(run));
                        } catch (Throwable th) {
                            run.close();
                            throw th;
                        }
                    }
                    run.close();
                    if (!isDisposed()) {
                        this.b.onNext(arrayList);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.observers.DisposableObserver
        public void onStart() {
            this.b.onSubscribe(this);
        }
    }

    public a(Function<Cursor, T> function) {
        this.a = function;
    }

    @Override // io.reactivex.ObservableOperator
    public Observer<? super SqlBrite.Query> apply(Observer<? super List<T>> observer) {
        return new C0101a(observer, this.a);
    }
}
