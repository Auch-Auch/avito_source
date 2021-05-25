package hu.akarnokd.rxjava2.basetypes;

import a2.b.a.a.a;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.a.b.a2;
import r6.a.a.b.a3;
import r6.a.a.b.b2;
import r6.a.a.b.b3;
import r6.a.a.b.c2;
import r6.a.a.b.c3;
import r6.a.a.b.d2;
import r6.a.a.b.d3;
import r6.a.a.b.e2;
import r6.a.a.b.e3;
import r6.a.a.b.f2;
import r6.a.a.b.g;
import r6.a.a.b.g2;
import r6.a.a.b.h;
import r6.a.a.b.h1;
import r6.a.a.b.h2;
import r6.a.a.b.i1;
import r6.a.a.b.i2;
import r6.a.a.b.j1;
import r6.a.a.b.j2;
import r6.a.a.b.k1;
import r6.a.a.b.k2;
import r6.a.a.b.l1;
import r6.a.a.b.l2;
import r6.a.a.b.m1;
import r6.a.a.b.m2;
import r6.a.a.b.n1;
import r6.a.a.b.n2;
import r6.a.a.b.o1;
import r6.a.a.b.o2;
import r6.a.a.b.p1;
import r6.a.a.b.p2;
import r6.a.a.b.q1;
import r6.a.a.b.q2;
import r6.a.a.b.r1;
import r6.a.a.b.r2;
import r6.a.a.b.s1;
import r6.a.a.b.s2;
import r6.a.a.b.t1;
import r6.a.a.b.t2;
import r6.a.a.b.u1;
import r6.a.a.b.u2;
import r6.a.a.b.v1;
import r6.a.a.b.v2;
import r6.a.a.b.w1;
import r6.a.a.b.w2;
import r6.a.a.b.x1;
import r6.a.a.b.x2;
import r6.a.a.b.y1;
import r6.a.a.b.y2;
import r6.a.a.b.z1;
import r6.a.a.b.z2;
public abstract class Perhaps<T> implements Publisher<T> {
    public static volatile Function<Perhaps, Perhaps> a;

    public static <T> Perhaps<T> amb(Iterable<? extends Perhaps<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return onAssembly(new i1(iterable));
    }

    public static <T> Perhaps<T> ambArray(Perhaps<? extends T>... perhapsArr) {
        ObjectHelper.requireNonNull(perhapsArr, "sources is null");
        return onAssembly(new h1(perhapsArr));
    }

    public static <T> Flowable<T> concat(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.concat(iterable);
    }

    public static <T> Flowable<T> concatArray(Perhaps<? extends T>... perhapsArr) {
        return Flowable.concatArray(perhapsArr);
    }

    public static <T> Flowable<T> concatArrayDelayError(Perhaps<? extends T>... perhapsArr) {
        return Flowable.concatArrayDelayError(perhapsArr);
    }

    public static <T> Flowable<T> concatDelayError(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.concatDelayError(iterable);
    }

    public static <T> Perhaps<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        ObjectHelper.requireNonNull(maybeOnSubscribe, "onCreate is null");
        return onAssembly(new l1(maybeOnSubscribe));
    }

    public static <T> Perhaps<T> defer(Callable<? extends Perhaps<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return onAssembly(new n1(callable));
    }

    public static <T> Perhaps<T> empty() {
        return onAssembly(s1.b);
    }

    public static <T> Perhaps<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return onAssembly(new t1(th));
    }

    public static <T> Perhaps<T> fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "action is null");
        return onAssembly(new z1(action));
    }

    public static <T> Perhaps<T> fromCallable(Callable<T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return onAssembly(new a2(callable));
    }

    public static <T> Perhaps<T> fromCompletable(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        return onAssembly(new b2(completableSource));
    }

    public static <T> Perhaps<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return onAssembly(new c2(future, 0, null));
    }

    public static <T> Perhaps<T> fromMaybe(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "source is null");
        return onAssembly(new d2(maybeSource));
    }

    public static <T> Perhaps<T> fromPublisher(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "source is null");
        return onAssembly(new e2(publisher));
    }

    public static <T> Perhaps<T> fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
        return onAssembly(new f2(singleSource));
    }

    public static <T> Function<Perhaps<T>, Perhaps<T>> getOnAssemblyHandler() {
        return a;
    }

    public static <T> Perhaps<T> just(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return onAssembly(new h2(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.merge(iterable);
    }

    public static <T> Flowable<T> mergeArray(Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArray(perhapsArr);
    }

    public static <T> Flowable<T> mergeArrayDelayError(Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArrayDelayError(perhapsArr);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.mergeDelayError(iterable);
    }

    public static <T> Perhaps<T> never() {
        return onAssembly(l2.b);
    }

    public static <T> Perhaps<T> onAssembly(Perhaps<T> perhaps) {
        Function<Perhaps, Perhaps> function = a;
        if (function == null) {
            return perhaps;
        }
        try {
            return function.apply(perhaps);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void setOnAssemblyHandler(Function<Perhaps<T>, Perhaps<T>> function) {
        a = function;
    }

    public static Perhaps<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static <T, R> Perhaps<T> using(Callable<R> callable, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, R> Perhaps<R> zip(Iterable<? extends Perhaps<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "zipper is null");
        return onAssembly(new e3(iterable, function));
    }

    public static <T, R> Perhaps<R> zipArray(Function<? super Object[], ? extends R> function, Perhaps<? extends T>... perhapsArr) {
        ObjectHelper.requireNonNull(perhapsArr, "sources is null");
        ObjectHelper.requireNonNull(function, "zipper is null");
        return onAssembly(new d3(perhapsArr, function));
    }

    public final Perhaps<T> ambWith(Perhaps<? extends T> perhaps) {
        return ambArray(this, perhaps);
    }

    public final Perhaps<T> andThen(Nono nono) {
        ObjectHelper.requireNonNull(nono, "other is null");
        return onAssembly(new j1(this, nono));
    }

    public final T blockingGet() {
        g gVar = new g();
        subscribe(gVar);
        return (T) gVar.b();
    }

    public final void blockingSubscribe() {
        blockingSubscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Perhaps<T> cache() {
        return onAssembly(new k1(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.functions.Function<? super hu.akarnokd.rxjava2.basetypes.Perhaps<T>, ? extends hu.akarnokd.rxjava2.basetypes.Perhaps<R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Perhaps<R> compose(Function<? super Perhaps<T>, ? extends Perhaps<R>> function) {
        return (Perhaps) to(function);
    }

    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return Flowable.concat(this, publisher);
    }

    public final Perhaps<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return onAssembly(new m1(this, t));
    }

    public final Perhaps<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    public final Perhaps<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(timer(j, timeUnit));
    }

    public final Perhaps<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Perhaps<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return onAssembly(new q1(this, action));
    }

    public final Perhaps<T> doOnCancel(Action action) {
        ObjectHelper.requireNonNull(action, "onCancel is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnComplete(Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Perhaps<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnRequest(LongConsumer longConsumer) {
        ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    public final Perhaps<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return onAssembly(new v1(this, predicate));
    }

    public final <R> Perhaps<R> flatMap(Function<? super T, ? extends Perhaps<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return onAssembly(new w1(this, function));
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new x1(this, function));
    }

    public final Perhaps<T> hide() {
        return onAssembly(new g2(this));
    }

    public final Nono ignoreElement() {
        return Nono.fromPublisher(this);
    }

    public final <R> Perhaps<R> lift(Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        ObjectHelper.requireNonNull(function, "onLift is null");
        return onAssembly(new i2(this, function));
    }

    public final <R> Perhaps<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return onAssembly(new j2(this, function));
    }

    public final Perhaps<T> mapError(Function<? super Throwable, ? extends Throwable> function) {
        ObjectHelper.requireNonNull(function, "errorMapper is null");
        return onAssembly(new k2(this, function));
    }

    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return Flowable.merge(this, publisher);
    }

    public final Perhaps<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new m2(this, scheduler));
    }

    public final Perhaps<T> onErrorComplete() {
        return onAssembly(new p2(this, null));
    }

    public final Perhaps<T> onErrorResumeNext(Function<? super Throwable, ? extends Perhaps<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "fallbackSupplier is null");
        return onAssembly(new n2(this, function));
    }

    public final Perhaps<T> onErrorResumeWith(Perhaps<? extends T> perhaps) {
        ObjectHelper.requireNonNull(perhaps, "fallback is null");
        return onAssembly(new o2(this, perhaps));
    }

    public final Perhaps<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return onAssembly(new p2(this, t));
    }

    public final Flowable<T> repeat() {
        return Flowable.fromPublisher(this).repeat();
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return Flowable.fromPublisher(this).repeatWhen(function);
    }

    public final Perhaps<T> retry() {
        return onAssembly(new q2(this, Long.MAX_VALUE));
    }

    public final Perhaps<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return onAssembly(new r2(this, function));
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super T> subscriber) {
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

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    public final Perhaps<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new t2(this, scheduler));
    }

    public final <E extends Subscriber<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Perhaps<T> switchIfEmpty(Perhaps<? extends T> perhaps) {
        ObjectHelper.requireNonNull(perhaps, "other is null");
        return onAssembly(new u2(this, perhaps));
    }

    public final Perhaps<T> takeUntil(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new v2(this, publisher));
    }

    public final TestSubscriber<T> test() {
        return test(Long.MAX_VALUE, false);
    }

    public final Perhaps<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, Schedulers.computation());
    }

    public final <R> R to(Function<? super Perhaps<T>, R> function) {
        try {
            return function.apply(this);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public final Flowable<T> toFlowable() {
        return RxJavaPlugins.onAssembly(new y2(this));
    }

    public final Future<T> toFuture() {
        h hVar = new h();
        subscribe(hVar);
        return hVar;
    }

    public final Maybe<T> toMaybe() {
        return RxJavaPlugins.onAssembly(new z2(this));
    }

    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly(new a3(this));
    }

    public final Perhaps<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new b3(this, scheduler));
    }

    public final <U, R> Perhaps<R> zipWith(Perhaps<? extends U> perhaps, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(perhaps, "other is null");
        ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return zipArray(Functions.toFunction(biFunction), this, perhaps);
    }

    public static <T> Flowable<T> concat(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.concat(publisher);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.concatDelayError(publisher);
    }

    public static <T> Flowable<T> merge(Iterable<? extends Perhaps<? extends T>> iterable, int i) {
        return Flowable.merge(iterable, i);
    }

    public static <T> Flowable<T> mergeArray(int i, Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArray(i, 1, perhapsArr);
    }

    public static <T> Flowable<T> mergeArrayDelayError(int i, Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArrayDelayError(i, 1, perhapsArr);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Perhaps<? extends T>> iterable, int i) {
        return Flowable.mergeDelayError(iterable, i);
    }

    public static Perhaps<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new x2(j, timeUnit, scheduler));
    }

    public static <T, R> Perhaps<T> using(Callable<R> callable, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return onAssembly(new c3(callable, function, consumer, z));
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        blockingSubscribe(consumer, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Perhaps<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(timer(j, timeUnit, scheduler));
    }

    public final Perhaps<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final Flowable<T> repeat(long j) {
        return Flowable.fromPublisher(this).repeat(j);
    }

    public final Perhaps<T> retry(long j) {
        if (j >= 0) {
            return onAssembly(new q2(this, j));
        }
        throw new IllegalArgumentException(a.T2("times >= 0 required but it was ", j));
    }

    public final TestSubscriber<T> test(boolean z) {
        return test(Long.MAX_VALUE, z);
    }

    public final Perhaps<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    public static <T> Flowable<T> concat(Publisher<? extends Perhaps<? extends T>> publisher, int i) {
        return Flowable.concat(publisher, i);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Perhaps<? extends T>> publisher, int i) {
        return Flowable.concatDelayError(publisher, i, false);
    }

    public static <T> Perhaps<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return onAssembly(new u1(callable));
    }

    public static <T> Perhaps<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return onAssembly(new c2(future, j, timeUnit));
    }

    public static <T> Flowable<T> merge(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.merge(publisher);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.mergeDelayError(publisher);
    }

    public final Flowable<T> andThen(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return Flowable.concat(this, publisher);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        blockingSubscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    public final Perhaps<T> delay(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new o1(this, publisher));
    }

    public final Perhaps<T> delaySubscription(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new p1(this, publisher));
    }

    public final <R> Perhaps<R> flatMap(Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Callable<? extends Perhaps<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onSuccessMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteMapper is null");
        return onAssembly(new y1(this, function, function2, callable));
    }

    public final Flowable<T> repeat(BooleanSupplier booleanSupplier) {
        return Flowable.fromPublisher(this).repeatUntil(booleanSupplier);
    }

    public final TestSubscriber<T> test(long j) {
        return test(j, false);
    }

    public final Perhaps<T> timeout(long j, TimeUnit timeUnit, Perhaps<? extends T> perhaps) {
        return timeout(j, timeUnit, Schedulers.computation(), perhaps);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Perhaps<? extends T>> publisher, int i, boolean z) {
        return Flowable.concatDelayError(publisher, i, z);
    }

    public static <T> Flowable<T> merge(Publisher<? extends Perhaps<? extends T>> publisher, int i) {
        return Flowable.merge(publisher, i);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Perhaps<? extends T>> publisher, int i) {
        return Flowable.mergeDelayError(publisher, i);
    }

    public final T blockingGet(long j, TimeUnit timeUnit) {
        g gVar = new g();
        subscribe(gVar);
        return (T) gVar.c(j, timeUnit);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        g gVar = new g();
        subscribe(gVar);
        gVar.a(consumer, consumer2, action);
    }

    public final Perhaps<T> retry(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return onAssembly(new s2(this, predicate));
    }

    public final TestSubscriber<T> test(long j, boolean z) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j);
        if (z) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final Perhaps<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Perhaps<? extends T> perhaps) {
        return timeout(timer(j, timeUnit, scheduler), perhaps);
    }

    public final Perhaps<T> timeout(Publisher<?> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return onAssembly(new w2(this, publisher, null));
    }

    public final Perhaps<T> timeout(Publisher<?> publisher, Perhaps<? extends T> perhaps) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.requireNonNull(perhaps, "fallback is null");
        return onAssembly(new w2(this, publisher, perhaps));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, Functions.REQUEST_MAX);
        subscribe(lambdaSubscriber);
        return lambdaSubscriber;
    }
}
