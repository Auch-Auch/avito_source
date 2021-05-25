package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableInternalHelper {

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static final class a<T> implements Supplier<ConnectableFlowable<T>> {
        public final Flowable<T> a;
        public final int b;
        public final boolean c;

        public a(Flowable<T> flowable, int i, boolean z) {
            this.a = flowable;
            this.b = i;
            this.c = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay(this.b, this.c);
        }
    }

    public static final class b<T> implements Supplier<ConnectableFlowable<T>> {
        public final Flowable<T> a;
        public final int b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final boolean f;

        public b(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = flowable;
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

    public static final class c<T, U> implements Function<T, Publisher<U>> {
        public final Function<? super T, ? extends Iterable<? extends U>> a;

        public c(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.a.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new FlowableFromIterable((Iterable) apply);
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

    public static final class e<T, R, U> implements Function<T, Publisher<R>> {
        public final BiFunction<? super T, ? super U, ? extends R> a;
        public final Function<? super T, ? extends Publisher<? extends U>> b;

        public e(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.a = biFunction;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            return new FlowableMapPublisher((Publisher) apply, new d(this.a, obj));
        }
    }

    public static final class f<T, U> implements Function<T, Publisher<T>> {
        public final Function<? super T, ? extends Publisher<U>> a;

        public f(Function<? super T, ? extends Publisher<U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            Object apply = this.a.apply(obj);
            Objects.requireNonNull(apply, "The itemDelay returned a null Publisher");
            return new FlowableTakePublisher((Publisher) apply, 1).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
        }
    }

    public static final class g<T> implements Supplier<ConnectableFlowable<T>> {
        public final Flowable<T> a;

        public g(Flowable<T> flowable) {
            this.a = flowable;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return this.a.replay();
        }
    }

    public static final class h<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final BiConsumer<S, Emitter<T>> a;

        public h(BiConsumer<S, Emitter<T>> biConsumer) {
            this.a = biConsumer;
        }

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) throws Throwable {
            this.a.accept(obj, (Emitter) obj2);
            return obj;
        }
    }

    public static final class i<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Consumer<Emitter<T>> a;

        public i(Consumer<Emitter<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) throws Throwable {
            this.a.accept((Emitter) obj2);
            return obj;
        }
    }

    public static final class j<T> implements Action {
        public final Subscriber<T> a;

        public j(Subscriber<T> subscriber) {
            this.a = subscriber;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() {
            this.a.onComplete();
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final Subscriber<T> a;

        public k(Subscriber<T> subscriber) {
            this.a = subscriber;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            this.a.onError(th);
        }
    }

    public static final class l<T> implements Consumer<T> {
        public final Subscriber<T> a;

        public l(Subscriber<T> subscriber) {
            this.a = subscriber;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T t) {
            this.a.onNext(t);
        }
    }

    public static final class m<T> implements Supplier<ConnectableFlowable<T>> {
        public final Flowable<T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final boolean e;

        public m(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = flowable;
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

    public FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new c(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new e(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new f(function);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable) {
        return new g(flowable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new h(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new i(consumer);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new j(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new k(subscriber);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new l(subscriber);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i2, boolean z) {
        return new a(flowable, i2, z);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new b(flowable, i2, j2, timeUnit, scheduler, z);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new m(flowable, j2, timeUnit, scheduler, z);
    }
}
