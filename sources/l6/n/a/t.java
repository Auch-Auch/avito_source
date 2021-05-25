package l6.n.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
public final class t implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ FragmentTransitionImpl b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ Object h;

    public t(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.a = obj;
        this.b = fragmentTransitionImpl;
        this.c = view;
        this.d = fragment;
        this.e = arrayList;
        this.f = arrayList2;
        this.g = arrayList3;
        this.h = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.a;
        if (obj != null) {
            this.b.removeTarget(obj, this.c);
            this.f.addAll(w.h(this.b, this.a, this.d, this.e, this.c));
        }
        if (this.g != null) {
            if (this.h != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.c);
                this.b.replaceTargets(this.h, this.g, arrayList);
            }
            this.g.clear();
            this.g.add(this.c);
        }
    }
}
