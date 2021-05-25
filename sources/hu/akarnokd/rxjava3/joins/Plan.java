package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import r6.a.b.g.l;
import r6.a.b.g.m;
public abstract class Plan<R> {

    public class a implements Consumer<Throwable> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            this.a.onError(th);
        }
    }

    public static final <T> l<T> b(Map<Object, m> map, Observable<T> observable, Consumer<Throwable> consumer) {
        m mVar = map.get(observable);
        if (mVar != null) {
            return (l) mVar;
        }
        l<T> lVar = new l<>(observable, consumer);
        map.put(observable, lVar);
        return lVar;
    }

    public static <T> Consumer<Throwable> onErrorFrom(Observer<T> observer) {
        return new a(observer);
    }

    public abstract r6.a.b.g.a a(Map<Object, m> map, Observer<R> observer, Consumer<r6.a.b.g.a> consumer);
}
