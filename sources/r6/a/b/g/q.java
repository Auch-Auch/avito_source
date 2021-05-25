package r6.a.b.g;

import hu.akarnokd.rxjava3.functions.Consumer3;
import hu.akarnokd.rxjava3.joins.Pattern3;
import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function3;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class q<T1, T2, T3, R> extends Plan<R> {
    public final Pattern3<T1, T2, T3> a;
    public final Function3<T1, T2, T3, R> b;

    public class a implements Consumer3<T1, T2, T3> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer3
        public void accept(T1 t1, T2 t2, T3 t3) {
            try {
                this.a.onNext(q.this.b.apply(t1, t2, t3));
            } catch (Throwable th) {
                this.a.onError(th);
            }
        }
    }

    public class b implements Action {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ l b;
        public final /* synthetic */ l c;
        public final /* synthetic */ l d;
        public final /* synthetic */ Consumer e;

        public b(q qVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.a(aVar);
            this.e.accept(aVar);
        }
    }

    public q(Pattern3<T1, T2, T3> pattern3, Function3<T1, T2, T3, R> function3) {
        this.a = pattern3;
        this.b = function3;
    }

    @Override // hu.akarnokd.rxjava3.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        l b4 = Plan.b(map, this.a.c, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        d dVar = new d(b2, b3, b4, new a(observer), new b(this, atomicReference, b2, b3, b4, consumer));
        atomicReference.set(dVar);
        b2.d.add(dVar);
        b3.d.add(dVar);
        b4.d.add(dVar);
        return dVar;
    }
}
