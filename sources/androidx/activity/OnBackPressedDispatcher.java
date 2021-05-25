package androidx.activity;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
public final class OnBackPressedDispatcher {
    @Nullable
    public final Runnable a;
    public final ArrayDeque<OnBackPressedCallback> b;

    public class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, l6.a.a {
        public final Lifecycle a;
        public final OnBackPressedCallback b;
        @Nullable
        public l6.a.a c;

        public LifecycleOnBackPressedCancellable(@NonNull Lifecycle lifecycle, @NonNull OnBackPressedCallback onBackPressedCallback) {
            this.a = lifecycle;
            this.b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // l6.a.a
        public void cancel() {
            this.a.removeObserver(this);
            this.b.b.remove(this);
            l6.a.a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                OnBackPressedCallback onBackPressedCallback = this.b;
                onBackPressedDispatcher.b.add(onBackPressedCallback);
                a aVar = new a(onBackPressedCallback);
                onBackPressedCallback.b.add(aVar);
                this.c = aVar;
            } else if (event == Lifecycle.Event.ON_STOP) {
                l6.a.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    public class a implements l6.a.a {
        public final OnBackPressedCallback a;

        public a(OnBackPressedCallback onBackPressedCallback) {
            this.a = onBackPressedCallback;
        }

        @Override // l6.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.b.remove(this.a);
            this.a.b.remove(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    @MainThread
    public void addCallback(@NonNull OnBackPressedCallback onBackPressedCallback) {
        this.b.add(onBackPressedCallback);
        onBackPressedCallback.b.add(new a(onBackPressedCallback));
    }

    @MainThread
    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    public void onBackPressed() {
        Iterator<OnBackPressedCallback> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this.b = new ArrayDeque<>();
        this.a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.b.add(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
        }
    }
}
