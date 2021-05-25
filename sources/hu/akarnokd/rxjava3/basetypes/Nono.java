package hu.akarnokd.rxjava3.basetypes;

import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.b.b.a0;
import r6.a.b.b.a1;
import r6.a.b.b.b0;
import r6.a.b.b.b1;
import r6.a.b.b.c0;
import r6.a.b.b.c1;
import r6.a.b.b.d0;
import r6.a.b.b.d1;
import r6.a.b.b.e0;
import r6.a.b.b.e1;
import r6.a.b.b.f0;
import r6.a.b.b.f1;
import r6.a.b.b.g0;
import r6.a.b.b.g1;
import r6.a.b.b.h;
import r6.a.b.b.h0;
import r6.a.b.b.i;
import r6.a.b.b.i0;
import r6.a.b.b.j;
import r6.a.b.b.j0;
import r6.a.b.b.k;
import r6.a.b.b.k0;
import r6.a.b.b.l;
import r6.a.b.b.l0;
import r6.a.b.b.m;
import r6.a.b.b.m0;
import r6.a.b.b.n;
import r6.a.b.b.n0;
import r6.a.b.b.o;
import r6.a.b.b.o0;
import r6.a.b.b.p;
import r6.a.b.b.p0;
import r6.a.b.b.q;
import r6.a.b.b.q0;
import r6.a.b.b.r;
import r6.a.b.b.r0;
import r6.a.b.b.s;
import r6.a.b.b.s0;
import r6.a.b.b.t;
import r6.a.b.b.t0;
import r6.a.b.b.u;
import r6.a.b.b.u0;
import r6.a.b.b.v;
import r6.a.b.b.v0;
import r6.a.b.b.w;
import r6.a.b.b.w0;
import r6.a.b.b.x;
import r6.a.b.b.x0;
import r6.a.b.b.y;
import r6.a.b.b.y0;
import r6.a.b.b.z;
import r6.a.b.b.z0;
public abstract class Nono implements Publisher<Void> {
    public static volatile Function<Nono, Nono> a;

    public static Nono amb(Iterable<? extends Nono> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return onAssembly(new j(iterable));
    }

    public static Nono ambArray(Nono... nonoArr) {
        Objects.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new i(nonoArr));
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    public static Nono complete() {
        return onAssembly(o.b);
    }

    public static Nono concat(Iterable<? extends Nono> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return onAssembly(new r(iterable, false));
    }

    public static Nono concatArray(Nono... nonoArr) {
        Objects.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new q(nonoArr, false));
    }

    public static Nono concatArrayDelayError(Nono... nonoArr) {
        Objects.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new q(nonoArr, true));
    }

    public static Nono concatDelayError(Iterable<? extends Nono> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return onAssembly(new r(iterable, true));
    }

    public static Nono create(CompletableOnSubscribe completableOnSubscribe) {
        Objects.requireNonNull(completableOnSubscribe, "onCreate is null");
        return onAssembly(new s(completableOnSubscribe));
    }

    public static Nono defer(Supplier<? extends Nono> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return onAssembly(new t(supplier));
    }

    public static Nono error(Throwable th) {
        Objects.requireNonNull(th, "ex is null");
        return onAssembly(new y(th));
    }

    public static Nono fromAction(Action action) {
        Objects.requireNonNull(action, "action is null");
        return onAssembly(new b0(action));
    }

    public static Nono fromCompletable(CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "source is null");
        return onAssembly(new c0(completableSource));
    }

    public static Nono fromFuture(Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return onAssembly(new d0(future, 0, TimeUnit.NANOSECONDS));
    }

    public static Nono fromMaybe(MaybeSource<?> maybeSource) {
        Objects.requireNonNull(maybeSource, "source is null");
        return onAssembly(new e0(maybeSource));
    }

    public static Nono fromObservable(ObservableSource<?> observableSource) {
        Objects.requireNonNull(observableSource, "source is null");
        return onAssembly(new f0(observableSource));
    }

    public static Nono fromPublisher(Publisher<?> publisher) {
        if (publisher instanceof Nono) {
            return (Nono) publisher;
        }
        Objects.requireNonNull(publisher, "source is null");
        return onAssembly(new g0(publisher));
    }

    public static Nono fromSingle(SingleSource<?> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return onAssembly(new h0(singleSource));
    }

    public static Function<Nono, Nono> getOnAssemblyHandler() {
        return a;
    }

    public static Nono merge(Iterable<? extends Nono> iterable) {
        return merge(iterable, Integer.MAX_VALUE);
    }

    public static Nono mergeArray(Nono... nonoArr) {
        return mergeArray(Integer.MAX_VALUE, nonoArr);
    }

    public static Nono mergeArrayDelayError(Nono... nonoArr) {
        return mergeArrayDelayError(bufferSize(), nonoArr);
    }

    public static Nono mergeDelayError(Iterable<? extends Nono> iterable) {
        return mergeDelayError(iterable, Integer.MAX_VALUE);
    }

    public static Nono never() {
        return onAssembly(p0.b);
    }

    public static Nono onAssembly(Nono nono) {
        Function<Nono, Nono> function = a;
        if (function == null) {
            return nono;
        }
        try {
            Nono apply = function.apply(nono);
            Objects.requireNonNull(apply, "The onAssemblyHandler returned a null Nono");
            return apply;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static void setOnAssemblyHandler(Function<Nono, Nono> function) {
        a = function;
    }

    @SchedulerSupport("io.reactivex:computation")
    public static Nono timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static <R> Nono using(Supplier<R> supplier, Function<? super R, ? extends Nono> function, Consumer<? super R> consumer) {
        return using(supplier, function, consumer, true);
    }

    public final <T> Flowable<T> andThen(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new l(this, publisher));
    }

    @SchedulerSupport("none")
    public final Throwable blockingAwait() {
        if (this instanceof Supplier) {
            try {
                ((Supplier) this).get();
                return null;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                return th;
            }
        } else {
            m mVar = new m();
            subscribe(mVar);
            if (mVar.getCount() != 0) {
                try {
                    mVar.await();
                } catch (InterruptedException e) {
                    mVar.a();
                    return e;
                }
            }
            return mVar.a;
        }
    }

    public final void blockingSubscribe() {
        blockingSubscribe(Functions.EMPTY_ACTION, Functions.ERROR_CONSUMER);
    }

    public final Nono cache() {
        return onAssembly(new n(this));
    }

    public final Nono compose(Function<? super Nono, ? extends Nono> function) {
        return (Nono) to(function);
    }

    @SchedulerSupport("io.reactivex:computation")
    public final Nono delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    public final Nono delaySubscription(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new v(this, publisher));
    }

    public final Nono doAfterTerminate(Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Nono doFinally(Action action) {
        Objects.requireNonNull(action, "action is null");
        return onAssembly(new w(this, action));
    }

    public final Nono doOnCancel(Action action) {
        Objects.requireNonNull(action, "action is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Nono doOnComplete(Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Nono doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Nono doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    public final Nono doOnSubscribe(Consumer<? super Subscription> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final <T> Flowable<T> flatMap(Function<? super Throwable, ? extends Publisher<? extends T>> function, Supplier<? extends Publisher<? extends T>> supplier) {
        Objects.requireNonNull(function, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteMapper is null");
        return RxJavaPlugins.onAssembly(new a0(this, function, supplier));
    }

    public final Nono hide() {
        return onAssembly(new i0(this));
    }

    public final Nono lift(Function<Subscriber<? super Void>, Subscriber<? super Void>> function) {
        Objects.requireNonNull(function, "lifter is null");
        return onAssembly(new k0(this, function));
    }

    public final Nono mapError(Function<? super Throwable, ? extends Throwable> function) {
        Objects.requireNonNull(function, "mapper is null");
        return onAssembly(new l0(this, function));
    }

    public final Nono observeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new q0(this, scheduler));
    }

    public final Nono onErrorComplete() {
        return onAssembly(new r0(this));
    }

    public final Nono onErrorResumeNext(Function<? super Throwable, ? extends Nono> function) {
        Objects.requireNonNull(function, "errorHandler is null");
        return onAssembly(new s0(this, function));
    }

    public final Nono repeat() {
        return onAssembly(new t0(this, Long.MAX_VALUE));
    }

    public final Nono repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return onAssembly(new v0(this, function));
    }

    public final Nono retry() {
        return onAssembly(new w0(this, Long.MAX_VALUE));
    }

    public final Nono retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return onAssembly(new x0(this, function));
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super Void> subscriber) {
        Objects.requireNonNull(subscriber, "s is null");
        try {
            subscribeActual(subscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException();
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(Subscriber<? super Void> subscriber);

    public final Nono subscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new z0(this, scheduler));
    }

    @SchedulerSupport("none")
    public final <T, E extends Subscriber<T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Nono takeUntil(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new a1(this, publisher));
    }

    @SchedulerSupport("none")
    public final TestSubscriber<Void> test() {
        TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final Nono timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, Schedulers.computation());
    }

    public final <R> R to(Function<? super Nono, R> function) {
        try {
            return function.apply(this);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public final Completable toCompletable() {
        return Completable.fromPublisher(this);
    }

    public final <T> Flowable<T> toFlowable() {
        return Flowable.fromPublisher(this);
    }

    public final Future<Void> toFuture() {
        h hVar = new h();
        subscribe(hVar);
        return hVar;
    }

    public final <T> Maybe<T> toMaybe() {
        return RxJavaPlugins.onAssembly(new d1(this));
    }

    public final <T> Observable<T> toObservable() {
        return Observable.fromPublisher(this);
    }

    public final <T> Perhaps<T> toPerhaps() {
        return Perhaps.onAssembly(new e1(this));
    }

    public final Nono unsubscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new f1(this, scheduler));
    }

    public static Nono merge(Iterable<? extends Nono> iterable, int i) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new o0(iterable, false, i));
    }

    public static Nono mergeArray(int i, Nono... nonoArr) {
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        Objects.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new n0(nonoArr, false, i));
    }

    public static Nono mergeArrayDelayError(int i, Nono... nonoArr) {
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        Objects.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new n0(nonoArr, true, i));
    }

    public static Nono mergeDelayError(Iterable<? extends Nono> iterable, int i) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new o0(iterable, true, i));
    }

    @SchedulerSupport("custom")
    public static Nono timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new c1(j, timeUnit, scheduler));
    }

    public static <R> Nono using(Supplier<R> supplier, Function<? super R, ? extends Nono> function, Consumer<? super R> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "disposer is null");
        return onAssembly(new g1(supplier, function, consumer, z));
    }

    public final void blockingSubscribe(Action action) {
        blockingSubscribe(action, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("custom")
    public final Nono delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new u(this, j, timeUnit, scheduler));
    }

    public final Nono repeat(long j) {
        return onAssembly(new t0(this, j));
    }

    public final Nono retry(long j) {
        return onAssembly(new w0(this, j));
    }

    public final Nono timeout(long j, TimeUnit timeUnit, Nono nono) {
        return timeout(j, timeUnit, Schedulers.computation(), nono);
    }

    public static Nono concat(Publisher<? extends Nono> publisher) {
        return concat(publisher, 2);
    }

    public static Nono concatDelayError(Publisher<? extends Nono> publisher) {
        return concatDelayError(publisher, 2, true);
    }

    public static Nono error(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "errorSupplier is null");
        return onAssembly(new z(supplier));
    }

    public static Nono fromFuture(Future<?> future, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return onAssembly(new d0(future, j, timeUnit));
    }

    public final Nono andThen(Nono nono) {
        Objects.requireNonNull(nono, "other is null");
        return onAssembly(new k(this, nono));
    }

    public final void blockingSubscribe(Action action, Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(consumer, "onError is null");
        Throwable blockingAwait = blockingAwait();
        if (blockingAwait != null) {
            try {
                consumer.accept(blockingAwait);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(blockingAwait, th));
            }
        } else {
            try {
                action.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public final Nono delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(timer(j, timeUnit));
    }

    public final Nono repeat(BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return onAssembly(new u0(this, booleanSupplier));
    }

    public final Nono retry(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return onAssembly(new y0(this, predicate));
    }

    @SchedulerSupport("none")
    public final TestSubscriber<Void> test(boolean z) {
        TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        if (z) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final Nono timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    public static Nono concat(Publisher<? extends Nono> publisher, int i) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return onAssembly(new p(publisher, i, ErrorMode.IMMEDIATE));
    }

    public static Nono concatDelayError(Publisher<? extends Nono> publisher, int i, boolean z) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return onAssembly(new p(publisher, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final Nono delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final Nono timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Nono nono) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        Objects.requireNonNull(nono, "fallback is null");
        return timeout(timer(j, timeUnit, scheduler), nono);
    }

    public static Nono merge(Publisher<? extends Nono> publisher) {
        return merge(publisher, Integer.MAX_VALUE);
    }

    public static Nono mergeDelayError(Publisher<? extends Nono> publisher) {
        return mergeDelayError(publisher, Integer.MAX_VALUE);
    }

    public static Nono merge(Publisher<? extends Nono> publisher, int i) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new m0(publisher, false, i));
    }

    public static Nono mergeDelayError(Publisher<? extends Nono> publisher, int i) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new m0(publisher, true, i));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.EMPTY_ACTION, Functions.ERROR_CONSUMER);
    }

    public final Nono timeout(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new b1(this, publisher, null));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Action action) {
        return subscribe(action, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("none")
    public final Throwable blockingAwait(long j, TimeUnit timeUnit) {
        if (this instanceof Supplier) {
            try {
                ((Supplier) this).get();
                return null;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                return th;
            }
        } else {
            Objects.requireNonNull(timeUnit, "unit is null");
            m mVar = new m();
            subscribe(mVar);
            if (mVar.getCount() != 0) {
                try {
                    if (!mVar.await(j, timeUnit)) {
                        mVar.a();
                        return new TimeoutException();
                    }
                } catch (InterruptedException e) {
                    mVar.a();
                    return e;
                }
            }
            return mVar.a;
        }
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(consumer, "onError is null");
        j0 j0Var = new j0(action, consumer);
        subscribe(j0Var);
        return j0Var;
    }

    public final Nono timeout(Publisher<?> publisher, Nono nono) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(nono, "fallback is null");
        return onAssembly(new b1(this, publisher, nono));
    }
}
