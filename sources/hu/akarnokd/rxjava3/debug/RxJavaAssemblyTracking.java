package hu.akarnokd.rxjava3.debug;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import r6.a.b.e.i;
import r6.a.b.e.j;
import r6.a.b.e.k;
import r6.a.b.e.l;
import r6.a.b.e.m;
import r6.a.b.e.n;
import r6.a.b.e.o;
import r6.a.b.e.p;
import r6.a.b.e.q;
import r6.a.b.e.r;
public final class RxJavaAssemblyTracking {
    public static final AtomicBoolean a = new AtomicBoolean();

    public class a implements Function<Flowable, Flowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Flowable apply(Flowable flowable) throws Throwable {
            Flowable flowable2 = flowable;
            if (!(flowable2 instanceof Supplier)) {
                return new r6.a.b.e.d(flowable2);
            }
            if (flowable2 instanceof ScalarSupplier) {
                return new r6.a.b.e.f(flowable2);
            }
            return new r6.a.b.e.g(flowable2);
        }
    }

    public class b implements Function<ConnectableFlowable, ConnectableFlowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ConnectableFlowable apply(ConnectableFlowable connectableFlowable) throws Throwable {
            return new r6.a.b.e.e(connectableFlowable);
        }
    }

    public class c implements Function<Observable, Observable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Observable apply(Observable observable) throws Throwable {
            Observable observable2 = observable;
            if (!(observable2 instanceof Supplier)) {
                return new k(observable2);
            }
            if (observable2 instanceof ScalarSupplier) {
                return new m(observable2);
            }
            return new n(observable2);
        }
    }

    public class d implements Function<ConnectableObservable, ConnectableObservable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ConnectableObservable apply(ConnectableObservable connectableObservable) throws Throwable {
            return new l(connectableObservable);
        }
    }

    public class e implements Function<Single, Single> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Single apply(Single single) throws Throwable {
            Single single2 = single;
            if (!(single2 instanceof Supplier)) {
                return new p(single2);
            }
            if (single2 instanceof ScalarSupplier) {
                return new q(single2);
            }
            return new r(single2);
        }
    }

    public class f implements Function<Completable, Completable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Completable apply(Completable completable) throws Throwable {
            Completable completable2 = completable;
            if (!(completable2 instanceof Supplier)) {
                return new r6.a.b.e.a(completable2);
            }
            if (completable2 instanceof ScalarSupplier) {
                return new r6.a.b.e.b(completable2);
            }
            return new r6.a.b.e.c(completable2);
        }
    }

    public class g implements Function<Maybe, Maybe> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Maybe apply(Maybe maybe) throws Throwable {
            Maybe maybe2 = maybe;
            if (!(maybe2 instanceof Supplier)) {
                return new r6.a.b.e.h(maybe2);
            }
            if (maybe2 instanceof ScalarSupplier) {
                return new i(maybe2);
            }
            return new j(maybe2);
        }
    }

    public class h implements Function<ParallelFlowable, ParallelFlowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ParallelFlowable apply(ParallelFlowable parallelFlowable) throws Throwable {
            return new o(parallelFlowable);
        }
    }

    public RxJavaAssemblyTracking() {
        throw new IllegalStateException("No instances!");
    }

    public static void disable() {
        AtomicBoolean atomicBoolean = a;
        if (atomicBoolean.compareAndSet(false, true)) {
            RxJavaPlugins.setOnCompletableAssembly(null);
            RxJavaPlugins.setOnSingleAssembly(null);
            RxJavaPlugins.setOnMaybeAssembly(null);
            RxJavaPlugins.setOnObservableAssembly(null);
            RxJavaPlugins.setOnFlowableAssembly(null);
            RxJavaPlugins.setOnConnectableObservableAssembly(null);
            RxJavaPlugins.setOnConnectableFlowableAssembly(null);
            RxJavaPlugins.setOnParallelAssembly(null);
            atomicBoolean.set(false);
        }
    }

    public static void enable() {
        AtomicBoolean atomicBoolean = a;
        if (atomicBoolean.compareAndSet(false, true)) {
            RxJavaPlugins.setOnFlowableAssembly(new a());
            RxJavaPlugins.setOnConnectableFlowableAssembly(new b());
            RxJavaPlugins.setOnObservableAssembly(new c());
            RxJavaPlugins.setOnConnectableObservableAssembly(new d());
            RxJavaPlugins.setOnSingleAssembly(new e());
            RxJavaPlugins.setOnCompletableAssembly(new f());
            RxJavaPlugins.setOnMaybeAssembly(new g());
            RxJavaPlugins.setOnParallelAssembly(new h());
            atomicBoolean.set(false);
        }
    }
}
