package androidx.work;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.setException(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.b = disposable;
        }

        @Override // io.reactivex.SingleObserver
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
        return Schedulers.from(getBackgroundExecutor());
    }

    @Override // androidx.work.ListenableWorker
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

    @NonNull
    @Deprecated
    public final Single<Void> setProgress(@NonNull Data data) {
        return Single.fromFuture(setProgressAsync(data));
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.f = new a<>();
        createWork().subscribeOn(getBackgroundScheduler()).observeOn(Schedulers.from(getTaskExecutor().getBackgroundExecutor())).subscribe(this.f);
        return this.f.a;
    }
}
