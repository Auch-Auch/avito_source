package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer5;
import hu.akarnokd.rxjava2.joins.Pattern5;
import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function5;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class s<T1, T2, T3, T4, T5, R> extends Plan<R> {
    public final Pattern5<T1, T2, T3, T4, T5> a;
    public final Function5<T1, T2, T3, T4, T5, R> b;

    public class a implements Consumer5<T1, T2, T3, T4, T5> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava2.functions.Consumer5
        public void accept(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
            try {
                this.a.onNext(s.this.b.apply(t1, t2, t3, t4, t5));
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
        public final /* synthetic */ l e;
        public final /* synthetic */ l f;
        public final /* synthetic */ Consumer g;

        public b(s sVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = lVar4;
            this.f = lVar5;
            this.g = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.a(aVar);
            this.e.a(aVar);
            this.f.a(aVar);
            this.g.accept(aVar);
        }
    }

    public s(Pattern5<T1, T2, T3, T4, T5> pattern5, Function5<T1, T2, T3, T4, T5, R> function5) {
        this.a = pattern5;
        this.b = function5;
    }

    @Override // hu.akarnokd.rxjava2.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        l b4 = Plan.b(map, this.a.c, onErrorFrom);
        l b5 = Plan.b(map, this.a.d, onErrorFrom);
        l b6 = Plan.b(map, this.a.e, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        f fVar = new f(b2, b3, b4, b5, b6, new a(observer), new b(this, atomicReference, b2, b3, b4, b5, b6, consumer));
        atomicReference.set(fVar);
        b2.d.add(fVar);
        b3.d.add(fVar);
        b4.d.add(fVar);
        b5.d.add(fVar);
        b6.d.add(fVar);
        return fVar;
    }
}
