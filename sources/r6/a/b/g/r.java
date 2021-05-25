package r6.a.b.g;

import hu.akarnokd.rxjava3.functions.Consumer4;
import hu.akarnokd.rxjava3.joins.Pattern4;
import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function4;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class r<T1, T2, T3, T4, R> extends Plan<R> {
    public final Pattern4<T1, T2, T3, T4> a;
    public final Function4<T1, T2, T3, T4, R> b;

    public class a implements Consumer4<T1, T2, T3, T4> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer4
        public void accept(T1 t1, T2 t2, T3 t3, T4 t4) {
            try {
                this.a.onNext(r.this.b.apply(t1, t2, t3, t4));
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
        public final /* synthetic */ Consumer f;

        public b(r rVar, AtomicReference atomicReference, l lVar, l lVar2, l lVar3, l lVar4, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = lVar2;
            this.d = lVar3;
            this.e = lVar4;
            this.f = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.a(aVar);
            this.d.a(aVar);
            this.e.a(aVar);
            this.f.accept(aVar);
        }
    }

    public r(Pattern4<T1, T2, T3, T4> pattern4, Function4<T1, T2, T3, T4, R> function4) {
        this.a = pattern4;
        this.b = function4;
    }

    @Override // hu.akarnokd.rxjava3.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        l b2 = Plan.b(map, this.a.a, onErrorFrom);
        l b3 = Plan.b(map, this.a.b, onErrorFrom);
        l b4 = Plan.b(map, this.a.c, onErrorFrom);
        l b5 = Plan.b(map, this.a.d, onErrorFrom);
        AtomicReference atomicReference = new AtomicReference();
        e eVar = new e(b2, b3, b4, b5, new a(observer), new b(this, atomicReference, b2, b3, b4, b5, consumer));
        atomicReference.set(eVar);
        b2.d.add(eVar);
        b3.d.add(eVar);
        b4.d.add(eVar);
        b5.d.add(eVar);
        return eVar;
    }
}
