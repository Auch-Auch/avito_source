package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
public class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    public final GeneratedAdapter a;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.a = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.a.callMethods(lifecycleOwner, event, false, null);
        this.a.callMethods(lifecycleOwner, event, true, null);
    }
}
