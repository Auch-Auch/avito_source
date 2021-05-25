package hu.akarnokd.rxjava3.async;

import hu.akarnokd.rxjava3.functions.Consumer3;
import hu.akarnokd.rxjava3.functions.Consumer4;
import hu.akarnokd.rxjava3.functions.Consumer5;
import hu.akarnokd.rxjava3.functions.Consumer6;
import hu.akarnokd.rxjava3.functions.Consumer7;
import hu.akarnokd.rxjava3.functions.Consumer8;
import hu.akarnokd.rxjava3.functions.Consumer9;
import hu.akarnokd.rxjava3.functions.PlainBiFunction;
import hu.akarnokd.rxjava3.functions.PlainFunction;
import hu.akarnokd.rxjava3.functions.PlainFunction3;
import hu.akarnokd.rxjava3.functions.PlainFunction4;
import hu.akarnokd.rxjava3.functions.PlainFunction5;
import hu.akarnokd.rxjava3.functions.PlainFunction6;
import hu.akarnokd.rxjava3.functions.PlainFunction7;
import hu.akarnokd.rxjava3.functions.PlainFunction8;
import hu.akarnokd.rxjava3.functions.PlainFunction9;
import hu.akarnokd.rxjava3.functions.SimpleCallable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import r6.a.b.a.e0;
import r6.a.b.a.f0;
import r6.a.b.a.g0;
import r6.a.b.a.h0;
import r6.a.b.a.i0;
import r6.a.b.a.j0;
import r6.a.b.a.k0;
import r6.a.b.a.l0;
import r6.a.b.a.m0;
import r6.a.b.a.n0;
import r6.a.b.a.o0;
import r6.a.b.a.p0;
import r6.a.b.a.r0;
import r6.a.b.a.s0;
public final class AsyncObservable {

    public class a implements PlainFunction4<T1, T2, T3, T4, Observable<Object>> {
        public final /* synthetic */ Consumer4 a;
        public final /* synthetic */ Scheduler b;

        public a(Consumer4 consumer4, Scheduler scheduler) {
            this.a = consumer4;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction4, io.reactivex.rxjava3.functions.Function4
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
            return Observable.fromSupplier(new r6.a.b.a.w(this, obj, obj2, obj3, obj4)).subscribeOn(this.b);
        }
    }

    public class a0 implements PlainBiFunction<T1, T2, Observable<Object>> {
        public final /* synthetic */ BiConsumer a;
        public final /* synthetic */ Scheduler b;

        public a0(BiConsumer biConsumer, Scheduler scheduler) {
            this.a = biConsumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainBiFunction, io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return Observable.fromSupplier(new m0(this, obj, obj2)).subscribeOn(this.b);
        }
    }

    public class b implements PlainFunction4<T1, T2, T3, T4, Observable<R>> {
        public final /* synthetic */ Function4 a;
        public final /* synthetic */ Scheduler b;

        public b(Function4 function4, Scheduler scheduler) {
            this.a = function4;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction4, io.reactivex.rxjava3.functions.Function4
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
            return Observable.fromSupplier(new r6.a.b.a.x(this, obj, obj2, obj3, obj4)).subscribeOn(this.b);
        }
    }

    public class b0 implements PlainBiFunction<T1, T2, Observable<R>> {
        public final /* synthetic */ BiFunction a;
        public final /* synthetic */ Scheduler b;

        public b0(BiFunction biFunction, Scheduler scheduler) {
            this.a = biFunction;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainBiFunction, io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return Observable.fromSupplier(new n0(this, obj, obj2)).subscribeOn(this.b);
        }
    }

    public class c implements PlainFunction5<T1, T2, T3, T4, T5, Observable<Object>> {
        public final /* synthetic */ Consumer5 a;
        public final /* synthetic */ Scheduler b;

        public c(Consumer5 consumer5, Scheduler scheduler) {
            this.a = consumer5;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction5, io.reactivex.rxjava3.functions.Function5
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return Observable.fromSupplier(new r6.a.b.a.y(this, obj, obj2, obj3, obj4, obj5)).subscribeOn(this.b);
        }
    }

    public class c0 implements PlainFunction3<T1, T2, T3, Observable<Object>> {
        public final /* synthetic */ Consumer3 a;
        public final /* synthetic */ Scheduler b;

        public c0(Consumer3 consumer3, Scheduler scheduler) {
            this.a = consumer3;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction3, io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return Observable.fromSupplier(new o0(this, obj, obj2, obj3)).subscribeOn(this.b);
        }
    }

    public class d implements PlainFunction5<T1, T2, T3, T4, T5, Observable<R>> {
        public final /* synthetic */ Function5 a;
        public final /* synthetic */ Scheduler b;

        public d(Function5 function5, Scheduler scheduler) {
            this.a = function5;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction5, io.reactivex.rxjava3.functions.Function5
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return Observable.fromSupplier(new r6.a.b.a.z(this, obj, obj2, obj3, obj4, obj5)).subscribeOn(this.b);
        }
    }

    public class d0 implements PlainFunction3<T1, T2, T3, Observable<R>> {
        public final /* synthetic */ Function3 a;
        public final /* synthetic */ Scheduler b;

        public d0(Function3 function3, Scheduler scheduler) {
            this.a = function3;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction3, io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return Observable.fromSupplier(new p0(this, obj, obj2, obj3)).subscribeOn(this.b);
        }
    }

    public class e implements PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<Object>> {
        public final /* synthetic */ Consumer6 a;
        public final /* synthetic */ Scheduler b;

        public e(Consumer6 consumer6, Scheduler scheduler) {
            this.a = consumer6;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction6, io.reactivex.rxjava3.functions.Function6
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return Observable.fromSupplier(new r6.a.b.a.a0(this, obj, obj2, obj3, obj4, obj5, obj6)).subscribeOn(this.b);
        }
    }

    public class f implements PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<R>> {
        public final /* synthetic */ Function6 a;
        public final /* synthetic */ Scheduler b;

        public f(Function6 function6, Scheduler scheduler) {
            this.a = function6;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction6, io.reactivex.rxjava3.functions.Function6
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return Observable.fromSupplier(new r6.a.b.a.b0(this, obj, obj2, obj3, obj4, obj5, obj6)).subscribeOn(this.b);
        }
    }

    public class g implements PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<Object>> {
        public final /* synthetic */ Consumer7 a;
        public final /* synthetic */ Scheduler b;

        public g(Consumer7 consumer7, Scheduler scheduler) {
            this.a = consumer7;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction7, io.reactivex.rxjava3.functions.Function7
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return Observable.fromSupplier(new r6.a.b.a.c0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7)).subscribeOn(this.b);
        }
    }

    public class h implements PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<R>> {
        public final /* synthetic */ Function7 a;
        public final /* synthetic */ Scheduler b;

        public h(Function7 function7, Scheduler scheduler) {
            this.a = function7;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction7, io.reactivex.rxjava3.functions.Function7
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return Observable.fromSupplier(new r6.a.b.a.d0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7)).subscribeOn(this.b);
        }
    }

    public class i implements PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<Object>> {
        public final /* synthetic */ Consumer8 a;
        public final /* synthetic */ Scheduler b;

        public i(Consumer8 consumer8, Scheduler scheduler) {
            this.a = consumer8;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction8, io.reactivex.rxjava3.functions.Function8
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return Observable.fromSupplier(new e0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)).subscribeOn(this.b);
        }
    }

    public class j implements PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<R>> {
        public final /* synthetic */ Function8 a;
        public final /* synthetic */ Scheduler b;

        public j(Function8 function8, Scheduler scheduler) {
            this.a = function8;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction8, io.reactivex.rxjava3.functions.Function8
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return Observable.fromSupplier(new f0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)).subscribeOn(this.b);
        }
    }

    public class k implements SimpleCallable<Observable<Object>> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ Scheduler b;

        public k(Action action, Scheduler scheduler) {
            this.a = action;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.SimpleCallable, java.util.concurrent.Callable
        public Object call() {
            return Observable.fromSupplier(new r6.a.b.a.v(this)).subscribeOn(this.b);
        }
    }

    public class l implements PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<Object>> {
        public final /* synthetic */ Consumer9 a;
        public final /* synthetic */ Scheduler b;

        public l(Consumer9 consumer9, Scheduler scheduler) {
            this.a = consumer9;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction9, io.reactivex.rxjava3.functions.Function9
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return Observable.fromSupplier(new g0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)).subscribeOn(this.b);
        }
    }

    public class m implements PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<R>> {
        public final /* synthetic */ Function9 a;
        public final /* synthetic */ Scheduler b;

        public m(Function9 function9, Scheduler scheduler) {
            this.a = function9;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction9, io.reactivex.rxjava3.functions.Function9
        public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return Observable.fromSupplier(new h0(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)).subscribeOn(this.b);
        }
    }

    public class n implements PlainFunction<Object[], Observable<Object>> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Scheduler b;

        public n(Consumer consumer, Scheduler scheduler) {
            this.a = consumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction, io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return Observable.fromSupplier(new i0(this, (Object[]) obj)).subscribeOn(this.b);
        }
    }

    public class o implements PlainFunction<Object[], Observable<R>> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ Scheduler b;

        public o(Function function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction, io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return Observable.fromSupplier(new j0(this, (Object[]) obj)).subscribeOn(this.b);
        }
    }

    public class p implements Supplier<T> {
        public final /* synthetic */ Supplier a;

        public p(Supplier supplier) {
            this.a = supplier;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public T get() throws Throwable {
            return (T) ((Future) this.a.get()).get();
        }
    }

    public class q implements Supplier<ObservableSource<? extends T>> {
        public final /* synthetic */ Supplier a;

        public q(Supplier supplier) {
            this.a = supplier;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return (ObservableSource) ((Future) this.a.get()).get();
        }
    }

    public class r implements Consumer<Throwable> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ r0 b;

        public r(Consumer consumer, r0 r0Var) {
            this.a = consumer;
            this.b = r0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
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

    public class s implements Action {
        public final /* synthetic */ Action a;
        public final /* synthetic */ r0 b;

        public s(Action action, r0 r0Var) {
            this.a = action;
            this.b = r0Var;
        }

        @Override // io.reactivex.rxjava3.functions.Action
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

    public class t implements Consumer<Disposable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) throws Throwable {
        }
    }

    public class u implements Runnable {
        public final /* synthetic */ BiConsumer a;
        public final /* synthetic */ Subject b;
        public final /* synthetic */ SequentialDisposable c;

        public u(BiConsumer biConsumer, Subject subject, SequentialDisposable sequentialDisposable) {
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

    public class v implements SimpleCallable<Observable<R>> {
        public final /* synthetic */ Callable a;
        public final /* synthetic */ Scheduler b;

        public v(Callable callable, Scheduler scheduler) {
            this.a = callable;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.SimpleCallable, java.util.concurrent.Callable
        public Object call() {
            return Observable.fromCallable(this.a).subscribeOn(this.b);
        }
    }

    public class w extends DisposableObservable<T> {
        public final /* synthetic */ Subject a;
        public final /* synthetic */ SequentialDisposable b;

        public w(Subject subject, SequentialDisposable sequentialDisposable) {
            this.a = subject;
            this.b = sequentialDisposable;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.a.subscribe(observer);
        }
    }

    public class x implements SimpleCallable<Observable<R>> {
        public final /* synthetic */ Supplier a;
        public final /* synthetic */ Scheduler b;

        public x(Supplier supplier, Scheduler scheduler) {
            this.a = supplier;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.SimpleCallable, java.util.concurrent.Callable
        public Object call() {
            return Observable.fromSupplier(this.a).subscribeOn(this.b);
        }
    }

    public class y implements PlainFunction<T1, Observable<Object>> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Scheduler b;

        public y(Consumer consumer, Scheduler scheduler) {
            this.a = consumer;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction, io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return Observable.fromSupplier(new k0(this, obj)).subscribeOn(this.b);
        }
    }

    public class z implements PlainFunction<T1, Observable<R>> {
        public final /* synthetic */ Function a;
        public final /* synthetic */ Scheduler b;

        public z(Function function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }

        @Override // hu.akarnokd.rxjava3.functions.PlainFunction, io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return Observable.fromSupplier(new l0(this, obj)).subscribeOn(this.b);
        }
    }

    public AsyncObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable<T> deferFuture(Supplier<? extends Future<? extends ObservableSource<? extends T>>> supplier) {
        return deferFuture(supplier, Schedulers.computation());
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer) {
        return forEachFuture(observableSource, consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Schedulers.computation());
    }

    public static <T> DisposableObservable<T> runAsync(Scheduler scheduler, BiConsumer<? super Observer<? super T>, ? super Disposable> biConsumer) {
        return runAsync(scheduler, PublishSubject.create(), biConsumer);
    }

    public static <T> Observable<T> start(Supplier<? extends T> supplier) {
        return start(supplier, Schedulers.computation());
    }

    public static <T> Observable<T> startFuture(Supplier<? extends Future<? extends T>> supplier) {
        return RxJavaPlugins.onAssembly(new s0(new p(supplier)));
    }

    public static SimpleCallable<Observable<Object>> toAsync(Action action) {
        return toAsync(action, Schedulers.computation());
    }

    public static PlainFunction<Object[], Observable<Object>> toAsyncArray(Consumer<? super Object[]> consumer) {
        return toAsyncArray(consumer, Schedulers.computation());
    }

    public static <R> SimpleCallable<Observable<R>> toAsyncCallable(Callable<? extends R> callable) {
        return toAsyncCallable(callable, Schedulers.computation());
    }

    public static <R> SimpleCallable<Observable<R>> toAsyncSupplier(Supplier<? extends R> supplier) {
        return toAsyncSupplier(supplier, Schedulers.computation());
    }

    public static <T> Observable<T> deferFuture(Supplier<? extends Future<? extends ObservableSource<? extends T>>> supplier, Scheduler scheduler) {
        return Observable.defer(new q(supplier)).subscribeOn(scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return forEachFuture(observableSource, consumer, consumer2, Functions.EMPTY_ACTION, Schedulers.computation());
    }

    public static <T> DisposableObservable<T> runAsync(Scheduler scheduler, Subject<T> subject, BiConsumer<? super Observer<? super T>, ? super Disposable> biConsumer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        sequentialDisposable.replace(scheduler.scheduleDirect(new u(biConsumer, subject, sequentialDisposable)));
        return new w(subject, sequentialDisposable);
    }

    public static <T> Observable<T> start(Supplier<? extends T> supplier, Scheduler scheduler) {
        return (Observable) Observable.fromSupplier(supplier).subscribeOn(scheduler).subscribeWith(AsyncSubject.create());
    }

    public static <T> Observable<T> startFuture(Supplier<? extends Future<? extends T>> supplier, Scheduler scheduler) {
        return startFuture(supplier).subscribeOn(scheduler);
    }

    public static <T1> PlainFunction<T1, Observable<Object>> toAsync(Consumer<? super T1> consumer) {
        return toAsync(consumer, Schedulers.computation());
    }

    public static <R> PlainFunction<Object[], Observable<R>> toAsyncArray(Function<? super Object[], ? extends R> function) {
        return toAsyncArray(function, Schedulers.computation());
    }

    public static <R> SimpleCallable<Observable<R>> toAsyncCallable(Callable<? extends R> callable, Scheduler scheduler) {
        return new v(callable, scheduler);
    }

    public static <R> SimpleCallable<Observable<R>> toAsyncSupplier(Supplier<? extends R> supplier, Scheduler scheduler) {
        return new x(supplier, scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return forEachFuture(observableSource, consumer, consumer2, action, Schedulers.computation());
    }

    public static <T1, R> PlainFunction<T1, Observable<R>> toAsync(Function<? super T1, ? extends R> function) {
        return toAsync(function, Schedulers.computation());
    }

    public static PlainFunction<Object[], Observable<Object>> toAsyncArray(Consumer<? super Object[]> consumer, Scheduler scheduler) {
        return new n(consumer, scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Scheduler scheduler) {
        return forEachFuture(observableSource, consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, scheduler);
    }

    public static <T1, T2> PlainBiFunction<T1, T2, Observable<Object>> toAsync(BiConsumer<? super T1, ? super T2> biConsumer) {
        return toAsync(biConsumer, Schedulers.computation());
    }

    public static <R> PlainFunction<Object[], Observable<R>> toAsyncArray(Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        return new o(function, scheduler);
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Scheduler scheduler) {
        return forEachFuture(observableSource, consumer, consumer2, Functions.EMPTY_ACTION, scheduler);
    }

    public static <T1, T2, R> PlainBiFunction<T1, T2, Observable<R>> toAsync(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return toAsync(biFunction, Schedulers.computation());
    }

    public static <T> Future<Object> forEachFuture(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Scheduler scheduler) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        r0 r0Var = new r0(sequentialDisposable);
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, new r(consumer2, r0Var), new s(action, r0Var), new t());
        sequentialDisposable.lazySet(lambdaObserver);
        Observable.wrap(observableSource).subscribeOn(scheduler).subscribe(lambdaObserver);
        return r0Var;
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

    public static SimpleCallable<Observable<Object>> toAsync(Action action, Scheduler scheduler) {
        return new k(action, scheduler);
    }

    public static <T1> PlainFunction<T1, Observable<Object>> toAsync(Consumer<? super T1> consumer, Scheduler scheduler) {
        return new y(consumer, scheduler);
    }

    public static <T1, R> PlainFunction<T1, Observable<R>> toAsync(Function<? super T1, ? extends R> function, Scheduler scheduler) {
        return new z(function, scheduler);
    }

    public static <T1, T2> PlainBiFunction<T1, T2, Observable<Object>> toAsync(BiConsumer<? super T1, ? super T2> biConsumer, Scheduler scheduler) {
        return new a0(biConsumer, scheduler);
    }

    public static <T1, T2, R> PlainBiFunction<T1, T2, Observable<R>> toAsync(BiFunction<? super T1, ? super T2, ? extends R> biFunction, Scheduler scheduler) {
        return new b0(biFunction, scheduler);
    }

    public static <T1, T2, T3> PlainFunction3<T1, T2, T3, Observable<Object>> toAsync(Consumer3<? super T1, ? super T2, ? super T3> consumer3, Scheduler scheduler) {
        return new c0(consumer3, scheduler);
    }

    public static <T1, T2, T3, R> PlainFunction3<T1, T2, T3, Observable<R>> toAsync(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Scheduler scheduler) {
        return new d0(function3, scheduler);
    }

    public static <T1, T2, T3, T4> PlainFunction4<T1, T2, T3, T4, Observable<Object>> toAsync(Consumer4<? super T1, ? super T2, ? super T3, ? super T4> consumer4, Scheduler scheduler) {
        return new a(consumer4, scheduler);
    }

    public static <T1, T2, T3, T4, R> PlainFunction4<T1, T2, T3, T4, Observable<R>> toAsync(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Scheduler scheduler) {
        return new b(function4, scheduler);
    }

    public static <T1, T2, T3, T4, T5> PlainFunction5<T1, T2, T3, T4, T5, Observable<Object>> toAsync(Consumer5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5> consumer5, Scheduler scheduler) {
        return new c(consumer5, scheduler);
    }

    public static <T1, T2, T3, T4, T5, R> PlainFunction5<T1, T2, T3, T4, T5, Observable<R>> toAsync(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5, Scheduler scheduler) {
        return new d(function5, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<Object>> toAsync(Consumer6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6> consumer6, Scheduler scheduler) {
        return new e(consumer6, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, R> PlainFunction6<T1, T2, T3, T4, T5, T6, Observable<R>> toAsync(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6, Scheduler scheduler) {
        return new f(function6, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<Object>> toAsync(Consumer7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7> consumer7, Scheduler scheduler) {
        return new g(consumer7, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> PlainFunction7<T1, T2, T3, T4, T5, T6, T7, Observable<R>> toAsync(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7, Scheduler scheduler) {
        return new h(function7, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<Object>> toAsync(Consumer8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8> consumer8, Scheduler scheduler) {
        return new i(consumer8, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, Observable<R>> toAsync(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8, Scheduler scheduler) {
        return new j(function8, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<Object>> toAsync(Consumer9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9> consumer9, Scheduler scheduler) {
        return new l(consumer9, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> PlainFunction9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Observable<R>> toAsync(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9, Scheduler scheduler) {
        return new m(function9, scheduler);
    }
}
