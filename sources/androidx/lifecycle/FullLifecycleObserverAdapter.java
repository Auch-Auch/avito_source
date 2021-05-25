package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import l6.p.d;
public class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    public final d a;
    public final LifecycleEventObserver b;

    public FullLifecycleObserverAdapter(d dVar, LifecycleEventObserver lifecycleEventObserver) {
        this.a = dVar;
        this.b = lifecycleEventObserver;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (event.ordinal()) {
            case 0:
                this.a.onCreate(lifecycleOwner);
                break;
            case 1:
                this.a.onStart(lifecycleOwner);
                break;
            case 2:
                this.a.onResume(lifecycleOwner);
                break;
            case 3:
                this.a.onPause(lifecycleOwner);
                break;
            case 4:
                this.a.onStop(lifecycleOwner);
                break;
            case 5:
                this.a.onDestroy(lifecycleOwner);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver lifecycleEventObserver = this.b;
        if (lifecycleEventObserver != null) {
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
        }
    }
}
