package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public class SchedulerWhen extends Scheduler implements Disposable {
    public static final Disposable e = new g();
    public static final Disposable f = EmptyDisposable.INSTANCE;
    public final Scheduler b;
    public final FlowableProcessor<Flowable<Completable>> c;
    public Disposable d;

    public static final class a implements Function<f, Completable> {
        public final Scheduler.Worker a;

        /* renamed from: io.reactivex.rxjava3.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        public final class C0502a extends Completable {
            public final f a;

            public C0502a(f fVar) {
                this.a = fVar;
            }

            @Override // io.reactivex.rxjava3.core.Completable
            public void subscribeActual(CompletableObserver completableObserver) {
                Disposable disposable;
                completableObserver.onSubscribe(this.a);
                f fVar = this.a;
                Scheduler.Worker worker = a.this.a;
                Disposable disposable2 = (Disposable) fVar.get();
                if (disposable2 != SchedulerWhen.f && disposable2 == (disposable = SchedulerWhen.e)) {
                    Disposable a3 = fVar.a(worker, completableObserver);
                    if (!fVar.compareAndSet(disposable, a3)) {
                        a3.dispose();
                    }
                }
            }
        }

        public a(Scheduler.Worker worker) {
            this.a = worker;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Completable apply(f fVar) throws Throwable {
            return new C0502a(fVar);
        }
    }

    public static class b extends f {
        public final Runnable a;
        public final long b;
        public final TimeUnit c;

        public b(Runnable runnable, long j, TimeUnit timeUnit) {
            this.a = runnable;
            this.b = j;
            this.c = timeUnit;
        }

        @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerWhen.f
        public Disposable a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new d(this.a, completableObserver), this.b, this.c);
        }
    }

    public static class c extends f {
        public final Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerWhen.f
        public Disposable a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new d(this.a, completableObserver));
        }
    }

    public static class d implements Runnable {
        public final CompletableObserver a;
        public final Runnable b;

        public d(Runnable runnable, CompletableObserver completableObserver) {
            this.b = runnable;
            this.a = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.onComplete();
            }
        }
    }

    public static abstract class f extends AtomicReference<Disposable> implements Disposable {
        public f() {
            super(SchedulerWhen.e);
        }

        public abstract Disposable a(Scheduler.Worker worker, CompletableObserver completableObserver);

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            ((Disposable) getAndSet(SchedulerWhen.f)).dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }
    }

    public static final class g implements Disposable {
        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.b = scheduler;
        FlowableProcessor<Flowable<Completable>> serialized = UnicastProcessor.create().toSerialized();
        this.c = serialized;
        try {
            this.d = function.apply(serialized).subscribe();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.b.createWorker();
        FlowableProcessor serialized = UnicastProcessor.create().toSerialized();
        Flowable<Completable> map = serialized.map(new a(createWorker));
        e eVar = new e(serialized, createWorker);
        this.c.onNext(map);
        return eVar;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public static final class e extends Scheduler.Worker {
        public final AtomicBoolean a = new AtomicBoolean();
        public final FlowableProcessor<f> b;
        public final Scheduler.Worker c;

        public e(FlowableProcessor<f> flowableProcessor, Scheduler.Worker worker) {
            this.b = flowableProcessor;
            this.c = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.b.onComplete();
                this.c.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.a.get();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            b bVar = new b(runnable, j, timeUnit);
            this.b.onNext(bVar);
            return bVar;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            c cVar = new c(runnable);
            this.b.onNext(cVar);
            return cVar;
        }
    }
}
