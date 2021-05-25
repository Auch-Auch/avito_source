package s6.a.e.a.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final class b extends Scheduler {
    public final Handler b;
    public final boolean c;

    public static final class a extends Scheduler.Worker {
        public final Handler a;
        public final boolean b;
        public volatile boolean c;

        public a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @SuppressLint({"NewApi"})
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.c) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            Handler handler = this.a;
            RunnableC0678b bVar = new RunnableC0678b(handler, onSchedule);
            Message obtain = Message.obtain(handler, bVar);
            obtain.obj = this;
            if (this.b) {
                obtain.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (!this.c) {
                return bVar;
            }
            this.a.removeCallbacks(bVar);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: s6.a.e.a.b.b$b  reason: collision with other inner class name */
    public static final class RunnableC0678b implements Runnable, Disposable {
        public final Handler a;
        public final Runnable b;
        public volatile boolean c;

        public RunnableC0678b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    public b(Handler handler, boolean z) {
        this.b = handler;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new a(this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @SuppressLint({"NewApi"})
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        Handler handler = this.b;
        RunnableC0678b bVar = new RunnableC0678b(handler, onSchedule);
        Message obtain = Message.obtain(handler, bVar);
        if (this.c) {
            obtain.setAsynchronous(true);
        }
        this.b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return bVar;
    }
}
