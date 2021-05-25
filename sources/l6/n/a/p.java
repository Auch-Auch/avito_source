package l6.n.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
public class p {
    public final ArrayList<Fragment> a = new ArrayList<>();
    public final HashMap<String, o> b = new HashMap<>();

    public void a(@NonNull Fragment fragment) {
        if (!this.a.contains(fragment)) {
            synchronized (this.a) {
                this.a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(@NonNull String str) {
        return this.b.containsKey(str);
    }

    public void d(int i) {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            o oVar = this.b.get(it.next().mWho);
            if (oVar != null) {
                oVar.c = i;
            }
        }
        for (o oVar2 : this.b.values()) {
            if (oVar2 != null) {
                oVar2.c = i;
            }
        }
    }

    @Nullable
    public Fragment e(@NonNull String str) {
        o oVar = this.b.get(str);
        if (oVar != null) {
            return oVar.b;
        }
        return null;
    }

    @NonNull
    public List<Fragment> f() {
        ArrayList arrayList = new ArrayList();
        for (o oVar : this.b.values()) {
            if (oVar != null) {
                arrayList.add(oVar.b);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @NonNull
    public List<Fragment> g() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public void h(@NonNull Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.mAdded = false;
    }
}
