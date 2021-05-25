package hu.akarnokd.rxjava2.basetypes;

import io.reactivex.Completable;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.a.b.a0;
import r6.a.a.b.a1;
import r6.a.a.b.b0;
import r6.a.a.b.b1;
import r6.a.a.b.c0;
import r6.a.a.b.c1;
import r6.a.a.b.d0;
import r6.a.a.b.d1;
import r6.a.a.b.e0;
import r6.a.a.b.e1;
import r6.a.a.b.f0;
import r6.a.a.b.f1;
import r6.a.a.b.g0;
import r6.a.a.b.g1;
import r6.a.a.b.h;
import r6.a.a.b.h0;
import r6.a.a.b.i;
import r6.a.a.b.i0;
import r6.a.a.b.j;
import r6.a.a.b.j0;
import r6.a.a.b.k;
import r6.a.a.b.k0;
import r6.a.a.b.l;
import r6.a.a.b.l0;
import r6.a.a.b.m;
import r6.a.a.b.m0;
import r6.a.a.b.n;
import r6.a.a.b.n0;
import r6.a.a.b.o;
import r6.a.a.b.o0;
import r6.a.a.b.p;
import r6.a.a.b.p0;
import r6.a.a.b.q;
import r6.a.a.b.q0;
import r6.a.a.b.r;
import r6.a.a.b.r0;
import r6.a.a.b.s;
import r6.a.a.b.s0;
import r6.a.a.b.t;
import r6.a.a.b.t0;
import r6.a.a.b.u;
import r6.a.a.b.u0;
import r6.a.a.b.v;
import r6.a.a.b.v0;
import r6.a.a.b.w;
import r6.a.a.b.w0;
import r6.a.a.b.x;
import r6.a.a.b.x0;
import r6.a.a.b.y;
import r6.a.a.b.y0;
import r6.a.a.b.z;
import r6.a.a.b.z0;
public abstract class Nono implements Publisher<Void> {
    public static volatile Function<Nono, Nono> a;

    public static Nono amb(Iterable<? extends Nono> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return onAssembly(new j(iterable));
    }

    public static Nono ambArray(Nono... nonoArr) {
        ObjectHelper.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new i(nonoArr));
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    public static Nono complete() {
        return onAssembly(o.b);
    }

    public static Nono concat(Iterable<? extends Nono> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return onAssembly(new r(iterable, false));
    }

    public static Nono concatArray(Nono... nonoArr) {
        ObjectHelper.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new q(nonoArr, false));
    }

    public static Nono concatArrayDelayError(Nono... nonoArr) {
        ObjectHelper.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new q(nonoArr, true));
    }

    public static Nono concatDelayError(Iterable<? extends Nono> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return onAssembly(new r(iterable, true));
    }

    public static Nono create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.requireNonNull(completableOnSubscribe, "onCreate is null");
        return onAssembly(new s(completableOnSubscribe));
    }

    public static Nono defer(Callable<? extends Nono> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return onAssembly(new t(callable));
    }

    public static Nono error(Throwable th) {
        ObjectHelper.requireNonNull(th, "ex is null");
        return onAssembly(new y(th));
    }

    public static Nono fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "action is null");
        return onAssembly(new b0(action));
    }

    public static Nono fromCompletable(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        return onAssembly(new c0(completableSource));
    }

    public static Nono fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return onAssembly(new d0(future, 0, TimeUnit.NANOSECONDS));
    }

    public static Nono fromMaybe(MaybeSource<?> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "source is null");
        return onAssembly(new e0(maybeSource));
    }

    public static Nono fromObservable(ObservableSource<?> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        return onAssembly(new f0(observableSource));
    }

    public static Nono fromPublisher(Publisher<?> publisher) {
        if (publisher instanceof Nono) {
            return (Nono) publisher;
        }
        ObjectHelper.requireNonNull(publisher, "source is null");
        return onAssembly(new g0(publisher));
    }

    public static Nono fromSingle(SingleSource<?> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
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
            return (Nono) ObjectHelper.requireNonNull(function.apply(nono), "The onAssemblyHandler returned a null Nono");
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

    public static <R> Nono using(Callable<R> callable, Function<? super R, ? extends Nono> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    public final <T> Flowable<T> andThen(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new l(this, publisher));
    }

    @SchedulerSupport("none")
    public final Throwable blockingAwait() {
        if (this instanceof Callable) {
            try {
                ((Callable) this).call();
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
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new v(this, publisher));
    }

    public final Nono doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Nono doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "action is null");
        return onAssembly(new w(this, action));
    }

    public final Nono doOnCancel(Action action) {
        ObjectHelper.requireNonNull(action, "action is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Nono doOnComplete(Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Nono doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Nono doOnRequest(LongConsumer longConsumer) {
        ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    public final Nono doOnSubscribe(Consumer<? super Subscription> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new x(this, emptyConsumer, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final <T> Flowable<T> flatMap(Function<? super Throwable, ? extends Publisher<? extends T>> function, Callable<? extends Publisher<? extends T>> callable) {
        ObjectHelper.requireNonNull(function, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteMapper is null");
        return RxJavaPlugins.onAssembly(new a0(this, function, callable));
    }

    public final Nono hide() {
        return onAssembly(new i0(this));
    }

    public final Nono lift(Function<Subscriber<? super Void>, Subscriber<? super Void>> function) {
        ObjectHelper.requireNonNull(function, "lifter is null");
        return onAssembly(new k0(this, function));
    }

    public final Nono mapError(Function<? super Throwable, ? extends Throwable> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return onAssembly(new l0(this, function));
    }

    public final Nono observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new q0(this, scheduler));
    }

    public final Nono onErrorComplete() {
        return onAssembly(new r0(this));
    }

    public final Nono onErrorResumeNext(Function<? super Throwable, ? extends Nono> function) {
        ObjectHelper.requireNonNull(function, "errorHandler is null");
        return onAssembly(new s0(this, function));
    }

    public final Nono repeat() {
        return onAssembly(new t0(this, Long.MAX_VALUE));
    }

    public final Nono repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return onAssembly(new v0(this, function));
    }

    public final Nono retry() {
        return onAssembly(new w0(this, Long.MAX_VALUE));
    }

    public final Nono retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return onAssembly(new x0(this, function));
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super Void> subscriber) {
        ObjectHelper.requireNonNull(subscriber, "s is null");
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
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new z0(this, scheduler));
    }

    @SchedulerSupport("none")
    public final <T, E extends Subscriber<T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Nono takeUntil(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
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
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new f1(this, scheduler));
    }

    public static Nono merge(Iterable<? extends Nono> iterable, int i) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new o0(iterable, false, i));
    }

    public static Nono mergeArray(int i, Nono... nonoArr) {
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new n0(nonoArr, false, i));
    }

    public static Nono mergeArrayDelayError(int i, Nono... nonoArr) {
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.requireNonNull(nonoArr, "sources is null");
        return onAssembly(new n0(nonoArr, true, i));
    }

    public static Nono mergeDelayError(Iterable<? extends Nono> iterable, int i) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new o0(iterable, true, i));
    }

    @SchedulerSupport("custom")
    public static Nono timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new c1(j, timeUnit, scheduler));
    }

    public static <R> Nono using(Callable<R> callable, Function<? super R, ? extends Nono> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return onAssembly(new g1(callable, function, consumer, z));
    }

    public final void blockingSubscribe(Action action) {
        blockingSubscribe(action, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("custom")
    public final Nono delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
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

    public static Nono error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return onAssembly(new z(callable));
    }

    public static Nono fromFuture(Future<?> future, long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return onAssembly(new d0(future, j, timeUnit));
    }

    public final Nono andThen(Nono nono) {
        ObjectHelper.requireNonNull(nono, "other is null");
        return onAssembly(new k(this, nono));
    }

    public final void blockingSubscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
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
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return onAssembly(new u0(this, booleanSupplier));
    }

    public final Nono retry(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
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
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return onAssembly(new p(publisher, i, ErrorMode.IMMEDIATE));
    }

    public static Nono concatDelayError(Publisher<? extends Nono> publisher, int i, boolean z) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return onAssembly(new p(publisher, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final Nono delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final Nono timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Nono nono) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(nono, "fallback is null");
        return timeout(timer(j, timeUnit, scheduler), nono);
    }

    public static Nono merge(Publisher<? extends Nono> publisher) {
        return merge(publisher, Integer.MAX_VALUE);
    }

    public static Nono mergeDelayError(Publisher<? extends Nono> publisher) {
        return mergeDelayError(publisher, Integer.MAX_VALUE);
    }

    public static Nono merge(Publisher<? extends Nono> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new m0(publisher, false, i));
    }

    public static Nono mergeDelayError(Publisher<? extends Nono> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return onAssembly(new m0(publisher, true, i));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.EMPTY_ACTION, Functions.ERROR_CONSUMER);
    }

    public final Nono timeout(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new b1(this, publisher, null));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Action action) {
        return subscribe(action, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("none")
    public final Throwable blockingAwait(long j, TimeUnit timeUnit) {
        if (this instanceof Callable) {
            try {
                ((Callable) this).call();
                return null;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                return th;
            }
        } else {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
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
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        j0 j0Var = new j0(action, consumer);
        subscribe(j0Var);
        return j0Var;
    }

    public final Nono timeout(Publisher<?> publisher, Nono nono) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.requireNonNull(nono, "fallback is null");
        return onAssembly(new b1(this, publisher, nono));
    }
}
