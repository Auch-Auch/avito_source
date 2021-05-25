package r6.a.b.g;

import hu.akarnokd.rxjava3.joins.Pattern2;
import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class p<T1, T2, R> extends Plan<R> {
    public final Pattern2<T1, T2> a;
    public final BiFunction<T1, T2, R> b;

    public class a implements BiConsumer<T1, T2> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public void accept(T1 t1, T2 t2) {
            try {
                this.a.onNext(p.this.b.apply(t1, t2));
            } catch (Throwable th) {
                this.a.onError(th);
            }
        }
    }

    public class b implements Action {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ l b;
        public final /* synthetic */ l c;
        public final /* synthetic */ Consumer d;

        public b(p pVar, AtomicReference atomicReference, l lVar, l lVar2, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.accept(aVar);
        }
    }

    public p(Pattern2<T1, T2> pattern2, BiFunction<T1, T2, R> biFunction) {
        this.a = pattern2;
        this.b = biFunction;
    }

    @Override // hu.akarnokd.rxjava3.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        c cVar = new c(b2, b3, new a(observer), new b(this, atomicReference, b2, b3, consumer));
        atomicReference.set(cVar);
        b2.d.add(cVar);
        b3.d.add(cVar);
        return cVar;
    }
}
