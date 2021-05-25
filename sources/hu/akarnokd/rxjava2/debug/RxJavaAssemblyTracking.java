package hu.akarnokd.rxjava2.debug;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import r6.a.a.d.i;
import r6.a.a.d.j;
import r6.a.a.d.k;
import r6.a.a.d.l;
import r6.a.a.d.m;
import r6.a.a.d.n;
import r6.a.a.d.o;
import r6.a.a.d.p;
import r6.a.a.d.q;
import r6.a.a.d.r;
public final class RxJavaAssemblyTracking {
    public static final AtomicBoolean a = new AtomicBoolean();

    public static class a implements Function<Flowable, Flowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Flowable apply(Flowable flowable) throws Exception {
            Flowable flowable2 = flowable;
            if (!(flowable2 instanceof Callable)) {
                return new r6.a.a.d.d(flowable2);
            }
            if (flowable2 instanceof ScalarCallable) {
                return new r6.a.a.d.g(flowable2);
            }
            return new r6.a.a.d.e(flowable2);
        }
    }

    public static class b implements Function<ConnectableFlowable, ConnectableFlowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ConnectableFlowable apply(ConnectableFlowable connectableFlowable) throws Exception {
            return new r6.a.a.d.f(connectableFlowable);
        }
    }

    public static class c implements Function<Observable, Observable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Observable apply(Observable observable) throws Exception {
            Observable observable2 = observable;
            if (!(observable2 instanceof Callable)) {
                return new k(observable2);
            }
            if (observable2 instanceof ScalarCallable) {
                return new n(observable2);
            }
            return new l(observable2);
        }
    }

    public static class d implements Function<ConnectableObservable, ConnectableObservable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ConnectableObservable apply(ConnectableObservable connectableObservable) throws Exception {
            return new m(connectableObservable);
        }
    }

    public static class e implements Function<Single, Single> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Single apply(Single single) throws Exception {
            Single single2 = single;
            if (!(single2 instanceof Callable)) {
                return new p(single2);
            }
            if (single2 instanceof ScalarCallable) {
                return new r(single2);
            }
            return new q(single2);
        }
    }

    public static class f implements Function<Completable, Completable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Completable apply(Completable completable) throws Exception {
            Completable completable2 = completable;
            if (!(completable2 instanceof Callable)) {
                return new r6.a.a.d.a(completable2);
            }
            if (completable2 instanceof ScalarCallable) {
                return new r6.a.a.d.c(completable2);
            }
            return new r6.a.a.d.b(completable2);
        }
    }

    public static class g implements Function<Maybe, Maybe> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Maybe apply(Maybe maybe) throws Exception {
            Maybe maybe2 = maybe;
            if (!(maybe2 instanceof Callable)) {
                return new r6.a.a.d.h(maybe2);
            }
            if (maybe2 instanceof ScalarCallable) {
                return new j(maybe2);
            }
            return new i(maybe2);
        }
    }

    public static class h implements Function<ParallelFlowable, ParallelFlowable> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ParallelFlowable apply(ParallelFlowable parallelFlowable) throws Exception {
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
