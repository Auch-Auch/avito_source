package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;
public final class Functions {
    public static final Action EMPTY_ACTION = new n();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new p();
    public static final Runnable EMPTY_RUNNABLE = new q();
    public static final Consumer<Throwable> ERROR_CONSUMER = new s();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new f0();
    public static final Consumer<Subscription> REQUEST_MAX = new z();
    public static final Function<Object, Object> a = new w();
    public static final Consumer<Object> b = new o();
    public static final Predicate<Object> c = new k0();
    public static final Predicate<Object> d = new t();
    public static final Supplier<Object> e = new e0();

    public static class BoundedConsumer implements Consumer<Subscription> {
        public final int a;

        public BoundedConsumer(int i) {
            this.a = i;
        }

        public void accept(Subscription subscription) {
            subscription.request((long) this.a);
        }
    }

    public static final class a<T> implements Consumer<T> {
        public final Action a;

        public a(Action action) {
            this.a = action;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T t) throws Throwable {
            this.a.run();
        }
    }

    public enum a0 implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class b<T1, T2, R> implements Function<Object[], R> {
        public final BiFunction<? super T1, ? super T2, ? extends R> a;

        public b(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.a = biFunction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 2) {
                return this.a.apply(objArr2[0], objArr2[1]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 2 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class b0<T> implements Action {
        public final Consumer<? super Notification<T>> a;

        public b0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            this.a.accept(Notification.createOnComplete());
        }
    }

    public static final class c<T1, T2, T3, R> implements Function<Object[], R> {
        public final Function3<T1, T2, T3, R> a;

        public c(Function3<T1, T2, T3, R> function3) {
            this.a = function3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.rxjava3.functions.Function3<T1, T2, T3, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 3) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 3 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class c0<T> implements Consumer<Throwable> {
        public final Consumer<? super Notification<T>> a;

        public c0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            this.a.accept(Notification.createOnError(th));
        }
    }

    public static final class d<T1, T2, T3, T4, R> implements Function<Object[], R> {
        public final Function4<T1, T2, T3, T4, R> a;

        public d(Function4<T1, T2, T3, T4, R> function4) {
            this.a = function4;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.rxjava3.functions.Function4<T1, T2, T3, T4, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 4) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 4 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class d0<T> implements Consumer<T> {
        public final Consumer<? super Notification<T>> a;

        public d0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T t) throws Throwable {
            this.a.accept(Notification.createOnNext(t));
        }
    }

    public static final class e<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        public final Function5<T1, T2, T3, T4, T5, R> a;

        public e(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.a = function5;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.functions.Function5<T1, T2, T3, T4, T5, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 5) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 5 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class e0 implements Supplier<Object> {
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return null;
        }
    }

    public static final class f<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        public final Function6<T1, T2, T3, T4, T5, T6, R> a;

        public f(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.a = function6;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.functions.Function6<T1, T2, T3, T4, T5, T6, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 6) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 6 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class f0 implements Consumer<Throwable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    public static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> a;

        public g(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.a = function7;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 7) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 7 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class g0<T> implements Function<T, Timed<T>> {
        public final TimeUnit a;
        public final Scheduler b;

        public g0(TimeUnit timeUnit, Scheduler scheduler) {
            this.a = timeUnit;
            this.b = scheduler;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            return new Timed(obj, this.b.now(this.a), this.a);
        }
    }

    public static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> a;

        public h(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.a = function8;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 8) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 8 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class h0<K, T> implements BiConsumer<Map<K, T>, T> {
        public final Function<? super T, ? extends K> a;

        public h0(Function<? super T, ? extends K> function) {
            this.a = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public void accept(Object obj, Object obj2) throws Throwable {
            ((Map) obj).put(this.a.apply(obj2), obj2);
        }
    }

    public static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;

        public i(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.a = function9;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr;
            if (objArr2.length == 9) {
                return this.a.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7], objArr2[8]);
            }
            StringBuilder L = a2.b.a.a.a.L("Array of size 9 expected but got ");
            L.append(objArr2.length);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static final class i0<K, V, T> implements BiConsumer<Map<K, V>, T> {
        public final Function<? super T, ? extends V> a;
        public final Function<? super T, ? extends K> b;

        public i0(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.a = function;
            this.b = function2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public void accept(Object obj, Object obj2) throws Throwable {
            ((Map) obj).put(this.b.apply(obj2), this.a.apply(obj2));
        }
    }

    public static final class j<T> implements Supplier<List<T>> {
        public final int a;

        public j(int i) {
            this.a = i;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return new ArrayList(this.a);
        }
    }

    public static final class j0<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        public final Function<? super K, ? extends Collection<? super V>> a;
        public final Function<? super T, ? extends V> b;
        public final Function<? super T, ? extends K> c;

        public j0(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.a = function;
            this.b = function2;
            this.c = function3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public void accept(Object obj, Object obj2) throws Throwable {
            Map map = (Map) obj;
            Object apply = this.c.apply(obj2);
            Collection collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = (Collection) this.a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.b.apply(obj2));
        }
    }

    public static final class k<T> implements Predicate<T> {
        public final BooleanSupplier a;

        public k(BooleanSupplier booleanSupplier) {
            this.a = booleanSupplier;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) throws Throwable {
            return !this.a.getAsBoolean();
        }
    }

    public static final class k0 implements Predicate<Object> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    public static final class l<T, U> implements Function<T, U> {
        public final Class<U> a;

        public l(Class<U> cls) {
            this.a = cls;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public U apply(T t) {
            return this.a.cast(t);
        }
    }

    public static final class m<T, U> implements Predicate<T> {
        public final Class<U> a;

        public m(Class<U> cls) {
            this.a = cls;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) {
            return this.a.isInstance(t);
        }
    }

    public static final class n implements Action {
        @Override // io.reactivex.rxjava3.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class o implements Consumer<Object> {
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class p implements LongConsumer {
        @Override // io.reactivex.rxjava3.functions.LongConsumer
        public void accept(long j) {
        }
    }

    public static final class q implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class r<T> implements Predicate<T> {
        public final T a;

        public r(T t) {
            this.a = t;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) {
            return Objects.equals(t, this.a);
        }
    }

    public static final class s implements Consumer<Throwable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) throws Throwable {
            RxJavaPlugins.onError(th);
        }
    }

    public static final class t implements Predicate<Object> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class u implements Action {
        public final Future<?> a;

        public u(Future<?> future) {
            this.a = future;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Exception {
            this.a.get();
        }
    }

    public enum v implements Supplier<Set<Object>> {
        INSTANCE;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Set<Object> get() throws Throwable {
            return new HashSet();
        }
    }

    public static final class w implements Function<Object, Object> {
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class x<T, U> implements Callable<U>, Supplier<U>, Function<T, U> {
        public final U a;

        public x(U u) {
            this.a = u;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public U apply(T t) {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.a;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public U get() {
            return this.a;
        }
    }

    public static final class y<T> implements Function<List<T>, List<T>> {
        public final Comparator<? super T> a;

        public y(Comparator<? super T> comparator) {
            this.a = comparator;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) throws Throwable {
            List list = (List) obj;
            Collections.sort(list, this.a);
            return list;
        }
    }

    public static final class z implements Consumer<Subscription> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Subscription subscription) throws Throwable {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new a(action);
    }

    @NonNull
    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) d;
    }

    @NonNull
    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) c;
    }

    public static <T> Consumer<T> boundedConsumer(int i2) {
        return new BoundedConsumer(i2);
    }

    @NonNull
    public static <T, U> Function<T, U> castFunction(@NonNull Class<U> cls) {
        return new l(cls);
    }

    public static <T> Supplier<List<T>> createArrayList(int i2) {
        return new j(i2);
    }

    public static <T> Supplier<Set<T>> createHashSet() {
        return v.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) b;
    }

    public static <T> Predicate<T> equalsWith(T t2) {
        return new r(t2);
    }

    @NonNull
    public static Action futureAction(@NonNull Future<?> future) {
        return new u(future);
    }

    @NonNull
    public static <T> Function<T, T> identity() {
        return (Function<T, T>) a;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new m(cls);
    }

    @NonNull
    public static <T> Callable<T> justCallable(@NonNull T t2) {
        return new x(t2);
    }

    @NonNull
    public static <T, U> Function<T, U> justFunction(@NonNull U u2) {
        return new x(u2);
    }

    @NonNull
    public static <T> Supplier<T> justSupplier(@NonNull T t2) {
        return new x(t2);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new y(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return a0.INSTANCE;
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new b0(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new c0(consumer);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new d0(consumer);
    }

    @NonNull
    public static <T> Supplier<T> nullSupplier() {
        return (Supplier<T>) e;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new k(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new g0(timeUnit, scheduler);
    }

    @NonNull
    public static <T1, T2, R> Function<Object[], R> toFunction(@NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return new b(biFunction);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new h0(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new i0(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new j0(function3, function2, function);
    }

    @NonNull
    public static <T1, T2, T3, R> Function<Object[], R> toFunction(@NonNull Function3<T1, T2, T3, R> function3) {
        return new c(function3);
    }

    @NonNull
    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(@NonNull Function4<T1, T2, T3, T4, R> function4) {
        return new d(function4);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(@NonNull Function5<T1, T2, T3, T4, T5, R> function5) {
        return new e(function5);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(@NonNull Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        return new f(function6);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(@NonNull Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        return new g(function7);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(@NonNull Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        return new h(function8);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(@NonNull Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        return new i(function9);
    }
}
