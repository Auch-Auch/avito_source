package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer8;
import hu.akarnokd.rxjava2.joins.Pattern8;
import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function8;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class v<T1, T2, T3, T4, T5, T6, T7, T8, R> extends Plan<R> {
    public final Pattern8<T1, T2, T3, T4, T5, T6, T7, T8> a;
    public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> b;

    public class a implements Consumer8<T1, T2, T3, T4, T5, T6, T7, T8> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava2.functions.Consumer8
        public void accept(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) {
            try {
                this.a.onNext(v.this.b.apply(t1, t2, t3, t4, t5, t62, t7, t8));
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
        public final /* synthetic */ l i;
        public final /* synthetic */ Consumer j;

        public b(v vVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, l lVar6, l lVar7, l lVar8, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = lVar4;
            this.f = lVar5;
            this.g = lVar6;
            this.h = lVar7;
            this.i = lVar8;
            this.j = consumer;
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
            this.h.a(aVar);
            this.i.a(aVar);
            this.j.accept(aVar);
        }
    }

    public v(Pattern8<T1, T2, T3, T4, T5, T6, T7, T8> pattern8, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        this.a = pattern8;
        this.b = function8;
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
        l b9 = Plan.b(map, this.a.g, onErrorFrom);
        l b10 = Plan.b(map, this.a.h, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        i iVar = new i(b2, b3, b4, b5, b6, b8, b9, b10, new a(observer), new b(this, atomicReference, b2, b3, b4, b5, b6, b8, b9, b10, consumer));
        atomicReference.set(iVar);
        b2.d.add(iVar);
        b3.d.add(iVar);
        b4.d.add(iVar);
        b5.d.add(iVar);
        b6.d.add(iVar);
        b8.d.add(iVar);
        b9.d.add(iVar);
        b10.d.add(iVar);
        return iVar;
    }
}
