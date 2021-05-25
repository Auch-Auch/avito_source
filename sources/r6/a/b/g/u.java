package r6.a.b.g;

import hu.akarnokd.rxjava3.functions.Consumer7;
import hu.akarnokd.rxjava3.joins.Pattern7;
import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function7;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class u<T1, T2, T3, T4, T5, T6, T7, R> extends Plan<R> {
    public final Pattern7<T1, T2, T3, T4, T5, T6, T7> a;
    public final Function7<T1, T2, T3, T4, T5, T6, T7, R> b;

    public class a implements Consumer7<T1, T2, T3, T4, T5, T6, T7> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer7
        public void accept(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) {
            try {
                this.a.onNext(u.this.b.apply(t1, t2, t3, t4, t5, t62, t7));
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
        public final /* synthetic */ l h;
        public final /* synthetic */ Consumer i;

        public b(u uVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, l lVar6, l lVar7, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = lVar4;
            this.f = lVar5;
            this.g = lVar6;
            this.h = lVar7;
            this.i = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.a(aVar);
            this.e.a(aVar);
            this.f.a(aVar);
            this.g.a(aVar);
            this.h.a(aVar);
            this.i.accept(aVar);
        }
    }

    public u(Pattern7<T1, T2, T3, T4, T5, T6, T7> pattern7, Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        this.a = pattern7;
        this.b = function7;
    }

    @Override // hu.akarnokd.rxjava3.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        l b4 = Plan.b(map, this.a.c, onErrorFrom);
        l b5 = Plan.b(map, this.a.d, onErrorFrom);
        l b6 = Plan.b(map, this.a.e, onErrorFrom);
        l b8 = Plan.b(map, this.a.f, onErrorFrom);
        l b9 = Plan.b(map, this.a.g, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        h hVar = new h(b2, b3, b4, b5, b6, b8, b9, new a(observer), new b(this, atomicReference, b2, b3, b4, b5, b6, b8, b9, consumer));
        atomicReference.set(hVar);
        b2.d.add(hVar);
        b3.d.add(hVar);
        b4.d.add(hVar);
        b5.d.add(hVar);
        b6.d.add(hVar);
        b8.d.add(hVar);
        b9.d.add(hVar);
        return hVar;
    }
}
