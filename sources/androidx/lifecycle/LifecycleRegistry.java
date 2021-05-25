package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l6.p.d;
public class LifecycleRegistry extends Lifecycle {
    public FastSafeIterableMap<LifecycleObserver, a> b = new FastSafeIterableMap<>();
    public Lifecycle.State c;
    public final WeakReference<LifecycleOwner> d;
    public int e = 0;
    public boolean f = false;
    public boolean g = false;
    public ArrayList<Lifecycle.State> h = new ArrayList<>();

    public static class a {
        public Lifecycle.State a;
        public LifecycleEventObserver b;

        public a(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            LifecycleEventObserver lifecycleEventObserver;
            Map<Class<?>, Integer> map = Lifecycling.a;
            boolean z = lifecycleObserver instanceof LifecycleEventObserver;
            boolean z2 = lifecycleObserver instanceof d;
            if (z && z2) {
                lifecycleEventObserver = new FullLifecycleObserverAdapter((d) lifecycleObserver, (LifecycleEventObserver) lifecycleObserver);
            } else if (z2) {
                lifecycleEventObserver = new FullLifecycleObserverAdapter((d) lifecycleObserver, null);
            } else if (z) {
                lifecycleEventObserver = (LifecycleEventObserver) lifecycleObserver;
            } else {
                Class<?> cls = lifecycleObserver.getClass();
                if (Lifecycling.b(cls) == 2) {
                    List<Constructor<? extends GeneratedAdapter>> list = Lifecycling.b.get(cls);
                    if (list.size() == 1) {
                        lifecycleEventObserver = new SingleGeneratedAdapterObserver(Lifecycling.a(list.get(0), lifecycleObserver));
                    } else {
                        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            generatedAdapterArr[i] = Lifecycling.a(list.get(i), lifecycleObserver);
                        }
                        lifecycleEventObserver = new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
                    }
                } else {
                    lifecycleEventObserver = new ReflectiveGenericLifecycleObserver(lifecycleObserver);
                }
            }
            this.b = lifecycleEventObserver;
            this.a = state;
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State b2 = LifecycleRegistry.b(event);
            this.a = LifecycleRegistry.c(this.a, b2);
            this.b.onStateChanged(lifecycleOwner, event);
            this.a = b2;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this.d = new WeakReference<>(lifecycleOwner);
        this.c = Lifecycle.State.INITIALIZED;
    }

    public static Lifecycle.State b(Lifecycle.Event event) {
        int ordinal = event.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return Lifecycle.State.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return Lifecycle.State.DESTROYED;
                        }
                        throw new IllegalArgumentException("Unexpected event value " + event);
                    }
                }
            }
            return Lifecycle.State.STARTED;
        }
        return Lifecycle.State.CREATED;
    }

    public static Lifecycle.State c(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public static Lifecycle.Event g(Lifecycle.State state) {
        int ordinal = state.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return Lifecycle.Event.ON_CREATE;
        }
        if (ordinal == 2) {
            return Lifecycle.Event.ON_START;
        }
        if (ordinal == 3) {
            return Lifecycle.Event.ON_RESUME;
        }
        if (ordinal != 4) {
            throw new IllegalArgumentException("Unexpected state value " + state);
        }
        throw new IllegalArgumentException();
    }

    public final Lifecycle.State a(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, a> ceil = this.b.ceil(lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State state2 = ceil != null ? ceil.getValue().a : null;
        if (!this.h.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.h;
            state = arrayList.get(arrayList.size() - 1);
        }
        return c(c(this.c, state2), state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Lifecycle.State state = this.c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(lifecycleObserver, state2);
        if (this.b.putIfAbsent(lifecycleObserver, aVar) == null && (lifecycleOwner = this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            Lifecycle.State a3 = a(lifecycleObserver);
            this.e++;
            while (aVar.a.compareTo(a3) < 0 && this.b.contains(lifecycleObserver)) {
                this.h.add(aVar.a);
                aVar.a(lifecycleOwner, g(aVar.a));
                e();
                a3 = a(lifecycleObserver);
            }
            if (!z) {
                f();
            }
            this.e--;
        }
    }

    public final void d(Lifecycle.State state) {
        if (this.c != state) {
            this.c = state;
            if (this.f || this.e != 0) {
                this.g = true;
                return;
            }
            this.f = true;
            f();
            this.f = false;
        }
    }

    public final void e() {
        ArrayList<Lifecycle.State> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        Lifecycle.Event event;
        Lifecycle.State state;
        LifecycleOwner lifecycleOwner = this.d.get();
        if (lifecycleOwner != null) {
            while (true) {
                if (!(this.b.size() == 0 || (this.b.eldest().getValue().a == (state = this.b.newest().getValue().a) && this.c == state))) {
                    this.g = false;
                    if (this.c.compareTo(this.b.eldest().getValue().a) < 0) {
                        Iterator<Map.Entry<LifecycleObserver, a>> descendingIterator = this.b.descendingIterator();
                        while (descendingIterator.hasNext() && !this.g) {
                            Map.Entry<LifecycleObserver, a> next = descendingIterator.next();
                            a value = next.getValue();
                            while (value.a.compareTo(this.c) > 0 && !this.g && this.b.contains(next.getKey())) {
                                Lifecycle.State state2 = value.a;
                                int ordinal = state2.ordinal();
                                if (ordinal == 0) {
                                    throw new IllegalArgumentException();
                                } else if (ordinal != 1) {
                                    if (ordinal == 2) {
                                        event = Lifecycle.Event.ON_DESTROY;
                                    } else if (ordinal == 3) {
                                        event = Lifecycle.Event.ON_STOP;
                                    } else if (ordinal == 4) {
                                        event = Lifecycle.Event.ON_PAUSE;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected state value " + state2);
                                    }
                                    this.h.add(b(event));
                                    value.a(lifecycleOwner, event);
                                    e();
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                    Map.Entry<LifecycleObserver, a> newest = this.b.newest();
                    if (!this.g && newest != null && this.c.compareTo(newest.getValue().a) > 0) {
                        SafeIterableMap<K, V>.d iteratorWithAdditions = this.b.iteratorWithAdditions();
                        while (iteratorWithAdditions.hasNext() && !this.g) {
                            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
                            a aVar = (a) entry.getValue();
                            while (aVar.a.compareTo(this.c) < 0 && !this.g && this.b.contains(entry.getKey())) {
                                this.h.add(aVar.a);
                                aVar.a(lifecycleOwner, g(aVar.a));
                                e();
                            }
                        }
                    }
                } else {
                    this.g = false;
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.c;
    }

    public int getObserverCount() {
        return this.b.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        d(b(event));
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State state) {
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        this.b.remove(lifecycleObserver);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State state) {
        d(state);
    }
}
