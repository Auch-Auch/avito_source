package r6.a.b.g;

import hu.akarnokd.rxjava3.joins.Pattern1;
import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class o<T1, R> extends Plan<R> {
    public final Pattern1<T1> a;
    public final Function<? super T1, ? extends R> b;

    public class a implements Consumer<T1> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T1 t1) {
            try {
                this.a.onNext(o.this.b.apply(t1));
            } catch (Throwable th) {
                this.a.onError(th);
            }
        }
    }

    public class b implements Action {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ l b;
        public final /* synthetic */ Consumer c;

        public b(o oVar, AtomicReference atomicReference, l lVar, Consumer consumer) {
            this.a = atomicReference;
            this.b = lVar;
            this.c = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            a aVar = (a) this.a.get();
            this.b.a(aVar);
            this.c.accept(aVar);
        }
    }

    public o(Pattern1<T1> pattern1, Function<? super T1, ? extends R> function) {
        this.a = pattern1;
        this.b = function;
    }

    @Override // hu.akarnokd.rxjava3.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        l b2 = Plan.b(map, this.a.a, Plan.onErrorFrom(observer));
        AtomicReference atomicReference = new AtomicReference();
        b bVar = new b(b2, new a(observer), new b(this, atomicReference, b2, consumer));
        atomicReference.set(bVar);
        b2.d.add(bVar);
        return bVar;
    }
}
