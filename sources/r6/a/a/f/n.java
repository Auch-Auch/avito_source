package r6.a.a.f;

import hu.akarnokd.rxjava2.joins.Plan;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.SafeObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class n extends Observable<R> {
    public final /* synthetic */ Iterable a;

    public class a implements Observer<R> {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ Map b;

        public a(n nVar, Observer observer, Map map) {
            this.a = observer;
            this.b = map;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            for (m mVar : this.b.values()) {
                mVar.dispose();
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // io.reactivex.Observer
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
        @Override // io.reactivex.functions.Consumer
        public void accept(a aVar) throws Exception {
            this.a.remove(aVar);
            if (this.a.isEmpty()) {
                this.b.onComplete();
            }
        }
    }

    public n(Iterable iterable) {
        this.a = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        HashMap hashMap = new HashMap();
        Object obj = new Object();
        ArrayList arrayList = new ArrayList();
        SafeObserver safeObserver = new SafeObserver(new a(this, observer, hashMap));
        safeObserver.onSubscribe(Disposables.empty());
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
