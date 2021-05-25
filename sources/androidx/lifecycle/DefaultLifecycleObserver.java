package androidx.lifecycle;

import androidx.annotation.NonNull;
import l6.p.d;
public interface DefaultLifecycleObserver extends d {
    @Override // l6.p.d
    void onCreate(@NonNull LifecycleOwner lifecycleOwner);

    @Override // l6.p.d
    void onDestroy(@NonNull LifecycleOwner lifecycleOwner);

    @Override // l6.p.d
    void onPause(@NonNull LifecycleOwner lifecycleOwner);

    @Override // l6.p.d
    void onResume(@NonNull LifecycleOwner lifecycleOwner);

    @Override // l6.p.d
    void onStart(@NonNull LifecycleOwner lifecycleOwner);

    @Override // l6.p.d
    void onStop(@NonNull LifecycleOwner lifecycleOwner);
}
