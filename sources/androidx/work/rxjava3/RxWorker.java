package androidx.work.rxjava3;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Executor;
public abstract class RxWorker extends ListenableWorker {
    public static final Executor g = new SynchronousExecutor();
    @Nullable
    public a<ListenableWorker.Result> f;

    public static class a<T> implements SingleObserver<T>, Runnable {
        public final SettableFuture<T> a;
        @Nullable
        public Disposable b;

        public a() {
            SettableFuture<T> create = SettableFuture.create();
            this.a = create;
            create.addListener(this, RxWorker.g);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.a.setException(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.b = disposable;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.a.set(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable;
            if (this.a.isCancelled() && (disposable = this.b) != null) {
                disposable.dispose();
            }
        }
    }

    public RxWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    @MainThread
    public abstract Single<ListenableWorker.Result> createWork();

    @NonNull
    public Scheduler getBackgroundScheduler() {
        return Schedulers.from(getBackgroundExecutor(), true, true);
    }

    @Override // androidx.work.ListenableWorker
    @CallSuper
    public void onStopped() {
        super.onStopped();
        a<ListenableWorker.Result> aVar = this.f;
        if (aVar != null) {
            Disposable disposable = aVar.b;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f = null;
        }
    }

    @NonNull
    public final Completable setCompletableProgress(@NonNull Data data) {
        return Completable.fromFuture(setProgressAsync(data));
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.f = new a<>();
        createWork().subscribeOn(getBackgroundScheduler()).observeOn(Schedulers.from(getTaskExecutor().getBackgroundExecutor(), true, true)).subscribe(this.f);
        return this.f.a;
    }
}
