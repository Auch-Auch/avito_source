package l6.n.a;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
public class b0 implements LifecycleOwner {
    public LifecycleRegistry a = null;

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        if (this.a == null) {
            this.a = new LifecycleRegistry(this);
        }
        return this.a;
    }
}
