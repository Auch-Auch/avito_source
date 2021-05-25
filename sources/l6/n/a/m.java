package l6.n.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public final class m extends ViewModel {
    public static final ViewModelProvider.Factory i = new a();
    public final HashMap<String, Fragment> c = new HashMap<>();
    public final HashMap<String, m> d = new HashMap<>();
    public final HashMap<String, ViewModelStore> e = new HashMap<>();
    public final boolean f;
    public boolean g = false;
    public boolean h = false;

    public static class a implements ViewModelProvider.Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new m(true);
        }
    }

    public m(boolean z) {
        this.f = z;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig c() {
        if (this.c.isEmpty() && this.d.isEmpty() && this.e.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, m> entry : this.d.entrySet()) {
            FragmentManagerNonConfig c2 = entry.getValue().c();
            if (c2 != null) {
                hashMap.put(entry.getKey(), c2);
            }
        }
        this.h = true;
        if (!this.c.isEmpty() || !hashMap.isEmpty() || !this.e.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.c.values()), hashMap, new HashMap(this.e));
        }
        return null;
    }

    @Deprecated
    public void d(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.c.clear();
        this.d.clear();
        this.e.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> collection = fragmentManagerNonConfig.a;
            if (collection != null) {
                for (Fragment fragment : collection) {
                    if (fragment != null) {
                        this.c.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> map = fragmentManagerNonConfig.b;
            if (map != null) {
                for (Map.Entry<String, FragmentManagerNonConfig> entry : map.entrySet()) {
                    m mVar = new m(this.f);
                    mVar.d(entry.getValue());
                    this.d.put(entry.getKey(), mVar);
                }
            }
            Map<String, ViewModelStore> map2 = fragmentManagerNonConfig.c;
            if (map2 != null) {
                this.e.putAll(map2);
            }
        }
        this.h = false;
    }

    public boolean e(@NonNull Fragment fragment) {
        if (!this.c.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f) {
            return this.g;
        }
        return !this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (!this.c.equals(mVar.c) || !this.d.equals(mVar.d) || !this.e.equals(mVar.e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.d.hashCode();
        return this.e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (FragmentManager.L(3)) {
            String str = "onCleared called for " + this;
        }
        this.g = true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
