package hu.akarnokd.rxjava2.debug.validator;

import hu.akarnokd.rxjava2.debug.SavedHooks;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.Nullable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
public final class RxJavaProtocolValidator {
    public static volatile boolean a;
    public static volatile PlainConsumer<ProtocolNonConformanceException> b;
    public static final PlainConsumer<ProtocolNonConformanceException> c = new b();

    public static class a implements SavedHooks {
        public final /* synthetic */ Function a;
        public final /* synthetic */ Function b;
        public final /* synthetic */ Function c;
        public final /* synthetic */ Function d;
        public final /* synthetic */ Function e;
        public final /* synthetic */ Function f;
        public final /* synthetic */ Function g;
        public final /* synthetic */ Function h;

        public a(Function function, Function function2, Function function3, Function function4, Function function5, Function function6, Function function7, Function function8) {
            this.a = function;
            this.b = function2;
            this.c = function3;
            this.d = function4;
            this.e = function5;
            this.f = function6;
            this.g = function7;
            this.h = function8;
        }

        @Override // hu.akarnokd.rxjava2.debug.SavedHooks
        public void restore() {
            RxJavaPlugins.setOnCompletableAssembly(this.a);
            RxJavaPlugins.setOnSingleAssembly(this.b);
            RxJavaPlugins.setOnMaybeAssembly(this.c);
            RxJavaPlugins.setOnObservableAssembly(this.d);
            RxJavaPlugins.setOnFlowableAssembly(this.e);
            RxJavaPlugins.setOnConnectableObservableAssembly(this.f);
            RxJavaPlugins.setOnConnectableFlowableAssembly(this.g);
            RxJavaPlugins.setOnParallelAssembly(this.h);
        }
    }

    public static class b implements PlainConsumer<ProtocolNonConformanceException> {
        @Override // hu.akarnokd.rxjava2.functions.PlainConsumer, io.reactivex.functions.Consumer
        public void accept(Object obj) {
            RxJavaPlugins.onError((ProtocolNonConformanceException) obj);
        }
    }

    public static class c implements Function<Completable, Completable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public c(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Completable apply(Completable completable) throws Exception {
            return (Completable) this.a.apply(new r6.a.a.d.s.a(completable, this.b));
        }
    }

    public static class d implements Function<Maybe, Maybe> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public d(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Maybe apply(Maybe maybe) throws Exception {
            return (Maybe) this.a.apply(new r6.a.a.d.s.e(maybe, this.b));
        }
    }

    public static class e implements Function<Single, Single> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public e(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Single apply(Single single) throws Exception {
            return (Single) this.a.apply(new r6.a.a.d.s.h(single, this.b));
        }
    }

    public static class f implements Function<Observable, Observable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public f(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Observable apply(Observable observable) throws Exception {
            return (Observable) this.a.apply(new r6.a.a.d.s.f(observable, this.b));
        }
    }

    public static class g implements Function<Flowable, Flowable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public g(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Flowable apply(Flowable flowable) throws Exception {
            return (Flowable) this.a.apply(new r6.a.a.d.s.d(flowable, this.b));
        }
    }

    public static class h implements Function<ConnectableFlowable, ConnectableFlowable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public h(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ConnectableFlowable apply(ConnectableFlowable connectableFlowable) throws Exception {
            return (ConnectableFlowable) this.a.apply(new r6.a.a.d.s.b(connectableFlowable, this.b));
        }
    }

    public static class i implements Function<ConnectableObservable, ConnectableObservable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public i(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ConnectableObservable apply(ConnectableObservable connectableObservable) throws Exception {
            return (ConnectableObservable) this.a.apply(new r6.a.a.d.s.c(connectableObservable, this.b));
        }
    }

    public static class j implements Function<ParallelFlowable, ParallelFlowable> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ PlainConsumer b;

        public j(Function function, PlainConsumer plainConsumer) {
            this.a = function;
            this.b = plainConsumer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ParallelFlowable apply(ParallelFlowable parallelFlowable) throws Exception {
            return (ParallelFlowable) this.a.apply(new r6.a.a.d.s.g(parallelFlowable, this.b));
        }
    }

    public RxJavaProtocolValidator() {
        throw new IllegalStateException("No instances!");
    }

    public static SavedHooks a(boolean z) {
        Function<? super Completable, ? extends Completable> function;
        Function<? super Maybe, ? extends Maybe> function2;
        Function<? super Single, ? extends Single> function3;
        Function<? super Observable, ? extends Observable> function4;
        Function<? super Flowable, ? extends Flowable> function5;
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function6;
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function7;
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function8;
        PlainConsumer<ProtocolNonConformanceException> plainConsumer = b;
        if (plainConsumer == null) {
            plainConsumer = c;
        }
        Function<? super Completable, ? extends Completable> onCompletableAssembly = RxJavaPlugins.getOnCompletableAssembly();
        if (onCompletableAssembly == null || !z) {
            function = Functions.identity();
        } else {
            function = onCompletableAssembly;
        }
        RxJavaPlugins.setOnCompletableAssembly(new c(function, plainConsumer));
        Function<? super Maybe, ? extends Maybe> onMaybeAssembly = RxJavaPlugins.getOnMaybeAssembly();
        if (onMaybeAssembly == null || !z) {
            function2 = Functions.identity();
        } else {
            function2 = onMaybeAssembly;
        }
        RxJavaPlugins.setOnMaybeAssembly(new d(function2, plainConsumer));
        Function<? super Single, ? extends Single> onSingleAssembly = RxJavaPlugins.getOnSingleAssembly();
        if (onSingleAssembly == null || !z) {
            function3 = Functions.identity();
        } else {
            function3 = onSingleAssembly;
        }
        RxJavaPlugins.setOnSingleAssembly(new e(function3, plainConsumer));
        Function<? super Observable, ? extends Observable> onObservableAssembly = RxJavaPlugins.getOnObservableAssembly();
        if (onObservableAssembly == null || !z) {
            function4 = Functions.identity();
        } else {
            function4 = onObservableAssembly;
        }
        RxJavaPlugins.setOnObservableAssembly(new f(function4, plainConsumer));
        Function<? super Flowable, ? extends Flowable> onFlowableAssembly = RxJavaPlugins.getOnFlowableAssembly();
        if (onFlowableAssembly == null || !z) {
            function5 = Functions.identity();
        } else {
            function5 = onFlowableAssembly;
        }
        RxJavaPlugins.setOnFlowableAssembly(new g(function5, plainConsumer));
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly = RxJavaPlugins.getOnConnectableFlowableAssembly();
        if (onConnectableFlowableAssembly == null || !z) {
            function6 = Functions.identity();
        } else {
            function6 = onConnectableFlowableAssembly;
        }
        RxJavaPlugins.setOnConnectableFlowableAssembly(new h(function6, plainConsumer));
        Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly = RxJavaPlugins.getOnConnectableObservableAssembly();
        if (onConnectableObservableAssembly == null || !z) {
            function7 = Functions.identity();
        } else {
            function7 = onConnectableObservableAssembly;
        }
        RxJavaPlugins.setOnConnectableObservableAssembly(new i(function7, plainConsumer));
        Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly = RxJavaPlugins.getOnParallelAssembly();
        if (onParallelAssembly == null || !z) {
            function8 = Functions.identity();
        } else {
            function8 = onParallelAssembly;
        }
        RxJavaPlugins.setOnParallelAssembly(new j(function8, plainConsumer));
        a = true;
        return new a(onCompletableAssembly, onSingleAssembly, onMaybeAssembly, onObservableAssembly, onFlowableAssembly, onConnectableObservableAssembly, onConnectableFlowableAssembly, onParallelAssembly);
    }

    public static void disable() {
        RxJavaPlugins.setOnCompletableAssembly(null);
        RxJavaPlugins.setOnSingleAssembly(null);
        RxJavaPlugins.setOnMaybeAssembly(null);
        RxJavaPlugins.setOnObservableAssembly(null);
        RxJavaPlugins.setOnFlowableAssembly(null);
        RxJavaPlugins.setOnConnectableObservableAssembly(null);
        RxJavaPlugins.setOnConnectableFlowableAssembly(null);
        RxJavaPlugins.setOnParallelAssembly(null);
        a = false;
    }

    public static void enable() {
        a(false);
    }

    public static SavedHooks enableAndChain() {
        return a(true);
    }

    @Nullable
    public static PlainConsumer<ProtocolNonConformanceException> getOnViolationHandler() {
        return b;
    }

    public static boolean isEnabled() {
        return a;
    }

    public static void setOnViolationHandler(@Nullable PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        b = plainConsumer;
    }
}
