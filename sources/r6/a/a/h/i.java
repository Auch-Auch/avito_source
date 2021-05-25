package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import r6.a.a.h.j;
public final class i<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Scheduler g;

    public static final class a<T, R> extends j.a<T, R> implements Runnable {
        private static final long serialVersionUID = -5109342841608286301L;
        public final Scheduler.Worker p;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z, Scheduler.Worker worker) {
            super(subscriber, function, i, i2, z);
            this.p = worker;
        }

        @Override // r6.a.a.h.j.c
        public void a(j.b<T, R> bVar, R r) {
            bVar.b().offer(r);
            drain();
        }

        @Override // r6.a.a.h.j.c
        public void b(j.b<T, R> bVar, Throwable th) {
            i(bVar);
            if (this.h.addThrowable(th)) {
                bVar.g = true;
                this.k = true;
                this.m.cancel();
                e();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // r6.a.a.h.j.c
        public void c(j.b<T, R> bVar) {
            bVar.g = true;
            drain();
        }

        @Override // r6.a.a.h.j.c
        public void drain() {
            if (getAndIncrement() == 0) {
                this.p.schedule(this);
            }
        }

        @Override // r6.a.a.h.j.a
        public void f() {
            this.p.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.i) {
                h();
            } else {
                d();
            }
        }
    }

    public i(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z, Scheduler scheduler) {
        this.b = publisher;
        this.c = function;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = scheduler;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new i(flowable, this.c, this.d, this.e, this.f, this.g);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e, this.f, this.g.createWorker()));
    }
}
