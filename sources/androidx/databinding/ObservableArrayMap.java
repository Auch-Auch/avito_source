package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;
import java.util.Iterator;
public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    public transient MapChangeRegistry i;

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.i == null) {
            this.i = new MapChangeRegistry();
        }
        this.i.add(onMapChangedCallback);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        if (!isEmpty()) {
            super.clear();
            h(null);
        }
    }

    public final void h(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.i;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        super.put(k, v);
        MapChangeRegistry mapChangeRegistry = this.i;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, k);
        }
        return v;
    }

    @Override // androidx.collection.ArrayMap
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int indexOfKey = indexOfKey(it.next());
            if (indexOfKey >= 0) {
                z = true;
                removeAt(indexOfKey);
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        K keyAt = keyAt(i2);
        V v = (V) super.removeAt(i2);
        if (v != null) {
            h(keyAt);
        }
        return v;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.i;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // androidx.collection.ArrayMap
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        K keyAt = keyAt(i2);
        V v2 = (V) super.setValueAt(i2, v);
        h(keyAt);
        return v2;
    }
}
