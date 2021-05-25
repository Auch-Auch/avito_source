package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public final class SavedStateHandle {
    public static final Class[] d = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final Map<String, Object> a;
    public final Map<String, b<?>> b;
    public final SavedStateRegistry.SavedStateProvider c;

    public class a implements SavedStateRegistry.SavedStateProvider {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NonNull
        public Bundle saveState() {
            Set<String> keySet = SavedStateHandle.this.a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(SavedStateHandle.this.a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList(ResidentialComplexModuleKt.VALUES, arrayList2);
            return bundle;
        }
    }

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new a();
        this.a = new HashMap(map);
    }

    @NonNull
    public final <T> MutableLiveData<T> a(@NonNull String str, boolean z, @Nullable T t) {
        b<?> bVar;
        b<?> bVar2 = this.b.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        if (this.a.containsKey(str)) {
            bVar = new b<>(this, str, this.a.get(str));
        } else if (z) {
            bVar = new b<>(this, str, t);
        } else {
            bVar = new b<>(this, str);
        }
        this.b.put(str, bVar);
        return bVar;
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.a.containsKey(str);
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        return (T) this.a.get(str);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return a(str, false, null);
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        T t = (T) this.a.remove(str);
        b<?> remove = this.b.remove(str);
        if (remove != null) {
            remove.m = null;
        }
        return t;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        if (t != null) {
            for (Class cls : d) {
                if (!cls.isInstance(t)) {
                }
            }
            StringBuilder L = a2.b.a.a.a.L("Can't put value with type ");
            L.append(t.getClass());
            L.append(" into saved state");
            throw new IllegalArgumentException(L.toString());
        }
        b<?> bVar = this.b.get(str);
        if (bVar != null) {
            bVar.setValue(t);
        } else {
            this.a.put(str, t);
        }
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        return a(str, true, t);
    }

    public static class b<T> extends MutableLiveData<T> {
        public String l;
        public SavedStateHandle m;

        public b(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            this.l = str;
            this.m = savedStateHandle;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.m;
            if (savedStateHandle != null) {
                savedStateHandle.a.put(this.l, t);
            }
            super.setValue(t);
        }

        public b(SavedStateHandle savedStateHandle, String str) {
            this.l = str;
            this.m = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.b = new HashMap();
        this.c = new a();
        this.a = new HashMap();
    }
}
