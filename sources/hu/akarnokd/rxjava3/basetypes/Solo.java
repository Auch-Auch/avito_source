package hu.akarnokd.rxjava3.basetypes;

import a2.b.a.a.a;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
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
import r6.a.b.b.a4;
import r6.a.b.b.b4;
import r6.a.b.b.c4;
import r6.a.b.b.d4;
import r6.a.b.b.e4;
import r6.a.b.b.f3;
import r6.a.b.b.f4;
import r6.a.b.b.g;
import r6.a.b.b.g0;
import r6.a.b.b.g3;
import r6.a.b.b.g4;
import r6.a.b.b.h;
import r6.a.b.b.h3;
import r6.a.b.b.h4;
import r6.a.b.b.i3;
import r6.a.b.b.i4;
import r6.a.b.b.j3;
import r6.a.b.b.j4;
import r6.a.b.b.k3;
import r6.a.b.b.k4;
import r6.a.b.b.l3;
import r6.a.b.b.l4;
import r6.a.b.b.m3;
import r6.a.b.b.m4;
import r6.a.b.b.n3;
import r6.a.b.b.n4;
import r6.a.b.b.o3;
import r6.a.b.b.o4;
import r6.a.b.b.p3;
import r6.a.b.b.p4;
import r6.a.b.b.q3;
import r6.a.b.b.q4;
import r6.a.b.b.r3;
import r6.a.b.b.r4;
import r6.a.b.b.s3;
import r6.a.b.b.s4;
import r6.a.b.b.t3;
import r6.a.b.b.t4;
import r6.a.b.b.u3;
import r6.a.b.b.u4;
import r6.a.b.b.v3;
import r6.a.b.b.v4;
import r6.a.b.b.w3;
import r6.a.b.b.w4;
import r6.a.b.b.x3;
import r6.a.b.b.y3;
import r6.a.b.b.z3;
public abstract class Solo<T> implements Publisher<T> {
    public static volatile Function<Solo, Solo> a;

    public static <T> Solo<T> amb(Iterable<? extends Solo<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return onAssembly(new g3(iterable));
    }

    @SafeVarargs
    public static <T> Solo<T> ambArray(Solo<? extends T>... soloArr) {
        Objects.requireNonNull(soloArr, "sources is null");
        return onAssembly(new f3(soloArr));
    }

    public static <T> Flowable<T> concat(Iterable<? extends Solo<? extends T>> iterable) {
        return Flowable.concat(iterable);
    }

    @SafeVarargs
    public static <T> Flowable<T> concatArray(Solo<? extends T>... soloArr) {
        return Flowable.concatArray(soloArr);
    }

    @SafeVarargs
    public static <T> Flowable<T> concatArrayDelayError(Solo<? extends T>... soloArr) {
        return Flowable.concatArrayDelayError(soloArr);
    }

    public static <T> Flowable<T> concatDelayError(Iterable<? extends Solo<? extends T>> iterable) {
        return Flowable.concatDelayError(iterable);
    }

    public static <T> Solo<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        Objects.requireNonNull(singleOnSubscribe, "onCreate is null");
        return onAssembly(new j3(singleOnSubscribe));
    }

    public static <T> Solo<T> defer(Supplier<? extends Solo<T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return onAssembly(new k3(supplier));
    }

    public static <T> Solo<T> error(Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return onAssembly(new p3(th));
    }

    public static <T> Solo<T> fromCallable(Callable<T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return onAssembly(new v3(callable));
    }

    public static <T> Solo<T> fromFuture(Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return onAssembly(new w3(future, 0, null));
    }

    public static <T> Solo<T> fromPublisher(Publisher<T> publisher) {
        if (publisher instanceof Solo) {
            return (Solo) publisher;
        }
        Objects.requireNonNull(publisher, "source is null");
        return onAssembly(new x3(publisher));
    }

    public static <T> Solo<T> fromSingle(SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return onAssembly(new y3(singleSource));
    }

    public static <T> Function<Solo<T>, Solo<T>> getOnAssemblyHandler() {
        return a;
    }

    public static <T> Solo<T> just(T t) {
        Objects.requireNonNull(t, "item is null");
        return onAssembly(new a4(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends Solo<? extends T>> iterable) {
        return merge(iterable, Integer.MAX_VALUE);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArray(Solo<? extends T>... soloArr) {
        return mergeArray(Integer.MAX_VALUE, soloArr);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArrayDelayError(Solo<? extends T>... soloArr) {
        return mergeArrayDelayError(Integer.MAX_VALUE, soloArr);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Solo<? extends T>> iterable) {
        return mergeDelayError(iterable, Integer.MAX_VALUE);
    }

    public static <T> Solo<T> never() {
        return onAssembly(e4.b);
    }

    public static <T> Solo<T> onAssembly(Solo<T> solo) {
        Function<Solo, Solo> function = a;
        if (function == null) {
            return solo;
        }
        try {
            return function.apply(solo);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void setOnAssemblyHandler(Function<Solo<T>, Solo<T>> function) {
        a = function;
    }

    public static Solo<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static <T, R> Solo<T> using(Supplier<R> supplier, Function<? super R, ? extends Solo<T>> function, Consumer<? super R> consumer) {
        return using(supplier, function, consumer, true);
    }

    public static <T, R> Solo<R> zip(Iterable<? extends Solo<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "zipper is null");
        return onAssembly(new w4(iterable, function));
    }

    @SafeVarargs
    public static <T, R> Solo<R> zipArray(Function<? super Object[], ? extends R> function, Solo<? extends T>... soloArr) {
        Objects.requireNonNull(soloArr, "sources is null");
        Objects.requireNonNull(function, "zipper is null");
        return onAssembly(new v4(soloArr, function));
    }

    public final Solo<T> ambWith(Solo<? extends T> solo) {
        return ambArray(this, solo);
    }

    public final Solo<T> andThen(Nono nono) {
        Objects.requireNonNull(nono, "other is null");
        return onAssembly(new h3(this, nono));
    }

    public final T blockingGet() {
        g gVar = new g();
        subscribe(gVar);
        return (T) gVar.b();
    }

    public final void blockingSubscribe() {
        blockingSubscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Solo<T> cache() {
        return onAssembly(new i3(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.rxjava3.functions.Function<? super hu.akarnokd.rxjava3.basetypes.Solo<T>, ? extends hu.akarnokd.rxjava3.basetypes.Solo<R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Solo<R> compose(Function<? super Solo<T>, ? extends Solo<R>> function) {
        return (Solo) to(function);
    }

    public final Flowable<T> concatWith(Solo<T> solo) {
        return Flowable.concat(this, solo);
    }

    public final Solo<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    public final Solo<T> delaySubscription(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new m3(this, publisher));
    }

    public final Solo<T> doAfterNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Solo<T> doAfterTerminate(Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Solo<T> doFinally(Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return onAssembly(new n3(this, action));
    }

    public final Solo<T> doOnCancel(Action action) {
        Objects.requireNonNull(action, "onCancel is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Solo<T> doOnComplete(Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    public final Solo<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Solo<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Solo<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    public final Solo<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return onAssembly(new o3(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    public final Perhaps<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return Perhaps.onAssembly(new r3(this, predicate));
    }

    public final <R> Solo<R> flatMap(Function<? super T, ? extends Solo<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return onAssembly(new s3(this, function));
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new t3(this, function));
    }

    public final Solo<T> hide() {
        return onAssembly(new z3(this));
    }

    public final Nono ignoreElement() {
        return Nono.onAssembly(new g0(this));
    }

    public final <R> Solo<R> lift(Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        Objects.requireNonNull(function, "onLift is null");
        return onAssembly(new b4(this, function));
    }

    public final <R> Solo<R> map(Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return onAssembly(new c4(this, function));
    }

    public final Solo<T> mapError(Function<? super Throwable, ? extends Throwable> function) {
        Objects.requireNonNull(function, "errorMapper is null");
        return onAssembly(new d4(this, function));
    }

    public final Flowable<T> mergeWith(Solo<T> solo) {
        return Flowable.merge(this, solo);
    }

    public final Solo<T> observeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new f4(this, scheduler));
    }

    public final Solo<T> onErrorResumeNext(Function<? super Throwable, ? extends Solo<T>> function) {
        Objects.requireNonNull(function, "errorHandler is null");
        return onAssembly(new g4(this, function));
    }

    public final Solo<T> onErrorResumeWith(Solo<T> solo) {
        Objects.requireNonNull(solo, "next is null");
        return onAssembly(new h4(this, solo));
    }

    public final Solo<T> onErrorReturnItem(T t) {
        Objects.requireNonNull(t, "item is null");
        return onAssembly(new i4(this, t));
    }

    public final Flowable<T> repeat() {
        return Flowable.fromPublisher(this).repeat();
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return Flowable.fromPublisher(this).repeatWhen(function);
    }

    public final Solo<T> retry() {
        return onAssembly(new j4(this, Long.MAX_VALUE));
    }

    public final Solo<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return onAssembly(new k4(this, function));
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

    public final Solo<T> subscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new m4(this, scheduler));
    }

    public final <E extends Subscriber<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Solo<T> takeUntil(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new n4(this, publisher));
    }

    public final TestSubscriber<T> test() {
        return test(Long.MAX_VALUE, false);
    }

    public final Solo<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(timer(j, timeUnit));
    }

    public final <R> R to(Function<? super Solo<T>, R> function) {
        try {
            return function.apply(this);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public final Flowable<T> toFlowable() {
        return RxJavaPlugins.onAssembly(new q4(this));
    }

    public final Future<T> toFuture() {
        h hVar = new h();
        subscribe(hVar);
        return hVar;
    }

    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly(new r4(this));
    }

    public final Single<T> toSingle() {
        return RxJavaPlugins.onAssembly(new s4(this));
    }

    public final Solo<T> unsubscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new t4(this, scheduler));
    }

    public final <U, R> Solo<R> zipWith(Solo<U> solo, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zipArray(Functions.toFunction(biFunction), this, solo);
    }

    public static <T> Flowable<T> concat(Publisher<? extends Solo<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Solo<? extends T>> publisher) {
        return concatDelayError(publisher, 2, true);
    }

    public static <T> Flowable<T> merge(Iterable<? extends Solo<? extends T>> iterable, int i) {
        return Flowable.merge(iterable, i);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArray(int i, Solo<? extends T>... soloArr) {
        return Flowable.mergeArray(i, 1, soloArr);
    }

    @SafeVarargs
    public static <T> Flowable<T> mergeArrayDelayError(int i, Solo<? extends T>... soloArr) {
        return Flowable.mergeArrayDelayError(i, 1, soloArr);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Solo<? extends T>> iterable, int i) {
        return Flowable.mergeDelayError(iterable, i);
    }

    public static Solo<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return onAssembly(new p4(j, timeUnit, scheduler));
    }

    public static <T, R> Solo<T> using(Supplier<R> supplier, Function<? super R, ? extends Solo<T>> function, Consumer<? super R> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "disposer is null");
        return onAssembly(new u4(supplier, function, consumer, z));
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        blockingSubscribe(consumer, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    public final Solo<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return delay(timer(j, timeUnit, scheduler));
    }

    public final Flowable<T> repeat(long j) {
        return Flowable.fromPublisher(this).repeat(j);
    }

    public final Solo<T> retry(long j) {
        if (j >= 0) {
            return onAssembly(new j4(this, j));
        }
        throw new IllegalArgumentException(a.T2("times >= 0 required but it was ", j));
    }

    public final TestSubscriber<T> test(boolean z) {
        return test(Long.MAX_VALUE, z);
    }

    public final Solo<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    public static <T> Flowable<T> concat(Publisher<? extends Solo<? extends T>> publisher, int i) {
        return Flowable.concat(publisher, i);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Solo<? extends T>> publisher, int i) {
        return concatDelayError(publisher, i, true);
    }

    public static <T> Solo<T> error(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "errorSupplier is null");
        return onAssembly(new q3(supplier));
    }

    public static <T> Solo<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return onAssembly(new w3(future, j, timeUnit));
    }

    public static <T> Flowable<T> merge(Publisher<? extends Solo<? extends T>> publisher) {
        return merge(publisher, Integer.MAX_VALUE);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Solo<? extends T>> publisher) {
        return mergeDelayError(publisher, Integer.MAX_VALUE);
    }

    public final Flowable<T> andThen(Publisher<? extends T> publisher) {
        return Flowable.concat(this, publisher);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        blockingSubscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    public final Solo<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(timer(j, timeUnit));
    }

    public final <R> Solo<R> flatMap(Function<? super T, ? extends Solo<? extends R>> function, Function<? super Throwable, ? extends Solo<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        return onAssembly(new u3(this, function, function2));
    }

    public final Flowable<T> repeat(BooleanSupplier booleanSupplier) {
        return Flowable.fromPublisher(this).repeatUntil(booleanSupplier);
    }

    public final TestSubscriber<T> test(long j) {
        return test(j, false);
    }

    public final Solo<T> timeout(long j, TimeUnit timeUnit, Solo<T> solo) {
        return timeout(timer(j, timeUnit), solo);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Solo<? extends T>> publisher, int i, boolean z) {
        return Flowable.concatDelayError(publisher, i, z);
    }

    public static <T> Flowable<T> merge(Publisher<? extends Solo<? extends T>> publisher, int i) {
        return Flowable.merge(publisher, i);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Solo<? extends T>> publisher, int i) {
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

    public final Solo<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final Solo<T> retry(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return onAssembly(new l4(this, predicate));
    }

    public final TestSubscriber<T> test(long j, boolean z) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j);
        if (z) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final Solo<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Solo<T> solo) {
        return timeout(timer(j, timeUnit, scheduler), solo);
    }

    public final Solo<T> delay(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new l3(this, publisher));
    }

    public final Solo<T> timeout(Publisher<?> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return onAssembly(new o4(this, publisher, null));
    }

    public final Solo<T> timeout(Publisher<?> publisher, Solo<T> solo) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(solo, "fallback is null");
        return onAssembly(new o4(this, publisher, solo));
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
