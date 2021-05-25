package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
public class ServiceLifecycleDispatcher {
    public final LifecycleRegistry a;
    public final Handler b = new Handler();
    public a c;

    public static class a implements Runnable {
        public final LifecycleRegistry a;
        public final Lifecycle.Event b;
        public boolean c = false;

        public a(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.a = lifecycleRegistry;
            this.b = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c) {
                this.a.handleLifecycleEvent(this.b);
                this.c = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.a = new LifecycleRegistry(lifecycleOwner);
    }

    public final void a(Lifecycle.Event event) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.a, event);
        this.c = aVar2;
        this.b.postAtFrontOfQueue(aVar2);
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.a;
    }

    public void onServicePreSuperOnBind() {
        a(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        a(Lifecycle.Event.ON_START);
    }
}
