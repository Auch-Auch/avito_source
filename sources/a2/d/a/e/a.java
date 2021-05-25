package a2.d.a.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
public class a implements Lifecycle {
    public final Set<LifecycleListener> a = Collections.newSetFromMap(new WeakHashMap());
    public boolean b;
    public boolean c;

    public void a() {
        this.c = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.a)) {
            lifecycleListener.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        this.a.add(lifecycleListener);
        if (this.c) {
            lifecycleListener.onDestroy();
        } else if (this.b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void b() {
        this.b = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.a)) {
            lifecycleListener.onStart();
        }
    }

    public void c() {
        this.b = false;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.a)) {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        this.a.remove(lifecycleListener);
    }
}
