package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
public class ProcessLifecycleOwner implements LifecycleOwner {
    public static final ProcessLifecycleOwner i = new ProcessLifecycleOwner();
    public int a = 0;
    public int b = 0;
    public boolean c = true;
    public boolean d = true;
    public Handler e;
    public final LifecycleRegistry f = new LifecycleRegistry(this);
    public Runnable g = new a();
    public ReportFragment.a h = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            if (processLifecycleOwner.b == 0) {
                processLifecycleOwner.c = true;
                processLifecycleOwner.f.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
            ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
            if (processLifecycleOwner2.a == 0 && processLifecycleOwner2.c) {
                processLifecycleOwner2.f.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                processLifecycleOwner2.d = true;
            }
        }
    }

    public class b implements ReportFragment.a {
        public b() {
        }
    }

    @NonNull
    public static LifecycleOwner get() {
        return i;
    }

    public void a() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 != 1) {
            return;
        }
        if (this.c) {
            this.f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.c = false;
            return;
        }
        this.e.removeCallbacks(this.g);
    }

    public void b() {
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 == 1 && this.d) {
            this.f.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.d = false;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f;
    }
}
