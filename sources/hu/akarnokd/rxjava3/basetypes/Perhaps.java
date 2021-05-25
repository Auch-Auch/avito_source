package hu.akarnokd.rxjava3.basetypes;

import a2.b.a.a.a;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.b.b.a2;
import r6.a.b.b.a3;
import r6.a.b.b.b2;
import r6.a.b.b.b3;
import r6.a.b.b.c2;
import r6.a.b.b.c3;
import r6.a.b.b.d2;
import r6.a.b.b.d3;
import r6.a.b.b.e2;
import r6.a.b.b.e3;
import r6.a.b.b.f2;
import r6.a.b.b.g;
import r6.a.b.b.g2;
import r6.a.b.b.h;
import r6.a.b.b.h1;
import r6.a.b.b.h2;
import r6.a.b.b.i1;
import r6.a.b.b.i2;
import r6.a.b.b.j1;
import r6.a.b.b.j2;
import r6.a.b.b.k1;
import r6.a.b.b.k2;
import r6.a.b.b.l1;
import r6.a.b.b.l2;
import r6.a.b.b.m1;
import r6.a.b.b.m2;
import r6.a.b.b.n1;
import r6.a.b.b.n2;
import r6.a.b.b.o1;
import r6.a.b.b.o2;
import r6.a.b.b.p1;
import r6.a.b.b.p2;
import r6.a.b.b.q1;
import r6.a.b.b.q2;
import r6.a.b.b.r1;
import r6.a.b.b.r2;
import r6.a.b.b.s1;
import r6.a.b.b.s2;
import r6.a.b.b.t1;
import r6.a.b.b.t2;
import r6.a.b.b.u1;
import r6.a.b.b.u2;
import r6.a.b.b.v1;
import r6.a.b.b.v2;
import r6.a.b.b.w1;
import r6.a.b.b.w2;
import r6.a.b.b.x1;
import r6.a.b.b.x2;
import r6.a.b.b.y1;
import r6.a.b.b.y2;
import r6.a.b.b.z1;
import r6.a.b.b.z2;
public abstract class Perhaps<T> implements Publisher<T> {
    public static volatile Function<Perhaps, Perhaps> a;

    public static <T> Perhaps<T> amb(Iterable<? extends Perhaps<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return onAssembly(new i1(iterable));
    }

    @SafeVarargs
    public static <T> Perhaps<T> ambArray(Perhaps<? extends T>... perhapsArr) {
        Objects.requireNonNull(perhapsArr, "sources is null");
        return onAssembly(new h1(perhapsArr));
    }

    public static <T> Flowable<T> concat(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.concat(iterable);
    }

    @SafeVarargs
    public static <T> Flowable<T> concatArray(Perhaps<? extends T>... perhapsArr) {
        return Flowable.concatArray(perhapsArr);
    }

    @SafeVarargs
    public static <T> Flowable<T> concatArrayDelayError(Perhaps<? extends T>... perhapsArr) {
        return Flowable.concatArrayDelayError(perhapsArr);
    }

    public static <T> Flowable<T> concatDelayError(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.concatDelayError(iterable);
    }

    public static <T> Perhaps<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        Objects.requireNonNull(maybeOnSubscribe, "onCreate is null");
        return onAssembly(new l1(maybeOnSubscribe));
    }

    public static <T> Perhaps<T> defer(Supplier<? extends Perhaps<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return onAssembly(new n1(supplier));
    }

    public static <T> Perhaps<T> empty() {
        return onAssembly(s1.b);
    }

    public static <T> Perhaps<T> error(Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return onAssembly(new t1(th));
    }

    public static <T> Perhaps<T> fromAction(Action action) {
        Objects.requireNonNull(action, "action is null");
        return onAssembly(new z1(action));
    }

    public static <T> Perhaps<T> fromCallable(Callable<T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return onAssembly(new a2(callable));
    }

    public static <T> Perhaps<T> fromCompletable(CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "source is null");
        return onAssembly(new b2(completableSource));
    }

    public static <T> Perhaps<T> fromFuture(Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return onAssembly(new c2(future, 0, null));
    }

    public static <T> Perhaps<T> fromMaybe(MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "source is null");
        return onAssembly(new d2(maybeSource));
    }

    public static <T> Perhaps<T> fromPublisher(Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "source is null");
        return onAssembly(new e2(publisher));
    }

    public static <T> Perhaps<T> fromSingle(SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return onAssembly(new f2(singleSource));
    }

    public static <T> Function<Perhaps<T>, Perhaps<T>> getOnAssemblyHandler() {
        return a;
    }

    public static <T> Perhaps<T> just(T t) {
        Objects.requireNonNull(t, "item is null");
        return onAssembly(new h2(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends Perhaps<? extends T>> iterable) {
        return Flowable.merge(iterable);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArray(Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArray(perhapsArr);
    }

    @SafeVarargs
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

    public static <T, R> Perhaps<T> using(Supplier<R> supplier, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer) {
        return using(supplier, function, consumer, true);
    }

    public static <T, R> Perhaps<R> zip(Iterable<? extends Perhaps<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "zipper is null");
        return onAssembly(new e3(iterable, function));
    }

    @SafeVarargs
    public static <T, R> Perhaps<R> zipArray(Function<? super Object[], ? extends R> function, Perhaps<? extends T>... perhapsArr) {
        Objects.requireNonNull(perhapsArr, "sources is null");
        Objects.requireNonNull(function, "zipper is null");
        return onAssembly(new d3(perhapsArr, function));
    }

    public final Perhaps<T> ambWith(Perhaps<? extends T> perhaps) {
        return ambArray(this, perhaps);
    }

    public final Perhaps<T> andThen(Nono nono) {
        Objects.requireNonNull(nono, "other is null");
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.rxjava3.functions.Function<? super hu.akarnokd.rxjava3.basetypes.Perhaps<T>, ? extends hu.akarnokd.rxjava3.basetypes.Perhaps<R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Perhaps<R> compose(Function<? super Perhaps<T>, ? extends Perhaps<R>> function) {
        return (Perhaps) to(function);
    }

    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return Flowable.concat(this, publisher);
    }

    public final Perhaps<T> defaultIfEmpty(T t) {
        Objects.requireNonNull(t, "item is null");
        return onAssembly(new m1(this, t));
    }

    public final Perhaps<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    public final Perhaps<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(timer(j, timeUnit));
    }

    public final Perhaps<T> doAfterNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doAfterTerminate(Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Perhaps<T> doFinally(Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return onAssembly(new q1(this, action));
    }

    public final Perhaps<T> doOnCancel(Action action) {
        Objects.requireNonNull(action, "onCancel is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnComplete(Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Perhaps<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    public final Perhaps<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new r1(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return onAssembly(new v1(this, predicate));
    }

    public final <R> Perhaps<R> flatMap(Function<? super T, ? extends Perhaps<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return onAssembly(new w1(this, function));
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new x1(this, function));
    }

    public final Perhaps<T> hide() {
        return onAssembly(new g2(this));
    }

    public final Nono ignoreElement() {
        return Nono.fromPublisher(this);
    }

    public final <R> Perhaps<R> lift(Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        Objects.requireNonNull(function, "onLift is null");
        return onAssembly(new i2(this, function));
    }

    public final <R> Perhaps<R> map(Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return onAssembly(new j2(this, function));
    }

    public final Perhaps<T> mapError(Function<? super Throwable, ? extends Throwable> function) {
        Objects.requireNonNull(function, "errorMapper is null");
        return onAssembly(new k2(this, function));
    }

    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return Flowable.merge(this, publisher);
    }

    public final Perhaps<T> observeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new m2(this, scheduler));
    }

    public final Perhaps<T> onErrorComplete() {
        return onAssembly(new p2(this, null));
    }

    public final Perhaps<T> onErrorResumeNext(Function<? super Throwable, ? extends Perhaps<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return onAssembly(new n2(this, function));
    }

    public final Perhaps<T> onErrorResumeWith(Perhaps<? extends T> perhaps) {
        Objects.requireNonNull(perhaps, "fallback is null");
        return onAssembly(new o2(this, perhaps));
    }

    public final Perhaps<T> onErrorReturnItem(T t) {
        Objects.requireNonNull(t, "item is null");
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
        Objects.requireNonNull(function, "handler is null");
        return onAssembly(new r2(this, function));
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super T> subscriber) {
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

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    public final Perhaps<T> subscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new t2(this, scheduler));
    }

    public final <E extends Subscriber<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Perhaps<T> switchIfEmpty(Perhaps<? extends T> perhaps) {
        Objects.requireNonNull(perhaps, "other is null");
        return onAssembly(new u2(this, perhaps));
    }

    public final Perhaps<T> takeUntil(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
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
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new b3(this, scheduler));
    }

    public final <U, R> Perhaps<R> zipWith(Perhaps<? extends U> perhaps, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(perhaps, "other is null");
        Objects.requireNonNull(biFunction, "zipper is null");
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

    @SafeVarargs
    public static <T> Flowable<T> mergeArray(int i, Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArray(i, 1, perhapsArr);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArrayDelayError(int i, Perhaps<? extends T>... perhapsArr) {
        return Flowable.mergeArrayDelayError(i, 1, perhapsArr);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Perhaps<? extends T>> iterable, int i) {
        return Flowable.mergeDelayError(iterable, i);
    }

    public static Perhaps<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new x2(j, timeUnit, scheduler));
    }

    public static <T, R> Perhaps<T> using(Supplier<R> supplier, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "disposer is null");
        return onAssembly(new c3(supplier, function, consumer, z));
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

    public static <T> Perhaps<T> error(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "errorSupplier is null");
        return onAssembly(new u1(supplier));
    }

    public static <T> Perhaps<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return onAssembly(new c2(future, j, timeUnit));
    }

    public static <T> Flowable<T> merge(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.merge(publisher);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Perhaps<? extends T>> publisher) {
        return Flowable.mergeDelayError(publisher);
    }

    public final Flowable<T> andThen(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return Flowable.concat(this, publisher);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        blockingSubscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    public final Perhaps<T> delay(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new o1(this, publisher));
    }

    public final Perhaps<T> delaySubscription(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new p1(this, publisher));
    }

    public final <R> Perhaps<R> flatMap(Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Supplier<? extends Perhaps<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteMapper is null");
        return onAssembly(new y1(this, function, function2, supplier));
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
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        g gVar = new g();
        subscribe(gVar);
        gVar.a(consumer, consumer2, action);
    }

    public final Perhaps<T> retry(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
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
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new w2(this, publisher, null));
    }

    public final Perhaps<T> timeout(Publisher<?> publisher, Perhaps<? extends T> perhaps) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(perhaps, "fallback is null");
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
