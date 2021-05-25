package a2.i.a.a.a.a.a.a.a;

import android.os.Looper;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.PreLollipopNetworkObservingStrategy;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
public class b implements Action {
    public final /* synthetic */ Action a;
    public final /* synthetic */ PreLollipopNetworkObservingStrategy b;

    public class a implements Runnable {
        public final /* synthetic */ Scheduler.Worker a;

        public a(Scheduler.Worker worker) {
            this.a = worker;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.run();
            } catch (Exception e) {
                b.this.b.onError("Could not unregister receiver in UI Thread", e);
            }
            this.a.dispose();
        }
    }

    public b(PreLollipopNetworkObservingStrategy preLollipopNetworkObservingStrategy, Action action) {
        this.b = preLollipopNetworkObservingStrategy;
        this.a = action;
    }

    @Override // io.reactivex.functions.Action
    public void run() throws Exception {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.a.run();
            return;
        }
        Scheduler.Worker createWorker = AndroidSchedulers.mainThread().createWorker();
        createWorker.schedule(new a(createWorker));
    }
}
