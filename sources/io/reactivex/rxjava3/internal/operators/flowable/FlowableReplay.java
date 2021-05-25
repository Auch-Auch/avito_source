package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    public static final Supplier f = new b();
    public final Flowable<T> b;
    public final AtomicReference<i<T>> c;
    public final Supplier<? extends f<T>> d;
    public final Publisher<T> e;

    public static abstract class a<T> extends AtomicReference<e> implements f<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public final boolean a;
        public e b;
        public int c;
        public long d;

        public a(boolean z) {
            this.a = z;
            e eVar = new e(null, 0);
            this.b = eVar;
            set(eVar);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public final void a(c<T> cVar) {
            int i;
            synchronized (cVar) {
                if (cVar.e) {
                    cVar.f = true;
                    return;
                }
                cVar.e = true;
            }
            while (true) {
                long j = cVar.get();
                boolean z = j == Long.MAX_VALUE;
                e eVar = (e) cVar.c;
                if (eVar == null) {
                    eVar = d();
                    cVar.c = eVar;
                    BackpressureHelper.add(cVar.d, eVar.b);
                }
                long j2 = 0;
                while (true) {
                    i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i != 0) {
                        if (!cVar.isDisposed()) {
                            e eVar2 = (e) eVar.get();
                            if (eVar2 == null) {
                                break;
                            }
                            Object e = e(eVar2.a);
                            try {
                                if (NotificationLite.accept(e, cVar.b)) {
                                    cVar.c = null;
                                    return;
                                }
                                j2++;
                                j--;
                                eVar = eVar2;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                cVar.c = null;
                                cVar.dispose();
                                if (NotificationLite.isError(e) || NotificationLite.isComplete(e)) {
                                    RxJavaPlugins.onError(th);
                                    return;
                                } else {
                                    cVar.b.onError(th);
                                    return;
                                }
                            }
                        } else {
                            cVar.c = null;
                            return;
                        }
                    } else {
                        break;
                    }
                }
                if (i != 0 || !cVar.isDisposed()) {
                    if (j2 != 0) {
                        cVar.c = eVar;
                        if (!z) {
                            BackpressureHelper.producedCancel(cVar, j2);
                        }
                    }
                    synchronized (cVar) {
                        if (!cVar.f) {
                            cVar.e = false;
                            return;
                        }
                        cVar.f = false;
                    }
                } else {
                    cVar.c = null;
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public final void b(Throwable th) {
            Object c2 = c(NotificationLite.error(th), true);
            long j = this.d + 1;
            this.d = j;
            e eVar = new e(c2, j);
            this.b.set(eVar);
            this.b = eVar;
            this.c++;
            i();
        }

        public Object c(Object obj, boolean z) {
            return obj;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public final void complete() {
            Object c2 = c(NotificationLite.complete(), true);
            long j = this.d + 1;
            this.d = j;
            e eVar = new e(c2, j);
            this.b.set(eVar);
            this.b = eVar;
            this.c++;
            i();
        }

        public e d() {
            return (e) get();
        }

        public Object e(Object obj) {
            return obj;
        }

        public final void f(e eVar) {
            if (this.a) {
                e eVar2 = new e(null, eVar.b);
                eVar2.lazySet(eVar.get());
                eVar = eVar2;
            }
            set(eVar);
        }

        public abstract void h();

        public void i() {
            e eVar = (e) get();
            if (eVar.a != null) {
                e eVar2 = new e(null, 0);
                eVar2.lazySet(eVar.get());
                set(eVar2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public final void next(T t) {
            Object c2 = c(NotificationLite.next(t), false);
            long j = this.d + 1;
            this.d = j;
            e eVar = new e(c2, j);
            this.b.set(eVar);
            this.b = eVar;
            this.c++;
            h();
        }
    }

    public static final class b implements Supplier<Object> {
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return new m(16);
        }
    }

    public static final class c<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;
        public final i<T> a;
        public final Subscriber<? super T> b;
        public Object c;
        public final AtomicLong d = new AtomicLong();
        public boolean e;
        public boolean f;

        public c(i<T> iVar, Subscriber<? super T> subscriber) {
            this.a = iVar;
            this.b = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.a.b(this);
                this.a.a();
                this.c = null;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.addCancel(this, j) != Long.MIN_VALUE) {
                BackpressureHelper.add(this.d, j);
                this.a.a();
                this.a.a.a(this);
            }
        }
    }

    public static final class d<R, U> extends Flowable<R> {
        public final Supplier<? extends ConnectableFlowable<U>> b;
        public final Function<? super Flowable<U>, ? extends Publisher<R>> c;

        public final class a implements Consumer<Disposable> {
            public final SubscriberResourceWrapper<R> a;

            public a(d dVar, SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.a = subscriberResourceWrapper;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Disposable disposable) throws Throwable {
                this.a.setResource(disposable);
            }
        }

        public d(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.b = supplier;
            this.c = function;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(this.b.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.nullCheck(this.c.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new a(this, subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    public static final class e extends AtomicReference<e> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object a;
        public final long b;

        public e(Object obj, long j) {
            this.a = obj;
            this.b = j;
        }
    }

    public interface f<T> {
        void a(c<T> cVar);

        void b(Throwable th);

        void complete();

        void next(T t);
    }

    public static final class g<T> implements Supplier<f<T>> {
        public final int a;
        public final boolean b;

        public g(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return new l(this.a, this.b);
        }
    }

    public static final class h<T> implements Publisher<T> {
        public final AtomicReference<i<T>> a;
        public final Supplier<? extends f<T>> b;

        public h(AtomicReference<i<T>> atomicReference, Supplier<? extends f<T>> supplier) {
            this.a = atomicReference;
            this.b = supplier;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            i<T> iVar;
            c<T>[] cVarArr;
            c<T>[] cVarArr2;
            while (true) {
                iVar = this.a.get();
                if (iVar != null) {
                    break;
                }
                try {
                    i<T> iVar2 = new i<>((f) this.b.get(), this.a);
                    if (this.a.compareAndSet(null, iVar2)) {
                        iVar = iVar2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            }
            c<T> cVar = new c<>(iVar, subscriber);
            subscriber.onSubscribe(cVar);
            do {
                cVarArr = iVar.c.get();
                if (cVarArr == i.i) {
                    break;
                }
                int length = cVarArr.length;
                cVarArr2 = new c[(length + 1)];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!iVar.c.compareAndSet(cVarArr, cVarArr2));
            if (cVar.isDisposed()) {
                iVar.b(cVar);
                return;
            }
            iVar.a();
            iVar.a.a(cVar);
        }
    }

    public static final class i<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        public static final c[] h = new c[0];
        public static final c[] i = new c[0];
        private static final long serialVersionUID = 7224554242710036740L;
        public final f<T> a;
        public boolean b;
        public final AtomicReference<c<T>[]> c = new AtomicReference<>(h);
        public final AtomicBoolean d = new AtomicBoolean();
        public final AtomicInteger e = new AtomicInteger();
        public long f;
        public final AtomicReference<i<T>> g;

        public i(f<T> fVar, AtomicReference<i<T>> atomicReference) {
            this.a = fVar;
            this.g = atomicReference;
        }

        public void a() {
            AtomicInteger atomicInteger = this.e;
            if (atomicInteger.getAndIncrement() == 0) {
                int i2 = 1;
                while (!isDisposed()) {
                    Subscription subscription = (Subscription) get();
                    if (subscription != null) {
                        long j = this.f;
                        long j2 = j;
                        for (c<T> cVar : this.c.get()) {
                            j2 = Math.max(j2, cVar.d.get());
                        }
                        long j3 = j2 - j;
                        if (j3 != 0) {
                            this.f = j2;
                            subscription.request(j3);
                        }
                    }
                    i2 = atomicInteger.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void b(c<T> cVar) {
            c<T>[] cVarArr;
            c<T>[] cVarArr2;
            do {
                cVarArr = this.c.get();
                int length = cVarArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (cVarArr[i2].equals(cVar)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            cVarArr2 = h;
                        } else {
                            c<T>[] cVarArr3 = new c[(length - 1)];
                            System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                            System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                            cVarArr2 = cVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.c.compareAndSet(cVarArr, cVarArr2));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c.set(i);
            this.g.compareAndSet(this, null);
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.b) {
                this.b = true;
                this.a.complete();
                for (c<T> cVar : this.c.getAndSet(i)) {
                    this.a.a(cVar);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.b) {
                this.b = true;
                this.a.b(th);
                for (c<T> cVar : this.c.getAndSet(i)) {
                    this.a.a(cVar);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.b) {
                this.a.next(t);
                for (c<T> cVar : this.c.get()) {
                    this.a.a(cVar);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                a();
                for (c<T> cVar : this.c.get()) {
                    this.a.a(cVar);
                }
            }
        }
    }

    public static final class j<T> implements Supplier<f<T>> {
        public final int a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final boolean e;

        public j(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = i;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = z;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() throws Throwable {
            return new k(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public static final class k<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final Scheduler e;
        public final long f;
        public final TimeUnit g;
        public final int h;

        public k(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            super(z);
            this.e = scheduler;
            this.h = i;
            this.f = j;
            this.g = timeUnit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public Object c(Object obj, boolean z) {
            return new Timed(obj, z ? Long.MAX_VALUE : this.e.now(this.g), this.g);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public e d() {
            long now = this.e.now(this.g) - this.f;
            e eVar = (e) get();
            Object obj = eVar.get();
            while (true) {
                eVar = (e) obj;
                if (eVar != null) {
                    Timed timed = (Timed) eVar.a;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    obj = eVar.get();
                } else {
                    break;
                }
            }
            return eVar;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public Object e(Object obj) {
            return ((Timed) obj).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public void h() {
            long now = this.e.now(this.g) - this.f;
            e eVar = (e) get();
            e eVar2 = (e) eVar.get();
            int i = 0;
            while (true) {
                eVar = eVar2;
                int i2 = this.c;
                if (i2 > 1) {
                    if (i2 <= this.h) {
                        if (((Timed) eVar.a).time() > now) {
                            break;
                        }
                        i++;
                        this.c--;
                        eVar2 = (e) eVar.get();
                    } else {
                        i++;
                        this.c = i2 - 1;
                        eVar2 = (e) eVar.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                f(eVar);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public void i() {
            long now = this.e.now(this.g) - this.f;
            e eVar = (e) get();
            e eVar2 = (e) eVar.get();
            int i = 0;
            while (true) {
                eVar = eVar2;
                if (this.c <= 1 || ((Timed) eVar.a).time() > now) {
                    break;
                }
                i++;
                this.c--;
                eVar2 = (e) eVar.get();
            }
            if (i != 0) {
                f(eVar);
            }
        }
    }

    public static final class l<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int e;

        public l(int i, boolean z) {
            super(z);
            this.e = i;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.a
        public void h() {
            if (this.c > this.e) {
                e eVar = (e) ((e) get()).get();
                if (eVar != null) {
                    this.c--;
                    f(eVar);
                    return;
                }
                throw new IllegalStateException("Empty list!");
            }
        }
    }

    public static final class m<T> extends ArrayList<Object> implements f<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int a;

        public m(int i) {
            super(i);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public void a(c<T> cVar) {
            synchronized (cVar) {
                if (cVar.e) {
                    cVar.f = true;
                    return;
                }
                cVar.e = true;
            }
            Subscriber<? super T> subscriber = cVar.b;
            while (!cVar.isDisposed()) {
                int i = this.a;
                Integer num = (Integer) cVar.c;
                int intValue = num != null ? num.intValue() : 0;
                long j = cVar.get();
                long j2 = j;
                long j3 = 0;
                while (j2 != 0 && intValue < i) {
                    Object obj = get(intValue);
                    try {
                        if (!NotificationLite.accept(obj, subscriber) && !cVar.isDisposed()) {
                            intValue++;
                            j2--;
                            j3++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cVar.dispose();
                        if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                            RxJavaPlugins.onError(th);
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    cVar.c = Integer.valueOf(intValue);
                    if (j != Long.MAX_VALUE) {
                        BackpressureHelper.producedCancel(cVar, j3);
                    }
                }
                synchronized (cVar) {
                    if (!cVar.f) {
                        cVar.e = false;
                        return;
                    }
                    cVar.f = false;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public void b(Throwable th) {
            add(NotificationLite.error(th));
            this.a++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public void complete() {
            add(NotificationLite.complete());
            this.a++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.f
        public void next(T t) {
            add(NotificationLite.next(t));
            this.a++;
        }
    }

    public FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<i<T>> atomicReference, Supplier<? extends f<T>> supplier) {
        this.e = publisher;
        this.b = flowable;
        this.c = atomicReference;
        this.d = supplier;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i2, boolean z) {
        if (i2 == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return f(flowable, new g(i2, z));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return f(flowable, f);
    }

    public static <T> ConnectableFlowable<T> f(Flowable<T> flowable, Supplier<? extends f<T>> supplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new h(atomicReference, supplier), flowable, atomicReference, supplier));
    }

    public static <U, R> Flowable<R> multicastSelector(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new d(supplier, function);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        i<T> iVar;
        while (true) {
            iVar = this.c.get();
            if (iVar != null && !iVar.isDisposed()) {
                break;
            }
            try {
                i<T> iVar2 = new i<>((f) this.d.get(), this.c);
                if (this.c.compareAndSet(iVar, iVar2)) {
                    iVar = iVar2;
                    break;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !iVar.d.get() && iVar.d.compareAndSet(false, true);
        try {
            consumer.accept(iVar);
            if (z) {
                this.b.subscribe((FlowableSubscriber) iVar);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            if (z) {
                iVar.d.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        i<T> iVar = this.c.get();
        if (iVar != null && iVar.isDisposed()) {
            this.c.compareAndSet(iVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.e.subscribe(subscriber);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return create(flowable, j2, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        return f(flowable, new j(i2, j2, timeUnit, scheduler, z));
    }
}
