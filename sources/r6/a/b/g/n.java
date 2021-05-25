package r6.a.b.g;

import hu.akarnokd.rxjava3.joins.Plan;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.SafeObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class n extends Observable<R> {
    public final /* synthetic */ Iterable a;

    public class a implements Observer<R> {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ Map b;

        public a(n nVar, Observer observer, Map map) {
            this.a = observer;
            this.b = map;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            for (m mVar : this.b.values()) {
                mVar.dispose();
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public class b implements Consumer<a> {
        public final /* synthetic */ List a;
        public final /* synthetic */ Observer b;

        public b(n nVar, List list, Observer observer) {
            this.a = list;
            this.b = observer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(a aVar) throws Throwable {
            this.a.remove(aVar);
            if (this.a.isEmpty()) {
                this.b.onComplete();
            }
        }
    }

    public n(Iterable iterable) {
        this.a = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        HashMap hashMap = new HashMap();
        Object obj = new Object();
        ArrayList arrayList = new ArrayList();
        SafeObserver safeObserver = new SafeObserver(new a(this, observer, hashMap));
        safeObserver.onSubscribe(s6.a.e.c.b.a());
        try {
            for (Plan plan : this.a) {
                arrayList.add(plan.a(hashMap, safeObserver, new b(this, arrayList, safeObserver)));
            }
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            observer.onSubscribe(compositeDisposable);
            for (m mVar : hashMap.values()) {
                mVar.subscribe(obj);
                compositeDisposable.add(mVar);
            }
        } catch (Throwable th) {
            Observable.error(th).subscribe(observer);
        }
    }
}
