package s6.a.a.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final class a extends Scheduler {
    public final Handler b;
    public final boolean c;

    /* renamed from: s6.a.a.a.a$a  reason: collision with other inner class name */
    public static final class C0677a extends Scheduler.Worker {
        public final Handler a;
        public final boolean b;
        public volatile boolean c;

        public C0677a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // io.reactivex.Scheduler.Worker
        @SuppressLint({"NewApi"})
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.c) {
                return Disposables.disposed();
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            Handler handler = this.a;
            b bVar = new b(handler, onSchedule);
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
            return Disposables.disposed();
        }
    }

    public static final class b implements Runnable, Disposable {
        public final Handler a;
        public final Runnable b;
        public volatile boolean c;

        public b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // io.reactivex.disposables.Disposable
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

    public a(Handler handler, boolean z) {
        this.b = handler;
        this.c = z;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new C0677a(this.b, this.c);
    }

    @Override // io.reactivex.Scheduler
    @SuppressLint({"NewApi"})
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        Handler handler = this.b;
        b bVar = new b(handler, onSchedule);
        Message obtain = Message.obtain(handler, bVar);
        if (this.c) {
            obtain.setAsynchronous(true);
        }
        this.b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return bVar;
    }
}
