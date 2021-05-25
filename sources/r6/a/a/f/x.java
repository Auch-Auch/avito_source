package r6.a.a.f;

import hu.akarnokd.rxjava2.joins.PatternN;
import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public final class x<R> extends Plan<R> {
    public final PatternN a;
    public final Function<? super Object[], R> b;

    public class a implements Consumer<Object[]> {
        public final /* synthetic */ Observer a;

        public a(Observer observer) {
            this.a = observer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Object[] objArr) throws Exception {
            try {
                this.a.onNext(x.this.b.apply(objArr));
            } catch (Throwable th) {
                this.a.onError(th);
            }
        }
    }

    public class b implements Action {
        public final /* synthetic */ List a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ Consumer c;

        public b(x xVar, List list, AtomicReference atomicReference, Consumer consumer) {
            this.a = list;
            this.b = atomicReference;
            this.c = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            for (l lVar : this.a) {
                lVar.a((a) this.b.get());
            }
            this.c.accept(this.b.get());
        }
    }

    public x(PatternN patternN, Function<? super Object[], R> function) {
        this.a = patternN;
        this.b = function;
    }

    @Override // hu.akarnokd.rxjava2.joins.Plan
    public a a(Map<Object, m> map, Observer<R> observer, Consumer<a> consumer) {
        Consumer<Throwable> onErrorFrom = Plan.onErrorFrom(observer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.a.size(); i++) {
            arrayList.add(Plan.b(map, this.a.a.get(i), onErrorFrom));
        }
        AtomicReference atomicReference = new AtomicReference();
        k kVar = new k(arrayList, new a(observer), new b(this, arrayList, atomicReference, consumer));
        atomicReference.set(kVar);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).d.add(kVar);
        }
        return kVar;
    }
}
