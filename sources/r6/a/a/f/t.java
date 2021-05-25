package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer6;
import hu.akarnokd.rxjava2.joins.Pattern6;
import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function6;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class t<T1, T2, T3, T4, T5, T6, R> extends Plan<R> {
    public final Pattern6<T1, T2, T3, T4, T5, T6> a;
    public final Function6<T1, T2, T3, T4, T5, T6, R> b;

    public class a implements Consumer6<T1, T2, T3, T4, T5, T6> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava2.functions.Consumer6
        public void accept(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) {
            try {
                this.a.onNext(t.this.b.apply(t1, t2, t3, t4, t5, t62));
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
        public final /* synthetic */ l g;
        public final /* synthetic */ Consumer h;

        public b(t tVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, l lVar6, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = lVar4;
            this.f = lVar5;
            this.g = lVar6;
            this.h = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.a(aVar);
            this.e.a(aVar);
            this.f.a(aVar);
            this.g.a(aVar);
            this.h.accept(aVar);
        }
    }

    public t(Pattern6<T1, T2, T3, T4, T5, T6> pattern6, Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        this.a = pattern6;
        this.b = function6;
    }

    @Override // hu.akarnokd.rxjava2.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        l b4 = Plan.b(map, this.a.c, onErrorFrom);
        l b5 = Plan.b(map, this.a.d, onErrorFrom);
        l b6 = Plan.b(map, this.a.e, onErrorFrom);
        l b8 = Plan.b(map, this.a.f, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        g gVar = new g(b2, b3, b4, b5, b6, b8, new a(observer), new b(this, atomicReference, b2, b3, b4, b5, b6, b8, consumer));
        atomicReference.set(gVar);
        b2.d.add(gVar);
        b3.d.add(gVar);
        b4.d.add(gVar);
        b5.d.add(gVar);
        b6.d.add(gVar);
        b8.d.add(gVar);
        return gVar;
    }
}
