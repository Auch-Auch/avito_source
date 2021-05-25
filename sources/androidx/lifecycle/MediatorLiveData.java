package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
public class MediatorLiveData<T> extends MutableLiveData<T> {
    public SafeIterableMap<LiveData<?>, a<?>> l = new SafeIterableMap<>();

    public static class a<V> implements Observer<V> {
        public final LiveData<V> a;
        public final Observer<? super V> b;
        public int c = -1;

        public a(LiveData<V> liveData, Observer<? super V> observer) {
            this.a = liveData;
            this.b = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V v) {
            int i = this.c;
            int i2 = this.a.g;
            if (i != i2) {
                this.c = i2;
                this.b.onChanged(v);
            }
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        a<?> aVar = new a<>(liveData, observer);
        a<?> putIfAbsent = this.l.putIfAbsent(liveData, aVar);
        if (putIfAbsent != null && putIfAbsent.b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (putIfAbsent == null && hasActiveObservers()) {
            aVar.a.observeForever(aVar);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.l.iterator();
        while (it.hasNext()) {
            a<?> value = it.next().getValue();
            value.a.observeForever(value);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.l.iterator();
        while (it.hasNext()) {
            a<?> value = it.next().getValue();
            value.a.removeObserver(value);
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        a<?> remove = this.l.remove(liveData);
        if (remove != null) {
            remove.a.removeObserver(remove);
        }
    }
}
