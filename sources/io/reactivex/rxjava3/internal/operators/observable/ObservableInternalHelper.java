package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final class ObservableInternalHelper {

    public static final class a<T> implements Supplier<ConnectableObservable<T>> {
        public final Observable<T> a;
        public final int b;
        public final boolean c;

        public a(Observable<T> observable, int i, boolean z) {
            this.a = observable;
            this.b = i;
            this.c = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay(this.b, this.c);
        }
    }

    public static final class b<T> implements Supplier<ConnectableObservable<T>> {
        public final Observable<T> a;
        public final int b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final boolean f;

        public b(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = observable;
            this.b = i;
            this.c = j;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay(this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static final class c<T, U> implements Function<T, ObservableSource<U>> {
        public final Function<? super T, ? extends Iterable<? extends U>> a;

        public c(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.a.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new ObservableFromIterable((Iterable) apply);
        }
    }

    public static final class d<U, R, T> implements Function<U, R> {
        public final BiFunction<? super T, ? super U, ? extends R> a;
        public final T b;

        public d(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.a = biFunction;
            this.b = t;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(U u) throws Throwable {
            return (R) this.a.apply(this.b, u);
        }
    }

    public static final class e<T, R, U> implements Function<T, ObservableSource<R>> {
        public final BiFunction<? super T, ? super U, ? extends R> a;
        public final Function<? super T, ? extends ObservableSource<? extends U>> b;

        public e(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.a = biFunction;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            return new ObservableMap((ObservableSource) apply, new d(this.a, obj));
        }
    }

    public static final class f<T, U> implements Function<T, ObservableSource<T>> {
        public final Function<? super T, ? extends ObservableSource<U>> a;

        public f(Function<? super T, ? extends ObservableSource<U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.a.apply(obj);
            Objects.requireNonNull(apply, "The itemDelay returned a null ObservableSource");
            return new ObservableTake((ObservableSource) apply, 1).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
        }
    }

    public static final class g<T> implements Action {
        public final Observer<T> a;

        public g(Observer<T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() {
            this.a.onComplete();
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final Observer<T> a;

        public h(Observer<T> observer) {
            this.a = observer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            this.a.onError(th);
        }
    }

    public static final class i<T> implements Consumer<T> {
        public final Observer<T> a;

        public i(Observer<T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T t) {
            this.a.onNext(t);
        }
    }

    public static final class j<T> implements Supplier<ConnectableObservable<T>> {
        public final Observable<T> a;

        public j(Observable<T> observable) {
            this.a = observable;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay();
        }
    }

    public static final class k<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final BiConsumer<S, Emitter<T>> a;

        public k(BiConsumer<S, Emitter<T>> biConsumer) {
            this.a = biConsumer;
        }

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) throws Throwable {
            this.a.accept(obj, (Emitter) obj2);
            return obj;
        }
    }

    public static final class l<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Consumer<Emitter<T>> a;

        public l(Consumer<Emitter<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) throws Throwable {
            this.a.accept((Emitter) obj2);
            return obj;
        }
    }

    public static final class m<T> implements Supplier<ConnectableObservable<T>> {
        public final Observable<T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final boolean e;

        public m(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = observable;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay(this.b, this.c, this.d, this.e);
        }
    }

    public ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new c(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new e(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new f(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new g(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new h(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new i(observer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable) {
        return new j(observable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new k(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new l(consumer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i2, boolean z) {
        return new a(observable, i2, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new b(observable, i2, j2, timeUnit, scheduler, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new m(observable, j2, timeUnit, scheduler, z);
    }
}
