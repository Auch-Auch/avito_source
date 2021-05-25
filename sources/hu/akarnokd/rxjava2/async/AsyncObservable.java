package hu.akarnokd.rxjava2.async;

import hu.akarnokd.rxjava2.functions.Consumer3;
import hu.akarnokd.rxjava2.functions.Consumer4;
import hu.akarnokd.rxjava2.functions.Consumer5;
import hu.akarnokd.rxjava2.functions.Consumer6;
import hu.akarnokd.rxjava2.functions.Consumer7;
import hu.akarnokd.rxjava2.functions.Consumer8;
import hu.akarnokd.rxjava2.functions.Consumer9;
import hu.akarnokd.rxjava2.functions.PlainBiFunction;
import hu.akarnokd.rxjava2.functions.PlainFunction;
import hu.akarnokd.rxjava2.functions.PlainFunction3;
import hu.akarnokd.rxjava2.functions.PlainFunction4;
import hu.akarnokd.rxjava2.functions.PlainFunction5;
import hu.akarnokd.rxjava2.functions.PlainFunction6;
import hu.akarnokd.rxjava2.functions.PlainFunction7;
import hu.akarnokd.rxjava2.functions.PlainFunction8;
import hu.akarnokd.rxjava2.functions.PlainFunction9;
import hu.akarnokd.rxjava2.functions.Supplier;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import r6.a.a.a.d0;
import r6.a.a.a.e0;
import r6.a.a.a.f0;
import r6.a.a.a.g0;
import r6.a.a.a.h0;
import r6.a.a.a.i0;
import r6.a.a.a.j0;
import r6.a.a.a.k0;
import r6.a.a.a.l0;
import r6.a.a.a.m0;
import r6.a.a.a.n0;
import r6.a.a.a.o0;
import r6.a.a.a.p0;
import r6.a.a.a.r0;
import r6.a.a.a.s0;
public final class AsyncObservable {

    public static class a implements PlainFunction4<T1, T2, T3, T4, Observable<R>> {
        public final /* synthetic */ Function4 a;
        public final /* synthetic */ Scheduler b;

        public a(Function4 function4, Scheduler scheduler) {
            this.a = function4;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction4, io.reactivex.functions.Function4
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
            return Observable.fromCallable(new r6.a.a.a.w(this, obj, obj2, obj3, obj4)).subscribeOn(this.b);
        }
    }

    public static class a0 implements PlainFunction3<T1, T2, T3, Observable<Object>> {
        public final /* synthetic */ Consumer3 a;
        public final /* synthetic */ Scheduler b;

        public a0(Consumer3 consumer3, Scheduler scheduler) {
            this.a = consumer3;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction3, io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return Observable.fromCallable(new n0(this, obj, obj2, obj3)).subscribeOn(this.b);
        }
    }

    public static class b implements PlainFunction5<T1, T2, T3, T4, T5, Observable<Object>> {
        public final /* synthetic */ Consumer5 a;
        public final /* synthetic */ Scheduler b;

        public b(Consumer5 consumer5, Scheduler scheduler) {
            this.a = consumer5;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction5, io.reactivex.functions.Function5
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return Observable.fromCallable(new r6.a.a.a.x(this, obj, obj2, obj3, obj4, obj5)).subscribeOn(this.b);
        }
    }

    public static class b0 implements PlainFunction3<T1, T2, T3, Observable<R>> {
        public final /* synthetic */ Function3 a;
        public final /* synthetic */ Scheduler b;

        public b0(Function3 function3, Scheduler scheduler) {
            this.a = function3;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction3, io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return Observable.fromCallable(new o0(this, obj, obj2, obj3)).subscribeOn(this.b);
        }
    }

    public static class c implements PlainFunction5<T1, T2, T3, T4, T5, Observable<R>> {
        public final /* synthetic */ Function5 a;
        public final /* synthetic */ Scheduler b;

        public c(Function5 function5, Scheduler scheduler) {
            this.a = function5;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction5, io.reactivex.functions.Function5
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return Observable.fromCallable(new r6.a.a.a.y(this, obj, obj2, obj3, obj4, obj5)).subscribeOn(this.b);
        }
    }

    public static class c0 implements PlainFunction4<T1, T2, T3, T4, Observable<Object>> {
        public final /* synthetic */ Consumer4 a;
        public final /* synthetic */ Scheduler b;

        public c0(Consumer4 consumer4, Scheduler scheduler) {
            this.a = consumer4;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction4, io.reactivex.functions.Function4
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
            return Observable.fromCallable(new p0(this, obj, obj2, obj3, obj4)).subscribeOn(this.b);
        }
    }

    public static class d implements PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<Object>> {
        public final /* synthetic */ Consumer6 a;
        public final /* synthetic */ Scheduler b;

        public d(Consumer6 consumer6, Scheduler scheduler) {
            this.a = consumer6;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction6, io.reactivex.functions.Function6
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return Observable.fromCallable(new r6.a.a.a.z(this, obj, obj2, obj3, obj4, obj5, obj6)).subscribeOn(this.b);
        }
    }

    public static class e implements PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<R>> {
        public final /* synthetic */ Function6 a;
        public final /* synthetic */ Scheduler b;

        public e(Function6 function6, Scheduler scheduler) {
            this.a = function6;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction6, io.reactivex.functions.Function6
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return Observable.fromCallable(new r6.a.a.a.a0(this, obj, obj2, obj3, obj4, obj5, obj6)).subscribeOn(this.b);
        }
    }

    public static class f implements PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<Object>> {
        public final /* synthetic */ Consumer7 a;
        public final /* synthetic */ Scheduler b;

        public f(Consumer7 consumer7, Scheduler scheduler) {
            this.a = consumer7;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction7, io.reactivex.functions.Function7
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return Observable.fromCallable(new r6.a.a.a.b0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7)).subscribeOn(this.b);
        }
    }

    public static class g implements PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<R>> {
        public final /* synthetic */ Function7 a;
        public final /* synthetic */ Scheduler b;

        public g(Function7 function7, Scheduler scheduler) {
            this.a = function7;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction7, io.reactivex.functions.Function7
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return Observable.fromCallable(new r6.a.a.a.c0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7)).subscribeOn(this.b);
        }
    }

    public static class h implements PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<Object>> {
        public final /* synthetic */ Consumer8 a;
        public final /* synthetic */ Scheduler b;

        public h(Consumer8 consumer8, Scheduler scheduler) {
            this.a = consumer8;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction8, io.reactivex.functions.Function8
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return Observable.fromCallable(new d0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)).subscribeOn(this.b);
        }
    }

    public static class i implements PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<R>> {
        public final /* synthetic */ Function8 a;
        public final /* synthetic */ Scheduler b;

        public i(Function8 function8, Scheduler scheduler) {
            this.a = function8;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction8, io.reactivex.functions.Function8
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return Observable.fromCallable(new e0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)).subscribeOn(this.b);
        }
    }

    public static class j implements PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<Object>> {
        public final /* synthetic */ Consumer9 a;
        public final /* synthetic */ Scheduler b;

        public j(Consumer9 consumer9, Scheduler scheduler) {
            this.a = consumer9;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction9, io.reactivex.functions.Function9
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return Observable.fromCallable(new f0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)).subscribeOn(this.b);
        }
    }

    public static class k implements Supplier<Observable<Object>> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ Scheduler b;

        public k(Action action, Scheduler scheduler) {
            this.a = action;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.Supplier, java.util.concurrent.Callable
        public Object call() {
            return Observable.fromCallable(new r6.a.a.a.v(this)).subscribeOn(this.b);
        }
    }

    public static class l implements PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<R>> {
        public final /* synthetic */ Function9 a;
        public final /* synthetic */ Scheduler b;

        public l(Function9 function9, Scheduler scheduler) {
            this.a = function9;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction9, io.reactivex.functions.Function9
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return Observable.fromCallable(new g0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)).subscribeOn(this.b);
        }
    }

    public static class m implements PlainFunction<Object[], Observable<Object>> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Scheduler b;

        public m(Consumer consumer, Scheduler scheduler) {
            this.a = consumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction, io.reactivex.functions.Function
        public Object apply(Object obj) {
            return Observable.fromCallable(new h0(this, (Object[]) obj)).subscribeOn(this.b);
        }
    }

    public static class n implements PlainFunction<Object[], Observable<R>> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ Scheduler b;

        public n(Function function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction, io.reactivex.functions.Function
        public Object apply(Object obj) {
            return Observable.fromCallable(new i0(this, (Object[]) obj)).subscribeOn(this.b);
        }
    }

    public static class o implements Callable<T> {
        public final /* synthetic */ Callable a;

        public o(Callable callable) {
            this.a = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            return (T) ((Future) this.a.call()).get();
        }
    }

    public static class p implements Callable<ObservableSource<? extends T>> {
        public final /* synthetic */ Callable a;

        public p(Callable callable) {
            this.a = callable;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            return (ObservableSource) ((Future) this.a.call()).get();
        }
    }

    public static class q implements Consumer<Throwable> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ r0 b;

        public q(Consumer consumer, r0 r0Var) {
            this.a = consumer;
            this.b = r0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            Throwable th2 = th;
            try {
                this.a.accept(th2);
                this.b.b(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.b.b(new CompositeException(th2, th3));
            }
        }
    }

    public static class r implements Action {
        public final /* synthetic */ Action a;
        public final /* synthetic */ r0 b;

        public r(Action action, r0 r0Var) {
            this.a = action;
            this.b = r0Var;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            try {
                this.a.run();
                this.b.a(null);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.b(th);
            }
        }
    }

    public static class s implements Consumer<Disposable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) throws Exception {
        }
    }

    public static class t implements Runnable {
        public final /* synthetic */ BiConsumer a;
        public final /* synthetic */ Subject b;
        public final /* synthetic */ SequentialDisposable c;

        public t(BiConsumer biConsumer, Subject subject, SequentialDisposable sequentialDisposable) {
            this.a = biConsumer;
            this.b = subject;
            this.c = sequentialDisposable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.accept(this.b, this.c);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.onError(th);
            }
        }
    }

    public static class u extends DisposableObservable<T> {
        public final /* synthetic */ Subject a;
        public final /* synthetic */ SequentialDisposable b;

        public u(Subject subject, SequentialDisposable sequentialDisposable) {
            this.a = subject;
            this.b = sequentialDisposable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.a.subscribe(observer);
        }
    }

    public static class v implements Supplier<Observable<R>> {
        public final /* synthetic */ Callable a;
        public final /* synthetic */ Scheduler b;

        public v(Callable callable, Scheduler scheduler) {
            this.a = callable;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.Supplier, java.util.concurrent.Callable
        public Object call() {
            return Observable.fromCallable(this.a).subscribeOn(this.b);
        }
    }

    public static class w implements PlainFunction<T1, Observable<Object>> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Scheduler b;

        public w(Consumer consumer, Scheduler scheduler) {
            this.a = consumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction, io.reactivex.functions.Function
        public Object apply(Object obj) {
            return Observable.fromCallable(new j0(this, obj)).subscribeOn(this.b);
        }
    }

    public static class x implements PlainFunction<T1, Observable<R>> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ Scheduler b;

        public x(Function function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainFunction, io.reactivex.functions.Function
        public Object apply(Object obj) {
            return Observable.fromCallable(new k0(this, obj)).subscribeOn(this.b);
        }
    }

    public static class y implements PlainBiFunction<T1, T2, Observable<Object>> {
        public final /* synthetic */ BiConsumer a;
        public final /* synthetic */ Scheduler b;

        public y(BiConsumer biConsumer, Scheduler scheduler) {
            this.a = biConsumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainBiFunction, io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return Observable.fromCallable(new l0(this, obj, obj2)).subscribeOn(this.b);
        }
    }

    public static class z implements PlainBiFunction<T1, T2, Observable<R>> {
        public final /* synthetic */ BiFunction a;
        public final /* synthetic */ Scheduler b;

        public z(BiFunction biFunction, Scheduler scheduler) {
            this.a = biFunction;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava2.functions.PlainBiFunction, io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return Observable.fromCallable(new m0(this, obj, obj2)).subscribeOn(this.b);
        }
    }

    public AsyncObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable<T> deferFuture(Callable<? extends Future<? extends ObservableSource<? extends T>>> callable) {
        return deferFuture(callable, Schedulers.computation());
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer) {
        return forEachFuture(observableSource, consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Schedulers.computation());
    }

    public static <T> DisposableObservable<T> runAsync(Scheduler scheduler, BiConsumer<? super Observer<? super T>, ? super Disposable> biConsumer) {
        return runAsync(scheduler, PublishSubject.create(), biConsumer);
    }

    public static <T> Observable<T> start(Callable<? extends T> callable) {
        return start(callable, Schedulers.computation());
    }

    public static <T> Observable<T> startFuture(Callable<? extends Future<? extends T>> callable) {
        return RxJavaPlugins.onAssembly(new s0(new o(callable)));
    }

    public static Supplier<Observable<Object>> toAsync(Action action) {
        return toAsync(action, Schedulers.computation());
    }

    public static PlainFunction<Object[], Observable<Object>> toAsyncArray(Consumer<? super Object[]> consumer) {
        return toAsyncArray(consumer, Schedulers.computation());
    }

    public static <T> Observable<T> deferFuture(Callable<? extends Future<? extends ObservableSource<? extends T>>> callable, Scheduler scheduler) {
        return Observable.defer(new p(callable)).subscribeOn(scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return forEachFuture(observableSource, consumer, consumer2, Functions.EMPTY_ACTION, Schedulers.computation());
    }

    public static <T> DisposableObservable<T> runAsync(Scheduler scheduler, Subject<T> subject, BiConsumer<? super Observer<? super T>, ? super Disposable> biConsumer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        sequentialDisposable.replace(scheduler.scheduleDirect(new t(biConsumer, subject, sequentialDisposable)));
        return new u(subject, sequentialDisposable);
    }

    public static <T> Observable<T> start(Callable<? extends T> callable, Scheduler scheduler) {
        return (Observable) Observable.fromCallable(callable).subscribeOn(scheduler).subscribeWith(AsyncSubject.create());
    }

    public static <T> Observable<T> startFuture(Callable<? extends Future<? extends T>> callable, Scheduler scheduler) {
        return startFuture(callable).subscribeOn(scheduler);
    }

    public static <R> Supplier<Observable<R>> toAsync(Callable<? extends R> callable) {
        return toAsync(callable, Schedulers.computation());
    }

    public static <R> PlainFunction<Object[], Observable<R>> toAsyncArray(Function<? super Object[], ? extends R> function) {
        return toAsyncArray(function, Schedulers.computation());
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return forEachFuture(observableSource, consumer, consumer2, action, Schedulers.computation());
    }

    public static <T1> PlainFunction<T1, Observable<Object>> toAsync(Consumer<? super T1> consumer) {
        return toAsync(consumer, Schedulers.computation());
    }

    public static PlainFunction<Object[], Observable<Object>> toAsyncArray(Consumer<? super Object[]> consumer, Scheduler scheduler) {
        return new m(consumer, scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Scheduler scheduler) {
        return forEachFuture(observableSource, consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, scheduler);
    }

    public static <T1, R> PlainFunction<T1, Observable<R>> toAsync(Function<? super T1, ? extends R> function) {
        return toAsync(function, Schedulers.computation());
    }

    public static <R> PlainFunction<Object[], Observable<R>> toAsyncArray(Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        return new n(function, scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Scheduler scheduler) {
        return forEachFuture(observableSource, consumer, consumer2, Functions.EMPTY_ACTION, scheduler);
    }

    public static <T1, T2> PlainBiFunction<T1, T2, Observable<Object>> toAsync(BiConsumer<? super T1, ? super T2> biConsumer) {
        return toAsync(biConsumer, Schedulers.computation());
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Scheduler scheduler) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        r0 r0Var = new r0(sequentialDisposable);
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, new q(consumer2, r0Var), new r(action, r0Var), new s());
        sequentialDisposable.lazySet(lambdaObserver);
        Observable.wrap(observableSource).subscribeOn(scheduler).subscribe(lambdaObserver);
        return r0Var;
    }

    public static <T1, T2, R> PlainBiFunction<T1, T2, Observable<R>> toAsync(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return toAsync(biFunction, Schedulers.computation());
    }

    public static <T1, T2, T3> PlainFunction3<T1, T2, T3, Observable<Object>> toAsync(Consumer3<? super T1, ? super T2, ? super T3> consumer3) {
        return toAsync(consumer3, Schedulers.computation());
    }

    public static <T1, T2, T3, R> PlainFunction3<T1, T2, T3, Observable<R>> toAsync(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        return toAsync(function3, Schedulers.computation());
    }

    public static <T1, T2, T3, T4> PlainFunction4<T1, T2, T3, T4, Observable<Object>> toAsync(Consumer4<? super T1, ? super T2, ? super T3, ? super T4> consumer4) {
        return toAsync(consumer4, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, R> PlainFunction4<T1, T2, T3, T4, Observable<R>> toAsync(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        return toAsync(function4, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5> PlainFunction5<T1, T2, T3, T4, T5, Observable<Object>> toAsync(Consumer5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5> consumer5) {
        return toAsync(consumer5, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, R> PlainFunction5<T1, T2, T3, T4, T5, Observable<R>> toAsync(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        return toAsync(function5, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<Object>> toAsync(Consumer6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6> consumer6) {
        return toAsync(consumer6, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, R> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<R>> toAsync(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        return toAsync(function6, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<Object>> toAsync(Consumer7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7> consumer7) {
        return toAsync(consumer7, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<R>> toAsync(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        return toAsync(function7, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<Object>> toAsync(Consumer8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8> consumer8) {
        return toAsync(consumer8, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<R>> toAsync(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        return toAsync(function8, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<Object>> toAsync(Consumer9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9> consumer9) {
        return toAsync(consumer9, Schedulers.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<R>> toAsync(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        return toAsync(function9, Schedulers.computation());
    }

    public static Supplier<Observable<Object>> toAsync(Action action, Scheduler scheduler) {
        return new k(action, scheduler);
    }

    public static <R> Supplier<Observable<R>> toAsync(Callable<? extends R> callable, Scheduler scheduler) {
        return new v(callable, scheduler);
    }

    public static <T1> PlainFunction<T1, Observable<Object>> toAsync(Consumer<? super T1> consumer, Scheduler scheduler) {
        return new w(consumer, scheduler);
    }

    public static <T1, R> PlainFunction<T1, Observable<R>> toAsync(Function<? super T1, ? extends R> function, Scheduler scheduler) {
        return new x(function, scheduler);
    }

    public static <T1, T2> PlainBiFunction<T1, T2, Observable<Object>> toAsync(BiConsumer<? super T1, ? super T2> biConsumer, Scheduler scheduler) {
        return new y(biConsumer, scheduler);
    }

    public static <T1, T2, R> PlainBiFunction<T1, T2, Observable<R>> toAsync(BiFunction<? super T1, ? super T2, ? extends R> biFunction, Scheduler scheduler) {
        return new z(biFunction, scheduler);
    }

    public static <T1, T2, T3> PlainFunction3<T1, T2, T3, Observable<Object>> toAsync(Consumer3<? super T1, ? super T2, ? super T3> consumer3, Scheduler scheduler) {
        return new a0(consumer3, scheduler);
    }

    public static <T1, T2, T3, R> PlainFunction3<T1, T2, T3, Observable<R>> toAsync(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Scheduler scheduler) {
        return new b0(function3, scheduler);
    }

    public static <T1, T2, T3, T4> PlainFunction4<T1, T2, T3, T4, Observable<Object>> toAsync(Consumer4<? super T1, ? super T2, ? super T3, ? super T4> consumer4, Scheduler scheduler) {
        return new c0(consumer4, scheduler);
    }

    public static <T1, T2, T3, T4, R> PlainFunction4<T1, T2, T3, T4, Observable<R>> toAsync(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Scheduler scheduler) {
        return new a(function4, scheduler);
    }

    public static <T1, T2, T3, T4, T5> PlainFunction5<T1, T2, T3, T4, T5, Observable<Object>> toAsync(Consumer5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5> consumer5, Scheduler scheduler) {
        return new b(consumer5, scheduler);
    }

    public static <T1, T2, T3, T4, T5, R> PlainFunction5<T1, T2, T3, T4, T5, Observable<R>> toAsync(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5, Scheduler scheduler) {
        return new c(function5, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<Object>> toAsync(Consumer6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6> consumer6, Scheduler scheduler) {
        return new d(consumer6, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, R> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<R>> toAsync(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6, Scheduler scheduler) {
        return new e(function6, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<Object>> toAsync(Consumer7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7> consumer7, Scheduler scheduler) {
        return new f(consumer7, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<R>> toAsync(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7, Scheduler scheduler) {
        return new g(function7, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<Object>> toAsync(Consumer8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8> consumer8, Scheduler scheduler) {
        return new h(consumer8, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<R>> toAsync(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8, Scheduler scheduler) {
        return new i(function8, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<Object>> toAsync(Consumer9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9> consumer9, Scheduler scheduler) {
        return new j(consumer9, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<R>> toAsync(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9, Scheduler scheduler) {
        return new l(function9, scheduler);
    }
}
