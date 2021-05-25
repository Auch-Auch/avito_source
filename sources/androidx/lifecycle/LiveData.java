package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;
public abstract class LiveData<T> {
    public static final Object k = new Object();
    public final Object a;
    public SafeIterableMap<Observer<? super T>, LiveData<T>.c> b;
    public int c;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final Runnable j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements LifecycleEventObserver {
        @NonNull
        public final LifecycleOwner e;

        public LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.e = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.c
        public void b() {
            this.e.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean c(LifecycleOwner lifecycleOwner) {
            return this.e == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return this.e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State currentState = this.e.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.a);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                a(this.e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED));
                state = currentState;
                currentState = this.e.getLifecycle().getCurrentState();
            }
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.setValue(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, Observer<? super T> observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return true;
        }
    }

    public abstract class c {
        public final Observer<? super T> a;
        public boolean b;
        public int c = -1;

        public c(Observer<? super T> observer) {
            this.a = observer;
        }

        public void a(boolean z) {
            if (z != this.b) {
                this.b = z;
                LiveData liveData = LiveData.this;
                int i = z ? 1 : -1;
                int i2 = liveData.c;
                liveData.c = i + i2;
                if (!liveData.d) {
                    liveData.d = true;
                    while (true) {
                        boolean z2 = false;
                        try {
                            int i3 = liveData.c;
                            if (i2 == i3) {
                                break;
                            }
                            boolean z3 = i2 == 0 && i3 > 0;
                            boolean z4 = i2 > 0 && i3 == 0;
                            if (z3) {
                                liveData.onActive();
                            } else if (z4) {
                                liveData.onInactive();
                            }
                            i2 = i3;
                        } finally {
                            liveData.d = z2;
                        }
                    }
                }
                if (this.b) {
                    LiveData.this.c(this);
                }
            }
        }

        public void b() {
        }

        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean d();
    }

    public LiveData(T t) {
        this.a = new Object();
        this.b = new SafeIterableMap<>();
        this.c = 0;
        this.f = k;
        this.j = new a();
        this.e = t;
        this.g = 0;
    }

    public static void a(String str) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(a2.b.a.a.a.e3("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(LiveData<T>.c cVar) {
        if (cVar.b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i2 = cVar.c;
            int i3 = this.g;
            if (i2 < i3) {
                cVar.c = i3;
                cVar.a.onChanged((Object) this.e);
            }
        }
    }

    public void c(@Nullable LiveData<T>.c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar == null) {
                SafeIterableMap<K, V>.d iteratorWithAdditions = this.b.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    b((c) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(cVar);
                cVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    @Nullable
    public T getValue() {
        T t = (T) this.e;
        if (t != k) {
            return t;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        return this.c > 0;
    }

    public boolean hasObservers() {
        return this.b.size() > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        a("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            LiveData<T>.c putIfAbsent = this.b.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        a("observeForever");
        b bVar = new b(this, observer);
        LiveData<T>.c putIfAbsent = this.b.putIfAbsent(observer, bVar);
        if (putIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (putIfAbsent == null) {
            bVar.a(true);
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = t;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.j);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        a("removeObserver");
        LiveData<T>.c remove = this.b.remove(observer);
        if (remove != null) {
            remove.b();
            remove.a(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        a("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.c>> it = this.b.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<? super T>, LiveData<T>.c> next = it.next();
            if (next.getValue().c(lifecycleOwner)) {
                removeObserver(next.getKey());
            }
        }
    }

    @MainThread
    public void setValue(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        c(null);
    }

    public LiveData() {
        this.a = new Object();
        this.b = new SafeIterableMap<>();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }
}
